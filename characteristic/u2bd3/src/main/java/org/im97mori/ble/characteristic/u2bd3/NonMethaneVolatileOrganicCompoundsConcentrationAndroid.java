package org.im97mori.ble.characteristic.u2bd3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import static org.im97mori.ble.constants.CharacteristicUUID.NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC;

/**
 * Non-Methane Volatile Organic Compounds Concentration (Characteristics UUID: 0x2BD3)
 */
@SuppressWarnings({"WeakerAccess"})
public class NonMethaneVolatileOrganicCompoundsConcentrationAndroid extends NonMethaneVolatileOrganicCompoundsConcentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<NonMethaneVolatileOrganicCompoundsConcentrationAndroid> CREATOR = new ByteArrayCreater<NonMethaneVolatileOrganicCompoundsConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NonMethaneVolatileOrganicCompoundsConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new NonMethaneVolatileOrganicCompoundsConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NonMethaneVolatileOrganicCompoundsConcentrationAndroid[] newArray(int size) {
            return new NonMethaneVolatileOrganicCompoundsConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NonMethaneVolatileOrganicCompoundsConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new NonMethaneVolatileOrganicCompoundsConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD3
     */
    public NonMethaneVolatileOrganicCompoundsConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param nonMethaneVolatileOrganicCompoundsConcentration Non-Methane Volatile Organic Compounds Concentration
     */
    public NonMethaneVolatileOrganicCompoundsConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT nonMethaneVolatileOrganicCompoundsConcentration) {
        super(nonMethaneVolatileOrganicCompoundsConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NonMethaneVolatileOrganicCompoundsConcentrationAndroid(@NonNull Parcel in) {
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
