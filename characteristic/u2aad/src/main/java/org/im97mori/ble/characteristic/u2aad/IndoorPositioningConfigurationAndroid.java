package org.im97mori.ble.characteristic.u2aad;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Indoor Positioning Configuration (Characteristics UUID: 0x2AAD)
 */
@SuppressWarnings({"WeakerAccess"})
public class IndoorPositioningConfigurationAndroid extends IndoorPositioningConfiguration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IndoorPositioningConfigurationAndroid> CREATOR = new ByteArrayCreator<IndoorPositioningConfigurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningConfigurationAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorPositioningConfigurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningConfigurationAndroid[] newArray(int size) {
            return new IndoorPositioningConfigurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IndoorPositioningConfigurationAndroid createFromByteArray(@NonNull byte[] values) {
            return new IndoorPositioningConfigurationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAD
     */
    @Deprecated
    public IndoorPositioningConfigurationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IndoorPositioningConfigurationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param indoorPositioningConfiguration Indoor Positioning Configuration
     */
    public IndoorPositioningConfigurationAndroid(int indoorPositioningConfiguration) {
        super(indoorPositioningConfiguration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IndoorPositioningConfigurationAndroid(@NonNull Parcel in) {
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
