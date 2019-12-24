package org.im97mori.ble.characteristic.las;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;

/**
 * Alert Level (Characteristics UUID: 0x2A06)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AlertLevel implements ByteArrayInterface, Parcelable {


    /**
     * 0: No Alert
     */
    public static final int ALERT_LEVEL_NO_ALERT = 0;

    /**
     * 1: Mild Alert
     */
    public static final int ALERT_LEVEL_MILD_ALERT = 1;

    /**
     * 2: High Alert
     */
    public static final int ALERT_LEVEL_HIGH_ALERT = 2;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AlertLevel> CREATOR = new ByteArrayCreater<AlertLevel>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertLevel createFromParcel(@NonNull Parcel in) {
            return new AlertLevel(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertLevel[] newArray(int size) {
            return new AlertLevel[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertLevel createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALERT_LEVEL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AlertLevel(bluetoothGattCharacteristic);
        }

    };

    /**
     * Alert Level
     */
    private final int mAlertLevel;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A06
     */
    public AlertLevel(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAlertLevel = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertLevel(@NonNull Parcel in) {
        mAlertLevel = in.readInt();
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
        dest.writeInt(mAlertLevel);
    }

    /**
     * @return Alert Level
     */
    public int getAlertLevel() {
        return mAlertLevel;
    }

    /**
     * @return {@code true}:No Alert, {@code false}:not No Alert
     */
    public boolean isAlertLevelNoAlert() {
        return ALERT_LEVEL_NO_ALERT == mAlertLevel;
    }

    /**
     * @return {@code true}:Mild Alert, {@code false}:not Mild Alert
     */
    public boolean isAlertLevelMildAlert() {
        return ALERT_LEVEL_MILD_ALERT == mAlertLevel;
    }

    /**
     * @return {@code true}:High Alert, {@code false}:not High Alert
     */
    public boolean isAlertLevelHighAlert() {
        return ALERT_LEVEL_HIGH_ALERT == mAlertLevel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mAlertLevel);
        return data;
    }

}
