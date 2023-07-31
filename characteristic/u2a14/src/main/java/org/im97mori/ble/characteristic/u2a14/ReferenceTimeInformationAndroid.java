package org.im97mori.ble.characteristic.u2a14;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Reference Time Information (Characteristics UUID: 0x2A14)
 */
@SuppressWarnings({"WeakerAccess"})
public class ReferenceTimeInformationAndroid extends ReferenceTimeInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ReferenceTimeInformationAndroid> CREATOR = new ByteArrayCreator<ReferenceTimeInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReferenceTimeInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new ReferenceTimeInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReferenceTimeInformationAndroid[] newArray(int size) {
            return new ReferenceTimeInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReferenceTimeInformationAndroid createFromByteArray(@NonNull byte[] values) {
            return new ReferenceTimeInformationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A14
     */
    @Deprecated
    public ReferenceTimeInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ReferenceTimeInformationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeSource       Time Source
     * @param accuracy         Accuracy
     * @param daysSinceUpdate  mDaysSinceUpdate
     * @param hoursSinceUpdate mHoursSinceUpdate
     */
    public ReferenceTimeInformationAndroid(int timeSource, int accuracy, int daysSinceUpdate, int hoursSinceUpdate) {
        super(timeSource, accuracy, daysSinceUpdate, hoursSinceUpdate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReferenceTimeInformationAndroid(@NonNull Parcel in) {
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
