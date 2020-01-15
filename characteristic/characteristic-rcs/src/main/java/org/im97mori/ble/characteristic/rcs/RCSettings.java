package org.im97mori.ble.characteristic.rcs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.R_C_SETTINGS_CHARACTERISTIC;

/**
 * RC Settings (Characteristics UUID: 0x2B1E)
 */
public class RCSettings implements ByteArrayInterface, Parcelable {

    /**
     * @see #SETTINGS_LESC_ONLY_FALSE
     * @see #SETTINGS_LESC_ONLY_TRUE
     */
    public static final int SETTINGS_LESC_ONLY_MASK = 0b00000000_00000010;

    /**
     * 0: LESC Only False
     */
    public static final int SETTINGS_LESC_ONLY_FALSE = 0b00000000_00000000;

    /**
     * 1: LESC Only True
     */
    public static final int SETTINGS_LESC_ONLY_TRUE = 0b00000000_00000010;

    /**
     * @see #SETTINGS_USE_OOB_PAIRING_FALSE
     * @see #SETTINGS_USE_OOB_PAIRING_TRUE
     */
    public static final int SETTINGS_USE_OOB_PAIRING_MASK = 0b00000000_00000100;

    /**
     * 0: Use OOB Pairing False
     */
    public static final int SETTINGS_USE_OOB_PAIRING_FALSE = 0b00000000_00000000;

    /**
     * 1: Use OOB Pairing True
     */
    public static final int SETTINGS_USE_OOB_PAIRING_TRUE = 0b00000000_00000100;

    /**
     * @see #SETTINGS_READY_FOR_DISCONNECT_FALSE
     * @see #SETTINGS_READY_FOR_DISCONNECT_TRUE
     */
    public static final int SETTINGS_READY_FOR_DISCONNECT_MASK = 0b00000000_00010000;

    /**
     * 0: Ready for Disconnect False
     */
    public static final int SETTINGS_READY_FOR_DISCONNECT_FALSE = 0b00000000_00000000;

    /**
     * 1: Ready for Disconnect True
     */
    public static final int SETTINGS_READY_FOR_DISCONNECT_TRUE = 0b00000000_00010000;

    /**
     * @see #SETTINGS_LIMITED_ACCESS_FALSE
     * @see #SETTINGS_LIMITED_ACCESS_TRUE
     */
    public static final int SETTINGS_LIMITED_ACCESS_MASK = 0b00000000_00100000;

    /**
     * 0: Limited Access False
     */
    public static final int SETTINGS_LIMITED_ACCESS_FALSE = 0b00000000_00000000;

    /**
     * 1: Limited Access True
     */
    public static final int SETTINGS_LIMITED_ACCESS_TRUE = 0b00000000_00100000;

    /**
     * @see #SETTINGS_ACCESS_PERMITTED_FALSE
     * @see #SETTINGS_ACCESS_PERMITTED_TRUE
     */
    public static final int SETTINGS_ACCESS_PERMITTED_MASK = 0b00000000_01000000;

    /**
     * 0: Access Permitted False
     */
    public static final int SETTINGS_ACCESS_PERMITTED_FALSE = 0b00000000_00000000;

    /**
     * 1: Access Permitted True
     */
    public static final int SETTINGS_ACCESS_PERMITTED_TRUE = 0b00000000_01000000;

    /**
     * @see #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1
     * @see #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_2
     * @see #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_3
     * @see #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_4
     */
    public static final int SETTINGS_ADVERTISEMENT_MOD_MASK = 0b00000011_00000000;

    /**
     * 0: Advertisement Configuration 1
     */
    public static final int SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1 = 0b00000000_00000000;

    /**
     * 1: Advertisement Configuration 2
     */
    public static final int SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_2 = 0b00000001_00000000;

    /**
     * 2: Advertisement Configuration 3
     */
    public static final int SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_3 = 0b00000010_00000000;

    /**
     * 3: Advertisement Configuration 4
     */
    public static final int SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_4 = 0b00000011_00000000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RCSettings> CREATOR = new ByteArrayCreater<RCSettings>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCSettings createFromParcel(@NonNull Parcel in) {
            return new RCSettings(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCSettings[] newArray(int size) {
            return new RCSettings[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RCSettings createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(R_C_SETTINGS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RCSettings(bluetoothGattCharacteristic);
        }

    };

    /**
     * Length
     */
    private final int mLength;

    /**
     * Settings
     */
    private final int mSettings;

    /**
     * E2E-CRC
     */
    private final int mE2eCrc;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1E
     */
    public RCSettings(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLength = BLEUtils.createUInt8(values, 0);
        mSettings = BLEUtils.createSInt16(values, 1);
        if (mLength == 5) {
            mE2eCrc = BLEUtils.createUInt16(values, 3);
        } else {
            mE2eCrc = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RCSettings(@NonNull Parcel in) {
        mLength = in.readInt();
        mSettings = in.readInt();
        mE2eCrc = in.readInt();
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
        dest.writeInt(mLength);
        dest.writeInt(mSettings);
        dest.writeInt(mE2eCrc);
    }

    /**
     * @return Length
     */
    public int getLength() {
        return mLength;
    }

    /**
     * @return Settings
     */
    public int getSettings() {
        return mSettings;
    }

    /**
     * @return {@code true}:LESC Only False, {@code false}:LESC Only True
     */
    public boolean isSettingsLescOnlyFalse() {
        return isSettingsMatched(SETTINGS_LESC_ONLY_MASK, SETTINGS_LESC_ONLY_FALSE);
    }

    /**
     * @return {@code true}:LESC Only True, {@code false}:LESC Only False
     */
    public boolean isSettingsLescOnlyTrue() {
        return isSettingsMatched(SETTINGS_LESC_ONLY_MASK, SETTINGS_LESC_ONLY_TRUE);
    }

    /**
     * @return {@code true}:Use OOB Pairing False, {@code false}:Use OOB Pairing True
     */
    public boolean isSettingsUseOobPairingFalse() {
        return isSettingsMatched(SETTINGS_USE_OOB_PAIRING_MASK, SETTINGS_USE_OOB_PAIRING_FALSE);
    }

    /**
     * @return {@code true}:Use OOB Pairing True, {@code false}:Use OOB Pairing False
     */
    public boolean isSettingsUseOobPairingTrue() {
        return isSettingsMatched(SETTINGS_USE_OOB_PAIRING_MASK, SETTINGS_USE_OOB_PAIRING_TRUE);
    }

    /**
     * @return {@code true}:Ready for Disconnect False, {@code false}:Ready for Disconnect True
     */
    public boolean isSettingsReadyForDisconnectFalse() {
        return isSettingsMatched(SETTINGS_READY_FOR_DISCONNECT_MASK, SETTINGS_READY_FOR_DISCONNECT_FALSE);
    }

    /**
     * @return {@code true}:Ready for Disconnect True, {@code false}:Ready for Disconnect False
     */
    public boolean isSettingsReadyForDisconnectTrue() {
        return isSettingsMatched(SETTINGS_READY_FOR_DISCONNECT_MASK, SETTINGS_READY_FOR_DISCONNECT_TRUE);
    }

    /**
     * @return {@code true}:Limited Access False, {@code false}:Limited Access True
     */
    public boolean isSettingsLimitedAccessFalse() {
        return isSettingsMatched(SETTINGS_LIMITED_ACCESS_MASK, SETTINGS_LIMITED_ACCESS_FALSE);
    }

    /**
     * @return {@code true}:Limited Access True, {@code false}:Limited Access False
     */
    public boolean isSettingsLimitedAccessTrue() {
        return isSettingsMatched(SETTINGS_LIMITED_ACCESS_MASK, SETTINGS_LIMITED_ACCESS_TRUE);
    }

    /**
     * @return {@code true}:Access Permitted False, {@code false}:Access Permitted True
     */
    public boolean isSettingsAccessPermittedFalse() {
        return isSettingsMatched(SETTINGS_ACCESS_PERMITTED_MASK, SETTINGS_ACCESS_PERMITTED_FALSE);
    }

    /**
     * @return {@code true}:Access Permitted True, {@code false}:Access Permitted False
     */
    public boolean isSettingsAccessPermittedTrue() {
        return isSettingsMatched(SETTINGS_ACCESS_PERMITTED_MASK, SETTINGS_ACCESS_PERMITTED_TRUE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 1, {@code false}:not Advertisement Configuration 1
     */
    public boolean isSettingsAdvertisementConfiguration1() {
        return isSettingsMatched(SETTINGS_ADVERTISEMENT_MOD_MASK, SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1);
    }

    /**
     * @return {@code true}:Advertisement Configuration 2, {@code false}:not Advertisement Configuration 2
     */
    public boolean isSettingsAdvertisementConfiguration2() {
        return isSettingsMatched(SETTINGS_ADVERTISEMENT_MOD_MASK, SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_2);
    }

    /**
     * @return {@code true}:Advertisement Configuration 3, {@code false}:not Advertisement Configuration 3
     */
    public boolean isSettingsAdvertisementConfiguration3() {
        return isSettingsMatched(SETTINGS_ADVERTISEMENT_MOD_MASK, SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_3);
    }

    /**
     * @return {@code true}:Advertisement Configuration 4, {@code false}:not Advertisement Configuration 4
     */
    public boolean isSettingsAdvertisementConfiguration4() {
        return isSettingsMatched(SETTINGS_ADVERTISEMENT_MOD_MASK, SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_4);
    }

    /**
     * @return E2E-CRC
     */
    public int getE2eCrc() {
        return mE2eCrc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[mLength];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mLength);
        byteBuffer.putShort((short) mSettings);
        if (mLength == 5) {
            byteBuffer.putShort((short) mE2eCrc);
        }
        return data;
    }

    /**
     * check Settings
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #SETTINGS_LESC_ONLY_FALSE}
     *               , {@link #SETTINGS_LESC_ONLY_TRUE}
     *               , {@link #SETTINGS_USE_OOB_PAIRING_FALSE}
     *               , {@link #SETTINGS_USE_OOB_PAIRING_TRUE}
     *               , {@link #SETTINGS_READY_FOR_DISCONNECT_FALSE}
     *               , {@link #SETTINGS_READY_FOR_DISCONNECT_TRUE}
     *               , {@link #SETTINGS_LIMITED_ACCESS_FALSE}
     *               , {@link #SETTINGS_LIMITED_ACCESS_TRUE}
     *               , {@link #SETTINGS_ACCESS_PERMITTED_FALSE}
     *               , {@link #SETTINGS_ACCESS_PERMITTED_TRUE}
     *               , {@link #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_1}
     *               , {@link #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_2}
     *               , {@link #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_3}
     *               , {@link #SETTINGS_ADVERTISEMENT_MOD_CONFIGURATION_4}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isSettingsMatched(int mask, int expect) {
        return (mask & mSettings) == expect;
    }

}
