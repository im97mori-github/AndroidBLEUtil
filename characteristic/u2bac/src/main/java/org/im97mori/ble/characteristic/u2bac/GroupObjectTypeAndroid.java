package org.im97mori.ble.characteristic.u2bac;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.GROUP_OBJECT_TYPE_CHARACTERISTIC;

/**
 * Group Object Type (Characteristics UUID: 0x2BAC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GroupObjectTypeAndroid extends GroupObjectType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<GroupObjectTypeAndroid> CREATOR = new ByteArrayCreator<GroupObjectTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GroupObjectTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new GroupObjectTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GroupObjectTypeAndroid[] newArray(int size) {
            return new GroupObjectTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GroupObjectTypeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GROUP_OBJECT_TYPE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GroupObjectTypeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAC
     */
    public GroupObjectTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GroupObjectTypeAndroid(@NonNull Parcel in) {
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
