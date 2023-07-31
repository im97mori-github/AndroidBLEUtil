package org.im97mori.ble.characteristic.u2bd8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Sulfur Dioxide Concentration (Characteristics UUID: 0x2BD8)
 */
@SuppressWarnings({"WeakerAccess"})
public class SulfurDioxideConcentrationAndroid extends SulfurDioxideConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SulfurDioxideConcentrationAndroid> CREATOR = new ByteArrayCreator<SulfurDioxideConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SulfurDioxideConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new SulfurDioxideConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SulfurDioxideConcentrationAndroid[] newArray(int size) {
            return new SulfurDioxideConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SulfurDioxideConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            return new SulfurDioxideConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD8
     */
    @Deprecated
    public SulfurDioxideConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SulfurDioxideConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param sulfurDioxideConcentration Sulfur Dioxide Concentration
     */
    public SulfurDioxideConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT sulfurDioxideConcentration) {
        super(sulfurDioxideConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SulfurDioxideConcentrationAndroid(@NonNull Parcel in) {
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
