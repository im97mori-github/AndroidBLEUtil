package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

/**
 * Characteristic Extended Properties (Descriptor UUID: 0x2900)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CharacteristicExtendedProperties implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CharacteristicExtendedProperties> CREATOR = new ByteArrayCreater<CharacteristicExtendedProperties>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicExtendedProperties createFromParcel(Parcel in) {
            return new CharacteristicExtendedProperties(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicExtendedProperties[] newArray(int size) {
            return new CharacteristicExtendedProperties[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicExtendedProperties createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new CharacteristicExtendedProperties(bluetoothGattDescriptor);
        }

    };

    /**
     * Properties
     */
    private final byte[] mProperties;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2900
     */
    public CharacteristicExtendedProperties(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mProperties = Arrays.copyOfRange(values, 0, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicExtendedProperties(Parcel in) {
        mProperties = in.createByteArray();
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
        dest.writeByteArray(mProperties);
    }

    /**
     * @return Properties
     */
    @NonNull
    public byte[] getProperties() {
        return mProperties;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mProperties);
        return data;
    }

}
