package org.im97mori.ble.characteristic.u2bf0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BATTERY_ENERGY_STATUS_CHARACTERISTIC;

/**
 * Battery Energy Status (Characteristics UUID: 0x2BF0)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BatteryEnergyStatusAndroid extends BatteryEnergyStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryEnergyStatusAndroid> CREATOR = new ByteArrayCreator<BatteryEnergyStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryEnergyStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryEnergyStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryEnergyStatusAndroid[] newArray(int size) {
            return new BatteryEnergyStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryEnergyStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_ENERGY_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BatteryEnergyStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BF0
     */
    public BatteryEnergyStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryEnergyStatusAndroid(@NonNull Parcel in) {
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
