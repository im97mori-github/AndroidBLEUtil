package org.im97mori.ble.characteristic.u2a77;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;

/**
 * Irradiance (Characteristics UUID: 0x2A77)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IrradianceAndroid extends Irradiance implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IrradianceAndroid> CREATOR = new ByteArrayCreater<IrradianceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IrradianceAndroid createFromParcel(@NonNull Parcel in) {
            return new IrradianceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IrradianceAndroid[] newArray(int size) {
            return new IrradianceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IrradianceAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IrradianceAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A77
     */
    public IrradianceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IrradianceAndroid(@NonNull Parcel in) {
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
