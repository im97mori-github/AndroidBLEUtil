package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Hardware revision string (Characteristics UUID: 0x2A27)
 */
@SuppressWarnings("WeakerAccess")
public class HardwareRevisionString extends AbstractCharacteristic implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<HardwareRevisionString> CREATOR = new Creator<HardwareRevisionString>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public HardwareRevisionString createFromParcel(Parcel in) {
            return new HardwareRevisionString(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public HardwareRevisionString[] newArray(int size) {
            return new HardwareRevisionString[size];
        }

    };

    /**
     * Hardware revision
     */
    private final String mHardwareRevision;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A27
     */
    public HardwareRevisionString(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mHardwareRevision = bluetoothGattCharacteristic.getStringValue(0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HardwareRevisionString(Parcel in) {
        mHardwareRevision = in.readString();
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
        dest.writeString(mHardwareRevision);
    }

    /**
     * @return Hardware revision
     */
    public String getHardwareRevision() {
        return mHardwareRevision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getBytes() {
        return mHardwareRevision.getBytes();
    }

}
