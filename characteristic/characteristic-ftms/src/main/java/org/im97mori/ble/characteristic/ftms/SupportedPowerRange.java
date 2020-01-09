package org.im97mori.ble.characteristic.ftms;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_POWER_RANGE_CHARACTERISTIC;

/**
 * Supported Power Range (Characteristics UUID: 0x2AD8)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedPowerRange implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedPowerRange> CREATOR = new ByteArrayCreater<SupportedPowerRange>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedPowerRange createFromParcel(@NonNull Parcel in) {
            return new SupportedPowerRange(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedPowerRange[] newArray(int size) {
            return new SupportedPowerRange[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedPowerRange createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedPowerRange(bluetoothGattCharacteristic);
        }

    };

    /**
     * Minimum Power
     */
    private final int mMinimumPower;

    /**
     * Maximum Power
     */
    private final int mMaximumPower;

    /**
     * Minimum Increment
     */
    private final int mMinimumIncrement;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD8
     */
    public SupportedPowerRange(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMinimumPower = BLEUtils.createSInt16(values, 0);
        mMaximumPower = BLEUtils.createSInt16(values, 2);
        mMinimumIncrement = BLEUtils.createUInt16(values, 4);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedPowerRange(@NonNull Parcel in) {
        mMinimumPower = in.readInt();
        mMaximumPower = in.readInt();
        mMinimumIncrement = in.readInt();
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
        dest.writeInt(mMinimumPower);
        dest.writeInt(mMaximumPower);
        dest.writeInt(mMinimumIncrement);
    }

    /**
     * @return Minimum Power
     */
    public int getMinimumPower() {
        return mMinimumPower;
    }

    /**
     * @return Maximum Power
     */
    public int getMaximumPower() {
        return mMaximumPower;
    }

    /**
     * @return Minimum Increment
     */
    public int getMinimumIncrement() {
        return mMinimumIncrement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[6];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mMinimumPower);
        byteBuffer.putShort((short) mMaximumPower);
        byteBuffer.putShort((short) mMinimumIncrement);
        return data;
    }

}
