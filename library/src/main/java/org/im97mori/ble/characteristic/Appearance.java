package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Appearance (Characteristics UUID: 0x2A01)
 */
@SuppressWarnings("WeakerAccess")
public class Appearance extends AbstractCharacteristic implements Parcelable {

    /**
     * 0x00: Unknown
     *
     * @see org.im97mori.ble.BLEConstants#APPEARANCE_VALUE_MAP
     * @see org.im97mori.ble.BLEConstants#APPEARANCE_DESCRIPTION_MAP
     */
    public static final int CATEGORY_UNKNOWN = 0x00;

    /**
     * @see Creator
     */
    public static final Creator<Appearance> CREATOR = new Creator<Appearance>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public Appearance createFromParcel(Parcel in) {
            return new Appearance(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Appearance[] newArray(int size) {
            return new Appearance[size];
        }

    };

    /**
     * Category
     */
    private final int mCategory;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A01
     */
    public Appearance(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mCategory = bluetoothGattCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT16, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Appearance(Parcel in) {
        mCategory = in.readInt();
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
        dest.writeInt(mCategory);
    }

    /**
     * @return Category
     */
    public int getCategory() {
        return mCategory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mCategory);
        return data;
    }

}