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

import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;

/**
 * Valid Range (Descriptor UUID: 0x2906)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ValidRange implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ValidRange> CREATOR = new ByteArrayCreater<ValidRange>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRange createFromParcel(Parcel in) {
            return new ValidRange(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRange[] newArray(int size) {
            return new ValidRange[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ValidRange createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ValidRange(bluetoothGattDescriptor);
        }

    };

    /**
     * Lower inclusive value
     */
    private final byte[] mLowerInclusiveValue;

    /**
     * Upper inclusive value
     */
    private final byte[] mUpperInclusiveValue;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2906
     */
    public ValidRange(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mLowerInclusiveValue = Arrays.copyOfRange(values, 0, values.length / 2);
        mUpperInclusiveValue = Arrays.copyOfRange(values, values.length / 2, values.length);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ValidRange(Parcel in) {
        mLowerInclusiveValue = in.createByteArray();
        mUpperInclusiveValue = in.createByteArray();
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
        dest.writeByteArray(mLowerInclusiveValue);
        dest.writeByteArray(mUpperInclusiveValue);
    }

    /**
     * @return Lower inclusive value
     */
    @NonNull
    public byte[] getLowerInclusiveValue() {
        return mLowerInclusiveValue;
    }

    /**
     * <p>
     * Gust Factor (Characteristic UUID: 0x2A74)
     * UV Index (Characteristic UUID: 0x2A76)
     * Barometric Pressure Trend (Characteristic UUID: 0x2AA3)
     * </p>
     *
     * @return Lower inclusive value(UINT8)
     */
    public int getLowerInclusiveValueUint8() {
        return 0xff & mLowerInclusiveValue[0];
    }

    /**
     * <p>
     * Analog (Characteristic UUID: 0x2A58)
     * Apparent Wind Direction (Characteristic UUID: 0x2A73)
     * Apparent Wind Speed (Characteristic UUID: 0x2A72)
     * Humidity (Characteristic UUID: 0x2A6F)
     * Irradiance (Characteristic UUID: 0x2A77)
     * Rainfall (Characteristic UUID: 0x2A78)
     * True Wind Direction (Characteristic UUID: 0x2A71)
     * True Wind Speed (Characteristic UUID: 0x2A70)
     * Magnetic Declination (Characteristic UUID: 0x2A2C)
     * </p>
     *
     * @return Lower inclusive value(UINT16)
     */
    public int getLowerInclusiveValueUint16() {
        return (0xff & mLowerInclusiveValue[0]) | ((0xff & mLowerInclusiveValue[1]) << 8);
    }

    /**
     * <p>
     * Pollen Concentration (Characteristic UUID: 0x2A75)
     * </p>
     *
     * @return Lower inclusive value(UINT24)
     */
    public int getLowerInclusiveValueUint24() {
        return (0xff & mLowerInclusiveValue[0]) | ((0xff & mLowerInclusiveValue[1]) << 8) | ((0xff & mLowerInclusiveValue[2]) << 16);
    }

    /**
     * <p>
     * Pressure (Characteristic UUID: 0x2A6D)
     * </p>
     *
     * @return Lower inclusive value(UINT32)
     */
    public long getLowerInclusiveValueUint32() {
        return (0xff & mLowerInclusiveValue[0]) | ((0xff & mLowerInclusiveValue[1]) << 8) | ((0xff & mLowerInclusiveValue[2]) << 16) | ((0xff & mLowerInclusiveValue[3]) << 24);
    }

    /**
     * <p>
     * Dew Point (Characteristic UUID: 0x2A7B)
     * Heat Index (Characteristic UUID: 0x2A7A)
     * Wind Chill (Characteristic UUID: 0x2A79)
     * </p>
     *
     * @return Lower inclusive value(SINT8)
     */
    public int getLowerInclusiveValueSint8() {
        return mLowerInclusiveValue[0];
    }

    /**
     * <p>
     * Temperature (Characteristic UUID: 0x2A6E)
     * Magnetic Flux Density - 2D (Characteristic UUID: 0x2AA0)
     * Magnetic Flux Density - 3D (Characteristic UUID: 0x2AA1)
     * </p>
     *
     * @return Lower inclusive value(SINT16)
     */
    public int getLowerInclusiveValueSint16() {
        return (0xff & mLowerInclusiveValue[0]) | (mLowerInclusiveValue[1] << 8);
    }

    /**
     * <p>
     * Elevation (Characteristic UUID: 0x2A6C)
     * </p>
     *
     * @return Lower inclusive value(SINT24)
     */
    public int getLowerInclusiveValueSint24() {
        return (0xff & mLowerInclusiveValue[0]) | ((0xff & mLowerInclusiveValue[1]) << 8) | (mLowerInclusiveValue[2] << 16);
    }

    /**
     * @return Upper inclusive value
     */
    @NonNull
    public byte[] getUpperInclusiveValue() {
        return mUpperInclusiveValue;
    }

    /**
     * <p>
     * Gust Factor (Characteristic UUID: 0x2A74)
     * UV Index (Characteristic UUID: 0x2A76)
     * Barometric Pressure Trend (Characteristic UUID: 0x2AA3)
     * </p>
     *
     * @return Upper inclusive value(UINT8)
     */
    public int getUpperInclusiveValueUint8() {
        return 0xff & mUpperInclusiveValue[0];
    }

    /**
     * <p>
     * Analog (Characteristic UUID: 0x2A58)
     * Apparent Wind Direction (Characteristic UUID: 0x2A73)
     * Apparent Wind Speed (Characteristic UUID: 0x2A72)
     * Humidity (Characteristic UUID: 0x2A6F)
     * Irradiance (Characteristic UUID: 0x2A77)
     * Rainfall (Characteristic UUID: 0x2A78)
     * True Wind Direction (Characteristic UUID: 0x2A71)
     * True Wind Speed (Characteristic UUID: 0x2A70)
     * Magnetic Declination (Characteristic UUID: 0x2A2C)
     * </p>
     *
     * @return Upper inclusive value(UINT16)
     */
    public int getUpperInclusiveValueUint16() {
        return (0xff & mUpperInclusiveValue[0]) | ((0xff & mUpperInclusiveValue[1]) << 8);
    }

    /**
     * <p>
     * Pollen Concentration (Characteristic UUID: 0x2A75)
     * </p>
     *
     * @return Upper inclusive value(UINT24)
     */
    public int getUpperInclusiveValueUint24() {
        return (0xff & mUpperInclusiveValue[0]) | ((0xff & mUpperInclusiveValue[1]) << 8) | ((0xff & mUpperInclusiveValue[2]) << 16);
    }

    /**
     * <p>
     * Pressure (Characteristic UUID: 0x2A6D)
     * </p>
     *
     * @return Upper inclusive value(UINT32)
     */
    public long getUpperInclusiveValueUint32() {
        return (0xff & mUpperInclusiveValue[0]) | ((0xff & mUpperInclusiveValue[1]) << 8) | ((0xff & mUpperInclusiveValue[2]) << 16) | ((0xff & mUpperInclusiveValue[3]) << 24);
    }

    /**
     * <p>
     * Dew Point (Characteristic UUID: 0x2A7B)
     * Heat Index (Characteristic UUID: 0x2A7A)
     * Wind Chill (Characteristic UUID: 0x2A79)
     * </p>
     *
     * @return Upper inclusive value(SINT8)
     */
    public int getUpperInclusiveValueSint8() {
        return mUpperInclusiveValue[0];
    }

    /**
     * <p>
     * Temperature (Characteristic UUID: 0x2A6E)
     * Magnetic Flux Density - 2D (Characteristic UUID: 0x2AA0)
     * Magnetic Flux Density - 3D (Characteristic UUID: 0x2AA1)
     * </p>
     *
     * @return Upper inclusive value(SINT16)
     */
    public int getUpperInclusiveValueSint16() {
        return (0xff & mUpperInclusiveValue[0]) | (mUpperInclusiveValue[1] << 8);
    }

    /**
     * <p>
     * Elevation (Characteristic UUID: 0x2A6C)
     * </p>
     *
     * @return Upper inclusive value(SINT24)
     */
    public int getUpperInclusiveValueSint24() {
        return (0xff & mUpperInclusiveValue[0]) | ((0xff & mUpperInclusiveValue[1]) << 8) | (mUpperInclusiveValue[2] << 16);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[mLowerInclusiveValue.length + mUpperInclusiveValue.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mLowerInclusiveValue);
        byteBuffer.put(mUpperInclusiveValue);
        return data;
    }

}
