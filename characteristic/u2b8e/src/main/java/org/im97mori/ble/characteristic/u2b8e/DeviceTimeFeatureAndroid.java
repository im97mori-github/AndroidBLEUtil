package org.im97mori.ble.characteristic.u2b8e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_TIME_FEATURE_CHARACTERISTIC;

/**
 * Device Time Feature (Characteristics UUID: 0x2B8E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DeviceTimeFeatureAndroid extends DeviceTimeFeature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DeviceTimeFeatureAndroid> CREATOR = new ByteArrayCreator<DeviceTimeFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new DeviceTimeFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DeviceTimeFeatureAndroid[] newArray(int size) {
            return new DeviceTimeFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DeviceTimeFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_TIME_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DeviceTimeFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B8E
     */
    public DeviceTimeFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DeviceTimeFeatureAndroid(@NonNull Parcel in) {
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
