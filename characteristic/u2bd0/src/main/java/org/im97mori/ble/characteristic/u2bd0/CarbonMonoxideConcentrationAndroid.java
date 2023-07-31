package org.im97mori.ble.characteristic.u2bd0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import java.util.Objects;

/**
 * Carbon Monoxide Concentration (Characteristics UUID: 0x2BD0)
 */
@SuppressWarnings({"WeakerAccess"})
public class CarbonMonoxideConcentrationAndroid extends CarbonMonoxideConcentration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CarbonMonoxideConcentrationAndroid> CREATOR = new ByteArrayCreator<CarbonMonoxideConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CarbonMonoxideConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new CarbonMonoxideConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CarbonMonoxideConcentrationAndroid[] newArray(int size) {
            return new CarbonMonoxideConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CarbonMonoxideConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            return new CarbonMonoxideConcentrationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD0
     */
    @Deprecated
    public CarbonMonoxideConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CarbonMonoxideConcentrationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param carbonMonoxideConcentration Carbon Monoxide Concentration
     */
    public CarbonMonoxideConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT carbonMonoxideConcentration) {
        super(carbonMonoxideConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CarbonMonoxideConcentrationAndroid(@NonNull Parcel in) {
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
