package org.im97mori.ble.characteristic.ips;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCATION_NAME_CHARACTERISTIC;

/**
 * Location Name (Characteristics UUID: 0x2AB5)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LocationName implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocationName> CREATOR = new ByteArrayCreater<LocationName>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationName createFromParcel(@NonNull Parcel in) {
            return new LocationName(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationName[] newArray(int size) {
            return new LocationName[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocationName createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCATION_NAME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocationName(bluetoothGattCharacteristic);
        }

    };

    /**
     * Location Name
     */
    private final String mLocationName;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB5
     */
    public LocationName(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLocationName = new String(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocationName(@NonNull Parcel in) {
        mLocationName = in.readString();
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
        dest.writeString(mLocationName);
    }

    /**
     * @return Location Name
     */
    public String getLocationName() {
        return mLocationName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[mLocationName.getBytes().length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mLocationName.getBytes());
        return data;
    }

}
