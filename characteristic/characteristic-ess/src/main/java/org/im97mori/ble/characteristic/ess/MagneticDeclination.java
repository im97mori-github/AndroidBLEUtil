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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;

/**
 * Magnetic Declination (Characteristics UUID: 0x2A2C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MagneticDeclination implements ByteArrayInterface, Parcelable {

    /**
     * Magnetic Declination Unit 0.01 degrees
     */
    public static final double MAGNETIC_DECLINATION_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MagneticDeclination> CREATOR = new ByteArrayCreater<MagneticDeclination>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticDeclination createFromParcel(@NonNull Parcel in) {
            return new MagneticDeclination(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticDeclination[] newArray(int size) {
            return new MagneticDeclination[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MagneticDeclination createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MagneticDeclination(bluetoothGattCharacteristic);
        }

    };

    /**
     * Magnetic Declination
     */
    private final int mMagneticDeclination;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2C
     */
    public MagneticDeclination(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMagneticDeclination = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MagneticDeclination(@NonNull Parcel in) {
        mMagneticDeclination = in.readInt();
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
        dest.writeInt(mMagneticDeclination);
    }

    /**
     * @return Magnetic Declination
     */
    public int getMagneticDeclination() {
        return mMagneticDeclination;
    }

    /**
     * @return Magnetic Declination(degrees)
     */
    public double getMagneticDeclinationDegrees() {
        return MAGNETIC_DECLINATION_RESOLUTION * mMagneticDeclination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mMagneticDeclination);
        return data;
    }

}
