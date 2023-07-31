package org.im97mori.ble.characteristic.u2b2e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Emergency Text (Characteristics UUID: 0x2B2E)
 */
@SuppressWarnings({"WeakerAccess"})
public class EmergencyTextAndroid extends EmergencyText implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EmergencyTextAndroid> CREATOR = new ByteArrayCreator<EmergencyTextAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmergencyTextAndroid createFromParcel(@NonNull Parcel in) {
            return new EmergencyTextAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmergencyTextAndroid[] newArray(int size) {
            return new EmergencyTextAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EmergencyTextAndroid createFromByteArray(@NonNull byte[] values) {
            return new EmergencyTextAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B2E
     */
    @Deprecated
    public EmergencyTextAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EmergencyTextAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param emergencyText Sulfur Emergency Text
     */
    public EmergencyTextAndroid(@NonNull String emergencyText) {
        super(emergencyText);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EmergencyTextAndroid(@NonNull Parcel in) {
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
