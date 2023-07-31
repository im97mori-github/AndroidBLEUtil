package org.im97mori.ble.characteristic.u2bfa;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * ESL Display Information (Characteristics UUID: 0x2BFA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EslDisplayInformationAndroid extends EslDisplayInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EslDisplayInformationAndroid> CREATOR = new ByteArrayCreator<EslDisplayInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslDisplayInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new EslDisplayInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslDisplayInformationAndroid[] newArray(int size) {
            return new EslDisplayInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EslDisplayInformationAndroid createFromByteArray(@NonNull byte[] values) {
            return new EslDisplayInformationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BFA
     */
    @Deprecated
    public EslDisplayInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public EslDisplayInformationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EslDisplayInformationAndroid(@NonNull Parcel in) {
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
