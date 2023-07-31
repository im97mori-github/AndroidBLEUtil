package org.im97mori.ble.descriptor.u2901;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Characteristic User Description (Descriptor UUID: 0x2901)
 */
@SuppressWarnings({"WeakerAccess"})
public class CharacteristicUserDescriptionAndroid extends CharacteristicUserDescription implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CharacteristicUserDescriptionAndroid> CREATOR = new ByteArrayCreator<CharacteristicUserDescriptionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicUserDescriptionAndroid createFromParcel(@NonNull Parcel in) {
            return new CharacteristicUserDescriptionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicUserDescriptionAndroid[] newArray(int size) {
            return new CharacteristicUserDescriptionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicUserDescriptionAndroid createFromByteArray(@NonNull byte[] values) {
            return new CharacteristicUserDescriptionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2901
     */
    @Deprecated
    public CharacteristicUserDescriptionAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public CharacteristicUserDescriptionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicUserDescriptionAndroid(@NonNull Parcel in) {
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
