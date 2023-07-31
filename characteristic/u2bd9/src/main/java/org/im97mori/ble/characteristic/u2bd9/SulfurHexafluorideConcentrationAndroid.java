package org.im97mori.ble.characteristic.u2bd9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Sulfur Hexafluoride Concentration (Characteristics UUID: 0x2BD9)
 */
@SuppressWarnings({"WeakerAccess"})
public class SulfurHexafluorideConcentrationAndroid extends SulfurHexafluorideConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SulfurHexafluorideConcentrationAndroid> CREATOR = new ByteArrayCreator<SulfurHexafluorideConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SulfurHexafluorideConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new SulfurHexafluorideConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SulfurHexafluorideConcentrationAndroid[] newArray(int size) {
            return new SulfurHexafluorideConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SulfurHexafluorideConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            return new SulfurHexafluorideConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD9
     */
    @Deprecated
    public SulfurHexafluorideConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SulfurHexafluorideConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param sulfurHexafluorideConcentration Sulfur Hexafluoride Concentration
     */
    public SulfurHexafluorideConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT sulfurHexafluorideConcentration) {
        super(sulfurHexafluorideConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SulfurHexafluorideConcentrationAndroid(@NonNull Parcel in) {
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
