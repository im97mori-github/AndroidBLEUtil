package org.im97mori.ble.characteristic.u2a98;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;

/**
 * Weight (Characteristics UUID: 0x2A98)
 */
@SuppressWarnings({"WeakerAccess"})
public class WeightAndroid extends Weight implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WeightAndroid> CREATOR = new ByteArrayCreater<WeightAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightAndroid createFromParcel(@NonNull Parcel in) {
            return new WeightAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightAndroid[] newArray(int size) {
            return new WeightAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WeightAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WEIGHT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WeightAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A98
     */
    public WeightAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param weight Weight
     */
    public WeightAndroid(int weight) {
        super(weight);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WeightAndroid(@NonNull Parcel in) {
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
