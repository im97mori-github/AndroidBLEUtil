package org.im97mori.ble.characteristic.u2bef;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ESTIMATED_SERVICE_DATE_CHARACTERISTIC;

/**
 * Estimated Service Date (Characteristics UUID: 0x2BEF)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EstimatedServiceDateAndroid extends EstimatedServiceDate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EstimatedServiceDateAndroid> CREATOR = new ByteArrayCreator<EstimatedServiceDateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EstimatedServiceDateAndroid createFromParcel(@NonNull Parcel in) {
            return new EstimatedServiceDateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EstimatedServiceDateAndroid[] newArray(int size) {
            return new EstimatedServiceDateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EstimatedServiceDateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ESTIMATED_SERVICE_DATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EstimatedServiceDateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BEF
     */
    public EstimatedServiceDateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EstimatedServiceDateAndroid(@NonNull Parcel in) {
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
