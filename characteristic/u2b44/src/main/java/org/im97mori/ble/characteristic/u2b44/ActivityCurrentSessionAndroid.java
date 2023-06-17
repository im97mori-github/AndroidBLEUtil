package org.im97mori.ble.characteristic.u2b44;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ACTIVITY_CURRENT_SESSION_CHARACTERISTIC;

/**
 * Activity Current Session (Characteristics UUID: 0x2B44)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ActivityCurrentSessionAndroid extends ActivityCurrentSession implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ActivityCurrentSessionAndroid> CREATOR = new ByteArrayCreator<ActivityCurrentSessionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ActivityCurrentSessionAndroid createFromParcel(@NonNull Parcel in) {
            return new ActivityCurrentSessionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ActivityCurrentSessionAndroid[] newArray(int size) {
            return new ActivityCurrentSessionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ActivityCurrentSessionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ACTIVITY_CURRENT_SESSION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ActivityCurrentSessionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B44
     */
    public ActivityCurrentSessionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ActivityCurrentSessionAndroid(@NonNull Parcel in) {
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
