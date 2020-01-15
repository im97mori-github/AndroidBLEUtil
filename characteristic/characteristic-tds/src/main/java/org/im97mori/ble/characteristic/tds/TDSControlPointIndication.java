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
 * TDS Control Point Indication (Characteristics UUID: 0x2ABC)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TDSControlPointIndication implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TDSControlPointIndication> CREATOR = new ByteArrayCreater<TDSControlPointIndication>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointIndication createFromParcel(@NonNull Parcel in) {
            return new TDSControlPointIndication(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TDSControlPointIndication[] newArray(int size) {
            return new TDSControlPointIndication[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TDSControlPointIndication createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TDSControlPointIndication(bluetoothGattCharacteristic);
        }

    };

    /**
     * Requested Op Code
     */
    private final int mRequestedOpCode;

    /**
     * Result Code
     */
    private final int mResultCode;

    /**
     * Response Parameter
     */
    private final byte[] mResponseParameter;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABC
     */
    public TDSControlPointIndication(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mRequestedOpCode = BLEUtils.createUInt8(values, 0);
        mResultCode = BLEUtils.createUInt8(values, 1);
        if (values.length > 2) {
            mResponseParameter = Arrays.copyOfRange(values, 2, values.length);
        } else {
            mResponseParameter = new byte[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TDSControlPointIndication(@NonNull Parcel in) {
        mRequestedOpCode = in.readInt();
        mResultCode = in.readInt();
        mResponseParameter = in.createByteArray();
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
        dest.writeInt(mRequestedOpCode);
        dest.writeInt(mResultCode);
        dest.writeByteArray(mResponseParameter);
    }

    /**
     * @return Requested Op Code
     */
    public int getRequestedOpCode() {
        return mRequestedOpCode;
    }

    /**
     * @return Result Code
     */
    public int getResultCode() {
        return mResultCode;
    }

    /**
     * @return Response Parameter
     */
    @NonNull
    public byte[] getResponseParameter() {
        return mResponseParameter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2 + mResponseParameter.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mRequestedOpCode);
        byteBuffer.put((byte) mResultCode);
        byteBuffer.put(mResponseParameter);
        return data;
    }

}
