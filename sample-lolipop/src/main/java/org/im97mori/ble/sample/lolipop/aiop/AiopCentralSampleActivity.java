package org.im97mori.ble.sample.lolipop.aiop;

import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.core.AutomationIoUtils;
import org.im97mori.ble.characteristic.u2a00.DeviceName;
import org.im97mori.ble.characteristic.u2a01.Appearance;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlag;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddress;
import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeatures;
import org.im97mori.ble.constants.AppearanceValues;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.profile.aiop.central.AutomationIOProfile;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.LinkedList;
import java.util.Set;

import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

public class AiopCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private AiopCallbackSample mAiopCallbackSample;
    private AutomationIOProfile mAutomationIOProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAiopCallbackSample = new AiopCallbackSample(this, this);
        mAutomationIOProfile = new AutomationIOProfile(this, mAiopCallbackSample) {
            @Override
            public synchronized void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                mBLEConnection.createDiscoverServiceTask(DiscoverServiceTask.TIMEOUT_MILLIS, null, null);
            }
        };
        mAutomationIOProfile.start();

        mConnectDisconnectButton = findViewById(R.id.connectDisconnectButton);
        mAdapter = new ArrayAdapter<Pair<String, String>>(this, R.layout.list_child, new LinkedList<>()) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View child = convertView;
                if (child == null) {
                    child = getLayoutInflater().inflate(R.layout.list_child, parent, false);
                }
                Pair<String, String> item = getItem(position);
                if (item != null) {
                    TextView textView = child.findViewById(R.id.time);
                    textView.setText(item.first);
                    textView = child.findViewById(R.id.body);
                    textView.setText(item.second);
                }
                return child;
            }
        };
        mListView = findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        mConnectDisconnectButton.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gatt_sample;
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateLayout();
    }

    @Override
    protected void onDestroy() {
        if (mAutomationIOProfile != null) {
            mAutomationIOProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aiop_central, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mAutomationIOProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mAutomationIOProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.get_device_name == item.getItemId()) {
            mAutomationIOProfile.getDeviceName();
        } else if (R.id.is_device_name_writable == item.getItemId()) {
            addRow("isDeviceNameCharacteristicWritable", mAutomationIOProfile.isDeviceNameCharacteristicWritable());
        } else if (R.id.set_device_name == item.getItemId()) {
            mAutomationIOProfile.setDeviceName(new DeviceName("a"));
        } else if (R.id.get_appearance == item.getItemId()) {
            mAutomationIOProfile.getAppearance();
        } else {
            digital(item);
            analog(item);
            aggregate(item);
            gatt(item);
            gap(item);
        }
        return true;
    }

    private void gatt(MenuItem item) {
        if (R.id.get_device_name == item.getItemId()) {
            mAutomationIOProfile.getDeviceName();
        } else if (R.id.is_device_name_writable == item.getItemId()) {
            addRow("isDeviceNameCharacteristicWritable", mAutomationIOProfile.isDeviceNameCharacteristicWritable());
        } else if (R.id.set_device_name == item.getItemId()) {
            mAutomationIOProfile.setDeviceName(new DeviceName("deviceNameAiop2"));
        } else if (R.id.get_appearance == item.getItemId()) {
            mAutomationIOProfile.getAppearance();
        } else if (R.id.is_appearance_writable == item.getItemId()) {
            addRow("isDeviceNameCharacteristicWritable", mAutomationIOProfile.isAppearanceCharacteristicWritable());
        } else if (R.id.set_appearance == item.getItemId()) {
            mAutomationIOProfile.setAppearance(new Appearance(AppearanceValues.LOCATION_POD_APPEARANCE_SUB_CATEGORY));
        } else if (R.id.has_ppcp == item.getItemId()) {
            addRow("isPeripheralPreferredConnectionParametersCharacteristicSupported", mAutomationIOProfile.isPeripheralPreferredConnectionParametersCharacteristicSupported());
        } else if (R.id.get_ppcp == item.getItemId()) {
            mAutomationIOProfile.getPeripheralPreferredConnectionParameters();
        } else if (R.id.has_car == item.getItemId()) {
            addRow("isCentralAddressResolutionCharacteristicSupported", mAutomationIOProfile.isCentralAddressResolutionCharacteristicSupported());
        } else if (R.id.get_car == item.getItemId()) {
            mAutomationIOProfile.getCentralAddressResolutionParameters();
        } else if (R.id.has_rpao == item.getItemId()) {
            addRow("isCentralAddressResolutionCharacteristicSupported", mAutomationIOProfile.isResolvablePrivateAddressOnlyCharacteristicSupported());
        } else if (R.id.get_rpao == item.getItemId()) {
            mAutomationIOProfile.getResolvablePrivateAddressOnly();
        } else if (R.id.has_reconnection_address == item.getItemId()) {
            addRow("isCentralAddressResolutionCharacteristicSupported", mAutomationIOProfile.isReconnectionAddressCharacteristicSupported());
        } else if (R.id.set_reconnection_address == item.getItemId()) {
            mAutomationIOProfile.setReconnectionAddress(new ReconnectionAddress(1));
        } else if (R.id.has_ppf == item.getItemId()) {
            addRow("isPeripheralPrivacyFlagCharacteristicSupported", mAutomationIOProfile.isPeripheralPrivacyFlagCharacteristicSupported());
        } else if (R.id.get_ppf == item.getItemId()) {
            mAutomationIOProfile.getPeripheralPrivacyFlag();
        } else if (R.id.is_ppf_writable == item.getItemId()) {
            addRow("isPeripheralPrivacyFlagCharacteristicWritable", mAutomationIOProfile.isPeripheralPrivacyFlagCharacteristicWritable());
        } else if (R.id.set_ppf == item.getItemId()) {
            mAutomationIOProfile.setPeripheralPrivacyFlag(new PeripheralPrivacyFlag(PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE));
        }
    }

    private void gap(MenuItem item) {
        if (R.id.has_service_changed == item.getItemId()) {
            addRow("isServiceChangedCharacteristicSupported", mAutomationIOProfile.isServiceChangedCharacteristicSupported());
        } else if (R.id.read_service_changed_characteristic_configuration == item.getItemId()) {
            mAutomationIOProfile.getServiceChangedClientCharacteristicConfiguration();
        } else if (R.id.indicate_service_changed_start == item.getItemId()) {
            mAutomationIOProfile.startServiceChangedIndication();
        } else if (R.id.indicate_service_changed_stop == item.getItemId()) {
            mAutomationIOProfile.stopServiceChangedIndication();
        } else if (R.id.has_csf == item.getItemId()) {
            addRow("isClientSupportedFeaturesCharacteristicSupported", mAutomationIOProfile.isClientSupportedFeaturesCharacteristicSupported());
        } else if (R.id.get_csf == item.getItemId()) {
            mAutomationIOProfile.getClientSupportedFeatures();
        } else if (R.id.set_csf == item.getItemId()) {
            mAutomationIOProfile.setClientSupportedFeatures(new ClientSupportedFeatures(new byte[0]));
        } else if (R.id.has_database_hash == item.getItemId()) {
            addRow("isDatabaseHashCharacteristicSupported", mAutomationIOProfile.isDatabaseHashCharacteristicSupported());
        } else if (R.id.get_database_hash == item.getItemId()) {
            mAutomationIOProfile.getDatabaseHash();
        }
    }

    private void digital(MenuItem item) {
        if (R.id.get_digital_count == item.getItemId()) {
            addRow("getDigitalCount", mAutomationIOProfile.getDigitalCount());
        } else {
            digital0(item);
            digital1(item);
        }
    }

    private void analog(MenuItem item) {
        if (R.id.get_analog_count == item.getItemId()) {
            addRow("getAnalogCount", mAutomationIOProfile.getAnalogCount());
        } else {
            analog0(item);
            analog1(item);
        }
    }

    private void digital0(MenuItem item) {
        if (R.id.is_digital_readable_0 == item.getItemId()) {
            addRow("isDigitalReadable", mAutomationIOProfile.isDigitalReadable());
        } else if (R.id.is_digital_writable_0 == item.getItemId()) {
            addRow("isDigitalWritable", mAutomationIOProfile.isDigitalWritable());
        } else if (R.id.is_digital_writable_with_no_response_0 == item.getItemId()) {
            addRow("isDigitalWritableWithNoResponse", mAutomationIOProfile.isDigitalWritableWithNoResponse());
        } else if (R.id.is_digital_notificatable_0 == item.getItemId()) {
            addRow("isDigitalNotificatable", mAutomationIOProfile.isDigitalNotificatable());
        } else if (R.id.is_digital_indicatable_0 == item.getItemId()) {
            addRow("isDigitalIndicatable", mAutomationIOProfile.isDigitalIndicatable());
        } else if (R.id.has_digital_characteristic_presentation_format_0 == item.getItemId()) {
            addRow("hasDigitalCharacteristicPresentationFormat", mAutomationIOProfile.hasDigitalCharacteristicPresentationFormat());
        } else if (R.id.has_digital_characteristic_user_description_0 == item.getItemId()) {
            addRow("hasDigitalCharacteristicUserDescription", mAutomationIOProfile.hasDigitalCharacteristicUserDescription());
        } else if (R.id.is_digital_characteristic_user_description_writable_0 == item.getItemId()) {
            addRow("isDigitalCharacteristicUserDescriptionWritable", mAutomationIOProfile.isDigitalCharacteristicUserDescriptionWritable());
        } else if (R.id.has_digital_characteristic_extended_properties_0 == item.getItemId()) {
            addRow("hasDigitalCharacteristicExtendedProperties", mAutomationIOProfile.hasDigitalCharacteristicExtendedProperties());
        } else if (R.id.has_digital_value_trigger_setting_0 == item.getItemId()) {
            addRow("hasDigitalValueTriggerSetting", mAutomationIOProfile.hasDigitalValueTriggerSetting());
        } else if (R.id.has_digital_time_trigger_setting_0 == item.getItemId()) {
            addRow("hasDigitalTimeTriggerSetting", mAutomationIOProfile.hasDigitalTimeTriggerSetting());
        } else if (R.id.get_digital_0 == item.getItemId()) {
            mAutomationIOProfile.getDigital();
        } else if (R.id.set_digital_0 == item.getItemId()) {
            mAutomationIOProfile.setDigital(new Digital(new byte[]{(byte) (AutomationIoUtils.DIGITAL_OUTPUT_STATE | AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2 | AutomationIoUtils.DIGITAL_OUTPUT_STATE << 4 | AutomationIoUtils.DIGITAL_OUTPUT_STATE << 6), AutomationIoUtils.DIGITAL_ACTIVE}));
        } else if (R.id.set_digital_with_no_response_0 == item.getItemId()) {
            mAutomationIOProfile.setDigitalWithNoResponse(new Digital(new byte[]{(byte) (AutomationIoUtils.DIGITAL_TRI_STATE | AutomationIoUtils.DIGITAL_TRI_STATE << 2 | AutomationIoUtils.DIGITAL_TRI_STATE << 4 | AutomationIoUtils.DIGITAL_TRI_STATE << 6), AutomationIoUtils.DIGITAL_ACTIVE}));
        } else if (R.id.get_digital_client_characteristic_configuration_0 == item.getItemId()) {
            mAutomationIOProfile.getDigitalClientCharacteristicConfiguration();
        } else if (R.id.start_digital_notification_0 == item.getItemId()) {
            mAutomationIOProfile.startDigitalNotification();
        } else if (R.id.stop_digital_notification_0 == item.getItemId()) {
            mAutomationIOProfile.stopDigitalNotification();
        } else if (R.id.start_digital_indication_0 == item.getItemId()) {
            mAutomationIOProfile.startDigitalIndication();
        } else if (R.id.stop_digital_indication_0 == item.getItemId()) {
            mAutomationIOProfile.stopDigitalIndication();
        } else if (R.id.get_digital_characteristic_presentation_format_0 == item.getItemId()) {
            mAutomationIOProfile.getDigitalCharacteristicPresentationFormat();
        } else if (R.id.get_digital_characteristic_user_description_0 == item.getItemId()) {
            mAutomationIOProfile.getDigitalCharacteristicUserDescription();
        } else if (R.id.set_digital_characteristic_user_description_0 == item.getItemId()) {
            mAutomationIOProfile.setDigitalCharacteristicUserDescription(new CharacteristicUserDescription("CharacteristicUserDescription 0_".getBytes()));
        } else if (R.id.get_digital_characteristic_extended_properties_0 == item.getItemId()) {
            mAutomationIOProfile.getDigitalCharacteristicExtendedProperties();
        } else if (R.id.get_digital_value_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.getDigitalValueTriggerSetting();
        } else if (R.id.set_digital_value_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.setDigitalValueTriggerSetting(new ValueTriggerSetting(ValueTriggerSetting.BIT_MASK_4, 0, new byte[1], 0, 0));
        } else if (R.id.get_digital_time_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.getDigitalTimeTriggerSetting();
        } else if (R.id.set_digital_time_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.setDigitalTimeTriggerSetting(new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 1));
        } else if (R.id.get_digital_number_of_digitals_0 == item.getItemId()) {
            mAutomationIOProfile.getDigitalNumberOfDigitals();
        }
    }

    private void digital1(MenuItem item) {
        if (R.id.is_digital_readable_1 == item.getItemId()) {
            addRow("isDigitalReadable", mAutomationIOProfile.isDigitalReadable(1));
        } else if (R.id.is_digital_writable_1 == item.getItemId()) {
            addRow("isDigitalWritable", mAutomationIOProfile.isDigitalWritable(1));
        } else if (R.id.is_digital_writable_with_no_response_1 == item.getItemId()) {
            addRow("isDigitalWritableWithNoResponse", mAutomationIOProfile.isDigitalWritableWithNoResponse(1));
        } else if (R.id.is_digital_notificatable_1 == item.getItemId()) {
            addRow("isDigitalNotificatable", mAutomationIOProfile.isDigitalNotificatable(1));
        } else if (R.id.is_digital_indicatable_1 == item.getItemId()) {
            addRow("isDigitalIndicatable", mAutomationIOProfile.isDigitalIndicatable(1));
        } else if (R.id.has_digital_characteristic_presentation_format_1 == item.getItemId()) {
            addRow("hasDigitalCharacteristicPresentationFormat", mAutomationIOProfile.hasDigitalCharacteristicPresentationFormat(1));
        } else if (R.id.has_digital_characteristic_user_description_1 == item.getItemId()) {
            addRow("hasDigitalCharacteristicUserDescription", mAutomationIOProfile.hasDigitalCharacteristicUserDescription(1));
        } else if (R.id.is_digital_characteristic_user_description_writable_1 == item.getItemId()) {
            addRow("isDigitalCharacteristicUserDescriptionWritable", mAutomationIOProfile.isDigitalCharacteristicUserDescriptionWritable(1));
        } else if (R.id.has_digital_characteristic_extended_properties_1 == item.getItemId()) {
            addRow("hasDigitalCharacteristicExtendedProperties", mAutomationIOProfile.hasDigitalCharacteristicExtendedProperties(1));
        } else if (R.id.has_digital_value_trigger_setting_1 == item.getItemId()) {
            addRow("hasDigitalValueTriggerSetting", mAutomationIOProfile.hasDigitalValueTriggerSetting(1));
        } else if (R.id.has_digital_time_trigger_setting_1 == item.getItemId()) {
            addRow("hasDigitalTimeTriggerSetting", mAutomationIOProfile.hasDigitalTimeTriggerSetting(1));
        } else if (R.id.get_digital_1 == item.getItemId()) {
            mAutomationIOProfile.getDigital(1);
        } else if (R.id.set_digital_1 == item.getItemId()) {
            mAutomationIOProfile.setDigital(1, new Digital(new byte[]{AutomationIoUtils.DIGITAL_ACTIVE}));
        } else if (R.id.set_digital_with_no_response_1 == item.getItemId()) {
            mAutomationIOProfile.setDigitalWithNoResponse(1, new Digital(new byte[]{AutomationIoUtils.DIGITAL_TRI_STATE}));
        } else if (R.id.get_digital_client_characteristic_configuration_1 == item.getItemId()) {
            mAutomationIOProfile.getDigitalClientCharacteristicConfiguration(1);
        } else if (R.id.start_digital_notification_1 == item.getItemId()) {
            mAutomationIOProfile.startDigitalNotification(1);
        } else if (R.id.stop_digital_notification_1 == item.getItemId()) {
            mAutomationIOProfile.stopDigitalNotification(1);
        } else if (R.id.start_digital_indication_1 == item.getItemId()) {
            mAutomationIOProfile.startDigitalIndication(1);
        } else if (R.id.stop_digital_indication_1 == item.getItemId()) {
            mAutomationIOProfile.stopDigitalIndication(1);
        } else if (R.id.get_digital_characteristic_presentation_format_1 == item.getItemId()) {
            mAutomationIOProfile.getDigitalCharacteristicPresentationFormat(1);
        } else if (R.id.get_digital_characteristic_user_description_1 == item.getItemId()) {
            mAutomationIOProfile.getDigitalCharacteristicUserDescription(1);
        } else if (R.id.set_digital_characteristic_user_description_1 == item.getItemId()) {
            mAutomationIOProfile.setDigitalCharacteristicUserDescription(1, new CharacteristicUserDescription("CharacteristicUserDescription 1_".getBytes()));
        } else if (R.id.get_digital_characteristic_extended_properties_1 == item.getItemId()) {
            mAutomationIOProfile.getDigitalCharacteristicExtendedProperties(1);
        } else if (R.id.get_digital_value_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.getDigitalValueTriggerSetting(1);
        } else if (R.id.set_digital_value_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.setDigitalValueTriggerSetting(1, new ValueTriggerSetting(ValueTriggerSetting.BIT_MASK_4, 0, new byte[1], 0, 0));
        } else if (R.id.get_digital_time_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.getDigitalTimeTriggerSetting(1);
        } else if (R.id.set_digital_time_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.setDigitalTimeTriggerSetting(1, new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 1));
        } else if (R.id.get_digital_number_of_digitals_1 == item.getItemId()) {
            mAutomationIOProfile.getDigitalNumberOfDigitals(1);
        }
    }

    private void analog0(MenuItem item) {
        if (R.id.is_analog_readable_0 == item.getItemId()) {
            addRow("isAnalogReadable", mAutomationIOProfile.isAnalogReadable());
        } else if (R.id.is_analog_writable_0 == item.getItemId()) {
            addRow("isAnalogWritable", mAutomationIOProfile.isAnalogWritable());
        } else if (R.id.is_analog_writable_with_no_response_0 == item.getItemId()) {
            addRow("isAnalogWritableWithNoResponse", mAutomationIOProfile.isAnalogWritableWithNoResponse());
        } else if (R.id.is_analog_notificatable_0 == item.getItemId()) {
            addRow("isAnalogNotificatable", mAutomationIOProfile.isAnalogNotificatable());
        } else if (R.id.is_analog_indicatable_0 == item.getItemId()) {
            addRow("isAnalogIndicatable", mAutomationIOProfile.isAnalogIndicatable());
        } else if (R.id.has_analog_characteristic_presentation_format_0 == item.getItemId()) {
            addRow("hasAnalogCharacteristicPresentationFormat", mAutomationIOProfile.hasAnalogCharacteristicPresentationFormat());
        } else if (R.id.has_analog_characteristic_user_description_0 == item.getItemId()) {
            addRow("hasAnalogCharacteristicUserDescription", mAutomationIOProfile.hasAnalogCharacteristicUserDescription());
        } else if (R.id.is_analog_characteristic_user_description_writable_0 == item.getItemId()) {
            addRow("isAnalogCharacteristicUserDescriptionWritable", mAutomationIOProfile.isAnalogCharacteristicUserDescriptionWritable());
        } else if (R.id.has_analog_characteristic_extended_properties_0 == item.getItemId()) {
            addRow("hasAnalogCharacteristicExtendedProperties", mAutomationIOProfile.hasAnalogCharacteristicExtendedProperties());
        } else if (R.id.has_analog_value_trigger_setting_0 == item.getItemId()) {
            addRow("hasAnalogValueTriggerSetting", mAutomationIOProfile.hasAnalogValueTriggerSetting());
        } else if (R.id.has_analog_time_trigger_setting_0 == item.getItemId()) {
            addRow("hasAnalogTimeTriggerSetting", mAutomationIOProfile.hasAnalogTimeTriggerSetting());
        } else if (R.id.get_analog_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalog();
        } else if (R.id.set_analog_0 == item.getItemId()) {
            mAutomationIOProfile.setAnalog(new Analog(new byte[]{0x02, 0x00}));
        } else if (R.id.set_analog_with_no_response_0 == item.getItemId()) {
            mAutomationIOProfile.setAnalogWithNoResponse(new Analog(new byte[]{0x03, 0x00}));
        } else if (R.id.get_analog_client_characteristic_configuration_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalogClientCharacteristicConfiguration();
        } else if (R.id.start_analog_notification_0 == item.getItemId()) {
            mAutomationIOProfile.startAnalogNotification();
        } else if (R.id.stop_analog_notification_0 == item.getItemId()) {
            mAutomationIOProfile.stopAnalogNotification();
        } else if (R.id.start_analog_indication_0 == item.getItemId()) {
            mAutomationIOProfile.startAnalogIndication();
        } else if (R.id.stop_analog_indication_0 == item.getItemId()) {
            mAutomationIOProfile.stopAnalogIndication();
        } else if (R.id.get_analog_characteristic_presentation_format_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalogCharacteristicPresentationFormat();
        } else if (R.id.get_analog_characteristic_user_description_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalogCharacteristicUserDescription();
        } else if (R.id.set_analog_characteristic_user_description_0 == item.getItemId()) {
            mAutomationIOProfile.setAnalogCharacteristicUserDescription(new CharacteristicUserDescription("CharacteristicUserDescription 0_".getBytes()));
        } else if (R.id.get_analog_characteristic_extended_properties_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalogCharacteristicExtendedProperties();
        } else if (R.id.get_analog_value_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalogValueTriggerSetting();
        } else if (R.id.set_analog_value_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.setAnalogValueTriggerSetting(new ValueTriggerSetting(ValueTriggerSetting.BIT_MASK_4, 0, new byte[1], 0, 0));
        } else if (R.id.get_analog_time_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalogTimeTriggerSetting();
        } else if (R.id.set_analog_time_trigger_setting_0 == item.getItemId()) {
            mAutomationIOProfile.setAnalogTimeTriggerSetting(new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 1));
        } else if (R.id.get_analog_valid_range_0 == item.getItemId()) {
            mAutomationIOProfile.getAnalogValidRange();
        }
    }

    private void analog1(MenuItem item) {
        if (R.id.is_analog_readable_1 == item.getItemId()) {
            addRow("isAnalogReadable", mAutomationIOProfile.isAnalogReadable(1));
        } else if (R.id.is_analog_writable_1 == item.getItemId()) {
            addRow("isAnalogWritable", mAutomationIOProfile.isAnalogWritable(1));
        } else if (R.id.is_analog_writable_with_no_response_1 == item.getItemId()) {
            addRow("isAnalogWritableWithNoResponse", mAutomationIOProfile.isAnalogWritableWithNoResponse(1));
        } else if (R.id.is_analog_notificatable_1 == item.getItemId()) {
            addRow("isAnalogNotificatable", mAutomationIOProfile.isAnalogNotificatable(1));
        } else if (R.id.is_analog_indicatable_1 == item.getItemId()) {
            addRow("isAnalogIndicatable", mAutomationIOProfile.isAnalogIndicatable(1));
        } else if (R.id.has_analog_characteristic_presentation_format_1 == item.getItemId()) {
            addRow("hasAnalogCharacteristicPresentationFormat", mAutomationIOProfile.hasAnalogCharacteristicPresentationFormat(1));
        } else if (R.id.has_analog_characteristic_user_description_1 == item.getItemId()) {
            addRow("hasAnalogCharacteristicUserDescription", mAutomationIOProfile.hasAnalogCharacteristicUserDescription(1));
        } else if (R.id.is_analog_characteristic_user_description_writable_1 == item.getItemId()) {
            addRow("isAnalogCharacteristicUserDescriptionWritable", mAutomationIOProfile.isAnalogCharacteristicUserDescriptionWritable(1));
        } else if (R.id.has_analog_characteristic_extended_properties_1 == item.getItemId()) {
            addRow("hasAnalogCharacteristicExtendedProperties", mAutomationIOProfile.hasAnalogCharacteristicExtendedProperties(1));
        } else if (R.id.has_analog_value_trigger_setting_1 == item.getItemId()) {
            addRow("hasAnalogValueTriggerSetting", mAutomationIOProfile.hasAnalogValueTriggerSetting(1));
        } else if (R.id.has_analog_time_trigger_setting_1 == item.getItemId()) {
            addRow("hasAnalogTimeTriggerSetting", mAutomationIOProfile.hasAnalogTimeTriggerSetting(1));
        } else if (R.id.get_analog_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalog(1);
        } else if (R.id.set_analog_1 == item.getItemId()) {
            mAutomationIOProfile.setAnalog(1, new Analog(new byte[]{0x02, 0x01}));
        } else if (R.id.set_analog_with_no_response_1 == item.getItemId()) {
            mAutomationIOProfile.setAnalogWithNoResponse(1, new Analog(new byte[]{0x03, 0x01}));
        } else if (R.id.get_analog_client_characteristic_configuration_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalogClientCharacteristicConfiguration(1);
        } else if (R.id.start_analog_notification_1 == item.getItemId()) {
            mAutomationIOProfile.startAnalogNotification(1);
        } else if (R.id.stop_analog_notification_1 == item.getItemId()) {
            mAutomationIOProfile.stopAnalogNotification(1);
        } else if (R.id.start_analog_indication_1 == item.getItemId()) {
            mAutomationIOProfile.startAnalogIndication(1);
        } else if (R.id.stop_analog_indication_1 == item.getItemId()) {
            mAutomationIOProfile.stopAnalogIndication(1);
        } else if (R.id.get_analog_characteristic_presentation_format_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalogCharacteristicPresentationFormat(1);
        } else if (R.id.get_analog_characteristic_user_description_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalogCharacteristicUserDescription(1);
        } else if (R.id.set_analog_characteristic_user_description_1 == item.getItemId()) {
            mAutomationIOProfile.setAnalogCharacteristicUserDescription(1, new CharacteristicUserDescription("CharacteristicUserDescription 1_".getBytes()));
        } else if (R.id.get_analog_characteristic_extended_properties_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalogCharacteristicExtendedProperties(1);
        } else if (R.id.get_analog_value_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalogValueTriggerSetting(1);
        } else if (R.id.set_analog_value_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.setAnalogValueTriggerSetting(1, new ValueTriggerSetting(ValueTriggerSetting.BIT_MASK_4, 0, new byte[1], 0, 0));
        } else if (R.id.get_analog_time_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalogTimeTriggerSetting(1);
        } else if (R.id.set_analog_time_trigger_setting_1 == item.getItemId()) {
            mAutomationIOProfile.setAnalogTimeTriggerSetting(1, new TimeTriggerSetting(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0, 0, 1));
        } else if (R.id.get_analog_valid_range_1 == item.getItemId()) {
            mAutomationIOProfile.getAnalogValidRange(1);
        }
    }

    private void aggregate(MenuItem item) {
        if (R.id.is_aggregate_supported == item.getItemId()) {
            addRow("isAggregateSupported", mAutomationIOProfile.isAggregateSupported());
        } else if (R.id.is_aggregate_readable == item.getItemId()) {
            addRow("isAggregateReadable", mAutomationIOProfile.isAggregateReadable());
        } else if (R.id.is_aggregate_notificatable == item.getItemId()) {
            addRow("isAggregateNotificatable", mAutomationIOProfile.isAggregateNotificatable());
        } else if (R.id.is_aggregate_indicatable == item.getItemId()) {
            addRow("isAggregateIndicatable", mAutomationIOProfile.isAggregateIndicatable());
        } else if (R.id.get_aggregate == item.getItemId()) {
            mAutomationIOProfile.getAggregate();
        } else if (R.id.get_aggregate_client_characteristic_configuration == item.getItemId()) {
            mAutomationIOProfile.getAggregateClientCharacteristicConfiguration();
        } else if (R.id.start_aggregate_notification == item.getItemId()) {
            mAutomationIOProfile.startAggregateNotification();
        } else if (R.id.stop_aggregate_notification == item.getItemId()) {
            mAutomationIOProfile.stopAggregateNotification();
        } else if (R.id.start_aggregate_indication == item.getItemId()) {
            mAutomationIOProfile.startAggregateIndication();
        } else if (R.id.stop_aggregate_indication == item.getItemId()) {
            mAutomationIOProfile.stopAggregateIndication();
        }
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mAutomationIOProfile.isConnected()) {
                mConnectDisconnectButton.setText(R.string.disconnect);
            } else if (mBluetoothDevice != null) {
                if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                    mConnectDisconnectButton.setText(R.string.connect);
                } else {
                    mConnectDisconnectButton.setText(R.string.bond);
                }
            } else {
                mConnectDisconnectButton.setText(R.string.scan_start);
            }
        }
        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mAutomationIOProfile == null) {
                mAutomationIOProfile = new AutomationIOProfile(this, mAiopCallbackSample);
                mAutomationIOProfile.start();
            }
            if (mAutomationIOProfile.isConnected()) {
                mAutomationIOProfile.disconnect();
                mAiopCallbackSample.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, UNKNOWN, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mAutomationIOProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mAutomationIOProfile.connect(mBluetoothDevice);
                    } else {
                        mAutomationIOProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
                    }
                }
            }
            updateLayout();
        } else {
            super.onClick(v);
        }
    }

    @Override
    public void onCallbacked(final Pair<String, String> log) {
        runOnUiThread(() -> {
            mAdapter.add(log);
            mListView.smoothScrollToPosition(mAdapter.getCount());

            updateLayout();
        });
    }

}
