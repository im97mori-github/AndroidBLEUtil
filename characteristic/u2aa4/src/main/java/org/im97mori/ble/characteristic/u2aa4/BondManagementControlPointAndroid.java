package org.im97mori.ble.characteristic.u2aa4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bond Management Control Point (Characteristics UUID: 0x2AA4)
 */
@SuppressWarnings({"WeakerAccess"})
public class BondManagementControlPointAndroid extends BondManagementControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BondManagementControlPointAndroid> CREATOR = new ByteArrayCreator<BondManagementControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new BondManagementControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementControlPointAndroid[] newArray(int size) {
            return new BondManagementControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BondManagementControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new BondManagementControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA4
     */
    @Deprecated
    public BondManagementControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BondManagementControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opCode  Op Code
     * @param operand Operand
     */
    public BondManagementControlPointAndroid(int opCode, @Nullable String operand) {
        super(opCode, operand);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BondManagementControlPointAndroid(@NonNull Parcel in) {
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
