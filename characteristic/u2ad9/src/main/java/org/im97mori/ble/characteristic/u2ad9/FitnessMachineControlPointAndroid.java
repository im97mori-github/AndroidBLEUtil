package org.im97mori.ble.characteristic.u2ad9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fitness Machine Control Point (Characteristics UUID: 0x2AD9)
 */
@SuppressWarnings("WeakerAccess")
public class FitnessMachineControlPointAndroid extends FitnessMachineControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FitnessMachineControlPointAndroid> CREATOR = new ByteArrayCreator<FitnessMachineControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineControlPointAndroid[] newArray(int size) {
            return new FitnessMachineControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FitnessMachineControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new FitnessMachineControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD9
     */
    @Deprecated
    public FitnessMachineControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FitnessMachineControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opCode            Op Code
     * @param parameter         Parameter
     * @param requestOpCode     Request Op Code
     * @param resultCode        Result Code
     * @param responseParameter Response Parameter
     */
    public FitnessMachineControlPointAndroid(int opCode, @NonNull byte[] parameter, int requestOpCode, int resultCode, @NonNull byte[] responseParameter) {
        super(opCode, parameter, requestOpCode, resultCode, responseParameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FitnessMachineControlPointAndroid(@NonNull Parcel in) {
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
