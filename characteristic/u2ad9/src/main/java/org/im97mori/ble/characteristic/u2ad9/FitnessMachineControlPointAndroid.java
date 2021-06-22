package org.im97mori.ble.characteristic.u2ad9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;

/**
 * Fitness Machine Control Point (Characteristics UUID: 0x2AD9)
 */
@SuppressWarnings("WeakerAccess")
public class FitnessMachineControlPointAndroid extends FitnessMachineControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FitnessMachineControlPointAndroid> CREATOR = new ByteArrayCreater<FitnessMachineControlPointAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FitnessMachineControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD9
     */
    public FitnessMachineControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
        //noinspection ConstantConditions
        super(in.createByteArray());
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
