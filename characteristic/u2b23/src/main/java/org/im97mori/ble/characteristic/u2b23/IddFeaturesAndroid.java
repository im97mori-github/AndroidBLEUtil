package org.im97mori.ble.characteristic.u2b23;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.IDD_FEATURES_CHARACTERISTIC;

/**
 * IDD Features (Characteristics UUID: 0x2B23)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddFeaturesAndroid extends IddFeatures implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddFeaturesAndroid> CREATOR = new ByteArrayCreator<IddFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new IddFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddFeaturesAndroid[] newArray(int size) {
            return new IddFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IDD_FEATURES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IddFeaturesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B23
     */
    public IddFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddFeaturesAndroid(@NonNull Parcel in) {
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
