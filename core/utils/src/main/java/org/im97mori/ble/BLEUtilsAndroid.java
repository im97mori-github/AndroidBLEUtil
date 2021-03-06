package org.im97mori.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Parcel;
import android.util.Log;

import androidx.annotation.NonNull;

import org.im97mori.stacklog.LogUtils;

import java.lang.reflect.Method;

/**
 * BLE Core Utilities for Android
 */

public class BLEUtilsAndroid extends BLEUtils {

    /**
     * check bluetooth status
     *
     * @return {@code true}:bluetooth enabled, {@code false}:bluetooth disabled or no bluetooth feature
     */
    @SuppressLint("MissingPermission")
    public static boolean isBluetoothEnabled() {
        boolean result = false;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            result = bluetoothAdapter.isEnabled();
        }
        return result;
    }

    /**
     * convinience method for {@link BluetoothAdapter#enable()}
     *
     * @return return value of {@link BluetoothAdapter#enable()} or {@code false}:no bluetooth feature
     */
    @SuppressLint("MissingPermission")
    public static boolean bluetoothEnable() {
        boolean result = false;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            result = bluetoothAdapter.enable();
        }
        return result;
    }

    /**
     * convinience method for {@link BluetoothAdapter#disable()}
     *
     * @return return value of {@link BluetoothAdapter#disable()} or {@code false}:no bluetooth feature
     */
    @SuppressLint("MissingPermission")
    public static boolean bluetoothDisable() {
        boolean result = false;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            result = bluetoothAdapter.disable();
        }
        return result;
    }

    /**
     * convinience method for get descriptor's instance id
     *
     * @param bluetoothGattDescriptor {@link BluetoothGattDescriptor} instance
     * @return descriptor instance id(like {@link BluetoothGattService#getInstanceId()} or {@link BluetoothGattCharacteristic#getInstanceId()})
     */
    @SuppressWarnings({"JavaReflectionMemberAccess", "ConstantConditions"})
    @SuppressLint({"SoonBlockedPrivateApi", "DiscouragedPrivateApi"})
    public static int getDescriptorInstanceId(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        int descriptorInstanceId;
        if (Build.VERSION_CODES.N <= Build.VERSION.SDK_INT) {
            Parcel parcel = Parcel.obtain();
            bluetoothGattDescriptor.writeToParcel(parcel, 0);
            parcel.setDataPosition(0);
            parcel.readParcelable(bluetoothGattDescriptor.getClass().getClassLoader());
            descriptorInstanceId = parcel.readInt();
            parcel.recycle();
        } else {
            try {
                Method method = BluetoothGattDescriptor.class.getDeclaredMethod("getInstanceId");
                descriptorInstanceId = (int) method.invoke(bluetoothGattDescriptor);
            } catch (Exception e) {
                LogUtils.stackLog(Log.getStackTraceString(e));
                descriptorInstanceId = 0;
            }
        }
        return descriptorInstanceId;
    }

}
