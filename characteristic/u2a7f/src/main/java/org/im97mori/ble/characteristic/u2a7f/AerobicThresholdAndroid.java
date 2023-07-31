package org.im97mori.ble.characteristic.u2a7f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Aerobic Threshold (Characteristics UUID: 0x2A7F)
 */
@SuppressWarnings({"WeakerAccess"})
public class AerobicThresholdAndroid extends AerobicThreshold implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AerobicThresholdAndroid> CREATOR = new ByteArrayCreator<AerobicThresholdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicThresholdAndroid createFromParcel(@NonNull Parcel in) {
            return new AerobicThresholdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicThresholdAndroid[] newArray(int size) {
            return new AerobicThresholdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicThresholdAndroid createFromByteArray(@NonNull byte[] values) {
            return new AerobicThresholdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7F
     */
    @Deprecated
    public AerobicThresholdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AerobicThresholdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param aerobicThreshold Aerobic Threshold
     */
    public AerobicThresholdAndroid(int aerobicThreshold) {
        super(aerobicThreshold);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicThresholdAndroid(@NonNull Parcel in) {
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
