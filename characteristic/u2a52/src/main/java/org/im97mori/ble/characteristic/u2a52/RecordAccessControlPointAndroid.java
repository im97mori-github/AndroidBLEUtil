package org.im97mori.ble.characteristic.u2a52;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.RECORD_ACCESS_CONTROL_POINT_CHARACTERISTIC;

/**
 * Record Access Control Point (Characteristics UUID: 0x2A52)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class RecordAccessControlPointAndroid extends RecordAccessControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RecordAccessControlPointAndroid> CREATOR = new ByteArrayCreater<RecordAccessControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RecordAccessControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new RecordAccessControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RecordAccessControlPointAndroid[] newArray(int size) {
            return new RecordAccessControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RecordAccessControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RECORD_ACCESS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RecordAccessControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A52
     */
    public RecordAccessControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RecordAccessControlPointAndroid(@NonNull Parcel in) {
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
