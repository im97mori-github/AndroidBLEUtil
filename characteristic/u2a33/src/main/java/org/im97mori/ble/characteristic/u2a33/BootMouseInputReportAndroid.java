package org.im97mori.ble.characteristic.u2a33;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BOOT_MOUSE_INPUT_REPORT_CHARACTERISTIC;

/**
 * Boot Mouse Input Report (Characteristics UUID: 0x2A33)
 */
@SuppressWarnings({"WeakerAccess"})
public class BootMouseInputReportAndroid extends BootMouseInputReport implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BootMouseInputReportAndroid> CREATOR = new ByteArrayCreater<BootMouseInputReportAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootMouseInputReportAndroid createFromParcel(@NonNull Parcel in) {
            return new BootMouseInputReportAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootMouseInputReportAndroid[] newArray(int size) {
            return new BootMouseInputReportAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootMouseInputReportAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOOT_MOUSE_INPUT_REPORT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BootMouseInputReportAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A33
     */
    public BootMouseInputReportAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BootMouseInputReportAndroid(@NonNull Parcel in) {
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
