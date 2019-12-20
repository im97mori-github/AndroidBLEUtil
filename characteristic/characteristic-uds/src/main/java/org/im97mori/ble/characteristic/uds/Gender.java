package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GENDER_CHARACTERISTIC;

/**
 * Gender (Characteristics UUID: 0x2A8C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Gender implements ByteArrayInterface, Parcelable {

    /**
     * 0: Male
     */
    public static final int GENDER_MALE = 0;

    /**
     * 1: Female
     */
    public static final int GENDER_FEMALE = 1;

    /**
     * 2: Unspecified
     */
    public static final int GENDER_UNSPECIFIED = 2;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Gender> CREATOR = new ByteArrayCreater<Gender>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Gender createFromParcel(@NonNull Parcel in) {
            return new Gender(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Gender[] newArray(int size) {
            return new Gender[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Gender createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Gender(bluetoothGattCharacteristic);
        }

    };

    /**
     * Gender
     */
    private final int mGender;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8C
     */
    public Gender(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mGender = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Gender(@NonNull Parcel in) {
        mGender = in.readInt();
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
        dest.writeInt(mGender);
    }

    /**
     * @return Gender
     */
    public int getGender() {
        return mGender;
    }

    /**
     * @return {@code true}:Male, {@code false}:not Male
     */
    public boolean isGenderMale() {
        return GENDER_MALE == mGender;
    }

    /**
     * @return {@code true}:Female, {@code false}:not Female
     */
    public boolean isGenderFemale() {
        return GENDER_FEMALE == mGender;
    }

    /**
     * @return {@code true}:Unspecified, {@code false}:not Unspecified
     */
    public boolean isGenderUnspecified() {
        return GENDER_UNSPECIFIED == mGender;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mGender);
        return data;
    }

}
