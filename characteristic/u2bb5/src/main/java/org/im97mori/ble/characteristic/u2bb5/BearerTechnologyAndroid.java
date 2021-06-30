package org.im97mori.ble.characteristic.u2bb5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.BEARER_TECHNOLOGY_CHARACTERISTIC;

/**
 * Bearer Technology (Characteristics UUID: 0x2BB5)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerTechnologyAndroid extends BearerTechnology implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BearerTechnologyAndroid> CREATOR = new ByteArrayCreater<BearerTechnologyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerTechnologyAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerTechnologyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerTechnologyAndroid[] newArray(int size) {
            return new BearerTechnologyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerTechnologyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BEARER_TECHNOLOGY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BearerTechnologyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB5
     */
    public BearerTechnologyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerTechnologyAndroid(@NonNull Parcel in) {
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
