package org.im97mori.ble.characteristic.u2ab9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTP_ENTITY_BODY_CHARACTERISTIC;

/**
 * HTTP Entity Body (Characteristics UUID: 0x2AB9)
 */
@SuppressWarnings({"WeakerAccess"})
public class HTTPEntityBodyAndroid extends HTTPEntityBody implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPEntityBodyAndroid> CREATOR = new ByteArrayCreater<HTTPEntityBodyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPEntityBodyAndroid createFromParcel(@NonNull Parcel in) {
            return new HTTPEntityBodyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPEntityBodyAndroid[] newArray(int size) {
            return new HTTPEntityBodyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPEntityBodyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTP_ENTITY_BODY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPEntityBodyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB9
     */
    public HTTPEntityBodyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param httpEntityBody HTTP Entity Body
     */
    public HTTPEntityBodyAndroid(@NonNull String httpEntityBody) {
        super(httpEntityBody);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPEntityBodyAndroid(@NonNull Parcel in) {
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
