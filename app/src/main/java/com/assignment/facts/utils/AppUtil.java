package com.assignment.facts.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * A utility class.
 */
public class AppUtil {
    private static AppUtil sInstance = null;

    /**
     * Returns an instance of utility class.
     *
     * @return The singleton utility
     */
    public static synchronized AppUtil getInstance() {
        if (sInstance == null) {
            synchronized (AppUtil.class) {
                if (sInstance == null) {
                    sInstance = new AppUtil();
                }
            }
        }
        return sInstance;
    }

    /**
     * Check whether the device is online
     *
     * @retrun true if the device is online, false otherwise
     */
    public boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
