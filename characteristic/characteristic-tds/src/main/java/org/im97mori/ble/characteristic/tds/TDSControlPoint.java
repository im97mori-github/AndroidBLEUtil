package org.im97mori.ble.characteristic.tds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TDS_CONTROL_POINT_CHARACTERISTIC;

/**
 * TDS Control Point (Characteristics UUID: 0x2ABC)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TDSControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TDSControlPoint> CREATOR = new ByteArrayCreater<TDSControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPoint createFromParcel(@NonNull Parcel in) {
            return new TDSControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPoint[] newArray(int size) {
            return new TDSControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TDSControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TDSControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Op Code
     */
    private final int mOpCode;

    /**
     * Organization ID
     */
    private final int mOrganizationId;

    /**
     * Parameter
     */
    private final byte[] mParameter;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABC
     */
    public TDSControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpCode = BLEUtils.createUInt8(values, 0);
        mOrganizationId = BLEUtils.createUInt8(values, 1);
        if (values.length > 2) {
            mParameter = Arrays.copyOfRange(values, 2, values.length);
        } else {
            mParameter = new byte[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TDSControlPoint(@NonNull Parcel in) {
        mOpCode = in.readInt();
        mOrganizationId = in.readInt();
        mParameter = in.createByteArray();
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
        dest.writeInt(mOpCode);
        dest.writeInt(mOrganizationId);
        dest.writeByteArray(mParameter);
    }

    /**
     * @return Op Code
     */
    public int getOpCode() {
        return mOpCode;
    }

    /**
     * @return Organization ID
     */
    public int getOrganizationId() {
        return mOrganizationId;
    }

    /**
     * @return Parameter
     */
    @NonNull
    public byte[] getParameter() {
        return mParameter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2 + mParameter.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpCode);
        byteBuffer.put((byte) mOrganizationId);
        byteBuffer.put(mParameter);
        return data;
    }

}
