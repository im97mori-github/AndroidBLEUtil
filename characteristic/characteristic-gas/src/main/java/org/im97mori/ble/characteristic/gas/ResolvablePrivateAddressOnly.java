package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;

/**
 * Resolvable Private Address Only (Characteristics UUID: 0x2AC9)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ResolvablePrivateAddressOnly implements ByteArrayInterface, Parcelable {

    /**
     * 0: Only Resolvable Private Addresses will be used as local addresses after bonding
     */
    public static final int RESOLVABLE_PRIVATE_ADDRESS_0 = 0;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ResolvablePrivateAddressOnly> CREATOR = new ByteArrayCreater<ResolvablePrivateAddressOnly>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ResolvablePrivateAddressOnly createFromParcel(@NonNull Parcel in) {
            return new ResolvablePrivateAddressOnly(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ResolvablePrivateAddressOnly[] newArray(int size) {
            return new ResolvablePrivateAddressOnly[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ResolvablePrivateAddressOnly createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ResolvablePrivateAddressOnly(bluetoothGattCharacteristic);
        }

    };

    /**
     * Resolvable Private Address
     */
    private final int mResolvablePrivateAddress;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC9
     */
    public ResolvablePrivateAddressOnly(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mResolvablePrivateAddress = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ResolvablePrivateAddressOnly(@NonNull Parcel in) {
        mResolvablePrivateAddress = in.readInt();
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
        dest.writeInt(mResolvablePrivateAddress);
    }

    /**
     * @return Resolvable Private Address
     */
    public int getResolvablePrivateAddress() {
        return mResolvablePrivateAddress;
    }

    /**
     * @return {@code true}:Only Resolvable Private Addresses will be used as local addresses after bonding
     */
    public boolean isResolvablePrivateAddress0() {
        return RESOLVABLE_PRIVATE_ADDRESS_0 == mResolvablePrivateAddress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mResolvablePrivateAddress);
        return data;
    }

}
