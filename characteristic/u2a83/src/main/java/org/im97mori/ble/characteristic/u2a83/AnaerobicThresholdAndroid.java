package org.im97mori.ble.characteristic.u2a83;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_THRESHOLD_CHARACTERISTIC;

/**
 * Anaerobic Threshold (Characteristics UUID: 0x2A83)
 */
@SuppressWarnings({"WeakerAccess"})
public class AnaerobicThresholdAndroid extends AnaerobicThreshold implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AnaerobicThresholdAndroid> CREATOR = new ByteArrayCreater<AnaerobicThresholdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicThresholdAndroid createFromParcel(@NonNull Parcel in) {
            return new AnaerobicThresholdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicThresholdAndroid[] newArray(int size) {
            return new AnaerobicThresholdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicThresholdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AnaerobicThresholdAndroid(bluetoothGattCharacteristic);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A83
     */
    public AnaerobicThresholdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param anaerobicThreshold Anaerobic Threshold
     */
    public AnaerobicThresholdAndroid(int anaerobicThreshold) {
        super(anaerobicThreshold);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicThresholdAndroid(@NonNull Parcel in) {
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
