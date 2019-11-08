package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;

/**
 * Environmental Sensing Trigger Setting (Descriptor UUID: 0x290D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EnvironmentalSensingTriggerSetting implements ByteArrayInterface, Parcelable {

    /**
     * Conditions:Trigger inactive
     */
    public static final int CONDITIONS_TRIGGER_INACTIVE = 0x00;

    /**
     * Conditions:Use a fixed time interval between transmissions
     */
    public static final int CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS = 0x01;

    /**
     * Conditions:No less than the specified time between transmissions
     */
    public static final int CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS = 0x02;

    /**
     * Conditions:When value changes compared to previous value
     */
    public static final int CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE = 0x03;

    /**
     * Conditions:While less than the specified value
     */
    public static final int CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE = 0x04;

    /**
     * Conditions:While less than or equal to the specified value
     */
    public static final int CONDITIONS_TRIGGER_WHILE_LESS_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE = 0x05;

    /**
     * Conditions:While greater than the specified value
     */
    public static final int CONDITIONS_TRIGGER_WHILE_GREATER_THAN_THE_SPECIFIED_VALUE = 0x06;

    /**
     * Conditions:While greater than or equal to the specified value
     */
    public static final int CONDITIONS_TRIGGER_WHILE_GREATER_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE = 0x07;

    /**
     * Conditions:While equal to the specified value
     */
    public static final int CONDITIONS_TRIGGER_WHILE_EQUAL_TO_THE_SPECIFIED_VALUE = 0x08;

    /**
     * Conditions:While not equal to the specified value
     */
    public static final int CONDITIONS_TRIGGER_WHILE_NOT_EQUAL_TO_THE_SPECIFIED_VALUE = 0x09;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnvironmentalSensingTriggerSetting> CREATOR = new ByteArrayCreater<EnvironmentalSensingTriggerSetting>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingTriggerSetting createFromParcel(Parcel in) {
            return new EnvironmentalSensingTriggerSetting(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingTriggerSetting[] newArray(int size) {
            return new EnvironmentalSensingTriggerSetting[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnvironmentalSensingTriggerSetting createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new EnvironmentalSensingTriggerSetting(bluetoothGattDescriptor);
        }

    };

    /**
     * Conditions
     */
    private final int mConditions;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290D
     */
    public EnvironmentalSensingTriggerSetting(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mConditions = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnvironmentalSensingTriggerSetting(Parcel in) {
        mConditions = in.readInt();
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
        dest.writeInt(mConditions);
    }

    /**
     * @return Conditions
     */
    public int getConditions() {
        return mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_INACTIVE}, {@code false}:not {@link #CONDITIONS_TRIGGER_INACTIVE}
     */
    public boolean isConditionsTriggerInactive() {
        return CONDITIONS_TRIGGER_INACTIVE == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS}, {@code false}:not {@link #CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS}
     */
    public boolean isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions() {
        return CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS}, {@code false}:not {@link #CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS}
     */
    public boolean isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions() {
        return CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE}, {@code false}:not {@link #CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE}
     */
    public boolean isConditionsTriggerWhenValueChangesComparedToPreviousValue() {
        return CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE}, {@code false}:not {@link #CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE}
     */
    public boolean isConditionsTriggerWhileLessThanTheSpecifiedValue() {
        return CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_WHILE_LESS_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE}, {@code false}:not {@link #CONDITIONS_TRIGGER_WHILE_LESS_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE}
     */
    public boolean isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue() {
        return CONDITIONS_TRIGGER_WHILE_LESS_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_WHILE_GREATER_THAN_THE_SPECIFIED_VALUE}, {@code false}:not {@link #CONDITIONS_TRIGGER_WHILE_GREATER_THAN_THE_SPECIFIED_VALUE}
     */
    public boolean isConditionsTriggerWhileGreaterThanTheSpecifiedValue() {
        return CONDITIONS_TRIGGER_WHILE_GREATER_THAN_THE_SPECIFIED_VALUE == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_WHILE_GREATER_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE}, {@code false}:not {@link #CONDITIONS_TRIGGER_WHILE_GREATER_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE}
     */
    public boolean isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue() {
        return CONDITIONS_TRIGGER_WHILE_GREATER_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_WHILE_EQUAL_TO_THE_SPECIFIED_VALUE}, {@code false}:not {@link #CONDITIONS_TRIGGER_WHILE_EQUAL_TO_THE_SPECIFIED_VALUE}
     */
    public boolean isConditionsTriggerWhileEqualToTheSpecifiedValue() {
        return CONDITIONS_TRIGGER_WHILE_EQUAL_TO_THE_SPECIFIED_VALUE == mConditions;
    }

    /**
     * @return {@code true}:conditions is {@link #CONDITIONS_TRIGGER_WHILE_NOT_EQUAL_TO_THE_SPECIFIED_VALUE}, {@code false}:not {@link #CONDITIONS_TRIGGER_WHILE_NOT_EQUAL_TO_THE_SPECIFIED_VALUE}
     */
    public boolean isConditionsTriggerWhileNotEqualToTheSpecifiedValue() {
        return CONDITIONS_TRIGGER_WHILE_NOT_EQUAL_TO_THE_SPECIFIED_VALUE == mConditions;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mConditions);
        return data;
    }

}
