package org.im97mori.ble.characteristic.u2b43;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Physical Activity Monitor Control Point (Characteristics UUID: 0x2B43)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PhysicalActivityMonitorControlPointAndroid extends PhysicalActivityMonitorControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PhysicalActivityMonitorControlPointAndroid> CREATOR = new ByteArrayCreator<PhysicalActivityMonitorControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new PhysicalActivityMonitorControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorControlPointAndroid[] newArray(int size) {
            return new PhysicalActivityMonitorControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PhysicalActivityMonitorControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new PhysicalActivityMonitorControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B43
     */
    @Deprecated
    public PhysicalActivityMonitorControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PhysicalActivityMonitorControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PhysicalActivityMonitorControlPointAndroid(@NonNull Parcel in) {
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
