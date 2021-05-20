package org.im97mori.ble.characteristic.u2ab2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FLOOR_NUMBER_CHARACTERISTIC;

/**
 * Floor Number (Characteristics UUID: 0x2AB2)
 */
@SuppressWarnings({"WeakerAccess"})
public class FloorNumberAndroid extends FloorNumber implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FloorNumberAndroid> CREATOR = new ByteArrayCreater<FloorNumberAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FloorNumberAndroid createFromParcel(@NonNull Parcel in) {
            return new FloorNumberAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FloorNumberAndroid[] newArray(int size) {
            return new FloorNumberAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FloorNumberAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FLOOR_NUMBER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FloorNumberAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB2
     */
    public FloorNumberAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param floorNumber Floor Number
     */
    public FloorNumberAndroid(int floorNumber) {
        super(floorNumber);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FloorNumberAndroid(@NonNull Parcel in) {
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
