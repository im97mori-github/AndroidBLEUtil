package org.im97mori.ble.characteristic.u2b1b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Volume Flow (Characteristics UUID: 0x2B1B)
 */
@SuppressWarnings({"WeakerAccess"})
public class VolumeFlowAndroid extends VolumeFlow implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VolumeFlowAndroid> CREATOR = new ByteArrayCreator<VolumeFlowAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeFlowAndroid createFromParcel(@NonNull Parcel in) {
            return new VolumeFlowAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeFlowAndroid[] newArray(int size) {
            return new VolumeFlowAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VolumeFlowAndroid createFromByteArray(@NonNull byte[] values) {
            return new VolumeFlowAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1B
     */
    @Deprecated
    public VolumeFlowAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public VolumeFlowAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param volumeFlow Volume Flow
     */
    public VolumeFlowAndroid(int volumeFlow) {
        super(volumeFlow);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VolumeFlowAndroid(@NonNull Parcel in) {
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
