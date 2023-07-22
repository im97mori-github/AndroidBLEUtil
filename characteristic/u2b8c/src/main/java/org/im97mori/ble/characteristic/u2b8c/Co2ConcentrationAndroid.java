package org.im97mori.ble.characteristic.u2b8c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CO2_CONCENTRATION_CHARACTERISTIC;

/**
 * CO2 Concentration (Characteristics UUID: 0x2B8C)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Co2ConcentrationAndroid extends Co2Concentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<Co2ConcentrationAndroid> CREATOR = new ByteArrayCreator<Co2ConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Co2ConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new Co2ConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Co2ConcentrationAndroid[] newArray(int size) {
            return new Co2ConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Co2ConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CO2_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Co2ConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B8C
     */
    public Co2ConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Co2ConcentrationAndroid(@NonNull Parcel in) {
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
