package org.im97mori.ble.characteristic.u2a86;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Date of Threshold Assessment (Characteristics UUID: 0x2A86)
 */
@SuppressWarnings({"WeakerAccess"})
public class DateOfThresholdAssessmentAndroid extends DateOfThresholdAssessment implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DateOfThresholdAssessmentAndroid> CREATOR = new ByteArrayCreator<DateOfThresholdAssessmentAndroid>() {

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
            return new DateOfThresholdAssessmentAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A86
     */
    @Deprecated
    public DateOfThresholdAssessmentAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DateOfThresholdAssessmentAndroid(@NonNull byte[] values) {
        super(values);
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
