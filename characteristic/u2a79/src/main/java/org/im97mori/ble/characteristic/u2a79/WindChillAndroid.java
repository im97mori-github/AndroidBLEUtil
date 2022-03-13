package org.im97mori.ble.characteristic.u2a79;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;

/**
 * Wind Chill (Characteristics UUID: 0x2A79)
 */
@SuppressWarnings({"WeakerAccess"})
public class WindChillAndroid extends WindChill implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<WindChillAndroid> CREATOR = new ByteArrayCreator<WindChillAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WindChillAndroid createFromParcel(@NonNull Parcel in) {
            return new WindChillAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WindChillAndroid[] newArray(int size) {
            return new WindChillAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WindChillAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WindChillAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A79
     */
    public WindChillAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param windChill Wind Chill
     */
    public WindChillAndroid(int windChill) {
        super(windChill);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WindChillAndroid(@NonNull Parcel in) {
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
