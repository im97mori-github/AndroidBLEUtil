package org.im97mori.ble.descriptor.u290e;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Trigger Setting (Descriptor UUID: 0x290E)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeTriggerSettingAndroid extends TimeTriggerSetting implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeTriggerSettingAndroid> CREATOR = new ByteArrayCreator<TimeTriggerSettingAndroid>() {

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
            return new TimeTriggerSettingAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290E
     */
    @Deprecated
    public TimeTriggerSettingAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public TimeTriggerSettingAndroid(@NonNull byte[] values) {
        super(values);
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
    private TimeTriggerSettingAndroid(@NonNull Parcel in) {
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
