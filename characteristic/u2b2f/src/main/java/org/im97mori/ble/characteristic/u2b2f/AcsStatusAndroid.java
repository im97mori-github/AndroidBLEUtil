package org.im97mori.ble.characteristic.u2b2f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * ACS Status (Characteristics UUID: 0x2B2F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AcsStatusAndroid extends AcsStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AcsStatusAndroid> CREATOR = new ByteArrayCreator<AcsStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new AcsStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsStatusAndroid[] newArray(int size) {
            return new AcsStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AcsStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new AcsStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B2F
     */
    @Deprecated
    public AcsStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AcsStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AcsStatusAndroid(@NonNull Parcel in) {
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
