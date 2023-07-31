package org.im97mori.ble.characteristic.u2bb6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bearer URI Schemes Supported List (Characteristics UUID: 0x2BB6)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerUriSchemesSupportedListAndroid extends BearerUriSchemesSupportedList implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerUriSchemesSupportedListAndroid> CREATOR = new ByteArrayCreator<BearerUriSchemesSupportedListAndroid>() {

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
            return new BearerUriSchemesSupportedListAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB6
     */
    @Deprecated
    public BearerUriSchemesSupportedListAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BearerUriSchemesSupportedListAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerUriSchemesSupportedListAndroid(@NonNull Parcel in) {
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
