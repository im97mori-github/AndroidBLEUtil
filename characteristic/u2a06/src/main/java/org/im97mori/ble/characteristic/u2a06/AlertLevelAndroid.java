package org.im97mori.ble.characteristic.u2a06;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;

/**
 * Alert Level (Characteristics UUID: 0x2A06)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertLevelAndroid extends AlertLevel implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AlertLevelAndroid> CREATOR = new ByteArrayCreator<AlertLevelAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertLevelAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertLevelAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertLevelAndroid[] newArray(int size) {
            return new AlertLevelAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertLevelAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALERT_LEVEL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AlertLevelAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A06
     */
    public AlertLevelAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param alertLevel Alert Level
     */
    public AlertLevelAndroid(int alertLevel) {
        super(alertLevel);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertLevelAndroid(@NonNull Parcel in) {
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
