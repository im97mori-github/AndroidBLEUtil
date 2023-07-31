package org.im97mori.ble.characteristic.u2b89;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Apparent Energy 32 (Characteristics UUID: 0x2B89)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ApparentEnergy32Android extends ApparentEnergy32 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ApparentEnergy32Android> CREATOR = new ByteArrayCreator<ApparentEnergy32Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentEnergy32Android createFromParcel(@NonNull Parcel in) {
            return new ApparentEnergy32Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentEnergy32Android[] newArray(int size) {
            return new ApparentEnergy32Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentEnergy32Android createFromByteArray(@NonNull byte[] values) {
            return new ApparentEnergy32Android(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B89
     */
    @Deprecated
    public ApparentEnergy32Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ApparentEnergy32Android(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentEnergy32Android(@NonNull Parcel in) {
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
