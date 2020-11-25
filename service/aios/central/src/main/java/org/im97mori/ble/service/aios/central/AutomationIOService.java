package org.im97mori.ble.service.aios.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a56.DigitalAndroid;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.characteristic.u2a58.AnalogAndroid;
import org.im97mori.ble.characteristic.u2a5a.AggregateAndroid;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedProperties;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedPropertiesAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormatAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitalsAndroid;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSettingAndroid;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSettingAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.NUMBER_OF_DIGITALS_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.AUTOMATION_IO_SERVICE;

public class AutomationIOService extends AbstractCentralService {

    /**
     * KEY:WRITE_TYPE
     */
    protected static final String KEY_WRITE_TYPE = "KEY_WRITE_TYPE";

    /**
     * {@link AutomationIOServiceCallback} instance
     */
    private final AutomationIOServiceCallback mAutomationIOServiceCallback;

    /**
     * Digital Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mDigitalList = new LinkedList<>();

    /**
     * Analog Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mAnalogList = new LinkedList<>();

    /**
     * Aggregate characteristic flag
     * {@code true}:Aggregate characteristic is exist, {@code false}:Aggregate characteristic is not exist or service not ready
     */
    private boolean mIsAggregateSupporeted;

    /**
     * Aggregate characteristic readable flag
     * {@code true}:Aggregate characteristic is readable, {@code false}:Aggregate characteristic is not readable or service not ready
     */
    private boolean mIsAggregateReadable;

    /**
     * Aggregate characteristic notificatable flag
     * {@code true}:Aggregate characteristic is notificatable, {@code false}:Aggregate characteristic is not notificatable or service not ready
     */
    private boolean mIsAggregateNotificatable;

    /**
     * Aggregate characteristic indicatable flag
     * {@code true}:Aggregate characteristic is indicatable, {@code false}:Aggregate characteristic is not indicatable or service not ready
     */
    private boolean mIsAggregateIndicatable;

    /**
     * @param bleConnection {@link BLEConnection} instance{@link BLEConnection} instance
     * @param bleCallback   {@link BLECallback} instance(optional)
     */
    public AutomationIOService(@NonNull BLEConnection bleConnection, @NonNull AutomationIOServiceCallback automationIOServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mAutomationIOServiceCallback = automationIOServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mDigitalList.clear();
            mAnalogList.clear();
            mIsAggregateSupporeted = false;
            mIsAggregateReadable = false;
            mIsAggregateNotificatable = false;
            mIsAggregateIndicatable = false;
        }
        super.onBLEDisconnected(taskId, bluetoothDevice, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (AUTOMATION_IO_SERVICE.equals(bluetoothGattService.getUuid())) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        if (DIGITAL_CHARACTERISTIC.equals(bluetoothGattCharacteristic.getUuid())) {
                            mDigitalList.add(bluetoothGattCharacteristic);
                        } else if (ANALOG_CHARACTERISTIC.equals(bluetoothGattCharacteristic.getUuid())) {
                            mAnalogList.add(bluetoothGattCharacteristic);
                        } else if (AGGREGATE_CHARACTERISTIC.equals(bluetoothGattCharacteristic.getUuid())) {
                            mIsAggregateSupporeted = true;
                            if ((bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_READ) == BluetoothGattCharacteristic.PROPERTY_READ) {
                                mIsAggregateReadable = true;
                            }
                            if (isAggregateReadable() && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                                if ((bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) == BluetoothGattCharacteristic.PROPERTY_NOTIFY) {
                                    mIsAggregateNotificatable = true;
                                } else if ((bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_INDICATE) == BluetoothGattCharacteristic.PROPERTY_INDICATE) {
                                    mIsAggregateIndicatable = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * get characteristic index
     *
     * @param characteristicList       {@link #mDigitalList} or {@link #mAnalogList}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @return characteristic index
     */
    @Nullable
    private Integer getCharacteristicIndex(@NonNull List<BluetoothGattCharacteristic> characteristicList, @Nullable Integer characteristicInstanceId) {
        Integer index = null;
        if (!characteristicList.isEmpty()) {
            if (characteristicInstanceId == null) {
                index = 1;
            } else {
                for (int i = 0; i < characteristicList.size(); i++) {
                    if (characteristicList.get(i).getInstanceId() == characteristicInstanceId) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onDigitalReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), DigitalAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onAnalogReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), AnalogAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onAggregateReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AggregateAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onDigitalReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), status, argument);
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onAnalogReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), status, argument);
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onAggregateReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onDigitalReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), timeout, argument);
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onAnalogReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), timeout, argument);
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mAutomationIOServiceCallback.onAggregateReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID) && argument != null && argument.containsKey(KEY_WRITE_TYPE)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onDigitalWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), DigitalAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onDigitalWriteWithNoResponseSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), DigitalAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onAnalogWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), AnalogAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onAnalogWriteWithNoResponseSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), AnalogAndroid.CREATOR.createFromByteArray(values), argument);
                }
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID) && argument != null && argument.containsKey(KEY_WRITE_TYPE)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onDigitalWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), status, argument);
                } else if (BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onDigitalWriteWithNoResponseFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), status, argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onAnalogWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), status, argument);
                } else if (BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onAnalogWriteWithNoResponseFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), status, argument);
                }
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID) && argument != null && argument.containsKey(KEY_WRITE_TYPE)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onDigitalWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), timeout, argument);
                } else if (BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onDigitalWriteWithNoResponseTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDigitalList, characteristicInstanceId), timeout, argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onAnalogWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), timeout, argument);
                } else if (BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE == argument.getInt(KEY_WRITE_TYPE)) {
                    mAutomationIOServiceCallback.onAnalogWriteWithNoResponseTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mAnalogList, characteristicInstanceId), timeout, argument);
                }
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDigitalList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicPresentationFormatReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicPresentationFormatAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicExtendedPropertiesReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicExtendedPropertiesAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalValueTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, ValueTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalTimeTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, TimeTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (NUMBER_OF_DIGITALS_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalNumberOfDigitalsReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, NumberOfDigitalsAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mAnalogList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicPresentationFormatReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicPresentationFormatAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicExtendedPropertiesReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicExtendedPropertiesAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValueTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, ValueTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogTimeTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, TimeTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAggregateClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                }
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDigitalList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicPresentationFormatReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicExtendedPropertiesReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalValueTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalTimeTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (NUMBER_OF_DIGITALS_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalNumberOfDigitalsReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mAnalogList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicPresentationFormatReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicExtendedPropertiesReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValueTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogTimeTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                }
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAggregateClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDigitalList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicPresentationFormatReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicExtendedPropertiesReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalValueTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalTimeTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (NUMBER_OF_DIGITALS_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalNumberOfDigitalsReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mAnalogList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicPresentationFormatReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicExtendedPropertiesReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValueTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogTimeTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                }
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAggregateClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDigitalList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (characteristicIndex != null) {
                        if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                            if (isDigitalNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            } else if (isDigitalIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            }
                        } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                            if (isDigitalNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            } else if (isDigitalIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            }
                        }
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalValueTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, ValueTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalTimeTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, TimeTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mAnalogList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (characteristicIndex != null) {
                        if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                            if (isAnalogNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            } else if (isAnalogIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            }
                        } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                            if (isAnalogNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            } else if (isAnalogIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, argument);
                            }
                        }
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValueTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, ValueTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogTimeTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, TimeTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                        if (isAggregateNotificatable()) {
                            mAutomationIOServiceCallback.onAggregateNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                        } else if (isAggregateIndicatable()) {
                            mAutomationIOServiceCallback.onAggregateIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                        }
                    } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                        if (isAggregateNotificatable()) {
                            mAutomationIOServiceCallback.onAggregateNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                        } else if (isAggregateIndicatable()) {
                            mAutomationIOServiceCallback.onAggregateIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                        }
                    }
                }
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDigitalList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (characteristicIndex != null) {
                        if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                            if (isDigitalNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            } else if (isDigitalIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            }
                        } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                            if (isDigitalNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            } else if (isDigitalIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            }
                        }
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalValueTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalTimeTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mAnalogList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (characteristicIndex != null) {
                        if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                            if (isAnalogNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            } else if (isAnalogIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            }
                        } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                            if (isAnalogNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            } else if (isAnalogIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                            }
                        }
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValueTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogTimeTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, status, argument);
                }
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                        if (isAggregateNotificatable()) {
                            mAutomationIOServiceCallback.onAggregateNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                        } else if (isAggregateIndicatable()) {
                            mAutomationIOServiceCallback.onAggregateIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                        }
                    } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                        if (isAggregateNotificatable()) {
                            mAutomationIOServiceCallback.onAggregateNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                        } else if (isAggregateIndicatable()) {
                            mAutomationIOServiceCallback.onAggregateIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                        }
                    }
                }
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDigitalList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (characteristicIndex != null) {
                        if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                            if (isDigitalNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            } else if (isDigitalIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            }
                        } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                            if (isDigitalNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            } else if (isDigitalIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onDigitalIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            }
                        }
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalValueTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onDigitalTimeTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mAnalogList, characteristicInstanceId);
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (characteristicIndex != null) {
                        if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                            if (isAnalogNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            } else if (isAnalogIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            }
                        } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                            if (isAnalogNotificatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            } else if (isAnalogIndicatable(characteristicIndex)) {
                                mAutomationIOServiceCallback.onAnalogIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                            }
                        }
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogValueTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                } else if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mAutomationIOServiceCallback.onAnalogTimeTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, timeout, argument);
                }
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                        if (isAggregateNotificatable()) {
                            mAutomationIOServiceCallback.onAggregateNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                        } else if (isAggregateIndicatable()) {
                            mAutomationIOServiceCallback.onAggregateIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                        }
                    } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                        if (isAggregateNotificatable()) {
                            mAutomationIOServiceCallback.onAggregateNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                        } else if (isAggregateIndicatable()) {
                            mAutomationIOServiceCallback.onAggregateIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                        }
                    }
                }
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && AUTOMATION_IO_SERVICE.equals(serviceUUID)) {
            if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDigitalList, characteristicInstanceId);
                if (characteristicIndex != null) {
                    if (isDigitalNotificatable(characteristicIndex)) {
                        mAutomationIOServiceCallback.onDigitalNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, DigitalAndroid.CREATOR.createFromByteArray(values));
                    } else if (isDigitalIndicatable(characteristicIndex)) {
                        mAutomationIOServiceCallback.onDigitalIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, DigitalAndroid.CREATOR.createFromByteArray(values));
                    }
                }
            } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mAnalogList, characteristicInstanceId);
                if (characteristicIndex != null) {
                    if (isAnalogNotificatable(characteristicIndex)) {
                        mAutomationIOServiceCallback.onAnalogNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, AnalogAndroid.CREATOR.createFromByteArray(values));
                    } else if (isAnalogIndicatable(characteristicIndex)) {
                        mAutomationIOServiceCallback.onAnalogIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, AnalogAndroid.CREATOR.createFromByteArray(values));
                    }
                }
            } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (isAggregateNotificatable()) {
                    mAutomationIOServiceCallback.onAggregateNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AggregateAndroid.CREATOR.createFromByteArray(values));
                } else if (isAggregateIndicatable()) {
                    mAutomationIOServiceCallback.onAggregateIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AggregateAndroid.CREATOR.createFromByteArray(values));
                }
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * get Digital Characteristic count
     *
     * @return available Digital Characteristic count. if {@code null} returned, service is not ready
     */
    public synchronized Integer getDigitalCount() {
        Integer count = null;
        if (isStarted()) {
            count = mDigitalList.size();
        }
        return count;
    }

    /**
     * check characteristic properties
     *
     * @param characteristicList {@link #mDigitalList} or {@link #mAnalogList}
     * @param property           property (ex {@link BluetoothGattCharacteristic#PROPERTY_READ})
     * @param index              characteristic index
     * @return {@code true}:target characteristic has specific properties, {@code false}:target characteristic does not have specific properties
     */
    private synchronized boolean isCharacteristicPropertyEnabled(@NonNull List<BluetoothGattCharacteristic> characteristicList, int property, int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < characteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & property) == property;
        }
        return result;
    }

    /**
     * @see #isDigitalReadable(int)
     */
    public synchronized boolean isDigitalReadable() {
        return isDigitalReadable(0);
    }

    /**
     * get Digital's readable status
     *
     * @param index Digital Characteristic index
     * @return {@code true}:target Digital Characteristic is readable, {@code false}:not readable
     */
    public synchronized boolean isDigitalReadable(int index) {
        return isCharacteristicPropertyEnabled(mDigitalList, BluetoothGattCharacteristic.PROPERTY_READ, index);
    }

    /**
     * @see #isDigitalWritable(int)
     */
    public synchronized boolean isDigitalWritable() {
        return isDigitalWritable(0);
    }

    /**
     * get Digital's writable status
     *
     * @param index Digital Characteristic index
     * @return {@code true}:target Digital Characteristic is writable, {@code false}:not writable
     */
    public synchronized boolean isDigitalWritable(int index) {
        return isCharacteristicPropertyEnabled(mDigitalList, BluetoothGattCharacteristic.PROPERTY_WRITE, index);
    }

    /**
     * @see #isDigitalWritableWithNoResponse(int)
     */
    public synchronized boolean isDigitalWritableWithNoResponse() {
        return isDigitalWritableWithNoResponse(0);
    }

    /**
     * get Digital's writable with no response status
     *
     * @param index Digital Characteristic index
     * @return {@code true}:target Digital Characteristic is writable with no response, {@code false}:not writable with no response
     */
    public synchronized boolean isDigitalWritableWithNoResponse(int index) {
        return isCharacteristicPropertyEnabled(mDigitalList, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, index);
    }

    /**
     * @see #isDigitalNotificatable(int)
     */
    public synchronized boolean isDigitalNotificatable() {
        return isDigitalNotificatable(0);
    }

    /**
     * get Digital's notificatable status
     *
     * @param index Digital Characteristic index
     * @return {@code true}:target Digital Characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isDigitalNotificatable(int index) {
        return isCharacteristicPropertyEnabled(mDigitalList, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, index);
    }

    /**
     * @see #isDigitalIndicatable(int)
     */
    public synchronized boolean isDigitalIndicatable() {
        return isDigitalIndicatable(0);
    }

    /**
     * get Digital's indicatable status
     *
     * @param index Digital Characteristic index
     * @return {@code true}:target Digital Characteristic is indicatable, {@code false}:not indicatable
     */
    public synchronized boolean isDigitalIndicatable(int index) {
        return isCharacteristicPropertyEnabled(mDigitalList, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, index);
    }

    /**
     * get Descriptor
     *
     * @param characteristicList {@link #mDigitalList} or {@link #mAnalogList}
     * @param descriptorUUID     descriptor's {@link UUID}
     * @param index              characteristic index
     * @return target characteristic's {@link BluetoothGattDescriptor} instance or {@code null} when target characteristic do not have specific descriptor
     */
    @Nullable
    private synchronized BluetoothGattDescriptor getDescriptor(@NonNull List<BluetoothGattCharacteristic> characteristicList, @NonNull UUID descriptorUUID, int index) {
        BluetoothGattDescriptor bluetoothGattDescriptor = null;
        if (isStarted() && index >= 0 && index < characteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristicList.get(index);
            bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(descriptorUUID);
        }
        return bluetoothGattDescriptor;
    }

    /**
     * @see #hasDigitalCharacteristicPresentationFormat(int)
     */
    public synchronized boolean hasDigitalCharacteristicPresentationFormat() {
        return hasDigitalCharacteristicPresentationFormat(0);
    }

    /**
     * check Digital's Characteristic Presentation Format
     *
     * @param index Digital's index
     * @return {@code true}:target Digital Characteristic has Characteristic Presentation Format Descriptor, {@code false}:target Digital Characteristic does not have Characteristic Presentation Format Descriptor
     */
    public synchronized boolean hasDigitalCharacteristicPresentationFormat(int index) {
        return getDescriptor(mDigitalList, CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #hasDigitalCharacteristicUserDescription(int)
     */
    public synchronized boolean hasDigitalCharacteristicUserDescription() {
        return hasDigitalCharacteristicUserDescription(0);
    }

    /**
     * check Digital's Characteristic User Description
     *
     * @param index Digital's index
     * @return {@code true}:target Digital Characteristic has Characteristic User Description Descriptor, {@code false}:target Digital Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
        return getDescriptor(mDigitalList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
    }

    /**
     * @see #isDigitalCharacteristicUserDescriptionWritable(int)
     */
    public synchronized boolean isDigitalCharacteristicUserDescriptionWritable() {
        return isDigitalCharacteristicUserDescriptionWritable(0);
    }

    /**
     * check Digital's Characteristic User Description writable status
     *
     * @param index Digital's index
     * @return {@code true}:target Digital Characteristic's Characteristic User Description Descriptor is writable, {@code false}:not writable or Characteristic Extended Properties value not stored
     */
    public synchronized boolean isDigitalCharacteristicUserDescriptionWritable(int index) {
        boolean result = false;
        if (hasDigitalCharacteristicUserDescription(index)) {
            BluetoothGattDescriptor bluetoothGattDescriptor = getDescriptor(mDigitalList, CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, index);
            if (bluetoothGattDescriptor != null) {
                byte[] value = bluetoothGattDescriptor.getValue();
                if (value != null && new CharacteristicExtendedProperties(value).isPropertiesWritableAuxiliariesEnabled()) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * @see #hasDigitalCharacteristicExtendedProperties(int)
     */
    public synchronized boolean hasDigitalCharacteristicExtendedProperties() {
        return hasDigitalCharacteristicExtendedProperties(0);
    }

    /**
     * check Digital's Characteristic Extended Properties
     *
     * @param index Digital's index
     * @return {@code true}:target Digital Characteristic has Characteristic Extended Properties Descriptor, {@code false}:target Digital Characteristic does not have Characteristic Extended Properties Descriptor
     */
    public synchronized boolean hasDigitalCharacteristicExtendedProperties(int index) {
        return getDescriptor(mDigitalList, CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, index) != null;
    }

    /**
     * @see #hasDigitalValueTriggerSetting(int)
     */
    public synchronized boolean hasDigitalValueTriggerSetting() {
        return hasDigitalValueTriggerSetting(0);
    }

    /**
     * check Digital's Value Trigger Setting
     *
     * @param index Digital's index
     * @return {@code true}:target Digital Characteristic has Value Trigger Setting Descriptor, {@code false}:target Digital Characteristic does not have Value Trigger Setting Descriptor
     */
    public synchronized boolean hasDigitalValueTriggerSetting(int index) {
        return (isDigitalNotificatable(index) || isDigitalIndicatable(index)) && getDescriptor(mDigitalList, VALUE_TRIGGER_SETTING_DESCRIPTOR, index) != null;
    }

    /**
     * @see #hasDigitalTimeTriggerSetting(int)
     */
    public synchronized boolean hasDigitalTimeTriggerSetting() {
        return hasDigitalTimeTriggerSetting(0);
    }

    /**
     * check Digital's Time Trigger Setting
     *
     * @param index Digital's index
     * @return {@code true}:target Digital Characteristic has Time Trigger Setting Descriptor, {@code false}:target Digital Characteristic does not have Time Trigger Setting Descriptor
     */
    public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
        return hasDigitalValueTriggerSetting(index) && getDescriptor(mDigitalList, TIME_TRIGGER_SETTING_DESCRIPTOR, index) != null;
    }

    /**
     * get Analog Characteristic count
     *
     * @return available Analog Characteristic count. if {@code null} returned, service is not ready
     */
    public synchronized Integer getAnalogCount() {
        Integer count = null;
        if (isStarted()) {
            count = mAnalogList.size();
        }
        return count;
    }

    /**
     * @see #isAnalogReadable(int)
     */
    public synchronized boolean isAnalogReadable() {
        return isAnalogReadable(0);
    }

    /**
     * get Analog's readable status
     *
     * @param index Analog Characteristic index
     * @return {@code true}:target Analog Characteristic is readable, {@code false}:not readable
     */
    public synchronized boolean isAnalogReadable(int index) {
        return isCharacteristicPropertyEnabled(mAnalogList, BluetoothGattCharacteristic.PROPERTY_READ, index);
    }

    /**
     * @see #isAnalogWritable(int)
     */
    public synchronized boolean isAnalogWritable() {
        return isAnalogWritable(0);
    }

    /**
     * get Analog's writable status
     *
     * @param index Analog Characteristic index
     * @return {@code true}:target Analog Characteristic is writable, {@code false}:not writable
     */
    public synchronized boolean isAnalogWritable(int index) {
        return isCharacteristicPropertyEnabled(mAnalogList, BluetoothGattCharacteristic.PROPERTY_WRITE, index);
    }

    /**
     * @see #isAnalogWritableWithNoResponse(int)
     */
    public synchronized boolean isAnalogWritableWithNoResponse() {
        return isAnalogWritableWithNoResponse(0);
    }

    /**
     * get Analog's writable with no response status
     *
     * @param index Analog Characteristic index
     * @return {@code true}:target Analog Characteristic is writable with no response, {@code false}:not writable with no response
     */
    public synchronized boolean isAnalogWritableWithNoResponse(int index) {
        return isCharacteristicPropertyEnabled(mAnalogList, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, index);
    }

    /**
     * @see #isAnalogNotificatable(int)
     */
    public synchronized boolean isAnalogNotificatable() {
        return isAnalogNotificatable(0);
    }

    /**
     * get Analog's notificatable status
     *
     * @param index Analog Characteristic index
     * @return {@code true}:target Analog Characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isAnalogNotificatable(int index) {
        return isCharacteristicPropertyEnabled(mAnalogList, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, index);
    }

    /**
     * @see #isAnalogIndicatable(int)
     */
    public synchronized boolean isAnalogIndicatable() {
        return isAnalogIndicatable(0);
    }

    /**
     * get Analog's indicatable status
     *
     * @param index Analog Characteristic index
     * @return {@code true}:target Analog Characteristic is indicatable, {@code false}:not indicatable
     */
    public synchronized boolean isAnalogIndicatable(int index) {
        return isCharacteristicPropertyEnabled(mAnalogList, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, index);
    }

    /**
     * @see #hasAnalogCharacteristicPresentationFormat(int)
     */
    public synchronized boolean hasAnalogCharacteristicPresentationFormat() {
        return hasAnalogCharacteristicPresentationFormat(0);
    }

    /**
     * check Analog's Characteristic Presentation Format
     *
     * @param index Analog's index
     * @return {@code true}:target Analog Characteristic has Characteristic Presentation Format Descriptor, {@code false}:target Analog Characteristic does not have Characteristic Presentation Format Descriptor
     */
    public synchronized boolean hasAnalogCharacteristicPresentationFormat(int index) {
        return getDescriptor(mAnalogList, CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #hasAnalogCharacteristicUserDescription(int)
     */
    public synchronized boolean hasAnalogCharacteristicUserDescription() {
        return hasAnalogCharacteristicUserDescription(0);
    }

    /**
     * check Analog's Characteristic User Description
     *
     * @param index Analog's index
     * @return {@code true}:target Analog Characteristic has Characteristic User Description Descriptor, {@code false}:target Analog Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
        return getDescriptor(mAnalogList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
    }

    /**
     * @see #isAnalogCharacteristicUserDescriptionWritable(int)
     */
    public synchronized boolean isAnalogCharacteristicUserDescriptionWritable() {
        return isAnalogCharacteristicUserDescriptionWritable(0);
    }

    /**
     * check Analog's Characteristic User Description writable status
     *
     * @param index Analog's index
     * @return {@code true}:target Analog Characteristic's Characteristic User Description Descriptor is writable, {@code false}:not writable
     */
    public synchronized boolean isAnalogCharacteristicUserDescriptionWritable(int index) {
        boolean result = false;
        if (hasAnalogCharacteristicUserDescription(index)) {
            BluetoothGattDescriptor bluetoothGattDescriptor = getDescriptor(mAnalogList, CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, index);
            if (bluetoothGattDescriptor != null) {
                byte[] value = bluetoothGattDescriptor.getValue();
                if (value != null && new CharacteristicExtendedProperties(value).isPropertiesWritableAuxiliariesEnabled()) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * @see #hasAnalogCharacteristicExtendedProperties(int)
     */
    public synchronized boolean hasAnalogCharacteristicExtendedProperties() {
        return hasAnalogCharacteristicExtendedProperties(0);
    }

    /**
     * check Analog's Characteristic Extended Properties
     *
     * @param index Analog's index
     * @return {@code true}:target Analog Characteristic has Characteristic Extended Properties Descriptor, {@code false}:target Analog Characteristic does not have Characteristic Extended Properties Descriptor
     */
    public synchronized boolean hasAnalogCharacteristicExtendedProperties(int index) {
        return getDescriptor(mAnalogList, CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, index) != null;
    }

    /**
     * @see #hasAnalogValueTriggerSetting(int)
     */
    public synchronized boolean hasAnalogValueTriggerSetting() {
        return hasAnalogValueTriggerSetting(0);
    }

    /**
     * check Analog's Value Trigger Setting
     *
     * @param index Analog's index
     * @return {@code true}:target Analog Characteristic has Value Trigger Setting Descriptor, {@code false}:target Analog Characteristic does not have Value Trigger Setting Descriptor
     */
    public synchronized boolean hasAnalogValueTriggerSetting(int index) {
        return (isAnalogNotificatable(index) || isAnalogIndicatable(index)) && getDescriptor(mAnalogList, VALUE_TRIGGER_SETTING_DESCRIPTOR, index) != null;
    }

    /**
     * @see #hasAnalogTimeTriggerSetting(int)
     */
    public synchronized boolean hasAnalogTimeTriggerSetting() {
        return hasAnalogTimeTriggerSetting(0);
    }

    /**
     * check Analog's Time Trigger Setting
     *
     * @param index Analog's index
     * @return {@code true}:target Analog Characteristic has Time Trigger Setting Descriptor, {@code false}:target Analog Characteristic does not have Time Trigger Setting Descriptor
     */
    public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
        return hasAnalogValueTriggerSetting(index) && getDescriptor(mAnalogList, TIME_TRIGGER_SETTING_DESCRIPTOR, index) != null;
    }

    /**
     * check Aggregate characteristic
     *
     * @return {@code true}:Aggregate characteristic is exist, {@code false}:Aggregate characteristic is not exist or service not ready
     */
    public synchronized boolean isAggregateSupporeted() {
        return mIsAggregateSupporeted;
    }

    /**
     * get Aggregate's readable status
     *
     * @return {@code true}:Aggregate characteristic is readable, {@code false}:Aggregate characteristic is not readable or service not ready
     */
    public synchronized boolean isAggregateReadable() {
        return mIsAggregateReadable;
    }

    /**
     * get Aggregate's notificatable status
     *
     * @return {@code true}:Aggregate characteristic is notificatable, {@code false}:Aggregate characteristic is not notificatable or service not ready
     */
    public synchronized boolean isAggregateNotificatable() {
        return mIsAggregateNotificatable;
    }

    /**
     * get Aggregate's indicatable status
     *
     * @return {@code true}:Aggregate characteristic is indicatable, {@code false}:Aggregate characteristic is not indicatable or service not ready
     */
    public synchronized boolean isAggregateIndicatable() {
        return mIsAggregateIndicatable;
    }

    /**
     * @see #getDigital(int)
     */
    @Nullable
    public synchronized Integer getDigital() {
        return getDigital(0);
    }

    /**
     * get Digital
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, DigitalAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigital(int index) {
        Integer taskId = null;
        if (isStarted() && isDigitalReadable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadCharacteristicTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #setDigital(int, Digital)
     */
    @Nullable
    public synchronized Integer setDigital(@NonNull Digital digital) {
        return setDigital(0, digital);
    }

    /**
     * set Digital
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, DigitalAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDigital(int index, @NonNull Digital digital) {
        Integer taskId = null;
        if (isStarted() && isDigitalWritable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            Bundle bundle = new Bundle();
            int writeType = BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT;
            bundle.putInt(KEY_WRITE_TYPE, writeType);
            taskId = mBLEConnection.createWriteCharacteristicTask(AUTOMATION_IO_SERVICE
                    , bluetoothGattCharacteristic.getService().getInstanceId()
                    , DIGITAL_CHARACTERISTIC
                    , bluetoothGattCharacteristic.getInstanceId()
                    , digital
                    , writeType
                    , WriteCharacteristicTask.TIMEOUT_MILLIS
                    , bundle
                    , this);
        }
        return taskId;
    }

    /**
     * @see #setDigitalWithNoResponse(int, Digital)
     */
    @Nullable
    public synchronized Integer setDigitalWithNoResponse(@NonNull Digital digital) {
        return setDigitalWithNoResponse(0, digital);
    }

    /**
     * set Digital with no response
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalWriteWithNoResponseSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, DigitalAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalWriteWithNoResponseFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalWriteWithNoResponseTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDigitalWithNoResponse(int index, @NonNull Digital digital) {
        Integer taskId = null;
        if (isStarted() && isDigitalWritableWithNoResponse(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            Bundle bundle = new Bundle();
            int writeType = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE;
            bundle.putInt(KEY_WRITE_TYPE, writeType);
            taskId = mBLEConnection.createWriteCharacteristicTask(AUTOMATION_IO_SERVICE
                    , bluetoothGattCharacteristic.getService().getInstanceId()
                    , DIGITAL_CHARACTERISTIC
                    , bluetoothGattCharacteristic.getInstanceId()
                    , digital
                    , writeType
                    , WriteCharacteristicTask.TIMEOUT_MILLIS
                    , bundle
                    , this);
        }
        return taskId;
    }

    /**
     * @see #getDigitalClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getDigitalClientCharacteristicConfiguration() {
        return getDigitalClientCharacteristicConfiguration(0);
    }

    /**
     * get Digital's Client Characteristic Configuration
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigitalClientCharacteristicConfiguration(int index) {
        Integer taskId = null;
        if (isStarted() && (isDigitalNotificatable(index) || isDigitalIndicatable(index))) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #startDigitalNotification(int)
     */
    @Nullable
    public synchronized Integer startDigitalNotification() {
        return startDigitalNotification(0);
    }

    /**
     * start Digital's notification
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onDigitalNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startDigitalNotification(int index) {
        Integer taskId = null;
        if (isStarted() && isDigitalNotificatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #stopDigitalNotification(int)
     */
    @Nullable
    public synchronized Integer stopDigitalNotification() {
        return stopDigitalNotification(0);
    }

    /**
     * stop Digital's notification
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onDigitalNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopDigitalNotification(int index) {
        Integer taskId = null;
        if (isStarted() && isDigitalNotificatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #startDigitalIndication(int)
     */
    @Nullable
    public synchronized Integer startDigitalIndication() {
        return startDigitalIndication(0);
    }

    /**
     * start Digital's indication
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onDigitalIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startDigitalIndication(int index) {
        Integer taskId = null;
        if (isStarted() && isDigitalIndicatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #stopDigitalIndication(int)
     */
    @Nullable
    public synchronized Integer stopDigitalIndication() {
        return stopDigitalIndication(0);
    }

    /**
     * stop Digital's indication
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onDigitalIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopDigitalIndication(int index) {
        Integer taskId = null;
        if (isStarted() && isDigitalIndicatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #getDigitalCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicPresentationFormat() {
        return getDigitalCharacteristicPresentationFormat(0);
    }

    /**
     * get Digital's Characteristic Presentation Format
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalCharacteristicPresentationFormatReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicPresentationFormatAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicPresentationFormatReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicPresentationFormatReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicPresentationFormat(int index) {
        Integer taskId = null;
        if (isStarted() && hasDigitalCharacteristicPresentationFormat(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getDigitalCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicUserDescription() {
        return getDigitalCharacteristicUserDescription(0);
    }

    /**
     * get Digital's Characteristic User Description
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (isStarted() && hasDigitalCharacteristicUserDescription(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #setDigitalCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setDigitalCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setDigitalCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Digital's Characteristic User Description
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDigitalCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (isStarted() && isDigitalCharacteristicUserDescriptionWritable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, characteristicUserDescription, WriteDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getDigitalCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicExtendedProperties() {
        return getDigitalCharacteristicExtendedProperties(0);
    }

    /**
     * get Digital's Characteristic Extended Properties
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalCharacteristicExtendedPropertiesReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicExtendedPropertiesAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicExtendedPropertiesReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalCharacteristicExtendedPropertiesReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicExtendedProperties(int index) {
        Integer taskId = null;
        if (isStarted() && hasDigitalCharacteristicExtendedProperties(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getDigitalValueTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getDigitalValueTriggerSetting() {
        return getDigitalValueTriggerSetting(0);
    }

    /**
     * get Digital's Value Trigger Setting
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalValueTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ValueTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalValueTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalValueTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigitalValueTriggerSetting(int index) {
        Integer taskId = null;
        if (isStarted() && hasDigitalValueTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), VALUE_TRIGGER_SETTING_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #setDigitalValueTriggerSetting(int, ValueTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDigitalValueTriggerSetting(@NonNull ValueTriggerSetting valueTriggerSetting) {
        return setDigitalValueTriggerSetting(0, valueTriggerSetting);
    }

    /**
     * set Digital's Value Trigger Setting
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalValueTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ValueTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalValueTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalValueTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDigitalValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
        Integer taskId = null;
        if (isStarted() && hasDigitalValueTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), VALUE_TRIGGER_SETTING_DESCRIPTOR, valueTriggerSetting, WriteDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getDigitalTimeTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getDigitalTimeTriggerSetting() {
        return getDigitalTimeTriggerSetting(0);
    }

    /**
     * get Digital's Time Trigger Setting
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalTimeTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, TimeTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalTimeTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalTimeTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigitalTimeTriggerSetting(int index) {
        Integer taskId = null;
        if (isStarted() && hasDigitalTimeTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), TIME_TRIGGER_SETTING_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #setDigitalTimeTriggerSetting(int, TimeTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDigitalTimeTriggerSetting(@NonNull TimeTriggerSetting timeTriggerSetting) {
        return setDigitalTimeTriggerSetting(0, timeTriggerSetting);
    }

    /**
     * set Digital's Time Trigger Setting
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalTimeTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, TimeTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalTimeTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalTimeTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDigitalTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
        Integer taskId = null;
        if (isStarted() && hasDigitalTimeTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), TIME_TRIGGER_SETTING_DESCRIPTOR, timeTriggerSetting, WriteDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getDigitalNumberOfDigitals(int)
     */
    @Nullable
    public synchronized Integer getDigitalNumberOfDigitals() {
        return getDigitalNumberOfDigitals(0);
    }

    /**
     * get Digital's Number of Digitals
     *
     * @param index Digital Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onDigitalNumberOfDigitalsReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, NumberOfDigitalsAndroid, Bundle)
     * @see AutomationIOServiceCallback#onDigitalNumberOfDigitalsReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onDigitalNumberOfDigitalsReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDigitalNumberOfDigitals(int index) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < mDigitalList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDigitalList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), DIGITAL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), NUMBER_OF_DIGITALS_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getAnalog(int)
     */
    @Nullable
    public synchronized Integer getAnalog() {
        return getAnalog(0);
    }

    /**
     * get Analog
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, AnalogAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalog(int index) {
        Integer taskId = null;
        if (isStarted() && isAnalogReadable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadCharacteristicTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);

        }
        return taskId;
    }

    /**
     * @see #setAnalog(int, Analog)
     */
    @Nullable
    public synchronized Integer setAnalog(@NonNull Analog analog) {
        return setAnalog(0, analog);
    }

    /**
     * set Analog
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, AnalogAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnalog(int index, @NonNull Analog analog) {
        Integer taskId = null;
        if (isStarted() && isAnalogWritable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            Bundle bundle = new Bundle();
            int writeType = BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT;
            bundle.putInt(KEY_WRITE_TYPE, writeType);
            taskId = mBLEConnection.createWriteCharacteristicTask(AUTOMATION_IO_SERVICE
                    , bluetoothGattCharacteristic.getService().getInstanceId()
                    , ANALOG_CHARACTERISTIC
                    , bluetoothGattCharacteristic.getInstanceId()
                    , analog
                    , writeType
                    , WriteCharacteristicTask.TIMEOUT_MILLIS
                    , bundle
                    , this);
        }
        return taskId;
    }

    /**
     * @see #setAnalogWithNoResponse(int, Analog)
     */
    @Nullable
    public synchronized Integer setAnalogWithNoResponse(@NonNull Analog analog) {
        return setAnalogWithNoResponse(0, analog);
    }

    /**
     * set Analog with no response
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogWriteWithNoResponseSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, AnalogAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogWriteWithNoResponseFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogWriteWithNoResponseTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnalogWithNoResponse(int index, @NonNull Analog analog) {
        Integer taskId = null;
        if (isStarted() && isAnalogWritableWithNoResponse(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            Bundle bundle = new Bundle();
            int writeType = BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE;
            bundle.putInt(KEY_WRITE_TYPE, writeType);
            taskId = mBLEConnection.createWriteCharacteristicTask(AUTOMATION_IO_SERVICE
                    , bluetoothGattCharacteristic.getService().getInstanceId()
                    , ANALOG_CHARACTERISTIC
                    , bluetoothGattCharacteristic.getInstanceId()
                    , analog
                    , writeType
                    , WriteCharacteristicTask.TIMEOUT_MILLIS
                    , bundle
                    , this);
        }
        return taskId;
    }

    /**
     * @see #getAnalogClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getAnalogClientCharacteristicConfiguration() {
        return getAnalogClientCharacteristicConfiguration(0);
    }

    /**
     * get Analog's Client Characteristic Configuration
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalogClientCharacteristicConfiguration(int index) {
        Integer taskId = null;
        if (isStarted() && (isAnalogNotificatable(index) || isAnalogIndicatable(index))) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #startAnalogNotification(int)
     */
    @Nullable
    public synchronized Integer startAnalogNotification() {
        return startAnalogNotification(0);
    }

    /**
     * start Analog's notification
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAnalogNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startAnalogNotification(int index) {
        Integer taskId = null;
        if (isStarted() && isAnalogNotificatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #stopAnalogNotification(int)
     */
    @Nullable
    public synchronized Integer stopAnalogNotification() {
        return stopAnalogNotification(0);
    }

    /**
     * stop Analog's notification
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAnalogNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopAnalogNotification(int index) {
        Integer taskId = null;
        if (isStarted() && isAnalogNotificatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #startAnalogIndication(int)
     */
    @Nullable
    public synchronized Integer startAnalogIndication() {
        return startAnalogIndication(0);
    }

    /**
     * start Analog's indication
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAnalogIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startAnalogIndication(int index) {
        Integer taskId = null;
        if (isStarted() && isAnalogIndicatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #stopAnalogIndication(int)
     */
    @Nullable
    public synchronized Integer stopAnalogIndication() {
        return stopAnalogIndication(0);
    }

    /**
     * stop Analog's indication
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAnalogIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopAnalogIndication(int index) {
        Integer taskId = null;
        if (isStarted() && isAnalogIndicatable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicPresentationFormat() {
        return getAnalogCharacteristicPresentationFormat(0);
    }

    /**
     * get Analog's Characteristic Presentation Format
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogCharacteristicPresentationFormatReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicPresentationFormatAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicPresentationFormatReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicPresentationFormatReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicPresentationFormat(int index) {
        Integer taskId = null;
        if (isStarted() && hasAnalogCharacteristicPresentationFormat(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicUserDescription() {
        return getAnalogCharacteristicUserDescription(0);
    }

    /**
     * get Analog's Characteristic User Description
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (isStarted() && hasAnalogCharacteristicUserDescription(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #setAnalogCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setAnalogCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setAnalogCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Analog's Characteristic User Description
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnalogCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (isStarted() && isAnalogCharacteristicUserDescriptionWritable(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, characteristicUserDescription, WriteDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicExtendedProperties() {
        return getAnalogCharacteristicExtendedProperties(0);
    }

    /**
     * get Analog's Characteristic Extended Properties
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogCharacteristicExtendedPropertiesReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicExtendedPropertiesAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicExtendedPropertiesReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogCharacteristicExtendedPropertiesReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicExtendedProperties(int index) {
        Integer taskId = null;
        if (isStarted() && hasAnalogCharacteristicExtendedProperties(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getAnalogValueTriggerSetting() {
        return getAnalogValueTriggerSetting(0);
    }

    /**
     * get Analog's Value Trigger Setting
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogValueTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ValueTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogValueTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogValueTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalogValueTriggerSetting(int index) {
        Integer taskId = null;
        if (isStarted() && hasAnalogValueTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), VALUE_TRIGGER_SETTING_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #setAnalogValueTriggerSetting(int, ValueTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAnalogValueTriggerSetting(@NonNull ValueTriggerSetting valueTriggerSetting) {
        return setAnalogValueTriggerSetting(0, valueTriggerSetting);
    }

    /**
     * set Analog's Value Trigger Setting
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogValueTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ValueTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogValueTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogValueTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnalogValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
        Integer taskId = null;
        if (isStarted() && hasAnalogValueTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), VALUE_TRIGGER_SETTING_DESCRIPTOR, valueTriggerSetting, WriteDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getAnalogTimeTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getAnalogTimeTriggerSetting() {
        return getAnalogTimeTriggerSetting(0);
    }

    /**
     * get Analog's Time Trigger Setting
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogTimeTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, TimeTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogTimeTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogTimeTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalogTimeTriggerSetting(int index) {
        Integer taskId = null;
        if (isStarted() && hasAnalogTimeTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), TIME_TRIGGER_SETTING_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #setAnalogTimeTriggerSetting(int, TimeTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAnalogTimeTriggerSetting(@NonNull TimeTriggerSetting timeTriggerSetting) {
        return setAnalogTimeTriggerSetting(0, timeTriggerSetting);
    }

    /**
     * set Analog's Time Trigger Setting
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogTimeTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, TimeTriggerSettingAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogTimeTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogTimeTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnalogTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
        Integer taskId = null;
        if (isStarted() && hasAnalogTimeTriggerSetting(index)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), TIME_TRIGGER_SETTING_DESCRIPTOR, timeTriggerSetting, WriteDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * @see #getAnalogValidRange(int)
     */
    @Nullable
    public synchronized Integer getAnalogValidRange() {
        return getAnalogValidRange(0);
    }

    /**
     * get Analog's Valid Range
     *
     * @param index Analog Characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see AutomationIOServiceCallback#onAnalogValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAnalogValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAnalogValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnalogValidRange(int index) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < mAnalogList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mAnalogList.get(index);
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, bluetoothGattCharacteristic.getService().getInstanceId(), ANALOG_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), VALID_RANGE_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Aggregate
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see AutomationIOServiceCallback#onAggregateReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AggregateAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAggregateReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAggregateReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAggregate() {
        Integer taskId = null;
        if (isStarted() && isAggregateReadable()) {
            taskId = mBLEConnection.createReadCharacteristicTask(AUTOMATION_IO_SERVICE, null, AGGREGATE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Aggregate's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see AutomationIOServiceCallback#onAggregateClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see AutomationIOServiceCallback#onAggregateClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAggregateClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAggregateClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && (isAggregateNotificatable() || isAggregateIndicatable())) {
            taskId = mBLEConnection.createReadDescriptorTask(AUTOMATION_IO_SERVICE, null, AGGREGATE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Aggregate's notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see AutomationIOServiceCallback#onAggregateNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAggregateNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAggregateNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startAggregateNotification() {
        Integer taskId = null;
        if (isStarted() && isAggregateNotificatable()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, null, AGGREGATE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Aggregate's notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see AutomationIOServiceCallback#onAggregateNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAggregateNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAggregateNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopAggregateNotification() {
        Integer taskId = null;
        if (isStarted() && isAggregateNotificatable()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, null, AGGREGATE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * start Aggregate's indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see AutomationIOServiceCallback#onAggregateIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAggregateIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAggregateIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startAggregateIndication() {
        Integer taskId = null;
        if (isStarted() && isAggregateIndicatable()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, null, AGGREGATE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Aggregate's indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see AutomationIOServiceCallback#onAggregateIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see AutomationIOServiceCallback#onAggregateIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see AutomationIOServiceCallback#onAggregateIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopAggregateIndication() {
        Integer taskId = null;
        if (isStarted() && isAggregateIndicatable()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(AUTOMATION_IO_SERVICE, null, AGGREGATE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
