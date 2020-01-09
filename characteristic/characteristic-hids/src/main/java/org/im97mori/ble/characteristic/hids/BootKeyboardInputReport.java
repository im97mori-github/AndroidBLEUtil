package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOOT_KEYBOARD_INPUT_REPORT_CHARACTERISTIC;

/**
 * Boot Keyboard Input Report (Characteristics UUID: 0x2A22)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BootKeyboardInputReport implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BootKeyboardInputReport> CREATOR = new ByteArrayCreater<BootKeyboardInputReport>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardInputReport createFromParcel(@NonNull Parcel in) {
            return new BootKeyboardInputReport(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardInputReport[] newArray(int size) {
            return new BootKeyboardInputReport[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootKeyboardInputReport createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOOT_KEYBOARD_INPUT_REPORT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BootKeyboardInputReport(bluetoothGattCharacteristic);
        }

    };

    /**
     * Boot Keyboard Input Report Value
     */
    private final byte[] mBootKeyboardInputReportValue;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A22
     */
    public BootKeyboardInputReport(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mBootKeyboardInputReportValue = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BootKeyboardInputReport(@NonNull Parcel in) {
        mBootKeyboardInputReportValue = in.createByteArray();
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
        dest.writeByteArray(mBootKeyboardInputReportValue);
    }

    /**
     * @return Boot Keyboard Input Report Value
     */
    public byte[] getBootKeyboardInputReportValue() {
        return mBootKeyboardInputReportValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mBootKeyboardInputReportValue;
    }

}
