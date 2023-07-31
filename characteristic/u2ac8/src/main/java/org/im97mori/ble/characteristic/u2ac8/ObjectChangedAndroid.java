package org.im97mori.ble.characteristic.u2ac8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * object changed (Characteristics UUID: 0x2AC8)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectChangedAndroid extends ObjectChanged implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectChangedAndroid> CREATOR = new ByteArrayCreator<ObjectChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectChangedAndroid[] newArray(int size) {
            return new ObjectChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectChangedAndroid createFromByteArray(@NonNull byte[] values) {
            return new ObjectChangedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC8
     */
    @Deprecated
    public ObjectChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ObjectChangedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags    Flags
     * @param objectId Object ID
     */
    public ObjectChangedAndroid(int flags, long objectId) {
        super(flags, objectId);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectChangedAndroid(@NonNull Parcel in) {
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
