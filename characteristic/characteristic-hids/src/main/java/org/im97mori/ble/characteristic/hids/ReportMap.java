package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REPORT_MAP_CHARACTERISTIC;

/**
 * Report Map (Characteristics UUID: 0x2A4B)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ReportMap implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReportMap> CREATOR = new ByteArrayCreater<ReportMap>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportMap createFromParcel(@NonNull Parcel in) {
            return new ReportMap(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportMap[] newArray(int size) {
            return new ReportMap[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReportMap createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(REPORT_MAP_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ReportMap(bluetoothGattCharacteristic);
        }

    };

    /**
     * Report Map Value
     */
    private final byte[] mReportMapValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4B
     */
    public ReportMap(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mReportMapValue = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReportMap(@NonNull Parcel in) {
        mReportMapValue = in.createByteArray();
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
        dest.writeByteArray(mReportMapValue);
    }

    /**
     * @return Report Map Value
     */
    public byte[] getReportMapValue() {
        return mReportMapValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mReportMapValue;
    }

}
