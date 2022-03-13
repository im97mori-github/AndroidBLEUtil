package org.im97mori.ble.characteristic.u2a70;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;

/**
 * True Wind Speed (Characteristics UUID: 0x2A70)
 */
@SuppressWarnings({"WeakerAccess"})
public class TrueWindSpeedAndroid extends TrueWindSpeed implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrueWindSpeedAndroid> CREATOR = new ByteArrayCreator<TrueWindSpeedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindSpeedAndroid createFromParcel(@NonNull Parcel in) {
            return new TrueWindSpeedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindSpeedAndroid[] newArray(int size) {
            return new TrueWindSpeedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrueWindSpeedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrueWindSpeedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A70
     */
    public TrueWindSpeedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param trueWindSpeed True Wind Speed
     */
    public TrueWindSpeedAndroid(int trueWindSpeed) {
        super(trueWindSpeed);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrueWindSpeedAndroid(@NonNull Parcel in) {
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
