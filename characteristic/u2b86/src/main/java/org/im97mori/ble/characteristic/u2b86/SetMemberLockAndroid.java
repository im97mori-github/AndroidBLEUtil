package org.im97mori.ble.characteristic.u2b86;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SET_MEMBER_LOCK_CHARACTERISTIC;

/**
 * Set Member Lock (Characteristics UUID: 0x2B86)
 */
@SuppressWarnings({"WeakerAccess"})
public class SetMemberLockAndroid extends SetMemberLock implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SetMemberLockAndroid> CREATOR = new ByteArrayCreator<SetMemberLockAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetMemberLockAndroid createFromParcel(@NonNull Parcel in) {
            return new SetMemberLockAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetMemberLockAndroid[] newArray(int size) {
            return new SetMemberLockAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SetMemberLockAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SET_MEMBER_LOCK_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SetMemberLockAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B86
     */
    public SetMemberLockAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param setMemberLock Set Member Lock
     */
    public SetMemberLockAndroid(int setMemberLock) {
        super(setMemberLock);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SetMemberLockAndroid(@NonNull Parcel in) {
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
