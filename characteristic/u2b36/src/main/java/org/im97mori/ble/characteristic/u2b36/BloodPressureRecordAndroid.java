package org.im97mori.ble.characteristic.u2b36;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.core.MultiplePacketCreator;

/**
 * Blood Pressure Record (Characteristics UUID: 0x2B36)
 */
@SuppressWarnings({"WeakerAccess"})
public class BloodPressureRecordAndroid extends BloodPressureRecord implements Parcelable {

    /**
     * @see MultiplePacketCreator
     */
    public static final MultiplePacketCreator<BloodPressureRecordAndroid, BloodPressureRecordPacketAndroid> CREATOR = new MultiplePacketCreator<BloodPressureRecordAndroid, BloodPressureRecordPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureRecordAndroid createFromParcel(@NonNull Parcel in) {
            return new BloodPressureRecordAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BloodPressureRecordAndroid[] newArray(int size) {
            return new BloodPressureRecordAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BloodPressureRecordAndroid createFromMultiplePacketArray(@NonNull BloodPressureRecordPacketAndroid[] multiplePacketArray) {
            return new BloodPressureRecordAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bloodPressureRecordPackets 1 or more Blood Pressure Record packet array
     */
    public BloodPressureRecordAndroid(@NonNull BloodPressureRecordPacketAndroid... bloodPressureRecordPackets) {
        super(bloodPressureRecordPackets);
    }

    /**
     * Constructor from parameters
     *
     * @param sequenceNumber         Sequence Number
     * @param uuid                   UUID
     * @param recordedCharacteristic Recorded Characteristic
     * @param crc                    E2E-CRC
     */
    public BloodPressureRecordAndroid(int sequenceNumber
            , int uuid
            , @NonNull byte[] recordedCharacteristic
            , @Nullable byte[] crc) {
        super(sequenceNumber, uuid, recordedCharacteristic, crc);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BloodPressureRecordAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(new BloodPressureRecordPacketAndroid[]{BloodPressureRecordPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
