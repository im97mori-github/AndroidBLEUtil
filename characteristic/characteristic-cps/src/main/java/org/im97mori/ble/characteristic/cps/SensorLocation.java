package org.im97mori.ble.characteristic.cps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;

/**
 * Sensor Location (Characteristics UUID: 0x2A5D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SensorLocation implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SensorLocation> CREATOR = new ByteArrayCreater<SensorLocation>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SensorLocation createFromParcel(@NonNull Parcel in) {
            return new SensorLocation(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SensorLocation[] newArray(int size) {
            return new SensorLocation[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SensorLocation createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SensorLocation(bluetoothGattCharacteristic);
        }

    };

    /**
     * Sensor Location
     */
    private final int mSensorLocation;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5D
     */
    public SensorLocation(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mSensorLocation = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SensorLocation(@NonNull Parcel in) {
        mSensorLocation = in.readInt();
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
        dest.writeInt(mSensorLocation);
    }

    /**
     * @return Sensor Location
     */
    public int getSensorLocation() {
        return mSensorLocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mSensorLocation);
        return data;
    }

}
