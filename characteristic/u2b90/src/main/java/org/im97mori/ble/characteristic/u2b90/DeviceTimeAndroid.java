package org.im97mori.ble.characteristic.u2b90;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_TIME_CHARACTERISTIC;

/**
 * Device Time (Characteristics UUID: 0x2B90)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DeviceTimeAndroid extends DeviceTime implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DeviceTimeAndroid> CREATOR = new ByteArrayCreator<DeviceTimeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeAndroid createFromParcel(@NonNull Parcel in) {
            return new DeviceTimeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeAndroid[] newArray(int size) {
            return new DeviceTimeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DeviceTimeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_TIME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DeviceTimeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B90
     */
    public DeviceTimeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DeviceTimeAndroid(@NonNull Parcel in) {
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
