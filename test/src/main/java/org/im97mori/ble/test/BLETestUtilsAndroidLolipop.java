package org.im97mori.ble.test;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressWarnings("unused")
public class BLETestUtilsAndroidLolipop extends BLETestUtilsAndroid {

    public static ScanResult createScanResult(@NonNull BluetoothDevice device
            , int eventType
            , int primaryPhy
            , int secondaryPhy
            , int advertisingSid
            , int txPower
            , int rssi
            , int periodicAdvertisingInterval
            , @Nullable ScanRecord scanRecord
            , long timestampNanos) {
        ScanResult scanResult = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            scanResult = new ScanResult(device
                    , eventType
                    , primaryPhy
                    , secondaryPhy
                    , advertisingSid
                    , txPower
                    , rssi
                    , periodicAdvertisingInterval
                    , scanRecord
                    , timestampNanos);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            scanResult = new ScanResult(device, scanRecord, rssi, timestampNanos);
        }
        return scanResult;
    }

}
