package org.im97mori.ble.characteristic.u2a50;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.PNP_ID_CHARACTERISTIC;

/**
 * PnP ID (Characteristics UUID: 0x2A50)
 */
@SuppressWarnings({"WeakerAccess"})
public class PnpIdAndroid extends PnpId implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PnpIdAndroid> CREATOR = new ByteArrayCreater<PnpIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PnpIdAndroid createFromParcel(@NonNull Parcel in) {
            return new PnpIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PnpIdAndroid[] newArray(int size) {
            return new PnpIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PnpIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PNP_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PnpIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A50
     */
    public PnpIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param vendorIdSource Vendor ID Source
     * @param vendorId       Vendor ID
     * @param productId      Product ID
     * @param productVersion Product Version
     */
    public PnpIdAndroid(int vendorIdSource, int vendorId, int productId, int productVersion) {
        super(vendorIdSource, vendorId, productId, productVersion);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PnpIdAndroid(@NonNull Parcel in) {
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
