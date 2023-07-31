package org.im97mori.ble.characteristic.u2b3f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * CardioRespiratory Activity Summary Data (Characteristics UUID: 0x2B3F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CardioRespiratoryActivitySummaryDataAndroid extends CardioRespiratoryActivitySummaryData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CardioRespiratoryActivitySummaryDataAndroid> CREATOR = new ByteArrayCreator<CardioRespiratoryActivitySummaryDataAndroid>() {

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
            return new CardioRespiratoryActivitySummaryDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3F
     */
    @Deprecated
    public CardioRespiratoryActivitySummaryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CardioRespiratoryActivitySummaryDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CardioRespiratoryActivitySummaryDataAndroid(@NonNull Parcel in) {
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
