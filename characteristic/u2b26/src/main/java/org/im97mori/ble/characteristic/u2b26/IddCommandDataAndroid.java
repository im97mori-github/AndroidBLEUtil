package org.im97mori.ble.characteristic.u2b26;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_COMMAND_DATA_CHARACTERISTIC;

/**
 * IDD Command Data (Characteristics UUID: 0x2B26)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddCommandDataAndroid extends IddCommandData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IddCommandDataAndroid> CREATOR = new ByteArrayCreater<IddCommandDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddCommandDataAndroid createFromParcel(@NonNull Parcel in) {
            return new IddCommandDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddCommandDataAndroid[] newArray(int size) {
            return new IddCommandDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddCommandDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_COMMAND_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddCommandDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B26
     */
    public IddCommandDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddCommandDataAndroid(@NonNull Parcel in) {
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
