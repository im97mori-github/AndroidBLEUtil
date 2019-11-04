package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIRMWARE_REVISION_STRING_CHARACTERISTIC;

/**
 * Firmware revision string (Characteristics UUID: 0x2A26)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FirmwareRevisionString implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FirmwareRevisionString> CREATOR = new ByteArrayCreater<FirmwareRevisionString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirmwareRevisionString createFromParcel(@NonNull Parcel in) {
            return new FirmwareRevisionString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirmwareRevisionString[] newArray(int size) {
            return new FirmwareRevisionString[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FirmwareRevisionString createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FirmwareRevisionString(bluetoothGattCharacteristic);
        }

    };

    /**
     * Firmware revision
     */
    private final String mFirmwareRevision;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A26
     */
    public FirmwareRevisionString(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mFirmwareRevision = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FirmwareRevisionString(@NonNull Parcel in) {
        mFirmwareRevision = in.readString();
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
        dest.writeString(mFirmwareRevision);
    }

    /**
     * @return Firmware revision
     */
    @NonNull
    public String getFirmwareRevision() {
        return mFirmwareRevision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mFirmwareRevision.getBytes();
    }

}
