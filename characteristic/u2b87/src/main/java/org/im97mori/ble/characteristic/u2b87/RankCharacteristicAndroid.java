package org.im97mori.ble.characteristic.u2b87;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RANK_CHARACTERISTIC;

/**
 * Rank Characteristic (Characteristics UUID: 0x2B87)
 */
@SuppressWarnings({"WeakerAccess"})
public class RankCharacteristicAndroid extends RankCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RankCharacteristicAndroid> CREATOR = new ByteArrayCreater<RankCharacteristicAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RankCharacteristicAndroid createFromParcel(@NonNull Parcel in) {
            return new RankCharacteristicAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RankCharacteristicAndroid[] newArray(int size) {
            return new RankCharacteristicAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RankCharacteristicAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RANK_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RankCharacteristicAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B87
     */
    public RankCharacteristicAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param setMemberRank Set Member Rank
     */
    public RankCharacteristicAndroid(int setMemberRank) {
        super(setMemberRank);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RankCharacteristicAndroid(@NonNull Parcel in) {
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
