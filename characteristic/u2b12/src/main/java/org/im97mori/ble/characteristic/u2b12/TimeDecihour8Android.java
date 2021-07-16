package org.im97mori.ble.characteristic.u2b12;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_DECIHOUR_8_CHARACTERISTIC;

/**
 * Time Decihour 8 (Characteristics UUID: 0x2B12)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeDecihour8Android extends TimeDecihour8 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeDecihour8Android> CREATOR = new ByteArrayCreater<TimeDecihour8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeDecihour8Android createFromParcel(@NonNull Parcel in) {
            return new TimeDecihour8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeDecihour8Android[] newArray(int size) {
            return new TimeDecihour8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeDecihour8Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_DECIHOUR_8_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeDecihour8Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B12
     */
    public TimeDecihour8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param timeDecihour8 Time Decihour 8
     */
    public TimeDecihour8Android(int timeDecihour8) {
        super(timeDecihour8);
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeDecihour8Android(@NonNull Parcel in) {
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
