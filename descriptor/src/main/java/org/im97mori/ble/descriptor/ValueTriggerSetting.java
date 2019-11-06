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

import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;

/**
 * Value Trigger Setting (Descriptor UUID: 0x290A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ValueTriggerSetting implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ValueTriggerSetting> CREATOR = new ByteArrayCreater<ValueTriggerSetting>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ValueTriggerSetting createFromParcel(Parcel in) {
            return new ValueTriggerSetting(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ValueTriggerSetting[] newArray(int size) {
            return new ValueTriggerSetting[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ValueTriggerSetting createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ValueTriggerSetting(bluetoothGattDescriptor);
        }

    };

    /**
     * Condition
     */
    private final int mCondition;

    /**
     * Value (Analog)
     */
    private final int mValueAnalog;

    /**
     * Value (Bit Mask)
     */
    private final byte[] mValueBitMask;

    /**
     * Value (Analog Interval)
     */
    private final long mValueAnalogInterval;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290A
     */
    public ValueTriggerSetting(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mCondition = (values[0] & 0xff);
        mValueAnalog = (values[1] & 0xff) | ((values[2] & 0xff) << 8);
        mValueBitMask = Arrays.copyOfRange(values, 3, values.length - 4);
        mValueAnalogInterval = (values[3] & 0xff) | ((values[4] & 0xff) << 8) | ((values[5] & 0xff) << 16) | ((values[6] & 0xff) << 24);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ValueTriggerSetting(Parcel in) {
        mCondition = in.readInt();
        mValueAnalog = in.readInt();
        mValueBitMask = in.createByteArray();
        mValueAnalogInterval = in.readLong();
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
        dest.writeInt(mCondition);
        dest.writeInt(mValueAnalog);
        dest.writeByteArray(mValueBitMask);
        dest.writeLong(mValueAnalogInterval);
    }

    /**
     * @return Condition
     */
    public int getCondition() {
        return mCondition;
    }

    /**
     * @return Value (Analog)
     */
    public int getValueAnalog() {
        return mValueAnalog;
    }

    /**
     * @return Value (Bit Mask)
     */
    @NonNull
    public byte[] getValueBitMask() {
        return mValueBitMask;
    }

    /**
     * @return Value (Analog Interval)
     */
    public long getValueAnalogInterval() {
        return mValueAnalogInterval;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[7 + mValueBitMask.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCondition);
        byteBuffer.putShort((short) mValueAnalog);
        byteBuffer.put(mValueBitMask);
        byteBuffer.putInt((int) mValueAnalogInterval);
        return data;
    }

}
