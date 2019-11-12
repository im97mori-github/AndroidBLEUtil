package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SYSTEM_ID_CHARACTERISTIC;

/**
 * System ID (Characteristics UUID: 0x2A23)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SystemId implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SystemId> CREATOR = new ByteArrayCreater<SystemId>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SystemId createFromParcel(@NonNull Parcel in) {
            return new SystemId(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SystemId[] newArray(int size) {
            return new SystemId[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SystemId createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SYSTEM_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SystemId(bluetoothGattCharacteristic);
        }

    };

    /**
     * Manufacturer Identifier
     */
    private final long mManufacturerIdentifier;

    /**
     * Organizationally Unique Identifier
     */
    private final int mOrganizationallyUniqueIdentifier;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A23
     */
    public SystemId(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mManufacturerIdentifier = BLEUtils.createUInt40(values, 0);
        mOrganizationallyUniqueIdentifier = BLEUtils.createUInt24(values, 5);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SystemId(@NonNull Parcel in) {
        mManufacturerIdentifier = in.readLong();
        mOrganizationallyUniqueIdentifier = in.readInt();
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
        dest.writeLong(mManufacturerIdentifier);
        dest.writeInt(mOrganizationallyUniqueIdentifier);
    }

    /**
     * @return Manufacturer Identifier
     */
    public long getManufacturerIdentifier() {
        return mManufacturerIdentifier;
    }

    /**
     * @return Organizationally Unique Identifier
     */
    public int getOrganizationallyUniqueIdentifier() {
        return mOrganizationallyUniqueIdentifier;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[8];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mManufacturerIdentifier);
        byteBuffer.put((byte) (mManufacturerIdentifier >> 8));
        byteBuffer.put((byte) (mManufacturerIdentifier >> 16));
        byteBuffer.put((byte) (mManufacturerIdentifier >> 24));
        byteBuffer.put((byte) (mManufacturerIdentifier >> 32));
        byteBuffer.put((byte) mOrganizationallyUniqueIdentifier);
        byteBuffer.put((byte) (mOrganizationallyUniqueIdentifier >> 8));
        byteBuffer.put((byte) (mOrganizationallyUniqueIdentifier >> 16));
        return data;
    }

}
