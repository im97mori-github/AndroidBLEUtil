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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;

/**
 * Wind Chill (Characteristics UUID: 0x2A79)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class WindChill implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<WindChill> CREATOR = new ByteArrayCreater<WindChill>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WindChill createFromParcel(@NonNull Parcel in) {
            return new WindChill(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WindChill[] newArray(int size) {
            return new WindChill[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public WindChill createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new WindChill(bluetoothGattCharacteristic);
        }

    };

    /**
     * Wind Chill
     */
    private final int mWindChill;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A79
     */
    public WindChill(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mWindChill = BLEUtils.createSInt8(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private WindChill(@NonNull Parcel in) {
        mWindChill = in.readInt();
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
        dest.writeInt(mWindChill);
    }

    /**
     * @return Wind Chill
     */
    public int getWindChill() {
        return mWindChill;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mWindChill);
        return data;
    }

}
