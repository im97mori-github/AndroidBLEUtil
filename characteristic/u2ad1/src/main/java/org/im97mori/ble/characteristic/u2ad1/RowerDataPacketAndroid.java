package org.im97mori.ble.characteristic.u2ad1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Rower Data packet (Characteristics UUID: 0x2AD1)
 */
@SuppressWarnings({"WeakerAccess"})
public class RowerDataPacketAndroid extends RowerDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RowerDataPacketAndroid> CREATOR = new ByteArrayCreator<RowerDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new RowerDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataPacketAndroid[] newArray(int size) {
            return new RowerDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RowerDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            return new RowerDataPacketAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD1
     */
    @Deprecated
    public RowerDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RowerDataPacketAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags               Flags
     * @param strokeRate          Stroke Rate
     * @param strokeCount         Stroke Count
     * @param averageStrokeRate   Average Stroke Rate
     * @param totalDistance       Total Distance
     * @param instantaneousPace   Instantaneous Pace
     * @param averagePace         Average Pace
     * @param instantaneousPower  Instantaneous Power
     * @param averagePower        Average Power
     * @param resistanceLevel     Resistance Level
     * @param totalEnergy         Total Energy
     * @param energyPerHour       Energy Per Hour
     * @param energyPerMinute     Energy Per Minute
     * @param heartRate           Heart Rate
     * @param metabolicEquivalent Metabolic Equivalent
     * @param elapsedTime         Elapsed Time
     * @param remainingTime       Remaining Time
     */
    public RowerDataPacketAndroid(@NonNull byte[] flags, int strokeRate, int strokeCount, int averageStrokeRate, int totalDistance, int instantaneousPace, int averagePace, int instantaneousPower, int averagePower, int resistanceLevel, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime) {
        super(flags, strokeRate, strokeCount, averageStrokeRate, totalDistance, instantaneousPace, averagePace, instantaneousPower, averagePower, resistanceLevel, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RowerDataPacketAndroid(@NonNull Parcel in) {
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
