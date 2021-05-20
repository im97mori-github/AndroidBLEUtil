package org.im97mori.ble.characteristic.u2a41;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RINGER_SETTING_CHARACTERISTIC;

/**
 * Ringer Setting (Characteristics UUID: 0x2A41)
 */
@SuppressWarnings({"WeakerAccess"})
public class RingerSettingAndroid extends RingerSetting implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RingerSettingAndroid> CREATOR = new ByteArrayCreater<RingerSettingAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerSettingAndroid createFromParcel(@NonNull Parcel in) {
            return new RingerSettingAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerSettingAndroid[] newArray(int size) {
            return new RingerSettingAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RingerSettingAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RINGER_SETTING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RingerSettingAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A41
     */
    public RingerSettingAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param ringerSetting Ringer SettingRinger Setting
     */
    public RingerSettingAndroid(int ringerSetting) {
        super(ringerSetting);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RingerSettingAndroid(@NonNull Parcel in) {
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
