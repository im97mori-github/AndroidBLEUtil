package org.im97mori.ble.characteristic.u2a12;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_ACCURACY_CHARACTERISTIC;

/**
 * Time Accuracy (Characteristics UUID: 0x2A12)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeAccuracyAndroid extends TimeAccuracy implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeAccuracyAndroid> CREATOR = new ByteArrayCreator<TimeAccuracyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeAccuracyAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeAccuracyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeAccuracyAndroid[] newArray(int size) {
            return new TimeAccuracyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeAccuracyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_ACCURACY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A12
     */
    public TimeAccuracyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param accuracy Accuracy
     */
    public TimeAccuracyAndroid(int accuracy) {
        super(accuracy);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeAccuracyAndroid(@NonNull Parcel in) {
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
