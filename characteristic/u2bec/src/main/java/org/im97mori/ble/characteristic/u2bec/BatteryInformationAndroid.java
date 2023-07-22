package org.im97mori.ble.characteristic.u2bec;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BATTERY_INFORMATION_CHARACTERISTIC;

/**
 * Battery Information (Characteristics UUID: 0x2BEC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BatteryInformationAndroid extends BatteryInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryInformationAndroid> CREATOR = new ByteArrayCreator<BatteryInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryInformationAndroid[] newArray(int size) {
            return new BatteryInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryInformationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BATTERY_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BatteryInformationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BEC
     */
    public BatteryInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryInformationAndroid(@NonNull Parcel in) {
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
