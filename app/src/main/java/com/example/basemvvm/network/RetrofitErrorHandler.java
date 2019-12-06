package com.example.basemvvm.network;

import android.support.annotation.StringRes;

import com.example.basemvvm.R;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;


class RetrofitErrorHandler {
    @SuppressWarnings("WeakerAccess")
    public static @StringRes int getError(Throwable error){
        if (error instanceof TimeoutException || error instanceof InterruptedIOException)
            return R.string.time_out_error;
        else if (error instanceof ConnectException)
            return R.string.connection_error;
        else if (error instanceof NoSuchElementException)
            return R.string.single_no_item_emitted_error;
        else if (error instanceof IllegalArgumentException)
            return R.string.data_receive_error;
        else
            return R.string.server_error;
    }
}
