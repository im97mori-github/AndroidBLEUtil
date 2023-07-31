package org.im97mori.ble.characteristic.u2ad3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Training Status (Characteristics UUID: 0x2AD3)
 */
@SuppressWarnings({"WeakerAccess"})
public class TrainingStatusAndroid extends TrainingStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrainingStatusAndroid> CREATOR = new ByteArrayCreator<TrainingStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrainingStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new TrainingStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrainingStatusAndroid[] newArray(int size) {
            return new TrainingStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrainingStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrainingStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD3
     */
    @Deprecated
    public TrainingStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrainingStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                Flags
     * @param trainingStatus       Training Status
     * @param trainingStatusString Training Status String
     */
    public TrainingStatusAndroid(int flags, int trainingStatus, @Nullable String trainingStatusString) {
        super(flags, trainingStatus, trainingStatusString);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrainingStatusAndroid(@NonNull Parcel in) {
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
