package org.im97mori.ble.characteristic.ips;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INDOOR_POSITIONING_CONFIGURATION_CHARACTERISTIC;

/**
 * Indoor Positioning Configuration (Characteristics UUID: 0x2AAD)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IndoorPositioningConfiguration implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IndoorPositioningConfiguration> CREATOR = new ByteArrayCreater<IndoorPositioningConfiguration>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningConfiguration createFromParcel(@NonNull Parcel in) {
            return new IndoorPositioningConfiguration(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningConfiguration[] newArray(int size) {
            return new IndoorPositioningConfiguration[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IndoorPositioningConfiguration createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_POSITIONING_CONFIGURATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IndoorPositioningConfiguration(bluetoothGattCharacteristic);
        }

    };

    /**
     * Indoor Positioning Configuration
     */
    private final int mIndoorPositioningConfiguration;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAD
     */
    public IndoorPositioningConfiguration(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mIndoorPositioningConfiguration = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IndoorPositioningConfiguration(@NonNull Parcel in) {
        mIndoorPositioningConfiguration = in.readInt();
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
        dest.writeInt(mIndoorPositioningConfiguration);
    }

    /**
     * @return Indoor Positioning Configuration
     */
    public int getIndoorPositioningConfiguration() {
        return mIndoorPositioningConfiguration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mIndoorPositioningConfiguration);
        return data;
    }

}
