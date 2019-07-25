package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIRMWARE_REVISION_STRING_CHARACTERISTIC;

/**
 * Firmware revision string (Characteristics UUID: 0x2A26)
 */
@SuppressWarnings("WeakerAccess")
public class FirmwareRevisionString extends AbstractCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FirmwareRevisionString> CREATOR = new ByteArrayCreater<FirmwareRevisionString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public FirmwareRevisionString createFromParcel(Parcel in) {
            return new FirmwareRevisionString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public FirmwareRevisionString[] newArray(int size) {
            return new FirmwareRevisionString[size];
        }

        /**
         * {@inheritDoc}
         */
        public FirmwareRevisionString createFromByteArray(byte[] values) {
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
    public FirmwareRevisionString(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mFirmwareRevision = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FirmwareRevisionString(Parcel in) {
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirmwareRevision);
    }

    /**
     * @return Firmware revision
     */
    public String getFirmwareRevision() {
        return mFirmwareRevision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        return mFirmwareRevision.getBytes();
    }

}
