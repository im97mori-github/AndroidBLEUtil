package org.im97mori.ble.characteristic.u2a82;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;

/**
 * Anaerobic Heart Rate Upper Limit (Characteristics UUID: 0x2A82)
 */
@SuppressWarnings({"WeakerAccess"})
public class AnaerobicHeartRateUpperLimitAndroid extends AnaerobicHeartRateUpperLimit implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AnaerobicHeartRateUpperLimitAndroid> CREATOR = new ByteArrayCreater<AnaerobicHeartRateUpperLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateUpperLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new AnaerobicHeartRateUpperLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicHeartRateUpperLimitAndroid[] newArray(int size) {
            return new AnaerobicHeartRateUpperLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicHeartRateUpperLimitAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AnaerobicHeartRateUpperLimitAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A82
     */
    public AnaerobicHeartRateUpperLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param anaerobicHeartRateLowerLimit Anaerobic Heart Rate Lower Limit
     */
    public AnaerobicHeartRateUpperLimitAndroid(int anaerobicHeartRateLowerLimit) {
        super(anaerobicHeartRateLowerLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicHeartRateUpperLimitAndroid(@NonNull Parcel in) {
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
