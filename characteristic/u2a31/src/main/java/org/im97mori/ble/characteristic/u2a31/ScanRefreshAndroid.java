package org.im97mori.ble.characteristic.u2a31;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SCAN_REFRESH_CHARACTERISTIC;

/**
 * Scan Refresh (Characteristics UUID: 0x2A31)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ScanRefreshAndroid extends ScanRefresh implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ScanRefreshAndroid> CREATOR = new ByteArrayCreater<ScanRefreshAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanRefreshAndroid createFromParcel(@NonNull Parcel in) {
            return new ScanRefreshAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanRefreshAndroid[] newArray(int size) {
            return new ScanRefreshAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ScanRefreshAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SCAN_REFRESH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ScanRefreshAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A31
     */
    public ScanRefreshAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param scanRefreshValue Scan Refresh Value
     */
    public ScanRefreshAndroid(int scanRefreshValue) {
        super(scanRefreshValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ScanRefreshAndroid(@NonNull Parcel in) {
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
