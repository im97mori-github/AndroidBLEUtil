package org.im97mori.ble.characteristic.rtus;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_UPDATE_STATE_CHARACTERISTIC;

/**
 * Time Update State (Characteristics UUID: 0x2A17)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TimeUpdateState implements ByteArrayInterface, Parcelable {

    /**
     * 0: Idle
     */
    public static final int CURRENT_STATE_IDLE = 0;

    /**
     * 1: Update Pending
     */
    public static final int CURRENT_STATE_UPDATE_PENDING = 1;

    /**
     * 0: Successful
     */
    public static final int RESULT_SUCCESSFUL = 0;

    /**
     * 1: Canceled
     */
    public static final int RESULT_CANCELED = 1;

    /**
     * 2: No Connection To Reference
     */
    public static final int RESULT_NO_CONNECTION_TO_REFERENCE = 2;

    /**
     * 3: Reference responded with an error
     */
    public static final int RESULT_REFERENCE_RESPONDED_WITH_AN_ERROR = 3;

    /**
     * 4: Timeout
     */
    public static final int RESULT_TIMEOUT = 4;

    /**
     * 5: Update not attempted after reset
     */
    public static final int RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET = 5;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeUpdateState> CREATOR = new ByteArrayCreater<TimeUpdateState>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateState createFromParcel(@NonNull Parcel in) {
            return new TimeUpdateState(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateState[] newArray(int size) {
            return new TimeUpdateState[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeUpdateState createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_UPDATE_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeUpdateState(bluetoothGattCharacteristic);
        }

    };

    /**
     * Current State
     */
    private final int mCurrentState;

    /**
     * Result
     */
    private final int mResult;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A17
     */
    public TimeUpdateState(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCurrentState = (values[0] & 0xff);
        mResult = (values[1] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeUpdateState(@NonNull Parcel in) {
        mCurrentState = in.readInt();
        mResult = in.readInt();
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
        dest.writeInt(mCurrentState);
        dest.writeInt(mResult);
    }

    /**
     * @return Current State
     */
    public int getCurrentState() {
        return mCurrentState;
    }

    /**
     * @return {@code true}:Idle, {@code false}:Update Pending
     */
    public boolean isCurrentStateIdle() {
        return CURRENT_STATE_IDLE == mCurrentState;
    }

    /**
     * @return {@code true}:Update Pending, {@code false}:Idle
     */
    public boolean isCurrentStateUpdatePending() {
        return CURRENT_STATE_UPDATE_PENDING == mCurrentState;
    }

    /**
     * @return Result
     */
    public int getResult() {
        return mResult;
    }

    /**
     * @return {@code true}:Successful, {@code false}:not Successful
     */
    public boolean isResultSuccessful() {
        return RESULT_SUCCESSFUL == mResult;
    }

    /**
     * @return {@code true}:Canceled, {@code false}:not Canceled
     */
    public boolean isResultCanceled() {
        return RESULT_CANCELED == mResult;
    }

    /**
     * @return {@code true}:No Connection To Reference, {@code false}:not No Connection To Reference
     */
    public boolean isResultNoConnectionToReference() {
        return RESULT_NO_CONNECTION_TO_REFERENCE == mResult;
    }

    /**
     * @return {@code true}:Reference responded with an error, {@code false}:not Reference responded with an error
     */
    public boolean isResultReferenceRespondedWithAnError() {
        return RESULT_REFERENCE_RESPONDED_WITH_AN_ERROR == mResult;
    }

    /**
     * @return {@code true}:Timeout, {@code false}:not Timeout
     */
    public boolean isResultTimeout() {
        return RESULT_TIMEOUT == mResult;
    }

    /**
     * @return {@code true}:Update not attempted after reset, {@code false}:not Update not attempted after reset
     */
    public boolean isResultUpdateNotAttemptedAfterReset() {
        return RESULT_UPDATE_NOT_ATTEMPTED_AFTER_RESET == mResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCurrentState);
        byteBuffer.put((byte) mResult);
        return data;
    }

}
