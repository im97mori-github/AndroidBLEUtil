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
