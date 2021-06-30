package org.im97mori.ble.characteristic.u2aac;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CGM_SPECIFIC_OPS_CONTROL_POINT_CHARACTERISTIC;

/**
 * CGM Specific Ops Control Point (Characteristics UUID: 0x2AAC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CgmSpecificOpsControlPointAndroid extends CgmSpecificOpsControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CgmSpecificOpsControlPointAndroid> CREATOR = new ByteArrayCreater<CgmSpecificOpsControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSpecificOpsControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new CgmSpecificOpsControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSpecificOpsControlPointAndroid[] newArray(int size) {
            return new CgmSpecificOpsControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CgmSpecificOpsControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CGM_SPECIFIC_OPS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CgmSpecificOpsControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAC
     */
    public CgmSpecificOpsControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CgmSpecificOpsControlPointAndroid(@NonNull Parcel in) {
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
