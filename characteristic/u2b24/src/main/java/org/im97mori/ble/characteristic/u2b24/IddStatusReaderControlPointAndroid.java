package org.im97mori.ble.characteristic.u2b24;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_STATUS_READER_CONTROL_POINT_CHARACTERISTIC;

/**
 * IDD Status Reader Control Point (Characteristics UUID: 0x2B24)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddStatusReaderControlPointAndroid extends IddStatusReaderControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IddStatusReaderControlPointAndroid> CREATOR = new ByteArrayCreater<IddStatusReaderControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusReaderControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new IddStatusReaderControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusReaderControlPointAndroid[] newArray(int size) {
            return new IddStatusReaderControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddStatusReaderControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_STATUS_READER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddStatusReaderControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B24
     */
    public IddStatusReaderControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddStatusReaderControlPointAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
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
