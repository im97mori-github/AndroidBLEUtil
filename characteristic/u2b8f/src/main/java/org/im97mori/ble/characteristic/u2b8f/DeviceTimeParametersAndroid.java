package org.im97mori.ble.characteristic.u2b8f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_TIME_PARAMETERS_CHARACTERISTIC;

/**
 * Device Time Parameters (Characteristics UUID: 0x2B8F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DeviceTimeParametersAndroid extends DeviceTimeParameters implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DeviceTimeParametersAndroid> CREATOR = new ByteArrayCreater<DeviceTimeParametersAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeParametersAndroid createFromParcel(@NonNull Parcel in) {
            return new DeviceTimeParametersAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeParametersAndroid[] newArray(int size) {
            return new DeviceTimeParametersAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DeviceTimeParametersAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_TIME_PARAMETERS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DeviceTimeParametersAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B8F
     */
    public DeviceTimeParametersAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DeviceTimeParametersAndroid(@NonNull Parcel in) {
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
