package org.im97mori.ble.characteristic.u2ba6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SEARCH_RESULTS_OBJECT_ID_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SEARCH_RESULTS_OBJECT_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SearchResultsObjectIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA6
     */
    public SearchResultsObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SearchResultsObjectIdAndroid(@NonNull Parcel in) {
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
