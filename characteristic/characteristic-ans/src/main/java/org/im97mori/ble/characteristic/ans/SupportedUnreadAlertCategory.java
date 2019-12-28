package org.im97mori.ble.characteristic.ans;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;

/**
 * Supported Unread Alert Category (Characteristics UUID: 0x2A48)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedUnreadAlertCategory implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedUnreadAlertCategory> CREATOR = new ByteArrayCreater<SupportedUnreadAlertCategory>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedUnreadAlertCategory createFromParcel(@NonNull Parcel in) {
            return new SupportedUnreadAlertCategory(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedUnreadAlertCategory[] newArray(int size) {
            return new SupportedUnreadAlertCategory[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedUnreadAlertCategory createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedUnreadAlertCategory(bluetoothGattCharacteristic);
        }

    };

    /**
     * Category ID Bit Mask 0
     */
    private final int mCategoryIdBitMask0;

    /**
     * 0: no Category ID Bit Mask 1, 1: has Category ID Bit Mask 1
     */
    private final int mHasCategoryIdBitMask1;

    /**
     * Category ID Bit Mask 1
     */
    private final int mCategoryIdBitMask1;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A48
     */
    public SupportedUnreadAlertCategory(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCategoryIdBitMask0 = (values[0] & 0xff);
        if (values.length > 1) {
            mHasCategoryIdBitMask1 = 1;
            mCategoryIdBitMask1 = (values[1] & 0xff);
        } else {
            mHasCategoryIdBitMask1 = 0;
            mCategoryIdBitMask1 = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedUnreadAlertCategory(@NonNull Parcel in) {
        mCategoryIdBitMask0 = in.readInt();
        mHasCategoryIdBitMask1 = in.readInt();
        mCategoryIdBitMask1 = in.readInt();
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
        dest.writeInt(mCategoryIdBitMask0);
        dest.writeInt(mHasCategoryIdBitMask1);
        dest.writeInt(mCategoryIdBitMask1);
    }

    /**
     * @return Category ID Bit Mask 0
     */
    public int getCategoryIdBitMask0() {
        return mCategoryIdBitMask0;
    }

    /**
     * @return Category ID Bit Mask 1
     */
    public int getCategoryIdBitMask1() {
        return mCategoryIdBitMask1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1 + mHasCategoryIdBitMask1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCategoryIdBitMask0);
        if (mHasCategoryIdBitMask1 == 1) {
            byteBuffer.put((byte) mCategoryIdBitMask1);
        }
        return data;
    }

}
