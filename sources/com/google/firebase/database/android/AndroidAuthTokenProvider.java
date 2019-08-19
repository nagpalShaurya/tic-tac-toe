package com.google.firebase.database.android;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp.IdTokenListener;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener;
import com.google.firebase.database.core.AuthTokenProvider.TokenChangeListener;
import com.google.firebase.internal.InternalTokenResult;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class AndroidAuthTokenProvider implements AuthTokenProvider {
    /* access modifiers changed from: private */
    public final ScheduledExecutorService executorService;
    private final FirebaseApp firebaseApp;

    public AndroidAuthTokenProvider(@NonNull FirebaseApp firebaseApp2, @NonNull ScheduledExecutorService executorService2) {
        this.firebaseApp = firebaseApp2;
        this.executorService = executorService2;
    }

    public void getToken(boolean forceRefresh, @NonNull final GetTokenCompletionListener listener) {
        this.firebaseApp.getToken(forceRefresh).addOnSuccessListener((Executor) this.executorService, (OnSuccessListener<? super TResult>) new OnSuccessListener<GetTokenResult>() {
            public void onSuccess(GetTokenResult result) {
                listener.onSuccess(result.getToken());
            }
        }).addOnFailureListener((Executor) this.executorService, (OnFailureListener) new OnFailureListener() {
            public void onFailure(@NonNull Exception e) {
                if (isUnauthenticatedUsage(e)) {
                    listener.onSuccess(null);
                } else {
                    listener.onError(e.getMessage());
                }
            }

            private boolean isUnauthenticatedUsage(Exception e) {
                if ((e instanceof FirebaseApiNotAvailableException) || (e instanceof FirebaseNoSignedInUserException)) {
                    return true;
                }
                return false;
            }
        });
    }

    public void addTokenChangeListener(TokenChangeListener tokenListener) {
        this.firebaseApp.addIdTokenListener(produceIdTokenListener(tokenListener));
    }

    private IdTokenListener produceIdTokenListener(final TokenChangeListener tokenListener) {
        return new IdTokenListener() {
            public void onIdTokenChanged(@NonNull final InternalTokenResult tokenResult) {
                AndroidAuthTokenProvider.this.executorService.execute(new Runnable() {
                    public void run() {
                        tokenListener.onTokenChange(tokenResult.getToken());
                    }
                });
            }
        };
    }

    public void removeTokenChangeListener(TokenChangeListener tokenListener) {
    }
}
