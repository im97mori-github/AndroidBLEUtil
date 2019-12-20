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

/**
 * User Control Point Request (Characteristics UUID: 0x2A9F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class UserControlPointRequest extends UserControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UserControlPointRequest> CREATOR = new ByteArrayCreater<UserControlPointRequest>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointRequest createFromParcel(@NonNull Parcel in) {
            return new UserControlPointRequest(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointRequest[] newArray(int size) {
            return new UserControlPointRequest[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UserControlPointRequest createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(USER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UserControlPointRequest(bluetoothGattCharacteristic);
        }

    };

    /**
     * Op Code
     */
    private final int mOpcode;

    /**
     * User Index
     */
    private final int mUserIndex;

    /**
     * Consent Code
     */
    private final int mConsentCode;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A95
     */
    public UserControlPointRequest(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpcode = (values[0] & 0xff);
        if (OP_CODE_REGISTER_NEW_USER == mOpcode) {
            mUserIndex = 0;
            mConsentCode = BLEUtils.createUInt16(values, 1);
        } else if (OP_CODE_CONSENT == mOpcode) {
            mUserIndex = BLEUtils.createUInt8(values, 1);
            mConsentCode = BLEUtils.createUInt16(values, 2);
        } else if (OP_CODE_DELETE_USERS == mOpcode) {
            mUserIndex = BLEUtils.createUInt8(values, 1);
            mConsentCode = 0;
        } else {
            mUserIndex = 0;
            mConsentCode = 0;
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UserControlPointRequest(@NonNull Parcel in) {
        mOpcode = in.readInt();
        mUserIndex = in.readInt();
        mConsentCode = in.readInt();
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
        dest.writeInt(mOpcode);
        dest.writeInt(mUserIndex);
        dest.writeInt(mConsentCode);
    }

    /**
     * @return Op Code
     */
    public int getOpCode() {
        return mOpcode;
    }

    /**
     * @return User Index
     */
    public int getUserIndex() {
        return mUserIndex;
    }

    /**
     * @return Consent Code
     */
    public int getConsentCode() {
        return mConsentCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 1;
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpcode);
        if (OP_CODE_REGISTER_NEW_USER == mOpcode) {
            byteBuffer.putShort((short) mConsentCode);
            length += 2;
        } else if (OP_CODE_CONSENT == mOpcode) {
            byteBuffer.put((byte) mUserIndex);
            byteBuffer.putShort((short) mConsentCode);
            length += 3;
        } else if (OP_CODE_DELETE_USERS == mOpcode) {
            byteBuffer.put((byte) mUserIndex);
            length++;
        }
        return Arrays.copyOfRange(data, 0, length);
    }

}
