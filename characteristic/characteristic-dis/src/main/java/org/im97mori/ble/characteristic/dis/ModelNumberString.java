package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MODEL_NUMBER_STRING_CHARACTERISTIC;

/**
 * Model Number String (Characteristics UUID: 0x2A24)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ModelNumberString implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ModelNumberString> CREATOR = new ByteArrayCreater<ModelNumberString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ModelNumberString createFromParcel(@NonNull Parcel in) {
            return new ModelNumberString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ModelNumberString[] newArray(int size) {
            return new ModelNumberString[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ModelNumberString createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ModelNumberString(bluetoothGattCharacteristic);
        }

    };

    /**
     * Model Number
     */
    private final String mModelNumber;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A24
     */
    public ModelNumberString(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mModelNumber = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ModelNumberString(@NonNull Parcel in) {
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
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(mModelNumber);
    }

    /**
     * @return Model Number
     */
    public String getModelNumber() {
        return mModelNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mModelNumber.getBytes();
    }

}
