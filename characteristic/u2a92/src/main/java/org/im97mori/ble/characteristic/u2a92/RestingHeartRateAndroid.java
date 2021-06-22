package org.im97mori.ble.characteristic.u2a92;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;

/**
 * Resting Heart Rate (Characteristics UUID: 0x2A92)
 */
@SuppressWarnings({"WeakerAccess"})
public class RestingHeartRateAndroid extends RestingHeartRate implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RestingHeartRateAndroid> CREATOR = new ByteArrayCreater<RestingHeartRateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RestingHeartRateAndroid createFromParcel(@NonNull Parcel in) {
            return new RestingHeartRateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RestingHeartRateAndroid[] newArray(int size) {
            return new RestingHeartRateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RestingHeartRateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RestingHeartRateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A92
     */
    public RestingHeartRateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param restingHeartRate Resting Heart Rate
     */
    public RestingHeartRateAndroid(int restingHeartRate) {
        super(restingHeartRate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RestingHeartRateAndroid(@NonNull Parcel in) {
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
