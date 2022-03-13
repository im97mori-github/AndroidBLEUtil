package org.im97mori.ble.characteristic.u2a8d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.HEART_RATE_MAX_CHARACTERISTIC;

/**
 * Heart Rate Max (Characteristics UUID: 0x2A8D)
 */
@SuppressWarnings({"WeakerAccess"})
public class HeartRateMaxAndroid extends HeartRateMax implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HeartRateMaxAndroid> CREATOR = new ByteArrayCreator<HeartRateMaxAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMaxAndroid createFromParcel(@NonNull Parcel in) {
            return new HeartRateMaxAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMaxAndroid[] newArray(int size) {
            return new HeartRateMaxAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeartRateMaxAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEART_RATE_MAX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HeartRateMaxAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8D
     */
    public HeartRateMaxAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param heartRateMax Heart Rate Max
     */
    public HeartRateMaxAndroid(int heartRateMax) {
        super(heartRateMax);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeartRateMaxAndroid(@NonNull Parcel in) {
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
