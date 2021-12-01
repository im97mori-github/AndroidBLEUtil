package org.im97mori.ble.characteristic.u2abd;

import static org.im97mori.ble.constants.CharacteristicUUID.OTS_FEATURE_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

/**
 * OTS Feature (Characteristics UUID: 0x2ABD)
 */
@SuppressWarnings({"WeakerAccess"})
public class OtsFeatureAndroid extends OtsFeature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<OtsFeatureAndroid> CREATOR = new ByteArrayCreater<OtsFeatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OtsFeatureAndroid createFromParcel(@NonNull Parcel in) {
            return new OtsFeatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OtsFeatureAndroid[] newArray(int size) {
            return new OtsFeatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public OtsFeatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OTS_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new OtsFeatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2ABD
     */
    public OtsFeatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from flags
     *
     * @param isOacpCreateOpCodeSupported                 {@code true}:{@link #OACP_CREATE_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OACP_CREATE_OP_CODE_SUPPORTED_FALSE}
     * @param isOacpDeleteOpCodeSupported                 {@code true}:{@link #OACP_DELETE_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OACP_DELETE_OP_CODE_SUPPORTED_FALSE}
     * @param isOacpCalculateOpCodeSupported              {@code true}:{@link #OACP_CALCULATE_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OACP_CALCULATE_OP_CODE_SUPPORTED_FALSE}
     * @param isOacpExecuteOpCodeSupported                {@code true}:{@link #OACP_EXECUTE_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OACP_EXECUTE_OP_CODE_SUPPORTED_FALSE}
     * @param isOacpReadOpCodeSupported                   {@code true}:{@link #OACP_READ_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OACP_READ_OP_CODE_SUPPORTED_FALSE}
     * @param isOacpWriteOpCodeSupported                  {@code true}:{@link #OACP_WRITE_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OACP_WRITE_OP_CODE_SUPPORTED_FALSE}
     * @param isAppendingAdditionalDataToObjectsSupported {@code true}:{@link #APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #APPENDING_ADDITIONAL_DATA_TO_OBJECTS_SUPPORTED_FALSE}
     * @param isTruncationOfObjectsSupported              {@code true}:{@link #TRUNCATION_OF_OBJECTS_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #TRUNCATION_OF_OBJECTS_SUPPORTED_FALSE}
     * @param isPatchingOfObjectsSupported                {@code true}:{@link #PATCHING_OF_OBJECTS_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #PATCHING_OF_OBJECTS_SUPPORTED_FALSE}
     * @param isOacpAbortOpCodeSupported                  {@code true}:{@link #OACP_ABORT_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OACP_ABORT_OP_CODE_SUPPORTED_FALSE}
     * @param isOlcpGoToOpCodeSupported                   {@code true}:{@link #OLCP_GO_TO_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OLCP_GO_TO_OP_CODE_SUPPORTED_FALSE}
     * @param isOlcpOrderOpCodeSupported                  {@code true}:{@link #OLCP_ORDER_OP_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OLCP_ORDER_OP_CODE_SUPPORTED_FALSE}
     * @param isOlcpRequestNumberOfObjectsOpCodeSupported {@code true}:{@link #OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OLCP_REQUEST_NUMBER_OF_OBJECTS_CODE_SUPPORTED_FALSE}
     * @param isOlcpClearMarkingOpCodeSupported           {@code true}:{@link #OLCP_CLEAR_MARKING_CODE_SUPPORTED_TRUE},
     *                                                    {@code false}:{@link #OLCP_CLEAR_MARKING_CODE_SUPPORTED_FALSE}
     */
    // @formatter:off
    public OtsFeatureAndroid(boolean isOacpCreateOpCodeSupported
            , boolean isOacpDeleteOpCodeSupported
            , boolean isOacpCalculateOpCodeSupported
            , boolean isOacpExecuteOpCodeSupported
            , boolean isOacpReadOpCodeSupported
            , boolean isOacpWriteOpCodeSupported
            , boolean isAppendingAdditionalDataToObjectsSupported
            , boolean isTruncationOfObjectsSupported
            , boolean isPatchingOfObjectsSupported
            , boolean isOacpAbortOpCodeSupported
            , boolean isOlcpGoToOpCodeSupported
            , boolean isOlcpOrderOpCodeSupported
            , boolean isOlcpRequestNumberOfObjectsOpCodeSupported
            , boolean isOlcpClearMarkingOpCodeSupported) {
        // @formatter:on
        super(isOacpCreateOpCodeSupported, isOacpDeleteOpCodeSupported, isOacpCalculateOpCodeSupported, isOacpExecuteOpCodeSupported, isOacpReadOpCodeSupported, isOacpWriteOpCodeSupported, isAppendingAdditionalDataToObjectsSupported, isTruncationOfObjectsSupported, isPatchingOfObjectsSupported, isOacpAbortOpCodeSupported, isOlcpGoToOpCodeSupported, isOlcpOrderOpCodeSupported, isOlcpRequestNumberOfObjectsOpCodeSupported, isOlcpClearMarkingOpCodeSupported);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private OtsFeatureAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
        dest.writeByteArray(getBytes());
    }

}
