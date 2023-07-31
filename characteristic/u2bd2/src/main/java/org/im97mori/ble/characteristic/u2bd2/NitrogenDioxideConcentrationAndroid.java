package org.im97mori.ble.characteristic.u2bd2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Nitrogen Dioxide Concentration (Characteristics UUID: 0x2BD2)
 */
@SuppressWarnings({"WeakerAccess"})
public class NitrogenDioxideConcentrationAndroid extends NitrogenDioxideConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<NitrogenDioxideConcentrationAndroid> CREATOR = new ByteArrayCreator<NitrogenDioxideConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NitrogenDioxideConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new NitrogenDioxideConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NitrogenDioxideConcentrationAndroid[] newArray(int size) {
            return new NitrogenDioxideConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NitrogenDioxideConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            return new NitrogenDioxideConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD2
     */
    @Deprecated
    public NitrogenDioxideConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public NitrogenDioxideConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param nitrogenDioxideConcentration Nitrogen Dioxide Concentration
     */
    public NitrogenDioxideConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT nitrogenDioxideConcentration) {
        super(nitrogenDioxideConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NitrogenDioxideConcentrationAndroid(@NonNull Parcel in) {
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
