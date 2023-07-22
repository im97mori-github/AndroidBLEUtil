package org.im97mori.ble.characteristic.u2bda;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.HEARING_AID_FEATURES_CHARACTERISTIC;

/**
 * Hearing Aid Features (Characteristics UUID: 0x2BDA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class HearingAidFeaturesAndroid extends HearingAidFeatures implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HearingAidFeaturesAndroid> CREATOR = new ByteArrayCreator<HearingAidFeaturesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HearingAidFeaturesAndroid createFromParcel(@NonNull Parcel in) {
            return new HearingAidFeaturesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HearingAidFeaturesAndroid[] newArray(int size) {
            return new HearingAidFeaturesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HearingAidFeaturesAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEARING_AID_FEATURES_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HearingAidFeaturesAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BDA
     */
    public HearingAidFeaturesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HearingAidFeaturesAndroid(@NonNull Parcel in) {
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
