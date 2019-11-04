package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Central address resolution (Characteristics UUID: 0x2AA6)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CentralAddressResolution implements ByteArrayInterface, Parcelable {

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
        @NonNull
        public CentralAddressResolution createFromParcel(@NonNull Parcel in) {
            return new CentralAddressResolution(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CentralAddressResolution[] newArray(int size) {
            return new CentralAddressResolution[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CentralAddressResolution createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLEConstants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, 0, 0);
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
    public CentralAddressResolution(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
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
    public void writeToParcel(@NonNull Parcel dest, int flags) {
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
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCentralAddressResolutionSupport);
        return data;
    }

}
