package org.im97mori.ble.descriptor.u290e;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;

/**
 * Time Trigger Setting (Descriptor UUID: 0x290E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TimeTriggerSettingAndroid extends TimeTriggerSetting implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeTriggerSettingAndroid> CREATOR = new ByteArrayCreater<TimeTriggerSettingAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public TimeTriggerSettingAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeTriggerSettingAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public TimeTriggerSettingAndroid[] newArray(int size) {
            return new TimeTriggerSettingAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeTriggerSettingAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(TIME_TRIGGER_SETTING_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290E
     */
    public TimeTriggerSettingAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param condition          Condition
     * @param valueNone          Value (None)
     * @param valueTimerInterval Value (Time Interval)
     * @param valueCount         Value (Count)
     */
    public TimeTriggerSettingAndroid(int condition, int valueNone, int valueTimerInterval, int valueCount) {
        super(condition, valueNone, valueTimerInterval, valueCount);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TimeTriggerSettingAndroid(@NonNull Parcel in) {
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
