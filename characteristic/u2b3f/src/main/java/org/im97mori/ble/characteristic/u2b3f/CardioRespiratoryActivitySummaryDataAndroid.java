package org.im97mori.ble.characteristic.u2b3f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CARDIO_RESPIRATORY_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC;

/**
 * CardioRespiratory Activity Summary Data (Characteristics UUID: 0x2B3F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CardioRespiratoryActivitySummaryDataAndroid extends CardioRespiratoryActivitySummaryData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CardioRespiratoryActivitySummaryDataAndroid> CREATOR = new ByteArrayCreater<CardioRespiratoryActivitySummaryDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CardioRespiratoryActivitySummaryDataAndroid createFromParcel(@NonNull Parcel in) {
            return new CardioRespiratoryActivitySummaryDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CardioRespiratoryActivitySummaryDataAndroid[] newArray(int size) {
            return new CardioRespiratoryActivitySummaryDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CardioRespiratoryActivitySummaryDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CARDIO_RESPIRATORY_ACTIVITY_SUMMARY_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CardioRespiratoryActivitySummaryDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3F
     */
    public CardioRespiratoryActivitySummaryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CardioRespiratoryActivitySummaryDataAndroid(@NonNull Parcel in) {
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
