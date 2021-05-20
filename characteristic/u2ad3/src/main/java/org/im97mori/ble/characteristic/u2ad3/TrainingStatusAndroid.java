package org.im97mori.ble.characteristic.u2ad3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRAINING_STATUS_CHARACTERISTIC;

/**
 * Training Status (Characteristics UUID: 0x2AD3)
 */
@SuppressWarnings({"WeakerAccess"})
public class TrainingStatusAndroid extends TrainingStatus implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TrainingStatusAndroid> CREATOR = new ByteArrayCreater<TrainingStatusAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrainingStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD3
     */
    public TrainingStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
        //noinspection ConstantConditions
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
