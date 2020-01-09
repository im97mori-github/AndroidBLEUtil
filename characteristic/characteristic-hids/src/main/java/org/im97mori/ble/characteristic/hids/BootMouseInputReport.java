package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOOT_MOUSE_INPUT_REPORT_CHARACTERISTIC;

/**
 * Boot Mouse Input Report (Characteristics UUID: 0x2A33)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BootMouseInputReport implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BootMouseInputReport> CREATOR = new ByteArrayCreater<BootMouseInputReport>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootMouseInputReport createFromParcel(@NonNull Parcel in) {
            return new BootMouseInputReport(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootMouseInputReport[] newArray(int size) {
            return new BootMouseInputReport[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootMouseInputReport createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOOT_MOUSE_INPUT_REPORT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BootMouseInputReport(bluetoothGattCharacteristic);
        }

    };

    /**
     * Boot Mouse Input Report Value
     */
    private final byte[] mBootMouseInputReportValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A33
     */
    public BootMouseInputReport(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mBootMouseInputReportValue = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BootMouseInputReport(@NonNull Parcel in) {
        mBootMouseInputReportValue = in.createByteArray();
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
        dest.writeByteArray(mBootMouseInputReportValue);
    }

    /**
     * @return Boot Mouse Input Report Value
     */
    public byte[] getBootMouseInputReportValue() {
        return mBootMouseInputReportValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mBootMouseInputReportValue;
    }

}
