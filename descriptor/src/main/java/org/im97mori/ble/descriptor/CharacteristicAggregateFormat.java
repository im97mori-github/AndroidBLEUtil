package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_AGGREGATE_FORMAT_DESCRIPTOR;

/**
 * Characteristic Aggregate Format (Descriptor UUID: 0x2905)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CharacteristicAggregateFormat implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CharacteristicAggregateFormat> CREATOR = new ByteArrayCreater<CharacteristicAggregateFormat>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicAggregateFormat createFromParcel(Parcel in) {
            return new CharacteristicAggregateFormat(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public CharacteristicAggregateFormat[] newArray(int size) {
            return new CharacteristicAggregateFormat[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CharacteristicAggregateFormat createFromByteArray(@NonNull byte[] values) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_AGGREGATE_FORMAT_DESCRIPTOR, 0);
            bluetoothGattDescriptor.setValue(values);
            return new CharacteristicAggregateFormat(bluetoothGattDescriptor);
        }

    };

    /**
     * List of Handles
     */
    private final byte[] mListOfHandles;

    /**
     * Constructor from {@link BluetoothGattDescriptor}
     *
     * @param bluetoothGattDescriptor Characteristics UUID: 0x2905
     */
    public CharacteristicAggregateFormat(BluetoothGattDescriptor bluetoothGattDescriptor) {
        mListOfHandles = bluetoothGattDescriptor.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CharacteristicAggregateFormat(Parcel in) {
        mListOfHandles = in.createByteArray();
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(mListOfHandles);
    }

    /**
     * @return List of Handles
     */
    @NonNull
    public byte[] getListOfHandles() {
        return mListOfHandles;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] data = new byte[mListOfHandles.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mListOfHandles);
        return data;
    }

}
