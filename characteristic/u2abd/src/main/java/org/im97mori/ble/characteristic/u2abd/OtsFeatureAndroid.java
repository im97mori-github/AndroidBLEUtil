package org.im97mori.ble.characteristic.u2abd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.OTS_FEATURE_CHARACTERISTIC;

/**
 * OTS Feature (Characteristics UUID: 0x2ABD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class OtsFeatureAndroid extends OtsFeature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<OtsFeatureAndroid> CREATOR = new ByteArrayCreater<OtsFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OtsFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new OtsFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OtsFeatureAndroid[] newArray(int size) {
            return new OtsFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public OtsFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OTS_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new OtsFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABD
     */
    public OtsFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private OtsFeatureAndroid(@NonNull Parcel in) {
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
