package org.im97mori.ble.characteristic.u2b20;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_STATUS_CHANGED_CHARACTERISTIC;

/**
 * IDD Status Changed (Characteristics UUID: 0x2B20)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddStatusChangedAndroid extends IddStatusChanged implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IddStatusChangedAndroid> CREATOR = new ByteArrayCreater<IddStatusChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new IddStatusChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusChangedAndroid[] newArray(int size) {
            return new IddStatusChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddStatusChangedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_STATUS_CHANGED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddStatusChangedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B20
     */
    public IddStatusChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddStatusChangedAndroid(@NonNull Parcel in) {
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
