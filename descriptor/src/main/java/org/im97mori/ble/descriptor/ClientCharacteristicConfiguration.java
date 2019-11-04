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

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;

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
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        }

    };

    /**
     * <p>
     * Configuration
     *
     * @see BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE
     * @see BluetoothGattDescriptor#ENABLE_INDICATION_VALUE
     * @see BluetoothGattDescriptor#DISABLE_NOTIFICATION_VALUE
     * </p>
     */
    private final byte[] mConfiguration;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2902
     */
    public ClientCharacteristicConfiguration(BluetoothGattDescriptor bluetoothGattDescriptor) {
        mConfiguration = bluetoothGattDescriptor.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ClientCharacteristicConfiguration(Parcel in) {
        mConfiguration = in.createByteArray();
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
        dest.writeByteArray(mConfiguration);
    }

    /**
     * @return Configuration
     */
    public byte[] getConfiguration() {
        return mConfiguration;
    }

    /**
     * @return {@code true}:current configuration is {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}, {@code false}:not {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}
     */
    public boolean isNotification() {
        return Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, mConfiguration);
    }

    /**
     * @return {@code true}:current configuration is {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}, {@code false}:not {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}
     */
    public boolean isIndication() {
        return Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, mConfiguration);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mConfiguration);
        return data;
    }

}
