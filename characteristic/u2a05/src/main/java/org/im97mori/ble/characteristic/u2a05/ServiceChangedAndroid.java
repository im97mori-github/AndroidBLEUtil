package org.im97mori.ble.characteristic.u2a05;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Service Changed (Characteristics UUID: 0x2A05)
 */
@SuppressWarnings({"WeakerAccess"})
public class ServiceChangedAndroid extends ServiceChanged implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ServiceChangedAndroid> CREATOR = new ByteArrayCreator<ServiceChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new ServiceChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceChangedAndroid[] newArray(int size) {
            return new ServiceChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ServiceChangedAndroid createFromByteArray(@NonNull byte[] values) {
            return new ServiceChangedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A05
     */
    @Deprecated
    public ServiceChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ServiceChangedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param startOfAffectedAttributeHandleRange Start of Affected Attribute Handle Range
     * @param endOfAffectedAttributeHandleRange   End of Affected Attribute Handle Range
     */
    public ServiceChangedAndroid(int startOfAffectedAttributeHandleRange, int endOfAffectedAttributeHandleRange) {
        super(startOfAffectedAttributeHandleRange, endOfAffectedAttributeHandleRange);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServiceChangedAndroid(@NonNull Parcel in) {
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
