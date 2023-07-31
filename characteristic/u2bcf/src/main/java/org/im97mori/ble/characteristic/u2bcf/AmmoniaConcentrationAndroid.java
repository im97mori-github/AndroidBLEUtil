package org.im97mori.ble.characteristic.u2bcf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Ammonia Concentration (Characteristics UUID: 0x2BCF)
 */
@SuppressWarnings({"WeakerAccess"})
public class AmmoniaConcentrationAndroid extends AmmoniaConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AmmoniaConcentrationAndroid> CREATOR = new ByteArrayCreator<AmmoniaConcentrationAndroid>() {

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
            return new AmmoniaConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCF
     */
    @Deprecated
    public AmmoniaConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AmmoniaConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param ammoniaConcentration Ammonia Concentration
     */
    public AmmoniaConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT ammoniaConcentration) {
        super(ammoniaConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AmmoniaConcentrationAndroid(@NonNull Parcel in) {
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
