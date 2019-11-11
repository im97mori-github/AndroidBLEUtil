package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;

/**
 * Central Address Resolution (Characteristics UUID: 0x2AA6)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CentralAddressResolution implements ByteArrayInterface, Parcelable {

    /**
     * 0: address resolution is not supported in this device
     */
    public static final int CENTRAL_ADDRESS_RESOLUTION_NOT_SUPPORTED = 0;

    /**
     * 1: address resolution is supported in this device
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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CentralAddressResolution(bluetoothGattCharacteristic);
        }

    };

    /**
     * Central Address Resolution Support
     */
    private final int mCentralAddressResolutionSupport;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA6
     */
    public CentralAddressResolution(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCentralAddressResolutionSupport = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CentralAddressResolution(@NonNull Parcel in) {
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
     * @return Central Address Resolution Support
     */
    public int getCentralAddressResolutionSupport() {
        return mCentralAddressResolutionSupport;
    }

    /**
     * @return {@code true}:address resolution is not supported in this device
     */
    public boolean isCentralAddressResolutionNotSupported() {
        return CENTRAL_ADDRESS_RESOLUTION_NOT_SUPPORTED == mCentralAddressResolutionSupport;
    }

    /**
     * @return {@code true}:address resolution is supported in this device
     */
    public boolean isCentralAddressResolutionSupported() {
        return CENTRAL_ADDRESS_RESOLUTION_SUPPORTED == mCentralAddressResolutionSupport;
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
