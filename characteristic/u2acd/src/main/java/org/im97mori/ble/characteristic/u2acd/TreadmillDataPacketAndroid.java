package org.im97mori.ble.characteristic.u2acd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Treadmill Data packet (Characteristics UUID: 0x2ACD)
 */
@SuppressWarnings({"WeakerAccess"})
public class TreadmillDataPacketAndroid extends TreadmillDataPacket implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TreadmillDataPacketAndroid> CREATOR = new ByteArrayCreator<TreadmillDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataPacketAndroid createFromParcel(@NonNull Parcel in) {
            return new TreadmillDataPacketAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataPacketAndroid[] newArray(int size) {
            return new TreadmillDataPacketAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TreadmillDataPacketAndroid createFromByteArray(@NonNull byte[] values) {
            return new TreadmillDataPacketAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ACD
     */
    @Deprecated
    public TreadmillDataPacketAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TreadmillDataPacketAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                 Flags
     * @param instantaneousSpeed    Instantaneous Speed
     * @param averageSpeed          Average Speed
     * @param totalDistance         Total Distance
     * @param inclination           Inclination
     * @param rampAngleSetting      Ramp Angle Setting
     * @param positiveElevationGain Positive Elevation Gain
     * @param negativeElevationGain Negative Elevation Gain
     * @param instantaneousPace     Instantaneous Pace
     * @param averagePace           Average Pace
     * @param totalEnergy           Total Energy
     * @param energyPerHour         Energy Per Hour
     * @param energyPerMinute       Energy Per Minute
     * @param heartRate             Heart Rate
     * @param metabolicEquivalent   Metabolic Equivalent
     * @param elapsedTime           Elapsed Time
     * @param remainingTime         Remaining Time
     * @param forceOnBelt           Force on Belt
     * @param powerOutput           Power Output
     */
    public TreadmillDataPacketAndroid(@NonNull byte[] flags, int instantaneousSpeed, int averageSpeed, int totalDistance, int inclination, int rampAngleSetting, int positiveElevationGain, int negativeElevationGain, int instantaneousPace, int averagePace, int totalEnergy, int energyPerHour, int energyPerMinute, int heartRate, int metabolicEquivalent, int elapsedTime, int remainingTime, int forceOnBelt, int powerOutput) {
        super(flags, instantaneousSpeed, averageSpeed, totalDistance, inclination, rampAngleSetting, positiveElevationGain, negativeElevationGain, instantaneousPace, averagePace, totalEnergy, energyPerHour, energyPerMinute, heartRate, metabolicEquivalent, elapsedTime, remainingTime, forceOnBelt, powerOutput);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TreadmillDataPacketAndroid(@NonNull Parcel in) {
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
