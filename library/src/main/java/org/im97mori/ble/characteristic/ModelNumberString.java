package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model number string (Characteristics UUID: 0x2A24)
 */
@SuppressWarnings("WeakerAccess")
public class ModelNumberString extends AbstractCharacteristic implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<ModelNumberString> CREATOR = new Creator<ModelNumberString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ModelNumberString createFromParcel(Parcel in) {
            return new ModelNumberString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ModelNumberString[] newArray(int size) {
            return new ModelNumberString[size];
        }

    };

    /**
     * Model number
     */
    private final String mModelNumber;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A24
     */
    public ModelNumberString(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mModelNumber = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ModelNumberString(Parcel in) {
        mModelNumber = in.readString();
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
        dest.writeString(mModelNumber);
    }

    /**
     * @return Model number
     */
    public String getModelNumber() {
        return mModelNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        return mModelNumber.getBytes();
    }

}
