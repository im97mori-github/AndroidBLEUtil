package org.im97mori.ble.characteristic.u2b3b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PHYSICAL_ACTIVITY_MONITOR_FEATURES_CHARACTERISTIC;

/**
 * Physical Activity Monitor Features (Characteristics UUID: 0x2B3B)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PhysicalActivityMonitorFeaturesAndroid extends PhysicalActivityMonitorFeatures implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PhysicalActivityMonitorFeaturesAndroid> CREATOR = new ByteArrayCreator<PhysicalActivityMonitorFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new PhysicalActivityMonitorFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorFeaturesAndroid[] newArray(int size) {
            return new PhysicalActivityMonitorFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PhysicalActivityMonitorFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PHYSICAL_ACTIVITY_MONITOR_FEATURES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PhysicalActivityMonitorFeaturesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B3B
     */
    public PhysicalActivityMonitorFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PhysicalActivityMonitorFeaturesAndroid(@NonNull Parcel in) {
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
