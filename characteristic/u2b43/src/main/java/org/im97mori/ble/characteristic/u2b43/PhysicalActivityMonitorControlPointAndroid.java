package org.im97mori.ble.characteristic.u2b43;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PHYSICAL_ACTIVITY_MONITOR_CONTROL_POINT_CHARACTERISTIC;

/**
 * Physical Activity Monitor Control Point (Characteristics UUID: 0x2B43)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PhysicalActivityMonitorControlPointAndroid extends PhysicalActivityMonitorControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PhysicalActivityMonitorControlPointAndroid> CREATOR = new ByteArrayCreator<PhysicalActivityMonitorControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new PhysicalActivityMonitorControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PhysicalActivityMonitorControlPointAndroid[] newArray(int size) {
            return new PhysicalActivityMonitorControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PhysicalActivityMonitorControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PHYSICAL_ACTIVITY_MONITOR_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PhysicalActivityMonitorControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B43
     */
    public PhysicalActivityMonitorControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PhysicalActivityMonitorControlPointAndroid(@NonNull Parcel in) {
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
