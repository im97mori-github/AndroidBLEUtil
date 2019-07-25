package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import org.im97mori.ble.ByteArrayCreater;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;

/**
 * Central address resolution (Characteristics UUID: 0x2AA6)
 */
@SuppressWarnings("WeakerAccess")
public class CentralAddressResolution extends AbstractCharacteristic implements Parcelable {

    /**
     * 1: Address resolution is supported in this device
     */
    public static final int CENTRAL_ADDRESS_RESOLUTION_SUPPORTED = 1;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CentralAddressResolution> CREATOR = new ByteArrayCreater<CentralAddressResolution>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CentralAddressResolution createFromParcel(Parcel in) {
            return new CentralAddressResolution(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CentralAddressResolution[] newArray(int size) {
            return new CentralAddressResolution[size];
        }

        /**
         * {@inheritDoc}
         */
        public CentralAddressResolution createFromByteArray(byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CentralAddressResolution(bluetoothGattCharacteristic);
        }

    };

    /**
     * Central address resolution support
     */
    private final int mCentralAddressResolutionSupport;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA6
     */
    public CentralAddressResolution(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mCentralAddressResolutionSupport = bluetoothGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CentralAddressResolution(Parcel in) {
        mCentralAddressResolutionSupport = in.readInt();
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
        dest.writeInt(mCentralAddressResolutionSupport);
    }

    /**
     * @return Central address resolution support
     */
    public int getCentralAddressResolutionSupport() {
        return mCentralAddressResolutionSupport;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCentralAddressResolutionSupport);
        return data;
    }

}
