package org.im97mori.ble.characteristic.u2a93;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;

/**
 * Sport Type for Aerobic and Anaerobic Thresholds (Characteristics UUID: 0x2A93)
 */
@SuppressWarnings({"WeakerAccess"})
public class SportTypeForAerobicAndAnaerobicThresholdsAndroid extends SportTypeForAerobicAndAnaerobicThresholds implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SportTypeForAerobicAndAnaerobicThresholdsAndroid> CREATOR = new ByteArrayCreator<SportTypeForAerobicAndAnaerobicThresholdsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholdsAndroid createFromParcel(@NonNull Parcel in) {
            return new SportTypeForAerobicAndAnaerobicThresholdsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholdsAndroid[] newArray(int size) {
            return new SportTypeForAerobicAndAnaerobicThresholdsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholdsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SportTypeForAerobicAndAnaerobicThresholdsAndroid(bluetoothGattCharacteristic);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A93
     */
    public SportTypeForAerobicAndAnaerobicThresholdsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param sportTypeForAerobicAndAnaerobicThresholds Sport Type for Aerobic and Anaerobic Thresholds
     */
    public SportTypeForAerobicAndAnaerobicThresholdsAndroid(int sportTypeForAerobicAndAnaerobicThresholds) {
        super(sportTypeForAerobicAndAnaerobicThresholds);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SportTypeForAerobicAndAnaerobicThresholdsAndroid(@NonNull Parcel in) {
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
