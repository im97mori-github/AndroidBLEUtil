package org.im97mori.ble.characteristic.u2ada;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fitness Machine Status (Characteristics UUID: 0x2ADA)
 */
@SuppressWarnings("WeakerAccess")
public class FitnessMachineStatusAndroid extends FitnessMachineStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FitnessMachineStatusAndroid> CREATOR = new ByteArrayCreator<FitnessMachineStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineStatusAndroid[] newArray(int size) {
            return new FitnessMachineStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FitnessMachineStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new FitnessMachineStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ADA
     */
    @Deprecated
    public FitnessMachineStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FitnessMachineStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opCode    Op Code
     * @param parameter Parameter
     */
    public FitnessMachineStatusAndroid(int opCode, @NonNull byte[] parameter) {
        super(opCode, parameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FitnessMachineStatusAndroid(@NonNull Parcel in) {
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
