package org.im97mori.ble.characteristic.u2b16;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_SECOND_16_CHARACTERISTIC;

/**
 * Time Second 16 (Characteristics UUID: 0x2B16)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeSecond_16Android extends TimeSecond_16 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeSecond_16Android> CREATOR = new ByteArrayCreater<TimeSecond_16Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond_16Android createFromParcel(@NonNull Parcel in) {
            return new TimeSecond_16Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond_16Android[] newArray(int size) {
            return new TimeSecond_16Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeSecond_16Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_SECOND_16_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeSecond_16Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B16
     */
    public TimeSecond_16Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeSecond_16Android(@NonNull Parcel in) {
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
