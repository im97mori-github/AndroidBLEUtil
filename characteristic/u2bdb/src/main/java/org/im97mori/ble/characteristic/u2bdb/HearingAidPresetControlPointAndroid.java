package org.im97mori.ble.characteristic.u2bdb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.HEARING_AID_PRESET_CONTROL_POINT_CHARACTERISTIC;

/**
 * Hearing Aid Preset Control Point (Characteristics UUID: 0x2BDB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class HearingAidPresetControlPointAndroid extends HearingAidPresetControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HearingAidPresetControlPointAndroid> CREATOR = new ByteArrayCreator<HearingAidPresetControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HearingAidPresetControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new HearingAidPresetControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HearingAidPresetControlPointAndroid[] newArray(int size) {
            return new HearingAidPresetControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HearingAidPresetControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEARING_AID_PRESET_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HearingAidPresetControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BDB
     */
    public HearingAidPresetControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HearingAidPresetControlPointAndroid(@NonNull Parcel in) {
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
