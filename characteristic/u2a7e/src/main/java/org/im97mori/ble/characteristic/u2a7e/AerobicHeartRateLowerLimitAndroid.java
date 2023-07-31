package org.im97mori.ble.characteristic.u2a7e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

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
            return new AerobicHeartRateLowerLimitAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7E
     */
    @Deprecated
    public AerobicHeartRateLowerLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AerobicHeartRateLowerLimitAndroid(@NonNull byte[] values) {
        super(values);
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
        super(Objects.requireNonNull(in.createByteArray()));
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
