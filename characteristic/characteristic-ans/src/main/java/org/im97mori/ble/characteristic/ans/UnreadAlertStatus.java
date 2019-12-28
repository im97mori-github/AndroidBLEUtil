package org.im97mori.ble.characteristic.ans;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UNREAD_ALERT_STATUS_CHARACTERISTIC;

/**
 * Unread Alert Status (Characteristics UUID: 0x2A45)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class UnreadAlertStatus implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UnreadAlertStatus> CREATOR = new ByteArrayCreater<UnreadAlertStatus>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnreadAlertStatus createFromParcel(@NonNull Parcel in) {
            return new UnreadAlertStatus(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnreadAlertStatus[] newArray(int size) {
            return new UnreadAlertStatus[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UnreadAlertStatus createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UNREAD_ALERT_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UnreadAlertStatus(bluetoothGattCharacteristic);
        }

    };

    /**
     * Category ID
     */
    private final int mCategoryId;

    /**
     * Unread count
     */
    private final int mUnreadCount;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A45
     */
    public UnreadAlertStatus(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCategoryId = (values[0] & 0xff);
        mUnreadCount = (values[1] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UnreadAlertStatus(@NonNull Parcel in) {
        mCategoryId = in.readInt();
        mUnreadCount = in.readInt();
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
        dest.writeInt(mCategoryId);
        dest.writeInt(mUnreadCount);
    }

    /**
     * @return Category ID
     */
    public int getCategoryId() {
        return mCategoryId;
    }

    /**
     * @return Unread count
     */
    public int getUnreadCount() {
        return mUnreadCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCategoryId);
        byteBuffer.put((byte) mUnreadCount);
        return data;
    }

}
