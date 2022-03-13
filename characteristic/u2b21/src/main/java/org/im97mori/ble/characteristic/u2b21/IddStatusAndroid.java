package org.im97mori.ble.characteristic.u2b21;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_STATUS_CHARACTERISTIC;

/**
 * IDD Status (Characteristics UUID: 0x2B21)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddStatusAndroid extends IddStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddStatusAndroid> CREATOR = new ByteArrayCreator<IddStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new IddStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddStatusAndroid[] newArray(int size) {
            return new IddStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B21
     */
    public IddStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddStatusAndroid(@NonNull Parcel in) {
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
