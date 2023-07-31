package org.im97mori.ble.characteristic.u2bd3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Non-Methane Volatile Organic Compounds Concentration (Characteristics UUID: 0x2BD3)
 */
@SuppressWarnings({"WeakerAccess"})
public class NonMethaneVolatileOrganicCompoundsConcentrationAndroid extends NonMethaneVolatileOrganicCompoundsConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<NonMethaneVolatileOrganicCompoundsConcentrationAndroid> CREATOR = new ByteArrayCreator<NonMethaneVolatileOrganicCompoundsConcentrationAndroid>() {

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
            return new NonMethaneVolatileOrganicCompoundsConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD3
     */
    @Deprecated
    public NonMethaneVolatileOrganicCompoundsConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public NonMethaneVolatileOrganicCompoundsConcentrationAndroid(@NonNull byte[] values) {
        super(values);
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
        super(Objects.requireNonNull(in.createByteArray()));
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
