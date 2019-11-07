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
     * Condition:The state is changed if the characteristic value is changed
     */
    public static final int CONDITION_THE_STATE_IS_CHANGED_IF_THE_CHARACTERISTIC_VALUE_IS_CHANGED = 0x00;

    /**
     * Condition:Crossed a boundary
     */
    public static final int CONDITION_CROSSED_A_BOUNDARY = 0x01;

    /**
     * Condition:On the boundary
     */
    public static final int CONDITION_ON_THE_BOUNDARY = 0x02;

    /**
     * Condition:The state is changed if the value of the analog characteristic is changed more than a settable Analog value
     */
    public static final int CONDITION_THE_STATE_IS_CHANGED_IF_THE_VALUE_OF_THE_ANALOG_CHARACTERISTIC_IS_CHANGED_MORE_THAN_A_SETTABLE_ANALOG_VALUE = 0x03;

    /**
     * Condition:Mask then compare
     */
    public static final int CONDITION_MASK_THEN_COMPARE = 0x04;

    /**
     * Condition:Inside or outside the boundaries
     */
    public static final int CONDITION_INSIDE_OR_OUTSIDE_THE_BOUNDARIES = 0x05;

    /**
     * Condition:On the boundaries
     */
    public static final int CONDITION_ON_THE_BOUNDARIES = 0x06;

    /**
     * Condition:No value trigger
     */
    public static final int CONDITION_NO_VALUE_TRIGGER = 0x07;

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
     * @return {@code true}:condition is {@link #CONDITION_THE_STATE_IS_CHANGED_IF_THE_CHARACTERISTIC_VALUE_IS_CHANGED}, {@code false}:not {@link #CONDITION_THE_STATE_IS_CHANGED_IF_THE_CHARACTERISTIC_VALUE_IS_CHANGED}
     */
    public boolean isConditionTheStateIsChangeIfTheCharacteristicValueIsChanged() {
        return CONDITION_THE_STATE_IS_CHANGED_IF_THE_CHARACTERISTIC_VALUE_IS_CHANGED == mCondition;
    }

    /**
     * @return {@code true}:condition is {@link #CONDITION_CROSSED_A_BOUNDARY}, {@code false}:not {@link #CONDITION_CROSSED_A_BOUNDARY}
     */
    public boolean isConditionCrossedABoundary() {
        return CONDITION_CROSSED_A_BOUNDARY == mCondition;
    }

    /**
     * @return {@code true}:condition is {@link #CONDITION_ON_THE_BOUNDARY}, {@code false}:not {@link #CONDITION_ON_THE_BOUNDARY}
     */
    public boolean isConditionOnTheBoundary() {
        return CONDITION_ON_THE_BOUNDARY == mCondition;
    }

    /**
     * @return {@code true}:condition is {@link #CONDITION_THE_STATE_IS_CHANGED_IF_THE_VALUE_OF_THE_ANALOG_CHARACTERISTIC_IS_CHANGED_MORE_THAN_A_SETTABLE_ANALOG_VALUE}, {@code false}:not {@link #CONDITION_THE_STATE_IS_CHANGED_IF_THE_VALUE_OF_THE_ANALOG_CHARACTERISTIC_IS_CHANGED_MORE_THAN_A_SETTABLE_ANALOG_VALUE}
     */
    public boolean isConditionTheStateIsChangedIfTheValueOfTheAnalogCharacteristicIsChangedMoreThanASettableAnalogValue() {
        return CONDITION_THE_STATE_IS_CHANGED_IF_THE_VALUE_OF_THE_ANALOG_CHARACTERISTIC_IS_CHANGED_MORE_THAN_A_SETTABLE_ANALOG_VALUE == mCondition;
    }

    /**
     * @return {@code true}:condition is {@link #CONDITION_MASK_THEN_COMPARE}, {@code false}:not {@link #CONDITION_MASK_THEN_COMPARE}
     */
    public boolean isConditionMaskThenCompare() {
        return CONDITION_MASK_THEN_COMPARE == mCondition;
    }

    /**
     * @return {@code true}:condition is {@link #CONDITION_INSIDE_OR_OUTSIDE_THE_BOUNDARIES}, {@code false}:not {@link #CONDITION_INSIDE_OR_OUTSIDE_THE_BOUNDARIES}
     */
    public boolean isConditionInsideOrOutsideTheBoundaries() {
        return CONDITION_INSIDE_OR_OUTSIDE_THE_BOUNDARIES == mCondition;
    }

    /**
     * @return {@code true}:condition is {@link #CONDITION_ON_THE_BOUNDARIES}, {@code false}:not {@link #CONDITION_ON_THE_BOUNDARIES}
     */
    public boolean isConditionOnTheBoundaries() {
        return CONDITION_ON_THE_BOUNDARIES == mCondition;
    }

    /**
     * @return {@code true}:condition is {@link #CONDITION_NO_VALUE_TRIGGER}, {@code false}:not {@link #CONDITION_NO_VALUE_TRIGGER}
     */
    public boolean isConditionNoValueTrigger() {
        return CONDITION_NO_VALUE_TRIGGER == mCondition;
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
