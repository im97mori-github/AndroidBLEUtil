package org.im97mori.ble.characteristic.u2abe;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Object Name (Characteristics UUID: 0x2ABE)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectNameAndroid extends ObjectName implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectNameAndroid> CREATOR = new ByteArrayCreator<ObjectNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectNameAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectNameAndroid[] newArray(int size) {
            return new ObjectNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectNameAndroid createFromByteArray(@NonNull byte[] values) {
            return new ObjectNameAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABE
     */
    @Deprecated
    public ObjectNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ObjectNameAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param objectName Object Name
     */
    public ObjectNameAndroid(@NonNull String objectName) {
        super(objectName);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectNameAndroid(@NonNull Parcel in) {
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
