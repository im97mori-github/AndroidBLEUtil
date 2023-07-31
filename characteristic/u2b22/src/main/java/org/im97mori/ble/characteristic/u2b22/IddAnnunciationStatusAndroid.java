package org.im97mori.ble.characteristic.u2b22;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * IDD Annunciation Status (Characteristics UUID: 0x2B22)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddAnnunciationStatusAndroid extends IddAnnunciationStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddAnnunciationStatusAndroid> CREATOR = new ByteArrayCreator<IddAnnunciationStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddAnnunciationStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new IddAnnunciationStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddAnnunciationStatusAndroid[] newArray(int size) {
            return new IddAnnunciationStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddAnnunciationStatusAndroid createFromByteArray(@NonNull byte[] values) {
            return new IddAnnunciationStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B22
     */
    @Deprecated
    public IddAnnunciationStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IddAnnunciationStatusAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddAnnunciationStatusAndroid(@NonNull Parcel in) {
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
