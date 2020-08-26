package org.im97mori.ble.characteristic.u2ab7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTP_HEADERS_CHARACTERISTIC;

/**
 * HTTP Headers (Characteristics UUID: 0x2AB7)
 */
@SuppressWarnings({"WeakerAccess"})
public class HTTPHeadersAndroid extends HTTPHeaders implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPHeadersAndroid> CREATOR = new ByteArrayCreater<HTTPHeadersAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPHeadersAndroid createFromParcel(@NonNull Parcel in) {
            return new HTTPHeadersAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPHeadersAndroid[] newArray(int size) {
            return new HTTPHeadersAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPHeadersAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTP_HEADERS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPHeadersAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB7
     */
    public HTTPHeadersAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param httpHeaders HTTP Headers
     */
    public HTTPHeadersAndroid(@NonNull String httpHeaders) {
        super(httpHeaders);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private HTTPHeadersAndroid(@NonNull Parcel in) {
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
