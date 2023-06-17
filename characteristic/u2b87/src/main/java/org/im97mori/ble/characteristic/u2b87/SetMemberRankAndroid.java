package org.im97mori.ble.characteristic.u2b87;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SET_MEMBER_RANK_CHARACTERISTIC;

/**
 * Set Member Rank (Characteristics UUID: 0x2B87)
 */
@SuppressWarnings({"WeakerAccess"})
public class SetMemberRankAndroid extends SetMemberRank implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SetMemberRankAndroid> CREATOR = new ByteArrayCreator<SetMemberRankAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetMemberRankAndroid createFromParcel(@NonNull Parcel in) {
            return new SetMemberRankAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SetMemberRankAndroid[] newArray(int size) {
            return new SetMemberRankAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SetMemberRankAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SET_MEMBER_RANK_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SetMemberRankAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B87
     */
    public SetMemberRankAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param setMemberRank Set Member Rank
     */
    public SetMemberRankAndroid(int setMemberRank) {
        super(setMemberRank);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SetMemberRankAndroid(@NonNull Parcel in) {
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
