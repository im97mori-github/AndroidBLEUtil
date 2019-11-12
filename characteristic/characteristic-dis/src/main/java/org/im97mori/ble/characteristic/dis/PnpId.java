package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PNP_ID_CHARACTERISTIC;

/**
 * PnP ID (Characteristics UUID: 0x2A50)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class PnpId implements ByteArrayInterface, Parcelable {

    /**
     * 1: Bluetooth SIG assigned Company Identifier value from the Assigned Numbers document
     */
    public static final int VENDOR_ID_SURCE_BLUETOOTH_SIG = 1;

    /**
     * 2: USB Implementer’s Forum assigned Vendor ID value
     */
    public static final int VENDOR_ID_SURCE_USB = 2;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PnpId> CREATOR = new ByteArrayCreater<PnpId>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PnpId createFromParcel(@NonNull Parcel in) {
            return new PnpId(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PnpId[] newArray(int size) {
            return new PnpId[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PnpId createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PNP_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PnpId(bluetoothGattCharacteristic);
        }

    };

    /**
     * Vendor ID Source
     */
    private final int mVendorIdSource;

    /**
     * Vendor ID
     */
    private final int mVendorId;

    /**
     * Product ID
     */
    private final int mProductId;

    /**
     * Product Version
     */
    private final int mProductVersion;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A50
     */
    public PnpId(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mVendorIdSource = (values[0] & 0xff);
        mVendorId = BLEUtils.createUInt16(values, 1);
        mProductId = BLEUtils.createUInt16(values, 3);
        mProductVersion = BLEUtils.createUInt16(values, 5);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PnpId(@NonNull Parcel in) {
        mVendorIdSource = in.readInt();
        mVendorId = in.readInt();
        mProductId = in.readInt();
        mProductVersion = in.readInt();
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
        dest.writeInt(mVendorIdSource);
        dest.writeInt(mVendorId);
        dest.writeInt(mProductId);
        dest.writeInt(mProductVersion);
    }

    /**
     * @return Vendor ID Source
     */
    public int getVendorIdSource() {
        return mVendorIdSource;
    }

    /**
     * @return {@code true}:Bluetooth SIG assigned Company Identifier value from the Assigned Numbers document
     */
    public boolean isVendorIsSourceBluetoothSig() {
        return VENDOR_ID_SURCE_BLUETOOTH_SIG == mVendorIdSource;
    }

    /**
     * @return {@code true}:USB Implementer’s Forum assigned Vendor ID value
     */
    public boolean isVendorIsSourceBluetoothUsb() {
        return VENDOR_ID_SURCE_USB == mVendorIdSource;
    }

    /**
     * @return Vendor ID
     */
    public int getVendorId() {
        return mVendorId;
    }

    /**
     * @return Product ID
     */
    public int getProductId() {
        return mProductId;
    }

    /**
     * @return Product Version
     */
    public int getProductVersion() {
        return mProductVersion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[7];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mVendorIdSource);
        byteBuffer.putShort((short) mVendorId);
        byteBuffer.putShort((short) mProductId);
        byteBuffer.putShort((short) mProductVersion);
        return data;
    }

}
