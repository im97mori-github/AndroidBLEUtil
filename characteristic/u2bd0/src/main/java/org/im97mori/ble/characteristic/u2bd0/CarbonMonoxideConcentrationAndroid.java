package org.im97mori.ble.characteristic.u2bd0;

import static org.im97mori.ble.constants.CharacteristicUUID.CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

/**
 * Carbon Monoxide Concentration (Characteristics UUID: 0x2BD0)
 */
@SuppressWarnings({"WeakerAccess"})
public class CarbonMonoxideConcentrationAndroid extends CarbonMonoxideConcentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CarbonMonoxideConcentrationAndroid> CREATOR = new ByteArrayCreater<CarbonMonoxideConcentrationAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CarbonMonoxideConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD0
     */
    public CarbonMonoxideConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
