package org.im97mori.ble.characteristic.u2b41;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SLEEP_ACTIVITY_INSTANTANEOUS_DATA_CHARACTERISTIC;

/**
 * Sleep Activity Instantaneous Data (Characteristics UUID: 0x2B41)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SleepActivityInstantaneousDataAndroid extends SleepActivityInstantaneousData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SleepActivityInstantaneousDataAndroid> CREATOR = new ByteArrayCreater<SleepActivityInstantaneousDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SleepActivityInstantaneousDataAndroid createFromParcel(@NonNull Parcel in) {
            return new SleepActivityInstantaneousDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SleepActivityInstantaneousDataAndroid[] newArray(int size) {
            return new SleepActivityInstantaneousDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SleepActivityInstantaneousDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SLEEP_ACTIVITY_INSTANTANEOUS_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SleepActivityInstantaneousDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B41
     */
    public SleepActivityInstantaneousDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SleepActivityInstantaneousDataAndroid(@NonNull Parcel in) {
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
