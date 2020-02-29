package org.im97mori.ble.characteristic.u2ace;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CROSS_TRAINER_DATA_CHARACTERISTIC;

/**
 * Cross Trainer Data packet (Characteristics UUID: 0x2ACE)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CrossTrainerDataPacketAndroid extends CrossTrainerDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CrossTrainerDataPacketAndroid> CREATOR = new ByteArrayCreater<CrossTrainerDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new CrossTrainerDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataPacketAndroid[] newArray(int size) {
            return new CrossTrainerDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CrossTrainerDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CrossTrainerDataPacketAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACE
     */
    public CrossTrainerDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private CrossTrainerDataPacketAndroid(@NonNull Parcel in) {
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
