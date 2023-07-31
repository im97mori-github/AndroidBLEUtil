package org.im97mori.ble.characteristic.u2bf5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * SLE GATT Security Levels (Characteristics UUID: 0x2BF5)
 */
@SuppressWarnings({"WeakerAccess"})
public class LeGattSecurityLevelsAndroid extends LeGattSecurityLevels implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LeGattSecurityLevelsAndroid> CREATOR = new ByteArrayCreator<LeGattSecurityLevelsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeGattSecurityLevelsAndroid createFromParcel(@NonNull Parcel in) {
            return new LeGattSecurityLevelsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeGattSecurityLevelsAndroid[] newArray(int size) {
            return new LeGattSecurityLevelsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LeGattSecurityLevelsAndroid createFromByteArray(@NonNull byte[] values) {
            return new LeGattSecurityLevelsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BF5
     */
    @Deprecated
    public LeGattSecurityLevelsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LeGattSecurityLevelsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param isMode1Level1Supported {@code true}:LE security mode 1, Level 1 is supported,
     *                               {@code false}:LE security mode 1, Level 1 is not supported
     * @param isMode1Level2Supported {@code true}:LE security mode 1, Level 2 is supported,
     *                               {@code false}:LE security mode 1, Level 2 is not supported
     * @param isMode1Level3Supported {@code true}:LE security mode 1, Level 3 is supported,
     *                               {@code false}:LE security mode 1, Level 3 is not supported
     * @param isMode1Level4Supported {@code true}:LE security mode 1, Level 4 is supported,
     *                               {@code false}:LE security mode 1, Level 5 is not supported
     * @param isMode2Level1Supported {@code true}:LE security mode 2, Level 1 is supported,
     *                               {@code false}:LE security mode 2, Level 1 is not supported
     * @param isMode2Level2Supported {@code true}:LE security mode 2, Level 2 is supported,
     *                               {@code false}:LE security mode 2, Level 2 is not supported
     * @param isMode3Level1Supported {@code true}:LE security mode 3, Level 1 is supported,
     *                               {@code false}:LE security mode 3, Level 1 is not supported
     * @param isMode3Level2Supported {@code true}:LE security mode 3, Level 2 is supported,
     *                               {@code false}:LE security mode 3, Level 2 is not supported
     * @param isMode3Level3Supported {@code true}:LE security mode 3, Level 3 is supported,
     *                               {@code false}:LE security mode 3, Level 3 is not supported
     */
    public LeGattSecurityLevelsAndroid(boolean isMode1Level1Supported, boolean isMode1Level2Supported,
                                       boolean isMode1Level3Supported, boolean isMode1Level4Supported,
                                       boolean isMode2Level1Supported, boolean isMode2Level2Supported,
                                       boolean isMode3Level1Supported, boolean isMode3Level2Supported,
                                       boolean isMode3Level3Supported) {
        super(isMode1Level1Supported, isMode1Level2Supported,
                isMode1Level3Supported, isMode1Level4Supported,
                isMode2Level1Supported, isMode2Level2Supported,
                isMode3Level1Supported, isMode3Level2Supported,
                isMode3Level3Supported);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LeGattSecurityLevelsAndroid(@NonNull Parcel in) {
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
