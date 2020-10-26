package org.im97mori.ble.characteristic.u2a7b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DEW_POINT_CHARACTERISTIC;

/**
 * Dew Point (Characteristics UUID: 0x2A7B)
 */
@SuppressWarnings({"WeakerAccess"})
public class DewPointAndroid extends DewPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DewPointAndroid> CREATOR = new ByteArrayCreater<DewPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DewPointAndroid createFromParcel(@NonNull Parcel in) {
            return new DewPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DewPointAndroid[] newArray(int size) {
            return new DewPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DewPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DewPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7B
     */
    public DewPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param dewPoint Dew Point
     */
    public DewPointAndroid(int dewPoint) {
        super(dewPoint);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DewPointAndroid(@NonNull Parcel in) {
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
