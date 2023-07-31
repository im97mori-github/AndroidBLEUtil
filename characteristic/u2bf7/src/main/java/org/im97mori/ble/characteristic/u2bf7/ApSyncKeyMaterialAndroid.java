package org.im97mori.ble.characteristic.u2bf7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * AP Sync Key Material (Characteristics UUID: 0x2BF7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ApSyncKeyMaterialAndroid extends ApSyncKeyMaterial implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ApSyncKeyMaterialAndroid> CREATOR = new ByteArrayCreator<ApSyncKeyMaterialAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApSyncKeyMaterialAndroid createFromParcel(@NonNull Parcel in) {
            return new ApSyncKeyMaterialAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApSyncKeyMaterialAndroid[] newArray(int size) {
            return new ApSyncKeyMaterialAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApSyncKeyMaterialAndroid createFromByteArray(@NonNull byte[] values) {
            return new ApSyncKeyMaterialAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BF7
     */
    @Deprecated
    public ApSyncKeyMaterialAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ApSyncKeyMaterialAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApSyncKeyMaterialAndroid(@NonNull Parcel in) {
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
