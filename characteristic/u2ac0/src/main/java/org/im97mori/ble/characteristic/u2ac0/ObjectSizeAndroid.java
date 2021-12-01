package org.im97mori.ble.characteristic.u2ac0;

import static org.im97mori.ble.constants.CharacteristicUUID.OBJECT_SIZE_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * object size (Characteristics UUID: 0x2AC0)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectSizeAndroid extends ObjectSize implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ObjectSizeAndroid> CREATOR = new ByteArrayCreater<ObjectSizeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectSizeAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectSizeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectSizeAndroid[] newArray(int size) {
            return new ObjectSizeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectSizeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OBJECT_SIZE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ObjectSizeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC0
     */
    public ObjectSizeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param currentSize   Current Size
     * @param allocatedSize Allocated Size
     */
    public ObjectSizeAndroid(long currentSize, long allocatedSize) {
        super(currentSize, allocatedSize);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectSizeAndroid(@NonNull Parcel in) {
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
