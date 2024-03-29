package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.ViewParentCompat */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";

    private ViewParentCompat() {
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
        return parent.requestSendAccessibilityEvent(child, event);
    }

    public static boolean onStartNestedScroll(ViewParent parent, View child, View target, int nestedScrollAxes) {
        return onStartNestedScroll(parent, child, target, nestedScrollAxes, 0);
    }

    public static void onNestedScrollAccepted(ViewParent parent, View child, View target, int nestedScrollAxes) {
        onNestedScrollAccepted(parent, child, target, nestedScrollAxes, 0);
    }

    public static void onStopNestedScroll(ViewParent parent, View target) {
        onStopNestedScroll(parent, target, 0);
    }

    public static void onNestedScroll(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        onNestedScroll(parent, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0);
    }

    public static void onNestedPreScroll(ViewParent parent, View target, int dx, int dy, int[] consumed) {
        onNestedPreScroll(parent, target, dx, dy, consumed, 0);
    }

    public static boolean onStartNestedScroll(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) parent).onStartNestedScroll(child, target, nestedScrollAxes, type);
        }
        if (type == 0) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    return parent.onStartNestedScroll(child, target, nestedScrollAxes);
                } catch (AbstractMethodError e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(parent);
                    sb.append(" does not implement interface ");
                    sb.append("method onStartNestedScroll");
                    Log.e(TAG, sb.toString(), e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) parent).onStartNestedScroll(child, target, nestedScrollAxes);
            }
        }
        return false;
    }

    public static void onNestedScrollAccepted(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) parent).onNestedScrollAccepted(child, target, nestedScrollAxes, type);
        } else if (type != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedScrollAccepted(child, target, nestedScrollAxes);
                } catch (AbstractMethodError e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(parent);
                    sb.append(" does not implement interface ");
                    sb.append("method onNestedScrollAccepted");
                    Log.e(TAG, sb.toString(), e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) parent).onNestedScrollAccepted(child, target, nestedScrollAxes);
            }
        }
    }

    public static void onStopNestedScroll(ViewParent parent, View target, int type) {
        if (parent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) parent).onStopNestedScroll(target, type);
        } else if (type != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    parent.onStopNestedScroll(target);
                } catch (AbstractMethodError e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(parent);
                    sb.append(" does not implement interface ");
                    sb.append("method onStopNestedScroll");
                    Log.e(TAG, sb.toString(), e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) parent).onStopNestedScroll(target);
            }
        }
    }

    public static void onNestedScroll(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (parent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) parent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        } else if (type != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
                } catch (AbstractMethodError e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(parent);
                    sb.append(" does not implement interface ");
                    sb.append("method onNestedScroll");
                    Log.e(TAG, sb.toString(), e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) parent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            }
        }
    }

    public static void onNestedPreScroll(ViewParent parent, View target, int dx, int dy, int[] consumed, int type) {
        if (parent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) parent).onNestedPreScroll(target, dx, dy, consumed, type);
        } else if (type != 0) {
        } else {
            if (VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedPreScroll(target, dx, dy, consumed);
                } catch (AbstractMethodError e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(parent);
                    sb.append(" does not implement interface ");
                    sb.append("method onNestedPreScroll");
                    Log.e(TAG, sb.toString(), e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) parent).onNestedPreScroll(target, dx, dy, consumed);
            }
        }
    }

    public static boolean onNestedFling(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return parent.onNestedFling(target, velocityX, velocityY, consumed);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onNestedFling");
                Log.e(TAG, sb.toString(), e);
            }
        } else {
            if (parent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) parent).onNestedFling(target, velocityX, velocityY, consumed);
            }
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent parent, View target, float velocityX, float velocityY) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return parent.onNestedPreFling(target, velocityX, velocityY);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onNestedPreFling");
                Log.e(TAG, sb.toString(), e);
            }
        } else {
            if (parent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) parent).onNestedPreFling(target, velocityX, velocityY);
            }
            return false;
        }
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent parent, View child, View source, int changeType) {
        if (VERSION.SDK_INT >= 19) {
            parent.notifySubtreeAccessibilityStateChanged(child, source, changeType);
        }
    }
}
