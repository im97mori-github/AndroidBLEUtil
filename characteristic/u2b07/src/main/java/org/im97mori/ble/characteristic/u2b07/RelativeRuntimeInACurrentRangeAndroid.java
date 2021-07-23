package org.im97mori.ble.characteristic.u2b07;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RELATIVE_RUNTIME_IN_A_CURRENT_RANGE_CHARACTERISTIC;

/**
 * Relative Runtime In A Current Range (Characteristics UUID: 0x2B07)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeRuntimeInACurrentRangeAndroid extends RelativeRuntimeInACurrentRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RelativeRuntimeInACurrentRangeAndroid> CREATOR = new ByteArrayCreater<RelativeRuntimeInACurrentRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInACurrentRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeRuntimeInACurrentRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInACurrentRangeAndroid[] newArray(int size) {
            return new RelativeRuntimeInACurrentRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeRuntimeInACurrentRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RELATIVE_RUNTIME_IN_A_CURRENT_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B07
     */
    public RelativeRuntimeInACurrentRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param relativeRuntimeValue Relative Runtime Value
     * @param minimumCurrent       Minimum Current
     * @param maximumCurrent       Maximum Current
     */
    public RelativeRuntimeInACurrentRangeAndroid(int relativeRuntimeValue, int minimumCurrent, int maximumCurrent) {
        super(relativeRuntimeValue, minimumCurrent, maximumCurrent);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeRuntimeInACurrentRangeAndroid(@NonNull Parcel in) {
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
