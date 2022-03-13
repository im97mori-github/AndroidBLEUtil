package org.im97mori.ble.characteristic.u2ae0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.AVERAGE_CURRENT_CHARACTERISTIC;

/**
 * Average Current (Characteristics UUID: 0x2AE0)
 */
@SuppressWarnings({"WeakerAccess"})
public class AverageCurrentAndroid extends AverageCurrent implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AverageCurrentAndroid> CREATOR = new ByteArrayCreator<AverageCurrentAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageCurrentAndroid createFromParcel(@NonNull Parcel in) {
            return new AverageCurrentAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageCurrentAndroid[] newArray(int size) {
            return new AverageCurrentAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AverageCurrentAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AVERAGE_CURRENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AverageCurrentAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE0
     */
    public AverageCurrentAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param electricCurrentValue Electric Current Value
     * @param sensingDuration      Sensing Duration
     */
    public AverageCurrentAndroid(int electricCurrentValue, int sensingDuration) {
        super(electricCurrentValue, sensingDuration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AverageCurrentAndroid(@NonNull Parcel in) {
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
