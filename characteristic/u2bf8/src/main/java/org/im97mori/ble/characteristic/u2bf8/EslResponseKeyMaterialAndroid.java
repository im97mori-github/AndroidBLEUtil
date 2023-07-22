package org.im97mori.ble.characteristic.u2bf8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ESL_RESPONSE_KEY_MATERIAL_CHARACTERISTIC;

/**
 * ESL Response Key Material (Characteristics UUID: 0x2BF8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EslResponseKeyMaterialAndroid extends EslResponseKeyMaterial implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EslResponseKeyMaterialAndroid> CREATOR = new ByteArrayCreator<EslResponseKeyMaterialAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslResponseKeyMaterialAndroid createFromParcel(@NonNull Parcel in) {
            return new EslResponseKeyMaterialAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslResponseKeyMaterialAndroid[] newArray(int size) {
            return new EslResponseKeyMaterialAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EslResponseKeyMaterialAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ESL_RESPONSE_KEY_MATERIAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EslResponseKeyMaterialAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BF8
     */
    public EslResponseKeyMaterialAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EslResponseKeyMaterialAndroid(@NonNull Parcel in) {
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
