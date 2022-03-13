package org.im97mori.ble.characteristic.u2af4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.EVENT_STATISTICS_CHARACTERISTIC;

/**
 * Event Statistics (Characteristics UUID: 0x2AF4)
 */
@SuppressWarnings({"WeakerAccess"})
public class EventStatisticsAndroid extends EventStatistics implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<EventStatisticsAndroid> CREATOR = new ByteArrayCreator<EventStatisticsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EventStatisticsAndroid createFromParcel(@NonNull Parcel in) {
            return new EventStatisticsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EventStatisticsAndroid[] newArray(int size) {
            return new EventStatisticsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EventStatisticsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(EVENT_STATISTICS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EventStatisticsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF4
     */
    public EventStatisticsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param numberOfEvents            Number of Events
     * @param averageEventDuration      Average Event Duration
     * @param timeElapsedSinceLastEvent Time Elapsed Since Last Event
     * @param sensingDuration           Sensing Duration
     */
    public EventStatisticsAndroid(int numberOfEvents, int averageEventDuration, int timeElapsedSinceLastEvent, int sensingDuration) {
        super(numberOfEvents, averageEventDuration, timeElapsedSinceLastEvent, sensingDuration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EventStatisticsAndroid(@NonNull Parcel in) {
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
