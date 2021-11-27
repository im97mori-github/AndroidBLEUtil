package org.im97mori.ble.characteristic.u2bd2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;

import static org.im97mori.ble.constants.CharacteristicUUID.NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC;

/**
 * Nitrogen Dioxide Concentration (Characteristics UUID: 0x2BD2)
 */
@SuppressWarnings({"WeakerAccess"})
public class NitrogenDioxideConcentrationAndroid extends NitrogenDioxideConcentration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<NitrogenDioxideConcentrationAndroid> CREATOR = new ByteArrayCreater<NitrogenDioxideConcentrationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NitrogenDioxideConcentrationAndroid createFromParcel(@NonNull Parcel in) {
            return new NitrogenDioxideConcentrationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NitrogenDioxideConcentrationAndroid[] newArray(int size) {
            return new NitrogenDioxideConcentrationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NitrogenDioxideConcentrationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new NitrogenDioxideConcentrationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BD2
     */
    public NitrogenDioxideConcentrationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param nitrogenDioxideConcentration Nitrogen Dioxide Concentration
     */
    public NitrogenDioxideConcentrationAndroid(@NonNull IEEE_11073_20601_SFLOAT nitrogenDioxideConcentration) {
        super(nitrogenDioxideConcentration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NitrogenDioxideConcentrationAndroid(@NonNull Parcel in) {
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
