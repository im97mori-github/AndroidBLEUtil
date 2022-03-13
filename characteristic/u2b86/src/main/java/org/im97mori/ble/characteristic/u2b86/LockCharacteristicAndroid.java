package org.im97mori.ble.characteristic.u2b86;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.LOCK_CHARACTERISTIC;

/**
 * Lock Characteristic (Characteristics UUID: 0x2B86)
 */
@SuppressWarnings({"WeakerAccess"})
public class LockCharacteristicAndroid extends LockCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LockCharacteristicAndroid> CREATOR = new ByteArrayCreator<LockCharacteristicAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LockCharacteristicAndroid createFromParcel(@NonNull Parcel in) {
            return new LockCharacteristicAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LockCharacteristicAndroid[] newArray(int size) {
            return new LockCharacteristicAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LockCharacteristicAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCK_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LockCharacteristicAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B86
     */
    public LockCharacteristicAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param setMemberLock Set Member Lock
     */
    public LockCharacteristicAndroid(int setMemberLock) {
        super(setMemberLock);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LockCharacteristicAndroid(@NonNull Parcel in) {
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
