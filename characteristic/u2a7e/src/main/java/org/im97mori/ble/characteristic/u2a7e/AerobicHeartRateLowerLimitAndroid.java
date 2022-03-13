package org.im97mori.ble.characteristic.u2a7e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;

/**
 * Aerobic Heart Rate Lower Limit (Characteristics UUID: 0x2A7E)
 */
@SuppressWarnings({"WeakerAccess"})
public class AerobicHeartRateLowerLimitAndroid extends AerobicHeartRateLowerLimit implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AerobicHeartRateLowerLimitAndroid> CREATOR = new ByteArrayCreator<AerobicHeartRateLowerLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateLowerLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new AerobicHeartRateLowerLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicHeartRateLowerLimitAndroid[] newArray(int size) {
            return new AerobicHeartRateLowerLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicHeartRateLowerLimitAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AerobicHeartRateLowerLimitAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7E
     */
    public AerobicHeartRateLowerLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param aerobicHeartRateLowerLimit Aerobic Heart Rate Lower Limit
     */
    public AerobicHeartRateLowerLimitAndroid(int aerobicHeartRateLowerLimit) {
        super(aerobicHeartRateLowerLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicHeartRateLowerLimitAndroid(@NonNull Parcel in) {
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
