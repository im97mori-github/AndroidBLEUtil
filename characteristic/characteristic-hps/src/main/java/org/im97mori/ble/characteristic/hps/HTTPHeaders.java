package org.im97mori.ble.characteristic.hps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTP_HEADERS_CHARACTERISTIC;

/**
 * HTTP Headers (Characteristics UUID: 0x2AB7)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HTTPHeaders implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPHeaders> CREATOR = new ByteArrayCreater<HTTPHeaders>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPHeaders createFromParcel(@NonNull Parcel in) {
            return new HTTPHeaders(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPHeaders[] newArray(int size) {
            return new HTTPHeaders[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPHeaders createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTP_HEADERS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPHeaders(bluetoothGattCharacteristic);
        }

    };

    /**
     * HTTP Headers
     */
    private final String mHttpHeaders;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB7
     */
    public HTTPHeaders(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHttpHeaders = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPHeaders(@NonNull Parcel in) {
        mHttpHeaders = in.readString();
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
        dest.writeString(mHttpHeaders);
    }

    /**
     * @return HTTP Headers
     */
    public String getHttpHeaders() {
        return mHttpHeaders;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mHttpHeaders.getBytes();
    }

}
