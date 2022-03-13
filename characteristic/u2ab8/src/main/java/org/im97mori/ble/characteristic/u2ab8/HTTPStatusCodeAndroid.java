package org.im97mori.ble.characteristic.u2ab8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.HTTP_STATUS_CODE_CHARACTERISTIC;

/**
 * HTTP Status Code (Characteristics UUID: 0x2AB8)
 */
@SuppressWarnings({"WeakerAccess"})
public class HTTPStatusCodeAndroid extends HTTPStatusCode implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HTTPStatusCodeAndroid> CREATOR = new ByteArrayCreator<HTTPStatusCodeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPStatusCodeAndroid createFromParcel(@NonNull Parcel in) {
            return new HTTPStatusCodeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPStatusCodeAndroid[] newArray(int size) {
            return new HTTPStatusCodeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPStatusCodeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTP_STATUS_CODE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPStatusCodeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB8
     */
    public HTTPStatusCodeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param statusCode Status Code
     * @param dataStatus Data Status
     */
    public HTTPStatusCodeAndroid(int statusCode, int dataStatus) {
        super(statusCode, dataStatus);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPStatusCodeAndroid(@NonNull Parcel in) {
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
