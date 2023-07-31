package org.im97mori.ble.characteristic.u2aa5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bond Management Features (Characteristics UUID: 0x2AA5)
 */
@SuppressWarnings({"WeakerAccess"})
public class BondManagementFeaturesAndroid extends BondManagementFeatures implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BondManagementFeaturesAndroid> CREATOR = new ByteArrayCreator<BondManagementFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new BondManagementFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementFeaturesAndroid[] newArray(int size) {
            return new BondManagementFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BondManagementFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            return new BondManagementFeaturesAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA5
     */
    @Deprecated
    public BondManagementFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BondManagementFeaturesAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BondManagementFeaturesAndroid(@NonNull Parcel in) {
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
