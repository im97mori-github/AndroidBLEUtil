package org.im97mori.ble.characteristic.u2b1d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * RC Feature (Characteristics UUID: 0x2B1D)
 */
@SuppressWarnings("WeakerAccess")
public class RCFeatureAndroid extends RCFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RCFeatureAndroid> CREATOR = new ByteArrayCreator<RCFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new RCFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCFeatureAndroid[] newArray(int size) {
            return new RCFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RCFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            return new RCFeatureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1D
     */
    @Deprecated
    public RCFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RCFeatureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param e2eCrc     E2E-CRC
     * @param rcFeatures RC Features
     */
    public RCFeatureAndroid(int e2eCrc, @NonNull byte[] rcFeatures) {
        super(e2eCrc, rcFeatures);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RCFeatureAndroid(@NonNull Parcel in) {
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
