package org.im97mori.ble.characteristic.hts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_TYPE_CHARACTERISTIC;

/**
 * Temperature Type (Characteristics UUID: 0x2A1D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TemperatureType implements ByteArrayInterface, Parcelable {

    /**
     * 1: Armpit
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT = 1;

    /**
     * 2: Body (general)
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL = 2;

    /**
     * 3: Ear (usually ear lobe)
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE = 3;

    /**
     * 4: Finger
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER = 4;

    /**
     * 5: Gastro-intestinal Tract
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT = 5;

    /**
     * 6: Mouth
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH = 6;

    /**
     * 7: Rectum
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM = 7;

    /**
     * 8: Toe
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE = 8;

    /**
     * 9: Tympanum (ear drum)
     */
    public static final int TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM = 9;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TemperatureType> CREATOR = new ByteArrayCreater<TemperatureType>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureType createFromParcel(@NonNull Parcel in) {
            return new TemperatureType(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureType[] newArray(int size) {
            return new TemperatureType[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TemperatureType createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_TYPE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TemperatureType(bluetoothGattCharacteristic);
        }

    };

    /**
     * Temperature Text Description
     */
    private final int mTemperatureTextDescription;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A1D
     */
    public TemperatureType(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTemperatureTextDescription = values[0];
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TemperatureType(@NonNull Parcel in) {
        mTemperatureTextDescription = in.readInt();
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
        dest.writeInt(mTemperatureTextDescription);
    }

    /**
     * @return Temperature Text Description
     */
    public int getTemperatureTextDescription() {
        return mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Armpit, {@code false}:not Armpit
     */
    public boolean isTemperatureTextDescriptionTypeArmpit() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Body (general), {@code false}:not Body (general)
     */
    public boolean isTemperatureTextDescriptionTypeBodyGeneral() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Ear (usually ear lobe), {@code false}:not Ear (usually ear lobe)
     */
    public boolean isTemperatureTextDescriptionTypeEarUsuallyEarLobe() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Finger, {@code false}:not Finger
     */
    public boolean isTemperatureTextDescriptionTypeFinger() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Gastro-intestinal Tract, {@code false}:not Gastro-intestinal Tract
     */
    public boolean isTemperatureTextDescriptionTypeGastroIntestinalTract() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Mouth, {@code false}:not Mouth
     */
    public boolean isTemperatureTextDescriptionTypeMouth() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Rectum, {@code false}:not Rectum
     */
    public boolean isTemperatureTextDescriptionTypeRectum() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Toe, {@code false}:not Toe
     */
    public boolean isTemperatureTextDescriptionTypeToe() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE == mTemperatureTextDescription;
    }

    /**
     * @return {@code true}:Tympanum (ear drum), {@code false}:not Tympanum (ear drum)
     */
    public boolean isTemperatureTextDescriptionTypeTympanumEarDrum() {
        return TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM == mTemperatureTextDescription;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mTemperatureTextDescription);
        return data;
    }

}
