package org.im97mori.ble.characteristic.u2a75;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;

/**
 * Pollen Concentration (Characteristics UUID: 0x2A75)
 */
@SuppressWarnings({"WeakerAccess"})
public class PollenConcentrationAndroid extends PollenConcentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PollenConcentrationAndroid> CREATOR = new ByteArrayCreater<PollenConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PollenConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new PollenConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PollenConcentrationAndroid[] newArray(int size) {
            return new PollenConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PollenConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PollenConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A75
     */
    public PollenConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param pollenConcentration Pollen Concentration
     */
    public PollenConcentrationAndroid(int pollenConcentration) {
        super(pollenConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PollenConcentrationAndroid(@NonNull Parcel in) {
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
