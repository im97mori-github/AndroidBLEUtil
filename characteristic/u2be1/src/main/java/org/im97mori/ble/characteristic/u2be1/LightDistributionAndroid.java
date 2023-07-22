package org.im97mori.ble.characteristic.u2be1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.LIGHT_DISTRIBUTION_CHARACTERISTIC;

/**
 * Light Distribution (Characteristics UUID: 0x2BE1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LightDistributionAndroid extends LightDistribution implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LightDistributionAndroid> CREATOR = new ByteArrayCreator<LightDistributionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightDistributionAndroid createFromParcel(@NonNull Parcel in) {
            return new LightDistributionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightDistributionAndroid[] newArray(int size) {
            return new LightDistributionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LightDistributionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LIGHT_DISTRIBUTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LightDistributionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE1
     */
    public LightDistributionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LightDistributionAndroid(@NonNull Parcel in) {
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
