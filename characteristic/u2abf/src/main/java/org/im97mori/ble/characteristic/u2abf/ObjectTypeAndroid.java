package org.im97mori.ble.characteristic.u2abf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.OBJECT_TYPE_CHARACTERISTIC;

/**
 * Object Type (Characteristics UUID: 0x2ABF)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectTypeAndroid extends ObjectType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectTypeAndroid> CREATOR = new ByteArrayCreator<ObjectTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectTypeAndroid[] newArray(int size) {
            return new ObjectTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectTypeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OBJECT_TYPE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ObjectTypeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABF
     */
    public ObjectTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectTypeAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
    }

    /**
     * Constructor from parameters
     *
     * @param uuid 16bit uuid
     */
    public ObjectTypeAndroid(int uuid) {
        super(uuid);
    }

    /**
     * Constructor from parameters
     *
     * @param uuid 16bit uuid
     */
    public ObjectTypeAndroid(@NonNull UUID uuid) {
        super(uuid);
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
