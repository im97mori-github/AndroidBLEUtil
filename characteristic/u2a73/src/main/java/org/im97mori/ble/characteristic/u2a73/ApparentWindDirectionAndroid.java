package org.im97mori.ble.characteristic.u2a73;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;

/**
 * Apparent Wind Direction (Characteristics UUID: 0x2A73)
 */
@SuppressWarnings({"WeakerAccess"})
public class ApparentWindDirectionAndroid extends ApparentWindDirection implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ApparentWindDirectionAndroid> CREATOR = new ByteArrayCreater<ApparentWindDirectionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindDirectionAndroid createFromParcel(@NonNull Parcel in) {
            return new ApparentWindDirectionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindDirectionAndroid[] newArray(int size) {
            return new ApparentWindDirectionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentWindDirectionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ApparentWindDirectionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A73
     */
    public ApparentWindDirectionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param apparentWindDirection Apparent Wind Direction
     */
    public ApparentWindDirectionAndroid(int apparentWindDirection) {
        super(apparentWindDirection);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentWindDirectionAndroid(@NonNull Parcel in) {
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
