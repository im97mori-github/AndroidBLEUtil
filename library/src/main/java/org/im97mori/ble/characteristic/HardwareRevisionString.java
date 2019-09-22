package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HARDWARE_REVISION_STRING_CHARACTERISTIC;

/**
 * Hardware revision string (Characteristics UUID: 0x2A27)
 */
@SuppressWarnings("WeakerAccess")
public class HardwareRevisionString implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HardwareRevisionString> CREATOR = new ByteArrayCreater<HardwareRevisionString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HardwareRevisionString createFromParcel(@NonNull Parcel in) {
            return new HardwareRevisionString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HardwareRevisionString[] newArray(int size) {
            return new HardwareRevisionString[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HardwareRevisionString createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HardwareRevisionString(bluetoothGattCharacteristic);
        }

    };

    /**
     * Hardware revision
     */
    private final String mHardwareRevision;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A27
     */
    public HardwareRevisionString(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mHardwareRevision = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HardwareRevisionString(@NonNull Parcel in) {
        mHardwareRevision = in.readString();
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
        dest.writeString(mHardwareRevision);
    }

    /**
     * @return Hardware revision
     */
    @NonNull
    public String getHardwareRevision() {
        return mHardwareRevision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mHardwareRevision.getBytes();
    }

}
