package org.im97mori.ble.characteristic.u2a66;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;

/**
 * Cycling Power Control Point (Characteristics UUID: 0x2A66)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CyclingPowerControlPointAndroid extends CyclingPowerControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CyclingPowerControlPointAndroid> CREATOR = new ByteArrayCreater<CyclingPowerControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerControlPointAndroid[] newArray(int size) {
            return new CyclingPowerControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CyclingPowerControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CyclingPowerControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A66
     */
    public CyclingPowerControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param opCodes           Op Codes
     * @param parameterValue    Parameter Value
     * @param requestOpCode     Request Op Code
     * @param responseValue     Response Value
     * @param responseParameter Response Parameter
     */
    public CyclingPowerControlPointAndroid(int opCodes, @NonNull byte[] parameterValue, int requestOpCode, int responseValue, @NonNull byte[] responseParameter) {
        super(opCodes, parameterValue, requestOpCode, responseValue, responseParameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private CyclingPowerControlPointAndroid(@NonNull Parcel in) {
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
