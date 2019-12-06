package com.example.basemvvm.utils;

import android.util.Patterns;

public class Utils {
    public static boolean isPhoneValid(String phone) {
        return phone.startsWith("09") && phone.length() >= 11 && Patterns.PHONE.matcher(phone).matches();
    }
}
