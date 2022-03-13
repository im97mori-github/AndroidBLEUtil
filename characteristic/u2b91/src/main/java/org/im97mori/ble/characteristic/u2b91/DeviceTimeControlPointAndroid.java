package org.im97mori.ble.characteristic.u2b91;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_TIME_CONTROL_POINT_CHARACTERISTIC;

/**
 * Device Time Control Point (Characteristics UUID: 0x2B91)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DeviceTimeControlPointAndroid extends DeviceTimeControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DeviceTimeControlPointAndroid> CREATOR = new ByteArrayCreator<DeviceTimeControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new DeviceTimeControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeControlPointAndroid[] newArray(int size) {
            return new DeviceTimeControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DeviceTimeControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_TIME_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DeviceTimeControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B91
     */
    public DeviceTimeControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DeviceTimeControlPointAndroid(@NonNull Parcel in) {
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
