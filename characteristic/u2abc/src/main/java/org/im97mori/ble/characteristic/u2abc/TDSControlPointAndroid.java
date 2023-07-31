package org.im97mori.ble.characteristic.u2abc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * TDS Control Point (Characteristics UUID: 0x2ABC)
 */
@SuppressWarnings({"WeakerAccess"})
public class TDSControlPointAndroid extends TDSControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TDSControlPointAndroid> CREATOR = new ByteArrayCreator<TDSControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new TDSControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointAndroid[] newArray(int size) {
            return new TDSControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TDSControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new TDSControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABC
     */
    @Deprecated
    public TDSControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TDSControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opCode         Op Code
     * @param organizationId Organization ID
     * @param parameter      Parameter
     */
    public TDSControlPointAndroid(int opCode, int organizationId, @NonNull byte[] parameter) {
        super(opCode, organizationId, parameter);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TDSControlPointAndroid(@NonNull Parcel in) {
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
