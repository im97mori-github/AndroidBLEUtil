package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERIAL_NUMBER_STRING_CHARACTERISTIC;

/**
 * Serial number string (Characteristics UUID: 0x2A25)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SerialNumberString implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SerialNumberString> CREATOR = new ByteArrayCreater<SerialNumberString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SerialNumberString createFromParcel(@NonNull Parcel in) {
            return new SerialNumberString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SerialNumberString[] newArray(int size) {
            return new SerialNumberString[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SerialNumberString createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SerialNumberString(bluetoothGattCharacteristic);
        }

    };

    /**
     * Serial number
     */
    private final String mSerialNumber;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A25
     */
    public SerialNumberString(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mSerialNumber = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SerialNumberString(@NonNull Parcel in) {
        mSerialNumber = in.readString();
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
        dest.writeString(mSerialNumber);
    }

    /**
     * @return Serial number
     */
    public String getSerialNumber() {
        return mSerialNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mSerialNumber.getBytes();
    }

}
