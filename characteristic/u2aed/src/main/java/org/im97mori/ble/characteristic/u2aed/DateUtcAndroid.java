package org.im97mori.ble.characteristic.u2aed;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.DATE_UTC_CHARACTERISTIC;

/**
 * Date UTC (Characteristics UUID: 0x2AED)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DateUtcAndroid extends DateUtc implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DateUtcAndroid> CREATOR = new ByteArrayCreater<DateUtcAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateUtcAndroid createFromParcel(@NonNull Parcel in) {
            return new DateUtcAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateUtcAndroid[] newArray(int size) {
            return new DateUtcAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DateUtcAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATE_UTC_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DateUtcAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AED
     */
    public DateUtcAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DateUtcAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
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
