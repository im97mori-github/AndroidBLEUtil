package org.im97mori.ble.characteristic.u2a84;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;

/**
 * Aerobic Heart Rate Upper Limit (Characteristics UUID: 0x2A84)
 */
@SuppressWarnings({"WeakerAccess"})
public class AerobicHeartRateUpperLimitAndroid extends AerobicHeartRateUpperLimit implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AerobicHeartRateUpperLimitAndroid> CREATOR = new ByteArrayCreater<AerobicHeartRateUpperLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateUpperLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new AerobicHeartRateUpperLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateUpperLimitAndroid[] newArray(int size) {
            return new AerobicHeartRateUpperLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicHeartRateUpperLimitAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AerobicHeartRateUpperLimitAndroid(bluetoothGattCharacteristic);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A84
     */
    public AerobicHeartRateUpperLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param aerobicHeartRateUpperLimit Aerobic Heart Rate Upper Limit
     */
    public AerobicHeartRateUpperLimitAndroid(int aerobicHeartRateUpperLimit) {
        super(aerobicHeartRateUpperLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicHeartRateUpperLimitAndroid(@NonNull Parcel in) {
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
