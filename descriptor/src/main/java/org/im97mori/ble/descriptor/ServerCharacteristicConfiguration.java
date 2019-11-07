package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.SERVER_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

/**
 * Server Characteristic Configuration (Descriptor UUID: 0x2903)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ServerCharacteristicConfiguration implements ByteArrayInterface, Parcelable {

    /**
     * Properties:Broadcasts disabled
     */
    public static final int PROPERTIES_BROADCASTS_DISABLED = 0x00;

    /**
     * Properties:Broadcasts enabled
     */
    public static final int PROPERTIES_BROADCASTS_ENABLED = 0x01;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ServerCharacteristicConfiguration> CREATOR = new ByteArrayCreater<ServerCharacteristicConfiguration>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ServerCharacteristicConfiguration createFromParcel(Parcel in) {
            return new ServerCharacteristicConfiguration(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ServerCharacteristicConfiguration[] newArray(int size) {
            return new ServerCharacteristicConfiguration[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ServerCharacteristicConfiguration createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(SERVER_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ServerCharacteristicConfiguration(bluetoothGattDescriptor);
        }

    };

    /**
     * Properties
     */
    private final int mProperties;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2903
     */
    public ServerCharacteristicConfiguration(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mProperties = (values[0] & 0xff) | ((values[1] & 0xff) << 8);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServerCharacteristicConfiguration(Parcel in) {
        mProperties = in.readInt();
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
        dest.writeInt(mProperties);
    }

    /**
     * @return Properties
     */
    public int getProperties() {
        return mProperties;
    }

    /**
     * @return {@code true}:property is {@link #PROPERTIES_BROADCASTS_DISABLED}, {@code false}:not {@link #PROPERTIES_BROADCASTS_DISABLED}
     */
    public boolean isPropertiesBroadcastsDisabled() {
        return PROPERTIES_BROADCASTS_DISABLED == mProperties;
    }

    /**
     * @return {@code true}:property is {@link #PROPERTIES_BROADCASTS_ENABLED}, {@code false}:not {@link #PROPERTIES_BROADCASTS_ENABLED}
     */
    public boolean isPropertiesBroadcastsEnabled() {
        return PROPERTIES_BROADCASTS_ENABLED == mProperties;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mProperties);
        return data;
    }

}
