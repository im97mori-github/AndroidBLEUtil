package org.im97mori.ble_peripheral;

import android.util.Log;

import androidx.annotation.NonNull;

import org.im97mori.stacklog.LogUtils;

/**
 * Output log when {@link BuildConfig#DEBUG} == {@code true}
 */
@SuppressWarnings({"unused"})
public class BLEPeripheralLogUtils {

    /**
     * @see LogUtils#stackLog(Object...)
     */
    public static void stackLog(@NonNull Object... args) {
        if (BuildConfig.DEBUG) {
            LogUtils.stackLogWithOffset(1, args);
        }
    }

    /**
     * @see LogUtils#stackLog(Object...)
     */
    public static void stackLog(@NonNull Throwable t) {
        if (BuildConfig.DEBUG) {
            LogUtils.stackLogWithOffset(1, Log.getStackTraceString(t));
        }
    }

}
