package org.im97mori.ble.characteristic.u2bd1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

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
            return new MethaneConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD1
     */
    @Deprecated
    public MethaneConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MethaneConcentrationAndroid(@NonNull byte[] values) {
        super(values);
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
