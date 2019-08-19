package android.support.p000v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.p000v4.app.BundleCompat;
import android.support.p000v4.media.MediaBrowserCompat.MediaItem;
import android.support.p000v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaSessionCompat.Token;
import android.support.p000v4.p002os.ResultReceiver;
import android.support.p000v4.util.ArrayMap;
import android.support.p000v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserServiceCompat */
public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final float EPSILON = 1.0E-5f;
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    static final int RESULT_OK = 0;
    static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler = new ServiceHandler();
    private MediaBrowserServiceImpl mImpl;
    Token mSession;

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$BrowserRoot */
    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String rootId, @Nullable Bundle extras) {
            if (rootId != null) {
                this.mRootId = rootId;
                this.mExtras = extras;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public String getRootId() {
            return this.mRootId;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord */
    private static class ConnectionRecord {
        ServiceCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();

        ConnectionRecord() {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl */
    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(Token token);
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 */
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList = new ArrayList();
        Object mServiceObj;

        MediaBrowserServiceImplApi21() {
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        public void setSessionToken(final Token token) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    if (!MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                        IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            for (Bundle rootExtras : MediaBrowserServiceImplApi21.this.mRootExtrasList) {
                                BundleCompat.putBinder(rootExtras, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.mServiceObj, token.getToken());
                }
            });
        }

        public void notifyChildrenChanged(final String parentId, final Bundle options) {
            if (this.mMessenger == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, parentId);
            } else {
                MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                    public void run() {
                        for (IBinder binder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                            ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(binder);
                            List<Pair<IBinder, Bundle>> callbackList = (List) connection.subscriptions.get(parentId);
                            if (callbackList != null) {
                                for (Pair<IBinder, Bundle> callback : callbackList) {
                                    if (MediaBrowserCompatUtils.hasDuplicatedItems(options, (Bundle) callback.second)) {
                                        MediaBrowserServiceCompat.this.performLoadChildren(parentId, connection, (Bundle) callback.second);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        public Bundle getBrowserRootHints() {
            Bundle bundle = null;
            if (this.mMessenger == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                if (MediaBrowserServiceCompat.this.mCurConnection.rootHints != null) {
                    bundle = new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
                }
                return bundle;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
        }

        public BrowserRoot onGetRoot(String clientPackageName, int clientUid, Bundle rootHints) {
            IBinder iBinder;
            Bundle rootExtras = null;
            if (rootHints != null) {
                String str = MediaBrowserProtocol.EXTRA_CLIENT_VERSION;
                if (rootHints.getInt(str, 0) != 0) {
                    rootHints.remove(str);
                    this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                    rootExtras = new Bundle();
                    rootExtras.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
                    BundleCompat.putBinder(rootExtras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                    if (MediaBrowserServiceCompat.this.mSession != null) {
                        IMediaSession extraBinder = MediaBrowserServiceCompat.this.mSession.getExtraBinder();
                        if (extraBinder == null) {
                            iBinder = null;
                        } else {
                            iBinder = extraBinder.asBinder();
                        }
                        BundleCompat.putBinder(rootExtras, MediaBrowserProtocol.EXTRA_SESSION_BINDER, iBinder);
                    } else {
                        this.mRootExtrasList.add(rootExtras);
                    }
                }
            }
            BrowserRoot root = MediaBrowserServiceCompat.this.onGetRoot(clientPackageName, clientUid, rootHints);
            if (root == null) {
                return null;
            }
            if (rootExtras == null) {
                rootExtras = root.getExtras();
            } else if (root.getExtras() != null) {
                rootExtras.putAll(root.getExtras());
            }
            return new BrowserRoot(root.getRootId(), rootExtras);
        }

        public void onLoadChildren(String parentId, final ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(parentId, new Result<List<MediaItem>>(parentId) {
                /* access modifiers changed from: 0000 */
                public void onResultSent(List<MediaItem> list) {
                    List<Parcel> parcelList = null;
                    if (list != null) {
                        parcelList = new ArrayList<>();
                        for (MediaItem item : list) {
                            Parcel parcel = Parcel.obtain();
                            item.writeToParcel(parcel, 0);
                            parcelList.add(parcel);
                        }
                    }
                    resultWrapper.sendResult(parcelList);
                }

                public void detach() {
                    resultWrapper.detach();
                }
            });
        }
    }

    @RequiresApi(23)
    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 */
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void onLoadItem(String itemId, final ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(itemId, new Result<MediaItem>(itemId) {
                /* access modifiers changed from: 0000 */
                public void onResultSent(MediaItem item) {
                    if (item == null) {
                        resultWrapper.sendResult(null);
                        return;
                    }
                    Parcel parcelItem = Parcel.obtain();
                    item.writeToParcel(parcelItem, 0);
                    resultWrapper.sendResult(parcelItem);
                }

                public void detach() {
                    resultWrapper.detach();
                }
            });
        }
    }

    @RequiresApi(26)
    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi24 */
    class MediaBrowserServiceImplApi24 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi24.ServiceCompatProxy {
        MediaBrowserServiceImplApi24() {
            super();
        }

        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi24.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        public void notifyChildrenChanged(String parentId, Bundle options) {
            if (options == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, parentId);
            } else {
                MediaBrowserServiceCompatApi24.notifyChildrenChanged(this.mServiceObj, parentId, options);
            }
        }

        public void onLoadChildren(String parentId, final ResultWrapper resultWrapper, Bundle options) {
            MediaBrowserServiceCompat.this.onLoadChildren(parentId, new Result<List<MediaItem>>(parentId) {
                /* access modifiers changed from: 0000 */
                public void onResultSent(List<MediaItem> list) {
                    List<Parcel> parcelList = null;
                    if (list != null) {
                        parcelList = new ArrayList<>();
                        for (MediaItem item : list) {
                            Parcel parcel = Parcel.obtain();
                            item.writeToParcel(parcel, 0);
                            parcelList.add(parcel);
                        }
                    }
                    resultWrapper.sendResult(parcelList, getFlags());
                }

                public void detach() {
                    resultWrapper.detach();
                }
            }, options);
        }

        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                return MediaBrowserServiceCompatApi24.getBrowserRootHints(this.mServiceObj);
            }
            return MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase */
    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        MediaBrowserServiceImplBase() {
        }

        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        public void setSessionToken(final Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    Iterator<ConnectionRecord> iter = MediaBrowserServiceCompat.this.mConnections.values().iterator();
                    while (iter.hasNext()) {
                        ConnectionRecord connection = (ConnectionRecord) iter.next();
                        try {
                            connection.callbacks.onConnect(connection.root.getRootId(), token, connection.root.getExtras());
                        } catch (RemoteException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Connection for ");
                            sb.append(connection.pkg);
                            sb.append(" is no longer valid.");
                            Log.w(MediaBrowserServiceCompat.TAG, sb.toString());
                            iter.remove();
                        }
                    }
                }
            });
        }

        public void notifyChildrenChanged(@NonNull final String parentId, final Bundle options) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                public void run() {
                    for (IBinder binder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(binder);
                        List<Pair<IBinder, Bundle>> callbackList = (List) connection.subscriptions.get(parentId);
                        if (callbackList != null) {
                            for (Pair<IBinder, Bundle> callback : callbackList) {
                                if (MediaBrowserCompatUtils.hasDuplicatedItems(options, (Bundle) callback.second)) {
                                    MediaBrowserServiceCompat.this.performLoadChildren(parentId, connection, (Bundle) callback.second);
                                }
                            }
                        }
                    }
                }
            });
        }

        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
            } else if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$Result */
    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(Object debug) {
            this.mDebug = debug;
        }

        public void sendResult(T result) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
                sb.append(this.mDebug);
                throw new IllegalStateException(sb.toString());
            }
            this.mSendResultCalled = true;
            onResultSent(result);
        }

        public void sendProgressUpdate(Bundle extras) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
                sb.append(this.mDebug);
                throw new IllegalStateException(sb.toString());
            }
            checkExtraFields(extras);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(extras);
        }

        public void sendError(Bundle extras) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendError() called when either sendResult() or sendError() had already been called for: ");
                sb.append(this.mDebug);
                throw new IllegalStateException(sb.toString());
            }
            this.mSendErrorCalled = true;
            onErrorSent(extras);
        }

        public void detach() {
            if (this.mDetachCalled) {
                StringBuilder sb = new StringBuilder();
                sb.append("detach() called when detach() had already been called for: ");
                sb.append(this.mDebug);
                throw new IllegalStateException(sb.toString());
            } else if (this.mSendResultCalled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detach() called when sendResult() had already been called for: ");
                sb2.append(this.mDebug);
                throw new IllegalStateException(sb2.toString());
            } else if (!this.mSendErrorCalled) {
                this.mDetachCalled = true;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("detach() called when sendError() had already been called for: ");
                sb3.append(this.mDebug);
                throw new IllegalStateException(sb3.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        /* access modifiers changed from: 0000 */
        public void setFlags(int flags) {
            this.mFlags = flags;
        }

        /* access modifiers changed from: 0000 */
        public int getFlags() {
            return this.mFlags;
        }

        /* access modifiers changed from: 0000 */
        public void onResultSent(T t) {
        }

        /* access modifiers changed from: 0000 */
        public void onProgressUpdateSent(Bundle extras) {
            StringBuilder sb = new StringBuilder();
            sb.append("It is not supported to send an interim update for ");
            sb.append(this.mDebug);
            throw new UnsupportedOperationException(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        public void onErrorSent(Bundle extras) {
            StringBuilder sb = new StringBuilder();
            sb.append("It is not supported to send an error for ");
            sb.append(this.mDebug);
            throw new UnsupportedOperationException(sb.toString());
        }

        private void checkExtraFields(Bundle extras) {
            if (extras != null) {
                String str = MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS;
                if (extras.containsKey(str)) {
                    float value = extras.getFloat(str);
                    if (value < -1.0E-5f || value > 1.00001f) {
                        throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                    }
                }
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ResultFlags */
    private @interface ResultFlags {
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ServiceBinderImpl */
    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void connect(String pkg, int uid, Bundle rootHints, ServiceCallbacks callbacks) {
            if (MediaBrowserServiceCompat.this.isValidPackage(pkg, uid)) {
                ServiceHandler serviceHandler = MediaBrowserServiceCompat.this.mHandler;
                final ServiceCallbacks serviceCallbacks = callbacks;
                final String str = pkg;
                final Bundle bundle = rootHints;
                final int i = uid;
                C01541 r1 = new Runnable() {
                    public void run() {
                        IBinder b = serviceCallbacks.asBinder();
                        MediaBrowserServiceCompat.this.mConnections.remove(b);
                        ConnectionRecord connection = new ConnectionRecord();
                        connection.pkg = str;
                        connection.rootHints = bundle;
                        connection.callbacks = serviceCallbacks;
                        connection.root = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
                        BrowserRoot browserRoot = connection.root;
                        String str = MediaBrowserServiceCompat.TAG;
                        if (browserRoot == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("No root for client ");
                            sb.append(str);
                            sb.append(" from service ");
                            sb.append(getClass().getName());
                            Log.i(str, sb.toString());
                            try {
                                serviceCallbacks.onConnectFailed();
                            } catch (RemoteException e) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                                sb2.append(str);
                                Log.w(str, sb2.toString());
                            }
                        } else {
                            try {
                                MediaBrowserServiceCompat.this.mConnections.put(b, connection);
                                if (MediaBrowserServiceCompat.this.mSession != null) {
                                    serviceCallbacks.onConnect(connection.root.getRootId(), MediaBrowserServiceCompat.this.mSession, connection.root.getExtras());
                                }
                            } catch (RemoteException e2) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Calling onConnect() failed. Dropping client. pkg=");
                                sb3.append(str);
                                Log.w(str, sb3.toString());
                                MediaBrowserServiceCompat.this.mConnections.remove(b);
                            }
                        }
                    }
                };
                serviceHandler.postOrRun(r1);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Package/uid mismatch: uid=");
            sb.append(uid);
            sb.append(" package=");
            sb.append(pkg);
            throw new IllegalArgumentException(sb.toString());
        }

        public void disconnect(final ServiceCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.remove(callbacks.asBinder());
                }
            });
        }

        public void addSubscription(String id, IBinder token, Bundle options, ServiceCallbacks callbacks) {
            ServiceHandler serviceHandler = MediaBrowserServiceCompat.this.mHandler;
            final ServiceCallbacks serviceCallbacks = callbacks;
            final String str = id;
            final IBinder iBinder = token;
            final Bundle bundle = options;
            C01563 r1 = new Runnable() {
                public void run() {
                    ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                    if (connection == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("addSubscription for callback that isn't registered id=");
                        sb.append(str);
                        Log.w(MediaBrowserServiceCompat.TAG, sb.toString());
                        return;
                    }
                    MediaBrowserServiceCompat.this.addSubscription(str, connection, iBinder, bundle);
                }
            };
            serviceHandler.postOrRun(r1);
        }

        public void removeSubscription(final String id, final IBinder token, final ServiceCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(callbacks.asBinder());
                    String str = MediaBrowserServiceCompat.TAG;
                    if (connection == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("removeSubscription for callback that isn't registered id=");
                        sb.append(id);
                        Log.w(str, sb.toString());
                        return;
                    }
                    if (!MediaBrowserServiceCompat.this.removeSubscription(id, connection, token)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("removeSubscription called for ");
                        sb2.append(id);
                        sb2.append(" which is not subscribed");
                        Log.w(str, sb2.toString());
                    }
                }
            });
        }

        public void getMediaItem(final String mediaId, final ResultReceiver receiver, final ServiceCallbacks callbacks) {
            if (!TextUtils.isEmpty(mediaId) && receiver != null) {
                MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                    public void run() {
                        ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(callbacks.asBinder());
                        if (connection == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("getMediaItem for callback that isn't registered id=");
                            sb.append(mediaId);
                            Log.w(MediaBrowserServiceCompat.TAG, sb.toString());
                            return;
                        }
                        MediaBrowserServiceCompat.this.performLoadItem(mediaId, connection, receiver);
                    }
                });
            }
        }

        public void registerCallbacks(final ServiceCallbacks callbacks, final Bundle rootHints) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    IBinder b = callbacks.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(b);
                    ConnectionRecord connection = new ConnectionRecord();
                    connection.callbacks = callbacks;
                    connection.rootHints = rootHints;
                    MediaBrowserServiceCompat.this.mConnections.put(b, connection);
                }
            });
        }

        public void unregisterCallbacks(final ServiceCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
                public void run() {
                    MediaBrowserServiceCompat.this.mConnections.remove(callbacks.asBinder());
                }
            });
        }

        public void search(String query, Bundle extras, ResultReceiver receiver, ServiceCallbacks callbacks) {
            if (!TextUtils.isEmpty(query) && receiver != null) {
                ServiceHandler serviceHandler = MediaBrowserServiceCompat.this.mHandler;
                final ServiceCallbacks serviceCallbacks = callbacks;
                final String str = query;
                final Bundle bundle = extras;
                final ResultReceiver resultReceiver = receiver;
                C01618 r1 = new Runnable() {
                    public void run() {
                        ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                        if (connection == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("search for callback that isn't registered query=");
                            sb.append(str);
                            Log.w(MediaBrowserServiceCompat.TAG, sb.toString());
                            return;
                        }
                        MediaBrowserServiceCompat.this.performSearch(str, bundle, connection, resultReceiver);
                    }
                };
                serviceHandler.postOrRun(r1);
            }
        }

        public void sendCustomAction(String action, Bundle extras, ResultReceiver receiver, ServiceCallbacks callbacks) {
            if (!TextUtils.isEmpty(action) && receiver != null) {
                ServiceHandler serviceHandler = MediaBrowserServiceCompat.this.mHandler;
                final ServiceCallbacks serviceCallbacks = callbacks;
                final String str = action;
                final Bundle bundle = extras;
                final ResultReceiver resultReceiver = receiver;
                C01629 r1 = new Runnable() {
                    public void run() {
                        ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.asBinder());
                        if (connection == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("sendCustomAction for callback that isn't registered action=");
                            sb.append(str);
                            sb.append(", extras=");
                            sb.append(bundle);
                            Log.w(MediaBrowserServiceCompat.TAG, sb.toString());
                            return;
                        }
                        MediaBrowserServiceCompat.this.performCustomAction(str, bundle, connection, resultReceiver);
                    }
                };
                serviceHandler.postOrRun(r1);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacks */
    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaItem> list, Bundle bundle) throws RemoteException;
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ServiceCallbacksCompat */
    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger callbacks) {
            this.mCallbacks = callbacks;
        }

        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        public void onConnect(String root, Token session, Bundle extras) throws RemoteException {
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 1);
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, root);
            data.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, session);
            data.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, extras);
            sendRequest(1, data);
        }

        public void onConnectFailed() throws RemoteException {
            sendRequest(2, null);
        }

        public void onLoadChildren(String mediaId, List<MediaItem> list, Bundle options) throws RemoteException {
            Bundle data = new Bundle();
            data.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, mediaId);
            data.putBundle(MediaBrowserProtocol.DATA_OPTIONS, options);
            if (list != null) {
                data.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            sendRequest(3, data);
        }

        private void sendRequest(int what, Bundle data) throws RemoteException {
            Message msg = Message.obtain();
            msg.what = what;
            msg.arg1 = 1;
            msg.setData(data);
            this.mCallbacks.send(msg);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ServiceHandler */
    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl = new ServiceBinderImpl();

        ServiceHandler() {
        }

        public void handleMessage(Message msg) {
            Bundle data = msg.getData();
            int i = msg.what;
            String str = MediaBrowserProtocol.DATA_CALLBACK_TOKEN;
            String str2 = MediaBrowserProtocol.DATA_ROOT_HINTS;
            String str3 = MediaBrowserProtocol.DATA_RESULT_RECEIVER;
            String str4 = MediaBrowserProtocol.DATA_MEDIA_ITEM_ID;
            switch (i) {
                case 1:
                    this.mServiceBinderImpl.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), data.getBundle(str2), new ServiceCallbacksCompat(msg.replyTo));
                    return;
                case 2:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(msg.replyTo));
                    return;
                case 3:
                    this.mServiceBinderImpl.addSubscription(data.getString(str4), BundleCompat.getBinder(data, str), data.getBundle(MediaBrowserProtocol.DATA_OPTIONS), new ServiceCallbacksCompat(msg.replyTo));
                    return;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(str4), BundleCompat.getBinder(data, str), new ServiceCallbacksCompat(msg.replyTo));
                    return;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(str4), (ResultReceiver) data.getParcelable(str3), new ServiceCallbacksCompat(msg.replyTo));
                    return;
                case 6:
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(msg.replyTo), data.getBundle(str2));
                    return;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(msg.replyTo));
                    return;
                case 8:
                    this.mServiceBinderImpl.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS), (ResultReceiver) data.getParcelable(str3), new ServiceCallbacksCompat(msg.replyTo));
                    return;
                case 9:
                    this.mServiceBinderImpl.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS), (ResultReceiver) data.getParcelable(str3), new ServiceCallbacksCompat(msg.replyTo));
                    return;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unhandled message: ");
                    sb.append(msg);
                    sb.append("\n  Service version: ");
                    sb.append(1);
                    sb.append("\n  Client version: ");
                    sb.append(msg.arg1);
                    Log.w(MediaBrowserServiceCompat.TAG, sb.toString());
                    return;
            }
        }

        public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
            Bundle data = msg.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            return super.sendMessageAtTime(msg, uptimeMillis);
        }

        public void postOrRun(Runnable r) {
            if (Thread.currentThread() == getLooper().getThread()) {
                r.run();
            } else {
                post(r);
            }
        }
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaItem>> result);

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserServiceImplApi24();
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserServiceImplApi23();
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserServiceImplApi21();
        } else {
            this.mImpl = new MediaBrowserServiceImplBase();
        }
        this.mImpl.onCreate();
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
    }

    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaItem>> result, @NonNull Bundle options) {
        result.setFlags(1);
        onLoadChildren(parentId, result);
    }

    public void onLoadItem(String itemId, @NonNull Result<MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(@NonNull String query, Bundle extras, @NonNull Result<List<MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    public void onCustomAction(@NonNull String action, Bundle extras, @NonNull Result<Bundle> result) {
        result.sendError(null);
    }

    public void setSessionToken(Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.mSession == null) {
            this.mSession = token;
            this.mImpl.setSessionToken(token);
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }

    @Nullable
    public Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public void notifyChildrenChanged(@NonNull String parentId) {
        if (parentId != null) {
            this.mImpl.notifyChildrenChanged(parentId, null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(@NonNull String parentId, @NonNull Bundle options) {
        if (parentId == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (options != null) {
            this.mImpl.notifyChildrenChanged(parentId, options);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isValidPackage(String pkg, int uid) {
        if (pkg == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(uid)) {
            if (equals.equals(pkg)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void addSubscription(String id, ConnectionRecord connection, IBinder token, Bundle options) {
        List<Pair<IBinder, Bundle>> list = (List) connection.subscriptions.get(id);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair<IBinder, Bundle> callback : list) {
            if (token == callback.first && MediaBrowserCompatUtils.areSameOptions(options, (Bundle) callback.second)) {
                return;
            }
        }
        list.add(new Pair(token, options));
        connection.subscriptions.put(id, list);
        performLoadChildren(id, connection, options);
    }

    /* access modifiers changed from: 0000 */
    public boolean removeSubscription(String id, ConnectionRecord connection, IBinder token) {
        if (token == null) {
            return connection.subscriptions.remove(id) != null;
        }
        boolean removed = false;
        List<Pair<IBinder, Bundle>> callbackList = (List) connection.subscriptions.get(id);
        if (callbackList != null) {
            Iterator<Pair<IBinder, Bundle>> iter = callbackList.iterator();
            while (iter.hasNext()) {
                if (token == ((Pair) iter.next()).first) {
                    removed = true;
                    iter.remove();
                }
            }
            if (callbackList.size() == 0) {
                connection.subscriptions.remove(id);
            }
        }
        return removed;
    }

    /* access modifiers changed from: 0000 */
    public void performLoadChildren(String parentId, ConnectionRecord connection, Bundle options) {
        final ConnectionRecord connectionRecord = connection;
        final String str = parentId;
        final Bundle bundle = options;
        C01431 r0 = new Result<List<MediaItem>>(parentId) {
            /* access modifiers changed from: 0000 */
            public void onResultSent(List<MediaItem> list) {
                Object obj = MediaBrowserServiceCompat.this.mConnections.get(connectionRecord.callbacks.asBinder());
                ConnectionRecord connectionRecord = connectionRecord;
                String str = MediaBrowserServiceCompat.TAG;
                if (obj != connectionRecord) {
                    if (MediaBrowserServiceCompat.DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                        sb.append(connectionRecord.pkg);
                        sb.append(" id=");
                        sb.append(str);
                        Log.d(str, sb.toString());
                    }
                    return;
                }
                try {
                    connectionRecord.callbacks.onLoadChildren(str, (getFlags() & 1) != 0 ? MediaBrowserServiceCompat.this.applyOptions(list, bundle) : list, bundle);
                } catch (RemoteException e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calling onLoadChildren() failed for id=");
                    sb2.append(str);
                    sb2.append(" package=");
                    sb2.append(connectionRecord.pkg);
                    Log.w(str, sb2.toString());
                }
            }
        };
        this.mCurConnection = connection;
        if (options == null) {
            onLoadChildren(parentId, r0);
        } else {
            onLoadChildren(parentId, r0, options);
        }
        this.mCurConnection = null;
        if (!r0.isDone()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadChildren must call detach() or sendResult() before returning for package=");
            sb.append(connection.pkg);
            sb.append(" id=");
            sb.append(parentId);
            throw new IllegalStateException(sb.toString());
        }
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

    /* access modifiers changed from: 0000 */
    public void performLoadItem(String itemId, ConnectionRecord connection, final ResultReceiver receiver) {
        Result<MediaItem> result = new Result<MediaItem>(itemId) {
            /* access modifiers changed from: 0000 */
            public void onResultSent(MediaItem item) {
                if ((getFlags() & 2) != 0) {
                    receiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, item);
                receiver.send(0, bundle);
            }
        };
        this.mCurConnection = connection;
        onLoadItem(itemId, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadItem must call detach() or sendResult() before returning for id=");
            sb.append(itemId);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void performSearch(String query, Bundle extras, ConnectionRecord connection, final ResultReceiver receiver) {
        Result<List<MediaItem>> result = new Result<List<MediaItem>>(query) {
            /* access modifiers changed from: 0000 */
            public void onResultSent(List<MediaItem> items) {
                if ((getFlags() & 4) != 0 || items == null) {
                    receiver.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) items.toArray(new MediaItem[0]));
                receiver.send(0, bundle);
            }
        };
        this.mCurConnection = connection;
        onSearch(query, extras, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSearch must call detach() or sendResult() before returning for query=");
            sb.append(query);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void performCustomAction(String action, Bundle extras, ConnectionRecord connection, final ResultReceiver receiver) {
        Result<Bundle> result = new Result<Bundle>(action) {
            /* access modifiers changed from: 0000 */
            public void onResultSent(Bundle result) {
                receiver.send(0, result);
            }

            /* access modifiers changed from: 0000 */
            public void onProgressUpdateSent(Bundle data) {
                receiver.send(1, data);
            }

            /* access modifiers changed from: 0000 */
            public void onErrorSent(Bundle data) {
                receiver.send(-1, data);
            }
        };
        this.mCurConnection = connection;
        onCustomAction(action, extras, result);
        this.mCurConnection = null;
        if (!result.isDone()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
            sb.append(action);
            sb.append(" extras=");
            sb.append(extras);
            throw new IllegalStateException(sb.toString());
        }
    }
}
