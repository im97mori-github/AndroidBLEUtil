package org.im97mori.ble.characteristic.u2be1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Light Distribution (Characteristics UUID: 0x2BE1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LightDistributionAndroid extends LightDistribution implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LightDistributionAndroid> CREATOR = new ByteArrayCreator<LightDistributionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightDistributionAndroid createFromParcel(@NonNull Parcel in) {
            return new LightDistributionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightDistributionAndroid[] newArray(int size) {
            return new LightDistributionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LightDistributionAndroid createFromByteArray(@NonNull byte[] values) {
            return new LightDistributionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE1
     */
    @Deprecated
    public LightDistributionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LightDistributionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LightDistributionAndroid(@NonNull Parcel in) {
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
