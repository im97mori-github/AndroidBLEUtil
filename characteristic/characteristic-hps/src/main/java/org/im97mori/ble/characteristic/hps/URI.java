package org.im97mori.ble.characteristic.hps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.URI_CHARACTERISTIC;

/**
 * URI (Characteristics UUID: 0x2AB6)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class URI implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<URI> CREATOR = new ByteArrayCreater<URI>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public URI createFromParcel(@NonNull Parcel in) {
            return new URI(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public URI[] newArray(int size) {
            return new URI[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public URI createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(URI_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new URI(bluetoothGattCharacteristic);
        }

    };

    /**
     * URI
     */
    private final String mUri;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB6
     */
    public URI(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mUri = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private URI(@NonNull Parcel in) {
        mUri = in.readString();
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
        dest.writeString(mUri);
    }

    /**
     * @return URI
     */
    public String getUri() {
        return mUri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mUri.getBytes();
    }

}
