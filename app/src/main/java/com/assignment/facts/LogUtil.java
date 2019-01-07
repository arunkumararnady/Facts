package com.assignment.facts;

import android.util.Log;

public class LogUtil {

    /**
     * Logs error by printing the tag that contains the name of the class where the exception is thrown, message and the
     * exception trace.
     *
     * @param tag
     *     A tag to associate with the log.
     * @param message
     *     Message associated with the log.
     */
    public static synchronized void error(String tag, final String message) {
        Log.e(tag, message);
    }

    /**
     * Logs an info message. Use this to report on status of operations such as successfully connecting to a server.
     *
     * @param tag
     *     A tag to associate with the log.
     * @param log
     *     the message you want to log.
     */
    public static synchronized void info(String tag, final String log) {
        Log.i(tag, log);
    }

    /**
     * Logs a debug message. Use this when you wish to make a record of variable information or chart the flow of an app.
     *
     * @param tag
     *     A tag associated with the log.
     * @param msg
     *     message
     */
    public static synchronized void debug(String tag, final String msg) {
        Log.d(tag, msg);
    }
}
