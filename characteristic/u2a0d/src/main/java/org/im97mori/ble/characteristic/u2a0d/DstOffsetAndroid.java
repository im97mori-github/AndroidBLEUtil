package org.im97mori.ble.characteristic.u2a0d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.DST_OFFSET_CHARACTERISTIC;

/**
 * DST Offset (Characteristics UUID: 0x2A0D)
 */
@SuppressWarnings({"WeakerAccess"})
public class DstOffsetAndroid extends DstOffset implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DstOffsetAndroid> CREATOR = new ByteArrayCreater<DstOffsetAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DstOffsetAndroid createFromParcel(@NonNull Parcel in) {
            return new DstOffsetAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DstOffsetAndroid[] newArray(int size) {
            return new DstOffsetAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DstOffsetAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DST_OFFSET_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DstOffsetAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0D
     */
    public DstOffsetAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param dstOffset DST Offset
     */
    public DstOffsetAndroid(int dstOffset) {
        super(dstOffset);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DstOffsetAndroid(@NonNull Parcel in) {
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
