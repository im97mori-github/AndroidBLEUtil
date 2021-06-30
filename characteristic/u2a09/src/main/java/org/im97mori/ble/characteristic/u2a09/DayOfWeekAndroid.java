package org.im97mori.ble.characteristic.u2a09;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.DAY_OF_WEEK_CHARACTERISTIC;

/**
 * Day of Week (Characteristics UUID: 0x2A09)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DayOfWeekAndroid extends DayOfWeek implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DayOfWeekAndroid> CREATOR = new ByteArrayCreater<DayOfWeekAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DayOfWeekAndroid createFromParcel(@NonNull Parcel in) {
            return new DayOfWeekAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DayOfWeekAndroid[] newArray(int size) {
            return new DayOfWeekAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DayOfWeekAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DAY_OF_WEEK_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DayOfWeekAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A09
     */
    public DayOfWeekAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DayOfWeekAndroid(@NonNull Parcel in) {
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
