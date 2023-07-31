package org.im97mori.ble.characteristic.u2ba6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Search Results Object ID (Characteristics UUID: 0x2BA6)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SearchResultsObjectIdAndroid extends SearchResultsObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SearchResultsObjectIdAndroid> CREATOR = new ByteArrayCreator<SearchResultsObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SearchResultsObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new SearchResultsObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SearchResultsObjectIdAndroid[] newArray(int size) {
            return new SearchResultsObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SearchResultsObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new SearchResultsObjectIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA6
     */
    @Deprecated
    public SearchResultsObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SearchResultsObjectIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SearchResultsObjectIdAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
