package org.im97mori.ble.descriptor.u2905;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Characteristic Aggregate Format (Descriptor UUID: 0x2905)
 */
@SuppressWarnings({"WeakerAccess"})
public class CharacteristicAggregateFormatAndroid extends CharacteristicAggregateFormat implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CharacteristicAggregateFormatAndroid> CREATOR = new ByteArrayCreator<CharacteristicAggregateFormatAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicAggregateFormatAndroid createFromParcel(@NonNull Parcel in) {
            return new CharacteristicAggregateFormatAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicAggregateFormatAndroid[] newArray(int size) {
            return new CharacteristicAggregateFormatAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicAggregateFormatAndroid createFromByteArray(@NonNull byte[] values) {
            return new CharacteristicAggregateFormatAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2905
     */
    @Deprecated
    public CharacteristicAggregateFormatAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public CharacteristicAggregateFormatAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicAggregateFormatAndroid(@NonNull Parcel in) {
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
