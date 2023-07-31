package org.im97mori.ble.descriptor.u2900;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Characteristic Extended Properties (Descriptor UUID: 0x2900)
 */
@SuppressWarnings({"WeakerAccess"})
public class CharacteristicExtendedPropertiesAndroid extends CharacteristicExtendedProperties implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CharacteristicExtendedPropertiesAndroid> CREATOR = new ByteArrayCreator<CharacteristicExtendedPropertiesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicExtendedPropertiesAndroid createFromParcel(@NonNull Parcel in) {
            return new CharacteristicExtendedPropertiesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicExtendedPropertiesAndroid[] newArray(int size) {
            return new CharacteristicExtendedPropertiesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicExtendedPropertiesAndroid createFromByteArray(@NonNull byte[] values) {
            return new CharacteristicExtendedPropertiesAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2900
     */
    @Deprecated
    public CharacteristicExtendedPropertiesAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public CharacteristicExtendedPropertiesAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param isReliableWriteEnabled       {@code true}:{@link #PROPERTIES_RELIABLE_WRITE_ENABLED}, {@code false}:{@link #PROPERTIES_RELIABLE_WRITE_DISABLED}
     * @param isWritableAuxiliariesEnabled {@code true}:{@link #PROPERTIES_WRITABLE_AUXILIARIES_ENABLED}, {@code false}:{@link #PROPERTIES_WRITABLE_AUXILIARIES_DISABLED}
     */
    public CharacteristicExtendedPropertiesAndroid(boolean isReliableWriteEnabled, boolean isWritableAuxiliariesEnabled) {
        super(isReliableWriteEnabled, isWritableAuxiliariesEnabled);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicExtendedPropertiesAndroid(@NonNull Parcel in) {
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
