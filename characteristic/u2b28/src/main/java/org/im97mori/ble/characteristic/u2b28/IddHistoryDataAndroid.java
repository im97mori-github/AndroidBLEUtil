package org.im97mori.ble.characteristic.u2b28;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_HISTORY_DATA_CHARACTERISTIC;

/**
 * IDD History Data (Characteristics UUID: 0x2B28)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddHistoryDataAndroid extends IddHistoryData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IddHistoryDataAndroid> CREATOR = new ByteArrayCreater<IddHistoryDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddHistoryDataAndroid createFromParcel(@NonNull Parcel in) {
            return new IddHistoryDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddHistoryDataAndroid[] newArray(int size) {
            return new IddHistoryDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddHistoryDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_HISTORY_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddHistoryDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B28
     */
    public IddHistoryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddHistoryDataAndroid(@NonNull Parcel in) {
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
