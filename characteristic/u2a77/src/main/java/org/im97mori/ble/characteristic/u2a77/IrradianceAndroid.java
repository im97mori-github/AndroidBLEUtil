package org.im97mori.ble.characteristic.u2a77;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Irradiance (Characteristics UUID: 0x2A77)
 */
@SuppressWarnings({"WeakerAccess"})
public class IrradianceAndroid extends Irradiance implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IrradianceAndroid> CREATOR = new ByteArrayCreator<IrradianceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IrradianceAndroid createFromParcel(@NonNull Parcel in) {
            return new IrradianceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IrradianceAndroid[] newArray(int size) {
            return new IrradianceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IrradianceAndroid createFromByteArray(@NonNull byte[] values) {
            return new IrradianceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A77
     */
    @Deprecated
    public IrradianceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IrradianceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param irradiance Irradiance
     */
    public IrradianceAndroid(int irradiance) {
        super(irradiance);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IrradianceAndroid(@NonNull Parcel in) {
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
