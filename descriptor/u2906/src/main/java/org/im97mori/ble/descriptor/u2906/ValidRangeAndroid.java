package org.im97mori.ble.descriptor.u2906;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Valid Range (Descriptor UUID: 0x2906)
 */
@SuppressWarnings({"WeakerAccess"})
public class ValidRangeAndroid extends ValidRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ValidRangeAndroid> CREATOR = new ByteArrayCreator<ValidRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new ValidRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ValidRangeAndroid[] newArray(int size) {
            return new ValidRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ValidRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new ValidRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2906
     */
    @Deprecated
    public ValidRangeAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor#getValue()">BluetoothGattDescriptor#getValue()</a>
     */
    public ValidRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param lowerInclusiveValue Lower inclusive value
     * @param upperInclusiveValue Upper inclusive value
     */
    public ValidRangeAndroid(@NonNull byte[] lowerInclusiveValue, @NonNull byte[] upperInclusiveValue) {
        super(lowerInclusiveValue, upperInclusiveValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ValidRangeAndroid(@NonNull Parcel in) {
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
