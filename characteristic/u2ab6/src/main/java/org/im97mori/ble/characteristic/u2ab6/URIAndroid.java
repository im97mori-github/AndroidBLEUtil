package org.im97mori.ble.characteristic.u2ab6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.URI_CHARACTERISTIC;

/**
 * URI (Characteristics UUID: 0x2AB6)
 */
@SuppressWarnings({"WeakerAccess"})
public class URIAndroid extends URI implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<URIAndroid> CREATOR = new ByteArrayCreater<URIAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public URIAndroid createFromParcel(@NonNull Parcel in) {
            return new URIAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public URIAndroid[] newArray(int size) {
            return new URIAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public URIAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(URI_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new URIAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB6
     */
    public URIAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param uri URI
     */
    public URIAndroid(@NonNull String uri) {
        super(uri);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private URIAndroid(@NonNull Parcel in) {
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
