package org.im97mori.ble.characteristic.gaps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERVICE_CHANGED_CHARACTERISTIC;

/**
 * Service Changed (Characteristics UUID: 0x2A05)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ServiceChanged implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ServiceChanged> CREATOR = new ByteArrayCreater<ServiceChanged>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceChanged createFromParcel(@NonNull Parcel in) {
            return new ServiceChanged(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceChanged[] newArray(int size) {
            return new ServiceChanged[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ServiceChanged createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SERVICE_CHANGED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ServiceChanged(bluetoothGattCharacteristic);
        }

    };

    /**
     * Start of Affected Attribute Handle Range
     */
    private final int mStartOfAffectedAttributeHandleRange;

    /**
     * End of Affected Attribute Handle Range
     */
    private final int mEndOfAffectedAttributeHandleRange;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A05
     */
    public ServiceChanged(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mStartOfAffectedAttributeHandleRange = BLEUtils.createUInt16(values, 0);
        mEndOfAffectedAttributeHandleRange = BLEUtils.createUInt16(values, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ServiceChanged(@NonNull Parcel in) {
        mStartOfAffectedAttributeHandleRange = in.readInt();
        mEndOfAffectedAttributeHandleRange = in.readInt();
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
        dest.writeInt(mStartOfAffectedAttributeHandleRange);
        dest.writeInt(mEndOfAffectedAttributeHandleRange);
    }

    /**
     * @return Start of Affected Attribute Handle Range
     */
    public int getStartOfAffectedAttributeHandleRange() {
        return mStartOfAffectedAttributeHandleRange;
    }

    /**
     * @return End of Affected Attribute Handle Range
     */
    public int getEndOfAffectedAttributeHandleRange() {
        return mEndOfAffectedAttributeHandleRange;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mStartOfAffectedAttributeHandleRange);
        byteBuffer.putShort((short) mEndOfAffectedAttributeHandleRange);
        return data;
    }

}
