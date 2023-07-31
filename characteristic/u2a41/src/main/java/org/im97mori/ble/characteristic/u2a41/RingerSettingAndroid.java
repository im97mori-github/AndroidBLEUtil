package org.im97mori.ble.characteristic.u2a41;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Ringer Setting (Characteristics UUID: 0x2A41)
 */
@SuppressWarnings({"WeakerAccess"})
public class RingerSettingAndroid extends RingerSetting implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RingerSettingAndroid> CREATOR = new ByteArrayCreator<RingerSettingAndroid>() {

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
            return new RingerSettingAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A41
     */
    @Deprecated
    public RingerSettingAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RingerSettingAndroid(@NonNull byte[] values) {
        super(values);
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
