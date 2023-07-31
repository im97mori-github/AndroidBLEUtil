package org.im97mori.ble.characteristic.u2b27;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * IDD Record Access Control Point (Characteristics UUID: 0x2B27)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddRecordAccessControlPointAndroid extends IddRecordAccessControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddRecordAccessControlPointAndroid> CREATOR = new ByteArrayCreator<IddRecordAccessControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddRecordAccessControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new IddRecordAccessControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddRecordAccessControlPointAndroid[] newArray(int size) {
            return new IddRecordAccessControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddRecordAccessControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new IddRecordAccessControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B27
     */
    @Deprecated
    public IddRecordAccessControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IddRecordAccessControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddRecordAccessControlPointAndroid(@NonNull Parcel in) {
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
