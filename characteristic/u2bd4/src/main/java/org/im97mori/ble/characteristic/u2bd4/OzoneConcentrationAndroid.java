package org.im97mori.ble.characteristic.u2bd4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Ozone Concentration (Characteristics UUID: 0x2BD4)
 */
@SuppressWarnings({"WeakerAccess"})
public class OzoneConcentrationAndroid extends OzoneConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<OzoneConcentrationAndroid> CREATOR = new ByteArrayCreator<OzoneConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OzoneConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new OzoneConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OzoneConcentrationAndroid[] newArray(int size) {
            return new OzoneConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public OzoneConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            return new OzoneConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD4
     */
    @Deprecated
    public OzoneConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public OzoneConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param ozoneConcentration Ozone Concentration
     */
    public OzoneConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT ozoneConcentration) {
        super(ozoneConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private OzoneConcentrationAndroid(@NonNull Parcel in) {
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
