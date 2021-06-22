package org.im97mori.ble.characteristic.u2a24;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.MODEL_NUMBER_STRING_CHARACTERISTIC;

/**
 * Model Number String (Characteristics UUID: 0x2A24)
 */
@SuppressWarnings({"WeakerAccess"})
public class ModelNumberStringAndroid extends ModelNumberString implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ModelNumberStringAndroid> CREATOR = new ByteArrayCreater<ModelNumberStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ModelNumberStringAndroid createFromParcel(@NonNull Parcel in) {
            return new ModelNumberStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ModelNumberStringAndroid[] newArray(int size) {
            return new ModelNumberStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ModelNumberStringAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ModelNumberStringAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A24
     */
    public ModelNumberStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param modelNumber Model Number
     */
    public ModelNumberStringAndroid(@NonNull String modelNumber) {
        super(modelNumber);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ModelNumberStringAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
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
