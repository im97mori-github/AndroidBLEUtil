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
     * Properties:Reliable Write enabled
     */
    public static final byte[] PROPERTIES_RELIABLE_WRITE_ENABLED = {0x01, 0x00};

    /**
     * Properties:Writable Auxiliaries enabled
     */
    public static final byte[] PROPERTIES_WRITABLE_AUXILIARIES_ENABLED = {0x02, 0x00};

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
     * @return {@code true}:property is {@link #PROPERTIES_RELIABLE_WRITE_ENABLED}, {@code false}:not {@link #PROPERTIES_RELIABLE_WRITE_ENABLED}
     */
    public boolean isPropertiesReliableWrite() {
        return (PROPERTIES_RELIABLE_WRITE_ENABLED[0] & mProperties[0]) != 0;
    }

    /**
     * @return {@code true}:property is {@link #PROPERTIES_WRITABLE_AUXILIARIES_ENABLED}, {@code false}:not {@link #PROPERTIES_WRITABLE_AUXILIARIES_ENABLED}
     */
    public boolean isPropertiesWritableAuxiliariesEnabled() {
        return (PROPERTIES_WRITABLE_AUXILIARIES_ENABLED[0] & mProperties[0]) != 0;
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
