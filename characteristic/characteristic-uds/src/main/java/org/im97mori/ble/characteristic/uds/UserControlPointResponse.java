package org.im97mori.ble.characteristic.uds;

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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;

@SuppressWarnings({"WeakerAccess", "unused"})
public class UserControlPointResponse extends UserControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 0x01: Success
     */
    public static final int RESPONSE_VALUE_SUCCESS = 0x01;

    /**
     * 0x02: Op Code not supported
     */
    public static final int RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED = 0x02;

    /**
     * 0x03: Invalid Parameter
     */
    public static final int RESPONSE_VALUE_INVALID_PARAMETER = 0x03;

    /**
     * 0x04: Operation Failed
     */
    public static final int RESPONSE_VALUE_OPERATION_FAILED = 0x04;

    /**
     * 0x05: User Not Authorized
     */
    public static final int RESPONSE_VALUE_USER_NOT_AUTHORIZED = 0x05;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UserControlPointResponse> CREATOR = new ByteArrayCreater<UserControlPointResponse>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointResponse createFromParcel(@NonNull Parcel in) {
            return new UserControlPointResponse(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointResponse[] newArray(int size) {
            return new UserControlPointResponse[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UserControlPointResponse createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(USER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UserControlPointResponse(bluetoothGattCharacteristic);
        }

    };

    /**
     * Response Op Code (0x20)
     */
    private final int mResponseOpCode;

    /**
     * Request Op Code
     */
    private final int mRequestOpCode;

    /**
     * Response Value
     */
    private final int mResponseValue;

    /**
     * User Index
     */
    private final int mUserIndex;

    /**
     * Number of users
     */
    private final int mNumberOfUsers;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A95
     */
    public UserControlPointResponse(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mResponseOpCode = BLEUtils.createUInt8(values, 0);
        mRequestOpCode = BLEUtils.createUInt8(values, 1);
        mResponseValue = BLEUtils.createUInt8(values, 2);
        if (RESPONSE_VALUE_SUCCESS == mResponseValue) {
            if (OP_CODE_REGISTER_NEW_USER == mRequestOpCode) {
                mUserIndex = BLEUtils.createUInt8(values, 3);
                mNumberOfUsers = 0;
            } else if (OP_CODE_LIST_ALL_USERS == mRequestOpCode) {
                mUserIndex = 0;
                mNumberOfUsers = BLEUtils.createUInt8(values, 3);
            } else if (OP_CODE_DELETE_USERS == mRequestOpCode) {
                mUserIndex = BLEUtils.createUInt8(values, 3);
                mNumberOfUsers = 0;
            } else {
                mUserIndex = 0;
                mNumberOfUsers = 0;
            }
        } else {
            mUserIndex = 0;
            mNumberOfUsers = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UserControlPointResponse(@NonNull Parcel in) {
        mResponseOpCode = in.readInt();
        mRequestOpCode = in.readInt();
        mResponseValue = in.readInt();
        mUserIndex = in.readInt();
        mNumberOfUsers = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * @return Response Op Code
     */
    public int getResponseOpCode() {
        return mResponseOpCode;
    }

    /**
     * @return Request Op Code
     */
    public int getRequestOpCode() {
        return mRequestOpCode;
    }

    /**
     * @return Response Value
     */
    public int getResponseValue() {
        return mResponseValue;
    }

    /**
     * @return User Index
     */
    public int getUserIndex() {
        return mUserIndex;
    }

    /**
     * @return Number of users
     */
    public int getNumberOfUsers() {
        return mNumberOfUsers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(mResponseOpCode);
        dest.writeInt(mRequestOpCode);
        dest.writeInt(mResponseValue);
        dest.writeInt(mUserIndex);
        dest.writeInt(mNumberOfUsers);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 3;
        byte[] data = new byte[20];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mResponseOpCode);
        byteBuffer.put((byte) mRequestOpCode);
        byteBuffer.put((byte) mResponseValue);
        if (RESPONSE_VALUE_SUCCESS == mResponseValue) {
            if (OP_CODE_REGISTER_NEW_USER == mRequestOpCode) {
                byteBuffer.put((byte) mUserIndex);
                length++;
            } else if (OP_CODE_LIST_ALL_USERS == mRequestOpCode) {
                byteBuffer.put((byte) mNumberOfUsers);
                length++;
            } else if (OP_CODE_DELETE_USERS == mRequestOpCode) {
                byteBuffer.put((byte) mUserIndex);
                length++;
            }
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
