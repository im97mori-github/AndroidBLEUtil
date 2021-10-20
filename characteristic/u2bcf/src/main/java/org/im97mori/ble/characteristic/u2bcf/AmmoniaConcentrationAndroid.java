package org.im97mori.ble.characteristic.u2bcf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.AMMONIA_CONCENTRATION_CHARACTERISTIC;

/**
 * Ammonia Concentration (Characteristics UUID: 0x2BCF)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AmmoniaConcentrationAndroid extends AmmoniaConcentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AmmoniaConcentrationAndroid> CREATOR = new ByteArrayCreater<AmmoniaConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AmmoniaConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new AmmoniaConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AmmoniaConcentrationAndroid[] newArray(int size) {
            return new AmmoniaConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AmmoniaConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AMMONIA_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AmmoniaConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCF
     */
    public AmmoniaConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AmmoniaConcentrationAndroid(@NonNull Parcel in) {
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
