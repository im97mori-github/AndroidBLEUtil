package org.im97mori.ble.characteristic.u2bed;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BATTERY_LEVEL_STATUS_CHARACTERISTIC;

/**
 * Battery Level Status (Characteristics UUID: 0x2BED)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BatteryLevelStatusAndroid extends BatteryLevelStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryLevelStatusAndroid> CREATOR = new ByteArrayCreator<BatteryLevelStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryLevelStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryLevelStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryLevelStatusAndroid[] newArray(int size) {
            return new BatteryLevelStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryLevelStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_LEVEL_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BatteryLevelStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BED
     */
    public BatteryLevelStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryLevelStatusAndroid(@NonNull Parcel in) {
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
