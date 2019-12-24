package org.im97mori.ble.characteristic.hts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MEASUREMENT_INTERVAL_CHARACTERISTIC;

/**
 * Measurement Interval (Characteristics UUID: 0x2A21)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MeasurementInterval implements ByteArrayInterface, Parcelable {

    /**
     * 0: No periodic measurement
     */
    public static final int MEASUREMENT_INTERVAL_NO_PERIODIC_MEASUREMENT = 0;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MeasurementInterval> CREATOR = new ByteArrayCreater<MeasurementInterval>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeasurementInterval createFromParcel(@NonNull Parcel in) {
            return new MeasurementInterval(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeasurementInterval[] newArray(int size) {
            return new MeasurementInterval[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MeasurementInterval createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MeasurementInterval(bluetoothGattCharacteristic);
        }

    };

    /**
     * Measurement Interval
     */
    private final int mMeasurementInterval;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A21
     */
    public MeasurementInterval(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMeasurementInterval = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MeasurementInterval(@NonNull Parcel in) {
        mMeasurementInterval = in.readInt();
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
        dest.writeInt(mMeasurementInterval);
    }

    /**
     * @return Measurement Interval
     */
    public int getMeasurementInterval() {
        return mMeasurementInterval;
    }

    /**
     * @return {@code true}:No periodic measurement, {@code false}:periodic measurement
     */
    public boolean isMeasurementIntevalNoPeriodicMeasurement() {
        return MEASUREMENT_INTERVAL_NO_PERIODIC_MEASUREMENT == mMeasurementInterval;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mMeasurementInterval);
        return data;
    }

}
