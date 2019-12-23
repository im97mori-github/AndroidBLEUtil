package org.im97mori.ble.characteristic.hrs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_SENSOR_LOCATION_CHARACTERISTIC;

/**
 * Body Sensor Location (Characteristics UUID: 0x2A38)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BodySensorLocation implements ByteArrayInterface, Parcelable {

    /**
     * 0: Other
     */
    public static final int BODY_SENSOR_LOCATION_OTHER = 0;

    /**
     * 1: Chest
     */
    public static final int BODY_SENSOR_LOCATION_CHEST = 1;

    /**
     * 2: Wrist
     */
    public static final int BODY_SENSOR_LOCATION_WRIST = 2;

    /**
     * 3: Finger
     */
    public static final int BODY_SENSOR_LOCATION_FINGER = 3;

    /**
     * 4: Hand
     */
    public static final int BODY_SENSOR_LOCATION_HAND = 4;

    /**
     * 5: Ear Lobe
     */
    public static final int BODY_SENSOR_LOCATION_EAR_LOBE = 5;

    /**
     * 6: Foot
     */
    public static final int BODY_SENSOR_LOCATION_FOOT = 6;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BodySensorLocation> CREATOR = new ByteArrayCreater<BodySensorLocation>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodySensorLocation createFromParcel(@NonNull Parcel in) {
            return new BodySensorLocation(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodySensorLocation[] newArray(int size) {
            return new BodySensorLocation[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BodySensorLocation createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BODY_SENSOR_LOCATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BodySensorLocation(bluetoothGattCharacteristic);
        }

    };

    /**
     * Body Sensor Location
     */
    private final int mBodySensorLocation;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A38
     */
    public BodySensorLocation(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mBodySensorLocation = values[0];
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BodySensorLocation(@NonNull Parcel in) {
        mBodySensorLocation = in.readInt();
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
        dest.writeInt(mBodySensorLocation);
    }

    /**
     * @return Body Sensor Location
     */
    public int getBodySensorLocation() {
        return mBodySensorLocation;
    }

    /**
     * @return {@code true}:Other, {@code false}:not Other
     */
    public boolean isBodySensorLocationOhter() {
        return BODY_SENSOR_LOCATION_OTHER == mBodySensorLocation;
    }

    /**
     * @return {@code true}:Chest, {@code false}:not Chest
     */
    public boolean isBodySensorLocationChest() {
        return BODY_SENSOR_LOCATION_CHEST == mBodySensorLocation;
    }

    /**
     * @return {@code true}:Wrist, {@code false}:not Wrist
     */
    public boolean isBodySensorLocationWrist() {
        return BODY_SENSOR_LOCATION_WRIST == mBodySensorLocation;
    }

    /**
     * @return {@code true}:Finger, {@code false}:not Finger
     */
    public boolean isBodySensorLocationFinger() {
        return BODY_SENSOR_LOCATION_FINGER == mBodySensorLocation;
    }

    /**
     * @return {@code true}:Hand, {@code false}:not Hand
     */
    public boolean isBodySensorLocationHand() {
        return BODY_SENSOR_LOCATION_HAND == mBodySensorLocation;
    }

    /**
     * @return {@code true}:Ear Lobe, {@code false}:not Ear Lobe
     */
    public boolean isBodySensorLocationEarLobe() {
        return BODY_SENSOR_LOCATION_EAR_LOBE == mBodySensorLocation;
    }

    /**
     * @return {@code true}:Foot, {@code false}:not Foot
     */
    public boolean isBodySensorLocationFoot() {
        return BODY_SENSOR_LOCATION_FOOT == mBodySensorLocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mBodySensorLocation);
        return data;
    }

}
