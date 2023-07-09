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
        boolean visibility = true;
        menu.setGroupVisible(R.id.ammonia_concentration, visibility);
        menu.setGroupVisible(R.id.apparent_wind_direction, visibility);
        menu.setGroupVisible(R.id.apparent_wind_speed, visibility);
        menu.setGroupVisible(R.id.barometric_pressure_trend, visibility);
        menu.setGroupVisible(R.id.carbon_monoxide_concentration, visibility);
        menu.setGroupVisible(R.id.dew_point, visibility);
        menu.setGroupVisible(R.id.elevation, visibility);
        menu.setGroupVisible(R.id.gust_factor, visibility);
        menu.setGroupVisible(R.id.heat_index, visibility);
        menu.setGroupVisible(R.id.humidity, visibility);
        menu.setGroupVisible(R.id.irradiance, visibility);
        menu.setGroupVisible(R.id.magnetic_declination, visibility);
        menu.setGroupVisible(R.id.magnetic_flux_density_2d, visibility);
        menu.setGroupVisible(R.id.magnetic_flux_density_3d, visibility);
        menu.setGroupVisible(R.id.methane_concentration, visibility);
        menu.setGroupVisible(R.id.nitrogen_dioxide_concentration, visibility);
        menu.setGroupVisible(R.id.non_methane_volatile_organic_compounds_concentration, visibility);
        menu.setGroupVisible(R.id.ozone_concentration, visibility);
        menu.setGroupVisible(R.id.particulate_matter_pm10_concentration, visibility);
        menu.setGroupVisible(R.id.particulate_matter_pm1_concentration, visibility);
        menu.setGroupVisible(R.id.particulate_matter_pm2_5_concentration, visibility);
        menu.setGroupVisible(R.id.pollen_concentration, visibility);
        menu.setGroupVisible(R.id.pressure, visibility);
        menu.setGroupVisible(R.id.rainfall, visibility);
        menu.setGroupVisible(R.id.sulfur_dioxide_concentration, visibility);
        menu.setGroupVisible(R.id.sulfur_hexafluoride_concentration, visibility);
        menu.setGroupVisible(R.id.temperature, visibility);
        menu.setGroupVisible(R.id.true_wind_direction, visibility);
        menu.setGroupVisible(R.id.true_wind_speed, visibility);
        menu.setGroupVisible(R.id.uv_index, visibility);
        menu.setGroupVisible(R.id.wind_chill, visibility);
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
        onAmmoniaConcentration(item);
        onApparentWindDirection(item);
        onApparentWindSpeed(item);
        onBarometricPressureTrend(item);
        onCarbonMonoxideConcentration(item);
        onDewPoint(item);
        onElevation(item);
        onGustFactor(item);
        onHeatIndex(item);
        onHumidity(item);
        onIrradiance(item);
        onMagneticDeclination(item);
        onMagneticFluxDensity2D(item);
        onMagneticFluxDensity3D(item);
        onMethaneConcentration(item);
        onNitrogenDioxideConcentration(item);
        onNonMethaneVolatileOrganicCompoundsConcentration(item);
        onOzoneConcentration(item);
        onParticulateMatterPm10Concentration(item);
        onParticulateMatterPm1Concentration(item);
        onParticulateMatterPm25Concentration(item);
        onPollenConcentration(item);
        onPressure(item);
        onRainfall(item);
        onSulfurDioxideConcentration(item);
        onSulfurHexafluorideConcentration(item);
        onTemperature(item);
        onTrueWindDirection(item);
        onTrueWindSpeed(item);
        onUVIndex(item);
        onWindChill(item);
        return true;
    }

    private void onAmmoniaConcentration(MenuItem item) {
        if (R.id.read_ammonia_concentration_count == item.getItemId()) {
            addRow("getAmmoniaConcentrationCount", mEnvironmentalSensingProfile.getAmmoniaConcentrationCount());
        } else if (R.id.is_ammonia_concentration_notificatable_0 == item.getItemId()) {
            addRow("isAmmoniaConcentrationNotificatable", mEnvironmentalSensingProfile.isAmmoniaConcentrationNotificatable());
        } else if (R.id.is_ammonia_concentration_notificatable_1 == item.getItemId()) {
            addRow("isAmmoniaConcentrationNotificatable_1", mEnvironmentalSensingProfile.isAmmoniaConcentrationNotificatable(1));
        } else if (R.id.has_ammonia_concentration_esm_0 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_ammonia_concentration_esm_1 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_ammonia_concentration_ests_count_0 == item.getItemId()) {
            addRow("getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_ammonia_concentration_ests_count_1 == item.getItemId()) {
            addRow("getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_ammonia_concentration_esc_0 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_ammonia_concentration_esc_1 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_ammonia_concentration_cud_0 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_ammonia_concentration_cud_1 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_ammonia_concentration_vr_0 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicValidRange());
        } else if (R.id.has_ammonia_concentration_vr_1 == item.getItemId()) {
            addRow("hasAmmoniaConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasAmmoniaConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_ammonia_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentration();
        } else if (R.id.read_ammonia_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentration(1);
        } else if (R.id.notify_ammonia_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startAmmoniaConcentrationNotification();
        } else if (R.id.notify_ammonia_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startAmmoniaConcentrationNotification(1);
        } else if (R.id.notify_ammonia_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopAmmoniaConcentrationNotification();
        } else if (R.id.notify_ammonia_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopAmmoniaConcentrationNotification(1);
        } else if (R.id.read_ammonia_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_ammonia_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_ammonia_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_ammonia_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_ammonia_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_ammonia_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_ammonia_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_ammonia_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_ammonia_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_ammonia_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_ammonia_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setAmmoniaConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_ammonia_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setAmmoniaConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_ammonia_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationCharacteristicUserDescription();
        } else if (R.id.read_ammonia_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_ammonia_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setAmmoniaConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_ammonia_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setAmmoniaConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_ammonia_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationValidRange();
        } else if (R.id.read_ammonia_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getAmmoniaConcentrationValidRange(1);
        }
    }

    private void onApparentWindDirection(MenuItem item) {
        if (R.id.read_apparent_wind_direction_count == item.getItemId()) {
            addRow("getApparentWindDirectionCount", mEnvironmentalSensingProfile.getApparentWindDirectionCount());
        } else if (R.id.is_apparent_wind_direction_notificatable_0 == item.getItemId()) {
            addRow("isApparentWindDirectionNotificatable", mEnvironmentalSensingProfile.isApparentWindDirectionNotificatable());
        } else if (R.id.is_apparent_wind_direction_notificatable_1 == item.getItemId()) {
            addRow("isApparentWindDirectionNotificatable_1", mEnvironmentalSensingProfile.isApparentWindDirectionNotificatable(1));
        } else if (R.id.has_apparent_wind_direction_esm_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_apparent_wind_direction_esm_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_apparent_wind_direction_ests_count_0 == item.getItemId()) {
            addRow("getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_apparent_wind_direction_ests_count_1 == item.getItemId()) {
            addRow("getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_apparent_wind_direction_esc_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_apparent_wind_direction_esc_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_apparent_wind_direction_cud_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_apparent_wind_direction_cud_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_apparent_wind_direction_vr_0 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicValidRange", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicValidRange());
        } else if (R.id.has_apparent_wind_direction_vr_1 == item.getItemId()) {
            addRow("hasApparentWindDirectionCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasApparentWindDirectionCharacteristicValidRange(1));
        } else if (R.id.read_apparent_wind_direction_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirection();
        } else if (R.id.read_apparent_wind_direction_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirection(1);
        } else if (R.id.notify_apparent_wind_direction_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindDirectionNotification();
        } else if (R.id.notify_apparent_wind_direction_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindDirectionNotification(1);
        } else if (R.id.notify_apparent_wind_direction_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindDirectionNotification();
        } else if (R.id.notify_apparent_wind_direction_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindDirectionNotification(1);
        } else if (R.id.read_apparent_wind_direction_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingMeasurement();
        } else if (R.id.read_apparent_wind_direction_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_apparent_wind_direction_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_apparent_wind_direction_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_apparent_wind_direction_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_apparent_wind_direction_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_apparent_wind_direction_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_apparent_wind_direction_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_apparent_wind_direction_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingConfiguration();
        } else if (R.id.read_apparent_wind_direction_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_apparent_wind_direction_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_apparent_wind_direction_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_apparent_wind_direction_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicUserDescription();
        } else if (R.id.read_apparent_wind_direction_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionCharacteristicUserDescription(1);
        } else if (R.id.write_apparent_wind_direction_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_apparent_wind_direction_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindDirectionCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_apparent_wind_direction_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionValidRange();
        } else if (R.id.read_apparent_wind_direction_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindDirectionValidRange(1);
        }
    }

    private void onApparentWindSpeed(MenuItem item) {
        if (R.id.read_apparent_wind_speed_count == item.getItemId()) {
            addRow("getApparentWindSpeedCount", mEnvironmentalSensingProfile.getApparentWindSpeedCount());
        } else if (R.id.is_apparent_wind_speed_notificatable_0 == item.getItemId()) {
            addRow("isApparentWindSpeedNotificatable", mEnvironmentalSensingProfile.isApparentWindSpeedNotificatable());
        } else if (R.id.is_apparent_wind_speed_notificatable_1 == item.getItemId()) {
            addRow("isApparentWindSpeedNotificatable_1", mEnvironmentalSensingProfile.isApparentWindSpeedNotificatable(1));
        } else if (R.id.has_apparent_wind_speed_esm_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_apparent_wind_speed_esm_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_apparent_wind_speed_ests_count_0 == item.getItemId()) {
            addRow("getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_apparent_wind_speed_ests_count_1 == item.getItemId()) {
            addRow("getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_apparent_wind_speed_esc_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_apparent_wind_speed_esc_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_apparent_wind_speed_cud_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_apparent_wind_speed_cud_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_apparent_wind_speed_vr_0 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicValidRange", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicValidRange());
        } else if (R.id.has_apparent_wind_speed_vr_1 == item.getItemId()) {
            addRow("hasApparentWindSpeedCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasApparentWindSpeedCharacteristicValidRange(1));
        } else if (R.id.read_apparent_wind_speed_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeed();
        } else if (R.id.read_apparent_wind_speed_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeed(1);
        } else if (R.id.notify_apparent_wind_speed_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindSpeedNotification();
        } else if (R.id.notify_apparent_wind_speed_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startApparentWindSpeedNotification(1);
        } else if (R.id.notify_apparent_wind_speed_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindSpeedNotification();
        } else if (R.id.notify_apparent_wind_speed_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopApparentWindSpeedNotification(1);
        } else if (R.id.read_apparent_wind_speed_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingMeasurement();
        } else if (R.id.read_apparent_wind_speed_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_apparent_wind_speed_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_apparent_wind_speed_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_apparent_wind_speed_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_apparent_wind_speed_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_apparent_wind_speed_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_apparent_wind_speed_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_apparent_wind_speed_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingConfiguration();
        } else if (R.id.read_apparent_wind_speed_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_apparent_wind_speed_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_apparent_wind_speed_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_apparent_wind_speed_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicUserDescription();
        } else if (R.id.read_apparent_wind_speed_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedCharacteristicUserDescription(1);
        } else if (R.id.write_apparent_wind_speed_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_apparent_wind_speed_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setApparentWindSpeedCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_apparent_wind_speed_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedValidRange();
        } else if (R.id.read_apparent_wind_speed_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getApparentWindSpeedValidRange(1);
        }
    }

    private void onBarometricPressureTrend(MenuItem item) {
        if (R.id.read_barometric_pressure_trend_count == item.getItemId()) {
            addRow("getBarometricPressureTrendCount", mEnvironmentalSensingProfile.getBarometricPressureTrendCount());
        } else if (R.id.is_barometric_pressure_trend_notificatable_0 == item.getItemId()) {
            addRow("isBarometricPressureTrendNotificatable", mEnvironmentalSensingProfile.isBarometricPressureTrendNotificatable());
        } else if (R.id.is_barometric_pressure_trend_notificatable_1 == item.getItemId()) {
            addRow("isBarometricPressureTrendNotificatable_1", mEnvironmentalSensingProfile.isBarometricPressureTrendNotificatable(1));
        } else if (R.id.has_barometric_pressure_trend_esm_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_barometric_pressure_trend_esm_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_barometric_pressure_trend_ests_count_0 == item.getItemId()) {
            addRow("getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_barometric_pressure_trend_ests_count_1 == item.getItemId()) {
            addRow("getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_barometric_pressure_trend_esc_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_barometric_pressure_trend_esc_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_barometric_pressure_trend_cud_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_barometric_pressure_trend_cud_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_barometric_pressure_trend_vr_0 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicValidRange", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicValidRange());
        } else if (R.id.has_barometric_pressure_trend_vr_1 == item.getItemId()) {
            addRow("hasBarometricPressureTrendCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasBarometricPressureTrendCharacteristicValidRange(1));
        } else if (R.id.read_barometric_pressure_trend_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrend();
        } else if (R.id.read_barometric_pressure_trend_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrend(1);
        } else if (R.id.notify_barometric_pressure_trend_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startBarometricPressureTrendNotification();
        } else if (R.id.notify_barometric_pressure_trend_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startBarometricPressureTrendNotification(1);
        } else if (R.id.notify_barometric_pressure_trend_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopBarometricPressureTrendNotification();
        } else if (R.id.notify_barometric_pressure_trend_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopBarometricPressureTrendNotification(1);
        } else if (R.id.read_barometric_pressure_trend_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingMeasurement();
        } else if (R.id.read_barometric_pressure_trend_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_barometric_pressure_trend_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_barometric_pressure_trend_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_barometric_pressure_trend_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_barometric_pressure_trend_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_barometric_pressure_trend_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_barometric_pressure_trend_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_barometric_pressure_trend_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingConfiguration();
        } else if (R.id.read_barometric_pressure_trend_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_barometric_pressure_trend_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_barometric_pressure_trend_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_barometric_pressure_trend_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicUserDescription();
        } else if (R.id.read_barometric_pressure_trend_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendCharacteristicUserDescription(1);
        } else if (R.id.write_barometric_pressure_trend_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_barometric_pressure_trend_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setBarometricPressureTrendCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_barometric_pressure_trend_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendValidRange();
        } else if (R.id.read_barometric_pressure_trend_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getBarometricPressureTrendValidRange(1);
        }
    }

    private void onCarbonMonoxideConcentration(MenuItem item) {
        if (R.id.read_carbon_monoxide_concentration_count == item.getItemId()) {
            addRow("getCarbonMonoxideConcentrationCount", mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationCount());
        } else if (R.id.is_carbon_monoxide_concentration_notificatable_0 == item.getItemId()) {
            addRow("isCarbonMonoxideConcentrationNotificatable", mEnvironmentalSensingProfile.isCarbonMonoxideConcentrationNotificatable());
        } else if (R.id.is_carbon_monoxide_concentration_notificatable_1 == item.getItemId()) {
            addRow("isCarbonMonoxideConcentrationNotificatable_1", mEnvironmentalSensingProfile.isCarbonMonoxideConcentrationNotificatable(1));
        } else if (R.id.has_carbon_monoxide_concentration_esm_0 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_carbon_monoxide_concentration_esm_1 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_carbon_monoxide_concentration_ests_count_0 == item.getItemId()) {
            addRow("getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_carbon_monoxide_concentration_ests_count_1 == item.getItemId()) {
            addRow("getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_carbon_monoxide_concentration_esc_0 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_carbon_monoxide_concentration_esc_1 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_carbon_monoxide_concentration_cud_0 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_carbon_monoxide_concentration_cud_1 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_carbon_monoxide_concentration_vr_0 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicValidRange());
        } else if (R.id.has_carbon_monoxide_concentration_vr_1 == item.getItemId()) {
            addRow("hasCarbonMonoxideConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasCarbonMonoxideConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_carbon_monoxide_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentration();
        } else if (R.id.read_carbon_monoxide_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentration(1);
        } else if (R.id.notify_carbon_monoxide_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startCarbonMonoxideConcentrationNotification();
        } else if (R.id.notify_carbon_monoxide_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startCarbonMonoxideConcentrationNotification(1);
        } else if (R.id.notify_carbon_monoxide_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopCarbonMonoxideConcentrationNotification();
        } else if (R.id.notify_carbon_monoxide_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopCarbonMonoxideConcentrationNotification(1);
        } else if (R.id.read_carbon_monoxide_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_carbon_monoxide_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_carbon_monoxide_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_carbon_monoxide_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_carbon_monoxide_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_carbon_monoxide_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_carbon_monoxide_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_carbon_monoxide_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_carbon_monoxide_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_carbon_monoxide_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_carbon_monoxide_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_carbon_monoxide_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_carbon_monoxide_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationCharacteristicUserDescription();
        } else if (R.id.read_carbon_monoxide_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_carbon_monoxide_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setCarbonMonoxideConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_carbon_monoxide_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setCarbonMonoxideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_carbon_monoxide_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationValidRange();
        } else if (R.id.read_carbon_monoxide_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getCarbonMonoxideConcentrationValidRange(1);
        }
    }

    private void onDewPoint(MenuItem item) {
        if (R.id.read_dew_point_count == item.getItemId()) {
            addRow("getDewPointCount", mEnvironmentalSensingProfile.getDewPointCount());
        } else if (R.id.is_dew_point_notificatable_0 == item.getItemId()) {
            addRow("isDewPointNotificatable", mEnvironmentalSensingProfile.isDewPointNotificatable());
        } else if (R.id.is_dew_point_notificatable_1 == item.getItemId()) {
            addRow("isDewPointNotificatable_1", mEnvironmentalSensingProfile.isDewPointNotificatable(1));
        } else if (R.id.has_dew_point_esm_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_dew_point_esm_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_dew_point_ests_count_0 == item.getItemId()) {
            addRow("getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_dew_point_ests_count_1 == item.getItemId()) {
            addRow("getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_dew_point_esc_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_dew_point_esc_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_dew_point_cud_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasDewPointCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_dew_point_cud_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_dew_point_vr_0 == item.getItemId()) {
            addRow("hasDewPointCharacteristicValidRange", mEnvironmentalSensingProfile.hasDewPointCharacteristicValidRange());
        } else if (R.id.has_dew_point_vr_1 == item.getItemId()) {
            addRow("hasDewPointCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasDewPointCharacteristicValidRange(1));
        } else if (R.id.read_dew_point_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPoint();
        } else if (R.id.read_dew_point_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPoint(1);
        } else if (R.id.notify_dew_point_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startDewPointNotification();
        } else if (R.id.notify_dew_point_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startDewPointNotification(1);
        } else if (R.id.notify_dew_point_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopDewPointNotification();
        } else if (R.id.notify_dew_point_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopDewPointNotification(1);
        } else if (R.id.read_dew_point_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingMeasurement();
        } else if (R.id.read_dew_point_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_dew_point_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_dew_point_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_dew_point_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_dew_point_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_dew_point_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_dew_point_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_dew_point_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingConfiguration();
        } else if (R.id.read_dew_point_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_dew_point_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_dew_point_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_dew_point_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointCharacteristicUserDescription();
        } else if (R.id.read_dew_point_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointCharacteristicUserDescription(1);
        } else if (R.id.write_dew_point_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_dew_point_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setDewPointCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_dew_point_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getDewPointValidRange();
        } else if (R.id.read_dew_point_vr_1 == item.getItemId()) {
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

    private void onGustFactor(MenuItem item) {
        if (R.id.read_gust_factor_count == item.getItemId()) {
            addRow("getGustFactorCount", mEnvironmentalSensingProfile.getGustFactorCount());
        } else if (R.id.is_gust_factor_notificatable_0 == item.getItemId()) {
            addRow("isGustFactorNotificatable", mEnvironmentalSensingProfile.isGustFactorNotificatable());
        } else if (R.id.is_gust_factor_notificatable_1 == item.getItemId()) {
            addRow("isGustFactorNotificatable_1", mEnvironmentalSensingProfile.isGustFactorNotificatable(1));
        } else if (R.id.has_gust_factor_esm_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_gust_factor_esm_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_gust_factor_ests_count_0 == item.getItemId()) {
            addRow("getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_gust_factor_ests_count_1 == item.getItemId()) {
            addRow("getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_gust_factor_esc_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_gust_factor_esc_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_gust_factor_cud_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasGustFactorCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_gust_factor_cud_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_gust_factor_vr_0 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicValidRange", mEnvironmentalSensingProfile.hasGustFactorCharacteristicValidRange());
        } else if (R.id.has_gust_factor_vr_1 == item.getItemId()) {
            addRow("hasGustFactorCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasGustFactorCharacteristicValidRange(1));
        } else if (R.id.read_gust_factor_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactor();
        } else if (R.id.read_gust_factor_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactor(1);
        } else if (R.id.notify_gust_factor_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startGustFactorNotification();
        } else if (R.id.notify_gust_factor_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startGustFactorNotification(1);
        } else if (R.id.notify_gust_factor_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopGustFactorNotification();
        } else if (R.id.notify_gust_factor_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopGustFactorNotification(1);
        } else if (R.id.read_gust_factor_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingMeasurement();
        } else if (R.id.read_gust_factor_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_gust_factor_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_gust_factor_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_gust_factor_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_gust_factor_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_gust_factor_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_gust_factor_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_gust_factor_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingConfiguration();
        } else if (R.id.read_gust_factor_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_gust_factor_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_gust_factor_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_gust_factor_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorCharacteristicUserDescription();
        } else if (R.id.read_gust_factor_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorCharacteristicUserDescription(1);
        } else if (R.id.write_gust_factor_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_gust_factor_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setGustFactorCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_gust_factor_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorValidRange();
        } else if (R.id.read_gust_factor_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getGustFactorValidRange(1);
        }
    }

    private void onHeatIndex(MenuItem item) {
        if (R.id.read_heat_index_count == item.getItemId()) {
            addRow("getHeatIndexCount", mEnvironmentalSensingProfile.getHeatIndexCount());
        } else if (R.id.is_heat_index_notificatable_0 == item.getItemId()) {
            addRow("isHeatIndexNotificatable", mEnvironmentalSensingProfile.isHeatIndexNotificatable());
        } else if (R.id.is_heat_index_notificatable_1 == item.getItemId()) {
            addRow("isHeatIndexNotificatable_1", mEnvironmentalSensingProfile.isHeatIndexNotificatable(1));
        } else if (R.id.has_heat_index_esm_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_heat_index_esm_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_heat_index_ests_count_0 == item.getItemId()) {
            addRow("getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_heat_index_ests_count_1 == item.getItemId()) {
            addRow("getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_heat_index_esc_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_heat_index_esc_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_heat_index_cud_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_heat_index_cud_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_heat_index_vr_0 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicValidRange", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicValidRange());
        } else if (R.id.has_heat_index_vr_1 == item.getItemId()) {
            addRow("hasHeatIndexCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasHeatIndexCharacteristicValidRange(1));
        } else if (R.id.read_heat_index_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndex();
        } else if (R.id.read_heat_index_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndex(1);
        } else if (R.id.notify_heat_index_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startHeatIndexNotification();
        } else if (R.id.notify_heat_index_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startHeatIndexNotification(1);
        } else if (R.id.notify_heat_index_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopHeatIndexNotification();
        } else if (R.id.notify_heat_index_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopHeatIndexNotification(1);
        } else if (R.id.read_heat_index_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingMeasurement();
        } else if (R.id.read_heat_index_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_heat_index_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_heat_index_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_heat_index_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_heat_index_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_heat_index_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_heat_index_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_heat_index_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingConfiguration();
        } else if (R.id.read_heat_index_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_heat_index_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_heat_index_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_heat_index_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexCharacteristicUserDescription();
        } else if (R.id.read_heat_index_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexCharacteristicUserDescription(1);
        } else if (R.id.write_heat_index_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_heat_index_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setHeatIndexCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_heat_index_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getHeatIndexValidRange();
        } else if (R.id.read_heat_index_vr_1 == item.getItemId()) {
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

    private void onMagneticDeclination(MenuItem item) {
        if (R.id.read_magnetic_declination_count == item.getItemId()) {
            addRow("getMagneticDeclinationCount", mEnvironmentalSensingProfile.getMagneticDeclinationCount());
        } else if (R.id.is_magnetic_declination_notificatable_0 == item.getItemId()) {
            addRow("isMagneticDeclinationNotificatable", mEnvironmentalSensingProfile.isMagneticDeclinationNotificatable());
        } else if (R.id.is_magnetic_declination_notificatable_1 == item.getItemId()) {
            addRow("isMagneticDeclinationNotificatable_1", mEnvironmentalSensingProfile.isMagneticDeclinationNotificatable(1));
        } else if (R.id.has_magnetic_declination_esm_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_magnetic_declination_esm_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_magnetic_declination_ests_count_0 == item.getItemId()) {
            addRow("getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_magnetic_declination_ests_count_1 == item.getItemId()) {
            addRow("getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_magnetic_declination_esc_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_magnetic_declination_esc_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_magnetic_declination_cud_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_magnetic_declination_cud_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_magnetic_declination_vr_0 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicValidRange", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicValidRange());
        } else if (R.id.has_magnetic_declination_vr_1 == item.getItemId()) {
            addRow("hasMagneticDeclinationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasMagneticDeclinationCharacteristicValidRange(1));
        } else if (R.id.read_magnetic_declination_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclination();
        } else if (R.id.read_magnetic_declination_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclination(1);
        } else if (R.id.notify_magnetic_declination_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticDeclinationNotification();
        } else if (R.id.notify_magnetic_declination_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticDeclinationNotification(1);
        } else if (R.id.notify_magnetic_declination_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticDeclinationNotification();
        } else if (R.id.notify_magnetic_declination_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticDeclinationNotification(1);
        } else if (R.id.read_magnetic_declination_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingMeasurement();
        } else if (R.id.read_magnetic_declination_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_magnetic_declination_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_magnetic_declination_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_magnetic_declination_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_magnetic_declination_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_magnetic_declination_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_magnetic_declination_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_magnetic_declination_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingConfiguration();
        } else if (R.id.read_magnetic_declination_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_magnetic_declination_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_magnetic_declination_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_magnetic_declination_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicUserDescription();
        } else if (R.id.read_magnetic_declination_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationCharacteristicUserDescription(1);
        } else if (R.id.write_magnetic_declination_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_magnetic_declination_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticDeclinationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_magnetic_declination_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationValidRange();
        } else if (R.id.read_magnetic_declination_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticDeclinationValidRange(1);
        }
    }

    private void onMagneticFluxDensity2D(MenuItem item) {
        if (R.id.read_magnetic_flux_density_2d_count == item.getItemId()) {
            addRow("getMagneticFluxDensity2DCount", mEnvironmentalSensingProfile.getMagneticFluxDensity2DCount());
        } else if (R.id.is_magnetic_flux_density_2d_notificatable_0 == item.getItemId()) {
            addRow("isMagneticFluxDensity2DNotificatable", mEnvironmentalSensingProfile.isMagneticFluxDensity2DNotificatable());
        } else if (R.id.is_magnetic_flux_density_2d_notificatable_1 == item.getItemId()) {
            addRow("isMagneticFluxDensity2DNotificatable_1", mEnvironmentalSensingProfile.isMagneticFluxDensity2DNotificatable(1));
        } else if (R.id.has_magnetic_flux_density_2d_esm_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_magnetic_flux_density_2d_esm_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_magnetic_flux_density_2d_ests_count_0 == item.getItemId()) {
            addRow("getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_magnetic_flux_density_2d_ests_count_1 == item.getItemId()) {
            addRow("getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_magnetic_flux_density_2d_esc_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_magnetic_flux_density_2d_esc_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_magnetic_flux_density_2d_cud_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_magnetic_flux_density_2d_cud_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_magnetic_flux_density_2d_vr_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicValidRange", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicValidRange());
        } else if (R.id.has_magnetic_flux_density_2d_vr_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity2DCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity2DCharacteristicValidRange(1));
        } else if (R.id.read_magnetic_flux_density_2d_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2D();
        } else if (R.id.read_magnetic_flux_density_2d_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2D(1);
        } else if (R.id.notify_magnetic_flux_density_2d_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity2DNotification();
        } else if (R.id.notify_magnetic_flux_density_2d_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity2DNotification(1);
        } else if (R.id.notify_magnetic_flux_density_2d_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity2DNotification();
        } else if (R.id.notify_magnetic_flux_density_2d_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity2DNotification(1);
        } else if (R.id.read_magnetic_flux_density_2d_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingMeasurement();
        } else if (R.id.read_magnetic_flux_density_2d_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_magnetic_flux_density_2d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_magnetic_flux_density_2d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_magnetic_flux_density_2d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_magnetic_flux_density_2d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_magnetic_flux_density_2d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_magnetic_flux_density_2d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_magnetic_flux_density_2d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingConfiguration();
        } else if (R.id.read_magnetic_flux_density_2d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_magnetic_flux_density_2d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_magnetic_flux_density_2d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_magnetic_flux_density_2d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicUserDescription();
        } else if (R.id.read_magnetic_flux_density_2d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DCharacteristicUserDescription(1);
        } else if (R.id.write_magnetic_flux_density_2d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_magnetic_flux_density_2d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity2DCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_magnetic_flux_density_2d_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DValidRange();
        } else if (R.id.read_magnetic_flux_density_2d_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity2DValidRange(1);
        }
    }

    private void onMagneticFluxDensity3D(MenuItem item) {
        if (R.id.read_magnetic_flux_density_3d_count == item.getItemId()) {
            addRow("getMagneticFluxDensity3DCount", mEnvironmentalSensingProfile.getMagneticFluxDensity3DCount());
        } else if (R.id.is_magnetic_flux_density_3d_notificatable_0 == item.getItemId()) {
            addRow("isMagneticFluxDensity3DNotificatable", mEnvironmentalSensingProfile.isMagneticFluxDensity3DNotificatable());
        } else if (R.id.is_magnetic_flux_density_3d_notificatable_1 == item.getItemId()) {
            addRow("isMagneticFluxDensity3DNotificatable_1", mEnvironmentalSensingProfile.isMagneticFluxDensity3DNotificatable(1));
        } else if (R.id.has_magnetic_flux_density_3d_esm_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_magnetic_flux_density_3d_esm_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_magnetic_flux_density_3d_ests_count_0 == item.getItemId()) {
            addRow("getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_magnetic_flux_density_3d_ests_count_1 == item.getItemId()) {
            addRow("getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_magnetic_flux_density_3d_esc_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_magnetic_flux_density_3d_esc_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_magnetic_flux_density_3d_cud_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_magnetic_flux_density_3d_cud_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_magnetic_flux_density_3d_vr_0 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicValidRange", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicValidRange());
        } else if (R.id.has_magnetic_flux_density_3d_vr_1 == item.getItemId()) {
            addRow("hasMagneticFluxDensity3DCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasMagneticFluxDensity3DCharacteristicValidRange(1));
        } else if (R.id.read_magnetic_flux_density_3d_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3D();
        } else if (R.id.read_magnetic_flux_density_3d_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3D(1);
        } else if (R.id.notify_magnetic_flux_density_3d_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity3DNotification();
        } else if (R.id.notify_magnetic_flux_density_3d_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMagneticFluxDensity3DNotification(1);
        } else if (R.id.notify_magnetic_flux_density_3d_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity3DNotification();
        } else if (R.id.notify_magnetic_flux_density_3d_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMagneticFluxDensity3DNotification(1);
        } else if (R.id.read_magnetic_flux_density_3d_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingMeasurement();
        } else if (R.id.read_magnetic_flux_density_3d_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_magnetic_flux_density_3d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_magnetic_flux_density_3d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_magnetic_flux_density_3d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_magnetic_flux_density_3d_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_magnetic_flux_density_3d_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_magnetic_flux_density_3d_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_magnetic_flux_density_3d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingConfiguration();
        } else if (R.id.read_magnetic_flux_density_3d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_magnetic_flux_density_3d_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_magnetic_flux_density_3d_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_magnetic_flux_density_3d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicUserDescription();
        } else if (R.id.read_magnetic_flux_density_3d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DCharacteristicUserDescription(1);
        } else if (R.id.write_magnetic_flux_density_3d_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_magnetic_flux_density_3d_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMagneticFluxDensity3DCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_magnetic_flux_density_3d_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DValidRange();
        } else if (R.id.read_magnetic_flux_density_3d_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMagneticFluxDensity3DValidRange(1);
        }
    }

    private void onMethaneConcentration(MenuItem item) {
        if (R.id.read_methane_concentration_count == item.getItemId()) {
            addRow("getMethaneConcentrationCount", mEnvironmentalSensingProfile.getMethaneConcentrationCount());
        } else if (R.id.is_methane_concentration_notificatable_0 == item.getItemId()) {
            addRow("isMethaneConcentrationNotificatable", mEnvironmentalSensingProfile.isMethaneConcentrationNotificatable());
        } else if (R.id.is_methane_concentration_notificatable_1 == item.getItemId()) {
            addRow("isMethaneConcentrationNotificatable_1", mEnvironmentalSensingProfile.isMethaneConcentrationNotificatable(1));
        } else if (R.id.has_methane_concentration_esm_0 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_methane_concentration_esm_1 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_methane_concentration_ests_count_0 == item.getItemId()) {
            addRow("getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_methane_concentration_ests_count_1 == item.getItemId()) {
            addRow("getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_methane_concentration_esc_0 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_methane_concentration_esc_1 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_methane_concentration_cud_0 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_methane_concentration_cud_1 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_methane_concentration_vr_0 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicValidRange());
        } else if (R.id.has_methane_concentration_vr_1 == item.getItemId()) {
            addRow("hasMethaneConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasMethaneConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_methane_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentration();
        } else if (R.id.read_methane_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentration(1);
        } else if (R.id.notify_methane_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMethaneConcentrationNotification();
        } else if (R.id.notify_methane_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startMethaneConcentrationNotification(1);
        } else if (R.id.notify_methane_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMethaneConcentrationNotification();
        } else if (R.id.notify_methane_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopMethaneConcentrationNotification(1);
        } else if (R.id.read_methane_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_methane_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_methane_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_methane_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_methane_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_methane_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMethaneConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_methane_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMethaneConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_methane_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMethaneConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_methane_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_methane_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_methane_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMethaneConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_methane_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMethaneConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_methane_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationCharacteristicUserDescription();
        } else if (R.id.read_methane_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_methane_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMethaneConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_methane_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setMethaneConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_methane_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationValidRange();
        } else if (R.id.read_methane_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getMethaneConcentrationValidRange(1);
        }
    }

    private void onNitrogenDioxideConcentration(MenuItem item) {
        if (R.id.read_nitrogen_dioxide_concentration_count == item.getItemId()) {
            addRow("getNitrogenDioxideConcentrationCount", mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationCount());
        } else if (R.id.is_nitrogen_dioxide_concentration_notificatable_0 == item.getItemId()) {
            addRow("isNitrogenDioxideConcentrationNotificatable", mEnvironmentalSensingProfile.isNitrogenDioxideConcentrationNotificatable());
        } else if (R.id.is_nitrogen_dioxide_concentration_notificatable_1 == item.getItemId()) {
            addRow("isNitrogenDioxideConcentrationNotificatable_1", mEnvironmentalSensingProfile.isNitrogenDioxideConcentrationNotificatable(1));
        } else if (R.id.has_nitrogen_dioxide_concentration_esm_0 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_nitrogen_dioxide_concentration_esm_1 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_nitrogen_dioxide_concentration_ests_count_0 == item.getItemId()) {
            addRow("getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_nitrogen_dioxide_concentration_ests_count_1 == item.getItemId()) {
            addRow("getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_nitrogen_dioxide_concentration_esc_0 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_nitrogen_dioxide_concentration_esc_1 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_nitrogen_dioxide_concentration_cud_0 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_nitrogen_dioxide_concentration_cud_1 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_nitrogen_dioxide_concentration_vr_0 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicValidRange());
        } else if (R.id.has_nitrogen_dioxide_concentration_vr_1 == item.getItemId()) {
            addRow("hasNitrogenDioxideConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasNitrogenDioxideConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_nitrogen_dioxide_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentration();
        } else if (R.id.read_nitrogen_dioxide_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentration(1);
        } else if (R.id.notify_nitrogen_dioxide_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startNitrogenDioxideConcentrationNotification();
        } else if (R.id.notify_nitrogen_dioxide_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startNitrogenDioxideConcentrationNotification(1);
        } else if (R.id.notify_nitrogen_dioxide_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopNitrogenDioxideConcentrationNotification();
        } else if (R.id.notify_nitrogen_dioxide_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopNitrogenDioxideConcentrationNotification(1);
        } else if (R.id.read_nitrogen_dioxide_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_nitrogen_dioxide_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_nitrogen_dioxide_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_nitrogen_dioxide_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_nitrogen_dioxide_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_nitrogen_dioxide_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_nitrogen_dioxide_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_nitrogen_dioxide_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_nitrogen_dioxide_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_nitrogen_dioxide_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_nitrogen_dioxide_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_nitrogen_dioxide_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_nitrogen_dioxide_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationCharacteristicUserDescription();
        } else if (R.id.read_nitrogen_dioxide_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_nitrogen_dioxide_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNitrogenDioxideConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_nitrogen_dioxide_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNitrogenDioxideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_nitrogen_dioxide_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationValidRange();
        } else if (R.id.read_nitrogen_dioxide_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNitrogenDioxideConcentrationValidRange(1);
        }
    }

    private void onNonMethaneVolatileOrganicCompoundsConcentration(MenuItem item) {
        if (R.id.read_non_methane_volatile_organic_compounds_concentration_count == item.getItemId()) {
            addRow("getNonMethaneVolatileOrganicCompoundsConcentrationCount", mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCount());
        } else if (R.id.is_non_methane_volatile_organic_compounds_concentration_notificatable_0 == item.getItemId()) {
            addRow("isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable", mEnvironmentalSensingProfile.isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable());
        } else if (R.id.is_non_methane_volatile_organic_compounds_concentration_notificatable_1 == item.getItemId()) {
            addRow("isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable_1", mEnvironmentalSensingProfile.isNonMethaneVolatileOrganicCompoundsConcentrationNotificatable(1));
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_esm_0 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_esm_1 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_ests_count_0 == item.getItemId()) {
            addRow("getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_ests_count_1 == item.getItemId()) {
            addRow("getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_esc_0 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_esc_1 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_cud_0 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_cud_1 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_vr_0 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange());
        } else if (R.id.has_non_methane_volatile_organic_compounds_concentration_vr_1 == item.getItemId()) {
            addRow("hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentration();
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentration(1);
        } else if (R.id.notify_non_methane_volatile_organic_compounds_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startNonMethaneVolatileOrganicCompoundsConcentrationNotification();
        } else if (R.id.notify_non_methane_volatile_organic_compounds_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startNonMethaneVolatileOrganicCompoundsConcentrationNotification(1);
        } else if (R.id.notify_non_methane_volatile_organic_compounds_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopNonMethaneVolatileOrganicCompoundsConcentrationNotification();
        } else if (R.id.notify_non_methane_volatile_organic_compounds_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(1);
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_non_methane_volatile_organic_compounds_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_non_methane_volatile_organic_compounds_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_non_methane_volatile_organic_compounds_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_non_methane_volatile_organic_compounds_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_non_methane_volatile_organic_compounds_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription();
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_non_methane_volatile_organic_compounds_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_non_methane_volatile_organic_compounds_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationValidRange();
        } else if (R.id.read_non_methane_volatile_organic_compounds_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(1);
        }
    }

    private void onOzoneConcentration(MenuItem item) {
        if (R.id.read_ozone_concentration_count == item.getItemId()) {
            addRow("getOzoneConcentrationCount", mEnvironmentalSensingProfile.getOzoneConcentrationCount());
        } else if (R.id.is_ozone_concentration_notificatable_0 == item.getItemId()) {
            addRow("isOzoneConcentrationNotificatable", mEnvironmentalSensingProfile.isOzoneConcentrationNotificatable());
        } else if (R.id.is_ozone_concentration_notificatable_1 == item.getItemId()) {
            addRow("isOzoneConcentrationNotificatable_1", mEnvironmentalSensingProfile.isOzoneConcentrationNotificatable(1));
        } else if (R.id.has_ozone_concentration_esm_0 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_ozone_concentration_esm_1 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_ozone_concentration_ests_count_0 == item.getItemId()) {
            addRow("getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_ozone_concentration_ests_count_1 == item.getItemId()) {
            addRow("getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_ozone_concentration_esc_0 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_ozone_concentration_esc_1 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_ozone_concentration_cud_0 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_ozone_concentration_cud_1 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_ozone_concentration_vr_0 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicValidRange());
        } else if (R.id.has_ozone_concentration_vr_1 == item.getItemId()) {
            addRow("hasOzoneConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasOzoneConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_ozone_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentration();
        } else if (R.id.read_ozone_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentration(1);
        } else if (R.id.notify_ozone_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startOzoneConcentrationNotification();
        } else if (R.id.notify_ozone_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startOzoneConcentrationNotification(1);
        } else if (R.id.notify_ozone_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopOzoneConcentrationNotification();
        } else if (R.id.notify_ozone_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopOzoneConcentrationNotification(1);
        } else if (R.id.read_ozone_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_ozone_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_ozone_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_ozone_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_ozone_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_ozone_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setOzoneConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_ozone_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setOzoneConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_ozone_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setOzoneConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_ozone_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_ozone_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_ozone_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setOzoneConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_ozone_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setOzoneConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_ozone_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationCharacteristicUserDescription();
        } else if (R.id.read_ozone_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_ozone_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setOzoneConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_ozone_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setOzoneConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_ozone_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationValidRange();
        } else if (R.id.read_ozone_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getOzoneConcentrationValidRange(1);
        }
    }

    private void onParticulateMatterPm10Concentration(MenuItem item) {
        if (R.id.read_particulate_matter_pm10_concentration_count == item.getItemId()) {
            addRow("getParticulateMatterPm10ConcentrationCount", mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationCount());
        } else if (R.id.is_particulate_matter_pm10_concentration_notificatable_0 == item.getItemId()) {
            addRow("isParticulateMatterPm10ConcentrationNotificatable", mEnvironmentalSensingProfile.isParticulateMatterPm10ConcentrationNotificatable());
        } else if (R.id.is_particulate_matter_pm10_concentration_notificatable_1 == item.getItemId()) {
            addRow("isParticulateMatterPm10ConcentrationNotificatable_1", mEnvironmentalSensingProfile.isParticulateMatterPm10ConcentrationNotificatable(1));
        } else if (R.id.has_particulate_matter_pm10_concentration_esm_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_particulate_matter_pm10_concentration_esm_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_particulate_matter_pm10_concentration_ests_count_0 == item.getItemId()) {
            addRow("getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_particulate_matter_pm10_concentration_ests_count_1 == item.getItemId()) {
            addRow("getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_particulate_matter_pm10_concentration_esc_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_particulate_matter_pm10_concentration_esc_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_particulate_matter_pm10_concentration_cud_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_particulate_matter_pm10_concentration_cud_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_particulate_matter_pm10_concentration_vr_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicValidRange());
        } else if (R.id.has_particulate_matter_pm10_concentration_vr_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm10ConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasParticulateMatterPm10ConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_particulate_matter_pm10_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10Concentration();
        } else if (R.id.read_particulate_matter_pm10_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10Concentration(1);
        } else if (R.id.notify_particulate_matter_pm10_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startParticulateMatterPm10ConcentrationNotification();
        } else if (R.id.notify_particulate_matter_pm10_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startParticulateMatterPm10ConcentrationNotification(1);
        } else if (R.id.notify_particulate_matter_pm10_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopParticulateMatterPm10ConcentrationNotification();
        } else if (R.id.notify_particulate_matter_pm10_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopParticulateMatterPm10ConcentrationNotification(1);
        } else if (R.id.read_particulate_matter_pm10_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_particulate_matter_pm10_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_particulate_matter_pm10_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_particulate_matter_pm10_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_particulate_matter_pm10_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_particulate_matter_pm10_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_particulate_matter_pm10_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_particulate_matter_pm10_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_particulate_matter_pm10_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_particulate_matter_pm10_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_particulate_matter_pm10_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_particulate_matter_pm10_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_particulate_matter_pm10_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationCharacteristicUserDescription();
        } else if (R.id.read_particulate_matter_pm10_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_particulate_matter_pm10_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm10ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_particulate_matter_pm10_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm10ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_particulate_matter_pm10_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationValidRange();
        } else if (R.id.read_particulate_matter_pm10_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm10ConcentrationValidRange(1);
        }
    }

    private void onParticulateMatterPm1Concentration(MenuItem item) {
        if (R.id.read_particulate_matter_pm1_concentration_count == item.getItemId()) {
            addRow("getParticulateMatterPm1ConcentrationCount", mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationCount());
        } else if (R.id.is_particulate_matter_pm1_concentration_notificatable_0 == item.getItemId()) {
            addRow("isParticulateMatterPm1ConcentrationNotificatable", mEnvironmentalSensingProfile.isParticulateMatterPm1ConcentrationNotificatable());
        } else if (R.id.is_particulate_matter_pm1_concentration_notificatable_1 == item.getItemId()) {
            addRow("isParticulateMatterPm1ConcentrationNotificatable_1", mEnvironmentalSensingProfile.isParticulateMatterPm1ConcentrationNotificatable(1));
        } else if (R.id.has_particulate_matter_pm1_concentration_esm_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_particulate_matter_pm1_concentration_esm_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_particulate_matter_pm1_concentration_ests_count_0 == item.getItemId()) {
            addRow("getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_particulate_matter_pm1_concentration_ests_count_1 == item.getItemId()) {
            addRow("getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_particulate_matter_pm1_concentration_esc_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_particulate_matter_pm1_concentration_esc_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_particulate_matter_pm1_concentration_cud_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_particulate_matter_pm1_concentration_cud_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_particulate_matter_pm1_concentration_vr_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicValidRange());
        } else if (R.id.has_particulate_matter_pm1_concentration_vr_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm1ConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasParticulateMatterPm1ConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_particulate_matter_pm1_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1Concentration();
        } else if (R.id.read_particulate_matter_pm1_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1Concentration(1);
        } else if (R.id.notify_particulate_matter_pm1_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startParticulateMatterPm1ConcentrationNotification();
        } else if (R.id.notify_particulate_matter_pm1_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startParticulateMatterPm1ConcentrationNotification(1);
        } else if (R.id.notify_particulate_matter_pm1_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopParticulateMatterPm1ConcentrationNotification();
        } else if (R.id.notify_particulate_matter_pm1_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopParticulateMatterPm1ConcentrationNotification(1);
        } else if (R.id.read_particulate_matter_pm1_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_particulate_matter_pm1_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_particulate_matter_pm1_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_particulate_matter_pm1_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_particulate_matter_pm1_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_particulate_matter_pm1_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_particulate_matter_pm1_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_particulate_matter_pm1_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_particulate_matter_pm1_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_particulate_matter_pm1_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_particulate_matter_pm1_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_particulate_matter_pm1_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_particulate_matter_pm1_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationCharacteristicUserDescription();
        } else if (R.id.read_particulate_matter_pm1_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_particulate_matter_pm1_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm1ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_particulate_matter_pm1_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm1ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_particulate_matter_pm1_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationValidRange();
        } else if (R.id.read_particulate_matter_pm1_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm1ConcentrationValidRange(1);
        }
    }

    private void onParticulateMatterPm25Concentration(MenuItem item) {
        if (R.id.read_particulate_matter_pm2_5_concentration_count == item.getItemId()) {
            addRow("getParticulateMatterPm25ConcentrationCount", mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationCount());
        } else if (R.id.is_particulate_matter_pm2_5_concentration_notificatable_0 == item.getItemId()) {
            addRow("isParticulateMatterPm25ConcentrationNotificatable", mEnvironmentalSensingProfile.isParticulateMatterPm25ConcentrationNotificatable());
        } else if (R.id.is_particulate_matter_pm2_5_concentration_notificatable_1 == item.getItemId()) {
            addRow("isParticulateMatterPm25ConcentrationNotificatable_1", mEnvironmentalSensingProfile.isParticulateMatterPm25ConcentrationNotificatable(1));
        } else if (R.id.has_particulate_matter_pm2_5_concentration_esm_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_particulate_matter_pm2_5_concentration_esm_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_particulate_matter_pm2_5_concentration_ests_count_0 == item.getItemId()) {
            addRow("getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_particulate_matter_pm2_5_concentration_ests_count_1 == item.getItemId()) {
            addRow("getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_particulate_matter_pm2_5_concentration_esc_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_particulate_matter_pm2_5_concentration_esc_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_particulate_matter_pm2_5_concentration_cud_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_particulate_matter_pm2_5_concentration_cud_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_particulate_matter_pm2_5_concentration_vr_0 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
        } else if (R.id.has_particulate_matter_pm2_5_concentration_vr_1 == item.getItemId()) {
            addRow("hasParticulateMatterPm25ConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasParticulateMatterPm25ConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_particulate_matter_pm2_5_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25Concentration();
        } else if (R.id.read_particulate_matter_pm2_5_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25Concentration(1);
        } else if (R.id.notify_particulate_matter_pm2_5_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startParticulateMatterPm25ConcentrationNotification();
        } else if (R.id.notify_particulate_matter_pm2_5_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startParticulateMatterPm25ConcentrationNotification(1);
        } else if (R.id.notify_particulate_matter_pm2_5_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopParticulateMatterPm25ConcentrationNotification();
        } else if (R.id.notify_particulate_matter_pm2_5_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopParticulateMatterPm25ConcentrationNotification(1);
        } else if (R.id.read_particulate_matter_pm2_5_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_particulate_matter_pm2_5_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_particulate_matter_pm2_5_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_particulate_matter_pm2_5_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_particulate_matter_pm2_5_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_particulate_matter_pm2_5_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_particulate_matter_pm2_5_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_particulate_matter_pm2_5_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_particulate_matter_pm2_5_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_particulate_matter_pm2_5_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_particulate_matter_pm2_5_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_particulate_matter_pm2_5_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_particulate_matter_pm2_5_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicUserDescription();
        } else if (R.id.read_particulate_matter_pm2_5_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_particulate_matter_pm2_5_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_particulate_matter_pm2_5_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_particulate_matter_pm2_5_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationValidRange();
        } else if (R.id.read_particulate_matter_pm2_5_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getParticulateMatterPm25ConcentrationValidRange(1);
        }
    }

    private void onPollenConcentration(MenuItem item) {
        if (R.id.read_pollen_concentration_count == item.getItemId()) {
            addRow("getPollenConcentrationCount", mEnvironmentalSensingProfile.getPollenConcentrationCount());
        } else if (R.id.is_pollen_concentration_notificatable_0 == item.getItemId()) {
            addRow("isPollenConcentrationNotificatable", mEnvironmentalSensingProfile.isPollenConcentrationNotificatable());
        } else if (R.id.is_pollen_concentration_notificatable_1 == item.getItemId()) {
            addRow("isPollenConcentrationNotificatable_1", mEnvironmentalSensingProfile.isPollenConcentrationNotificatable(1));
        } else if (R.id.has_pollen_concentration_esm_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_pollen_concentration_esm_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_pollen_concentration_ests_count_0 == item.getItemId()) {
            addRow("getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_pollen_concentration_ests_count_1 == item.getItemId()) {
            addRow("getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_pollen_concentration_esc_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_pollen_concentration_esc_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_pollen_concentration_cud_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_pollen_concentration_cud_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_pollen_concentration_vr_0 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicValidRange());
        } else if (R.id.has_pollen_concentration_vr_1 == item.getItemId()) {
            addRow("hasPollenConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasPollenConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_pollen_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentration();
        } else if (R.id.read_pollen_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentration(1);
        } else if (R.id.notify_pollen_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startPollenConcentrationNotification();
        } else if (R.id.notify_pollen_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startPollenConcentrationNotification(1);
        } else if (R.id.notify_pollen_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopPollenConcentrationNotification();
        } else if (R.id.notify_pollen_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopPollenConcentrationNotification(1);
        } else if (R.id.read_pollen_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_pollen_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_pollen_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_pollen_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_pollen_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_pollen_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_pollen_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_pollen_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_pollen_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_pollen_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_pollen_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_pollen_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_pollen_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicUserDescription();
        } else if (R.id.read_pollen_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_pollen_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_pollen_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setPollenConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_pollen_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationValidRange();
        } else if (R.id.read_pollen_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getPollenConcentrationValidRange(1);
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

    private void onSulfurDioxideConcentration(MenuItem item) {
        if (R.id.read_sulfur_dioxide_concentration_count == item.getItemId()) {
            addRow("getSulfurDioxideConcentrationCount", mEnvironmentalSensingProfile.getSulfurDioxideConcentrationCount());
        } else if (R.id.is_sulfur_dioxide_concentration_notificatable_0 == item.getItemId()) {
            addRow("isSulfurDioxideConcentrationNotificatable", mEnvironmentalSensingProfile.isSulfurDioxideConcentrationNotificatable());
        } else if (R.id.is_sulfur_dioxide_concentration_notificatable_1 == item.getItemId()) {
            addRow("isSulfurDioxideConcentrationNotificatable_1", mEnvironmentalSensingProfile.isSulfurDioxideConcentrationNotificatable(1));
        } else if (R.id.has_sulfur_dioxide_concentration_esm_0 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_sulfur_dioxide_concentration_esm_1 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_sulfur_dioxide_concentration_ests_count_0 == item.getItemId()) {
            addRow("getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_sulfur_dioxide_concentration_ests_count_1 == item.getItemId()) {
            addRow("getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_sulfur_dioxide_concentration_esc_0 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_sulfur_dioxide_concentration_esc_1 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_sulfur_dioxide_concentration_cud_0 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_sulfur_dioxide_concentration_cud_1 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_sulfur_dioxide_concentration_vr_0 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicValidRange());
        } else if (R.id.has_sulfur_dioxide_concentration_vr_1 == item.getItemId()) {
            addRow("hasSulfurDioxideConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasSulfurDioxideConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_sulfur_dioxide_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentration();
        } else if (R.id.read_sulfur_dioxide_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentration(1);
        } else if (R.id.notify_sulfur_dioxide_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startSulfurDioxideConcentrationNotification();
        } else if (R.id.notify_sulfur_dioxide_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startSulfurDioxideConcentrationNotification(1);
        } else if (R.id.notify_sulfur_dioxide_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopSulfurDioxideConcentrationNotification();
        } else if (R.id.notify_sulfur_dioxide_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopSulfurDioxideConcentrationNotification(1);
        } else if (R.id.read_sulfur_dioxide_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_sulfur_dioxide_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_sulfur_dioxide_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_sulfur_dioxide_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_sulfur_dioxide_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_sulfur_dioxide_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_sulfur_dioxide_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_sulfur_dioxide_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_sulfur_dioxide_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_sulfur_dioxide_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_sulfur_dioxide_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_sulfur_dioxide_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_sulfur_dioxide_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationCharacteristicUserDescription();
        } else if (R.id.read_sulfur_dioxide_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_sulfur_dioxide_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurDioxideConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_sulfur_dioxide_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurDioxideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_sulfur_dioxide_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationValidRange();
        } else if (R.id.read_sulfur_dioxide_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurDioxideConcentrationValidRange(1);
        }
    }

    private void onSulfurHexafluorideConcentration(MenuItem item) {
        if (R.id.read_sulfur_hexafluoride_concentration_count == item.getItemId()) {
            addRow("getSulfurHexafluorideConcentrationCount", mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationCount());
        } else if (R.id.is_sulfur_hexafluoride_concentration_notificatable_0 == item.getItemId()) {
            addRow("isSulfurHexafluorideConcentrationNotificatable", mEnvironmentalSensingProfile.isSulfurHexafluorideConcentrationNotificatable());
        } else if (R.id.is_sulfur_hexafluoride_concentration_notificatable_1 == item.getItemId()) {
            addRow("isSulfurHexafluorideConcentrationNotificatable_1", mEnvironmentalSensingProfile.isSulfurHexafluorideConcentrationNotificatable(1));
        } else if (R.id.has_sulfur_hexafluoride_concentration_esm_0 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_sulfur_hexafluoride_concentration_esm_1 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_sulfur_hexafluoride_concentration_ests_count_0 == item.getItemId()) {
            addRow("getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_sulfur_hexafluoride_concentration_ests_count_1 == item.getItemId()) {
            addRow("getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_sulfur_hexafluoride_concentration_esc_0 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_sulfur_hexafluoride_concentration_esc_1 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_sulfur_hexafluoride_concentration_cud_0 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_sulfur_hexafluoride_concentration_cud_1 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_sulfur_hexafluoride_concentration_vr_0 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicValidRange", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicValidRange());
        } else if (R.id.has_sulfur_hexafluoride_concentration_vr_1 == item.getItemId()) {
            addRow("hasSulfurHexafluorideConcentrationCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasSulfurHexafluorideConcentrationCharacteristicValidRange(1));
        } else if (R.id.read_sulfur_hexafluoride_concentration_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentration();
        } else if (R.id.read_sulfur_hexafluoride_concentration_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentration(1);
        } else if (R.id.notify_sulfur_hexafluoride_concentration_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startSulfurHexafluorideConcentrationNotification();
        } else if (R.id.notify_sulfur_hexafluoride_concentration_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startSulfurHexafluorideConcentrationNotification(1);
        } else if (R.id.notify_sulfur_hexafluoride_concentration_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopSulfurHexafluorideConcentrationNotification();
        } else if (R.id.notify_sulfur_hexafluoride_concentration_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopSulfurHexafluorideConcentrationNotification(1);
        } else if (R.id.read_sulfur_hexafluoride_concentration_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement();
        } else if (R.id.read_sulfur_hexafluoride_concentration_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_sulfur_hexafluoride_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_sulfur_hexafluoride_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_sulfur_hexafluoride_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_sulfur_hexafluoride_concentration_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_sulfur_hexafluoride_concentration_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_sulfur_hexafluoride_concentration_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_sulfur_hexafluoride_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration();
        } else if (R.id.read_sulfur_hexafluoride_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_sulfur_hexafluoride_concentration_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_sulfur_hexafluoride_concentration_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_sulfur_hexafluoride_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationCharacteristicUserDescription();
        } else if (R.id.read_sulfur_hexafluoride_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationCharacteristicUserDescription(1);
        } else if (R.id.write_sulfur_hexafluoride_concentration_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurHexafluorideConcentrationCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_sulfur_hexafluoride_concentration_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setSulfurHexafluorideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_sulfur_hexafluoride_concentration_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationValidRange();
        } else if (R.id.read_sulfur_hexafluoride_concentration_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getSulfurHexafluorideConcentrationValidRange(1);
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

    private void onTrueWindDirection(MenuItem item) {
        if (R.id.read_true_wind_direction_count == item.getItemId()) {
            addRow("getTrueWindDirectionCount", mEnvironmentalSensingProfile.getTrueWindDirectionCount());
        } else if (R.id.is_true_wind_direction_notificatable_0 == item.getItemId()) {
            addRow("isTrueWindDirectionNotificatable", mEnvironmentalSensingProfile.isTrueWindDirectionNotificatable());
        } else if (R.id.is_true_wind_direction_notificatable_1 == item.getItemId()) {
            addRow("isTrueWindDirectionNotificatable_1", mEnvironmentalSensingProfile.isTrueWindDirectionNotificatable(1));
        } else if (R.id.has_true_wind_direction_esm_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_true_wind_direction_esm_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_true_wind_direction_ests_count_0 == item.getItemId()) {
            addRow("getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_true_wind_direction_ests_count_1 == item.getItemId()) {
            addRow("getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_true_wind_direction_esc_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_true_wind_direction_esc_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_true_wind_direction_cud_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_true_wind_direction_cud_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_true_wind_direction_vr_0 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicValidRange", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange());
        } else if (R.id.has_true_wind_direction_vr_1 == item.getItemId()) {
            addRow("hasTrueWindDirectionCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasTrueWindDirectionCharacteristicValidRange(1));
        } else if (R.id.read_true_wind_direction_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirection();
        } else if (R.id.read_true_wind_direction_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirection(1);
        } else if (R.id.notify_true_wind_direction_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindDirectionNotification();
        } else if (R.id.notify_true_wind_direction_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindDirectionNotification(1);
        } else if (R.id.notify_true_wind_direction_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindDirectionNotification();
        } else if (R.id.notify_true_wind_direction_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindDirectionNotification(1);
        } else if (R.id.read_true_wind_direction_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement();
        } else if (R.id.read_true_wind_direction_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_true_wind_direction_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_true_wind_direction_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_true_wind_direction_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_true_wind_direction_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_true_wind_direction_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_true_wind_direction_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_true_wind_direction_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration();
        } else if (R.id.read_true_wind_direction_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_true_wind_direction_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_true_wind_direction_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_true_wind_direction_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription();
        } else if (R.id.read_true_wind_direction_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionCharacteristicUserDescription(1);
        } else if (R.id.write_true_wind_direction_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_true_wind_direction_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindDirectionCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_true_wind_direction_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionValidRange();
        } else if (R.id.read_true_wind_direction_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindDirectionValidRange(1);
        }
    }

    private void onTrueWindSpeed(MenuItem item) {
        if (R.id.read_true_wind_speed_count == item.getItemId()) {
            addRow("getTrueWindSpeedCount", mEnvironmentalSensingProfile.getTrueWindSpeedCount());
        } else if (R.id.is_true_wind_speed_notificatable_0 == item.getItemId()) {
            addRow("isTrueWindSpeedNotificatable", mEnvironmentalSensingProfile.isTrueWindSpeedNotificatable());
        } else if (R.id.is_true_wind_speed_notificatable_1 == item.getItemId()) {
            addRow("isTrueWindSpeedNotificatable_1", mEnvironmentalSensingProfile.isTrueWindSpeedNotificatable(1));
        } else if (R.id.has_true_wind_speed_esm_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_true_wind_speed_esm_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_true_wind_speed_ests_count_0 == item.getItemId()) {
            addRow("getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_true_wind_speed_ests_count_1 == item.getItemId()) {
            addRow("getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_true_wind_speed_esc_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_true_wind_speed_esc_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_true_wind_speed_cud_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_true_wind_speed_cud_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_true_wind_speed_vr_0 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicValidRange", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicValidRange());
        } else if (R.id.has_true_wind_speed_vr_1 == item.getItemId()) {
            addRow("hasTrueWindSpeedCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasTrueWindSpeedCharacteristicValidRange(1));
        } else if (R.id.read_true_wind_speed_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeed();
        } else if (R.id.read_true_wind_speed_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeed(1);
        } else if (R.id.notify_true_wind_speed_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindSpeedNotification();
        } else if (R.id.notify_true_wind_speed_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startTrueWindSpeedNotification(1);
        } else if (R.id.notify_true_wind_speed_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindSpeedNotification();
        } else if (R.id.notify_true_wind_speed_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopTrueWindSpeedNotification(1);
        } else if (R.id.read_true_wind_speed_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingMeasurement();
        } else if (R.id.read_true_wind_speed_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_true_wind_speed_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_true_wind_speed_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_true_wind_speed_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_true_wind_speed_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_true_wind_speed_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_true_wind_speed_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_true_wind_speed_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingConfiguration();
        } else if (R.id.read_true_wind_speed_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_true_wind_speed_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_true_wind_speed_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_true_wind_speed_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicUserDescription();
        } else if (R.id.read_true_wind_speed_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedCharacteristicUserDescription(1);
        } else if (R.id.write_true_wind_speed_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_true_wind_speed_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setTrueWindSpeedCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_true_wind_speed_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedValidRange();
        } else if (R.id.read_true_wind_speed_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getTrueWindSpeedValidRange(1);
        }
    }

    private void onUVIndex(MenuItem item) {
        if (R.id.read_uv_index_count == item.getItemId()) {
            addRow("getUVIndexCount", mEnvironmentalSensingProfile.getUVIndexCount());
        } else if (R.id.is_uv_index_notificatable_0 == item.getItemId()) {
            addRow("isUVIndexNotificatable", mEnvironmentalSensingProfile.isUVIndexNotificatable());
        } else if (R.id.is_uv_index_notificatable_1 == item.getItemId()) {
            addRow("isUVIndexNotificatable_1", mEnvironmentalSensingProfile.isUVIndexNotificatable(1));
        } else if (R.id.has_uv_index_esm_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_uv_index_esm_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_uv_index_ests_count_0 == item.getItemId()) {
            addRow("getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_uv_index_ests_count_1 == item.getItemId()) {
            addRow("getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_uv_index_esc_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_uv_index_esc_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_uv_index_cud_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasUVIndexCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_uv_index_cud_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_uv_index_vr_0 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicValidRange", mEnvironmentalSensingProfile.hasUVIndexCharacteristicValidRange());
        } else if (R.id.has_uv_index_vr_1 == item.getItemId()) {
            addRow("hasUVIndexCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasUVIndexCharacteristicValidRange(1));
        } else if (R.id.read_uv_index_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndex();
        } else if (R.id.read_uv_index_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndex(1);
        } else if (R.id.notify_uv_index_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startUVIndexNotification();
        } else if (R.id.notify_uv_index_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startUVIndexNotification(1);
        } else if (R.id.notify_uv_index_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopUVIndexNotification();
        } else if (R.id.notify_uv_index_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopUVIndexNotification(1);
        } else if (R.id.read_uv_index_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingMeasurement();
        } else if (R.id.read_uv_index_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_uv_index_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_uv_index_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_uv_index_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_uv_index_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_uv_index_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_uv_index_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_uv_index_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingConfiguration();
        } else if (R.id.read_uv_index_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_uv_index_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_uv_index_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_uv_index_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexCharacteristicUserDescription();
        } else if (R.id.read_uv_index_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexCharacteristicUserDescription(1);
        } else if (R.id.write_uv_index_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_uv_index_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setUVIndexCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_uv_index_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexValidRange();
        } else if (R.id.read_uv_index_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getUVIndexValidRange(1);
        }
    }

    private void onWindChill(MenuItem item) {
        if (R.id.read_wind_chill_count == item.getItemId()) {
            addRow("getWindChillCount", mEnvironmentalSensingProfile.getWindChillCount());
        } else if (R.id.is_wind_chill_notificatable_0 == item.getItemId()) {
            addRow("isWindChillNotificatable", mEnvironmentalSensingProfile.isWindChillNotificatable());
        } else if (R.id.is_wind_chill_notificatable_1 == item.getItemId()) {
            addRow("isWindChillNotificatable_1", mEnvironmentalSensingProfile.isWindChillNotificatable(1));
        } else if (R.id.has_wind_chill_esm_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingMeasurement", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingMeasurement());
        } else if (R.id.has_wind_chill_esm_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingMeasurement_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingMeasurement(1));
        } else if (R.id.read_wind_chill_ests_count_0 == item.getItemId()) {
            addRow("getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount", mEnvironmentalSensingProfile.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        } else if (R.id.read_wind_chill_ests_count_1 == item.getItemId()) {
            addRow("getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount_1", mEnvironmentalSensingProfile.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(1));
        } else if (R.id.has_wind_chill_esc_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingConfiguration", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingConfiguration());
        } else if (R.id.has_wind_chill_esc_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicEnvironmentalSensingConfiguration_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicEnvironmentalSensingConfiguration(1));
        } else if (R.id.has_wind_chill_cud_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicCharacteristicUserDescription", mEnvironmentalSensingProfile.hasWindChillCharacteristicCharacteristicUserDescription());
        } else if (R.id.has_wind_chill_cud_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicCharacteristicUserDescription_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicCharacteristicUserDescription(1));
        } else if (R.id.has_wind_chill_vr_0 == item.getItemId()) {
            addRow("hasWindChillCharacteristicValidRange", mEnvironmentalSensingProfile.hasWindChillCharacteristicValidRange());
        } else if (R.id.has_wind_chill_vr_1 == item.getItemId()) {
            addRow("hasWindChillCharacteristicValidRange_1", mEnvironmentalSensingProfile.hasWindChillCharacteristicValidRange(1));
        } else if (R.id.read_wind_chill_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChill();
        } else if (R.id.read_wind_chill_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChill(1);
        } else if (R.id.notify_wind_chill_start_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.startWindChillNotification();
        } else if (R.id.notify_wind_chill_start_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.startWindChillNotification(1);
        } else if (R.id.notify_wind_chill_stop_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopWindChillNotification();
        } else if (R.id.notify_wind_chill_stop_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.stopWindChillNotification(1);
        } else if (R.id.read_wind_chill_esm_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingMeasurement();
        } else if (R.id.read_wind_chill_esm_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingMeasurement(1);
        } else if (R.id.read_wind_chill_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingTriggerSetting();
        } else if (R.id.read_wind_chill_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingTriggerSetting(0, 1);
        } else if (R.id.read_wind_chill_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingTriggerSetting(1, 1);
        } else if (R.id.write_wind_chill_ests_0_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS));
        } else if (R.id.write_wind_chill_ests_0_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE));
        } else if (R.id.write_wind_chill_ests_1_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE));
        } else if (R.id.read_wind_chill_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingConfiguration();
        } else if (R.id.read_wind_chill_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillEnvironmentalSensingConfiguration(1);
        } else if (R.id.write_wind_chill_esc_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.write_wind_chill_esc_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR));
        } else if (R.id.read_wind_chill_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillCharacteristicUserDescription();
        } else if (R.id.read_wind_chill_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillCharacteristicUserDescription(1);
        } else if (R.id.write_wind_chill_cud_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillCharacteristicUserDescription(new CharacteristicUserDescription("0".getBytes()));
        } else if (R.id.write_wind_chill_cud_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.setWindChillCharacteristicUserDescription(1, new CharacteristicUserDescription("1".getBytes()));
        } else if (R.id.read_wind_chill_vr_0 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillValidRange();
        } else if (R.id.read_wind_chill_vr_1 == item.getItemId()) {
            mEnvironmentalSensingProfile.getWindChillValidRange(1);
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
