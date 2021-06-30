package org.im97mori.ble.characteristic.u2aef;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ELECTRIC_CURRENT_RANGE_CHARACTERISTIC;

/**
 * Electric Current Range (Characteristics UUID: 0x2AEF)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ElectricCurrentRangeAndroid extends ElectricCurrentRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ElectricCurrentRangeAndroid> CREATOR = new ByteArrayCreater<ElectricCurrentRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new ElectricCurrentRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentRangeAndroid[] newArray(int size) {
            return new ElectricCurrentRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ElectricCurrentRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELECTRIC_CURRENT_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ElectricCurrentRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEF
     */
    public ElectricCurrentRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ElectricCurrentRangeAndroid(@NonNull Parcel in) {
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
