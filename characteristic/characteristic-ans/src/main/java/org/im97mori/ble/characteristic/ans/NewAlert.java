package org.im97mori.ble.characteristic.ans;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NEW_ALERT_CHARACTERISTIC;

/**
 * New Alert (Characteristics UUID: 0x2A46)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class NewAlert implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<NewAlert> CREATOR = new ByteArrayCreater<NewAlert>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NewAlert createFromParcel(@NonNull Parcel in) {
            return new NewAlert(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NewAlert[] newArray(int size) {
            return new NewAlert[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NewAlert createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NEW_ALERT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new NewAlert(bluetoothGattCharacteristic);
        }

    };

    /**
     * Category ID
     */
    private final int mCategoryId;

    /**
     * Number of New Alert
     */
    private final int mNumberOfNewAlert;

    /**
     * Text String Information
     */
    private final String mTextStringInformation;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A46
     */
    public NewAlert(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCategoryId = (values[0] & 0xff);
        mNumberOfNewAlert = (values[1] & 0xff);
        if (values.length > 2) {
            mTextStringInformation = new String(values, 2, values.length - 2);
        } else {
            mTextStringInformation = null;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NewAlert(@NonNull Parcel in) {
        mCategoryId = in.readInt();
        mNumberOfNewAlert = in.readInt();
        mTextStringInformation = in.readString();
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
        dest.writeInt(mNumberOfNewAlert);
        dest.writeString(mTextStringInformation);
    }

    /**
     * @return Category ID
     */
    public int getCategoryId() {
        return mCategoryId;
    }

    /**
     * @return Number of New Alert
     */
    public int getNumberOfNewAlert() {
        return mNumberOfNewAlert;
    }

    /**
     * @return Text String Information
     */
    @Nullable
    public String getTextStringInformation() {
        return mTextStringInformation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2 + (mTextStringInformation == null ? 0 : mTextStringInformation.getBytes().length)];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCategoryId);
        byteBuffer.put((byte) mNumberOfNewAlert);
        if (mTextStringInformation != null) {
            byteBuffer.put(mTextStringInformation.getBytes());
        }
        return data;
    }

}
