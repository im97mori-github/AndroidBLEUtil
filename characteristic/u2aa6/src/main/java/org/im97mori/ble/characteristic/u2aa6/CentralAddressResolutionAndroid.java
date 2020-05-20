package org.im97mori.ble.characteristic.u2aa6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;

/**
 * Central Address Resolution (Characteristics UUID: 0x2AA6)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CentralAddressResolutionAndroid extends CentralAddressResolution implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CentralAddressResolutionAndroid> CREATOR = new ByteArrayCreater<CentralAddressResolutionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CentralAddressResolutionAndroid createFromParcel(@NonNull Parcel in) {
            return new CentralAddressResolutionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CentralAddressResolutionAndroid[] newArray(int size) {
            return new CentralAddressResolutionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CentralAddressResolutionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CentralAddressResolutionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA6
     */
    public CentralAddressResolutionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param centralAddressResolutionSupport Central Address Resolution Support
     */
    public CentralAddressResolutionAndroid(int centralAddressResolutionSupport) {
        super(centralAddressResolutionSupport);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private CentralAddressResolutionAndroid(@NonNull Parcel in) {
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
