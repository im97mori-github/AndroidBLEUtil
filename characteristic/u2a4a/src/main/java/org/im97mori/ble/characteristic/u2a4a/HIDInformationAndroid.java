package org.im97mori.ble.characteristic.u2a4a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HID_INFORMATION_CHARACTERISTIC;

/**
 * HID Information (Characteristics UUID: 0x2A4A)
 */
@SuppressWarnings({"WeakerAccess"})
public class HIDInformationAndroid extends HIDInformation implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HIDInformationAndroid> CREATOR = new ByteArrayCreater<HIDInformationAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HID_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HIDInformationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4A
     */
    public HIDInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
    @SuppressWarnings("ConstantConditions")
    private HIDInformationAndroid(@NonNull Parcel in) {
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
