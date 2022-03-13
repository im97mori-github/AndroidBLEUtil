package org.im97mori.ble.characteristic.u2a91;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;

/**
 * Maximum Recommended Heart Rate (Characteristics UUID: 0x2A91)
 */
@SuppressWarnings({"WeakerAccess"})
public class MaximumRecommendedHeartRateAndroid extends MaximumRecommendedHeartRate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MaximumRecommendedHeartRateAndroid> CREATOR = new ByteArrayCreator<MaximumRecommendedHeartRateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MaximumRecommendedHeartRateAndroid createFromParcel(@NonNull Parcel in) {
            return new MaximumRecommendedHeartRateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MaximumRecommendedHeartRateAndroid[] newArray(int size) {
            return new MaximumRecommendedHeartRateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MaximumRecommendedHeartRateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MaximumRecommendedHeartRateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A91
     */
    public MaximumRecommendedHeartRateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param maximumRecommendedHeartRate Maximum Recommended Heart Rate
     */
    public MaximumRecommendedHeartRateAndroid(int maximumRecommendedHeartRate) {
        super(maximumRecommendedHeartRate);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MaximumRecommendedHeartRateAndroid(@NonNull Parcel in) {
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
