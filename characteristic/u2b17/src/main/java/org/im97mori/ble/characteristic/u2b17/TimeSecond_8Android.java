package org.im97mori.ble.characteristic.u2b17;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_SECOND_8_CHARACTERISTIC;

/**
 * Time Second 8 (Characteristics UUID: 0x2B17)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeSecond_8Android extends TimeSecond_8 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeSecond_8Android> CREATOR = new ByteArrayCreater<TimeSecond_8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond_8Android createFromParcel(@NonNull Parcel in) {
            return new TimeSecond_8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond_8Android[] newArray(int size) {
            return new TimeSecond_8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeSecond_8Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_SECOND_8_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeSecond_8Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B17
     */
    public TimeSecond_8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeSecond_8Android(@NonNull Parcel in) {
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
