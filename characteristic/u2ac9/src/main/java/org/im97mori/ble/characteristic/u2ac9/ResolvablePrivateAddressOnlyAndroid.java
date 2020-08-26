package org.im97mori.ble.characteristic.u2ac9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;

/**
 * Resolvable Private Address Only (Characteristics UUID: 0x2AC9)
 */
@SuppressWarnings({"WeakerAccess"})
public class ResolvablePrivateAddressOnlyAndroid extends ResolvablePrivateAddressOnly implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ResolvablePrivateAddressOnlyAndroid> CREATOR = new ByteArrayCreater<ResolvablePrivateAddressOnlyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ResolvablePrivateAddressOnlyAndroid createFromParcel(@NonNull Parcel in) {
            return new ResolvablePrivateAddressOnlyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ResolvablePrivateAddressOnlyAndroid[] newArray(int size) {
            return new ResolvablePrivateAddressOnlyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ResolvablePrivateAddressOnlyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ResolvablePrivateAddressOnlyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC9
     */
    public ResolvablePrivateAddressOnlyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param resolvablePrivateAddress Resolvable Private Address
     */
    public ResolvablePrivateAddressOnlyAndroid(int resolvablePrivateAddress) {
        super(resolvablePrivateAddress);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ResolvablePrivateAddressOnlyAndroid(@NonNull Parcel in) {
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
