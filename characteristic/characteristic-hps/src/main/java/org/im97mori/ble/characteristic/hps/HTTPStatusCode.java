package org.im97mori.ble.characteristic.hps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HTTP_STATUS_CODE_CHARACTERISTIC;

/**
 * HTTP Status Code (Characteristics UUID: 0x2AB8)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HTTPStatusCode implements ByteArrayInterface, Parcelable {

    /**
     * @see #DATA_STATUS_HEADERS_RECEIVED_FALSE
     * @see #DATA_STATUS_HEADERS_RECEIVED_TRUE
     */
    public static final int DATA_STATUS_HEADERS_RECEIVED_MASK = 0b00000001;

    /**
     * 0: The response-header and entity-header fields were not received in the HTTP response or stored in the HTTP Headers characteristic.
     */
    public static final int DATA_STATUS_HEADERS_RECEIVED_FALSE = 0b00000000;

    /**
     * 1: The response-header and entity-header fields were received in the HTTP response and stored in the HTTP Headers characteristic for the Client to read.
     */
    public static final int DATA_STATUS_HEADERS_RECEIVED_TRUE = 0b00000001;

    /**
     * @see #DATA_STATUS_HEADERS_TRUNCATED_FALSE
     * @see #DATA_STATUS_HEADERS_TRUNCATED_TRUE
     */
    public static final int DATA_STATUS_HEADERS_TRUNCATED_MASK = 0b00000010;

    /**
     * 0: Any received response-header and entity-header fields did not exceed 512 octets in length.
     */
    public static final int DATA_STATUS_HEADERS_TRUNCATED_FALSE = 0b00000000;

    /**
     * 1: The response-header and entity-header fields exceeded 512 octets in length and the first 512 octets were saved in the HTTP Headers characteristic.
     */
    public static final int DATA_STATUS_HEADERS_TRUNCATED_TRUE = 0b00000010;

    /**
     * @see #DATA_STATUS_BODY_RECEIVED_FALSE
     * @see #DATA_STATUS_BODY_RECEIVED_TRUE
     */
    public static final int DATA_STATUS_BODY_RECEIVED_MASK = 0b00000100;

    /**
     * 0: The entity-body field was not received in the HTTP response or stored in the HTTP Entity Body characteristic.
     */
    public static final int DATA_STATUS_BODY_RECEIVED_FALSE = 0b00000000;

    /**
     * 1: The entity-body field was received in the HTTP response and stored in the HTTP Entity Body characteristic for the Client to read.
     */
    public static final int DATA_STATUS_BODY_RECEIVED_TRUE = 0b00000100;

    /**
     * @see #DATA_STATUS_BODY_TRUNCATED_FALSE
     * @see #DATA_STATUS_BODY_TRUNCATED_TRUE
     */
    public static final int DATA_STATUS_BODY_TRUNCATED_MASK = 0b00001000;

    /**
     * 0: Any received entity-body field did not exceed 512 octets in length.
     */
    public static final int DATA_STATUS_BODY_TRUNCATED_FALSE = 0b00000000;

    /**
     * 1: The entity-body field exceeded 512 octets in length and the first 512 octets were saved in the HTTP Headers characteristic
     */
    public static final int DATA_STATUS_BODY_TRUNCATED_TRUE = 0b00001000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HTTPStatusCode> CREATOR = new ByteArrayCreater<HTTPStatusCode>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPStatusCode createFromParcel(@NonNull Parcel in) {
            return new HTTPStatusCode(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HTTPStatusCode[] newArray(int size) {
            return new HTTPStatusCode[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HTTPStatusCode createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HTTP_STATUS_CODE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HTTPStatusCode(bluetoothGattCharacteristic);
        }

    };

    /**
     * Status Code
     */
    private final int mStatusCode;

    /**
     * Data Status
     */
    private final int mDataStatus;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB8
     */
    public HTTPStatusCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mStatusCode = BLEUtils.createUInt16(values, 0);
        mDataStatus = (values[2] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HTTPStatusCode(@NonNull Parcel in) {
        mStatusCode = in.readInt();
        mDataStatus = in.readInt();
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
        dest.writeInt(mStatusCode);
        dest.writeInt(mDataStatus);
    }

    /**
     * @return Status Code
     */
    public int getStatusCode() {
        return mStatusCode;
    }

    /**
     * @return Data Status
     */
    public int getDataStatus() {
        return mDataStatus;
    }

    /**
     * @return {@code true}:Headers not Received, {@code false}:Headers Received
     */
    public boolean isDataStatusHeadersNotReceived() {
        return isDataStatusMatched(DATA_STATUS_HEADERS_RECEIVED_MASK, DATA_STATUS_HEADERS_RECEIVED_FALSE);
    }

    /**
     * @return {@code true}:Headers Received, {@code false}:Headers not Received
     */
    public boolean isDataStatusHeadersReceived() {
        return isDataStatusMatched(DATA_STATUS_HEADERS_RECEIVED_MASK, DATA_STATUS_HEADERS_RECEIVED_TRUE);
    }

    /**
     * @return {@code true}:Headers not Truncated, {@code false}:Headers Truncated
     */
    public boolean isDataStatusHeadersNotTruncated() {
        return isDataStatusMatched(DATA_STATUS_HEADERS_TRUNCATED_MASK, DATA_STATUS_HEADERS_TRUNCATED_FALSE);
    }

    /**
     * @return {@code true}:Headers Truncated, {@code false}:Headers not Truncated
     */
    public boolean isDataStatusHeadersTruncated() {
        return isDataStatusMatched(DATA_STATUS_HEADERS_TRUNCATED_MASK, DATA_STATUS_HEADERS_TRUNCATED_TRUE);
    }

    /**
     * @return {@code true}:Bodys not Received, {@code false}:Bodys Received
     */
    public boolean isDataStatusBodysNotReceived() {
        return isDataStatusMatched(DATA_STATUS_BODY_RECEIVED_MASK, DATA_STATUS_BODY_RECEIVED_FALSE);
    }

    /**
     * @return {@code true}:Bodys Received, {@code false}:Bodys not Received
     */
    public boolean isDataStatusBodysReceived() {
        return isDataStatusMatched(DATA_STATUS_BODY_RECEIVED_MASK, DATA_STATUS_BODY_RECEIVED_TRUE);
    }

    /**
     * @return {@code true}:Bodys not Truncated, {@code false}:Bodys Truncated
     */
    public boolean isDataStatusBodysNotTruncated() {
        return isDataStatusMatched(DATA_STATUS_BODY_TRUNCATED_MASK, DATA_STATUS_BODY_TRUNCATED_FALSE);
    }

    /**
     * @return {@code true}:Bodys Truncated, {@code false}:Bodys not Truncated
     */
    public boolean isDataStatusBodysTruncated() {
        return isDataStatusMatched(DATA_STATUS_BODY_TRUNCATED_MASK, DATA_STATUS_BODY_TRUNCATED_TRUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[3];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mStatusCode);
        byteBuffer.put((byte) mDataStatus);
        return data;
    }

    /**
     * check Data Status
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #DATA_STATUS_HEADERS_RECEIVED_FALSE}
     *               , {@link #DATA_STATUS_HEADERS_RECEIVED_TRUE}
     *               , {@link #DATA_STATUS_HEADERS_TRUNCATED_FALSE}
     *               , {@link #DATA_STATUS_HEADERS_TRUNCATED_TRUE}
     *               , {@link #DATA_STATUS_BODY_RECEIVED_FALSE}
     *               , {@link #DATA_STATUS_BODY_RECEIVED_TRUE}
     *               , {@link #DATA_STATUS_BODY_TRUNCATED_FALSE}
     *               , {@link #DATA_STATUS_BODY_TRUNCATED_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isDataStatusMatched(int mask, int expect) {
        return (mask & mDataStatus) == expect;
    }

}
