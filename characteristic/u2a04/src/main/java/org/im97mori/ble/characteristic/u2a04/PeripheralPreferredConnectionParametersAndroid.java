package org.im97mori.ble.characteristic.u2a04;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;

/**
 * Peripheral Preferred Connection Parameters (Characteristics UUID: 0x2A04)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class PeripheralPreferredConnectionParametersAndroid extends PeripheralPreferredConnectionParameters implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PeripheralPreferredConnectionParametersAndroid> CREATOR = new ByteArrayCreater<PeripheralPreferredConnectionParametersAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPreferredConnectionParametersAndroid createFromParcel(@NonNull Parcel in) {
            return new PeripheralPreferredConnectionParametersAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPreferredConnectionParametersAndroid[] newArray(int size) {
            return new PeripheralPreferredConnectionParametersAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PeripheralPreferredConnectionParametersAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PeripheralPreferredConnectionParametersAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A04
     */
    public PeripheralPreferredConnectionParametersAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private PeripheralPreferredConnectionParametersAndroid(@NonNull Parcel in) {
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
