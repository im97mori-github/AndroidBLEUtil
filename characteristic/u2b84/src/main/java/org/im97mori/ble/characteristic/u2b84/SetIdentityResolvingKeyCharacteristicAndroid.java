package org.im97mori.ble.characteristic.u2b84;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SET_IDENTITY_RESOLVING_KEY_CHARACTERISTIC;

/**
 * Set Identity Resolving Key Characteristic (Characteristics UUID: 0x2B84)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SetIdentityResolvingKeyCharacteristicAndroid extends SetIdentityResolvingKeyCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SetIdentityResolvingKeyCharacteristicAndroid> CREATOR = new ByteArrayCreater<SetIdentityResolvingKeyCharacteristicAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetIdentityResolvingKeyCharacteristicAndroid createFromParcel(@NonNull Parcel in) {
            return new SetIdentityResolvingKeyCharacteristicAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetIdentityResolvingKeyCharacteristicAndroid[] newArray(int size) {
            return new SetIdentityResolvingKeyCharacteristicAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SetIdentityResolvingKeyCharacteristicAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SET_IDENTITY_RESOLVING_KEY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SetIdentityResolvingKeyCharacteristicAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B84
     */
    public SetIdentityResolvingKeyCharacteristicAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SetIdentityResolvingKeyCharacteristicAndroid(@NonNull Parcel in) {
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
