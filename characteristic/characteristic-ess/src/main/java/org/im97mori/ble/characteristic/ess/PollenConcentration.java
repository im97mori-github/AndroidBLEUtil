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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;

/**
 * Pollen Concentration (Characteristics UUID: 0x2A75)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class PollenConcentration implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PollenConcentration> CREATOR = new ByteArrayCreater<PollenConcentration>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PollenConcentration createFromParcel(@NonNull Parcel in) {
            return new PollenConcentration(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PollenConcentration[] newArray(int size) {
            return new PollenConcentration[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PollenConcentration createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PollenConcentration(bluetoothGattCharacteristic);
        }

    };

    /**
     * Pollen Concentration
     */
    private final int mPollenConcentration;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A75
     */
    public PollenConcentration(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mPollenConcentration = BLEUtils.createUInt24(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PollenConcentration(@NonNull Parcel in) {
        mPollenConcentration = in.readInt();
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
        dest.writeInt(mPollenConcentration);
    }

    /**
     * @return Pollen Concentration
     */
    public int getPollenConcentration() {
        return mPollenConcentration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[3];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mPollenConcentration);
        byteBuffer.put((byte) (mPollenConcentration >> 8));
        byteBuffer.put((byte) (mPollenConcentration >> 16));
        return data;
    }

}
