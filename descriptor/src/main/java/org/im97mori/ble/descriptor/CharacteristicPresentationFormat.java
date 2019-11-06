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
    private final byte mFormat;

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
    private final byte mNamespace;

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
        mFormat = values[0];
        mExponent = values[1];
        mUnit = (values[2] & 0xff) | ((values[3] & 0xff) << 8);
        mNamespace = values[4];
        mDescription = Arrays.copyOfRange(values, 5, 7);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicPresentationFormat(Parcel in) {
        mFormat = in.readByte();
        mExponent = in.readInt();
        mUnit = in.readInt();
        mNamespace = in.readByte();
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
        dest.writeByte(mFormat);
        dest.writeInt(mExponent);
        dest.writeInt(mUnit);
        dest.writeByte(mNamespace);
        dest.writeByteArray(mDescription);
    }

    /**
     * @return Format
     */
    public byte getFormat() {
        return mFormat;
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
    public byte getNamespace() {
        return mNamespace;
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
        byteBuffer.put(mFormat);
        byteBuffer.put((byte) mExponent);
        byteBuffer.putShort((short) mUnit);
        byteBuffer.put(mNamespace);
        byteBuffer.put(mDescription);
        return data;
    }

}
