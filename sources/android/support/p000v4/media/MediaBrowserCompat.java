package android.support.p000v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.p000v4.app.BundleCompat;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.IMediaSession.Stub;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p000v4.media.session.MediaSessionCompat.Token;
import android.support.p000v4.p002os.ResultReceiver;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CallbackHandler */
    private static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        CallbackHandler(MediaBrowserServiceCallbackImpl callbackImpl) {
            this.mCallbackImplRef = new WeakReference<>(callbackImpl);
        }

        public void handleMessage(Message msg) {
            String str = MediaBrowserCompat.TAG;
            WeakReference<Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference != null && weakReference.get() != null && this.mCallbackImplRef.get() != null) {
                Bundle data = msg.getData();
                data.setClassLoader(MediaSessionCompat.class.getClassLoader());
                MediaBrowserServiceCallbackImpl serviceCallback = (MediaBrowserServiceCallbackImpl) this.mCallbackImplRef.get();
                Messenger callbacksMessenger = (Messenger) this.mCallbacksMessengerRef.get();
                try {
                    int i = msg.what;
                    String str2 = MediaBrowserProtocol.DATA_MEDIA_ITEM_ID;
                    if (i == 1) {
                        serviceCallback.onServiceConnected(callbacksMessenger, data.getString(str2), (Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                    } else if (i == 2) {
                        serviceCallback.onConnectionFailed(callbacksMessenger);
                    } else if (i != 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unhandled message: ");
                        sb.append(msg);
                        sb.append("\n  Client version: ");
                        sb.append(1);
                        sb.append("\n  Service version: ");
                        sb.append(msg.arg1);
                        Log.w(str, sb.toString());
                    } else {
                        serviceCallback.onLoadChildren(callbacksMessenger, data.getString(str2), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), data.getBundle(MediaBrowserProtocol.DATA_OPTIONS));
                    }
                } catch (BadParcelableException e) {
                    Log.e(str, "Could not unparcel the data.");
                    if (msg.what == 1) {
                        serviceCallback.onConnectionFailed(callbacksMessenger);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void setCallbacksMessenger(Messenger callbacksMessenger) {
            this.mCallbacksMessengerRef = new WeakReference<>(callbacksMessenger);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback */
    public static class ConnectionCallback {
        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal */
        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$StubApi21 */
        private class StubApi21 implements ConnectionCallback {
            StubApi21() {
            }

            public void onConnected() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            public void onConnectionSuspended() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }

            public void onConnectionFailed() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }
        }

        public ConnectionCallback() {
            if (VERSION.SDK_INT >= 21) {
                this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21());
            } else {
                this.mConnectionCallbackObj = null;
            }
        }

        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }

        /* access modifiers changed from: 0000 */
        public void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionCallback */
    public static abstract class CustomActionCallback {
        public void onProgressUpdate(String action, Bundle extras, Bundle data) {
        }

        public void onResult(String action, Bundle extras, Bundle resultData) {
        }

        public void onError(String action, Bundle extras, Bundle data) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        CustomActionResultReceiver(String action, Bundle extras, CustomActionCallback callback, Handler handler) {
            super(handler);
            this.mAction = action;
            this.mExtras = extras;
            this.mCallback = callback;
        }

        /* access modifiers changed from: protected */
        public void onReceiveResult(int resultCode, Bundle resultData) {
            CustomActionCallback customActionCallback = this.mCallback;
            if (customActionCallback != null) {
                if (resultCode == -1) {
                    customActionCallback.onError(this.mAction, this.mExtras, resultData);
                } else if (resultCode == 0) {
                    customActionCallback.onResult(this.mAction, this.mExtras, resultData);
                } else if (resultCode != 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown result code: ");
                    sb.append(resultCode);
                    sb.append(" (extras=");
                    sb.append(this.mExtras);
                    sb.append(", resultData=");
                    sb.append(resultData);
                    sb.append(")");
                    Log.w(MediaBrowserCompat.TAG, sb.toString());
                } else {
                    customActionCallback.onProgressUpdate(this.mAction, this.mExtras, resultData);
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback */
    public static abstract class ItemCallback {
        final Object mItemCallbackObj;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback$StubApi23 */
        private class StubApi23 implements ItemCallback {
            StubApi23() {
            }

            public void onItemLoaded(Parcel itemParcel) {
                if (itemParcel == null) {
                    ItemCallback.this.onItemLoaded(null);
                    return;
                }
                itemParcel.setDataPosition(0);
                MediaItem item = (MediaItem) MediaItem.CREATOR.createFromParcel(itemParcel);
                itemParcel.recycle();
                ItemCallback.this.onItemLoaded(item);
            }

            public void onError(@NonNull String itemId) {
                ItemCallback.this.onError(itemId);
            }
        }

        public ItemCallback() {
            if (VERSION.SDK_INT >= 23) {
                this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23());
            } else {
                this.mItemCallbackObj = null;
            }
        }

        public void onItemLoaded(MediaItem item) {
        }

        public void onError(@NonNull String itemId) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
    private static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        ItemReceiver(String mediaId, ItemCallback callback, Handler handler) {
            super(handler);
            this.mMediaId = mediaId;
            this.mCallback = callback;
        }

        /* access modifiers changed from: protected */
        public void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (resultCode == 0 && resultData != null) {
                String str = MediaBrowserServiceCompat.KEY_MEDIA_ITEM;
                if (resultData.containsKey(str)) {
                    Parcelable item = resultData.getParcelable(str);
                    if (item == null || (item instanceof MediaItem)) {
                        this.mCallback.onItemLoaded((MediaItem) item);
                    } else {
                        this.mCallback.onError(this.mMediaId);
                    }
                    return;
                }
            }
            this.mCallback.onError(this.mMediaId);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl */
    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String str, @NonNull ItemCallback itemCallback);

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback);

        void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback);

        void subscribe(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback);

        void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback);
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21 */
    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallbackInternal {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler = new CallbackHandler(this);
        private Token mMediaSessionToken;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        public MediaBrowserImplApi21(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            this.mContext = context;
            if (rootHints == null) {
                rootHints = new Bundle();
            }
            rootHints.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            this.mRootHints = new Bundle(rootHints);
            callback.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(context, serviceComponent, callback.mConnectionCallbackObj, this.mRootHints);
        }

        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        public void disconnect() {
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null) {
                Messenger messenger = this.mCallbacksMessenger;
                if (messenger != null) {
                    try {
                        serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                    } catch (RemoteException e) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
                    }
                }
            }
            MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @NonNull
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Nullable
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @NonNull
        public Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
            }
            return this.mMediaSessionToken;
        }

        public void subscribe(@NonNull String parentId, Bundle options, @NonNull SubscriptionCallback callback) {
            Subscription sub = (Subscription) this.mSubscriptions.get(parentId);
            if (sub == null) {
                sub = new Subscription();
                this.mSubscriptions.put(parentId, sub);
            }
            callback.setSubscription(sub);
            Bundle copiedOptions = options == null ? null : new Bundle(options);
            sub.putCallback(this.mContext, copiedOptions, callback);
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, parentId, callback.mSubscriptionCallbackObj);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(parentId, callback.mToken, copiedOptions, this.mCallbacksMessenger);
            } catch (RemoteException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Remote error subscribing media item: ");
                sb.append(parentId);
                Log.i(MediaBrowserCompat.TAG, sb.toString());
            }
        }

        public void unsubscribe(@NonNull String parentId, SubscriptionCallback callback) {
            Subscription sub = (Subscription) this.mSubscriptions.get(parentId);
            if (sub != null) {
                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                if (serviceBinderWrapper == null) {
                    if (callback == null) {
                        MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, parentId);
                    } else {
                        List<SubscriptionCallback> callbacks = sub.getCallbacks();
                        List<Bundle> optionsList = sub.getOptionsList();
                        for (int i = callbacks.size() - 1; i >= 0; i--) {
                            if (callbacks.get(i) == callback) {
                                callbacks.remove(i);
                                optionsList.remove(i);
                            }
                        }
                        if (callbacks.size() == 0) {
                            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, parentId);
                        }
                    }
                } else if (callback == null) {
                    try {
                        serviceBinderWrapper.removeSubscription(parentId, null, this.mCallbacksMessenger);
                    } catch (RemoteException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("removeSubscription failed with RemoteException parentId=");
                        sb.append(parentId);
                        Log.d(MediaBrowserCompat.TAG, sb.toString());
                    }
                } else {
                    List<SubscriptionCallback> callbacks2 = sub.getCallbacks();
                    List<Bundle> optionsList2 = sub.getOptionsList();
                    for (int i2 = callbacks2.size() - 1; i2 >= 0; i2--) {
                        if (callbacks2.get(i2) == callback) {
                            this.mServiceBinderWrapper.removeSubscription(parentId, callback.mToken, this.mCallbacksMessenger);
                            callbacks2.remove(i2);
                            optionsList2.remove(i2);
                        }
                    }
                }
                if (sub.isEmpty() || callback == null) {
                    this.mSubscriptions.remove(parentId);
                }
            }
        }

        public void getItem(@NonNull final String mediaId, @NonNull final ItemCallback cb) {
            if (TextUtils.isEmpty(mediaId)) {
                throw new IllegalArgumentException("mediaId is empty");
            } else if (cb != null) {
                boolean isConnected = MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
                String str = MediaBrowserCompat.TAG;
                if (!isConnected) {
                    Log.i(str, "Not connected, unable to retrieve the MediaItem.");
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            cb.onError(mediaId);
                        }
                    });
                } else if (this.mServiceBinderWrapper == null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            cb.onError(mediaId);
                        }
                    });
                } else {
                    try {
                        this.mServiceBinderWrapper.getMediaItem(mediaId, new ItemReceiver(mediaId, cb, this.mHandler), this.mCallbacksMessenger);
                    } catch (RemoteException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Remote error getting media item: ");
                        sb.append(mediaId);
                        Log.i(str, sb.toString());
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                cb.onError(mediaId);
                            }
                        });
                    }
                }
            } else {
                throw new IllegalArgumentException("cb is null");
            }
        }

        public void search(@NonNull final String query, final Bundle extras, @NonNull final SearchCallback callback) {
            if (isConnected()) {
                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                String str = MediaBrowserCompat.TAG;
                if (serviceBinderWrapper == null) {
                    Log.i(str, "The connected service doesn't support search.");
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            callback.onError(query, extras);
                        }
                    });
                    return;
                }
                try {
                    this.mServiceBinderWrapper.search(query, extras, new SearchResultReceiver(query, extras, callback, this.mHandler), this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Remote error searching items with query: ");
                    sb.append(query);
                    Log.i(str, sb.toString(), e);
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            callback.onError(query, extras);
                        }
                    });
                }
                return;
            }
            throw new IllegalStateException("search() called while not connected");
        }

        public void sendCustomAction(@NonNull final String action, final Bundle extras, @Nullable final CustomActionCallback callback) {
            if (isConnected()) {
                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                String str = MediaBrowserCompat.TAG;
                if (serviceBinderWrapper == null) {
                    Log.i(str, "The connected service doesn't support sendCustomAction.");
                    if (callback != null) {
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                callback.onError(action, extras, null);
                            }
                        });
                    }
                }
                try {
                    this.mServiceBinderWrapper.sendCustomAction(action, extras, new CustomActionResultReceiver(action, extras, callback, this.mHandler), this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Remote error sending a custom action: action=");
                    sb.append(action);
                    sb.append(", extras=");
                    sb.append(extras);
                    Log.i(str, sb.toString(), e);
                    if (callback != null) {
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                callback.onError(action, extras, null);
                            }
                        });
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot send a custom action (");
                sb2.append(action);
                sb2.append(") with ");
                sb2.append("extras ");
                sb2.append(extras);
                sb2.append(" because the browser is not connected to the ");
                sb2.append("service.");
                throw new IllegalStateException(sb2.toString());
            }
        }

        public void onConnected() {
            Bundle extras = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if (extras != null) {
                IBinder serviceBinder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (serviceBinder != null) {
                    this.mServiceBinderWrapper = new ServiceBinderWrapper(serviceBinder, this.mRootHints);
                    this.mCallbacksMessenger = new Messenger(this.mHandler);
                    this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
                    try {
                        this.mServiceBinderWrapper.registerCallbackMessenger(this.mCallbacksMessenger);
                    } catch (RemoteException e) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error registering client messenger.");
                    }
                }
                IMediaSession sessionToken = Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (sessionToken != null) {
                    this.mMediaSessionToken = Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), sessionToken);
                }
            }
        }

        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        public void onConnectionFailed() {
        }

        public void onServiceConnected(Messenger callback, String root, Token session, Bundle extra) {
        }

        public void onConnectionFailed(Messenger callback) {
        }

        public void onLoadChildren(Messenger callback, String parentId, List list, Bundle options) {
            if (this.mCallbacksMessenger == callback) {
                Subscription subscription = (Subscription) this.mSubscriptions.get(parentId);
                if (subscription == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onLoadChildren for id that isn't subscribed id=");
                        sb.append(parentId);
                        Log.d(MediaBrowserCompat.TAG, sb.toString());
                    }
                    return;
                }
                SubscriptionCallback subscriptionCallback = subscription.getCallback(this.mContext, options);
                if (subscriptionCallback != null) {
                    if (options == null) {
                        if (list == null) {
                            subscriptionCallback.onError(parentId);
                        } else {
                            subscriptionCallback.onChildrenLoaded(parentId, list);
                        }
                    } else if (list == null) {
                        subscriptionCallback.onError(parentId, options);
                    } else {
                        subscriptionCallback.onChildrenLoaded(parentId, list, options);
                    }
                }
            }
        }
    }

    @RequiresApi(23)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23 */
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            super(context, serviceComponent, callback, rootHints);
        }

        public void getItem(@NonNull String mediaId, @NonNull ItemCallback cb) {
            if (this.mServiceBinderWrapper == null) {
                MediaBrowserCompatApi23.getItem(this.mBrowserObj, mediaId, cb.mItemCallbackObj);
            } else {
                super.getItem(mediaId, cb);
            }
        }
    }

    @RequiresApi(26)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi24 */
    static class MediaBrowserImplApi24 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi24(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            super(context, serviceComponent, callback, rootHints);
        }

        public void subscribe(@NonNull String parentId, @NonNull Bundle options, @NonNull SubscriptionCallback callback) {
            if (options == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, parentId, callback.mSubscriptionCallbackObj);
            } else {
                MediaBrowserCompatApi24.subscribe(this.mBrowserObj, parentId, options, callback.mSubscriptionCallbackObj);
            }
        }

        public void unsubscribe(@NonNull String parentId, SubscriptionCallback callback) {
            if (callback == null) {
                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, parentId);
            } else {
                MediaBrowserCompatApi24.unsubscribe(this.mBrowserObj, parentId, callback.mSubscriptionCallbackObj);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase */
    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler = new CallbackHandler(this);
        private Token mMediaSessionToken;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState = 1;
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection */
        private class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            public void onServiceConnected(final ComponentName name, final IBinder binder) {
                postOrRun(new Runnable() {
                    public void run() {
                        String str = "ServiceCallbacks.onConnect...";
                        boolean z = MediaBrowserCompat.DEBUG;
                        String str2 = MediaBrowserCompat.TAG;
                        if (z) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("MediaServiceConnection.onServiceConnected name=");
                            sb.append(name);
                            sb.append(" binder=");
                            sb.append(binder);
                            Log.d(str2, sb.toString());
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            MediaBrowserImplBase.this.mServiceBinderWrapper = new ServiceBinderWrapper(binder, MediaBrowserImplBase.this.mRootHints);
                            MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                            MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(MediaBrowserImplBase.this.mCallbacksMessenger);
                            MediaBrowserImplBase.this.mState = 2;
                            try {
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d(str2, str);
                                    MediaBrowserImplBase.this.dump();
                                }
                                MediaBrowserImplBase.this.mServiceBinderWrapper.connect(MediaBrowserImplBase.this.mContext, MediaBrowserImplBase.this.mCallbacksMessenger);
                            } catch (RemoteException e) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("RemoteException during connect for ");
                                sb2.append(MediaBrowserImplBase.this.mServiceComponent);
                                Log.w(str2, sb2.toString());
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d(str2, str);
                                    MediaBrowserImplBase.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            public void onServiceDisconnected(final ComponentName name) {
                postOrRun(new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("MediaServiceConnection.onServiceDisconnected name=");
                            sb.append(name);
                            sb.append(" this=");
                            sb.append(this);
                            sb.append(" mServiceConnection=");
                            sb.append(MediaBrowserImplBase.this.mServiceConnection);
                            Log.d(MediaBrowserCompat.TAG, sb.toString());
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            MediaBrowserImplBase.this.mServiceBinderWrapper = null;
                            MediaBrowserImplBase.this.mCallbacksMessenger = null;
                            MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(null);
                            MediaBrowserImplBase.this.mState = 4;
                            MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }

            private void postOrRun(Runnable r) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    r.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(r);
                }
            }

            /* access modifiers changed from: 0000 */
            public boolean isCurrent(String funcName) {
                if (MediaBrowserImplBase.this.mServiceConnection == this && MediaBrowserImplBase.this.mState != 0 && MediaBrowserImplBase.this.mState != 1) {
                    return true;
                }
                if (!(MediaBrowserImplBase.this.mState == 0 || MediaBrowserImplBase.this.mState == 1)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(funcName);
                    sb.append(" for ");
                    sb.append(MediaBrowserImplBase.this.mServiceComponent);
                    sb.append(" with mServiceConnection=");
                    sb.append(MediaBrowserImplBase.this.mServiceConnection);
                    sb.append(" this=");
                    sb.append(this);
                    Log.i(MediaBrowserCompat.TAG, sb.toString());
                }
                return false;
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (serviceComponent == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (callback != null) {
                this.mContext = context;
                this.mServiceComponent = serviceComponent;
                this.mCallback = callback;
                this.mRootHints = rootHints == null ? null : new Bundle(rootHints);
            } else {
                throw new IllegalArgumentException("connection callback must not be null");
            }
        }

        public void connect() {
            int i = this.mState;
            if (i == 0 || i == 1) {
                this.mState = 2;
                this.mHandler.post(new Runnable() {
                    public void run() {
                        String str = MediaBrowserCompat.TAG;
                        if (MediaBrowserImplBase.this.mState != 0) {
                            MediaBrowserImplBase.this.mState = 2;
                            if (MediaBrowserCompat.DEBUG && MediaBrowserImplBase.this.mServiceConnection != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("mServiceConnection should be null. Instead it is ");
                                sb.append(MediaBrowserImplBase.this.mServiceConnection);
                                throw new RuntimeException(sb.toString());
                            } else if (MediaBrowserImplBase.this.mServiceBinderWrapper != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("mServiceBinderWrapper should be null. Instead it is ");
                                sb2.append(MediaBrowserImplBase.this.mServiceBinderWrapper);
                                throw new RuntimeException(sb2.toString());
                            } else if (MediaBrowserImplBase.this.mCallbacksMessenger == null) {
                                Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                                intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                                mediaBrowserImplBase.mServiceConnection = new MediaServiceConnection();
                                boolean bound = false;
                                try {
                                    bound = MediaBrowserImplBase.this.mContext.bindService(intent, MediaBrowserImplBase.this.mServiceConnection, 1);
                                } catch (Exception e) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Failed binding to service ");
                                    sb3.append(MediaBrowserImplBase.this.mServiceComponent);
                                    Log.e(str, sb3.toString());
                                }
                                if (!bound) {
                                    MediaBrowserImplBase.this.forceCloseConnection();
                                    MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                                }
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d(str, "connect...");
                                    MediaBrowserImplBase.this.dump();
                                }
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("mCallbacksMessenger should be null. Instead it is ");
                                sb4.append(MediaBrowserImplBase.this.mCallbacksMessenger);
                                throw new RuntimeException(sb4.toString());
                            }
                        }
                    }
                });
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("connect() called while neigther disconnecting nor disconnected (state=");
            sb.append(getStateLabel(this.mState));
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }

        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new Runnable() {
                public void run() {
                    Messenger messenger = MediaBrowserImplBase.this.mCallbacksMessenger;
                    String str = MediaBrowserCompat.TAG;
                    if (messenger != null) {
                        try {
                            MediaBrowserImplBase.this.mServiceBinderWrapper.disconnect(MediaBrowserImplBase.this.mCallbacksMessenger);
                        } catch (RemoteException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("RemoteException during connect for ");
                            sb.append(MediaBrowserImplBase.this.mServiceComponent);
                            Log.w(str, sb.toString());
                        }
                    }
                    int state = MediaBrowserImplBase.this.mState;
                    MediaBrowserImplBase.this.forceCloseConnection();
                    if (state != 0) {
                        MediaBrowserImplBase.this.mState = state;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d(str, "disconnect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        /* access modifiers changed from: 0000 */
        public void forceCloseConnection() {
            MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        public boolean isConnected() {
            return this.mState == 3;
        }

        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getServiceComponent() called while not connected (state=");
            sb.append(this.mState);
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }

        @NonNull
        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getRoot() called while not connected(state=");
            sb.append(getStateLabel(this.mState));
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }

        @Nullable
        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getExtras() called while not connected (state=");
            sb.append(getStateLabel(this.mState));
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }

        @NonNull
        public Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getSessionToken() called while not connected(state=");
            sb.append(this.mState);
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }

        public void subscribe(@NonNull String parentId, Bundle options, @NonNull SubscriptionCallback callback) {
            Subscription sub = (Subscription) this.mSubscriptions.get(parentId);
            if (sub == null) {
                sub = new Subscription();
                this.mSubscriptions.put(parentId, sub);
            }
            Bundle copiedOptions = options == null ? null : new Bundle(options);
            sub.putCallback(this.mContext, copiedOptions, callback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(parentId, callback.mToken, copiedOptions, this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("addSubscription failed with RemoteException parentId=");
                    sb.append(parentId);
                    Log.d(MediaBrowserCompat.TAG, sb.toString());
                }
            }
        }

        public void unsubscribe(@NonNull String parentId, SubscriptionCallback callback) {
            Subscription sub = (Subscription) this.mSubscriptions.get(parentId);
            if (sub != null) {
                if (callback == null) {
                    try {
                        if (isConnected()) {
                            this.mServiceBinderWrapper.removeSubscription(parentId, null, this.mCallbacksMessenger);
                        }
                    } catch (RemoteException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("removeSubscription failed with RemoteException parentId=");
                        sb.append(parentId);
                        Log.d(MediaBrowserCompat.TAG, sb.toString());
                    }
                } else {
                    List<SubscriptionCallback> callbacks = sub.getCallbacks();
                    List<Bundle> optionsList = sub.getOptionsList();
                    for (int i = callbacks.size() - 1; i >= 0; i--) {
                        if (callbacks.get(i) == callback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(parentId, callback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(i);
                            optionsList.remove(i);
                        }
                    }
                }
                if (sub.isEmpty() || callback == null) {
                    this.mSubscriptions.remove(parentId);
                }
            }
        }

        public void getItem(@NonNull final String mediaId, @NonNull final ItemCallback cb) {
            if (TextUtils.isEmpty(mediaId)) {
                throw new IllegalArgumentException("mediaId is empty");
            } else if (cb != null) {
                boolean isConnected = isConnected();
                String str = MediaBrowserCompat.TAG;
                if (!isConnected) {
                    Log.i(str, "Not connected, unable to retrieve the MediaItem.");
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            cb.onError(mediaId);
                        }
                    });
                    return;
                }
                try {
                    this.mServiceBinderWrapper.getMediaItem(mediaId, new ItemReceiver(mediaId, cb, this.mHandler), this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Remote error getting media item: ");
                    sb.append(mediaId);
                    Log.i(str, sb.toString());
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            cb.onError(mediaId);
                        }
                    });
                }
            } else {
                throw new IllegalArgumentException("cb is null");
            }
        }

        public void search(@NonNull final String query, final Bundle extras, @NonNull final SearchCallback callback) {
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.search(query, extras, new SearchResultReceiver(query, extras, callback, this.mHandler), this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Remote error searching items with query: ");
                    sb.append(query);
                    Log.i(MediaBrowserCompat.TAG, sb.toString(), e);
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            callback.onError(query, extras);
                        }
                    });
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("search() called while not connected (state=");
                sb2.append(getStateLabel(this.mState));
                sb2.append(")");
                throw new IllegalStateException(sb2.toString());
            }
        }

        public void sendCustomAction(@NonNull final String action, final Bundle extras, @Nullable final CustomActionCallback callback) {
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.sendCustomAction(action, extras, new CustomActionResultReceiver(action, extras, callback, this.mHandler), this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Remote error sending a custom action: action=");
                    sb.append(action);
                    sb.append(", extras=");
                    sb.append(extras);
                    Log.i(MediaBrowserCompat.TAG, sb.toString(), e);
                    if (callback != null) {
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                callback.onError(action, extras, null);
                            }
                        });
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot send a custom action (");
                sb2.append(action);
                sb2.append(") with ");
                sb2.append("extras ");
                sb2.append(extras);
                sb2.append(" because the browser is not connected to the ");
                sb2.append("service.");
                throw new IllegalStateException(sb2.toString());
            }
        }

        public void onServiceConnected(Messenger callback, String root, Token session, Bundle extra) {
            if (isCurrent(callback, "onConnect")) {
                int i = this.mState;
                String str = MediaBrowserCompat.TAG;
                if (i != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onConnect from service while mState=");
                    sb.append(getStateLabel(this.mState));
                    sb.append("... ignoring");
                    Log.w(str, sb.toString());
                    return;
                }
                this.mRootId = root;
                this.mMediaSessionToken = session;
                this.mExtras = extra;
                this.mState = 3;
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(str, "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    Iterator it = this.mSubscriptions.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<String, Subscription> subscriptionEntry = (Entry) it.next();
                        String id = (String) subscriptionEntry.getKey();
                        Subscription sub = (Subscription) subscriptionEntry.getValue();
                        List<SubscriptionCallback> callbackList = sub.getCallbacks();
                        List<Bundle> optionsList = sub.getOptionsList();
                        int i2 = 0;
                        while (i2 < callbackList.size()) {
                            Iterator it2 = it;
                            this.mServiceBinderWrapper.addSubscription(id, ((SubscriptionCallback) callbackList.get(i2)).mToken, (Bundle) optionsList.get(i2), this.mCallbacksMessenger);
                            i2++;
                            it = it2;
                        }
                        Iterator it3 = it;
                    }
                } catch (RemoteException e) {
                    Log.d(str, "addSubscription failed with RemoteException.");
                }
            }
        }

        public void onConnectionFailed(Messenger callback) {
            StringBuilder sb = new StringBuilder();
            sb.append("onConnectFailed for ");
            sb.append(this.mServiceComponent);
            String sb2 = sb.toString();
            String str = MediaBrowserCompat.TAG;
            Log.e(str, sb2);
            if (isCurrent(callback, "onConnectFailed")) {
                if (this.mState != 2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onConnect from service while mState=");
                    sb3.append(getStateLabel(this.mState));
                    sb3.append("... ignoring");
                    Log.w(str, sb3.toString());
                    return;
                }
                forceCloseConnection();
                this.mCallback.onConnectionFailed();
            }
        }

        public void onLoadChildren(Messenger callback, String parentId, List list, Bundle options) {
            if (isCurrent(callback, "onLoadChildren")) {
                boolean z = MediaBrowserCompat.DEBUG;
                String str = MediaBrowserCompat.TAG;
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onLoadChildren for ");
                    sb.append(this.mServiceComponent);
                    sb.append(" id=");
                    sb.append(parentId);
                    Log.d(str, sb.toString());
                }
                Subscription subscription = (Subscription) this.mSubscriptions.get(parentId);
                if (subscription == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onLoadChildren for id that isn't subscribed id=");
                        sb2.append(parentId);
                        Log.d(str, sb2.toString());
                    }
                    return;
                }
                SubscriptionCallback subscriptionCallback = subscription.getCallback(this.mContext, options);
                if (subscriptionCallback != null) {
                    if (options == null) {
                        if (list == null) {
                            subscriptionCallback.onError(parentId);
                        } else {
                            subscriptionCallback.onChildrenLoaded(parentId, list);
                        }
                    } else if (list == null) {
                        subscriptionCallback.onError(parentId, options);
                    } else {
                        subscriptionCallback.onChildrenLoaded(parentId, list, options);
                    }
                }
            }
        }

        private static String getStateLabel(int state) {
            if (state == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (state == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (state == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (state == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (state == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("UNKNOWN/");
            sb.append(state);
            return sb.toString();
        }

        private boolean isCurrent(Messenger callback, String funcName) {
            if (this.mCallbacksMessenger == callback) {
                int i = this.mState;
                if (!(i == 0 || i == 1)) {
                    return true;
                }
            }
            int i2 = this.mState;
            if (!(i2 == 0 || i2 == 1)) {
                StringBuilder sb = new StringBuilder();
                sb.append(funcName);
                sb.append(" for ");
                sb.append(this.mServiceComponent);
                sb.append(" with mCallbacksMessenger=");
                sb.append(this.mCallbacksMessenger);
                sb.append(" this=");
                sb.append(this);
                Log.i(MediaBrowserCompat.TAG, sb.toString());
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public void dump() {
            String str = MediaBrowserCompat.TAG;
            Log.d(str, "MediaBrowserCompat...");
            StringBuilder sb = new StringBuilder();
            sb.append("  mServiceComponent=");
            sb.append(this.mServiceComponent);
            Log.d(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  mCallback=");
            sb2.append(this.mCallback);
            Log.d(str, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  mRootHints=");
            sb3.append(this.mRootHints);
            Log.d(str, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  mState=");
            sb4.append(getStateLabel(this.mState));
            Log.d(str, sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("  mServiceConnection=");
            sb5.append(this.mServiceConnection);
            Log.d(str, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("  mServiceBinderWrapper=");
            sb6.append(this.mServiceBinderWrapper);
            Log.d(str, sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("  mCallbacksMessenger=");
            sb7.append(this.mCallbacksMessenger);
            Log.d(str, sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("  mRootId=");
            sb8.append(this.mRootId);
            Log.d(str, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("  mMediaSessionToken=");
            sb9.append(this.mMediaSessionToken);
            Log.d(str, sb9.toString());
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl */
    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle);

        void onServiceConnected(Messenger messenger, String str, Token token, Bundle bundle);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public MediaItem createFromParcel(Parcel in) {
                return new MediaItem(in);
            }

            public MediaItem[] newArray(int size) {
                return new MediaItem[size];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$Flags */
        public @interface Flags {
        }

        public static MediaItem fromMediaItem(Object itemObj) {
            if (itemObj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaItem.getDescription(itemObj)), MediaItem.getFlags(itemObj));
        }

        public static List<MediaItem> fromMediaItemList(List<?> itemList) {
            if (itemList == null || VERSION.SDK_INT < 21) {
                return null;
            }
            List<MediaItem> items = new ArrayList<>(itemList.size());
            for (Object itemObj : itemList) {
                items.add(fromMediaItem(itemObj));
            }
            return items;
        }

        public MediaItem(@NonNull MediaDescriptionCompat description, int flags) {
            if (description == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (!TextUtils.isEmpty(description.getMediaId())) {
                this.mFlags = flags;
                this.mDescription = description;
            } else {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
        }

        MediaItem(Parcel in) {
            this.mFlags = in.readInt();
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(in);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.mFlags);
            this.mDescription.writeToParcel(out, flags);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=");
            sb.append(this.mFlags);
            sb.append(", mDescription=");
            sb.append(this.mDescription);
            sb.append('}');
            return sb.toString();
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        @Nullable
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchCallback */
    public static abstract class SearchCallback {
        public void onSearchResult(@NonNull String query, Bundle extras, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String query, Bundle extras) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
    private static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String query, Bundle extras, SearchCallback callback, Handler handler) {
            super(handler);
            this.mQuery = query;
            this.mExtras = extras;
            this.mCallback = callback;
        }

        /* access modifiers changed from: protected */
        public void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (resultCode == 0 && resultData != null) {
                String str = MediaBrowserServiceCompat.KEY_SEARCH_RESULTS;
                if (resultData.containsKey(str)) {
                    Parcelable[] items = resultData.getParcelableArray(str);
                    List<MediaItem> results = null;
                    if (items != null) {
                        results = new ArrayList<>();
                        int length = items.length;
                        for (int i = 0; i < length; i++) {
                            results.add((MediaItem) items[i]);
                        }
                    }
                    this.mCallback.onSearchResult(this.mQuery, this.mExtras, results);
                    return;
                }
            }
            this.mCallback.onError(this.mQuery, this.mExtras);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper */
    private static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder target, Bundle rootHints) {
            this.mMessenger = new Messenger(target);
            this.mRootHints = rootHints;
        }

        /* access modifiers changed from: 0000 */
        public void connect(Context context, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            data.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, data, callbacksMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void disconnect(Messenger callbacksMessenger) throws RemoteException {
            sendRequest(2, null, callbacksMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void addSubscription(String parentId, IBinder callbackToken, Bundle options, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, parentId);
            BundleCompat.putBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, callbackToken);
            data.putBundle(MediaBrowserProtocol.DATA_OPTIONS, options);
            sendRequest(3, data, callbacksMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void removeSubscription(String parentId, IBinder callbackToken, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, parentId);
            BundleCompat.putBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, callbackToken);
            sendRequest(4, data, callbacksMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void getMediaItem(String mediaId, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, mediaId);
            data.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, receiver);
            sendRequest(5, data, callbacksMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void registerCallbackMessenger(Messenger callbackMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, data, callbackMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void unregisterCallbackMessenger(Messenger callbackMessenger) throws RemoteException {
            sendRequest(7, null, callbackMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void search(String query, Bundle extras, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, query);
            data.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, extras);
            data.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, receiver);
            sendRequest(8, data, callbacksMessenger);
        }

        /* access modifiers changed from: 0000 */
        public void sendCustomAction(String action, Bundle extras, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, action);
            data.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, extras);
            data.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, receiver);
            sendRequest(9, data, callbacksMessenger);
        }

        private void sendRequest(int what, Bundle data, Messenger cbMessenger) throws RemoteException {
            Message msg = Message.obtain();
            msg.what = what;
            msg.arg1 = 1;
            msg.setData(data);
            msg.replyTo = cbMessenger;
            this.mMessenger.send(msg);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$Subscription */
    private static class Subscription {
        private final List<SubscriptionCallback> mCallbacks = new ArrayList();
        private final List<Bundle> mOptionsList = new ArrayList();

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public SubscriptionCallback getCallback(Context context, Bundle options) {
            if (options != null) {
                options.setClassLoader(context.getClassLoader());
            }
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(i), options)) {
                    return (SubscriptionCallback) this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public void putCallback(Context context, Bundle options, SubscriptionCallback callback) {
            if (options != null) {
                options.setClassLoader(context.getClassLoader());
            }
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(i), options)) {
                    this.mCallbacks.set(i, callback);
                    return;
                }
            }
            this.mCallbacks.add(callback);
            this.mOptionsList.add(options);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback */
    public static abstract class SubscriptionCallback {
        /* access modifiers changed from: private */
        public final Object mSubscriptionCallbackObj;
        WeakReference<Subscription> mSubscriptionRef;
        /* access modifiers changed from: private */
        public final IBinder mToken;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21 */
        private class StubApi21 implements SubscriptionCallback {
            StubApi21() {
            }

            public void onChildrenLoaded(@NonNull String parentId, List<?> children) {
                Subscription sub = SubscriptionCallback.this.mSubscriptionRef == null ? null : (Subscription) SubscriptionCallback.this.mSubscriptionRef.get();
                if (sub == null) {
                    SubscriptionCallback.this.onChildrenLoaded(parentId, MediaItem.fromMediaItemList(children));
                    return;
                }
                List<MediaItem> itemList = MediaItem.fromMediaItemList(children);
                List<SubscriptionCallback> callbacks = sub.getCallbacks();
                List<Bundle> optionsList = sub.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle options = (Bundle) optionsList.get(i);
                    if (options == null) {
                        SubscriptionCallback.this.onChildrenLoaded(parentId, itemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(parentId, applyOptions(itemList, options), options);
                    }
                }
            }

            public void onError(@NonNull String parentId) {
                SubscriptionCallback.this.onError(parentId);
            }

            /* access modifiers changed from: 0000 */
            public List<MediaItem> applyOptions(List<MediaItem> list, Bundle options) {
                if (list == null) {
                    return null;
                }
                int page = options.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int pageSize = options.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (page == -1 && pageSize == -1) {
                    return list;
                }
                int fromIndex = pageSize * page;
                int toIndex = fromIndex + pageSize;
                if (page < 0 || pageSize < 1 || fromIndex >= list.size()) {
                    return Collections.EMPTY_LIST;
                }
                if (toIndex > list.size()) {
                    toIndex = list.size();
                }
                return list.subList(fromIndex, toIndex);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi24 */
        private class StubApi24 extends StubApi21 implements SubscriptionCallback {
            StubApi24() {
                super();
            }

            public void onChildrenLoaded(@NonNull String parentId, List<?> children, @NonNull Bundle options) {
                SubscriptionCallback.this.onChildrenLoaded(parentId, MediaItem.fromMediaItemList(children), options);
            }

            public void onError(@NonNull String parentId, @NonNull Bundle options) {
                SubscriptionCallback.this.onError(parentId, options);
            }
        }

        public SubscriptionCallback() {
            if (VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackObj = MediaBrowserCompatApi24.createSubscriptionCallback(new StubApi24());
                this.mToken = null;
            } else if (VERSION.SDK_INT >= 21) {
                this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21());
                this.mToken = new Binder();
            } else {
                this.mSubscriptionCallbackObj = null;
                this.mToken = new Binder();
            }
        }

        public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> list) {
        }

        public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> list, @NonNull Bundle options) {
        }

        public void onError(@NonNull String parentId) {
        }

        public void onError(@NonNull String parentId, @NonNull Bundle options) {
        }

        /* access modifiers changed from: private */
        public void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference<>(subscription);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
        if (VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserImplApi24(context, serviceComponent, callback, rootHints);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserImplApi23(context, serviceComponent, callback, rootHints);
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserImplApi21(context, serviceComponent, callback, rootHints);
        } else {
            this.mImpl = new MediaBrowserImplBase(context, serviceComponent, callback, rootHints);
        }
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    @NonNull
    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public void subscribe(@NonNull String parentId, @NonNull SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (callback != null) {
            this.mImpl.subscribe(parentId, null, callback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }

    public void subscribe(@NonNull String parentId, @NonNull Bundle options, @NonNull SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (callback == null) {
            throw new IllegalArgumentException("callback is null");
        } else if (options != null) {
            this.mImpl.subscribe(parentId, options, callback);
        } else {
            throw new IllegalArgumentException("options are null");
        }
    }

    public void unsubscribe(@NonNull String parentId) {
        if (!TextUtils.isEmpty(parentId)) {
            this.mImpl.unsubscribe(parentId, null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String parentId, @NonNull SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (callback != null) {
            this.mImpl.unsubscribe(parentId, callback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }

    public void getItem(@NonNull String mediaId, @NonNull ItemCallback cb) {
        this.mImpl.getItem(mediaId, cb);
    }

    public void search(@NonNull String query, Bundle extras, @NonNull SearchCallback callback) {
        if (TextUtils.isEmpty(query)) {
            throw new IllegalArgumentException("query cannot be empty");
        } else if (callback != null) {
            this.mImpl.search(query, extras, callback);
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public void sendCustomAction(@NonNull String action, Bundle extras, @Nullable CustomActionCallback callback) {
        if (!TextUtils.isEmpty(action)) {
            this.mImpl.sendCustomAction(action, extras, callback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }
}
