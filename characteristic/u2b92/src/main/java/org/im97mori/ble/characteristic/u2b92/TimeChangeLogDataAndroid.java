package org.im97mori.ble.characteristic.u2b92;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_CHANGE_LOG_DATA_CHARACTERISTIC;

/**
 * Time Change Log Data (Characteristics UUID: 0x2B92)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeChangeLogDataAndroid extends TimeChangeLogData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeChangeLogDataAndroid> CREATOR = new ByteArrayCreator<TimeChangeLogDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeChangeLogDataAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeChangeLogDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeChangeLogDataAndroid[] newArray(int size) {
            return new TimeChangeLogDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeChangeLogDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_CHANGE_LOG_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeChangeLogDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B92
     */
    public TimeChangeLogDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeChangeLogDataAndroid(@NonNull Parcel in) {
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
