package org.im97mori.ble.characteristic.u2ad2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Indoor Bike Data packet (Characteristics UUID: 0x2AD2)
 */
@SuppressWarnings({"WeakerAccess"})
public class IndoorBikeDataPacketAndroid extends IndoorBikeDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IndoorBikeDataPacketAndroid> CREATOR = new ByteArrayCreator<IndoorBikeDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorBikeDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataPacketAndroid[] newArray(int size) {
            return new IndoorBikeDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IndoorBikeDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            return new IndoorBikeDataPacketAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD2
     */
    @Deprecated
    public IndoorBikeDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IndoorBikeDataPacketAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                Flags
     * @param instantaneousSpeed   Instantaneous Speed
     * @param averageSpeed         Average Speed
     * @param instantaneousCadence Instantaneous Cadence
     * @param averageCadence       Average Cadence
     * @param totalDistance        Total Distance
     * @param resistanceLevel      Resistance Level
     * @param instantaneousPower   Instantaneous Power
     * @param averagePower         Average Power
     * @param totalEnergy          Total Energy
     * @param energyPerHour        Energy Per Hour
     * @param energyPerMinute      Energy Per Minute
     * @param heartRate            Heart Rate
     * @param metabolicEquivalent  Metabolic Equivalent
     * @param elapsedTime          Elapsed Time
     * @param remainingTime        Remaining Time
     */
    public IndoorBikeDataPacketAndroid(@NonNull byte[] flags, int instantaneousSpeed, int averageSpeed, int instantaneousCadence, int averageCadence, int totalDistance, int resistanceLevel, int instantaneousPower, int averagePower, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, instantaneousSpeed, averageSpeed, instantaneousCadence, averageCadence, totalDistance, resistanceLevel, instantaneousPower, averagePower, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IndoorBikeDataPacketAndroid(@NonNull Parcel in) {
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
