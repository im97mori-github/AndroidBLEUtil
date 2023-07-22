package org.im97mori.ble.characteristic.u2bfc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ESL_SENSOR_INFORMATION_CHARACTERISTIC;

/**
 * ESL Sensor Information (Characteristics UUID: 0x2BFC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EslSensorInformationAndroid extends EslSensorInformation implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EslSensorInformationAndroid> CREATOR = new ByteArrayCreator<EslSensorInformationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslSensorInformationAndroid createFromParcel(@NonNull Parcel in) {
            return new EslSensorInformationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EslSensorInformationAndroid[] newArray(int size) {
            return new EslSensorInformationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EslSensorInformationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ESL_SENSOR_INFORMATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EslSensorInformationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BFC
     */
    public EslSensorInformationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EslSensorInformationAndroid(@NonNull Parcel in) {
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
