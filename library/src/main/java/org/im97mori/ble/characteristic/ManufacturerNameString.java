package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Manufacturer name string (Characteristics UUID: 0x2A28)
 */
@SuppressWarnings("WeakerAccess")
public class ManufacturerNameString extends AbstractCharacteristic implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<ManufacturerNameString> CREATOR = new Creator<ManufacturerNameString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ManufacturerNameString createFromParcel(Parcel in) {
            return new ManufacturerNameString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ManufacturerNameString[] newArray(int size) {
            return new ManufacturerNameString[size];
        }

    };

    /**
     * Manufacture name
     */
    private final String mManufactureName;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A28
     */
    public ManufacturerNameString(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mManufactureName = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ManufacturerNameString(Parcel in) {
        mManufactureName = in.readString();
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
        dest.writeString(mManufactureName);
    }

    /**
     * @return Manufacture name
     */
    public String getManufactureName() {
        return mManufactureName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        return mManufactureName.getBytes();
    }

}
