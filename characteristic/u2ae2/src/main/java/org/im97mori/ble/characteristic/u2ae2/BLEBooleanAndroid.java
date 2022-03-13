package org.im97mori.ble.characteristic.u2ae2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BOOLEAN_CHARACTERISTIC;

/**
 * Boolean (Characteristics UUID: 0x2AE2)
 */
// TODO
public class BLEBooleanAndroid extends BLEBoolean implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BLEBooleanAndroid> CREATOR = new ByteArrayCreator<BLEBooleanAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BLEBooleanAndroid createFromParcel(@NonNull Parcel in) {
            return new BLEBooleanAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BLEBooleanAndroid[] newArray(int size) {
            return new BLEBooleanAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BLEBooleanAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BOOLEAN_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BLEBooleanAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE2
     */
    public BLEBooleanAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param booleanValue Boolean value
     */
    public BLEBooleanAndroid(int booleanValue) {
        super(booleanValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BLEBooleanAndroid(@NonNull Parcel in) {
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
