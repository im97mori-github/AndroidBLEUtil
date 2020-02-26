package org.im97mori.ble.characteristic.u2a4b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REPORT_MAP_CHARACTERISTIC;

/**
 * Report Map (Characteristics UUID: 0x2A4B)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ReportMapAndroid extends ReportMap implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReportMapAndroid> CREATOR = new ByteArrayCreater<ReportMapAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportMapAndroid createFromParcel(@NonNull Parcel in) {
            return new ReportMapAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportMapAndroid[] newArray(int size) {
            return new ReportMapAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReportMapAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(REPORT_MAP_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ReportMapAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4B
     */
    public ReportMapAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ReportMapAndroid(@NonNull Parcel in) {
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
