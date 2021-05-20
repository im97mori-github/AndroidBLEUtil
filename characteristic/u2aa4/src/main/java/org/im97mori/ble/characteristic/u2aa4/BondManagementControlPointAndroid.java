package org.im97mori.ble.characteristic.u2aa4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;

/**
 * Bond Management Control Point (Characteristics UUID: 0x2AA4)
 */
@SuppressWarnings({"WeakerAccess"})
public class BondManagementControlPointAndroid extends BondManagementControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BondManagementControlPointAndroid> CREATOR = new ByteArrayCreater<BondManagementControlPointAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BondManagementControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA4
     */
    public BondManagementControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
