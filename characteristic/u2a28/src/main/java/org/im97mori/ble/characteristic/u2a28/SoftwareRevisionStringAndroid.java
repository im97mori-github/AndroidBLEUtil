package org.im97mori.ble.characteristic.u2a28;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SOFTWARE_REVISION_STRING_CHARACTERISTIC;

/**
 * Software Revision String (Characteristics UUID: 0x2A28)
 */
@SuppressWarnings({"WeakerAccess"})
public class SoftwareRevisionStringAndroid extends SoftwareRevisionString implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SoftwareRevisionStringAndroid> CREATOR = new ByteArrayCreater<SoftwareRevisionStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SoftwareRevisionStringAndroid createFromParcel(@NonNull Parcel in) {
            return new SoftwareRevisionStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SoftwareRevisionStringAndroid[] newArray(int size) {
            return new SoftwareRevisionStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SoftwareRevisionStringAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SoftwareRevisionStringAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A28
     */
    public SoftwareRevisionStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param softwareRevision Software Revision
     */
    public SoftwareRevisionStringAndroid(@NonNull String softwareRevision) {
        super(softwareRevision);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SoftwareRevisionStringAndroid(@NonNull Parcel in) {
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
