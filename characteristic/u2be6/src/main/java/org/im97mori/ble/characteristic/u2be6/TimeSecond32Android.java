package org.im97mori.ble.characteristic.u2be6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_SECOND_32_CHARACTERISTIC;

/**
 * Time Second 32 (Characteristics UUID: 0x2BE6)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeSecond32Android extends TimeSecond32 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeSecond32Android> CREATOR = new ByteArrayCreator<TimeSecond32Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond32Android createFromParcel(@NonNull Parcel in) {
            return new TimeSecond32Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeSecond32Android[] newArray(int size) {
            return new TimeSecond32Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeSecond32Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_SECOND_32_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeSecond32Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE6
     */
    public TimeSecond32Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeSecond32Android(@NonNull Parcel in) {
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
