package org.im97mori.ble.characteristic.scps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SCAN_INTERVAL_WINDOW_CHARACTERISTIC;

/**
 * Scan Interval Window (Characteristics UUID: 0x2A4F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ScanIntervalWindow implements ByteArrayInterface, Parcelable {

    /**
     * LE_Scan_Interval Unit 0.625 ms
     */
    public static final double LE_SCAN_INTERVAL_RESOLUTION = 0.625d;

    /**
     * LE_Scan_Window Unit 0.625 ms
     */
    public static final double LE_SCAN_WINDOW_RESOLUTION = 0.625d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ScanIntervalWindow> CREATOR = new ByteArrayCreater<ScanIntervalWindow>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanIntervalWindow createFromParcel(@NonNull Parcel in) {
            return new ScanIntervalWindow(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanIntervalWindow[] newArray(int size) {
            return new ScanIntervalWindow[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ScanIntervalWindow createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SCAN_INTERVAL_WINDOW_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ScanIntervalWindow(bluetoothGattCharacteristic);
        }

    };

    /**
     * LE_Scan_Interval
     */
    private final int mLeScanInterval;

    /**
     * LE_Scan_Window
     */
    private final int mLeScanWindow;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4F
     */
    public ScanIntervalWindow(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLeScanInterval = BLEUtils.createUInt16(values, 0);
        mLeScanWindow = BLEUtils.createUInt16(values, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ScanIntervalWindow(@NonNull Parcel in) {
        mLeScanInterval = in.readInt();
        mLeScanWindow = in.readInt();
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
        dest.writeInt(mLeScanInterval);
        dest.writeInt(mLeScanWindow);
    }

    /**
     * @return LE_Scan_Interval
     */
    public int getLeScanInterval() {
        return mLeScanInterval;
    }

    /**
     * @return LE_Scan_Interval(ms)
     */
    public double getLeScanIntervalMs() {
        return LE_SCAN_INTERVAL_RESOLUTION * mLeScanInterval;
    }

    /**
     * @return LE_Scan_Window
     */
    public int getLeScanWindow() {
        return mLeScanWindow;
    }

    /**
     * @return LE_Scan_Window(ms)
     */
    public double getLeScanWindowMs() {
        return LE_SCAN_WINDOW_RESOLUTION * mLeScanWindow;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mLeScanInterval);
        byteBuffer.putShort((short) mLeScanWindow);
        return data;
    }

}
