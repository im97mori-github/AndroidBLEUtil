package org.im97mori.ble.characteristic.u2b25;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * IDD Command Control Point (Characteristics UUID: 0x2B25)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddCommandControlPointAndroid extends IddCommandControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddCommandControlPointAndroid> CREATOR = new ByteArrayCreator<IddCommandControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddCommandControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new IddCommandControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddCommandControlPointAndroid[] newArray(int size) {
            return new IddCommandControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddCommandControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new IddCommandControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B25
     */
    @Deprecated
    public IddCommandControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IddCommandControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddCommandControlPointAndroid(@NonNull Parcel in) {
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
