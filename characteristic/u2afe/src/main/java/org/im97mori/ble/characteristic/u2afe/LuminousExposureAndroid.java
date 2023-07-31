package org.im97mori.ble.characteristic.u2afe;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Luminous Exposure (Characteristics UUID: 0x2AFE)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousExposureAndroid extends LuminousExposure implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LuminousExposureAndroid> CREATOR = new ByteArrayCreator<LuminousExposureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousExposureAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousExposureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousExposureAndroid[] newArray(int size) {
            return new LuminousExposureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousExposureAndroid createFromByteArray(@NonNull byte[] values) {
            return new LuminousExposureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFE
     */
    @Deprecated
    public LuminousExposureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LuminousExposureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param luminousExposure Luminous Exposure
     */
    public LuminousExposureAndroid(int luminousExposure) {
        super(luminousExposure);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousExposureAndroid(@NonNull Parcel in) {
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
