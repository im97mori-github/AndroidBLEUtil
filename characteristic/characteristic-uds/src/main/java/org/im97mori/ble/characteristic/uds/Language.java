package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LANGUAGE_CHARACTERISTIC;

/**
 * Language (Characteristics UUID: 0x2AA2)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Language implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Language> CREATOR = new ByteArrayCreater<Language>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Language createFromParcel(@NonNull Parcel in) {
            return new Language(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Language[] newArray(int size) {
            return new Language[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Language createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LANGUAGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Language(bluetoothGattCharacteristic);
        }

    };

    /**
     * Language
     */
    private final String mLanguage;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA2
     */
    public Language(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLanguage = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Language(@NonNull Parcel in) {
        mLanguage = in.readString();
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
        dest.writeString(mLanguage);
    }

    /**
     * @return Language
     */
    public String getLanguage() {
        return mLanguage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[mLanguage.getBytes().length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mLanguage.getBytes());
        return data;
    }

}
