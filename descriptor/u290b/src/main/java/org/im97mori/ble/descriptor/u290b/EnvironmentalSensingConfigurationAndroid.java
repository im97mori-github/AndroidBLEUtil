package org.im97mori.ble.descriptor.u290b;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Environmental Sensing Configuration (Descriptor UUID: 0x290B)
 */
@SuppressWarnings({"WeakerAccess"})
public class EnvironmentalSensingConfigurationAndroid extends EnvironmentalSensingConfiguration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EnvironmentalSensingConfigurationAndroid> CREATOR = new ByteArrayCreator<EnvironmentalSensingConfigurationAndroid>() {

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
            return new EnvironmentalSensingConfigurationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290B
     */
    @Deprecated
    public EnvironmentalSensingConfigurationAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public EnvironmentalSensingConfigurationAndroid(@NonNull byte[] values) {
        super(values);
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
