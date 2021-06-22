package org.im97mori.ble.descriptor.u290a;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;

/**
 * Value Trigger Setting (Descriptor UUID: 0x290A)
 */
@SuppressWarnings({"WeakerAccess"})
public class ValueTriggerSettingAndroid extends ValueTriggerSetting implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ValueTriggerSettingAndroid> CREATOR = new ByteArrayCreater<ValueTriggerSettingAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ValueTriggerSettingAndroid createFromParcel(@NonNull Parcel in) {
            return new ValueTriggerSettingAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ValueTriggerSettingAndroid[] newArray(int size) {
            return new ValueTriggerSettingAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ValueTriggerSettingAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290A
     */
    public ValueTriggerSettingAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param condition      Condition
     * @param valueAnalog    Value (Analog)
     * @param valueBitMask   Value (Bit Mask)
     * @param valueAnalogOne Value (Analog Interval One)
     * @param valueAnalogTwo Value (Analog Interval Two)
     */
    public ValueTriggerSettingAndroid(int condition, int valueAnalog, @NonNull byte[] valueBitMask, int valueAnalogOne, int valueAnalogTwo) {
        super(condition, valueAnalog, valueBitMask, valueAnalogOne, valueAnalogTwo);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ValueTriggerSettingAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
