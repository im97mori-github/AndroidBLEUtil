package org.im97mori.ble.descriptor.u2904;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

/**
 * Characteristic Presentation Format (Descriptor UUID: 0x2904)
 */
@SuppressWarnings({"WeakerAccess"})
public class CharacteristicPresentationFormatAndroid extends CharacteristicPresentationFormat implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CharacteristicPresentationFormatAndroid> CREATOR = new ByteArrayCreater<CharacteristicPresentationFormatAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicPresentationFormatAndroid createFromParcel(@NonNull Parcel in) {
            return new CharacteristicPresentationFormatAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicPresentationFormatAndroid[] newArray(int size) {
            return new CharacteristicPresentationFormatAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicPresentationFormatAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new CharacteristicPresentationFormatAndroid(bluetoothGattDescriptor);
        }

    };

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2904
     */
    public CharacteristicPresentationFormatAndroid(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(bluetoothGattDescriptor.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param format      Format
     * @param exponent    Exponent
     * @param unit        Unit
     * @param namespace   Namespace
     * @param description Description
     */
    public CharacteristicPresentationFormatAndroid(int format, int exponent, int unit, int namespace, @NonNull byte[] description) {
        super(format, exponent, unit, namespace, description);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicPresentationFormatAndroid(@NonNull Parcel in) {
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
