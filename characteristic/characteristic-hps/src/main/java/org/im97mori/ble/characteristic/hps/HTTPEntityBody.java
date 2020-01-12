package org.im97mori.ble.characteristic.hps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTP_ENTITY_BODY_CHARACTERISTIC;

/**
 * HTTP Entity Body (Characteristics UUID: 0x2AB9)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HTTPEntityBody implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPEntityBody> CREATOR = new ByteArrayCreater<HTTPEntityBody>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPEntityBody createFromParcel(@NonNull Parcel in) {
            return new HTTPEntityBody(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPEntityBody[] newArray(int size) {
            return new HTTPEntityBody[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPEntityBody createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTP_ENTITY_BODY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPEntityBody(bluetoothGattCharacteristic);
        }

    };

    /**
     * HTTP Entity Body
     */
    private final String mHttpEntityBody;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB9
     */
    public HTTPEntityBody(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHttpEntityBody = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPEntityBody(@NonNull Parcel in) {
        mHttpEntityBody = in.readString();
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
        dest.writeString(mHttpEntityBody);
    }

    /**
     * @return HTTP Entity Body
     */
    public String getHttpEntityBody() {
        return mHttpEntityBody;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mHttpEntityBody.getBytes();
    }

}
