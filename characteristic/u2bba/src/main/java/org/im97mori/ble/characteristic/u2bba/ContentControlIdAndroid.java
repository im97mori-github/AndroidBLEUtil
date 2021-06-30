package org.im97mori.ble.characteristic.u2bba;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CONTENT_CONTROL_ID_CHARACTERISTIC;

/**
 * Content Control ID (Characteristics UUID: 0x2BBA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ContentControlIdAndroid extends ContentControlId implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ContentControlIdAndroid> CREATOR = new ByteArrayCreater<ContentControlIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ContentControlIdAndroid createFromParcel(@NonNull Parcel in) {
            return new ContentControlIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ContentControlIdAndroid[] newArray(int size) {
            return new ContentControlIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ContentControlIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CONTENT_CONTROL_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ContentControlIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BBA
     */
    public ContentControlIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ContentControlIdAndroid(@NonNull Parcel in) {
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
