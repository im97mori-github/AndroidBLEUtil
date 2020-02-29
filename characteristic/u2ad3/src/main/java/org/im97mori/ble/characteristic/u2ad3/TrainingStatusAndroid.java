package org.im97mori.ble.characteristic.u2ad3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRAINING_STATUS_CHARACTERISTIC;

/**
 * Training Status (Characteristics UUID: 0x2AD3)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
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
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TrainingStatusAndroid(@NonNull Parcel in) {
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
