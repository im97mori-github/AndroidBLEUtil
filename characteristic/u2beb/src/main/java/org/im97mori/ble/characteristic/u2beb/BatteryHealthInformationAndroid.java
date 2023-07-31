package org.im97mori.ble.characteristic.u2beb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Battery Health Information (Characteristics UUID: 0x2BEB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BatteryHealthInformationAndroid extends BatteryHealthInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BatteryHealthInformationAndroid> CREATOR = new ByteArrayCreator<BatteryHealthInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryHealthInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new BatteryHealthInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BatteryHealthInformationAndroid[] newArray(int size) {
            return new BatteryHealthInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BatteryHealthInformationAndroid createFromByteArray(@NonNull byte[] values) {
            return new BatteryHealthInformationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BEB
     */
    @Deprecated
    public BatteryHealthInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BatteryHealthInformationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BatteryHealthInformationAndroid(@NonNull Parcel in) {
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
