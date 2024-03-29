package android.arch.lifecycle;

import android.arch.core.internal.FastSafeIterableMap;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
    private static final String LOG_TAG = "LifecycleRegistry";
    private int mAddingObserverCounter = 0;
    private boolean mHandlingEvent = false;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred = false;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap = new FastSafeIterableMap<>();
    private ArrayList<State> mParentStates = new ArrayList<>();
    private State mState;

    /* renamed from: android.arch.lifecycle.LifecycleRegistry$1 */
    static /* synthetic */ class C00081 {
        static final /* synthetic */ int[] $SwitchMap$android$arch$lifecycle$Lifecycle$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$State[State.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$State[State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$State[State.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$State[State.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$State[State.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $SwitchMap$android$arch$lifecycle$Lifecycle$Event = new int[Event.values().length];
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    static class ObserverWithState {
        GenericLifecycleObserver mLifecycleObserver;
        State mState;

        ObserverWithState(LifecycleObserver observer, State initialState) {
            this.mLifecycleObserver = Lifecycling.getCallback(observer);
            this.mState = initialState;
        }

        /* access modifiers changed from: 0000 */
        public void dispatchEvent(LifecycleOwner owner, Event event) {
            State newState = LifecycleRegistry.getStateAfter(event);
            this.mState = LifecycleRegistry.min(this.mState, newState);
            this.mLifecycleObserver.onStateChanged(owner, event);
            this.mState = newState;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner provider) {
        this.mLifecycleOwner = new WeakReference<>(provider);
        this.mState = State.INITIALIZED;
    }

    @MainThread
    public void markState(@NonNull State state) {
        moveToState(state);
    }

    public void handleLifecycleEvent(@NonNull Event event) {
        moveToState(getStateAfter(event));
    }

    private void moveToState(State next) {
        if (this.mState != next) {
            this.mState = next;
            if (this.mHandlingEvent || this.mAddingObserverCounter != 0) {
                this.mNewEventOccurred = true;
                return;
            }
            this.mHandlingEvent = true;
            sync();
            this.mHandlingEvent = false;
        }
    }

    private boolean isSynced() {
        boolean z = true;
        if (this.mObserverMap.size() == 0) {
            return true;
        }
        State eldestObserverState = ((ObserverWithState) this.mObserverMap.eldest().getValue()).mState;
        State newestObserverState = ((ObserverWithState) this.mObserverMap.newest().getValue()).mState;
        if (!(eldestObserverState == newestObserverState && this.mState == newestObserverState)) {
            z = false;
        }
        return z;
    }

    private State calculateTargetState(LifecycleObserver observer) {
        Entry<LifecycleObserver, ObserverWithState> previous = this.mObserverMap.ceil(observer);
        State parentState = null;
        State siblingState = previous != null ? ((ObserverWithState) previous.getValue()).mState : null;
        if (!this.mParentStates.isEmpty()) {
            ArrayList<State> arrayList = this.mParentStates;
            parentState = (State) arrayList.get(arrayList.size() - 1);
        }
        return min(min(this.mState, siblingState), parentState);
    }

    public void addObserver(@NonNull LifecycleObserver observer) {
        ObserverWithState statefulObserver = new ObserverWithState(observer, this.mState == State.DESTROYED ? State.DESTROYED : State.INITIALIZED);
        if (((ObserverWithState) this.mObserverMap.putIfAbsent(observer, statefulObserver)) == null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) this.mLifecycleOwner.get();
            if (lifecycleOwner != null) {
                boolean isReentrance = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
                State targetState = calculateTargetState(observer);
                this.mAddingObserverCounter++;
                while (statefulObserver.mState.compareTo(targetState) < 0 && this.mObserverMap.contains(observer)) {
                    pushParentState(statefulObserver.mState);
                    statefulObserver.dispatchEvent(lifecycleOwner, upEvent(statefulObserver.mState));
                    popParentState();
                    targetState = calculateTargetState(observer);
                }
                if (!isReentrance) {
                    sync();
                }
                this.mAddingObserverCounter--;
            }
        }
    }

    private void popParentState() {
        ArrayList<State> arrayList = this.mParentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    private void pushParentState(State state) {
        this.mParentStates.add(state);
    }

    public void removeObserver(@NonNull LifecycleObserver observer) {
        this.mObserverMap.remove(observer);
    }

    public int getObserverCount() {
        return this.mObserverMap.size();
    }

    @NonNull
    public State getCurrentState() {
        return this.mState;
    }

    static State getStateAfter(Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return State.STARTED;
            case ON_RESUME:
                return State.RESUMED;
            case ON_DESTROY:
                return State.DESTROYED;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected event value ");
                sb.append(event);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    private static Event downEvent(State state) {
        int i = C00081.$SwitchMap$android$arch$lifecycle$Lifecycle$State[state.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return Event.ON_DESTROY;
        } else {
            if (i == 3) {
                return Event.ON_STOP;
            }
            if (i == 4) {
                return Event.ON_PAUSE;
            }
            if (i != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(state);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new IllegalArgumentException();
        }
    }

    private static Event upEvent(State state) {
        int i = C00081.$SwitchMap$android$arch$lifecycle$Lifecycle$State[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Event.ON_START;
            }
            if (i == 3) {
                return Event.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state value ");
                sb.append(state);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return Event.ON_CREATE;
    }

    private void forwardPass(LifecycleOwner lifecycleOwner) {
        Iterator<Entry<LifecycleObserver, ObserverWithState>> ascendingIterator = this.mObserverMap.iteratorWithAdditions();
        while (ascendingIterator.hasNext() && !this.mNewEventOccurred) {
            Entry<LifecycleObserver, ObserverWithState> entry = (Entry) ascendingIterator.next();
            ObserverWithState observer = (ObserverWithState) entry.getValue();
            while (observer.mState.compareTo(this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains(entry.getKey())) {
                pushParentState(observer.mState);
                observer.dispatchEvent(lifecycleOwner, upEvent(observer.mState));
                popParentState();
            }
        }
    }

    private void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator<Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.mObserverMap.descendingIterator();
        while (descendingIterator.hasNext() && !this.mNewEventOccurred) {
            Entry<LifecycleObserver, ObserverWithState> entry = (Entry) descendingIterator.next();
            ObserverWithState observer = (ObserverWithState) entry.getValue();
            while (observer.mState.compareTo(this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains(entry.getKey())) {
                Event event = downEvent(observer.mState);
                pushParentState(getStateAfter(event));
                observer.dispatchEvent(lifecycleOwner, event);
                popParentState();
            }
        }
    }

    private void sync() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.mLifecycleOwner.get();
        if (lifecycleOwner == null) {
            Log.w(LOG_TAG, "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!isSynced()) {
            this.mNewEventOccurred = false;
            if (this.mState.compareTo(((ObserverWithState) this.mObserverMap.eldest().getValue()).mState) < 0) {
                backwardPass(lifecycleOwner);
            }
            Entry<LifecycleObserver, ObserverWithState> newest = this.mObserverMap.newest();
            if (!this.mNewEventOccurred && newest != null && this.mState.compareTo(((ObserverWithState) newest.getValue()).mState) > 0) {
                forwardPass(lifecycleOwner);
            }
        }
        this.mNewEventOccurred = false;
    }

    static State min(@NonNull State state1, @Nullable State state2) {
        return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
    }
}
