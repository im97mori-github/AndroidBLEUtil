package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPEARANCE_CHARACTERISTIC;

/**
 * Appearance (Characteristics UUID: 0x2A01)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Appearance implements ByteArrayInterface, Parcelable {

    /**
     * 0x00: Unknown
     *
     * @see BLEConstants#APPEARANCE_VALUE_MAP
     * @see BLEConstants#APPEARANCE_DESCRIPTION_MAP
     */
    public static final int CATEGORY_UNKNOWN = 0x00;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Appearance> CREATOR = new ByteArrayCreater<Appearance>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Appearance createFromParcel(@NonNull Parcel in) {
            return new Appearance(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Appearance[] newArray(int size) {
            return new Appearance[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Appearance createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPEARANCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Appearance(bluetoothGattCharacteristic);
        }

    };

    /**
     * Category
     */
    private final byte[] mCategory;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A01
     */
    public Appearance(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCategory = Arrays.copyOfRange(values, 0, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Appearance(@NonNull Parcel in) {
        mCategory = in.createByteArray();
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
        dest.writeByteArray(mCategory);
    }

    /**
     * @return Category
     */
    public byte[] getCategory() {
        return mCategory;
    }

    /**
     * @return Category
     */
    public int getCategoryUint16() {
        return BLEUtils.createUInt16(mCategory, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mCategory);
        return data;
    }

}
