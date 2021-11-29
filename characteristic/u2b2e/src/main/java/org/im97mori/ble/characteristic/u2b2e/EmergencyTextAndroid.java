package org.im97mori.ble.characteristic.u2b2e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.EMERGENCY_TEXT_CHARACTERISTIC;

/**
 * Emergency Text (Characteristics UUID: 0x2B2E)
 */
@SuppressWarnings({"WeakerAccess"})
public class EmergencyTextAndroid extends EmergencyText implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EmergencyTextAndroid> CREATOR = new ByteArrayCreater<EmergencyTextAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmergencyTextAndroid createFromParcel(@NonNull Parcel in) {
            return new EmergencyTextAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EmergencyTextAndroid[] newArray(int size) {
            return new EmergencyTextAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EmergencyTextAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(EMERGENCY_TEXT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EmergencyTextAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B2E
     */
    public EmergencyTextAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param emergencyText Sulfur Emergency Text
     */
    public EmergencyTextAndroid(@NonNull String emergencyText) {
        super(emergencyText);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EmergencyTextAndroid(@NonNull Parcel in) {
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
