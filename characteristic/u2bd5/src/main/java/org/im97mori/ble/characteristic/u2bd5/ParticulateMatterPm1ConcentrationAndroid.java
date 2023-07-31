package org.im97mori.ble.characteristic.u2bd5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Particulate Matter - PM1 Concentration (Characteristics UUID: 0x2BD5)
 */
@SuppressWarnings({"WeakerAccess"})
public class ParticulateMatterPm1ConcentrationAndroid extends ParticulateMatterPm1Concentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ParticulateMatterPm1ConcentrationAndroid> CREATOR = new ByteArrayCreator<ParticulateMatterPm1ConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParticulateMatterPm1ConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new ParticulateMatterPm1ConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParticulateMatterPm1ConcentrationAndroid[] newArray(int size) {
            return new ParticulateMatterPm1ConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ParticulateMatterPm1ConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            return new ParticulateMatterPm1ConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD5
     */
    @Deprecated
    public ParticulateMatterPm1ConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ParticulateMatterPm1ConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param particulateMatterPm1Concentration Particulate Matter - PM1
     *                                          Concentration
     */
    public ParticulateMatterPm1ConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT particulateMatterPm1Concentration) {
        super(particulateMatterPm1Concentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ParticulateMatterPm1ConcentrationAndroid(@NonNull Parcel in) {
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
