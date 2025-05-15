package com.example.proyecto24022025;

import android.os.Build;
import android.window.OnBackInvokedCallback;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
public class NonBackActivity implements OnBackInvokedCallback {

    public NonBackActivity(){

    }

    @Override
    public void registerOnBackInvokedCallback(int priority, @NonNull OnBackInvokedCallback) {

    }

    @Override
    public void unregisterOnBackInvokedCallBack(@NonNull OnBackInvokedCallback callback){

    }
}
