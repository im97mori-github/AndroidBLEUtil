package org.im97mori.ble.descriptor.u290d;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;

/**
 * Environmental Sensing Trigger Setting (Descriptor UUID: 0x290D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EnvironmentalSensingTriggerSettingAndroid extends EnvironmentalSensingTriggerSetting implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnvironmentalSensingTriggerSettingAndroid> CREATOR = new ByteArrayCreater<EnvironmentalSensingTriggerSettingAndroid>() {

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
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new EnvironmentalSensingTriggerSettingAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290D
     */
    public EnvironmentalSensingTriggerSettingAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
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
    @SuppressWarnings("ConstantConditions")
    private EnvironmentalSensingTriggerSettingAndroid(@NonNull Parcel in) {
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
