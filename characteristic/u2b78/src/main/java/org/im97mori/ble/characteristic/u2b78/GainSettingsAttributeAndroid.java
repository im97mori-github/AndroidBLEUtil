package org.im97mori.ble.characteristic.u2b78;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.GAIN_SETTINGS_ATTRIBUTE_CHARACTERISTIC;

/**
 * Gain Settings Attribute (Characteristics UUID: 0x2B78)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GainSettingsAttributeAndroid extends GainSettingsAttribute implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GainSettingsAttributeAndroid> CREATOR = new ByteArrayCreater<GainSettingsAttributeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GainSettingsAttributeAndroid createFromParcel(@NonNull Parcel in) {
            return new GainSettingsAttributeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GainSettingsAttributeAndroid[] newArray(int size) {
            return new GainSettingsAttributeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GainSettingsAttributeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GAIN_SETTINGS_ATTRIBUTE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GainSettingsAttributeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B78
     */
    public GainSettingsAttributeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GainSettingsAttributeAndroid(@NonNull Parcel in) {
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
