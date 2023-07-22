package org.im97mori.ble.characteristic.u2bfb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ESL_IMAGE_INFORMATION_CHARACTERISTIC;

/**
 * ESL Image Information (Characteristics UUID: 0x2BFB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EslImageInformationAndroid extends EslImageInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EslImageInformationAndroid> CREATOR = new ByteArrayCreator<EslImageInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslImageInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new EslImageInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslImageInformationAndroid[] newArray(int size) {
            return new EslImageInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EslImageInformationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ESL_IMAGE_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EslImageInformationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BFB
     */
    public EslImageInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EslImageInformationAndroid(@NonNull Parcel in) {
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
