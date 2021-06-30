package org.im97mori.ble.characteristic.u2bb6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.BEARER_URI_SCHEMES_SUPPORTED_LIST_CHARACTERISTIC;

/**
 * Bearer URI Schemes Supported List (Characteristics UUID: 0x2BB6)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerUriSchemesSupportedListAndroid extends BearerUriSchemesSupportedList implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BearerUriSchemesSupportedListAndroid> CREATOR = new ByteArrayCreater<BearerUriSchemesSupportedListAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerUriSchemesSupportedListAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerUriSchemesSupportedListAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerUriSchemesSupportedListAndroid[] newArray(int size) {
            return new BearerUriSchemesSupportedListAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerUriSchemesSupportedListAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BEARER_URI_SCHEMES_SUPPORTED_LIST_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BearerUriSchemesSupportedListAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB6
     */
    public BearerUriSchemesSupportedListAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerUriSchemesSupportedListAndroid(@NonNull Parcel in) {
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
