package org.im97mori.ble.characteristic.u2b30;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ACS_DATA_IN_CHARACTERISTIC;

/**
 * ACS Data In (Characteristics UUID: 0x2B30)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AcsDataInAndroid extends AcsDataIn implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AcsDataInAndroid> CREATOR = new ByteArrayCreator<AcsDataInAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataInAndroid createFromParcel(@NonNull Parcel in) {
            return new AcsDataInAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataInAndroid[] newArray(int size) {
            return new AcsDataInAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AcsDataInAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ACS_DATA_IN_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AcsDataInAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B30
     */
    public AcsDataInAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AcsDataInAndroid(@NonNull Parcel in) {
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
