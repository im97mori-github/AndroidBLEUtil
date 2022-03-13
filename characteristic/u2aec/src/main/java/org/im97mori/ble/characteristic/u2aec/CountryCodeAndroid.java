package org.im97mori.ble.characteristic.u2aec;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.COUNTRY_CODE_CHARACTERISTIC;

/**
 * Country Code (Characteristics UUID: 0x2AEC)
 */
@SuppressWarnings({"WeakerAccess"})
public class CountryCodeAndroid extends CountryCode implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CountryCodeAndroid> CREATOR = new ByteArrayCreator<CountryCodeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CountryCodeAndroid createFromParcel(@NonNull Parcel in) {
            return new CountryCodeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CountryCodeAndroid[] newArray(int size) {
            return new CountryCodeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CountryCodeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COUNTRY_CODE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CountryCodeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEC
     */
    public CountryCodeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param countryCode Country Code
     */
    public CountryCodeAndroid(int countryCode) {
        super(countryCode);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CountryCodeAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
