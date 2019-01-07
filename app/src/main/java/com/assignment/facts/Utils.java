package com.assignment.facts;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * A utility class.
 */
public class Utils {
    private static Utils sInstance = null;

    /**
     * Returns an instance of utility class.
     *
     * @return The singleton utility
     */
    public static synchronized Utils getInstance() {
        if (sInstance == null) {
            synchronized (Utils.class) {
                if (sInstance == null) {
                    sInstance = new Utils();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the base url
     *
     * @retrun baseUrl
     */
    public String getBaseUrl() {
        return Constants.getBaseUrl();
    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
