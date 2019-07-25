package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HARDWARE_REVISION_STRING_CHARACTERISTIC;

/**
 * Hardware revision string (Characteristics UUID: 0x2A27)
 */
@SuppressWarnings("WeakerAccess")
public class HardwareRevisionString extends AbstractCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HardwareRevisionString> CREATOR = new ByteArrayCreater<HardwareRevisionString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public HardwareRevisionString createFromParcel(Parcel in) {
            return new HardwareRevisionString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public HardwareRevisionString[] newArray(int size) {
            return new HardwareRevisionString[size];
        }

        /**
         * {@inheritDoc}
         */
        public HardwareRevisionString createFromByteArray(byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HardwareRevisionString(bluetoothGattCharacteristic);
        }

    };

    /**
     * Hardware revision
     */
    private final String mHardwareRevision;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A27
     */
    public HardwareRevisionString(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mHardwareRevision = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HardwareRevisionString(Parcel in) {
        mHardwareRevision = in.readString();
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
        dest.writeString(mHardwareRevision);
    }

    /**
     * @return Hardware revision
     */
    public String getHardwareRevision() {
        return mHardwareRevision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        return mHardwareRevision.getBytes();
    }

}
