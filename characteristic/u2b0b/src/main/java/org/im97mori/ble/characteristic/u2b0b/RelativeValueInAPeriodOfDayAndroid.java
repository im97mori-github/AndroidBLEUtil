package org.im97mori.ble.characteristic.u2b0b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Relative Value In A Period Of Day (Characteristics UUID: 0x2B0B)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeValueInAPeriodOfDayAndroid extends RelativeValueInAPeriodOfDay implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeValueInAPeriodOfDayAndroid> CREATOR = new ByteArrayCreator<RelativeValueInAPeriodOfDayAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAPeriodOfDayAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeValueInAPeriodOfDayAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAPeriodOfDayAndroid[] newArray(int size) {
            return new RelativeValueInAPeriodOfDayAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeValueInAPeriodOfDayAndroid createFromByteArray(@NonNull byte[] values) {
            return new RelativeValueInAPeriodOfDayAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0B
     */
    @Deprecated
    public RelativeValueInAPeriodOfDayAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RelativeValueInAPeriodOfDayAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param relativeValue Relative Value
     * @param startTime     Start Time
     * @param endTime       End Time
     */
    public RelativeValueInAPeriodOfDayAndroid(int relativeValue, int startTime, int endTime) {
        super(relativeValue, startTime, endTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeValueInAPeriodOfDayAndroid(@NonNull Parcel in) {
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
