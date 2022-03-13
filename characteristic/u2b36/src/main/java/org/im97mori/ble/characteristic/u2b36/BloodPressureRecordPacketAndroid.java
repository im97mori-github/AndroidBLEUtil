package org.im97mori.ble.characteristic.u2b36;

import static org.im97mori.ble.constants.CharacteristicUUID.BLOOD_PRESSURE_RECORD_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreator;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLOOD_PRESSURE_RECORD_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BloodPressureRecordPacketAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B36
     */
    public BloodPressureRecordPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
