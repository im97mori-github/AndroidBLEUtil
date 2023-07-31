package org.im97mori.ble.characteristic.u2b51;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * TMAP Role (Characteristics UUID: 0x2B51)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TmapRoleAndroid extends TmapRole implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TmapRoleAndroid> CREATOR = new ByteArrayCreator<TmapRoleAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TmapRoleAndroid createFromParcel(@NonNull Parcel in) {
            return new TmapRoleAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TmapRoleAndroid[] newArray(int size) {
            return new TmapRoleAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TmapRoleAndroid createFromByteArray(@NonNull byte[] values) {
            return new TmapRoleAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B51
     */
    @Deprecated
    public TmapRoleAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TmapRoleAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TmapRoleAndroid(@NonNull Parcel in) {
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
