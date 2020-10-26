package org.im97mori.ble.characteristic.u2a7f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_THRESHOLD_CHARACTERISTIC;

/**
 * Aerobic Threshold (Characteristics UUID: 0x2A7F)
 */
@SuppressWarnings({"WeakerAccess"})
public class AerobicThresholdAndroid extends AerobicThreshold implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AerobicThresholdAndroid> CREATOR = new ByteArrayCreater<AerobicThresholdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicThresholdAndroid createFromParcel(@NonNull Parcel in) {
            return new AerobicThresholdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AerobicThresholdAndroid[] newArray(int size) {
            return new AerobicThresholdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AerobicThresholdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AerobicThresholdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7F
     */
    public AerobicThresholdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param aerobicThreshold Aerobic Threshold
     */
    public AerobicThresholdAndroid(int aerobicThreshold) {
        super(aerobicThreshold);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AerobicThresholdAndroid(@NonNull Parcel in) {
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
