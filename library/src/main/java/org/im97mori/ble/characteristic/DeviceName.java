package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC;

/**
 * Device mName (Characteristics UUID: 0x2A00)
 */
@SuppressWarnings("WeakerAccess")
public class DeviceName extends AbstractCharacteristic implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DeviceName> CREATOR = new ByteArrayCreater<DeviceName>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public DeviceName createFromParcel(Parcel in) {
            return new DeviceName(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public DeviceName[] newArray(int size) {
            return new DeviceName[size];
        }

        /**
         * {@inheritDoc}
         */
        public DeviceName createFromByteArray(byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEVICE_NAME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DeviceName(bluetoothGattCharacteristic);
        }

    };

    /**
     * Name
     */
    private final String mName;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A00
     */
    public DeviceName(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mName = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DeviceName(Parcel in) {
        mName = in.readString();
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
        dest.writeString(mName);
    }

    /**
     * @return Name
     */
    public String getName() {
        return mName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        return mName.getBytes();
    }

}
