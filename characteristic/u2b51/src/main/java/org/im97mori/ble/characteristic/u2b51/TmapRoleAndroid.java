package org.im97mori.ble.characteristic.u2b51;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TMAP_ROLE_CHARACTERISTIC;

/**
 * TMAP Role (Characteristics UUID: 0x2B51)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TmapRoleAndroid extends TmapRole implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TmapRoleAndroid> CREATOR = new ByteArrayCreator<TmapRoleAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TmapRoleAndroid createFromParcel(@NonNull Parcel in) {
            return new TmapRoleAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TmapRoleAndroid[] newArray(int size) {
            return new TmapRoleAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TmapRoleAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TMAP_ROLE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TmapRoleAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B51
     */
    public TmapRoleAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TmapRoleAndroid(@NonNull Parcel in) {
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
