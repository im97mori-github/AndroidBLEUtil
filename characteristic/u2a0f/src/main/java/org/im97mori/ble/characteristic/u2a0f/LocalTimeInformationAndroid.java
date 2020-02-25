package org.im97mori.ble.characteristic.u2a0f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;

/**
 * Local Time Information (Characteristics UUID: 0x2A0F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LocalTimeInformationAndroid extends LocalTimeInformation implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocalTimeInformationAndroid> CREATOR = new ByteArrayCreater<LocalTimeInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalTimeInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new LocalTimeInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalTimeInformationAndroid[] newArray(int size) {
            return new LocalTimeInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocalTimeInformationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocalTimeInformationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0F
     */
    public LocalTimeInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private LocalTimeInformationAndroid(@NonNull Parcel in) {
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
