package org.im97mori.ble.characteristic.scps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SCAN_REFRESH_CHARACTERISTIC;

/**
 * Scan Refresh (Characteristics UUID: 0x2A31)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ScanRefresh implements ByteArrayInterface, Parcelable {

    /**
     * 0x00: Server requires refresh
     */
    public static final int SCAN_REFRESH_VALUE_SERVER_REQUIRES_REFRESH = 0x00;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ScanRefresh> CREATOR = new ByteArrayCreater<ScanRefresh>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanRefresh createFromParcel(@NonNull Parcel in) {
            return new ScanRefresh(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanRefresh[] newArray(int size) {
            return new ScanRefresh[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ScanRefresh createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SCAN_REFRESH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ScanRefresh(bluetoothGattCharacteristic);
        }

    };

    /**
     * Scan Refresh Value
     */
    private final int mScanRefreshValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A31
     */
    public ScanRefresh(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mScanRefreshValue = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ScanRefresh(@NonNull Parcel in) {
        mScanRefreshValue = in.readInt();
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
        dest.writeInt(mScanRefreshValue);
    }

    /**
     * @return Scan Refresh Value
     */
    public int getScanRefreshValue() {
        return mScanRefreshValue;
    }

    /**
     * @return {@code true}:Server requires refresh, {@code false}:not Server requires refresh
     */
    public boolean isScanRefreshValueServerRequiresRefresh() {
        return SCAN_REFRESH_VALUE_SERVER_REQUIRES_REFRESH == mScanRefreshValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mScanRefreshValue);
        return data;
    }

}
