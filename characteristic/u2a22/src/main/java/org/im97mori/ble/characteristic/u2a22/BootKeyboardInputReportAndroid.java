package org.im97mori.ble.characteristic.u2a22;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOOT_KEYBOARD_INPUT_REPORT_CHARACTERISTIC;

/**
 * Boot Keyboard Input Report (Characteristics UUID: 0x2A22)
 */
@SuppressWarnings({"WeakerAccess"})
public class BootKeyboardInputReportAndroid extends BootKeyboardInputReport implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BootKeyboardInputReportAndroid> CREATOR = new ByteArrayCreater<BootKeyboardInputReportAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardInputReportAndroid createFromParcel(@NonNull Parcel in) {
            return new BootKeyboardInputReportAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardInputReportAndroid[] newArray(int size) {
            return new BootKeyboardInputReportAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootKeyboardInputReportAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOOT_KEYBOARD_INPUT_REPORT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BootKeyboardInputReportAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A22
     */
    public BootKeyboardInputReportAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private BootKeyboardInputReportAndroid(@NonNull Parcel in) {
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
