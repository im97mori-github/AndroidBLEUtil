package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REPORT_CHARACTERISTIC;

/**
 * Report (Characteristics UUID: 0x2A4D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Report implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Report> CREATOR = new ByteArrayCreater<Report>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Report createFromParcel(@NonNull Parcel in) {
            return new Report(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Report[] newArray(int size) {
            return new Report[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Report createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(REPORT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Report(bluetoothGattCharacteristic);
        }

    };

    /**
     * Report Value
     */
    private final byte[] mReportValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4D
     */
    public Report(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mReportValue = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Report(@NonNull Parcel in) {
        mReportValue = in.createByteArray();
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
        dest.writeByteArray(mReportValue);
    }

    /**
     * @return Report Value
     */
    public byte[] getReportValue() {
        return mReportValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mReportValue;
    }

}
