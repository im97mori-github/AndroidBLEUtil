package org.im97mori.ble.characteristic.u2b3b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Physical Activity Monitor Features (Characteristics UUID: 0x2B3B)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PhysicalActivityMonitorFeaturesAndroid extends PhysicalActivityMonitorFeatures implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PhysicalActivityMonitorFeaturesAndroid> CREATOR = new ByteArrayCreator<PhysicalActivityMonitorFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new PhysicalActivityMonitorFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorFeaturesAndroid[] newArray(int size) {
            return new PhysicalActivityMonitorFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PhysicalActivityMonitorFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            return new PhysicalActivityMonitorFeaturesAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3B
     */
    @Deprecated
    public PhysicalActivityMonitorFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PhysicalActivityMonitorFeaturesAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PhysicalActivityMonitorFeaturesAndroid(@NonNull Parcel in) {
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
