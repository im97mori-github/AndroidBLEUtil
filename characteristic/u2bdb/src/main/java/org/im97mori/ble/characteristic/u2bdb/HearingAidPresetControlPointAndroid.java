package org.im97mori.ble.characteristic.u2bdb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

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
            return new HearingAidPresetControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BDB
     */
    @Deprecated
    public HearingAidPresetControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HearingAidPresetControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HearingAidPresetControlPointAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
