package org.im97mori.ble.characteristic.u2ab8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTP_STATUS_CODE_CHARACTERISTIC;

/**
 * HTTP Status Code (Characteristics UUID: 0x2AB8)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HTTPStatusCodeAndroid extends HTTPStatusCode implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPStatusCodeAndroid> CREATOR = new ByteArrayCreater<HTTPStatusCodeAndroid>() {

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
    @SuppressWarnings("ConstantConditions")
    private HTTPStatusCodeAndroid(@NonNull Parcel in) {
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
