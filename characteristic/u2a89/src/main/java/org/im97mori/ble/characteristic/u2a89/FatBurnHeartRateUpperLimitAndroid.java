package org.im97mori.ble.characteristic.u2a89;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;

/**
 * Fat Burn Heart Rate Upper Limit (Characteristics UUID: 0x2A89)
 */
@SuppressWarnings({"WeakerAccess"})
public class FatBurnHeartRateUpperLimitAndroid extends FatBurnHeartRateUpperLimit implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FatBurnHeartRateUpperLimitAndroid> CREATOR = new ByteArrayCreater<FatBurnHeartRateUpperLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateUpperLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new FatBurnHeartRateUpperLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateUpperLimitAndroid[] newArray(int size) {
            return new FatBurnHeartRateUpperLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FatBurnHeartRateUpperLimitAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FatBurnHeartRateUpperLimitAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A89
     */
    public FatBurnHeartRateUpperLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param fatBurnHeartRateUpperLimit Fat Burn Heart Rate Upper Limit
     */
    public FatBurnHeartRateUpperLimitAndroid(int fatBurnHeartRateUpperLimit) {
        super(fatBurnHeartRateUpperLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FatBurnHeartRateUpperLimitAndroid(@NonNull Parcel in) {
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
