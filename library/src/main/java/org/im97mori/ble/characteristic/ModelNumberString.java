package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MODEL_NUMBER_STRING_CHARACTERISTIC;

/**
 * Model number string (Characteristics UUID: 0x2A24)
 */
@SuppressWarnings("WeakerAccess")
public class ModelNumberString extends AbstractCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ModelNumberString> CREATOR = new ByteArrayCreater<ModelNumberString>() {

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

        /**
         * {@inheritDoc}
         */
        public ModelNumberString createFromByteArray(byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ModelNumberString(bluetoothGattCharacteristic);
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
