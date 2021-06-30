package org.im97mori.ble.characteristic.u2b27;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_RECORD_ACCESS_CONTROL_POINT_CHARACTERISTIC;

/**
 * IDD Record Access Control Point (Characteristics UUID: 0x2B27)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddRecordAccessControlPointAndroid extends IddRecordAccessControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IddRecordAccessControlPointAndroid> CREATOR = new ByteArrayCreater<IddRecordAccessControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddRecordAccessControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new IddRecordAccessControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddRecordAccessControlPointAndroid[] newArray(int size) {
            return new IddRecordAccessControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddRecordAccessControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_RECORD_ACCESS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddRecordAccessControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B27
     */
    public IddRecordAccessControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddRecordAccessControlPointAndroid(@NonNull Parcel in) {
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
