package org.im97mori.ble.characteristic.u2b36;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Blood Pressure Record packet (Characteristics UUID: 0x2B36)
 */
@SuppressWarnings({"WeakerAccess"})
public class BloodPressureRecordPacketAndroid extends BloodPressureRecordPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BloodPressureRecordPacketAndroid> CREATOR = new ByteArrayCreator<BloodPressureRecordPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureRecordPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new BloodPressureRecordPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureRecordPacketAndroid[] newArray(int size) {
            return new BloodPressureRecordPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BloodPressureRecordPacketAndroid createFromByteArray(@NonNull byte[] values) {
            return new BloodPressureRecordPacketAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B36
     */
    @Deprecated
    public BloodPressureRecordPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BloodPressureRecordPacketAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param segmentationHeader     Segmentation Header
     * @param sequenceNumber         Sequence Number
     * @param uuid                   UUID
     * @param recordedCharacteristic Recorded Characteristic
     * @param crc                    E2E-CRC
     */
    public BloodPressureRecordPacketAndroid(int segmentationHeader
            , int sequenceNumber
            , int uuid
            , @NonNull byte[] recordedCharacteristic
            , @Nullable byte[] crc) {
        super(segmentationHeader, sequenceNumber, uuid, recordedCharacteristic, crc);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BloodPressureRecordPacketAndroid(@NonNull Parcel in) {
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
