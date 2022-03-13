package org.im97mori.ble.characteristic.u2b4b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_WEARING_POSITION_CHARACTERISTIC;

/**
 * Device Wearing Position (Characteristics UUID: 0x2B4B)
 */
@SuppressWarnings({"WeakerAccess"})
public class DeviceWearingPositionAndroid extends DeviceWearingPosition implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DeviceWearingPositionAndroid> CREATOR = new ByteArrayCreator<DeviceWearingPositionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceWearingPositionAndroid createFromParcel(@NonNull Parcel in) {
            return new DeviceWearingPositionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceWearingPositionAndroid[] newArray(int size) {
            return new DeviceWearingPositionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DeviceWearingPositionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_WEARING_POSITION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DeviceWearingPositionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4B
     */
    public DeviceWearingPositionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param deviceWearingPosition Device Wearing Position
     */
    public DeviceWearingPositionAndroid(int deviceWearingPosition) {
        super(deviceWearingPosition);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DeviceWearingPositionAndroid(@NonNull Parcel in) {
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
