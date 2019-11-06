package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;

/**
 * Environmental Sensing Configuration (Descriptor UUID: 0x290B)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EnvironmentalSensingConfiguration implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnvironmentalSensingConfiguration> CREATOR = new ByteArrayCreater<EnvironmentalSensingConfiguration>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingConfiguration createFromParcel(Parcel in) {
            return new EnvironmentalSensingConfiguration(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingConfiguration[] newArray(int size) {
            return new EnvironmentalSensingConfiguration[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnvironmentalSensingConfiguration createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new EnvironmentalSensingConfiguration(bluetoothGattDescriptor);
        }

    };

    /**
     * Trigger Logic Value
     */
    private final int mTriggerLogicValue;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290B
     */
    public EnvironmentalSensingConfiguration(BluetoothGattDescriptor bluetoothGattDescriptor) {
        byte[] values = bluetoothGattDescriptor.getValue();
        mTriggerLogicValue = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnvironmentalSensingConfiguration(Parcel in) {
        mTriggerLogicValue = in.readInt();
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
        dest.writeInt(mTriggerLogicValue);
    }

    /**
     * @return Trigger Logic Value
     */
    public int getTriggerLogicValue() {
        return mTriggerLogicValue;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mTriggerLogicValue);
        return data;
    }

}
