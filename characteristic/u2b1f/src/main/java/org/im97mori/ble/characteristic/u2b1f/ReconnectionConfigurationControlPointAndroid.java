package org.im97mori.ble.characteristic.u2b1f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;

/**
 * Reconnection Configuration Control Point (Characteristics UUID: 0x2B1F)
 */

@SuppressWarnings("WeakerAccess")
public class ReconnectionConfigurationControlPointAndroid extends ReconnectionConfigurationControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ReconnectionConfigurationControlPointAndroid> CREATOR = new ByteArrayCreater<ReconnectionConfigurationControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new ReconnectionConfigurationControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPointAndroid[] newArray(int size) {
            return new ReconnectionConfigurationControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReconnectionConfigurationControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ReconnectionConfigurationControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1F
     */
    public ReconnectionConfigurationControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ReconnectionConfigurationControlPointAndroid(@NonNull Parcel in) {
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
