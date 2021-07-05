package org.im97mori.ble.characteristic.u2a43;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_CATEGORY_ID_CHARACTERISTIC;

/**
 * Alert Category ID (Characteristics UUID: 0x2A43)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertCategoryIdAndroid extends AlertCategoryId implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AlertCategoryIdAndroid> CREATOR = new ByteArrayCreater<AlertCategoryIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertCategoryIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertCategoryIdAndroid[] newArray(int size) {
            return new AlertCategoryIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertCategoryIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALERT_CATEGORY_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AlertCategoryIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A43
     */
    public AlertCategoryIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param categoryId Category ID
     */
    public AlertCategoryIdAndroid(int categoryId) {
        super(categoryId);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertCategoryIdAndroid(@NonNull Parcel in) {
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
