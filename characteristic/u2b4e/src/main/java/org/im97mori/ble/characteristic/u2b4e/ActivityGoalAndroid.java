package org.im97mori.ble.characteristic.u2b4e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Activity Goal (Characteristics UUID: 0x2B4E)
 */
@SuppressWarnings({"WeakerAccess"})
public class ActivityGoalAndroid extends ActivityGoal implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ActivityGoalAndroid> CREATOR = new ByteArrayCreator<ActivityGoalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ActivityGoalAndroid createFromParcel(@NonNull Parcel in) {
            return new ActivityGoalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ActivityGoalAndroid[] newArray(int size) {
            return new ActivityGoalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ActivityGoalAndroid createFromByteArray(@NonNull byte[] values) {
            return new ActivityGoalAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4E
     */
    @Deprecated
    public ActivityGoalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ActivityGoalAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param presenceFlags              Presence Flags
     * @param totalEnergyExpenditure     Total Energy Expenditure
     * @param normalWalkingSteps         Normal Walking Steps
     * @param intensitySteps             Intensity Steps
     * @param floorSteps                 Floor Steps
     * @param distance                   Distance
     * @param durationOfNormalWalking    Duration of Normal Walking
     * @param durationOfIntensityWalking Duration of Intensity Walking
     */
    public ActivityGoalAndroid(int presenceFlags, int totalEnergyExpenditure, int normalWalkingSteps, int intensitySteps,
                               int floorSteps, int distance, int durationOfNormalWalking, int durationOfIntensityWalking) {
        super(presenceFlags, totalEnergyExpenditure, normalWalkingSteps, intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ActivityGoalAndroid(@NonNull Parcel in) {
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
