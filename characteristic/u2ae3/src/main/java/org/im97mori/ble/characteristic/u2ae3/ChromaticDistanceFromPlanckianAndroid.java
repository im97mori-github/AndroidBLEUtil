package org.im97mori.ble.characteristic.u2ae3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Chromatic Distance From Planckian (Characteristics UUID: 0x2AE3)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticDistanceFromPlanckianAndroid extends ChromaticDistanceFromPlanckian implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ChromaticDistanceFromPlanckianAndroid> CREATOR = new ByteArrayCreator<ChromaticDistanceFromPlanckianAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticDistanceFromPlanckianAndroid createFromParcel(@NonNull Parcel in) {
            return new ChromaticDistanceFromPlanckianAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticDistanceFromPlanckianAndroid[] newArray(int size) {
            return new ChromaticDistanceFromPlanckianAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ChromaticDistanceFromPlanckianAndroid createFromByteArray(@NonNull byte[] values) {
            return new ChromaticDistanceFromPlanckianAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE3
     */
    @Deprecated
    public ChromaticDistanceFromPlanckianAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ChromaticDistanceFromPlanckianAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param distanceFromPlanckian Distance From Planckian
     */
    public ChromaticDistanceFromPlanckianAndroid(int distanceFromPlanckian) {
        super(distanceFromPlanckian);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChromaticDistanceFromPlanckianAndroid(@NonNull Parcel in) {
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
