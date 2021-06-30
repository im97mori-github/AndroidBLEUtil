package org.im97mori.ble.characteristic.u2acb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.DIRECTORY_LISTING_CHARACTERISTIC;

/**
 * Directory Listing (Characteristics UUID: 0x2ACB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class DirectoryListingAndroid extends DirectoryListing implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DirectoryListingAndroid> CREATOR = new ByteArrayCreater<DirectoryListingAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DirectoryListingAndroid createFromParcel(@NonNull Parcel in) {
            return new DirectoryListingAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DirectoryListingAndroid[] newArray(int size) {
            return new DirectoryListingAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DirectoryListingAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DIRECTORY_LISTING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DirectoryListingAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACB
     */
    public DirectoryListingAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DirectoryListingAndroid(@NonNull Parcel in) {
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
