package org.im97mori.ble.characteristic.u2aab;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CGM_SESSION_RUN_TIME_CHARACTERISTIC;

/**
 * CGM Session Run Time (Characteristics UUID: 0x2AAB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CgmSessionRunTimeAndroid extends CgmSessionRunTime implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CgmSessionRunTimeAndroid> CREATOR = new ByteArrayCreator<CgmSessionRunTimeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSessionRunTimeAndroid createFromParcel(@NonNull Parcel in) {
            return new CgmSessionRunTimeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CgmSessionRunTimeAndroid[] newArray(int size) {
            return new CgmSessionRunTimeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CgmSessionRunTimeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CGM_SESSION_RUN_TIME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CgmSessionRunTimeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAB
     */
    public CgmSessionRunTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CgmSessionRunTimeAndroid(@NonNull Parcel in) {
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
