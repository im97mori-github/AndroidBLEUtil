package org.im97mori.ble.characteristic.u2be9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BATTERY_CRITICAL_STATUS_CHARACTERISTIC;

/**
 * Battery Critical Status (Characteristics UUID: 0x2BE9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BatteryCriticalStatusAndroid extends BatteryCriticalStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryCriticalStatusAndroid> CREATOR = new ByteArrayCreator<BatteryCriticalStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryCriticalStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryCriticalStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryCriticalStatusAndroid[] newArray(int size) {
            return new BatteryCriticalStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryCriticalStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_CRITICAL_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BatteryCriticalStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE9
     */
    public BatteryCriticalStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryCriticalStatusAndroid(@NonNull Parcel in) {
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
