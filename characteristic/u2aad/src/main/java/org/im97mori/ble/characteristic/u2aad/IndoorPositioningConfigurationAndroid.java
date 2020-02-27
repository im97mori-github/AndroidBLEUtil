package org.im97mori.ble.characteristic.u2aad;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INDOOR_POSITIONING_CONFIGURATION_CHARACTERISTIC;

/**
 * Indoor Positioning Configuration (Characteristics UUID: 0x2AAD)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IndoorPositioningConfigurationAndroid extends IndoorPositioningConfiguration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IndoorPositioningConfigurationAndroid> CREATOR = new ByteArrayCreater<IndoorPositioningConfigurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningConfigurationAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorPositioningConfigurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorPositioningConfigurationAndroid[] newArray(int size) {
            return new IndoorPositioningConfigurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IndoorPositioningConfigurationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_POSITIONING_CONFIGURATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IndoorPositioningConfigurationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAD
     */
    public IndoorPositioningConfigurationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IndoorPositioningConfigurationAndroid(@NonNull Parcel in) {
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
