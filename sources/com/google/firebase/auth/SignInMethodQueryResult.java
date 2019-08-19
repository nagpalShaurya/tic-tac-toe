package com.google.firebase.auth;

import android.support.annotation.Nullable;
import java.util.List;

public interface SignInMethodQueryResult {
    @Nullable
    List<String> getSignInMethods();
}
