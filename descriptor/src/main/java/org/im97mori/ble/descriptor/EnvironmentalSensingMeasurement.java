package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;

/**
 * Environmental Sensing Measurement (Descriptor UUID: 0x290C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class EnvironmentalSensingMeasurement implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnvironmentalSensingMeasurement> CREATOR = new ByteArrayCreater<EnvironmentalSensingMeasurement>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingMeasurement createFromParcel(Parcel in) {
            return new EnvironmentalSensingMeasurement(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnvironmentalSensingMeasurement[] newArray(int size) {
            return new EnvironmentalSensingMeasurement[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnvironmentalSensingMeasurement createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new EnvironmentalSensingMeasurement(bluetoothGattDescriptor);
        }

    };


    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x290C
     */
    public EnvironmentalSensingMeasurement(BluetoothGattDescriptor bluetoothGattDescriptor) {

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnvironmentalSensingMeasurement(Parcel in) {

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

    }


    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[0];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);

        return data;
    }

}
