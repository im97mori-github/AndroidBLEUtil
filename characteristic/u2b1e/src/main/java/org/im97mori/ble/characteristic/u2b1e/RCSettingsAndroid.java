package org.im97mori.ble.characteristic.u2b1e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * RC Settings (Characteristics UUID: 0x2B1E)
 */
@SuppressWarnings("WeakerAccess")
public class RCSettingsAndroid extends RCSettings implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RCSettingsAndroid> CREATOR = new ByteArrayCreator<RCSettingsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCSettingsAndroid createFromParcel(@NonNull Parcel in) {
            return new RCSettingsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCSettingsAndroid[] newArray(int size) {
            return new RCSettingsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RCSettingsAndroid createFromByteArray(@NonNull byte[] values) {
            return new RCSettingsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1E
     */
    @Deprecated
    public RCSettingsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RCSettingsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param length   Length
     * @param settings Settings
     * @param e2eCrc   E2E-CRC
     */
    public RCSettingsAndroid(int length, int settings, int e2eCrc) {
        super(length, settings, e2eCrc);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RCSettingsAndroid(@NonNull Parcel in) {
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
