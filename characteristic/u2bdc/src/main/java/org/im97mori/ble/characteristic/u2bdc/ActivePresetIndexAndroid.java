package org.im97mori.ble.characteristic.u2bdc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ACTIVE_PRESET_INDEX_CHARACTERISTIC;

/**
 * Active Preset Index (Characteristics UUID: 0x2BDC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ActivePresetIndexAndroid extends ActivePresetIndex implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ActivePresetIndexAndroid> CREATOR = new ByteArrayCreator<ActivePresetIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ActivePresetIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new ActivePresetIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ActivePresetIndexAndroid[] newArray(int size) {
            return new ActivePresetIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ActivePresetIndexAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ACTIVE_PRESET_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ActivePresetIndexAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BDC
     */
    public ActivePresetIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ActivePresetIndexAndroid(@NonNull Parcel in) {
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
