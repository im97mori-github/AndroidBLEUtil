package org.im97mori.ble.characteristic.u2a43;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Alert Category ID (Characteristics UUID: 0x2A43)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertCategoryIdAndroid extends AlertCategoryId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AlertCategoryIdAndroid> CREATOR = new ByteArrayCreator<AlertCategoryIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertCategoryIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdAndroid[] newArray(int size) {
            return new AlertCategoryIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertCategoryIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new AlertCategoryIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A43
     */
    @Deprecated
    public AlertCategoryIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AlertCategoryIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param categoryId Category ID
     */
    public AlertCategoryIdAndroid(int categoryId) {
        super(categoryId);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertCategoryIdAndroid(@NonNull Parcel in) {
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
