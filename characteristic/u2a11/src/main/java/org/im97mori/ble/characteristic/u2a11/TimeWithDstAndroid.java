package org.im97mori.ble.characteristic.u2a11;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_WITH_DST_CHARACTERISTIC;

/**
 * Time with DST (Characteristics UUID: 0x2A11)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TimeWithDstAndroid extends TimeWithDst implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeWithDstAndroid> CREATOR = new ByteArrayCreater<TimeWithDstAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeWithDstAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeWithDstAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeWithDstAndroid[] newArray(int size) {
            return new TimeWithDstAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeWithDstAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_WITH_DST_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeWithDstAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A11
     */
    public TimeWithDstAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TimeWithDstAndroid(@NonNull Parcel in) {
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
