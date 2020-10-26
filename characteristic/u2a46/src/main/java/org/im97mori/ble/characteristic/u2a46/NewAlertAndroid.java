package org.im97mori.ble.characteristic.u2a46;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NEW_ALERT_CHARACTERISTIC;

/**
 * New Alert (Characteristics UUID: 0x2A46)
 */
@SuppressWarnings({"WeakerAccess"})
public class NewAlertAndroid extends NewAlert implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<NewAlertAndroid> CREATOR = new ByteArrayCreater<NewAlertAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NewAlertAndroid createFromParcel(@NonNull Parcel in) {
            return new NewAlertAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NewAlertAndroid[] newArray(int size) {
            return new NewAlertAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NewAlertAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NEW_ALERT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new NewAlertAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A46
     */
    public NewAlertAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param categoryId            Category ID
     * @param numberOfNewAlert      Number of New Alert
     * @param textStringInformation Text String Information
     */
    public NewAlertAndroid(int categoryId, int numberOfNewAlert, @NonNull String textStringInformation) {
        super(categoryId, numberOfNewAlert, textStringInformation);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NewAlertAndroid(@NonNull Parcel in) {
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
