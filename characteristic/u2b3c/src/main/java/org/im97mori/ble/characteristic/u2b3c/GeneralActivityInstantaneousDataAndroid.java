package org.im97mori.ble.characteristic.u2b3c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.GENERAL_ACTIVITY_INSTANTANEOUS_DATA_CHARACTERISTIC;

/**
 * General Activity Instantaneous Data (Characteristics UUID: 0x2B3C)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GeneralActivityInstantaneousDataAndroid extends GeneralActivityInstantaneousData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GeneralActivityInstantaneousDataAndroid> CREATOR = new ByteArrayCreater<GeneralActivityInstantaneousDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GeneralActivityInstantaneousDataAndroid createFromParcel(@NonNull Parcel in) {
            return new GeneralActivityInstantaneousDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GeneralActivityInstantaneousDataAndroid[] newArray(int size) {
            return new GeneralActivityInstantaneousDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GeneralActivityInstantaneousDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GENERAL_ACTIVITY_INSTANTANEOUS_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GeneralActivityInstantaneousDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3C
     */
    public GeneralActivityInstantaneousDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GeneralActivityInstantaneousDataAndroid(@NonNull Parcel in) {
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
