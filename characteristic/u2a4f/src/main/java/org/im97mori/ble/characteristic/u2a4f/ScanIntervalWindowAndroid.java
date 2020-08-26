package org.im97mori.ble.characteristic.u2a4f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SCAN_INTERVAL_WINDOW_CHARACTERISTIC;

/**
 * Scan Interval Window (Characteristics UUID: 0x2A4F)
 */
@SuppressWarnings({"WeakerAccess"})
public class ScanIntervalWindowAndroid extends ScanIntervalWindow implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ScanIntervalWindowAndroid> CREATOR = new ByteArrayCreater<ScanIntervalWindowAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanIntervalWindowAndroid createFromParcel(@NonNull Parcel in) {
            return new ScanIntervalWindowAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanIntervalWindowAndroid[] newArray(int size) {
            return new ScanIntervalWindowAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ScanIntervalWindowAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SCAN_INTERVAL_WINDOW_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ScanIntervalWindowAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4F
     */
    public ScanIntervalWindowAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param leScanInterval LE_Scan_Interval
     * @param leScanWindow   LE_Scan_Window
     */
    public ScanIntervalWindowAndroid(int leScanInterval, int leScanWindow) {
        super(leScanInterval, leScanWindow);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ScanIntervalWindowAndroid(@NonNull Parcel in) {
        super(in.createByteArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeByteArray(getBytes());
    }

}
