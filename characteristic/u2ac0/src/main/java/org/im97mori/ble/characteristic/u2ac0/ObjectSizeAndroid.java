package org.im97mori.ble.characteristic.u2ac0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * object size (Characteristics UUID: 0x2AC0)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectSizeAndroid extends ObjectSize implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectSizeAndroid> CREATOR = new ByteArrayCreator<ObjectSizeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectSizeAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectSizeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectSizeAndroid[] newArray(int size) {
            return new ObjectSizeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectSizeAndroid createFromByteArray(@NonNull byte[] values) {
            return new ObjectSizeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC0
     */
    @Deprecated
    public ObjectSizeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ObjectSizeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param currentSize   Current Size
     * @param allocatedSize Allocated Size
     */
    public ObjectSizeAndroid(long currentSize, long allocatedSize) {
        super(currentSize, allocatedSize);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectSizeAndroid(@NonNull Parcel in) {
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
