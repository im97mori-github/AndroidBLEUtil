package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOOT_KEYBOARD_OUTPUT_REPORT_CHARACTERISTIC;

/**
 * Boot Keyboard Output Report (Characteristics UUID: 0x2A32)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BootKeyboardOutputReport implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BootKeyboardOutputReport> CREATOR = new ByteArrayCreater<BootKeyboardOutputReport>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardOutputReport createFromParcel(@NonNull Parcel in) {
            return new BootKeyboardOutputReport(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardOutputReport[] newArray(int size) {
            return new BootKeyboardOutputReport[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootKeyboardOutputReport createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOOT_KEYBOARD_OUTPUT_REPORT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BootKeyboardOutputReport(bluetoothGattCharacteristic);
        }

    };

    /**
     * Boot Keyboard Output Report Value
     */
    private final byte[] mBootKeyboardOutputReportValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A32
     */
    public BootKeyboardOutputReport(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mBootKeyboardOutputReportValue = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BootKeyboardOutputReport(@NonNull Parcel in) {
        mBootKeyboardOutputReportValue = in.createByteArray();
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
        dest.writeByteArray(mBootKeyboardOutputReportValue);
    }

    /**
     * @return Boot Keyboard Output Report Value
     */
    public byte[] getBootKeyboardOutputReportValue() {
        return mBootKeyboardOutputReportValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mBootKeyboardOutputReportValue;
    }

}
