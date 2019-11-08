package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

/**
 * Characteristic User Description (Descriptor UUID: 0x2901)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CharacteristicUserDescription implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CharacteristicUserDescription> CREATOR = new ByteArrayCreater<CharacteristicUserDescription>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicUserDescription createFromParcel(Parcel in) {
            return new CharacteristicUserDescription(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicUserDescription[] newArray(int size) {
            return new CharacteristicUserDescription[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicUserDescription createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new CharacteristicUserDescription(bluetoothGattDescriptor);
        }

    };

    /**
     * User Description
     */
    private final String mUserDescription;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2901
     */
    public CharacteristicUserDescription(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mUserDescription = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicUserDescription(Parcel in) {
        mUserDescription = in.readString();
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUserDescription);
    }

    /**
     * @return User Description
     */
    @NonNull
    public String getUserDescription() {
        return mUserDescription;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        return mUserDescription.getBytes();
    }

}
