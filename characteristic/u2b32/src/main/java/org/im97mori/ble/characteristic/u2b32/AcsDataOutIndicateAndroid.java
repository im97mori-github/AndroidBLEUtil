package org.im97mori.ble.characteristic.u2b32;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * ACS Data Out Indicate (Characteristics UUID: 0x2B32)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AcsDataOutIndicateAndroid extends AcsDataOutIndicate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AcsDataOutIndicateAndroid> CREATOR = new ByteArrayCreator<AcsDataOutIndicateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutIndicateAndroid createFromParcel(@NonNull Parcel in) {
            return new AcsDataOutIndicateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutIndicateAndroid[] newArray(int size) {
            return new AcsDataOutIndicateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AcsDataOutIndicateAndroid createFromByteArray(@NonNull byte[] values) {
            return new AcsDataOutIndicateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B32
     */
    @Deprecated
    public AcsDataOutIndicateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AcsDataOutIndicateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AcsDataOutIndicateAndroid(@NonNull Parcel in) {
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
