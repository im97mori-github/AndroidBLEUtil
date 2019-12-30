package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
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
    public static final int TARGET_TYPE_DESCRIPTOR = TARGET_TYPE_CHARACTERISTIC + 1;

    /**
     * mock target:notification(indication)
     */
    public static final int TARGET_TYPE_NOTIFICATION = TARGET_TYPE_DESCRIPTOR + 1;

    /**
     * clear target mock
     */
    public static final int TARGET_CLEAR = TARGET_TYPE_NOTIFICATION + 1;

    /**
     * <p>
     * INSTANCE_ID:NULL
     * no specified instance
     * </p>
     */
    public static final int INSTANCE_ID_NULL = 0;

    /**
     * <p>
     * INSTANCE_ID:NON_NULL
     * specified instance
     * </p>
     */
    public static final int INSTANCE_ID_NOT_NULL = 1;

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
     * mock target service incetanceId {@link BluetoothGattService#getInstanceId()}
     */
    private final Integer mServiceInstanceId;

    /**
     * mock target characteristic {@link UUID}
     */
    private final UUID mCharacteristicUUID;

    /**
     * mock target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     */
    private final Integer mCharacteristicInstanceId;

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
        if (INSTANCE_ID_NULL == byteBuffer.get()) {
            mServiceInstanceId = null;
        } else {
            mServiceInstanceId = byteBuffer.getInt();
        }
        mCharacteristicUUID = new UUID(byteBuffer.getLong(), byteBuffer.getLong());
        if (INSTANCE_ID_NULL == byteBuffer.get()) {
            mCharacteristicInstanceId = null;
        } else {
            mCharacteristicInstanceId = byteBuffer.getInt();
        }
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
     * @param serviceUUID              mock target service UUID
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       mock target characteristic UUID
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           mock target descriptor UUID
     * @param targetType               one of {@link #TARGET_TYPE_CHARACTERISTIC}, {@link #TARGET_TYPE_DESCRIPTOR}, {@link #TARGET_TYPE_NOTIFICATION}, {@link #TARGET_CLEAR}
     * @param status                   for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
     * @param value                    for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     */
    public MockControl(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int targetType, int status, @NonNull byte[] value) {
        mServiceUUID = serviceUUID;
        mServiceInstanceId = serviceInstanceId;
        mCharacteristicUUID = characteristicUUID;
        mCharacteristicInstanceId = characteristicInstanceId;
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
        if (INSTANCE_ID_NULL == in.readInt()) {
            mServiceInstanceId = null;
        } else {
            mServiceInstanceId = in.readInt();
        }
        mCharacteristicUUID = new UUID(in.readLong(), in.readLong());
        if (INSTANCE_ID_NULL == in.readInt()) {
            mCharacteristicInstanceId = null;
        } else {
            mCharacteristicInstanceId = in.readInt();
        }
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
        if (mServiceInstanceId == null) {
            dest.writeInt(INSTANCE_ID_NULL);
        } else {
            dest.writeInt(INSTANCE_ID_NOT_NULL);
            dest.writeInt(mServiceInstanceId);
        }
        dest.writeLong(mCharacteristicUUID.getMostSignificantBits());
        dest.writeLong(mCharacteristicUUID.getLeastSignificantBits());
        if (mCharacteristicInstanceId == null) {
            dest.writeInt(INSTANCE_ID_NULL);
        } else {
            dest.writeInt(INSTANCE_ID_NOT_NULL);
            dest.writeInt(mCharacteristicInstanceId);
        }
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
     * @return mock target service incetanceId {@link BluetoothGattService#getInstanceId()}
     */
    @Nullable
    public Integer getServiceInstanceId() {
        return mServiceInstanceId;
    }

    /**
     * @return mock target characteristic UUID
     */
    @NonNull
    public UUID getCharacteristicUUID() {
        return mCharacteristicUUID;
    }

    /**
     * @return mock target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     */
    @Nullable
    public Integer getCharacteristicInstanceId() {
        return mCharacteristicInstanceId;
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
        int length = 58;
        byte[] data = new byte[66 + mValue.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putLong(mServiceUUID.getMostSignificantBits());
        byteBuffer.putLong(mServiceUUID.getLeastSignificantBits());
        if (mServiceInstanceId == null) {
            byteBuffer.put((byte) INSTANCE_ID_NULL);
        } else {
            byteBuffer.put((byte) INSTANCE_ID_NOT_NULL);
            byteBuffer.putInt(mServiceInstanceId);
            length += 4;
        }
        byteBuffer.putLong(mCharacteristicUUID.getMostSignificantBits());
        byteBuffer.putLong(mCharacteristicUUID.getLeastSignificantBits());
        if (mCharacteristicInstanceId == null) {
            byteBuffer.put((byte) INSTANCE_ID_NULL);
        } else {
            byteBuffer.put((byte) INSTANCE_ID_NOT_NULL);
            byteBuffer.putInt(mCharacteristicInstanceId);
            length += 4;
        }
        byteBuffer.putLong(mDescriptorUUID.getMostSignificantBits());
        byteBuffer.putLong(mDescriptorUUID.getLeastSignificantBits());
        byteBuffer.putInt(mTargetType);
        byteBuffer.putInt(mStatus);
        byteBuffer.put(mValue);
        length += mValue.length;
        return Arrays.copyOfRange(data, 0, length);
    }

}
