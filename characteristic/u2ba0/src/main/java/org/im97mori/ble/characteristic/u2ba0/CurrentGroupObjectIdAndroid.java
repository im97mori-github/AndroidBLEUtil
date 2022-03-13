package org.im97mori.ble.characteristic.u2ba0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_GROUP_OBJECT_ID_CHARACTERISTIC;

/**
 * Current Group Object ID (Characteristics UUID: 0x2BA0)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CurrentGroupObjectIdAndroid extends CurrentGroupObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CurrentGroupObjectIdAndroid> CREATOR = new ByteArrayCreator<CurrentGroupObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentGroupObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new CurrentGroupObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentGroupObjectIdAndroid[] newArray(int size) {
            return new CurrentGroupObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CurrentGroupObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CURRENT_GROUP_OBJECT_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CurrentGroupObjectIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA0
     */
    public CurrentGroupObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentGroupObjectIdAndroid(@NonNull Parcel in) {
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
