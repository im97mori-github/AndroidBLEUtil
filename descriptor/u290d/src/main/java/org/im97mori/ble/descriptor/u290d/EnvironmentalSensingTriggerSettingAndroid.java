package org.im97mori.ble.descriptor.u290d;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Environmental Sensing Trigger Setting (Descriptor UUID: 0x290D)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnvironmentalSensingTriggerSettingAndroid extends EnvironmentalSensingTriggerSetting implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EnvironmentalSensingTriggerSettingAndroid> CREATOR = new ByteArrayCreator<EnvironmentalSensingTriggerSettingAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingTriggerSettingAndroid createFromParcel(@NonNull Parcel in) {
            return new EnvironmentalSensingTriggerSettingAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingTriggerSettingAndroid[] newArray(int size) {
            return new EnvironmentalSensingTriggerSettingAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnvironmentalSensingTriggerSettingAndroid createFromByteArray(@NonNull byte[] values) {
            return new EnvironmentalSensingTriggerSettingAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290D
     */
    @Deprecated
    public EnvironmentalSensingTriggerSettingAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public EnvironmentalSensingTriggerSettingAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param conditions Conditions
     */
    public EnvironmentalSensingTriggerSettingAndroid(int conditions) {
        super(conditions);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnvironmentalSensingTriggerSettingAndroid(@NonNull Parcel in) {
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
