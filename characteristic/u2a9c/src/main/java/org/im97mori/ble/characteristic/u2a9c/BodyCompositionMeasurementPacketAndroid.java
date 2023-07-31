package org.im97mori.ble.characteristic.u2a9c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Body Composition Measurement packet (Characteristics UUID: 0x2A9C)
 */
@SuppressWarnings({"WeakerAccess"})
public class BodyCompositionMeasurementPacketAndroid extends BodyCompositionMeasurementPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BodyCompositionMeasurementPacketAndroid> CREATOR = new ByteArrayCreator<BodyCompositionMeasurementPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new BodyCompositionMeasurementPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementPacketAndroid[] newArray(int size) {
            return new BodyCompositionMeasurementPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BodyCompositionMeasurementPacketAndroid createFromByteArray(@NonNull byte[] values) {
            return new BodyCompositionMeasurementPacketAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A9C
     */
    @Deprecated
    public BodyCompositionMeasurementPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BodyCompositionMeasurementPacketAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                Flags
     * @param bodyFatPercentage    Body Fat Percentage
     * @param year                 Year
     * @param month                Month
     * @param day                  Day
     * @param hours                Hours
     * @param minutes              Minutes
     * @param seconds              Seconds
     * @param userId               User ID
     * @param basalMetabolism      Basal Metabolism
     * @param musclePercentage     Muscle Percentage
     * @param muscleMassSi         Muscle Mass - SI(Muscle Mass - Kilograms in xml)
     * @param muscleMassImperial   Muscle Mass - SI(Muscle Mass - Kilograms in xml)
     * @param fatFreeMassSi        Fat Free Mass - SI(Fat Free Mass - Kilograms in xml)
     * @param fatFreeMassImperial  Fat Free Mass - Imperial(Fat Free Mass - Pounds in xml)
     * @param softLeanMassSi       Soft Lean Mass - SI(Soft Lean Mass - Kilograms in xml)
     * @param softLeanMassImperial Soft Lean Mass - Imperial(Soft Lean Mass - Pounds in xml)
     * @param bodyWaterSi          Body Water Mass - SI(Body Water Mass - Kilograms in xml)
     * @param bodyWaterImperial    Body Water Mass - Imperial(Body Water Mass - Pounds in xml)
     * @param impedance            Impedance
     * @param weightSi             Weight - SI(Weight - Kilograms in xml)
     * @param weightImperial       Weight - Imperial(Weight - Pounds in xml)
     * @param heightSi             Height - SI(Height - Meters in xml)
     * @param heightImperial       Height - Imperial(Height - Inches in xml)
     */
    public BodyCompositionMeasurementPacketAndroid(@NonNull byte[] flags, int bodyFatPercentage, int year, int month, int day, int hours, int minutes, int seconds, int userId, int basalMetabolism, int musclePercentage, int muscleMassSi, int muscleMassImperial, int fatFreeMassSi, int fatFreeMassImperial, int softLeanMassSi, int softLeanMassImperial, int bodyWaterSi, int bodyWaterImperial, int impedance, int weightSi, int weightImperial, int heightSi, int heightImperial) {
        super(flags, bodyFatPercentage, year, month, day, hours, minutes, seconds, userId, basalMetabolism, musclePercentage, muscleMassSi, muscleMassImperial, fatFreeMassSi, fatFreeMassImperial, softLeanMassSi, softLeanMassImperial, bodyWaterSi, bodyWaterImperial, impedance, weightSi, weightImperial, heightSi, heightImperial);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BodyCompositionMeasurementPacketAndroid(@NonNull Parcel in) {
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
