package org.im97mori.ble.characteristic.u2a4a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * HID Information (Characteristics UUID: 0x2A4A)
 */
@SuppressWarnings({"WeakerAccess"})
public class HIDInformationAndroid extends HIDInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HIDInformationAndroid> CREATOR = new ByteArrayCreator<HIDInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new HIDInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDInformationAndroid[] newArray(int size) {
            return new HIDInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HIDInformationAndroid createFromByteArray(@NonNull byte[] values) {
            return new HIDInformationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4A
     */
    @Deprecated
    public HIDInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HIDInformationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param bcdhid       bcdHID
     * @param bcountrycode bCountryCode
     * @param flags        Flags
     */
    public HIDInformationAndroid(int bcdhid, int bcountrycode, int flags) {
        super(bcdhid, bcountrycode, flags);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HIDInformationAndroid(@NonNull Parcel in) {
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
