package org.im97mori.ble.characteristic.u2bcb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Source PAC (Characteristics UUID: 0x2BCB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SourcePacAndroid extends SourcePac implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SourcePacAndroid> CREATOR = new ByteArrayCreator<SourcePacAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourcePacAndroid createFromParcel(@NonNull Parcel in) {
            return new SourcePacAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourcePacAndroid[] newArray(int size) {
            return new SourcePacAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SourcePacAndroid createFromByteArray(@NonNull byte[] values) {
            return new SourcePacAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCB
     */
    @Deprecated
    public SourcePacAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SourcePacAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SourcePacAndroid(@NonNull Parcel in) {
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
