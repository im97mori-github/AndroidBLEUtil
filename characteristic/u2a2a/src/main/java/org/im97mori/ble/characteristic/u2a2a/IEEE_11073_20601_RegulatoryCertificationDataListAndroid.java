package org.im97mori.ble.characteristic.u2a2a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

// TODO

/**
 * IEEE 11073-20601 Regulatory Certification Data List (Characteristics UUID: 0x2A2A)
 */
@SuppressWarnings({"WeakerAccess"})
public class IEEE_11073_20601_RegulatoryCertificationDataListAndroid extends IEEE_11073_20601_RegulatoryCertificationDataList implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IEEE_11073_20601_RegulatoryCertificationDataListAndroid> CREATOR = new ByteArrayCreator<IEEE_11073_20601_RegulatoryCertificationDataListAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IEEE_11073_20601_RegulatoryCertificationDataListAndroid createFromParcel(@NonNull Parcel in) {
            return new IEEE_11073_20601_RegulatoryCertificationDataListAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IEEE_11073_20601_RegulatoryCertificationDataListAndroid[] newArray(int size) {
            return new IEEE_11073_20601_RegulatoryCertificationDataListAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IEEE_11073_20601_RegulatoryCertificationDataListAndroid createFromByteArray(@NonNull byte[] values) {
            return new IEEE_11073_20601_RegulatoryCertificationDataListAndroid(values);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2A
     */
    @Deprecated
    public IEEE_11073_20601_RegulatoryCertificationDataListAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IEEE_11073_20601_RegulatoryCertificationDataListAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IEEE_11073_20601_RegulatoryCertificationDataListAndroid(@NonNull Parcel in) {
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
