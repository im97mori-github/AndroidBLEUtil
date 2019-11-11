package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;

/**
 * Peripheral Privacy Flag (Characteristics UUID: 0x2A02)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class PeripheralPrivacyFlag implements ByteArrayInterface, Parcelable {

    /**
     * 0: privacy is disabled in this device
     */
    public static final int FLAGS_PRIVACY_IS_DISABLED_IN_THIS_DEVICE = 0;

    /**
     * 1: privacy is enabled in this device
     */
    public static final int FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE = 1;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PeripheralPrivacyFlag> CREATOR = new ByteArrayCreater<PeripheralPrivacyFlag>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPrivacyFlag createFromParcel(@NonNull Parcel in) {
            return new PeripheralPrivacyFlag(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPrivacyFlag[] newArray(int size) {
            return new PeripheralPrivacyFlag[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PeripheralPrivacyFlag createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PeripheralPrivacyFlag(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flag
     */
    private final int mFlag;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A02
     */
    public PeripheralPrivacyFlag(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFlag = BLEUtils.createBoolean(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PeripheralPrivacyFlag(@NonNull Parcel in) {
        mFlag = in.readInt();
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
        dest.writeInt(mFlag);
    }

    /**
     * @return Flag
     */
    public int getFlag() {
        return mFlag;
    }

    /**
     * @return {@code true}:privacy is disabled in this device
     */
    public boolean isPrivacyDisabled() {
        return FLAGS_PRIVACY_IS_DISABLED_IN_THIS_DEVICE == mFlag;
    }

    /**
     * @return {@code true}:privacy is enabled in this device
     */
    public boolean isPrivacyEnabled() {
        return FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE == mFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFlag);
        return data;
    }

}
