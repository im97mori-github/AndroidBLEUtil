package org.im97mori.ble.characteristic.u2b9f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.PARENT_GROUP_OBJECT_ID_CHARACTERISTIC;

/**
 * Parent Group Object ID (Characteristics UUID: 0x2B9F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ParentGroupObjectIdAndroid extends ParentGroupObjectId implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ParentGroupObjectIdAndroid> CREATOR = new ByteArrayCreater<ParentGroupObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParentGroupObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new ParentGroupObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ParentGroupObjectIdAndroid[] newArray(int size) {
            return new ParentGroupObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ParentGroupObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARENT_GROUP_OBJECT_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ParentGroupObjectIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9F
     */
    public ParentGroupObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ParentGroupObjectIdAndroid(@NonNull Parcel in) {
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
