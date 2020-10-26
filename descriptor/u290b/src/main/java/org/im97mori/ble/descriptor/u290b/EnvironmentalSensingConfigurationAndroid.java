package org.im97mori.ble.descriptor.u290b;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;

/**
 * Environmental Sensing Configuration (Descriptor UUID: 0x290B)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnvironmentalSensingConfigurationAndroid extends EnvironmentalSensingConfiguration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnvironmentalSensingConfigurationAndroid> CREATOR = new ByteArrayCreater<EnvironmentalSensingConfigurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingConfigurationAndroid createFromParcel(@NonNull Parcel in) {
            return new EnvironmentalSensingConfigurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingConfigurationAndroid[] newArray(int size) {
            return new EnvironmentalSensingConfigurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnvironmentalSensingConfigurationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new EnvironmentalSensingConfigurationAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290B
     */
    public EnvironmentalSensingConfigurationAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param triggerLogicValue Trigger Logic Value
     */
    public EnvironmentalSensingConfigurationAndroid(int triggerLogicValue) {
        super(triggerLogicValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnvironmentalSensingConfigurationAndroid(@NonNull Parcel in) {
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
