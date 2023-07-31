package org.im97mori.ble.characteristic.u2b45;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Session (Characteristics UUID: 0x2B45)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PhysicalActivitySessionDescriptorAndroid extends PhysicalActivitySessionDescriptor implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PhysicalActivitySessionDescriptorAndroid> CREATOR = new ByteArrayCreator<PhysicalActivitySessionDescriptorAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivitySessionDescriptorAndroid createFromParcel(@NonNull Parcel in) {
            return new PhysicalActivitySessionDescriptorAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivitySessionDescriptorAndroid[] newArray(int size) {
            return new PhysicalActivitySessionDescriptorAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PhysicalActivitySessionDescriptorAndroid createFromByteArray(@NonNull byte[] values) {
            return new PhysicalActivitySessionDescriptorAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B45
     */
    @Deprecated
    public PhysicalActivitySessionDescriptorAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PhysicalActivitySessionDescriptorAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PhysicalActivitySessionDescriptorAndroid(@NonNull Parcel in) {
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
