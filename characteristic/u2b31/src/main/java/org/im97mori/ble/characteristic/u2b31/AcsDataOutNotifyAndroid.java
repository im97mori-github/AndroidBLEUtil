package org.im97mori.ble.characteristic.u2b31;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ACS_DATA_OUT_NOTIFY_CHARACTERISTIC;

/**
 * ACS Data Out Notify (Characteristics UUID: 0x2B31)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AcsDataOutNotifyAndroid extends AcsDataOutNotify implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AcsDataOutNotifyAndroid> CREATOR = new ByteArrayCreator<AcsDataOutNotifyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutNotifyAndroid createFromParcel(@NonNull Parcel in) {
            return new AcsDataOutNotifyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutNotifyAndroid[] newArray(int size) {
            return new AcsDataOutNotifyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AcsDataOutNotifyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ACS_DATA_OUT_NOTIFY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AcsDataOutNotifyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B31
     */
    public AcsDataOutNotifyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AcsDataOutNotifyAndroid(@NonNull Parcel in) {
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
