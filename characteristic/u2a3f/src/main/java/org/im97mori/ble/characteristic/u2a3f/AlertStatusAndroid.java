package org.im97mori.ble.characteristic.u2a3f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_STATUS_CHARACTERISTIC;

/**
 * Alert Status (Characteristics UUID: 0x2A3F)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertStatusAndroid extends AlertStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AlertStatusAndroid> CREATOR = new ByteArrayCreator<AlertStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertStatusAndroid[] newArray(int size) {
            return new AlertStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALERT_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AlertStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A3F
     */
    public AlertStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param alertStatus Alert Status
     */
    public AlertStatusAndroid(int alertStatus) {
        super(alertStatus);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertStatusAndroid(@NonNull Parcel in) {
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
