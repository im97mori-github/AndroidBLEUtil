package org.im97mori.ble.characteristic.u2ad2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INDOOR_BIKE_DATA_CHARACTERISTIC;

/**
 * Indoor Bike Data packet (Characteristics UUID: 0x2AD2)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IndoorBikeDataPacketAndroid extends IndoorBikeDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IndoorBikeDataPacketAndroid> CREATOR = new ByteArrayCreater<IndoorBikeDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorBikeDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataPacketAndroid[] newArray(int size) {
            return new IndoorBikeDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IndoorBikeDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IndoorBikeDataPacketAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD2
     */
    public IndoorBikeDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IndoorBikeDataPacketAndroid(@NonNull Parcel in) {
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
