package org.im97mori.ble.characteristic.dis;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SOFTWARE_REVISION_STRING_CHARACTERISTIC;

/**
 * Software Revision String (Characteristics UUID: 0x2A28)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SoftwareRevisionString implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SoftwareRevisionString> CREATOR = new ByteArrayCreater<SoftwareRevisionString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SoftwareRevisionString createFromParcel(@NonNull Parcel in) {
            return new SoftwareRevisionString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SoftwareRevisionString[] newArray(int size) {
            return new SoftwareRevisionString[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SoftwareRevisionString createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SoftwareRevisionString(bluetoothGattCharacteristic);
        }

    };

    /**
     * Software Revision
     */
    private final String mSoftwareRevision;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A28
     */
    public SoftwareRevisionString(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mSoftwareRevision = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SoftwareRevisionString(@NonNull Parcel in) {
        mSoftwareRevision = in.readString();
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
        dest.writeString(mSoftwareRevision);
    }

    /**
     * @return Software Revision
     */
    public String getSoftwareRevision() {
        return mSoftwareRevision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        return mSoftwareRevision.getBytes();
    }

}
