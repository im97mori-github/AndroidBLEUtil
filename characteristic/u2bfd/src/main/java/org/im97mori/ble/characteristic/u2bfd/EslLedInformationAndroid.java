package org.im97mori.ble.characteristic.u2bfd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ESL_LED_INFORMATION_CHARACTERISTIC;

/**
 * ESL LED Information (Characteristics UUID: 0x2BFD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EslLedInformationAndroid extends EslLedInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EslLedInformationAndroid> CREATOR = new ByteArrayCreator<EslLedInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslLedInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new EslLedInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslLedInformationAndroid[] newArray(int size) {
            return new EslLedInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EslLedInformationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ESL_LED_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EslLedInformationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BFD
     */
    public EslLedInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EslLedInformationAndroid(@NonNull Parcel in) {
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
