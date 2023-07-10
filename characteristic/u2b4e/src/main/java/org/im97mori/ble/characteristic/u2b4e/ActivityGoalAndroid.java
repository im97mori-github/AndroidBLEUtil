package org.im97mori.ble.characteristic.u2b4e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ACTIVITY_GOAL_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ACTIVITY_GOAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ActivityGoalAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4E
     */
    public ActivityGoalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
        //noinspection ConstantConditions
        super(in.createByteArray());
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
