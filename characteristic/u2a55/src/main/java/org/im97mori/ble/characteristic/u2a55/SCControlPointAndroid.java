package org.im97mori.ble.characteristic.u2a55;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * SC Control Point (Characteristics UUID: 0x2A55)
 */
@SuppressWarnings({"WeakerAccess"})
public class SCControlPointAndroid extends SCControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SCControlPointAndroid> CREATOR = new ByteArrayCreator<SCControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SCControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new SCControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SCControlPointAndroid[] newArray(int size) {
            return new SCControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SCControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new SCControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A55
     */
    @Deprecated
    public SCControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SCControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opCode              Op Code
     * @param cumulativeValue     Cumulative Value
     * @param sensorLocationValue Sensor Location Value
     * @param requestOpCode       Request Op Code
     * @param responseValue       Response Value
     * @param responseParameter   Response Parameter
     */
    public SCControlPointAndroid(int opCode, long cumulativeValue, int sensorLocationValue, int requestOpCode, int responseValue, byte[] responseParameter) {
        super(opCode, cumulativeValue, sensorLocationValue, requestOpCode, responseValue, responseParameter);
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SCControlPointAndroid(@NonNull Parcel in) {
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
