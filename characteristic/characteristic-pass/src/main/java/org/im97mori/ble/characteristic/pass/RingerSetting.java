package org.im97mori.ble.characteristic.pass;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RINGER_SETTING_CHARACTERISTIC;

/**
 * Ringer Setting (Characteristics UUID: 0x2A41)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RingerSetting implements ByteArrayInterface, Parcelable {

    /**
     * 0: Ringer Silent
     */
    public static final int RINGER_SETTING_SILENT = 0;

    /**
     * 1: Ringer Normal
     */
    public static final int RINGER_SETTING_NORMAL = 1;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RingerSetting> CREATOR = new ByteArrayCreater<RingerSetting>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerSetting createFromParcel(@NonNull Parcel in) {
            return new RingerSetting(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerSetting[] newArray(int size) {
            return new RingerSetting[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RingerSetting createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RINGER_SETTING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RingerSetting(bluetoothGattCharacteristic);
        }

    };

    /**
     * Ringer Setting
     */
    private final int mRingerSetting;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A41
     */
    public RingerSetting(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mRingerSetting = values[0];
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RingerSetting(@NonNull Parcel in) {
        mRingerSetting = in.readInt();
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
        dest.writeInt(mRingerSetting);
    }

    /**
     * @return Ringer Setting
     */
    public int getRingerSetting() {
        return mRingerSetting;
    }

    /**
     * @return {@code true}:Ringer Silent, {@code false}:Ringer Normal
     */
    public boolean isRingerSettingSilent() {
        return RINGER_SETTING_SILENT == mRingerSetting;
    }

    /**
     * @return {@code true}:Ringer Normal, {@code false}:Ringer Silent
     */
    public boolean isRingerSettingNormal() {
        return RINGER_SETTING_NORMAL == mRingerSetting;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mRingerSetting);
        return data;
    }

}
