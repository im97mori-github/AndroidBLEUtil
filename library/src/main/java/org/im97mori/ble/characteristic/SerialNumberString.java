package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Serial number string (Characteristics UUID: 0x2A25)
 */
@SuppressWarnings("WeakerAccess")
public class SerialNumberString extends AbstractCharacteristic implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<SerialNumberString> CREATOR = new Creator<SerialNumberString>() {

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
