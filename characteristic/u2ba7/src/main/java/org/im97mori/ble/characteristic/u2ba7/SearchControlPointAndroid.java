package org.im97mori.ble.characteristic.u2ba7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SEARCH_CONTROL_POINT_CHARACTERISTIC;

/**
 * Search Control Point (Characteristics UUID: 0x2BA7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SearchControlPointAndroid extends SearchControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SearchControlPointAndroid> CREATOR = new ByteArrayCreator<SearchControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SearchControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new SearchControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SearchControlPointAndroid[] newArray(int size) {
            return new SearchControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SearchControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SEARCH_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SearchControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA7
     */
    public SearchControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SearchControlPointAndroid(@NonNull Parcel in) {
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
