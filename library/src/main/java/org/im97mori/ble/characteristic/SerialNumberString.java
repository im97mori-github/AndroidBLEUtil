package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERIAL_NUMBER_STRING_CHARACTERISTIC;

/**
 * Serial number string (Characteristics UUID: 0x2A25)
 */
@SuppressWarnings("WeakerAccess")
public class SerialNumberString implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SerialNumberString> CREATOR = new ByteArrayCreater<SerialNumberString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public SerialNumberString createFromParcel(Parcel in) {
            return new SerialNumberString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public SerialNumberString[] newArray(int size) {
            return new SerialNumberString[size];
        }

        /**
         * {@inheritDoc}
         */
        public SerialNumberString createFromByteArray(byte[] values) {
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
    public SerialNumberString(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mSerialNumber = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SerialNumberString(Parcel in) {
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
    public void writeToParcel(Parcel dest, int flags) {
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
    public byte[] getBytes() {
        return mSerialNumber.getBytes();
    }

}
