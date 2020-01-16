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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;

/**
 * Rainfall (Characteristics UUID: 0x2A78)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Rainfall implements ByteArrayInterface, Parcelable {

    /**
     * Rainfall Unit 1 mm (0.001meters)
     */
    public static final double RAINFALL_RESOLUTION = 0.001d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Rainfall> CREATOR = new ByteArrayCreater<Rainfall>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Rainfall createFromParcel(@NonNull Parcel in) {
            return new Rainfall(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Rainfall[] newArray(int size) {
            return new Rainfall[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Rainfall createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Rainfall(bluetoothGattCharacteristic);
        }

    };

    /**
     * Rainfall
     */
    private final int mRainfall;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A78
     */
    public Rainfall(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mRainfall = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Rainfall(@NonNull Parcel in) {
        mRainfall = in.readInt();
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
        dest.writeInt(mRainfall);
    }

    /**
     * @return Rainfall
     */
    public int getRainfall() {
        return mRainfall;
    }

    /**
     * @return Rainfall(mm)
     */
    public double getRainfallMilliMeters() {
        return RAINFALL_RESOLUTION * mRainfall;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mRainfall);
        return data;
    }

}
