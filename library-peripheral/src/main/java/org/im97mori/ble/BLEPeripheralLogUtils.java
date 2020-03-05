package org.im97mori.ble;

import android.util.Log;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.BLEAdvertisingLogUtils;
import org.im97mori.ble.peripheral.BuildConfig;
import org.im97mori.stacklog.LogUtils;

/**
 * Output log when {@link BuildConfig#DEBUG} == {@code true}
 */
@SuppressWarnings({"unused"})
public class BLEPeripheralLogUtils {

    /**
     * verbose mode
     */
    private static boolean VERBOSE = false;

    /**
     * enable verbose mode
     */
    public static void verbose() {
        VERBOSE = true;
        BLEAdvertisingLogUtils.verbose();
    }

    /**
     * disable verbose mode
     */
    public static void mute() {
        VERBOSE = false;
        BLEAdvertisingLogUtils.mute();
    }

    /**
     * @see LogUtils#stackLog(Object...)
     */
    public static void stackLog(@NonNull Object... args) {
        if (BuildConfig.DEBUG || VERBOSE) {
            LogUtils.stackLogWithOffset(1, args);
        }
    }

    /**
     * @see LogUtils#stackLog(Object...)
     */
    public static void stackLog(@NonNull Throwable t) {
        if (BuildConfig.DEBUG || VERBOSE) {
            LogUtils.stackLogWithOffset(1, Log.getStackTraceString(t));
        }
    }

}
