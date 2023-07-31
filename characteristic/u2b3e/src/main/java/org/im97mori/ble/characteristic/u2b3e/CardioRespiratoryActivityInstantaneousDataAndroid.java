package org.im97mori.ble.characteristic.u2b3e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * CardioRespiratory Activity Instantaneous Data (Characteristics UUID: 0x2B3E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CardioRespiratoryActivityInstantaneousDataAndroid extends CardioRespiratoryActivityInstantaneousData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CardioRespiratoryActivityInstantaneousDataAndroid> CREATOR = new ByteArrayCreator<CardioRespiratoryActivityInstantaneousDataAndroid>() {

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
            return new CardioRespiratoryActivityInstantaneousDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3E
     */
    @Deprecated
    public CardioRespiratoryActivityInstantaneousDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CardioRespiratoryActivityInstantaneousDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CardioRespiratoryActivityInstantaneousDataAndroid(@NonNull Parcel in) {
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
