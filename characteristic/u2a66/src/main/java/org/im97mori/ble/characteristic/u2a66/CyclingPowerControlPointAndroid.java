package org.im97mori.ble.characteristic.u2a66;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Cycling Power Control Point (Characteristics UUID: 0x2A66)
 */
@SuppressWarnings({"WeakerAccess"})
public class CyclingPowerControlPointAndroid extends CyclingPowerControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CyclingPowerControlPointAndroid> CREATOR = new ByteArrayCreator<CyclingPowerControlPointAndroid>() {

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
            return new CyclingPowerControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A66
     */
    @Deprecated
    public CyclingPowerControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CyclingPowerControlPointAndroid(@NonNull byte[] values) {
        super(values);
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
    private CyclingPowerControlPointAndroid(@NonNull Parcel in) {
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
