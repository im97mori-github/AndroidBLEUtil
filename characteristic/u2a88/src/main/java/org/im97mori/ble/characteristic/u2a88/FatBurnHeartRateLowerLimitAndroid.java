package org.im97mori.ble.characteristic.u2a88;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;

/**
 * Fat Burn Heart Rate Lower Limit (Characteristics UUID: 0x2A88)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FatBurnHeartRateLowerLimitAndroid extends FatBurnHeartRateLowerLimit implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FatBurnHeartRateLowerLimitAndroid> CREATOR = new ByteArrayCreater<FatBurnHeartRateLowerLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateLowerLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new FatBurnHeartRateLowerLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateLowerLimitAndroid[] newArray(int size) {
            return new FatBurnHeartRateLowerLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FatBurnHeartRateLowerLimitAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FatBurnHeartRateLowerLimitAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A88
     */
    public FatBurnHeartRateLowerLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param fatBurnHeartRateLowerLimit Fat Burn Heart Rate Lower Limit
     */
    public FatBurnHeartRateLowerLimitAndroid(int fatBurnHeartRateLowerLimit) {
        super(fatBurnHeartRateLowerLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private FatBurnHeartRateLowerLimitAndroid(@NonNull Parcel in) {
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
