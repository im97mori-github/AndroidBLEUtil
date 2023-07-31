package org.im97mori.ble.descriptor.u290a;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Value Trigger Setting (Descriptor UUID: 0x290A)
 */
@SuppressWarnings({"WeakerAccess"})
public class ValueTriggerSettingAndroid extends ValueTriggerSetting implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ValueTriggerSettingAndroid> CREATOR = new ByteArrayCreator<ValueTriggerSettingAndroid>() {

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
            return new ValueTriggerSettingAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290A
     */
    @Deprecated
    public ValueTriggerSettingAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public ValueTriggerSettingAndroid(@NonNull byte[] values) {
        super(values);
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
        super(Objects.requireNonNull(in.createByteArray()));
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
