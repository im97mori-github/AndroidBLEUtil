package org.im97mori.ble.characteristic.hts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_FLOAT;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_MASK;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_MASK;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TIME_STAMP_MASK;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT;
import static org.im97mori.ble.characteristic.hts.TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
import static org.im97mori.ble.characteristic.hts.TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;

/**
 * Intermediate Temperature (Characteristics UUID: 0x2A1E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IntermediateTemperature implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IntermediateTemperature> CREATOR = new ByteArrayCreater<IntermediateTemperature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateTemperature createFromParcel(@NonNull Parcel in) {
            return new IntermediateTemperature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateTemperature[] newArray(int size) {
            return new IntermediateTemperature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IntermediateTemperature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IntermediateTemperature(bluetoothGattCharacteristic);
        }

    };

    /**
     * Flags
     */
    private final int mFlags;

    /**
     * Temperature Measurement Value (Celsius)
     */
    private final IEEE_11073_20601_FLOAT mTemperatureMeasurementValueCelsius;

    /**
     * Temperature Measurement Value (Fahrenheit)
     */
    private final IEEE_11073_20601_FLOAT mTemperatureMeasurementValueFahrenheit;

    /**
     * Year
     */
    private final int mYear;

    /**
     * Month
     */
    private final int mMonth;

    /**
     * Day
     */
    private final int mDay;

    /**
     * Hours
     */
    private final int mHours;

    /**
     * Minutes
     */
    private final int mMinutes;

    /**
     * Seconds
     */
    private final int mSeconds;

    /**
     * Temperature Text Description
     */
    private final int mTemperatureTextDescription;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A1E
     */
    public IntermediateTemperature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        int index = 0;
        mFlags = values[index++];
        if (isFlagsTemperatureUnitsCelsius()) {
            mTemperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(values, index);
            mTemperatureMeasurementValueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[4], 0);
        } else {
            mTemperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[4], 0);
            mTemperatureMeasurementValueFahrenheit = new IEEE_11073_20601_FLOAT(values, index);
        }
        index += 4;
        if (isFlagsTimeStampPresent()) {
            mYear = BLEUtils.createUInt16(values, index);
            index += 2;
            mMonth = (values[index++] & 0xff);
            mDay = (values[index++] & 0xff);
            mHours = (values[index++] & 0xff);
            mMinutes = (values[index++] & 0xff);
            mSeconds = (values[index++] & 0xff);
        } else {
            mYear = 0;
            mMonth = 0;
            mDay = 0;
            mHours = 0;
            mMinutes = 0;
            mSeconds = 0;
        }
        if (isFlagsTemperatureTypePresent()) {
            mTemperatureTextDescription = values[index];
        } else {
            mTemperatureTextDescription = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IntermediateTemperature(@NonNull Parcel in) {
        mFlags = in.readInt();
        mTemperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(in.createByteArray(), 0);
        mTemperatureMeasurementValueFahrenheit = new IEEE_11073_20601_FLOAT(in.createByteArray(), 0);
        mYear = in.readInt();
        mMonth = in.readInt();
        mDay = in.readInt();
        mHours = in.readInt();
        mMinutes = in.readInt();
        mSeconds = in.readInt();
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
        dest.writeInt(mFlags);
        dest.writeByteArray(mTemperatureMeasurementValueCelsius.getData());
        dest.writeByteArray(mTemperatureMeasurementValueFahrenheit.getData());
        dest.writeInt(mYear);
        dest.writeInt(mMonth);
        dest.writeInt(mDay);
        dest.writeInt(mHours);
        dest.writeInt(mMinutes);
        dest.writeInt(mSeconds);
        dest.writeInt(mTemperatureTextDescription);
    }

    /**
     * @return Flags
     */
    public int getFlags() {
        return mFlags;
    }

    /**
     * @return {@code true}:Temperature Measurement Value in units of Celsius, {@code false}:Temperature Measurement Value in units of Fahrenheit
     */
    public boolean isFlagsTemperatureUnitsCelsius() {
        return isFlagsMatched(FLAGS_TEMPERATURE_UNITS_MASK, FLAGS_TEMPERATURE_UNITS_CELSIUS);
    }

    /**
     * @return {@code true}:Temperature Measurement Value in units of Fahrenheit, {@code false}:Temperature Measurement Value in units of Celsius
     */
    public boolean isFlagsTemperatureUnitsFahrenheit() {
        return isFlagsMatched(FLAGS_TEMPERATURE_UNITS_MASK, FLAGS_TEMPERATURE_UNITS_FAHRENHEIT);
    }

    /**
     * @return {@code true}:Time Stamp field not present, {@code false}:Time Stamp field present
     */
    public boolean isFlagsTimeStampNotPresent() {
        return isFlagsMatched(FLAGS_TIME_STAMP_MASK, FLAGS_TIME_STAMP_NOT_PRESENT);
    }

    /**
     * @return {@code true}:Time Stamp field present, {@code false}:Time Stamp field not present
     */
    public boolean isFlagsTimeStampPresent() {
        return isFlagsMatched(FLAGS_TIME_STAMP_MASK, FLAGS_TIME_STAMP_PRESENT);
    }

    /**
     * @return {@code true}:Temperature Type field not present, {@code false}:Temperature Type field present
     */
    public boolean isFlagsTemperatureTypeNotPresent() {
        return isFlagsMatched(FLAGS_TEMPERATURE_TYPE_MASK, FLAGS_TEMPERATURE_TYPE_NOT_PRESENT);
    }

    /**
     * @return {@code true}:Temperature Type field present, {@code false}:Temperature Type field not present
     */
    public boolean isFlagsTemperatureTypePresent() {
        return isFlagsMatched(FLAGS_TEMPERATURE_TYPE_MASK, FLAGS_TEMPERATURE_TYPE_PRESENT);
    }

    /**
     * @return Temperature Measurement Value (Celsius)
     */
    public IEEE_11073_20601_FLOAT getTemperatureMeasurementValueCelsius() {
        return mTemperatureMeasurementValueCelsius;
    }

    /**
     * @return Temperature Measurement Value (Fahrenheit)
     */
    public IEEE_11073_20601_FLOAT getTemperatureMeasurementValueFahrenheit() {
        return mTemperatureMeasurementValueFahrenheit;
    }

    /**
     * @return Year
     */
    public int getYear() {
        return mYear;
    }

    /**
     * @return Month
     */
    public int getMonth() {
        return mMonth;
    }

    /**
     * @return Day
     */
    public int getDay() {
        return mDay;
    }

    /**
     * @return Hours
     */
    public int getHours() {
        return mHours;
    }

    /**
     * @return Minutes
     */
    public int getMinutes() {
        return mMinutes;
    }

    /**
     * @return Seconds
     */
    public int getSeconds() {
        return mSeconds;
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
        int length = 0;
        byte[] data = new byte[13];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFlags);
        length++;
        if (isFlagsTemperatureUnitsCelsius()) {
            byteBuffer.put(mTemperatureMeasurementValueCelsius.getData());
        } else {
            byteBuffer.put(mTemperatureMeasurementValueFahrenheit.getData());
        }
        length += 4;
        if (isFlagsTimeStampPresent()) {
            byteBuffer.putShort((short) mYear);
            byteBuffer.put((byte) mMonth);
            byteBuffer.put((byte) mDay);
            byteBuffer.put((byte) mHours);
            byteBuffer.put((byte) mMinutes);
            byteBuffer.put((byte) mSeconds);
            length += 7;
        }
        if (isFlagsTemperatureTypePresent()) {
            byteBuffer.put((byte) mTemperatureTextDescription);
            length++;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link TemperatureMeasurement#FLAGS_TEMPERATURE_UNITS_CELSIUS}
     *               , {@link TemperatureMeasurement#FLAGS_TEMPERATURE_UNITS_FAHRENHEIT}
     *               , {@link TemperatureMeasurement#FLAGS_TIME_STAMP_NOT_PRESENT}
     *               , {@link TemperatureMeasurement#FLAGS_TIME_STAMP_PRESENT}
     *               , {@link TemperatureMeasurement#FLAGS_TEMPERATURE_TYPE_NOT_PRESENT}
     *               , {@link TemperatureMeasurement#FLAGS_TEMPERATURE_TYPE_PRESENT}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isFlagsMatched(int mask, int expect) {
        return (mask & mFlags) == expect;
    }

}
