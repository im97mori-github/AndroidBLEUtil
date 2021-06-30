package org.im97mori.ble.characteristic.u2b3e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CARDIO_RESPIRATORY_ACTIVITY_INSTANTANEOUS_DATA_CHARACTERISTIC;

/**
 * CardioRespiratory Activity Instantaneous Data (Characteristics UUID: 0x2B3E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CardioRespiratoryActivityInstantaneousDataAndroid extends CardioRespiratoryActivityInstantaneousData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CardioRespiratoryActivityInstantaneousDataAndroid> CREATOR = new ByteArrayCreater<CardioRespiratoryActivityInstantaneousDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CardioRespiratoryActivityInstantaneousDataAndroid createFromParcel(@NonNull Parcel in) {
            return new CardioRespiratoryActivityInstantaneousDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CardioRespiratoryActivityInstantaneousDataAndroid[] newArray(int size) {
            return new CardioRespiratoryActivityInstantaneousDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CardioRespiratoryActivityInstantaneousDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CARDIO_RESPIRATORY_ACTIVITY_INSTANTANEOUS_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CardioRespiratoryActivityInstantaneousDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3E
     */
    public CardioRespiratoryActivityInstantaneousDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CardioRespiratoryActivityInstantaneousDataAndroid(@NonNull Parcel in) {
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
