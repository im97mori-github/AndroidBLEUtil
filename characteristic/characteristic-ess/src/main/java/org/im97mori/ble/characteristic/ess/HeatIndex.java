package org.im97mori.ble.characteristic.ess;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;

/**
 * Heat Index (Characteristics UUID: 0x2A7A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HeatIndex implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HeatIndex> CREATOR = new ByteArrayCreater<HeatIndex>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeatIndex createFromParcel(@NonNull Parcel in) {
            return new HeatIndex(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeatIndex[] newArray(int size) {
            return new HeatIndex[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeatIndex createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HeatIndex(bluetoothGattCharacteristic);
        }

    };

    /**
     * Heat Index
     */
    private final int mHeatIndex;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7A
     */
    public HeatIndex(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHeatIndex = BLEUtils.createSInt8(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeatIndex(@NonNull Parcel in) {
        mHeatIndex = in.readInt();
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
        dest.writeInt(mHeatIndex);
    }

    /**
     * @return Heat Index
     */
    public int getHeatIndex() {
        return mHeatIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mHeatIndex);
        return data;
    }

}
