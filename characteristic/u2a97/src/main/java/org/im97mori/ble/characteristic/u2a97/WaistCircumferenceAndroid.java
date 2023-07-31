package org.im97mori.ble.characteristic.u2a97;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Waist Circumference (Characteristics UUID: 0x2A97)
 */
@SuppressWarnings({"WeakerAccess"})
public class WaistCircumferenceAndroid extends WaistCircumference implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<WaistCircumferenceAndroid> CREATOR = new ByteArrayCreator<WaistCircumferenceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WaistCircumferenceAndroid createFromParcel(@NonNull Parcel in) {
            return new WaistCircumferenceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WaistCircumferenceAndroid[] newArray(int size) {
            return new WaistCircumferenceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WaistCircumferenceAndroid createFromByteArray(@NonNull byte[] values) {
            return new WaistCircumferenceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A97
     */
    @Deprecated
    public WaistCircumferenceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public WaistCircumferenceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param waistCircumference Waist Circumference
     */
    public WaistCircumferenceAndroid(int waistCircumference) {
        super(waistCircumference);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WaistCircumferenceAndroid(@NonNull Parcel in) {
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
