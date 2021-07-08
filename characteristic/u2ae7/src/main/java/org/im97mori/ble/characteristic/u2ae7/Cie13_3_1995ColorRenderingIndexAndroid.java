package org.im97mori.ble.characteristic.u2ae7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CIE13_3_1995_COLOR_RENDERING_INDEX_CHARACTERISTIC;

/**
 * CIE 13.3-1995 Color Rendering Index (Characteristics UUID: 0x2AE7)
 */
@SuppressWarnings({"WeakerAccess"})
public class Cie13_3_1995ColorRenderingIndexAndroid extends Cie13_3_1995ColorRenderingIndex implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Cie13_3_1995ColorRenderingIndexAndroid> CREATOR = new ByteArrayCreater<Cie13_3_1995ColorRenderingIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Cie13_3_1995ColorRenderingIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new Cie13_3_1995ColorRenderingIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Cie13_3_1995ColorRenderingIndexAndroid[] newArray(int size) {
            return new Cie13_3_1995ColorRenderingIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Cie13_3_1995ColorRenderingIndexAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CIE13_3_1995_COLOR_RENDERING_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE7
     */
    public Cie13_3_1995ColorRenderingIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param colorRenderingIndex Color Rendering Index
     */
    public Cie13_3_1995ColorRenderingIndexAndroid(int colorRenderingIndex) {
        super(colorRenderingIndex);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Cie13_3_1995ColorRenderingIndexAndroid(@NonNull Parcel in) {
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
