package org.im97mori.ble.characteristic.hps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTP_CONTROL_POINT_CHARACTERISTIC;

/**
 * HTTP Control Point (Characteristics UUID: 0x2ABA)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HTTPControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 1: HTTP GET Request
     */
    public static final int OP_CODE_HTTP_GET_REQUEST = 1;

    /**
     * 2: HTTP HEAD Request
     */
    public static final int OP_CODE_HTTP_HEAD_REQUEST = 2;

    /**
     * 3: HTTP POST Request
     */
    public static final int OP_CODE_HTTP_POST_REQUEST = 3;

    /**
     * 4: HTTP PUT Request
     */
    public static final int OP_CODE_HTTP_PUT_REQUEST = 4;

    /**
     * 5: HTTP DELETE Request
     */
    public static final int OP_CODE_HTTP_DELETE_REQUEST = 5;

    /**
     * 6: HTTPS GET Request
     */
    public static final int OP_CODE_HTTPS_GET_REQUEST = 6;

    /**
     * 7: HTTPS HEAD Request
     */
    public static final int OP_CODE_HTTPS_HEAD_REQUEST = 7;

    /**
     * 8: HTTPS POST Request
     */
    public static final int OP_CODE_HTTPS_POST_REQUEST = 8;

    /**
     * 9: HTTPS HEAD Request
     */
    public static final int OP_CODE_HTTPS_PUT_REQUEST = 9;

    /**
     * 10: HTTPS DELETE Request
     */
    public static final int OP_CODE_HTTPS_DELETE_REQUEST = 10;

    /**
     * 11: HTTP Request Cancel
     */
    public static final int OP_CODE_HTTP_REQUEST_CANCEL = 11;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPControlPoint> CREATOR = new ByteArrayCreater<HTTPControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPControlPoint createFromParcel(@NonNull Parcel in) {
            return new HTTPControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPControlPoint[] newArray(int size) {
            return new HTTPControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTP_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Op Code
     */
    private final int mOpCode;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABA
     */
    public HTTPControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpCode = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPControlPoint(@NonNull Parcel in) {
        mOpCode = in.readInt();
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
    }

    /**
     * @return Op Code
     */
    public int getOpCode() {
        return mOpCode;
    }

    /**
     * @return {@code true}:HTTP GET Request, {@code false}:not HTTP GET Request
     */
    public boolean isOpCodeHttpGetRequest() {
        return OP_CODE_HTTP_GET_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTP HEAD Request, {@code false}:not HTTP HEAD Request
     */
    public boolean isOpCodeHttpHeadRequest() {
        return OP_CODE_HTTP_HEAD_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTP POST Request, {@code false}:not HTTP POST Request
     */
    public boolean isOpCodeHttpPostRequest() {
        return OP_CODE_HTTP_POST_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTP PUT Request, {@code false}:not HTTP PUT Request
     */
    public boolean isOpCodeHttpPutRequest() {
        return OP_CODE_HTTP_PUT_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTP DELETE Request, {@code false}:not HTTP DELETE Request
     */
    public boolean isOpCodeHttpDeleteRequest() {
        return OP_CODE_HTTP_DELETE_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTPS GET Request, {@code false}:not HTTPS GET Request
     */
    public boolean isOpCodeHttpsGetRequest() {
        return OP_CODE_HTTPS_GET_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTPS HEAD Request, {@code false}:not HTTPS HEAD Request
     */
    public boolean isOpCodeHttpsHeadRequest() {
        return OP_CODE_HTTPS_HEAD_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTPS POST Request, {@code false}:not HTTPS POST Request
     */
    public boolean isOpCodeHttpsPostRequest() {
        return OP_CODE_HTTPS_POST_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTPS PUT Request, {@code false}:not HTTPS PUT Request
     */
    public boolean isOpCodeHttpsPutRequest() {
        return OP_CODE_HTTPS_PUT_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTPS DELETE Request, {@code false}:not HTTPS DELETE Request
     */
    public boolean isOpCodeHttpsDeleteRequest() {
        return OP_CODE_HTTPS_DELETE_REQUEST == mOpCode;
    }

    /**
     * @return {@code true}:HTTP Request Cancel, {@code false}:not HTTP Request Cancel
     */
    public boolean isOpCodeHttpRequestCancel() {
        return OP_CODE_HTTP_REQUEST_CANCEL == mOpCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpCode);
        return data;
    }

}
