package org.im97mori.ble.characteristic.u2a72;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;

/**
 * Apparent Wind Speed (Characteristics UUID: 0x2A72)
 */
@SuppressWarnings({"WeakerAccess"})
public class ApparentWindSpeedAndroid extends ApparentWindSpeed implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ApparentWindSpeedAndroid> CREATOR = new ByteArrayCreater<ApparentWindSpeedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindSpeedAndroid createFromParcel(@NonNull Parcel in) {
            return new ApparentWindSpeedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindSpeedAndroid[] newArray(int size) {
            return new ApparentWindSpeedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentWindSpeedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ApparentWindSpeedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A72
     */
    public ApparentWindSpeedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param apparentWindSpeed Apparent Wind Speed
     */
    public ApparentWindSpeedAndroid(int apparentWindSpeed) {
        super(apparentWindSpeed);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentWindSpeedAndroid(@NonNull Parcel in) {
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
