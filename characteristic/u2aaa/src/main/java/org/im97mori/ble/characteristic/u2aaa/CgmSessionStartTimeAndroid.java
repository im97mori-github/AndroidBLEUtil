package org.im97mori.ble.characteristic.u2aaa;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CGM_SESSION_START_TIME_CHARACTERISTIC;

/**
 * CGM Session Start Time (Characteristics UUID: 0x2AAA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CgmSessionStartTimeAndroid extends CgmSessionStartTime implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CgmSessionStartTimeAndroid> CREATOR = new ByteArrayCreator<CgmSessionStartTimeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSessionStartTimeAndroid createFromParcel(@NonNull Parcel in) {
            return new CgmSessionStartTimeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSessionStartTimeAndroid[] newArray(int size) {
            return new CgmSessionStartTimeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CgmSessionStartTimeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CGM_SESSION_START_TIME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CgmSessionStartTimeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAA
     */
    public CgmSessionStartTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CgmSessionStartTimeAndroid(@NonNull Parcel in) {
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
