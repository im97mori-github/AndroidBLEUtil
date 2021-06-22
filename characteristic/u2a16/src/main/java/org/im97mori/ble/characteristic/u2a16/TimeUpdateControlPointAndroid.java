package org.im97mori.ble.characteristic.u2a16;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;

/**
 * Time Update Control Point (Characteristics UUID: 0x2A16)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeUpdateControlPointAndroid extends TimeUpdateControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeUpdateControlPointAndroid> CREATOR = new ByteArrayCreater<TimeUpdateControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeUpdateControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateControlPointAndroid[] newArray(int size) {
            return new TimeUpdateControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeUpdateControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeUpdateControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A16
     */
    public TimeUpdateControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param timeUpdateControlPoint Time Update Control Point
     */
    public TimeUpdateControlPointAndroid(int timeUpdateControlPoint) {
        super(timeUpdateControlPoint);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeUpdateControlPointAndroid(@NonNull Parcel in) {
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
