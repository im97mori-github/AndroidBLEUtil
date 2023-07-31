package org.im97mori.ble.characteristic.u2a65;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Cycling Power Feature (Characteristics UUID: 0x2A65)
 */
@SuppressWarnings({"WeakerAccess"})
public class CyclingPowerFeatureAndroid extends CyclingPowerFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CyclingPowerFeatureAndroid> CREATOR = new ByteArrayCreator<CyclingPowerFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerFeatureAndroid[] newArray(int size) {
            return new CyclingPowerFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            return new CyclingPowerFeatureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A65
     */
    @Deprecated
    public CyclingPowerFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CyclingPowerFeatureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CyclingPowerFeatureAndroid(@NonNull Parcel in) {
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
