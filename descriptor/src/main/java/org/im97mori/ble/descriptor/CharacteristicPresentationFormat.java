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

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

/**
 * Characteristic Presentation Format (Descriptor UUID: 0x2904)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CharacteristicPresentationFormat implements ByteArrayInterface, Parcelable {

    /**
     * Format:Boolean
     */
    public static final int FORMAT_BOOLEAN = 0x01;

    /**
     * Format:unsigned 2-bit integer
     */
    public static final int FORMAT_UNSIGNED_2_BIT_INTEGER = 0x02;

    /**
     * Format:unsigned 4-bit integer
     */
    public static final int FORMAT_UNSIGNED_4_BIT_INTEGER = 0x03;

    /**
     * Format:unsigned 8-bit integer
     */
    public static final int FORMAT_UNSIGNED_8_BIT_INTEGER = 0x04;

    /**
     * Format:unsigned 12-bit integer
     */
    public static final int FORMAT_UNSIGNED_12_BIT_INTEGER = 0x05;

    /**
     * Format:unsigned 16-bit integer
     */
    public static final int FORMAT_UNSIGNED_16_BIT_INTEGER = 0x06;

    /**
     * Format:unsigned 24-bit integer
     */
    public static final int FORMAT_UNSIGNED_24_BIT_INTEGER = 0x07;

    /**
     * Format:unsigned 32-bit integer
     */
    public static final int FORMAT_UNSIGNED_32_BIT_INTEGER = 0x08;

    /**
     * Format:unsigned 48-bit integer
     */
    public static final int FORMAT_UNSIGNED_48_BIT_INTEGER = 0x09;

    /**
     * Format:unsigned 64-bit integer
     */
    public static final int FORMAT_UNSIGNED_64_BIT_INTEGER = 0x0a;

    /**
     * Format:unsigned 128-bit integer
     */
    public static final int FORMAT_UNSIGNED_128_BIT_INTEGER = 0x0b;

    /**
     * Format:signed 8-bit integer
     */
    public static final int FORMAT_SIGNED_8_BIT_INTEGER = 0x0c;

    /**
     * Format:signed 12-bit integer
     */
    public static final int FORMAT_SIGNED_12_BIT_INTEGER = 0x0d;

    /**
     * Format:signed 16-bit integer
     */
    public static final int FORMAT_SIGNED_16_BIT_INTEGER = 0x0e;

    /**
     * Format:signed 24-bit integer
     */
    public static final int FORMAT_SIGNED_24_BIT_INTEGER = 0x0f;

    /**
     * Format:signed 32-bit integer
     */
    public static final int FORMAT_SIGNED_32_BIT_INTEGER = 0xa0;

    /**
     * Format:signed 48-bit integer
     */
    public static final int FORMAT_SIGNED_48_BIT_INTEGER = 0xa1;

    /**
     * Format:signed 64-bit integer
     */
    public static final int FORMAT_SIGNED_64_BIT_INTEGER = 0xa2;

    /**
     * Format:signed 128-bit integer
     */
    public static final int FORMAT_SIGNED_128_BIT_INTEGER = 0xa3;

    /**
     * Format:IEEE-754 32-bit floating point
     */
    public static final int FORMAT_IEEE_754_32_BIT_FLOATING_POINT = 0xa4;

    /**
     * Format:IEEE-754 64-bit floating point
     */
    public static final int FORMAT_IEEE_754_64_BIT_FLOATING_POINT = 0xa5;

    /**
     * Format:IEEE-11073 16-bit SFLOAT
     */
    public static final int FORMAT_IEEE_11073_16_BIT_SFLOAT = 0xa7;

    /**
     * Format:IEEE-11073 32-bit FLOAT
     */
    public static final int FORMAT_IEEE_11073_32_BIT_FLOAT = 0xa8;

    /**
     * Format:IEEE-20601 format
     */
    public static final int FORMAT_IEEE_20601_FORMAT = 0xa9;

    /**
     * Format:UTF-8 string
     */
    public static final int FORMAT_UTF_8_STRING = 0xaa;

    /**
     * Format:UTF-16 string
     */
    public static final int FORMAT_UTF_16_STRING = 0xab;

    /**
     * Format:Opaque Structure
     */
    public static final int FORMAT_OPAQUE_STRUCTURE = 0xac;

    /**
     * Namespace:Bluetooth SIG Assigned Numbers
     */
    public static final int NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS = 0x01;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CharacteristicPresentationFormat> CREATOR = new ByteArrayCreater<CharacteristicPresentationFormat>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicPresentationFormat createFromParcel(Parcel in) {
            return new CharacteristicPresentationFormat(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicPresentationFormat[] newArray(int size) {
            return new CharacteristicPresentationFormat[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicPresentationFormat createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new CharacteristicPresentationFormat(bluetoothGattDescriptor);
        }

    };

    /**
     * Format
     */
    private final int mFormat;

    /**
     * Exponent
     */
    private final int mExponent;

    /**
     * Unit
     */
    private final int mUnit;

    /**
     * Namespace
     */
    private final int mNamespace;

    /**
     * Description
     */
    private final byte[] mDescription;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2904
     */
    public CharacteristicPresentationFormat(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mFormat = values[0] & 0xff;
        mExponent = values[1];
        mUnit = (values[2] & 0xff) | ((values[3] & 0xff) << 8);
        mNamespace = values[4] & 0xff;
        mDescription = Arrays.copyOfRange(values, 5, 7);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicPresentationFormat(Parcel in) {
        mFormat = in.readInt();
        mExponent = in.readInt();
        mUnit = in.readInt();
        mNamespace = in.readInt();
        mDescription = in.createByteArray();
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
        dest.writeInt(mFormat);
        dest.writeInt(mExponent);
        dest.writeInt(mUnit);
        dest.writeInt(mNamespace);
        dest.writeByteArray(mDescription);
    }

    /**
     * @return Format
     */
    public int getFormat() {
        return mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_BOOLEAN}, {@code false}:not {@link #FORMAT_BOOLEAN}
     */
    public boolean isFormatBoolean() {
        return FORMAT_BOOLEAN == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_2_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_2_BIT_INTEGER}
     */
    public boolean isFormatUnsigned2BitInteger() {
        return FORMAT_UNSIGNED_2_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_4_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_4_BIT_INTEGER}
     */
    public boolean isFormatUnsigned4BitInteger() {
        return FORMAT_UNSIGNED_4_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_8_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_8_BIT_INTEGER}
     */
    public boolean isFormatUnsigned8BitInteger() {
        return FORMAT_UNSIGNED_8_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_12_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_12_BIT_INTEGER}
     */
    public boolean isFormatUnsigned12BitInteger() {
        return FORMAT_UNSIGNED_12_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_16_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_16_BIT_INTEGER}
     */
    public boolean isFormatUnsigned16BitInteger() {
        return FORMAT_UNSIGNED_16_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_24_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_24_BIT_INTEGER}
     */
    public boolean isFormatUnsigned24BitInteger() {
        return FORMAT_UNSIGNED_24_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_32_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_32_BIT_INTEGER}
     */
    public boolean isFormatUnsigned32BitInteger() {
        return FORMAT_UNSIGNED_32_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_48_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_48_BIT_INTEGER}
     */
    public boolean isFormatUnsigned48BitInteger() {
        return FORMAT_UNSIGNED_48_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_64_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_64_BIT_INTEGER}
     */
    public boolean isFormatUnsigned64BitInteger() {
        return FORMAT_UNSIGNED_64_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UNSIGNED_128_BIT_INTEGER}, {@code false}:not {@link #FORMAT_UNSIGNED_128_BIT_INTEGER}
     */
    public boolean isFormatUnsigned128BitInteger() {
        return FORMAT_UNSIGNED_128_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_8_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_8_BIT_INTEGER}
     */
    public boolean isFormatSigned8BitInteger() {
        return FORMAT_SIGNED_8_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_12_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_12_BIT_INTEGER}
     */
    public boolean isFormatSigned12BitInteger() {
        return FORMAT_SIGNED_12_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_16_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_16_BIT_INTEGER}
     */
    public boolean isFormatSigned16BitInteger() {
        return FORMAT_SIGNED_16_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_24_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_24_BIT_INTEGER}
     */
    public boolean isFormatSigned24BitInteger() {
        return FORMAT_SIGNED_24_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_32_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_32_BIT_INTEGER}
     */
    public boolean isFormatSigned32BitInteger() {
        return FORMAT_SIGNED_32_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_48_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_48_BIT_INTEGER}
     */
    public boolean isFormatSigned48BitInteger() {
        return FORMAT_SIGNED_48_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_64_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_64_BIT_INTEGER}
     */
    public boolean isFormatSigned64BitInteger() {
        return FORMAT_SIGNED_64_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_SIGNED_128_BIT_INTEGER}, {@code false}:not {@link #FORMAT_SIGNED_128_BIT_INTEGER}
     */
    public boolean isFormatSigned128BitInteger() {
        return FORMAT_SIGNED_128_BIT_INTEGER == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_IEEE_754_32_BIT_FLOATING_POINT}, {@code false}:not {@link #FORMAT_IEEE_754_32_BIT_FLOATING_POINT}
     */
    public boolean isFormatIEEE754_32BitFloatingPoint() {
        return FORMAT_IEEE_754_32_BIT_FLOATING_POINT == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_IEEE_754_64_BIT_FLOATING_POINT}, {@code false}:not {@link #FORMAT_IEEE_754_64_BIT_FLOATING_POINT}
     */
    public boolean isFormatIEEE754_64BitFloatingPoint() {
        return FORMAT_IEEE_754_64_BIT_FLOATING_POINT == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_IEEE_11073_16_BIT_SFLOAT}, {@code false}:not {@link #FORMAT_IEEE_11073_16_BIT_SFLOAT}
     */
    public boolean isFormatIEEE11073_16BitSfloat() {
        return FORMAT_IEEE_11073_16_BIT_SFLOAT == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_IEEE_11073_32_BIT_FLOAT}, {@code false}:not {@link #FORMAT_IEEE_11073_32_BIT_FLOAT}
     */
    public boolean isFormatIEEE11073_32BitFloat() {
        return FORMAT_IEEE_11073_32_BIT_FLOAT == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_IEEE_20601_FORMAT}, {@code false}:not {@link #FORMAT_IEEE_20601_FORMAT}
     */
    public boolean isFormatIEEE20601Format() {
        return FORMAT_IEEE_20601_FORMAT == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UTF_8_STRING}, {@code false}:not {@link #FORMAT_UTF_8_STRING}
     */
    public boolean isFormatUtf8String() {
        return FORMAT_UTF_8_STRING == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_UTF_16_STRING}, {@code false}:not {@link #FORMAT_UTF_16_STRING}
     */
    public boolean isFormatUtf16String() {
        return FORMAT_UTF_16_STRING == mFormat;
    }

    /**
     * @return {@code true}:format is {@link #FORMAT_OPAQUE_STRUCTURE}, {@code false}:not {@link #FORMAT_OPAQUE_STRUCTURE}
     */
    public boolean isFormatOpaqueStructure() {
        return FORMAT_OPAQUE_STRUCTURE == mFormat;
    }

    /**
     * @return Exponent
     */
    public int getExponent() {
        return mExponent;
    }

    /**
     * @return Unit
     */
    public int getUnit() {
        return mUnit;
    }

    /**
     * @return Namespace
     */
    public int getNamespace() {
        return mNamespace;
    }

    /**
     * @return {@code true}:namespace is {@link #NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS}, {@code false}:not {@link #NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS}
     */
    public boolean isNamespaceBluetoothSigAssignedNumbers() {
        return (mNamespace & 0xff) == NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS;
    }

    /**
     * @return Description
     */
    @NonNull
    public byte[] getDescription() {
        return mDescription;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[7];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFormat);
        byteBuffer.put((byte) mExponent);
        byteBuffer.putShort((short) mUnit);
        byteBuffer.put((byte) mNamespace);
        byteBuffer.put(mDescription);
        return data;
    }

}
