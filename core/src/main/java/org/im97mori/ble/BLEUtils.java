package org.im97mori.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

import androidx.annotation.NonNull;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * BLE Core Utilities
 */
@SuppressWarnings("WeakerAccess")
public class BLEUtils {

    /**
     * ISO/IEEE Std. 11073-20601™-2008 FLOAT NaN (Not a Number)
     */
    public static final int FLOAT_NAN = 0x007FFFFF;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 FLOAT NRes (Not at this Resolution)
     */
    public static final int FLOAT_NRES = 0x00800000;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 FLOAT + INFINITY
     */
    public static final int FLOAT_POSITIVE_INFINITY = 0x007FFFFE;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 FLOAT – INFINITY
     */
    public static final int FLOAT_NEGATIVE_INFINITY = 0x00800002;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 FLOAT Reserved for future use
     */
    public static final int FLOAT_RFU = 0x00800001;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 SFLOAT NaN (Not a Number)
     */
    public static final int SFLOAT_NAN = 0x07ff;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 SFLOAT NRes (Not at this Resolution)
     */
    public static final int SFLOAT_NRES = 0x0800;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 SFLOAT + INFINITY
     */
    public static final int SFLOAT_POSITIVE_INFINITY = 0x07fe;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 SFLOAT – INFINITY
     */
    public static final int SFLOAT_NEGATIVE_INFINITY = 0x0802;

    /**
     * ISO/IEEE Std. 11073-20601™-2008 SFLOAT Reserved for future use
     */
    public static final int SFLOAT_RFU = 0x0801;

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
     * create signed 12-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x0D)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return signed 12-bit integer
     */
    public static int createSInt12(@NonNull byte[] data, int offset) {
        return createSInt12(data, offset, 0);
    }

    /**
     * <p>
     * create signed 12-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x0D)
     * </p>
     *
     * @param data        byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset      data offset
     * @param shiftOffset shift offset
     * @return signed 12-bit integer
     */
    public static int createSInt12(@NonNull byte[] data, int offset, int shiftOffset) {
        return createByteBuffer(data, offset + (shiftOffset / 8), 2, Short.SIZE / 8).getShort() << (20 - shiftOffset % 8) >> 20;
    }

    /**
     * <p>
     * create unsigned 12-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x05)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 12-bit integer
     */
    public static int createUInt12(@NonNull byte[] data, int offset) {
        return createUInt12(data, offset, 0);
    }

    /**
     * <p>
     * create unsigned 12-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x05)
     * </p>
     *
     * @param data        byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset      data offset
     * @param shiftOffset shift offset
     * @return unsigned 12-bit integer
     */
    public static int createUInt12(@NonNull byte[] data, int offset, int shiftOffset) {
        return createSInt12(data, offset, shiftOffset) & 0x00000fff;
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
     * @return signed 24-bit integer
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
     * @return unsigned 24-bit integer
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
     * @return signed 32-bit integer
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
     * @return unsigned 32-bit integer
     */
    public static long createUInt32(@NonNull byte[] data, int offset) {
        return createSInt32(data, offset) & 0xffffffffL;
    }

    /**
     * <p>
     * create unsigned 40-bit integer
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 40-bit integer
     */
    public static long createUInt40(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 5, Long.SIZE / 8).getLong() & 0xffffffffffL;
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
     * @return unsigned 48-bit integer
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
     * @return unsigned 48-bit integer
     */
    public static long createUInt48(@NonNull byte[] data, int offset) {
        return createSInt48(data, offset) & 0xffffffffffffL;
    }

    /**
     * <p>
     * create unsigned 128-bit integer
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x09)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return unsigned 128-bit {@link BigInteger}
     */
    public static BigInteger createUInt128(@NonNull byte[] data, int offset) {
        return createBigInteger(data, offset, 16);
    }

    /**
     * <p>
     * create IEEE-11073 32-bit FLOAT manitissa
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x17)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return IEEE-11073 32-bit FLOAT manitissa
     */
    public static int createFloatManitissa(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 3, Integer.SIZE / 8).getInt() << 8 >> 8;
    }

    /**
     * <p>
     * create IEEE-11073 32-bit FLOAT exponent
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x17)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return IEEE-11073 32-bit SFLOAT exponent
     */
    public static int createFloatExponent(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset + 3, 1, Integer.SIZE / 8).getInt() << 24 >> 24;
    }

    /**
     * <p>
     * create IEEE-11073 32-bit FLOAT
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x17)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return IEEE-11073 32-bit FLOAT
     */
    public static double createFloat(@NonNull byte[] data, int offset) {
        return createFloatManitissa(data, offset) * Math.pow(10, createFloatExponent(data, offset));
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 FLOAT NaN (Not a Number), {@code false}:not ISO/IEEE Std. 11073-20601™-2008 FLOAT NaN (Not a Number)
     */
    public static boolean isFloatNan(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 4, Integer.SIZE / 8).getInt();
        return FLOAT_NAN == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 FLOAT NRes (Not at this Resolution), {@code false}:not ISO/IEEE Std. 11073-20601™-2008 FLOAT NRes (Not at this Resolution)
     */
    public static boolean isFloatNres(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 4, Integer.SIZE / 8).getInt();
        return FLOAT_NRES == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 FLOAT + INFINITY, {@code false}:not ISO/IEEE Std. 11073-20601™-2008 FLOAT + INFINITY
     */
    public static boolean isFloatPositiveInfinity(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 4, Integer.SIZE / 8).getInt();
        return FLOAT_POSITIVE_INFINITY == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 FLOAT – INFINITY, {@code false}:not ISO/IEEE Std. 11073-20601™-2008 FLOAT – INFINITY
     */
    public static boolean isFloatNegativeInfinity(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 4, Integer.SIZE / 8).getInt();
        return FLOAT_NEGATIVE_INFINITY == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 FLOAT Reserved for future use, {@code false}:not ISO/IEEE Std. 11073-20601™-2008 FLOAT Reserved for future use
     */
    public static boolean isFloatRfu(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 4, Integer.SIZE / 8).getInt();
        return FLOAT_RFU == sfloat;
    }

    /**
     * <p>
     * create IEEE-11073 16-bit SFLOAT manitissa
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x16)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return IEEE-11073 16-bit SFLOAT manitissa
     */
    public static int createSfloatManitissa(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset, 2, Integer.SIZE / 8).getInt() << 20 >> 20;
    }

    /**
     * <p>
     * create IEEE-11073 16-bit SFLOAT exponent
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x16)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return IEEE-11073 16-bit SFLOAT exponent
     */
    public static int createSfloatExponent(@NonNull byte[] data, int offset) {
        return createByteBuffer(data, offset + 1, 1, Integer.SIZE / 8).getInt() << 24 >> 28;
    }

    /**
     * <p>
     * create IEEE-11073 16-bit SFLOAT
     * <p>
     * Core Specification v5.1 Vol 3 Part G 3.3.3.5.2 Format Table 3.16 (0x16)
     * </p>
     *
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return IEEE-11073 16-bit SFLOAT
     */
    public static double createSfloat(@NonNull byte[] data, int offset) {
        return createSfloatManitissa(data, offset) * Math.pow(10, createSfloatExponent(data, offset));
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 SFLOAT NaN (Not a Number), {@code false}:not ISO/IEEE Std. 11073-20601™-2008 SFLOAT NaN (Not a Number)
     */
    public static boolean isSfloatNan(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 2, Integer.SIZE / 8).getInt();
        return SFLOAT_NAN == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 SFLOAT NRes (Not at this Resolution), {@code false}:not ISO/IEEE Std. 11073-20601™-2008 SFLOAT NRes (Not at this Resolution)
     */
    public static boolean isSfloatNres(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 2, Integer.SIZE / 8).getInt();
        return SFLOAT_NRES == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 SFLOAT + INFINITY, {@code false}:not ISO/IEEE Std. 11073-20601™-2008 SFLOAT + INFINITY
     */
    public static boolean isSfloatPositiveInfinity(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 2, Integer.SIZE / 8).getInt();
        return SFLOAT_POSITIVE_INFINITY == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 SFLOAT – INFINITY, {@code false}:not ISO/IEEE Std. 11073-20601™-2008 SFLOAT – INFINITY
     */
    public static boolean isSfloatNegativeInfinity(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 2, Integer.SIZE / 8).getInt();
        return SFLOAT_NEGATIVE_INFINITY == sfloat;
    }

    /**
     * @param data   byte array from {@link BluetoothGattCharacteristic#getValue()} or {@link BluetoothGattDescriptor#getValue()}
     * @param offset data offset
     * @return {@code true}:ISO/IEEE Std. 11073-20601™-2008 SFLOAT Reserved for future use, {@code false}:not ISO/IEEE Std. 11073-20601™-2008 SFLOAT Reserved for future use
     */
    public static boolean isSfloatRfu(@NonNull byte[] data, int offset) {
        int sfloat = createByteBuffer(data, offset, 2, Integer.SIZE / 8).getInt();
        return SFLOAT_RFU == sfloat;
    }

    /**
     * Create {@link BigInteger} instance
     *
     * @param data   {@link BluetoothGattCharacteristic#getValue()}
     * @param offset offset for time counter 8bytes data
     * @param length second parameter length of {@link BigInteger#BigInteger(int, byte[])}
     * @return Unsigned 64bit(8bytes) integer value
     */
    public static BigInteger createBigInteger(@NonNull byte[] data, int offset, int length) {
        // little to big endian
        byte[] reversed = new byte[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = data[length - i - 1 + offset];
        }
        return new BigInteger(1, reversed);
    }

    /**
     * Create little-endian byte array from {@link BigInteger}
     *
     * @param bigInteger original BigInteger instance
     * @param length     byte array length
     * @return little-endian byte array
     */
    public static byte[] createLittleEndianByteArrayFromBigInteger(@NonNull BigInteger bigInteger, int length) {
        byte[] original = bigInteger.toByteArray();
        byte[] data = new byte[length];
        if (bigInteger.signum() == -1) {
            Arrays.fill(data, (byte) -1);
        }
        for (int i = 0; i < original.length; i++) {
            data[i] = original[original.length - i - 1];
        }
        return data;
    }

    /**
     * create int from byte array
     *
     * @param data         byte array
     * @param offset       data offset
     * @param inputLength  input length from offset
     * @param outputLength output length
     * @return {@link ByteOrder#LITTLE_ENDIAN} {@link ByteBuffer} instance
     */
    private static ByteBuffer createByteBuffer(@NonNull byte[] data, int offset, int inputLength, int outputLength) {
        ByteBuffer buffer = ByteBuffer.allocate(outputLength).order(ByteOrder.LITTLE_ENDIAN).put(data, offset, inputLength);
        buffer.position(0);
        return buffer;
    }

}
