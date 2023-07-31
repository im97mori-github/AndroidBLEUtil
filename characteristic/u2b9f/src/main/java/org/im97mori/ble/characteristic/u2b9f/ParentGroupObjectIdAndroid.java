package org.im97mori.ble.characteristic.u2b9f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Parent Group Object ID (Characteristics UUID: 0x2B9F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ParentGroupObjectIdAndroid extends ParentGroupObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ParentGroupObjectIdAndroid> CREATOR = new ByteArrayCreator<ParentGroupObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParentGroupObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new ParentGroupObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParentGroupObjectIdAndroid[] newArray(int size) {
            return new ParentGroupObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ParentGroupObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new ParentGroupObjectIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9F
     */
    @Deprecated
    public ParentGroupObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ParentGroupObjectIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ParentGroupObjectIdAndroid(@NonNull Parcel in) {
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
