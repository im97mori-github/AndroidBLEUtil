package org.im97mori.ble.service.rcs.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;

/**
 * Reconnection Configuration Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class ReconnectionConfigurationControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<ReconnectionConfigurationControlPointCharacteristicData> CREATOR = new Creator<ReconnectionConfigurationControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new ReconnectionConfigurationControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationControlPointCharacteristicData[] newArray(int size) {
            return new ReconnectionConfigurationControlPointCharacteristicData[size];
        }

    };

    /**
     * characteristic response codes (Enable Disconnect response)
     */
    @SerializedName("enable_disconnect_result_codes")
    public int enableDisconnectResultCodes;

    /**
     * characteristic response codes (Get Actual Communication Parameters response)
     * {@code 0}:Client Parameter Indication
     */
    @SerializedName("get_actual_communication_parameters_result_codes")
    public int getActualCommunicationParametersResultCodes;

    /**
     * characteristic response codes (Propose Settings response)
     */
    @SerializedName("propose_settings_result_codes")
    public int proposeSettingsResultCodes;

    /**
     * characteristic operand(Propose Settings response)
     */
    @SerializedName("propose_settings_error")
    public int proposeSettingsError;

    /**
     * characteristic response codes (Activate Stored Settings response)
     */
    @SerializedName("activate_stored_settings_result_codes")
    public int activateStoredSettingsResultCodes;

    /**
     * characteristic response codes (Get Max Values response)
     * {@code 0}:Communication Parameter Response
     */
    @SerializedName("get_max_values_result_codes")
    public int getMaxValuesResultCodes;

    /**
     * characteristic operand (Get Max Values response)
     * {@code 0}:Communication Parameter Response
     */
    @SerializedName("max_values")
    public byte[] maxValues;

    /**
     * characteristic response codes (Get Min Values response)
     * {@code 0}:Communication Parameter Response
     */
    @SerializedName("get_min_values_result_codes")
    public int getMinValuesResultCodes;

    /**
     * characteristic operand (Get Min Values response)
     */
    @SerializedName("min_values")
    public byte[] minValues;

    /**
     * characteristic response codes (Get Stored Values response)
     */
    @SerializedName("get_stored_values_result_codes")
    public int getStoredValuesResultCodes;

    /**
     * characteristic operand (Get Stored Values response)
     */
    @SerializedName("get_stored_values_operand")
    public byte[] getStoredValuesOperand;

    /**
     * characteristic response codes (Set White List Timer response)
     */
    @SerializedName("set_white_list_timer_result_codes")
    public int setWhiteListTimerResultCodes;

    /**
     * characteristic response codes (Get White List Timer response)
     * {@code 0}:White List Timer Response
     */
    @SerializedName("get_white_list_timer_result_codes")
    public int getWhiteListTimerResultCodes;

    /**
     * characteristic operand (Get White List Timer response)
     */
    @SerializedName("get_white_list_timer_operand")
    public byte[] getWhiteListTimerOperand;

    /**
     * characteristic response codes (Set Advertisement Configuration response)
     */
    @SerializedName("set_advertisement_configuration_result_codes")
    public int setAdvertisementConfigurationResultCodes;

    /**
     * characteristic response codes (Upgrade to LESC Only response)
     */
    @SerializedName("upgrade_to_lesc_only_result_codes")
    public int upgradeToLescOnlyResultCodes;

    /**
     * characteristic response codes (Switch OOB Pairing response)
     */
    @SerializedName("switch_oob_pairing_result_codes")
    public int switchOobPairingResultCodes;

    /**
     * characteristic response codes (Limited Access response)
     */
    @SerializedName("limited_access_result_codes")
    public int limitedAccessResultCodes;

    /**
     * current setting
     */
    @SerializedName("current_setting")
    public byte[] currentSetting;

    /**
     * crc support flag
     */
    @SerializedName("is_rc_features_e2e_crc_supported")
    public boolean isRcFeaturesE2eCrcSupported;

    /**
     * one shot response data
     */
    public transient byte[] highPriorityResponseData;

    /**
     * @param descriptorDataList                          {@link DescriptorData} list
     * @param responseCode                                response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
     * @param delay                                       response delay(millis)
     * @param enableDisconnectResultCodes                 characteristic response codes (Enable Disconnect response)
     * @param getActualCommunicationParametersResultCodes characteristic response codes (Get Actual Communication Parameters response), {@code 0}:Client Parameter Indication
     * @param proposeSettingsResultCodes                  characteristic response codes (Propose Settings response)
     * @param proposeSettingsError                        characteristic operand (Propose Setting response)
     * @param activateStoredSettingsResultCodes           characteristic response codes (Activate Stored Settings response)
     * @param getMaxValuesResultCodes                     characteristic response codes (Get Max Values response), {@code 0}:Communication Parameter Response
     * @param maxValues                                   characteristic operand (Get Max Values response)
     * @param getMinValuesResultCodes                     characteristic response codes (Get Min Values response), {@code 0}:Communication Parameter Response
     * @param minValues                                   characteristic operand (Get Min Values response)
     * @param getStoredValuesResultCodes                  characteristic response codes (Get Stored Values response), {@code 0}:Communication Parameter Response
     * @param getStoredValuesOperand                      characteristic operand (Get Stored Values response)
     * @param setWhiteListTimerResultCodes                characteristic response codes (Set White List Timer response)
     * @param getWhiteListTimerResultCodes                characteristic response codes (Get White List Timer response)
     * @param getWhiteListTimerOperand                    characteristic operand (Get White List Timer response), {@code 0}:White List Timer Response
     * @param setAdvertisementConfigurationResultCodes    characteristic response codes (Set Advertisement Configuration response)
     * @param upgradeToLescOnlyResultCodes                characteristic response codes (Upgrade to LESC Only response)
     * @param switchOobPairingResultCodes                 characteristic response codes (Switch OOB Pairing response)
     * @param limitedAccessResultCodes                    characteristic response codes (Limited Access response)
     * @param currentSetting                              current setting
     * @param isRcFeaturesE2eCrcSupported                 crc support flag
     */
    public ReconnectionConfigurationControlPointCharacteristicData(@NonNull List<DescriptorData> descriptorDataList
            , int responseCode
            , long delay
            , int enableDisconnectResultCodes
            , int getActualCommunicationParametersResultCodes
            , int proposeSettingsResultCodes
            , int proposeSettingsError
            , int activateStoredSettingsResultCodes
            , int getMaxValuesResultCodes
            , @NonNull byte[] maxValues
            , int getMinValuesResultCodes
            , @NonNull byte[] minValues
            , int getStoredValuesResultCodes
            , @NonNull byte[] getStoredValuesOperand
            , int setWhiteListTimerResultCodes
            , int getWhiteListTimerResultCodes
            , @NonNull byte[] getWhiteListTimerOperand
            , int setAdvertisementConfigurationResultCodes
            , int upgradeToLescOnlyResultCodes
            , int switchOobPairingResultCodes
            , int limitedAccessResultCodes
            , @NonNull byte[] currentSetting
            , boolean isRcFeaturesE2eCrcSupported) {
        super(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE
                , BluetoothGattCharacteristic.PERMISSION_WRITE
                , descriptorDataList
                , responseCode
                , delay
                , null
                , 0);
        this.enableDisconnectResultCodes = enableDisconnectResultCodes;
        this.getActualCommunicationParametersResultCodes = getActualCommunicationParametersResultCodes;
        this.proposeSettingsResultCodes = proposeSettingsResultCodes;
        this.proposeSettingsError = proposeSettingsError;
        this.activateStoredSettingsResultCodes = activateStoredSettingsResultCodes;
        this.getMaxValuesResultCodes = getMaxValuesResultCodes;
        this.maxValues = maxValues;
        this.getMinValuesResultCodes = getMinValuesResultCodes;
        this.minValues = minValues;
        this.getStoredValuesResultCodes = getStoredValuesResultCodes;
        this.getStoredValuesOperand = getStoredValuesOperand;
        this.setWhiteListTimerResultCodes = setWhiteListTimerResultCodes;
        this.getWhiteListTimerResultCodes = getWhiteListTimerResultCodes;
        this.getWhiteListTimerOperand = getWhiteListTimerOperand;
        this.setAdvertisementConfigurationResultCodes = setAdvertisementConfigurationResultCodes;
        this.upgradeToLescOnlyResultCodes = upgradeToLescOnlyResultCodes;
        this.switchOobPairingResultCodes = switchOobPairingResultCodes;
        this.limitedAccessResultCodes = limitedAccessResultCodes;
        this.currentSetting = currentSetting;
        this.isRcFeaturesE2eCrcSupported = isRcFeaturesE2eCrcSupported;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public ReconnectionConfigurationControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        enableDisconnectResultCodes = in.readInt();
        getActualCommunicationParametersResultCodes = in.readInt();
        proposeSettingsResultCodes = in.readInt();
        proposeSettingsError = in.readInt();
        activateStoredSettingsResultCodes = in.readInt();
        getMaxValuesResultCodes = in.readInt();
        maxValues = in.createByteArray();
        getMinValuesResultCodes = in.readInt();
        minValues = in.createByteArray();
        getStoredValuesResultCodes = in.readInt();
        getStoredValuesOperand = in.createByteArray();
        setWhiteListTimerResultCodes = in.readInt();
        getWhiteListTimerOperand = in.createByteArray();
        setAdvertisementConfigurationResultCodes = in.readInt();
        upgradeToLescOnlyResultCodes = in.readInt();
        switchOobPairingResultCodes = in.readInt();
        limitedAccessResultCodes = in.readInt();
        currentSetting = in.createByteArray();
        isRcFeaturesE2eCrcSupported = in.readInt() != 0;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] result = null;
        if (highPriorityResponseData == null) {
            ReconnectionConfigurationControlPoint reconnectionConfigurationControlPoint;
            try {
                if (currentData != null) {
                    reconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPoint(currentData);
                    if (reconnectionConfigurationControlPoint.isOpcodeEnableDisconnect(reconnectionConfigurationControlPoint.getOpcode())) {
                        result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                , new byte[0]
                                , null
                                , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                                , enableDisconnectResultCodes
                                , new byte[0]).getBytes();
                    } else if (reconnectionConfigurationControlPoint.isOpcodeGetActualCommunicationParameters(reconnectionConfigurationControlPoint.getOpcode())) {
                        if (ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED == getActualCommunicationParametersResultCodes
                                || ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED == getActualCommunicationParametersResultCodes) {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                                    , getActualCommunicationParametersResultCodes
                                    , new byte[0]).getBytes();
                        }
                    } else if (reconnectionConfigurationControlPoint.isOpcodeProposeSettings(reconnectionConfigurationControlPoint.getOpcode())) {
                        if (ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE == proposeSettingsResultCodes
                                || ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_PARAMETER_COMBINATION == proposeSettingsResultCodes) {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                                    , proposeSettingsResultCodes
                                    , new byte[]{(byte) proposeSettingsError}).getBytes();
                        } else {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                                    , proposeSettingsResultCodes
                                    , new byte[0]).getBytes();
                        }
                    } else if (reconnectionConfigurationControlPoint.isOpcodeActivateStoredSettings(reconnectionConfigurationControlPoint.getOpcode())) {
                        result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                , new byte[0]
                                , null
                                , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                                , activateStoredSettingsResultCodes
                                , new byte[0]).getBytes();
                    } else if (reconnectionConfigurationControlPoint.isOpcodeGetMaxValues(reconnectionConfigurationControlPoint.getOpcode())) {
                        if (ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED == getMaxValuesResultCodes
                                || ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED == getMaxValuesResultCodes) {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                                    , getMaxValuesResultCodes
                                    , new byte[0]).getBytes();
                        } else {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                                    , getMaxValuesResultCodes
                                    , maxValues).getBytes();
                        }
                    } else if (reconnectionConfigurationControlPoint.isOpcodeGetMinValues(reconnectionConfigurationControlPoint.getOpcode())) {
                        if (ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED == getMinValuesResultCodes
                                || ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED == getMinValuesResultCodes) {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                                    , getMinValuesResultCodes
                                    , new byte[0]).getBytes();
                        } else {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                                    , getMinValuesResultCodes
                                    , minValues).getBytes();
                        }
                    } else if (reconnectionConfigurationControlPoint.isOpcodeGetStoredValues(reconnectionConfigurationControlPoint.getOpcode())) {
                        if (ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED == getStoredValuesResultCodes
                                || ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED == getStoredValuesResultCodes
                                || ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND == getStoredValuesResultCodes) {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                                    , getStoredValuesResultCodes
                                    , new byte[0]).getBytes();
                        } else {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_COMMUNICATION_PARAMETER_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                                    , getStoredValuesResultCodes
                                    , getStoredValuesOperand).getBytes();
                        }
                    } else if (reconnectionConfigurationControlPoint.isOpcodeSetWhiteListTimer(reconnectionConfigurationControlPoint.getOpcode())) {
                        result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                , new byte[0]
                                , null
                                , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                                , setWhiteListTimerResultCodes
                                , new byte[0]).getBytes();
                    } else if (reconnectionConfigurationControlPoint.isOpcodeGetWhiteListTimer(reconnectionConfigurationControlPoint.getOpcode())) {
                        if (ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED == getWhiteListTimerResultCodes
                                || ReconnectionConfigurationControlPoint.RESULT_CODE_OPERATION_FAILED == getWhiteListTimerResultCodes) {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                    , new byte[0]
                                    , null
                                    , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                                    , getWhiteListTimerResultCodes
                                    , new byte[0]).getBytes();
                        } else {
                            result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_WHITE_LIST_TIMER_RESPONSE
                                    , new byte[0]
                                    , null
                                    , 0
                                    , 0
                                    , getWhiteListTimerOperand).getBytes();
                        }
                    } else if (reconnectionConfigurationControlPoint.isOpcodeSetAdvertisementConfiguration(reconnectionConfigurationControlPoint.getOpcode())) {
                        result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                , new byte[0]
                                , null
                                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                                , setAdvertisementConfigurationResultCodes
                                , new byte[0]).getBytes();
                    } else if (reconnectionConfigurationControlPoint.isOpcodeUpgradeToLescOnly(reconnectionConfigurationControlPoint.getOpcode())) {
                        result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                , new byte[0]
                                , null
                                , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                                , upgradeToLescOnlyResultCodes
                                , new byte[0]).getBytes();
                    } else if (reconnectionConfigurationControlPoint.isOpcodeSwitchOobPairing(reconnectionConfigurationControlPoint.getOpcode())) {
                        result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                , new byte[0]
                                , null
                                , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                                , switchOobPairingResultCodes
                                , new byte[0]).getBytes();
                    } else if (reconnectionConfigurationControlPoint.isOpcodeLimitedAccess(reconnectionConfigurationControlPoint.getOpcode())) {
                        result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                                , new byte[0]
                                , null
                                , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                                , limitedAccessResultCodes
                                , new byte[0]).getBytes();
                    }
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }

            if (result == null) {
                result = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                        , new byte[0]
                        , null
                        , 0
                        , 0,
                        currentSetting).getBytes();
            }

            if (isRcFeaturesE2eCrcSupported) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(result.length + 2).order(ByteOrder.LITTLE_ENDIAN);
                byteBuffer.put(result);
                byteBuffer.putShort((short) BLEUtils.createCrc(result, 0, result.length));
                result = byteBuffer.array();
            }
        } else {
            result = highPriorityResponseData;
            highPriorityResponseData = null;
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(enableDisconnectResultCodes);
        dest.writeInt(getActualCommunicationParametersResultCodes);
        dest.writeInt(proposeSettingsResultCodes);
        dest.writeInt(proposeSettingsError);
        dest.writeInt(activateStoredSettingsResultCodes);
        dest.writeInt(getMaxValuesResultCodes);
        dest.writeByteArray(maxValues);
        dest.writeInt(getMinValuesResultCodes);
        dest.writeByteArray(minValues);
        dest.writeInt(getStoredValuesResultCodes);
        dest.writeByteArray(getStoredValuesOperand);
        dest.writeInt(setWhiteListTimerResultCodes);
        dest.writeByteArray(getWhiteListTimerOperand);
        dest.writeInt(setAdvertisementConfigurationResultCodes);
        dest.writeInt(upgradeToLescOnlyResultCodes);
        dest.writeInt(switchOobPairingResultCodes);
        dest.writeInt(limitedAccessResultCodes);
        dest.writeByteArray(currentSetting);
        dest.writeInt(isRcFeaturesE2eCrcSupported ? 1 : 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(enableDisconnectResultCodes).hashCode()
                ^ Integer.valueOf(getActualCommunicationParametersResultCodes).hashCode()
                ^ Integer.valueOf(proposeSettingsResultCodes).hashCode()
                ^ Integer.valueOf(proposeSettingsError).hashCode()
                ^ Integer.valueOf(activateStoredSettingsResultCodes).hashCode()
                ^ Integer.valueOf(getMaxValuesResultCodes).hashCode()
                ^ Arrays.hashCode(maxValues)
                ^ Integer.valueOf(getMinValuesResultCodes).hashCode()
                ^ Arrays.hashCode(minValues)
                ^ Integer.valueOf(getStoredValuesResultCodes).hashCode()
                ^ Arrays.hashCode(getStoredValuesOperand)
                ^ Integer.valueOf(setWhiteListTimerResultCodes).hashCode()
                ^ Integer.valueOf(getWhiteListTimerResultCodes).hashCode()
                ^ Arrays.hashCode(getWhiteListTimerOperand)
                ^ Integer.valueOf(setAdvertisementConfigurationResultCodes).hashCode()
                ^ Integer.valueOf(upgradeToLescOnlyResultCodes).hashCode()
                ^ Integer.valueOf(switchOobPairingResultCodes).hashCode()
                ^ Integer.valueOf(limitedAccessResultCodes).hashCode()
                ^ Arrays.hashCode(currentSetting)
                ^ Boolean.valueOf(isRcFeaturesE2eCrcSupported).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ReconnectionConfigurationControlPointCharacteristicData) {
            ReconnectionConfigurationControlPointCharacteristicData target = (ReconnectionConfigurationControlPointCharacteristicData) obj;
            result = super.equals(obj)
                    && enableDisconnectResultCodes == target.enableDisconnectResultCodes
                    && getActualCommunicationParametersResultCodes == target.getActualCommunicationParametersResultCodes
                    && proposeSettingsResultCodes == target.proposeSettingsResultCodes
                    && proposeSettingsError == target.proposeSettingsError
                    && activateStoredSettingsResultCodes == target.activateStoredSettingsResultCodes
                    && getMaxValuesResultCodes == target.getMaxValuesResultCodes
                    && Arrays.equals(maxValues, target.maxValues)
                    && getMinValuesResultCodes == target.getMinValuesResultCodes
                    && Arrays.equals(minValues, target.minValues)
                    && getStoredValuesResultCodes == target.getStoredValuesResultCodes
                    && Arrays.equals(getStoredValuesOperand, target.getStoredValuesOperand)
                    && setWhiteListTimerResultCodes == target.setWhiteListTimerResultCodes
                    && getWhiteListTimerResultCodes == target.getWhiteListTimerResultCodes
                    && Arrays.equals(getWhiteListTimerOperand, target.getWhiteListTimerOperand)
                    && setAdvertisementConfigurationResultCodes == target.setAdvertisementConfigurationResultCodes
                    && upgradeToLescOnlyResultCodes == target.upgradeToLescOnlyResultCodes
                    && switchOobPairingResultCodes == target.switchOobPairingResultCodes
                    && limitedAccessResultCodes == target.limitedAccessResultCodes
                    && Arrays.equals(currentSetting, target.currentSetting)
                    && isRcFeaturesE2eCrcSupported == target.isRcFeaturesE2eCrcSupported;
        }
        return result;
    }

}
