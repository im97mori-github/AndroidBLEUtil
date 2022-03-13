package org.im97mori.ble.sample.lolipop.esp;

import static org.im97mori.ble.task.DisconnectTask.STATUS_MANUAL_DISCONNECT;

import android.bluetooth.BluetoothDevice;
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

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.esp.central.EnvironmentalSensingProfile;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;
import java.util.Set;

public class EspCentralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private EspCallbackSample mEspCallbackSample;
    private EnvironmentalSensingProfile mEnvironmentalSensingProfile;
    BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mEspCallbackSample = new EspCallbackSample(this, this);
        mEnvironmentalSensingProfile = new EnvironmentalSensingProfile(this, mEspCallbackSample);
        mEnvironmentalSensingProfile.start();

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
        if (mEnvironmentalSensingProfile != null) {
            mEnvironmentalSensingProfile.quit();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.esp_central, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.load_bonded_device == item.getItemId()) {
            Set<BluetoothDevice> bluetoothDeviceSet = mEnvironmentalSensingProfile.getBondedDevices();
            if (bluetoothDeviceSet != null && !bluetoothDeviceSet.isEmpty()) {
                mBluetoothDevice = bluetoothDeviceSet.iterator().next();
            }
            updateLayout();
        } else if (R.id.clear_bonded_history == item.getItemId()) {
            mEnvironmentalSensingProfile.syncBondedDevice();
            mBluetoothDevice = null;
            updateLayout();
        } else if (R.id.has_device_information_service == item.getItemId()) {
            addRow("hasDeviceInformationService", mEnvironmentalSensingProfile.hasDeviceInformationService());
        } else if (R.id.has_battery_service == item.getItemId()) {
            addRow("hasBatteryService", mEnvironmentalSensingProfile.hasBatteryService());
        } else if (R.id.is_descriptor_value_changed_characteristic_supported == item.getItemId()) {
            mEnvironmentalSensingProfile.isDescriptorValueChangedCharacteristicSupported();
        } else if (R.id.indicate_descriptor_value_changed_start == item.getItemId()) {
            mEnvironmentalSensingProfile.startDescriptorValueChangedIndication();
        } else if (R.id.indicate_descriptor_value_changed_stop == item.getItemId()) {
            mEnvironmentalSensingProfile.stopDescriptorValueChangedIndication();
        } else if (R.id.read_manufacturer_name == item.getItemId()) {
            mEnvironmentalSensingProfile.getManufacturerNameString();
        } else if (R.id.read_model_number == item.getItemId()) {
            mEnvironmentalSensingProfile.getModelNumberString();
        } else if (R.id.read_battery_level_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBatteryLevel(0);
        } else if (R.id.read_battery_level_2 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBatteryLevel(1);
        } else if (R.id.start_notify_battery_level == item.getItemId()) {
            mEnvironmentalSensingProfile.startBatteryLevelNotification(1);
        } else if (R.id.stop_notify_battery_level == item.getItemId()) {
            mEnvironmentalSensingProfile.stopBatteryLevelNotification(1);
        }
        onAwd(item);
        onAws(item);
        onDp(item);
        onElevation(item);
        onGf(item);
        onHi(item);
        onHumidity(item);
        onIrradiance(item);
        onPc(item);
        onRainfall(item);
        onPressure(item);
        onTemperature(item);
        onTwd(item);
        onTws(item);
        onUvi(item);
        onWc(item);
        onBpt(item);
        onMd(item);
        onMfd2d(item);
        onMfd3d(item);
        return true;
    }

    private void onAwd(MenuItem item) {
        if (R.id.read_awd_count == item.getItemId()) {
            addRow("getApparentWindDirectionCount", mEnvironmentalSensingProfile.getApparentWindDirectionCount());
        } else if (R.id.is_awd_notificatable_0 == item.getItemId()) {
            addRow("isApparentWindDirectionNotificatable", mEnvironmentalSensingProfile.isApparentWindDirectionNotificatable());
        } else if (R.id.is_awd_notificatable_1 == item.getItemId()) {
            addRow("isApparentWindDirectionNotificatable_1", mEnvironmentalSensingProfile.isApparentWindDirectionNotificatable(1));
        } else if (R.id.has_awd_esm_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_awd_esm_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_awd_ests_count_0 == item.getItemId()) {
            addRow("getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_awd_ests_count_1 == item.getItemId()) {
            addRow("getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_awd_esc_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_awd_esc_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_awd_cud_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_awd_cud_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_awd_vr_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicValidRange", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicValidRange());
        } else if (R.id.has_awd_vr_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicValidRange(1));
        } else if (R.id.read_awd_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirection();
        } else if (R.id.read_awd_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirection(1);
        } else if (R.id.notify_awd_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindDirectionNotification();
        } else if (R.id.notify_awd_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindDirectionNotification(1);
        } else if (R.id.notify_awd_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindDirectionNotification();
        } else if (R.id.notify_awd_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindDirectionNotification(1);
        } else if (R.id.read_awd_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingMeasurement();
        } else if (R.id.read_awd_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_awd_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_awd_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_awd_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_awd_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_awd_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_awd_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_awd_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingConfiguration();
        } else if (R.id.read_awd_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_awd_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_awd_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_awd_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicUserDescription();
        } else if (R.id.read_awd_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicUserDescription(1);
        } else if (R.id.write_awd_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_awd_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_awd_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionValidRange();
        } else if (R.id.read_awd_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionValidRange(1);
        }
    }

    private void onAws(MenuItem item) {
        if (R.id.read_aws_count == item.getItemId()) {
            addRow("getApparentWindSpeedCount", mEnvironmentalSensingProfile.getApparentWindSpeedCount());
        } else if (R.id.is_aws_notificatable_0 == item.getItemId()) {
            addRow("isApparentWindSpeedNotificatable", mEnvironmentalSensingProfile.isApparentWindSpeedNotificatable());
        } else if (R.id.is_aws_notificatable_1 == item.getItemId()) {
            addRow("isApparentWindSpeedNotificatable_1", mEnvironmentalSensingProfile.isApparentWindSpeedNotificatable(1));
        } else if (R.id.has_aws_esm_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_aws_esm_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_aws_ests_count_0 == item.getItemId()) {
            addRow("getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_aws_ests_count_1 == item.getItemId()) {
            addRow("getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_aws_esc_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_aws_esc_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_aws_cud_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_aws_cud_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_aws_vr_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicValidRange", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicValidRange());
        } else if (R.id.has_aws_vr_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicValidRange(1));
        } else if (R.id.read_aws_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeed();
        } else if (R.id.read_aws_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeed(1);
        } else if (R.id.notify_aws_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindSpeedNotification();
        } else if (R.id.notify_aws_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindSpeedNotification(1);
        } else if (R.id.notify_aws_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindSpeedNotification();
        } else if (R.id.notify_aws_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindSpeedNotification(1);
        } else if (R.id.read_aws_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingMeasurement();
        } else if (R.id.read_aws_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_aws_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_aws_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_aws_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_aws_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_aws_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_aws_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_aws_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingConfiguration();
        } else if (R.id.read_aws_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_aws_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_aws_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_aws_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicUserDescription();
        } else if (R.id.read_aws_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicUserDescription(1);
        } else if (R.id.write_aws_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_aws_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_aws_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedValidRange();
        } else if (R.id.read_aws_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedValidRange(1);
        }
    }

    private void onDp(MenuItem item) {
        if (R.id.read_dp_count == item.getItemId()) {
            addRow("getDewPointCount", mEnvironmentalSensingProfile.getDewPointCount());
        } else if (R.id.is_dp_notificatable_0 == item.getItemId()) {
            addRow("isDewPointNotificatable", mEnvironmentalSensingProfile.isDewPointNotificatable());
        } else if (R.id.is_dp_notificatable_1 == item.getItemId()) {
            addRow("isDewPointNotificatable_1", mEnvironmentalSensingProfile.isDewPointNotificatable(1));
        } else if (R.id.has_dp_esm_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_dp_esm_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_dp_ests_count_0 == item.getItemId()) {
            addRow("getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_dp_ests_count_1 == item.getItemId()) {
            addRow("getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_dp_esc_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_dp_esc_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_dp_cud_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasDewPointCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_dp_cud_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_dp_vr_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicValidRange", mEnvironmentalSensingProfile.hasDewPointCharacteristicValidRange());
        } else if (R.id.has_dp_vr_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicValidRange(1));
        } else if (R.id.read_dp_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPoint();
        } else if (R.id.read_dp_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPoint(1);
        } else if (R.id.notify_dp_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startDewPointNotification();
        } else if (R.id.notify_dp_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startDewPointNotification(1);
        } else if (R.id.notify_dp_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopDewPointNotification();
        } else if (R.id.notify_dp_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopDewPointNotification(1);
        } else if (R.id.read_dp_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingMeasurement();
        } else if (R.id.read_dp_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_dp_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_dp_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_dp_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_dp_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_dp_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_dp_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_dp_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingConfiguration();
        } else if (R.id.read_dp_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_dp_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_dp_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_dp_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointCharacteristicUserDescription();
        } else if (R.id.read_dp_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointCharacteristicUserDescription(1);
        } else if (R.id.write_dp_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_dp_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_dp_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointValidRange();
        } else if (R.id.read_dp_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointValidRange(1);
        }
    }

    private void onElevation(MenuItem item) {
        if (R.id.read_elevation_count == item.getItemId()) {
            addRow("getElevationCount", mEnvironmentalSensingProfile.getElevationCount());
        } else if (R.id.is_elevation_notificatable_0 == item.getItemId()) {
            addRow("isElevationNotificatable", mEnvironmentalSensingProfile.isElevationNotificatable());
        } else if (R.id.is_elevation_notificatable_1 == item.getItemId()) {
            addRow("isElevationNotificatable_1", mEnvironmentalSensingProfile.isElevationNotificatable(1));
        } else if (R.id.has_elevation_esm_0 == item.getItemId()) {
            addRow("hasElevationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasElevationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_elevation_esm_1 == item.getItemId()) {
            addRow("hasElevationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasElevationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_elevation_ests_count_0 == item.getItemId()) {
            addRow("getElevationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_elevation_ests_count_1 == item.getItemId()) {
            addRow("getElevationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_elevation_esc_0 == item.getItemId()) {
            addRow("hasElevationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasElevationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_elevation_esc_1 == item.getItemId()) {
            addRow("hasElevationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasElevationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_elevation_cud_0 == item.getItemId()) {
            addRow("hasElevationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasElevationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_elevation_cud_1 == item.getItemId()) {
            addRow("hasElevationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasElevationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_elevation_vr_0 == item.getItemId()) {
            addRow("hasElevationCharacteristicValidRange", mEnvironmentalSensingProfile.hasElevationCharacteristicValidRange());
        } else if (R.id.has_elevation_vr_1 == item.getItemId()) {
            addRow("hasElevationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasElevationCharacteristicValidRange(1));
        } else if (R.id.read_elevation_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevation();
        } else if (R.id.read_elevation_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevation(1);
        } else if (R.id.notify_elevation_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startElevationNotification();
        } else if (R.id.notify_elevation_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startElevationNotification(1);
        } else if (R.id.notify_elevation_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopElevationNotification();
        } else if (R.id.notify_elevation_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopElevationNotification(1);
        } else if (R.id.read_elevation_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationEnvironmentalSensingMeasurement();
        } else if (R.id.read_elevation_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_elevation_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_elevation_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_elevation_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_elevation_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setElevationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_elevation_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setElevationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_elevation_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setElevationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_elevation_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationEnvironmentalSensingConfiguration();
        } else if (R.id.read_elevation_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_elevation_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setElevationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_elevation_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setElevationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_elevation_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationCharacteristicUserDescription();
        } else if (R.id.read_elevation_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationCharacteristicUserDescription(1);
        } else if (R.id.write_elevation_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setElevationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_elevation_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setElevationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_elevation_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationValidRange();
        } else if (R.id.read_elevation_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getElevationValidRange(1);
        }
    }

    private void onGf(MenuItem item) {
        if (R.id.read_gf_count == item.getItemId()) {
            addRow("getGustFactorCount", mEnvironmentalSensingProfile.getGustFactorCount());
        } else if (R.id.is_gf_notificatable_0 == item.getItemId()) {
            addRow("isGustFactorNotificatable", mEnvironmentalSensingProfile.isGustFactorNotificatable());
        } else if (R.id.is_gf_notificatable_1 == item.getItemId()) {
            addRow("isGustFactorNotificatable_1", mEnvironmentalSensingProfile.isGustFactorNotificatable(1));
        } else if (R.id.has_gf_esm_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_gf_esm_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_gf_ests_count_0 == item.getItemId()) {
            addRow("getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_gf_ests_count_1 == item.getItemId()) {
            addRow("getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_gf_esc_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_gf_esc_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_gf_cud_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasGustFactorCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_gf_cud_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_gf_vr_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicValidRange", mEnvironmentalSensingProfile.hasGustFactorCharacteristicValidRange());
        } else if (R.id.has_gf_vr_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicValidRange(1));
        } else if (R.id.read_gf_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactor();
        } else if (R.id.read_gf_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactor(1);
        } else if (R.id.notify_gf_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startGustFactorNotification();
        } else if (R.id.notify_gf_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startGustFactorNotification(1);
        } else if (R.id.notify_gf_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopGustFactorNotification();
        } else if (R.id.notify_gf_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopGustFactorNotification(1);
        } else if (R.id.read_gf_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingMeasurement();
        } else if (R.id.read_gf_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_gf_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_gf_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_gf_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_gf_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_gf_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_gf_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_gf_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingConfiguration();
        } else if (R.id.read_gf_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_gf_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_gf_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_gf_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorCharacteristicUserDescription();
        } else if (R.id.read_gf_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorCharacteristicUserDescription(1);
        } else if (R.id.write_gf_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_gf_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_gf_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorValidRange();
        } else if (R.id.read_gf_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorValidRange(1);
        }
    }

    private void onHi(MenuItem item) {
        if (R.id.read_hi_count == item.getItemId()) {
            addRow("getHeatIndexCount", mEnvironmentalSensingProfile.getHeatIndexCount());
        } else if (R.id.is_hi_notificatable_0 == item.getItemId()) {
            addRow("isHeatIndexNotificatable", mEnvironmentalSensingProfile.isHeatIndexNotificatable());
        } else if (R.id.is_hi_notificatable_1 == item.getItemId()) {
            addRow("isHeatIndexNotificatable_1", mEnvironmentalSensingProfile.isHeatIndexNotificatable(1));
        } else if (R.id.has_hi_esm_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_hi_esm_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_hi_ests_count_0 == item.getItemId()) {
            addRow("getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_hi_ests_count_1 == item.getItemId()) {
            addRow("getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_hi_esc_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_hi_esc_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_hi_cud_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_hi_cud_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_hi_vr_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicValidRange", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicValidRange());
        } else if (R.id.has_hi_vr_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicValidRange(1));
        } else if (R.id.read_hi_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndex();
        } else if (R.id.read_hi_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndex(1);
        } else if (R.id.notify_hi_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startHeatIndexNotification();
        } else if (R.id.notify_hi_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startHeatIndexNotification(1);
        } else if (R.id.notify_hi_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopHeatIndexNotification();
        } else if (R.id.notify_hi_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopHeatIndexNotification(1);
        } else if (R.id.read_hi_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingMeasurement();
        } else if (R.id.read_hi_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_hi_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_hi_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_hi_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_hi_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_hi_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_hi_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_hi_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingConfiguration();
        } else if (R.id.read_hi_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_hi_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_hi_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_hi_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexCharacteristicUserDescription();
        } else if (R.id.read_hi_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexCharacteristicUserDescription(1);
        } else if (R.id.write_hi_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_hi_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_hi_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexValidRange();
        } else if (R.id.read_hi_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexValidRange(1);
        }
    }

    private void onHumidity(MenuItem item) {
        if (R.id.read_humidity_count == item.getItemId()) {
            addRow("getHumidityCount", mEnvironmentalSensingProfile.getHumidityCount());
        } else if (R.id.is_humidity_notificatable_0 == item.getItemId()) {
            addRow("isHumidityNotificatable", mEnvironmentalSensingProfile.isHumidityNotificatable());
        } else if (R.id.is_humidity_notificatable_1 == item.getItemId()) {
            addRow("isHumidityNotificatable_1", mEnvironmentalSensingProfile.isHumidityNotificatable(1));
        } else if (R.id.has_humidity_esm_0 == item.getItemId()) {
            addRow("hasHumidityCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasHumidityCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_humidity_esm_1 == item.getItemId()) {
            addRow("hasHumidityCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasHumidityCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_humidity_ests_count_0 == item.getItemId()) {
            addRow("getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_humidity_ests_count_1 == item.getItemId()) {
            addRow("getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_humidity_esc_0 == item.getItemId()) {
            addRow("hasHumidityCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasHumidityCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_humidity_esc_1 == item.getItemId()) {
            addRow("hasHumidityCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasHumidityCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_humidity_cud_0 == item.getItemId()) {
            addRow("hasHumidityCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasHumidityCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_humidity_cud_1 == item.getItemId()) {
            addRow("hasHumidityCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasHumidityCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_humidity_vr_0 == item.getItemId()) {
            addRow("hasHumidityCharacteristicValidRange", mEnvironmentalSensingProfile.hasHumidityCharacteristicValidRange());
        } else if (R.id.has_humidity_vr_1 == item.getItemId()) {
            addRow("hasHumidityCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasHumidityCharacteristicValidRange(1));
        } else if (R.id.read_humidity_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidity();
        } else if (R.id.read_humidity_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidity(1);
        } else if (R.id.notify_humidity_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startHumidityNotification();
        } else if (R.id.notify_humidity_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startHumidityNotification(1);
        } else if (R.id.notify_humidity_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopHumidityNotification();
        } else if (R.id.notify_humidity_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopHumidityNotification(1);
        } else if (R.id.read_humidity_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityEnvironmentalSensingMeasurement();
        } else if (R.id.read_humidity_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_humidity_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_humidity_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_humidity_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_humidity_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHumidityEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_humidity_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHumidityEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_humidity_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHumidityEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_humidity_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityEnvironmentalSensingConfiguration();
        } else if (R.id.read_humidity_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_humidity_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHumidityEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_humidity_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHumidityEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_humidity_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityCharacteristicUserDescription();
        } else if (R.id.read_humidity_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityCharacteristicUserDescription(1);
        } else if (R.id.write_humidity_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHumidityCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_humidity_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHumidityCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_humidity_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityValidRange();
        } else if (R.id.read_humidity_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHumidityValidRange(1);
        }
    }

    private void onIrradiance(MenuItem item) {
        if (R.id.read_irradiance_count == item.getItemId()) {
            addRow("getIrradianceCount", mEnvironmentalSensingProfile.getIrradianceCount());
        } else if (R.id.is_irradiance_notificatable_0 == item.getItemId()) {
            addRow("isIrradianceNotificatable", mEnvironmentalSensingProfile.isIrradianceNotificatable());
        } else if (R.id.is_irradiance_notificatable_1 == item.getItemId()) {
            addRow("isIrradianceNotificatable_1", mEnvironmentalSensingProfile.isIrradianceNotificatable(1));
        } else if (R.id.has_irradiance_esm_0 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_irradiance_esm_1 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_irradiance_ests_count_0 == item.getItemId()) {
            addRow("getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_irradiance_ests_count_1 == item.getItemId()) {
            addRow("getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_irradiance_esc_0 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_irradiance_esc_1 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasIrradianceCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_irradiance_cud_0 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasIrradianceCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_irradiance_cud_1 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasIrradianceCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_irradiance_vr_0 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicValidRange", mEnvironmentalSensingProfile.hasIrradianceCharacteristicValidRange());
        } else if (R.id.has_irradiance_vr_1 == item.getItemId()) {
            addRow("hasIrradianceCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasIrradianceCharacteristicValidRange(1));
        } else if (R.id.read_irradiance_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradiance();
        } else if (R.id.read_irradiance_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradiance(1);
        } else if (R.id.notify_irradiance_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startIrradianceNotification();
        } else if (R.id.notify_irradiance_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startIrradianceNotification(1);
        } else if (R.id.notify_irradiance_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopIrradianceNotification();
        } else if (R.id.notify_irradiance_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopIrradianceNotification(1);
        } else if (R.id.read_irradiance_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceEnvironmentalSensingMeasurement();
        } else if (R.id.read_irradiance_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_irradiance_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_irradiance_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_irradiance_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_irradiance_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setIrradianceEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_irradiance_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setIrradianceEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_irradiance_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setIrradianceEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_irradiance_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceEnvironmentalSensingConfiguration();
        } else if (R.id.read_irradiance_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_irradiance_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setIrradianceEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_irradiance_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setIrradianceEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_irradiance_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceCharacteristicUserDescription();
        } else if (R.id.read_irradiance_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceCharacteristicUserDescription(1);
        } else if (R.id.write_irradiance_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setIrradianceCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_irradiance_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setIrradianceCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_irradiance_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceValidRange();
        } else if (R.id.read_irradiance_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getIrradianceValidRange(1);
        }
    }

    private void onPc(MenuItem item) {
        if (R.id.read_pc_count == item.getItemId()) {
            addRow("getPollenConcentrationCount", mEnvironmentalSensingProfile.getPollenConcentrationCount());
        } else if (R.id.is_pc_notificatable_0 == item.getItemId()) {
            addRow("isPollenConcentrationNotificatable", mEnvironmentalSensingProfile.isPollenConcentrationNotificatable());
        } else if (R.id.is_pc_notificatable_1 == item.getItemId()) {
            addRow("isPollenConcentrationNotificatable_1", mEnvironmentalSensingProfile.isPollenConcentrationNotificatable(1));
        } else if (R.id.has_pc_esm_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_pc_esm_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_pc_ests_count_0 == item.getItemId()) {
            addRow("getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_pc_ests_count_1 == item.getItemId()) {
            addRow("getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_pc_esc_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_pc_esc_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_pc_cud_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_pc_cud_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_pc_vr_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicValidRange());
        } else if (R.id.has_pc_vr_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_pc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentration();
        } else if (R.id.read_pc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentration(1);
        } else if (R.id.notify_pc_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startPollenConcentrationNotification();
        } else if (R.id.notify_pc_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startPollenConcentrationNotification(1);
        } else if (R.id.notify_pc_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopPollenConcentrationNotification();
        } else if (R.id.notify_pc_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopPollenConcentrationNotification(1);
        } else if (R.id.read_pc_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_pc_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_pc_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_pc_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_pc_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_pc_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_pc_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_pc_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_pc_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_pc_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_pc_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_pc_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_pc_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicUserDescription();
        } else if (R.id.read_pc_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_pc_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_pc_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_pc_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationValidRange();
        } else if (R.id.read_pc_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationValidRange(1);
        }
    }

    private void onRainfall(MenuItem item) {
        if (R.id.read_rainfall_count == item.getItemId()) {
            addRow("getRainfallCount", mEnvironmentalSensingProfile.getRainfallCount());
        } else if (R.id.is_rainfall_notificatable_0 == item.getItemId()) {
            addRow("isRainfallNotificatable", mEnvironmentalSensingProfile.isRainfallNotificatable());
        } else if (R.id.is_rainfall_notificatable_1 == item.getItemId()) {
            addRow("isRainfallNotificatable_1", mEnvironmentalSensingProfile.isRainfallNotificatable(1));
        } else if (R.id.has_rainfall_esm_0 == item.getItemId()) {
            addRow("hasRainfallCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasRainfallCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_rainfall_esm_1 == item.getItemId()) {
            addRow("hasRainfallCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasRainfallCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_rainfall_ests_count_0 == item.getItemId()) {
            addRow("getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_rainfall_ests_count_1 == item.getItemId()) {
            addRow("getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_rainfall_esc_0 == item.getItemId()) {
            addRow("hasRainfallCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasRainfallCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_rainfall_esc_1 == item.getItemId()) {
            addRow("hasRainfallCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasRainfallCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_rainfall_cud_0 == item.getItemId()) {
            addRow("hasRainfallCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasRainfallCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_rainfall_cud_1 == item.getItemId()) {
            addRow("hasRainfallCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasRainfallCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_rainfall_vr_0 == item.getItemId()) {
            addRow("hasRainfallCharacteristicValidRange", mEnvironmentalSensingProfile.hasRainfallCharacteristicValidRange());
        } else if (R.id.has_rainfall_vr_1 == item.getItemId()) {
            addRow("hasRainfallCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasRainfallCharacteristicValidRange(1));
        } else if (R.id.read_rainfall_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfall();
        } else if (R.id.read_rainfall_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfall(1);
        } else if (R.id.notify_rainfall_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startRainfallNotification();
        } else if (R.id.notify_rainfall_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startRainfallNotification(1);
        } else if (R.id.notify_rainfall_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopRainfallNotification();
        } else if (R.id.notify_rainfall_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopRainfallNotification(1);
        } else if (R.id.read_rainfall_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallEnvironmentalSensingMeasurement();
        } else if (R.id.read_rainfall_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_rainfall_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_rainfall_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_rainfall_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_rainfall_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setRainfallEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_rainfall_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setRainfallEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_rainfall_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setRainfallEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_rainfall_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallEnvironmentalSensingConfiguration();
        } else if (R.id.read_rainfall_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_rainfall_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setRainfallEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_rainfall_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setRainfallEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_rainfall_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallCharacteristicUserDescription();
        } else if (R.id.read_rainfall_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallCharacteristicUserDescription(1);
        } else if (R.id.write_rainfall_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setRainfallCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_rainfall_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setRainfallCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_rainfall_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallValidRange();
        } else if (R.id.read_rainfall_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getRainfallValidRange(1);
        }
    }

    private void onPressure(MenuItem item) {
        if (R.id.read_pressure_count == item.getItemId()) {
            addRow("getPressureCount", mEnvironmentalSensingProfile.getPressureCount());
        } else if (R.id.is_pressure_notificatable_0 == item.getItemId()) {
            addRow("isPressureNotificatable", mEnvironmentalSensingProfile.isPressureNotificatable());
        } else if (R.id.is_pressure_notificatable_1 == item.getItemId()) {
            addRow("isPressureNotificatable_1", mEnvironmentalSensingProfile.isPressureNotificatable(1));
        } else if (R.id.has_pressure_esm_0 == item.getItemId()) {
            addRow("hasPressureCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasPressureCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_pressure_esm_1 == item.getItemId()) {
            addRow("hasPressureCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasPressureCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_pressure_ests_count_0 == item.getItemId()) {
            addRow("getPressureCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_pressure_ests_count_1 == item.getItemId()) {
            addRow("getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_pressure_esc_0 == item.getItemId()) {
            addRow("hasPressureCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasPressureCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_pressure_esc_1 == item.getItemId()) {
            addRow("hasPressureCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasPressureCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_pressure_cud_0 == item.getItemId()) {
            addRow("hasPressureCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasPressureCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_pressure_cud_1 == item.getItemId()) {
            addRow("hasPressureCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasPressureCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_pressure_vr_0 == item.getItemId()) {
            addRow("hasPressureCharacteristicValidRange", mEnvironmentalSensingProfile.hasPressureCharacteristicValidRange());
        } else if (R.id.has_pressure_vr_1 == item.getItemId()) {
            addRow("hasPressureCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasPressureCharacteristicValidRange(1));
        } else if (R.id.read_pressure_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressure();
        } else if (R.id.read_pressure_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressure(1);
        } else if (R.id.notify_pressure_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startPressureNotification();
        } else if (R.id.notify_pressure_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startPressureNotification(1);
        } else if (R.id.notify_pressure_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopPressureNotification();
        } else if (R.id.notify_pressure_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopPressureNotification(1);
        } else if (R.id.read_pressure_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureEnvironmentalSensingMeasurement();
        } else if (R.id.read_pressure_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_pressure_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_pressure_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_pressure_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_pressure_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPressureEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_pressure_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPressureEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_pressure_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPressureEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_pressure_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureEnvironmentalSensingConfiguration();
        } else if (R.id.read_pressure_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_pressure_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPressureEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_pressure_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPressureEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_pressure_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureCharacteristicUserDescription();
        } else if (R.id.read_pressure_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureCharacteristicUserDescription(1);
        } else if (R.id.write_pressure_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPressureCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_pressure_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPressureCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_pressure_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureValidRange();
        } else if (R.id.read_pressure_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPressureValidRange(1);
        }
    }

    private void onTemperature(MenuItem item) {
        if (R.id.read_temperature_count == item.getItemId()) {
            addRow("getTemperatureCount", mEnvironmentalSensingProfile.getTemperatureCount());
        } else if (R.id.is_temperature_notificatable_0 == item.getItemId()) {
            addRow("isTemperatureNotificatable", mEnvironmentalSensingProfile.isTemperatureNotificatable());
        } else if (R.id.is_temperature_notificatable_1 == item.getItemId()) {
            addRow("isTemperatureNotificatable_1", mEnvironmentalSensingProfile.isTemperatureNotificatable(1));
        } else if (R.id.has_temperature_esm_0 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasTemperatureCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_temperature_esm_1 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasTemperatureCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_temperature_ests_count_0 == item.getItemId()) {
            addRow("getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_temperature_ests_count_1 == item.getItemId()) {
            addRow("getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_temperature_esc_0 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasTemperatureCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_temperature_esc_1 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasTemperatureCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_temperature_cud_0 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasTemperatureCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_temperature_cud_1 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasTemperatureCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_temperature_vr_0 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicValidRange", mEnvironmentalSensingProfile.hasTemperatureCharacteristicValidRange());
        } else if (R.id.has_temperature_vr_1 == item.getItemId()) {
            addRow("hasTemperatureCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasTemperatureCharacteristicValidRange(1));
        } else if (R.id.read_temperature_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperature();
        } else if (R.id.read_temperature_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperature(1);
        } else if (R.id.notify_temperature_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTemperatureNotification();
        } else if (R.id.notify_temperature_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTemperatureNotification(1);
        } else if (R.id.notify_temperature_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTemperatureNotification();
        } else if (R.id.notify_temperature_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTemperatureNotification(1);
        } else if (R.id.read_temperature_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureEnvironmentalSensingMeasurement();
        } else if (R.id.read_temperature_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_temperature_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_temperature_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_temperature_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_temperature_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTemperatureEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_temperature_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTemperatureEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_temperature_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTemperatureEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_temperature_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureEnvironmentalSensingConfiguration();
        } else if (R.id.read_temperature_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_temperature_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTemperatureEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_temperature_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTemperatureEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_temperature_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureCharacteristicUserDescription();
        } else if (R.id.read_temperature_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureCharacteristicUserDescription(1);
        } else if (R.id.write_temperature_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTemperatureCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_temperature_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTemperatureCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_temperature_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureValidRange();
        } else if (R.id.read_temperature_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTemperatureValidRange(1);
        }
    }

    private void onTwd(MenuItem item) {
        if (R.id.read_twd_count == item.getItemId()) {
            addRow("getTrueWindDirectionCount", mEnvironmentalSensingProfile.getTrueWindDirectionCount());
        } else if (R.id.is_twd_notificatable_0 == item.getItemId()) {
            addRow("isTrueWindDirectionNotificatable", mEnvironmentalSensingProfile.isTrueWindDirectionNotificatable());
        } else if (R.id.is_twd_notificatable_1 == item.getItemId()) {
            addRow("isTrueWindDirectionNotificatable_1", mEnvironmentalSensingProfile.isTrueWindDirectionNotificatable(1));
        } else if (R.id.has_twd_esm_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_twd_esm_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_twd_ests_count_0 == item.getItemId()) {
            addRow("getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_twd_ests_count_1 == item.getItemId()) {
            addRow("getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_twd_esc_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_twd_esc_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_twd_cud_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_twd_cud_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_twd_vr_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicValidRange", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange());
        } else if (R.id.has_twd_vr_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange(1));
        } else if (R.id.read_twd_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirection();
        } else if (R.id.read_twd_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirection(1);
        } else if (R.id.notify_twd_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindDirectionNotification();
        } else if (R.id.notify_twd_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindDirectionNotification(1);
        } else if (R.id.notify_twd_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindDirectionNotification();
        } else if (R.id.notify_twd_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindDirectionNotification(1);
        } else if (R.id.read_twd_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement();
        } else if (R.id.read_twd_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_twd_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_twd_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_twd_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_twd_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_twd_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_twd_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_twd_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration();
        } else if (R.id.read_twd_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_twd_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_twd_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_twd_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription();
        } else if (R.id.read_twd_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription(1);
        } else if (R.id.write_twd_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_twd_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_twd_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionValidRange();
        } else if (R.id.read_twd_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionValidRange(1);
        }
    }

    private void onTws(MenuItem item) {
        if (R.id.read_tws_count == item.getItemId()) {
            addRow("getTrueWindSpeedCount", mEnvironmentalSensingProfile.getTrueWindSpeedCount());
        } else if (R.id.is_tws_notificatable_0 == item.getItemId()) {
            addRow("isTrueWindSpeedNotificatable", mEnvironmentalSensingProfile.isTrueWindSpeedNotificatable());
        } else if (R.id.is_tws_notificatable_1 == item.getItemId()) {
            addRow("isTrueWindSpeedNotificatable_1", mEnvironmentalSensingProfile.isTrueWindSpeedNotificatable(1));
        } else if (R.id.has_tws_esm_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_tws_esm_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_tws_ests_count_0 == item.getItemId()) {
            addRow("getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_tws_ests_count_1 == item.getItemId()) {
            addRow("getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_tws_esc_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_tws_esc_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_tws_cud_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_tws_cud_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_tws_vr_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicValidRange", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicValidRange());
        } else if (R.id.has_tws_vr_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicValidRange(1));
        } else if (R.id.read_tws_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeed();
        } else if (R.id.read_tws_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeed(1);
        } else if (R.id.notify_tws_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindSpeedNotification();
        } else if (R.id.notify_tws_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindSpeedNotification(1);
        } else if (R.id.notify_tws_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindSpeedNotification();
        } else if (R.id.notify_tws_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindSpeedNotification(1);
        } else if (R.id.read_tws_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingMeasurement();
        } else if (R.id.read_tws_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_tws_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_tws_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_tws_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_tws_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_tws_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_tws_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_tws_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingConfiguration();
        } else if (R.id.read_tws_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_tws_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_tws_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_tws_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicUserDescription();
        } else if (R.id.read_tws_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicUserDescription(1);
        } else if (R.id.write_tws_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_tws_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_tws_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedValidRange();
        } else if (R.id.read_tws_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedValidRange(1);
        }
    }

    private void onUvi(MenuItem item) {
        if (R.id.read_uvi_count == item.getItemId()) {
            addRow("getUVIndexCount", mEnvironmentalSensingProfile.getUVIndexCount());
        } else if (R.id.is_uvi_notificatable_0 == item.getItemId()) {
            addRow("isUVIndexNotificatable", mEnvironmentalSensingProfile.isUVIndexNotificatable());
        } else if (R.id.is_uvi_notificatable_1 == item.getItemId()) {
            addRow("isUVIndexNotificatable_1", mEnvironmentalSensingProfile.isUVIndexNotificatable(1));
        } else if (R.id.has_uvi_esm_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_uvi_esm_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_uvi_ests_count_0 == item.getItemId()) {
            addRow("getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_uvi_ests_count_1 == item.getItemId()) {
            addRow("getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_uvi_esc_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_uvi_esc_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_uvi_cud_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasUVIndexCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_uvi_cud_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_uvi_vr_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicValidRange", mEnvironmentalSensingProfile.hasUVIndexCharacteristicValidRange());
        } else if (R.id.has_uvi_vr_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicValidRange(1));
        } else if (R.id.read_uvi_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndex();
        } else if (R.id.read_uvi_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndex(1);
        } else if (R.id.notify_uvi_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startUVIndexNotification();
        } else if (R.id.notify_uvi_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startUVIndexNotification(1);
        } else if (R.id.notify_uvi_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopUVIndexNotification();
        } else if (R.id.notify_uvi_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopUVIndexNotification(1);
        } else if (R.id.read_uvi_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingMeasurement();
        } else if (R.id.read_uvi_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_uvi_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_uvi_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_uvi_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_uvi_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_uvi_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_uvi_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_uvi_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingConfiguration();
        } else if (R.id.read_uvi_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_uvi_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_uvi_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_uvi_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexCharacteristicUserDescription();
        } else if (R.id.read_uvi_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexCharacteristicUserDescription(1);
        } else if (R.id.write_uvi_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_uvi_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_uvi_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexValidRange();
        } else if (R.id.read_uvi_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexValidRange(1);
        }
    }

    private void onWc(MenuItem item) {
        if (R.id.read_wc_count == item.getItemId()) {
            addRow("getWindChillCount", mEnvironmentalSensingProfile.getWindChillCount());
        } else if (R.id.is_wc_notificatable_0 == item.getItemId()) {
            addRow("isWindChillNotificatable", mEnvironmentalSensingProfile.isWindChillNotificatable());
        } else if (R.id.is_wc_notificatable_1 == item.getItemId()) {
            addRow("isWindChillNotificatable_1", mEnvironmentalSensingProfile.isWindChillNotificatable(1));
        } else if (R.id.has_wc_esm_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_wc_esm_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_wc_ests_count_0 == item.getItemId()) {
            addRow("getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_wc_ests_count_1 == item.getItemId()) {
            addRow("getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_wc_esc_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_wc_esc_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_wc_cud_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasWindChillCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_wc_cud_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_wc_vr_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicValidRange", mEnvironmentalSensingProfile.hasWindChillCharacteristicValidRange());
        } else if (R.id.has_wc_vr_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicValidRange(1));
        } else if (R.id.read_wc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChill();
        } else if (R.id.read_wc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChill(1);
        } else if (R.id.notify_wc_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startWindChillNotification();
        } else if (R.id.notify_wc_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startWindChillNotification(1);
        } else if (R.id.notify_wc_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopWindChillNotification();
        } else if (R.id.notify_wc_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopWindChillNotification(1);
        } else if (R.id.read_wc_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingMeasurement();
        } else if (R.id.read_wc_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_wc_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_wc_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_wc_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_wc_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_wc_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_wc_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_wc_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingConfiguration();
        } else if (R.id.read_wc_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_wc_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_wc_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_wc_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillCharacteristicUserDescription();
        } else if (R.id.read_wc_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillCharacteristicUserDescription(1);
        } else if (R.id.write_wc_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_wc_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_wc_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillValidRange();
        } else if (R.id.read_wc_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillValidRange(1);
        }
    }

    private void onBpt(MenuItem item) {
        if (R.id.read_bpt_count == item.getItemId()) {
            addRow("getBarometricPressureTrendCount", mEnvironmentalSensingProfile.getBarometricPressureTrendCount());
        } else if (R.id.is_bpt_notificatable_0 == item.getItemId()) {
            addRow("isBarometricPressureTrendNotificatable", mEnvironmentalSensingProfile.isBarometricPressureTrendNotificatable());
        } else if (R.id.is_bpt_notificatable_1 == item.getItemId()) {
            addRow("isBarometricPressureTrendNotificatable_1", mEnvironmentalSensingProfile.isBarometricPressureTrendNotificatable(1));
        } else if (R.id.has_bpt_esm_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_bpt_esm_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_bpt_ests_count_0 == item.getItemId()) {
            addRow("getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_bpt_ests_count_1 == item.getItemId()) {
            addRow("getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_bpt_esc_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_bpt_esc_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_bpt_cud_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_bpt_cud_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_bpt_vr_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicValidRange", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicValidRange());
        } else if (R.id.has_bpt_vr_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicValidRange(1));
        } else if (R.id.read_bpt_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrend();
        } else if (R.id.read_bpt_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrend(1);
        } else if (R.id.notify_bpt_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startBarometricPressureTrendNotification();
        } else if (R.id.notify_bpt_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startBarometricPressureTrendNotification(1);
        } else if (R.id.notify_bpt_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopBarometricPressureTrendNotification();
        } else if (R.id.notify_bpt_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopBarometricPressureTrendNotification(1);
        } else if (R.id.read_bpt_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingMeasurement();
        } else if (R.id.read_bpt_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_bpt_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_bpt_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_bpt_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_bpt_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_bpt_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_bpt_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_bpt_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingConfiguration();
        } else if (R.id.read_bpt_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_bpt_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_bpt_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_bpt_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicUserDescription();
        } else if (R.id.read_bpt_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicUserDescription(1);
        } else if (R.id.write_bpt_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_bpt_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_bpt_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendValidRange();
        } else if (R.id.read_bpt_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendValidRange(1);
        }
    }

    private void onMd(MenuItem item) {
        if (R.id.read_md_count == item.getItemId()) {
            addRow("getMagneticDeclinationCount", mEnvironmentalSensingProfile.getMagneticDeclinationCount());
        } else if (R.id.is_md_notificatable_0 == item.getItemId()) {
            addRow("isMagneticDeclinationNotificatable", mEnvironmentalSensingProfile.isMagneticDeclinationNotificatable());
        } else if (R.id.is_md_notificatable_1 == item.getItemId()) {
            addRow("isMagneticDeclinationNotificatable_1", mEnvironmentalSensingProfile.isMagneticDeclinationNotificatable(1));
        } else if (R.id.has_md_esm_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_md_esm_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_md_ests_count_0 == item.getItemId()) {
            addRow("getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_md_ests_count_1 == item.getItemId()) {
            addRow("getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_md_esc_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_md_esc_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_md_cud_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_md_cud_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_md_vr_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicValidRange", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicValidRange());
        } else if (R.id.has_md_vr_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicValidRange(1));
        } else if (R.id.read_md_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclination();
        } else if (R.id.read_md_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclination(1);
        } else if (R.id.notify_md_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticDeclinationNotification();
        } else if (R.id.notify_md_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticDeclinationNotification(1);
        } else if (R.id.notify_md_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticDeclinationNotification();
        } else if (R.id.notify_md_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticDeclinationNotification(1);
        } else if (R.id.read_md_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingMeasurement();
        } else if (R.id.read_md_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_md_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_md_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_md_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_md_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_md_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_md_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_md_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingConfiguration();
        } else if (R.id.read_md_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_md_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_md_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_md_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicUserDescription();
        } else if (R.id.read_md_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicUserDescription(1);
        } else if (R.id.write_md_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_md_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_md_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationValidRange();
        } else if (R.id.read_md_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationValidRange(1);
        }
    }

    private void onMfd2d(MenuItem item) {
        if (R.id.read_mfd2d_count == item.getItemId()) {
            addRow("getMagneticFluxDensity2DCount", mEnvironmentalSensingProfile.getMagneticFluxDensity2DCount());
        } else if (R.id.is_mfd2d_notificatable_0 == item.getItemId()) {
            addRow("isMagneticFluxDensity2DNotificatable", mEnvironmentalSensingProfile.isMagneticFluxDensity2DNotificatable());
        } else if (R.id.is_mfd2d_notificatable_1 == item.getItemId()) {
            addRow("isMagneticFluxDensity2DNotificatable_1", mEnvironmentalSensingProfile.isMagneticFluxDensity2DNotificatable(1));
        } else if (R.id.has_mfd2d_esm_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_mfd2d_esm_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_mfd2d_ests_count_0 == item.getItemId()) {
            addRow("getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_mfd2d_ests_count_1 == item.getItemId()) {
            addRow("getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_mfd2d_esc_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_mfd2d_esc_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_mfd2d_cud_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_mfd2d_cud_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_mfd2d_vr_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicValidRange", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicValidRange());
        } else if (R.id.has_mfd2d_vr_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicValidRange(1));
        } else if (R.id.read_mfd2d_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2D();
        } else if (R.id.read_mfd2d_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2D(1);
        } else if (R.id.notify_mfd2d_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity2DNotification();
        } else if (R.id.notify_mfd2d_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity2DNotification(1);
        } else if (R.id.notify_mfd2d_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity2DNotification();
        } else if (R.id.notify_mfd2d_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity2DNotification(1);
        } else if (R.id.read_mfd2d_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingMeasurement();
        } else if (R.id.read_mfd2d_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_mfd2d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_mfd2d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_mfd2d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_mfd2d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_mfd2d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_mfd2d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_mfd2d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingConfiguration();
        } else if (R.id.read_mfd2d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_mfd2d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_mfd2d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_mfd2d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicUserDescription();
        } else if (R.id.read_mfd2d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicUserDescription(1);
        } else if (R.id.write_mfd2d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_mfd2d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_mfd2d_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DValidRange();
        } else if (R.id.read_mfd2d_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DValidRange(1);
        }
    }

    private void onMfd3d(MenuItem item) {
        if (R.id.read_mfd3d_count == item.getItemId()) {
            addRow("getMagneticFluxDensity3DCount", mEnvironmentalSensingProfile.getMagneticFluxDensity3DCount());
        } else if (R.id.is_mfd3d_notificatable_0 == item.getItemId()) {
            addRow("isMagneticFluxDensity3DNotificatable", mEnvironmentalSensingProfile.isMagneticFluxDensity3DNotificatable());
        } else if (R.id.is_mfd3d_notificatable_1 == item.getItemId()) {
            addRow("isMagneticFluxDensity3DNotificatable_1", mEnvironmentalSensingProfile.isMagneticFluxDensity3DNotificatable(1));
        } else if (R.id.has_mfd3d_esm_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_mfd3d_esm_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_mfd3d_ests_count_0 == item.getItemId()) {
            addRow("getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_mfd3d_ests_count_1 == item.getItemId()) {
            addRow("getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_mfd3d_esc_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_mfd3d_esc_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_mfd3d_cud_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_mfd3d_cud_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_mfd3d_vr_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicValidRange", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicValidRange());
        } else if (R.id.has_mfd3d_vr_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicValidRange(1));
        } else if (R.id.read_mfd3d_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3D();
        } else if (R.id.read_mfd3d_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3D(1);
        } else if (R.id.notify_mfd3d_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity3DNotification();
        } else if (R.id.notify_mfd3d_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity3DNotification(1);
        } else if (R.id.notify_mfd3d_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity3DNotification();
        } else if (R.id.notify_mfd3d_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity3DNotification(1);
        } else if (R.id.read_mfd3d_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingMeasurement();
        } else if (R.id.read_mfd3d_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_mfd3d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_mfd3d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_mfd3d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_mfd3d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_mfd3d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_mfd3d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_mfd3d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingConfiguration();
        } else if (R.id.read_mfd3d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_mfd3d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_mfd3d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_mfd3d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicUserDescription();
        } else if (R.id.read_mfd3d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicUserDescription(1);
        } else if (R.id.write_mfd3d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_mfd3d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_mfd3d_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DValidRange();
        } else if (R.id.read_mfd3d_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DValidRange(1);
        }
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else {
            mConnectDisconnectButton.setVisibility(View.VISIBLE);
            if (mEnvironmentalSensingProfile.isConnected()) {
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
            if (mEnvironmentalSensingProfile == null) {
                mEnvironmentalSensingProfile = new EnvironmentalSensingProfile(this, mEspCallbackSample);
                mEnvironmentalSensingProfile.start();
            }
            if (mEnvironmentalSensingProfile.isConnected()) {
                mEnvironmentalSensingProfile.disconnect();
                mEnvironmentalSensingProfile.onBLEDisconnected(Integer.MIN_VALUE, mBluetoothDevice, STATUS_MANUAL_DISCONNECT, null);
                mBluetoothDevice = null;
            } else {
                if (mBluetoothDevice == null) {
                    mEnvironmentalSensingProfile.findDevices(null);
                } else {
                    if (BluetoothDevice.BOND_BONDED == mBluetoothDevice.getBondState()) {
                        mEnvironmentalSensingProfile.connect(mBluetoothDevice);
                    } else {
                        mEnvironmentalSensingProfile.bondDevice(mBluetoothDevice, BondTask.TIMEOUT_MILLIS, null);
                    }
                }
            }
            updateLayout();
        } else {
            super.onClick(v);
        }
    }

    @Override
    public void onCallback(final Pair<String, String> log) {
        runOnUiThread(() -> {
            mAdapter.add(log);
            mListView.smoothScrollToPosition(mAdapter.getCount());

            updateLayout();
        });
    }

}
