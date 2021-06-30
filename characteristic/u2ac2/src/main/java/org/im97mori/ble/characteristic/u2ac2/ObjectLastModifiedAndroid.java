package org.im97mori.ble.characteristic.u2ac2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.OBJECT_LAST_MODIFIED_CHARACTERISTIC;

/**
 * object last modified (Characteristics UUID: 0x2AC2)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ObjectLastModifiedAndroid extends ObjectLastModified implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ObjectLastModifiedAndroid> CREATOR = new ByteArrayCreater<ObjectLastModifiedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectLastModifiedAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectLastModifiedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectLastModifiedAndroid[] newArray(int size) {
            return new ObjectLastModifiedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectLastModifiedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OBJECT_LAST_MODIFIED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ObjectLastModifiedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC2
     */
    public ObjectLastModifiedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectLastModifiedAndroid(@NonNull Parcel in) {
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
