package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;

/**
 * IEEE 11073-20601 Regulatory Certification Data List (Characteristics UUID: 0x2A2A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IEEE_11073_20601_RegulatoryCertificationDataList implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IEEE_11073_20601_RegulatoryCertificationDataList> CREATOR = new ByteArrayCreater<IEEE_11073_20601_RegulatoryCertificationDataList>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IEEE_11073_20601_RegulatoryCertificationDataList createFromParcel(@NonNull Parcel in) {
            return new IEEE_11073_20601_RegulatoryCertificationDataList(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IEEE_11073_20601_RegulatoryCertificationDataList[] newArray(int size) {
            return new IEEE_11073_20601_RegulatoryCertificationDataList[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IEEE_11073_20601_RegulatoryCertificationDataList createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IEEE_11073_20601_RegulatoryCertificationDataList(bluetoothGattCharacteristic);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2A
     */
    public IEEE_11073_20601_RegulatoryCertificationDataList(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IEEE_11073_20601_RegulatoryCertificationDataList(@NonNull Parcel in) {

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

    }


    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[0];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);

        return data;
    }

}
