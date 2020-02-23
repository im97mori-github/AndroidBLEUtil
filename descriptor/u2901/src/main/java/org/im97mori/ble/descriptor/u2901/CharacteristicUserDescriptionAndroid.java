package org.im97mori.ble.descriptor.u2901;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

/**
 * Characteristic User Description (Descriptor UUID: 0x2901)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CharacteristicUserDescriptionAndroid extends CharacteristicUserDescription implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CharacteristicUserDescriptionAndroid> CREATOR = new ByteArrayCreater<CharacteristicUserDescriptionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicUserDescriptionAndroid createFromParcel(@NonNull Parcel in) {
            return new CharacteristicUserDescriptionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicUserDescriptionAndroid[] newArray(int size) {
            return new CharacteristicUserDescriptionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicUserDescriptionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new CharacteristicUserDescriptionAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2901
     */
    public CharacteristicUserDescriptionAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private CharacteristicUserDescriptionAndroid(@NonNull Parcel in) {
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
