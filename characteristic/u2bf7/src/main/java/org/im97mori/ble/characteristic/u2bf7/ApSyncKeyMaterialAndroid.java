package org.im97mori.ble.characteristic.u2bf7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.AP_SYNC_KEY_MATERIAL_CHARACTERISTIC;

/**
 * AP Sync Key Material (Characteristics UUID: 0x2BF7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ApSyncKeyMaterialAndroid extends ApSyncKeyMaterial implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ApSyncKeyMaterialAndroid> CREATOR = new ByteArrayCreator<ApSyncKeyMaterialAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApSyncKeyMaterialAndroid createFromParcel(@NonNull Parcel in) {
            return new ApSyncKeyMaterialAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApSyncKeyMaterialAndroid[] newArray(int size) {
            return new ApSyncKeyMaterialAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApSyncKeyMaterialAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AP_SYNC_KEY_MATERIAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ApSyncKeyMaterialAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BF7
     */
    public ApSyncKeyMaterialAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApSyncKeyMaterialAndroid(@NonNull Parcel in) {
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
