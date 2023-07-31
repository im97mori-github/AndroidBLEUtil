package org.im97mori.ble.characteristic.u2b31;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * ACS Data Out Notify (Characteristics UUID: 0x2B31)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AcsDataOutNotifyAndroid extends AcsDataOutNotify implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AcsDataOutNotifyAndroid> CREATOR = new ByteArrayCreator<AcsDataOutNotifyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutNotifyAndroid createFromParcel(@NonNull Parcel in) {
            return new AcsDataOutNotifyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutNotifyAndroid[] newArray(int size) {
            return new AcsDataOutNotifyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AcsDataOutNotifyAndroid createFromByteArray(@NonNull byte[] values) {
            return new AcsDataOutNotifyAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B31
     */
    @Deprecated
    public AcsDataOutNotifyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AcsDataOutNotifyAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AcsDataOutNotifyAndroid(@NonNull Parcel in) {
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
