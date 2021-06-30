package org.im97mori.ble.characteristic.u2b22;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_ANNUNCIATION_STATUS_CHARACTERISTIC;

/**
 * IDD Annunciation Status (Characteristics UUID: 0x2B22)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddAnnunciationStatusAndroid extends IddAnnunciationStatus implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IddAnnunciationStatusAndroid> CREATOR = new ByteArrayCreater<IddAnnunciationStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddAnnunciationStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new IddAnnunciationStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddAnnunciationStatusAndroid[] newArray(int size) {
            return new IddAnnunciationStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddAnnunciationStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_ANNUNCIATION_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddAnnunciationStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B22
     */
    public IddAnnunciationStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddAnnunciationStatusAndroid(@NonNull Parcel in) {
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
