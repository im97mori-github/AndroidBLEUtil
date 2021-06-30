package org.im97mori.ble.characteristic.u2a42;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_CATEGORY_ID_BIT_MASK_CHARACTERISTIC;

/**
 * Alert Category ID Bit Mask (Characteristics UUID: 0x2A42)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AlertCategoryIdBitMaskAndroid extends AlertCategoryIdBitMask implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AlertCategoryIdBitMaskAndroid> CREATOR = new ByteArrayCreater<AlertCategoryIdBitMaskAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdBitMaskAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertCategoryIdBitMaskAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdBitMaskAndroid[] newArray(int size) {
            return new AlertCategoryIdBitMaskAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertCategoryIdBitMaskAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALERT_CATEGORY_ID_BIT_MASK_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AlertCategoryIdBitMaskAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A42
     */
    public AlertCategoryIdBitMaskAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertCategoryIdBitMaskAndroid(@NonNull Parcel in) {
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
