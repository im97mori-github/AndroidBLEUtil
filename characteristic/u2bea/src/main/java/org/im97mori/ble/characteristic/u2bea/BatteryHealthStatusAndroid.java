package org.im97mori.ble.characteristic.u2bea;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BATTERY_HEALTH_STATUS_CHARACTERISTIC;

/**
 * Battery Health Status (Characteristics UUID: 0x2BEA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BatteryHealthStatusAndroid extends BatteryHealthStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryHealthStatusAndroid> CREATOR = new ByteArrayCreator<BatteryHealthStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryHealthStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryHealthStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryHealthStatusAndroid[] newArray(int size) {
            return new BatteryHealthStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryHealthStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_HEALTH_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BatteryHealthStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BEA
     */
    public BatteryHealthStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryHealthStatusAndroid(@NonNull Parcel in) {
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
