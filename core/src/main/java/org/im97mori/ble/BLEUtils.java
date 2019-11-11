package org.im97mori.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

import androidx.annotation.NonNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * BLE Core Utilities
 */
@SuppressWarnings("WeakerAccess")
public class BLEUtils {

    /**
     * <p>
     * create signed 8-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x01)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 1-bit; 0 = false, 1 = true
     */
    public static int createBoolean(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 1, Byte.SIZE / 8).get() & 0x00000001;
    }

    /**
     * <p>
     * create signed 8-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x0C)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return signed 8-bit integer
     */
    public static int createSInt8(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 1, Byte.SIZE / 8).get();
    }

    /**
     * <p>
     * create unsigned 8-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x04)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 8-bit integer
     */
    public static int createUInt8(@NonNull byte[] data, int offset) {
        return createSInt8(data, offset) & 0x000000ff;
    }

    /**
     * <p>
     * create signed 16-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x0E)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return signed 16-bit integer
     */
    public static int createSInt16(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 2, Short.SIZE / 8).getShort();
    }

    /**
     * <p>
     * create unsigned 16-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x06)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 16-bit integer
     */
    public static int createUInt16(@NonNull byte[] data, int offset) {
        return createSInt16(data, offset) & 0x0000ffff;
    }

    /**
     * <p>
     * create signed 24-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x0F)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return signed 16-bit integer
     */
    public static int createSInt24(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 3, Integer.SIZE / 8).getInt() << 8 >> 8;
    }

    /**
     * <p>
     * create unsigned 24-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x07)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 16-bit integer
     */
    public static int createUInt24(@NonNull byte[] data, int offset) {
        return createSInt24(data, offset) & 0x00ffffff;
    }

    /**
     * <p>
     * create signed 32-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x10)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return signed 16-bit integer
     */
    public static int createSInt32(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 4, Integer.SIZE / 8).getInt();
    }

    /**
     * <p>
     * create unsigned 32-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x08)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 16-bit integer
     */
    public static long createUInt32(@NonNull byte[] data, int offset) {
        return createSInt32(data, offset) & 0xffffffffL;
    }

    /**
     * <p>
     * create signed 48-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x11)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 16-bit integer
     */
    public static long createSInt48(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 6, Long.SIZE / 8).getLong() << 16 >> 16;
    }

    /**
     * <p>
     * create unsigned 48-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x09)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 16-bit integer
     */
    public static long createUInt48(@NonNull byte[] data, int offset) {
        return createSInt48(data, offset) & 0xffffffffffffL;
    }

    /**
     * create int from byte array
     *
     * @param data         byte array
     * @param offset       data offset
     * @param inputLength  input length from offset
     * @param outputLength onput length
     * @return {@link ByteOrder#LITTLE_ENDIAN} {@link ByteBuffer} instance
     */
    private static ByteBuffer createByteBuffer(@NonNull byte[] data, int offset, int inputLength, int outputLength) {
        ByteBuffer buffer = ByteBuffer.allocate(outputLength).order(ByteOrder.LITTLE_ENDIAN).put(data, offset, inputLength);
        buffer.position(0);
        return buffer;
    }

}
