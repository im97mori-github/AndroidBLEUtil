package org.im97mori.ble.characteristic.hps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTPS_SECURITY_CHARACTERISTIC;

/**
 * HTTPS Security (Characteristics UUID: 0x2ABB)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HTTPSSecurity implements ByteArrayInterface, Parcelable {

    /**
     * 0: HTTP Server certificate for the URI is not valid
     */
    public static final int HTTPS_SECURITY_FALSE = 0;

    /**
     * 1: HTTP Server certificate for the URI is valid
     */
    public static final int HTTPS_SECURITY_TRUE = 1;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPSSecurity> CREATOR = new ByteArrayCreater<HTTPSSecurity>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPSSecurity createFromParcel(@NonNull Parcel in) {
            return new HTTPSSecurity(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPSSecurity[] newArray(int size) {
            return new HTTPSSecurity[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPSSecurity createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTPS_SECURITY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPSSecurity(bluetoothGattCharacteristic);
        }

    };

    /**
     * HTTPS Security
     */
    private final int mHttpsSecurity;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABB
     */
    public HTTPSSecurity(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHttpsSecurity = BLEUtils.createBoolean(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPSSecurity(@NonNull Parcel in) {
        mHttpsSecurity = in.readInt();
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
        dest.writeInt(mHttpsSecurity);
    }

    /**
     * @return HTTPS Security
     */
    public int getHttpsSecurity() {
        return mHttpsSecurity;
    }

    /**
     * @return {@code true}:HTTP Server certificate for the URI is not valid, {@code false}:HTTP Server certificate for the URI is valid
     */
    public boolean isHttpsSecurityFalse() {
        return HTTPS_SECURITY_FALSE == mHttpsSecurity;
    }

    /**
     * @return {@code true}:HTTP Server certificate for the URI is valid, {@code false}:HTTP Server certificate for the URI is not valid
     */
    public boolean isHttpsSecurityTrue() {
        return HTTPS_SECURITY_TRUE == mHttpsSecurity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mHttpsSecurity);
        return data;
    }

}
