package org.im97mori.ble.characteristic.u2a8f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Hip Circumference (Characteristics UUID: 0x2A8F)
 */
@SuppressWarnings({"WeakerAccess"})
public class HipCircumferenceAndroid extends HipCircumference implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HipCircumferenceAndroid> CREATOR = new ByteArrayCreator<HipCircumferenceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HipCircumferenceAndroid createFromParcel(@NonNull Parcel in) {
            return new HipCircumferenceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HipCircumferenceAndroid[] newArray(int size) {
            return new HipCircumferenceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HipCircumferenceAndroid createFromByteArray(@NonNull byte[] values) {
            return new HipCircumferenceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8F
     */
    @Deprecated
    public HipCircumferenceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HipCircumferenceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param hipCircumference Hip Circumference
     */
    public HipCircumferenceAndroid(int hipCircumference) {
        super(hipCircumference);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HipCircumferenceAndroid(@NonNull Parcel in) {
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
