package org.im97mori.ble.characteristic.u2aa9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CGM_STATUS_CHARACTERISTIC;

/**
 * CGM Status (Characteristics UUID: 0x2AA9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CgmStatusAndroid extends CgmStatus implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CgmStatusAndroid> CREATOR = new ByteArrayCreater<CgmStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new CgmStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmStatusAndroid[] newArray(int size) {
            return new CgmStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CgmStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CGM_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CgmStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA9
     */
    public CgmStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CgmStatusAndroid(@NonNull Parcel in) {
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
