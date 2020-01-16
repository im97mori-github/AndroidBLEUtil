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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;

/**
 * Irradiance (Characteristics UUID: 0x2A77)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Irradiance implements ByteArrayInterface, Parcelable {

    /**
     * Irradiance Unit 0.1 watt per square meter
     */
    public static final double IRRADIANCE_RESOLUTION = 0.1d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Irradiance> CREATOR = new ByteArrayCreater<Irradiance>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Irradiance createFromParcel(@NonNull Parcel in) {
            return new Irradiance(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Irradiance[] newArray(int size) {
            return new Irradiance[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Irradiance createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Irradiance(bluetoothGattCharacteristic);
        }

    };

    /**
     * Irradiance
     */
    private final int mIrradiance;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A77
     */
    public Irradiance(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mIrradiance = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Irradiance(@NonNull Parcel in) {
        mIrradiance = in.readInt();
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
        dest.writeInt(mIrradiance);
    }

    /**
     * @return Irradiance
     */
    public int getIrradiance() {
        return mIrradiance;
    }

    /**
     * @return Irradiance(watt per square meter)
     */
    public double getIrradianceWattPerSquareMeter() {
        return IRRADIANCE_RESOLUTION * mIrradiance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mIrradiance);
        return data;
    }

}
