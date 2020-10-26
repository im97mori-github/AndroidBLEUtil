package org.im97mori.ble.characteristic.u2a86;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;

/**
 * Date of Threshold Assessment (Characteristics UUID: 0x2A86)
 */
@SuppressWarnings({"WeakerAccess"})
public class DateOfThresholdAssessmentAndroid extends DateOfThresholdAssessment implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DateOfThresholdAssessmentAndroid> CREATOR = new ByteArrayCreater<DateOfThresholdAssessmentAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateOfThresholdAssessmentAndroid createFromParcel(@NonNull Parcel in) {
            return new DateOfThresholdAssessmentAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DateOfThresholdAssessmentAndroid[] newArray(int size) {
            return new DateOfThresholdAssessmentAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DateOfThresholdAssessmentAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DateOfThresholdAssessmentAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A86
     */
    public DateOfThresholdAssessmentAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param year  Year
     * @param month Month
     * @param day   Day
     */
    public DateOfThresholdAssessmentAndroid(int year, int month, int day) {
        super(year, month, day);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DateOfThresholdAssessmentAndroid(@NonNull Parcel in) {
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
