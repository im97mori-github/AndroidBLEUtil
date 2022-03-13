package org.im97mori.ble.characteristic.u2bd1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import static org.im97mori.ble.constants.CharacteristicUUID.METHANE_CONCENTRATION_CHARACTERISTIC;

/**
 * Methane Concentration (Characteristics UUID: 0x2BD1)
 */
@SuppressWarnings({"WeakerAccess"})
public class MethaneConcentrationAndroid extends MethaneConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MethaneConcentrationAndroid> CREATOR = new ByteArrayCreator<MethaneConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MethaneConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new MethaneConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MethaneConcentrationAndroid[] newArray(int size) {
            return new MethaneConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MethaneConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(METHANE_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MethaneConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD1
     */
    public MethaneConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param methaneConcentration Methane Concentration
     */
    public MethaneConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT methaneConcentration) {
        super(methaneConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MethaneConcentrationAndroid(@NonNull Parcel in) {
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
