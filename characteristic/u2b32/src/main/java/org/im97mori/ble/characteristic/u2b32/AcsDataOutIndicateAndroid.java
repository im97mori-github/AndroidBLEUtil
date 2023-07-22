package org.im97mori.ble.characteristic.u2b32;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ACS_DATA_OUT_INDICATE_CHARACTERISTIC;

/**
 * ACS Data Out Indicate (Characteristics UUID: 0x2B32)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AcsDataOutIndicateAndroid extends AcsDataOutIndicate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AcsDataOutIndicateAndroid> CREATOR = new ByteArrayCreator<AcsDataOutIndicateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutIndicateAndroid createFromParcel(@NonNull Parcel in) {
            return new AcsDataOutIndicateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AcsDataOutIndicateAndroid[] newArray(int size) {
            return new AcsDataOutIndicateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AcsDataOutIndicateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ACS_DATA_OUT_INDICATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AcsDataOutIndicateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B32
     */
    public AcsDataOutIndicateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AcsDataOutIndicateAndroid(@NonNull Parcel in) {
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
