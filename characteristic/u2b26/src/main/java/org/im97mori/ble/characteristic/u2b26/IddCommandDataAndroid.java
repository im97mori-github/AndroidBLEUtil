package org.im97mori.ble.characteristic.u2b26;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * IDD Command Data (Characteristics UUID: 0x2B26)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddCommandDataAndroid extends IddCommandData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddCommandDataAndroid> CREATOR = new ByteArrayCreator<IddCommandDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddCommandDataAndroid createFromParcel(@NonNull Parcel in) {
            return new IddCommandDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddCommandDataAndroid[] newArray(int size) {
            return new IddCommandDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddCommandDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new IddCommandDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B26
     */
    @Deprecated
    public IddCommandDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IddCommandDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddCommandDataAndroid(@NonNull Parcel in) {
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
