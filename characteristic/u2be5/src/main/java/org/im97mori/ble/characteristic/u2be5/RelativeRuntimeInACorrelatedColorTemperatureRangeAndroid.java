package org.im97mori.ble.characteristic.u2be5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.RELATIVE_RUNTIME_IN_A_CORRELATED_COLOR_TEMPERATURE_RANGE_CHARACTERISTIC;

/**
 * Relative Runtime in a Correlated Color Temperature Range (Characteristics UUID: 0x2BE5)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid extends RelativeRuntimeInACorrelatedColorTemperatureRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid> CREATOR = new ByteArrayCreator<RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid[] newArray(int size) {
            return new RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RELATIVE_RUNTIME_IN_A_CORRELATED_COLOR_TEMPERATURE_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE5
     */
    public RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeRuntimeInACorrelatedColorTemperatureRangeAndroid(@NonNull Parcel in) {
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
