package org.im97mori.ble_peripheral.characteristic;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble_peripheral.BLEServerConnection;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/**
 * Mock Control
 *
 * @see BLEServerConnection#MOCK_CONTROL_CHARACTERISTIC_UUID
 */
@SuppressWarnings("WeakerAccess")
public class MockControl implements ByteArrayInterface, Parcelable {

    /**
     * mock target:characteristic
     */
    public static final int TARGET_TYPE_CHARACTERISTIC = 0;

    /**
     * mock target:descriptor
     */
    public static final int TARGET_TYPE_DESCRIPTOR = 1;

    /**
     * mock target:notification(indication)
     */
    public static final int TARGET_TYPE_NOTIFICATION = 2;

    /**
     * clear target mock
     */
    public static final int TARGET_CLEAR = 3;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MockControl> CREATOR = new ByteArrayCreater<MockControl>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockControl createFromParcel(@NonNull Parcel in) {
            return new MockControl(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockControl[] newArray(int size) {
            return new MockControl[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MockControl createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLEServerConnection.MOCK_CONTROL_CHARACTERISTIC_UUID, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MockControl(bluetoothGattCharacteristic);
        }

    };

    /**
     * mock target service UUID
     */
    private final UUID mServiceUUID;

    /**
     * mock target characteristic UUID
     */
    private final UUID mCharacteristicUUID;

    /**
     * mock target descriptor UUID
     */
    private final UUID mDescriptorUUID;

    /**
     * mock target type
     * <p>
     *
     * @see #TARGET_TYPE_CHARACTERISTIC
     * @see #TARGET_TYPE_DESCRIPTOR
     * @see #TARGET_TYPE_NOTIFICATION
     * @see #TARGET_CLEAR
     */
    private final int mTargetType;

    /**
     * response status
     * <p>
     * for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
     */
    private final int mStatus;

    /**
     * response value
     * <p>
     * for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     */
    private final byte[] mValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic {@link BLEServerConnection#MOCK_CONTROL_CHARACTERISTIC_UUID}
     */
    public MockControl(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] data = bluetoothGattCharacteristic.getValue();
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        mServiceUUID = new UUID(byteBuffer.getLong(), byteBuffer.getLong());
        mCharacteristicUUID = new UUID(byteBuffer.getLong(), byteBuffer.getLong());
        mDescriptorUUID = new UUID(byteBuffer.getLong(), byteBuffer.getLong());
        mTargetType = byteBuffer.getInt();
        mStatus = byteBuffer.getInt();
        int position = byteBuffer.position();
        mValue = new byte[data.length - position];
        System.arraycopy(data, position, mValue, 0, mValue.length);
    }

    /**
     * Constructor from value
     *
     * @param serviceUUID        mock target service UUID
     * @param characteristicUUID mock target characteristic UUID
     * @param descriptorUUID     mock target descriptor UUID
     * @param targetType         {@link MockControl#TARGET_TYPE_CHARACTERISTIC} or {@link MockControl#TARGET_TYPE_DESCRIPTOR}
     * @param status             for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
     * @param value              for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     */
    public MockControl(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int targetType, int status, @NonNull byte[] value) {
        mServiceUUID = serviceUUID;
        mCharacteristicUUID = characteristicUUID;
        mDescriptorUUID = descriptorUUID;
        mTargetType = targetType;
        mStatus = status;
        mValue = value;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MockControl(@NonNull Parcel in) {
        mServiceUUID = new UUID(in.readLong(), in.readLong());
        mCharacteristicUUID = new UUID(in.readLong(), in.readLong());
        mDescriptorUUID = new UUID(in.readLong(), in.readLong());
        mTargetType = in.readInt();
        mStatus = in.readInt();
        mValue = in.createByteArray();
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
        dest.writeLong(mServiceUUID.getMostSignificantBits());
        dest.writeLong(mServiceUUID.getLeastSignificantBits());
        dest.writeLong(mCharacteristicUUID.getMostSignificantBits());
        dest.writeLong(mCharacteristicUUID.getLeastSignificantBits());
        dest.writeLong(mDescriptorUUID.getMostSignificantBits());
        dest.writeLong(mDescriptorUUID.getLeastSignificantBits());
        dest.writeInt(mTargetType);
        dest.writeInt(mStatus);
        dest.writeByteArray(mValue);
    }

    /**
     * @return mock target service UUID
     */
    @NonNull
    public UUID getServiceUUID() {
        return mServiceUUID;
    }

    /**
     * @return mock target characteristic UUID
     */
    @NonNull
    public UUID getCharacteristicUUID() {
        return mCharacteristicUUID;
    }

    /**
     * @return mock target descriptor UUID
     */
    @NonNull
    public UUID getDescriptorUUID() {
        return mDescriptorUUID;
    }

    /**
     * @return mock target type
     */
    public int getTargetType() {
        return mTargetType;
    }

    /**
     * @return response status
     */
    public int getStatus() {
        return mStatus;
    }

    /**
     * @return response value
     */
    @NonNull
    public byte[] getValue() {
        return mValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[56 + mValue.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putLong(mServiceUUID.getMostSignificantBits());
        byteBuffer.putLong(mServiceUUID.getLeastSignificantBits());
        byteBuffer.putLong(mCharacteristicUUID.getMostSignificantBits());
        byteBuffer.putLong(mCharacteristicUUID.getLeastSignificantBits());
        byteBuffer.putLong(mDescriptorUUID.getMostSignificantBits());
        byteBuffer.putLong(mDescriptorUUID.getLeastSignificantBits());
        byteBuffer.putInt(mTargetType);
        byteBuffer.putInt(mStatus);
        byteBuffer.put(mValue);
        return data;
    }

}
