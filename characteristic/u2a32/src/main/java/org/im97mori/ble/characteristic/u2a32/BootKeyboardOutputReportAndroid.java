package org.im97mori.ble.characteristic.u2a32;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOOT_KEYBOARD_OUTPUT_REPORT_CHARACTERISTIC;

/**
 * Boot Keyboard Output Report (Characteristics UUID: 0x2A32)
 */
@SuppressWarnings({"WeakerAccess"})
public class BootKeyboardOutputReportAndroid extends BootKeyboardOutputReport implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BootKeyboardOutputReportAndroid> CREATOR = new ByteArrayCreater<BootKeyboardOutputReportAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardOutputReportAndroid createFromParcel(@NonNull Parcel in) {
            return new BootKeyboardOutputReportAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardOutputReportAndroid[] newArray(int size) {
            return new BootKeyboardOutputReportAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootKeyboardOutputReportAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOOT_KEYBOARD_OUTPUT_REPORT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BootKeyboardOutputReportAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A32
     */
    public BootKeyboardOutputReportAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BootKeyboardOutputReportAndroid(@NonNull Parcel in) {
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
