package org.im97mori.ble.characteristic.u2b4e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ACTIVITY_GOAL_CHARACTERISTIC;

/**
 * Activity Goal (Characteristics UUID: 0x2B4E)
 */
@SuppressWarnings({"WeakerAccess"})
public class ActivityGoalAndroid extends ActivityGoal implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ActivityGoalAndroid> CREATOR = new ByteArrayCreater<ActivityGoalAndroid>() {

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
