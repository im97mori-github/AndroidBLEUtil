package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Peripheral preferred connection parameters (Characteristics UUID: 0x2A04)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class PeripheralPreferredConnectionParameters implements ByteArrayInterface, Parcelable {

    /**
     * Unit: 1.25ms
     */
    public static final double MINIMUM_CONNECTION_INTERVAL_UNIT = 1.25d;

    /**
     * Unit: 1.25ms
     */
    public static final double MAXIMUM_CONNECTION_INTERVAL_UNIT = 1.25d;

    /**
     * Unit: 10ms
     */
    public static final double CONNECTION_SUPERVISION_TIMEOUT_MULTIPLIER_UNIT = 10d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PeripheralPreferredConnectionParameters> CREATOR = new ByteArrayCreater<PeripheralPreferredConnectionParameters>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPreferredConnectionParameters createFromParcel(@NonNull Parcel in) {
            return new PeripheralPreferredConnectionParameters(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPreferredConnectionParameters[] newArray(int size) {
            return new PeripheralPreferredConnectionParameters[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PeripheralPreferredConnectionParameters createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLEConstants.CharacteristicUUID.PERIPHERAL_PREFERRED_CONNECTION_PARAMATERS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PeripheralPreferredConnectionParameters(bluetoothGattCharacteristic);
        }

    };

    /**
     * Minimum connection interval
     */
    private final int mMinimumConnectionInterval;

    /**
     * Maximum connection interval
     */
    private final int mMaximumConnectionInterval;

    /**
     * Slave Latency
     */
    private final int mSlaveLatency;

    /**
     * Connection Supervision Timeout Multiplier
     */
    private final int mConnectionSupervisionTimeoutMultiplier;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A04
     */
    public PeripheralPreferredConnectionParameters(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mMinimumConnectionInterval = bluetoothGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, 0);
        mMaximumConnectionInterval = bluetoothGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, 2);
        mSlaveLatency = bluetoothGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, 4);
        mConnectionSupervisionTimeoutMultiplier = bluetoothGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, 6);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PeripheralPreferredConnectionParameters(@NonNull Parcel in) {
        mMinimumConnectionInterval = in.readInt();
        mMaximumConnectionInterval = in.readInt();
        mSlaveLatency = in.readInt();
        mConnectionSupervisionTimeoutMultiplier = in.readInt();
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
        dest.writeInt(mMinimumConnectionInterval);
        dest.writeInt(mMaximumConnectionInterval);
        dest.writeInt(mSlaveLatency);
        dest.writeInt(mConnectionSupervisionTimeoutMultiplier);
    }

    /**
     * @return Minimum connection interval
     */
    public int getMinimumConnectionInterval() {
        return mMinimumConnectionInterval;
    }

    /**
     * @return Minimum connection interval(millis)
     */
    public double getMinimumConnectionIntervalMillis() {
        return mMinimumConnectionInterval * MINIMUM_CONNECTION_INTERVAL_UNIT;
    }

    /**
     * @return Maximum connection interval
     */
    public int getMaximumConnectionInterval() {
        return mMaximumConnectionInterval;
    }

    /**
     * @return Maximum connection interval(millis)
     */
    public double getMaximumConnectionIntervalMillis() {
        return mMaximumConnectionInterval * MAXIMUM_CONNECTION_INTERVAL_UNIT;
    }

    /**
     * @return Slave Latency
     */
    public int getSlaveLatency() {
        return mSlaveLatency;
    }

    /**
     * @return Connection Supervision Timeout Multiplier
     */
    public int getConnectionSupervisionTimeoutMultiplier() {
        return mConnectionSupervisionTimeoutMultiplier;
    }

    /**
     * @return Connection Supervision Timeout Multiplier(millis)
     */
    public double getConnectionSupervisionTimeoutMultiplierMillis() {
        return mConnectionSupervisionTimeoutMultiplier * CONNECTION_SUPERVISION_TIMEOUT_MULTIPLIER_UNIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[8];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mMinimumConnectionInterval);
        byteBuffer.putShort((short) mMaximumConnectionInterval);
        byteBuffer.putShort((short) mSlaveLatency);
        byteBuffer.putShort((short) mConnectionSupervisionTimeoutMultiplier);
        return data;
    }

}
