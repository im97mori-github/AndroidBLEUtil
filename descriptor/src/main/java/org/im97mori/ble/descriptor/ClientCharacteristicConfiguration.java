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

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

/**
 * Client Characteristic Configuration (Descriptor UUID: 0x2902)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ClientCharacteristicConfiguration implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ClientCharacteristicConfiguration> CREATOR = new ByteArrayCreater<ClientCharacteristicConfiguration>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ClientCharacteristicConfiguration createFromParcel(Parcel in) {
            return new ClientCharacteristicConfiguration(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ClientCharacteristicConfiguration[] newArray(int size) {
            return new ClientCharacteristicConfiguration[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ClientCharacteristicConfiguration createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        }

    };

    /**
     * Properties
     */
    private final byte[] mProperties;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2902
     */
    public ClientCharacteristicConfiguration(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mProperties = Arrays.copyOfRange(values, 0, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClientCharacteristicConfiguration(Parcel in) {
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
     * @return {@code true}:property is {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}, {@code false}:not {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}
     */
    public boolean isNotification() {
        return (mProperties[0] & BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]) != 0;
    }

    /**
     * @return {@code true}:property is {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}, {@code false}:not {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}
     */
    public boolean isIndication() {
        return (mProperties[0] & BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]) != 0;
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
