package org.im97mori.ble.characteristic.u2b0c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.RELATIVE_VALUE_IN_A_TEMPERATURE_RANGE_CHARACTERISTIC;

/**
 * Relative Value In A Temperature Range (Characteristics UUID: 0x2B0C)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeValueInATemperatureRangeAndroid extends RelativeValueInATemperatureRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeValueInATemperatureRangeAndroid> CREATOR = new ByteArrayCreator<RelativeValueInATemperatureRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInATemperatureRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeValueInATemperatureRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInATemperatureRangeAndroid[] newArray(int size) {
            return new RelativeValueInATemperatureRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeValueInATemperatureRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RELATIVE_VALUE_IN_A_TEMPERATURE_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0C
     */
    public RelativeValueInATemperatureRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param relativeValue           Relative Value
     * @param minimumTemperatureValue Minimum Temperature Value
     * @param maximumTemperatureValue Maximum Temperature Value
     */
    public RelativeValueInATemperatureRangeAndroid(int relativeValue, int minimumTemperatureValue, int maximumTemperatureValue) {
        super(relativeValue, minimumTemperatureValue, maximumTemperatureValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeValueInATemperatureRangeAndroid(@NonNull Parcel in) {
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
