package org.im97mori.ble.sample.lolipop.esp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a2c.MagneticDeclination;
import org.im97mori.ble.characteristic.u2a6c.Elevation;
import org.im97mori.ble.characteristic.u2a6d.Pressure;
import org.im97mori.ble.characteristic.u2a6e.Temperature;
import org.im97mori.ble.characteristic.u2a6f.Humidity;
import org.im97mori.ble.characteristic.u2a70.TrueWindSpeed;
import org.im97mori.ble.characteristic.u2a71.TrueWindDirection;
import org.im97mori.ble.characteristic.u2a72.ApparentWindSpeed;
import org.im97mori.ble.characteristic.u2a73.ApparentWindDirection;
import org.im97mori.ble.characteristic.u2a74.GustFactor;
import org.im97mori.ble.characteristic.u2a75.PollenConcentration;
import org.im97mori.ble.characteristic.u2a76.UVIndex;
import org.im97mori.ble.characteristic.u2a77.Irradiance;
import org.im97mori.ble.characteristic.u2a78.Rainfall;
import org.im97mori.ble.characteristic.u2a79.WindChill;
import org.im97mori.ble.characteristic.u2a7a.HeatIndex;
import org.im97mori.ble.characteristic.u2a7b.DewPoint;
import org.im97mori.ble.characteristic.u2aa0.MagneticFluxDensity2D;
import org.im97mori.ble.characteristic.u2aa1.MagneticFluxDensity3D;
import org.im97mori.ble.characteristic.u2aa3.BarometricPressureTrend;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.profile.esp.peripheral.EnvironmentalSensingProfileMockCallback;
import org.im97mori.ble.sample.lolipop.AlertDialogFragment;
import org.im97mori.ble.sample.lolipop.BaseActivity;
import org.im97mori.ble.sample.lolipop.R;
import org.im97mori.ble.sample.lolipop.SampleCallback;

import java.util.LinkedList;

public class EspPeripheralSampleActivity extends BaseActivity implements View.OnClickListener, AlertDialogFragment.AlertDialogFragmentCallback, SampleCallback {

    private Button mConnectDisconnectButton;

    private ArrayAdapter<Pair<String, String>> mAdapter;
    private ListView mListView;

    private EnvironmentalSensingProfileMockCallback mEnvironmentalSensingProfileMockCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder = new EspCallbackSample.Builder(this, this, false, false)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .addManufacturerNameString("Manufacturer Name String data esp")
                .addModelNumberString("Model Number String data esp")
                .addBatteryLevel(0, new BatteryLevel(10))
                .addBatteryLevel(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new BatteryLevel(20).getBytes(), -1);

        awd(builder);
        aws(builder);
        dp(builder);
        elevation(builder);
        gf(builder);
        hi(builder);
        humidity(builder);
        irradiance(builder);
        pc(builder);
        rainfall(builder);
        pressure(builder);
        temperature(builder);
        twd(builder);
        tws(builder);
        uvi(builder);
        wc(builder);
        bpt(builder);
        md(builder);
        mfd2d(builder);
        mfd3d(builder);

        mEnvironmentalSensingProfileMockCallback = builder
                .build();
    }

    private void awd(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addApparentWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(9).getBytes())
                .setApparentWindDirectionEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setApparentWindDirectionEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setApparentWindDirectionEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setApparentWindDirectionEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setApparentWindDirectionCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setApparentWindDirectionValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addApparentWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(11).getBytes())
                .setApparentWindDirectionEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setApparentWindDirectionEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setApparentWindDirectionEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setApparentWindDirectionEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setApparentWindDirectionCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setApparentWindDirectionValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void aws(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addApparentWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindSpeed(9).getBytes())
                .setApparentWindSpeedEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setApparentWindSpeedEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setApparentWindSpeedEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setApparentWindSpeedEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setApparentWindSpeedCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setApparentWindSpeedValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addApparentWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindSpeed(11).getBytes())
                .setApparentWindSpeedEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setApparentWindSpeedEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setApparentWindSpeedEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setApparentWindSpeedEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setApparentWindSpeedCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setApparentWindSpeedValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void dp(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addDewPoint(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(9).getBytes())
                .setDewPointEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setDewPointEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setDewPointEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setDewPointEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setDewPointCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setDewPointValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addDewPoint(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(11).getBytes())
                .setDewPointEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setDewPointEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setDewPointEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setDewPointEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setDewPointCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setDewPointValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void elevation(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addElevation(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(9).getBytes())
                .setElevationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setElevationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setElevationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setElevationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setElevationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setElevationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addElevation(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(11).getBytes())
                .setElevationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setElevationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setElevationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setElevationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setElevationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setElevationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void gf(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addGustFactor(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(9).getBytes())
                .setGustFactorEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setGustFactorEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setGustFactorEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setGustFactorEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setGustFactorCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setGustFactorValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addGustFactor(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(11).getBytes())
                .setGustFactorEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setGustFactorEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setGustFactorEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setGustFactorEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setGustFactorCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setGustFactorValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void hi(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addHeatIndex(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(9).getBytes())
                .setHeatIndexEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setHeatIndexEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setHeatIndexEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setHeatIndexEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setHeatIndexCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setHeatIndexValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addHeatIndex(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(11).getBytes())
                .setHeatIndexEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setHeatIndexEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setHeatIndexEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setHeatIndexEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setHeatIndexCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setHeatIndexValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void humidity(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addHumidity(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(9).getBytes())
                .setHumidityEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setHumidityEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setHumidityEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setHumidityEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setHumidityCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setHumidityValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addHumidity(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(11).getBytes())
                .setHumidityEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setHumidityEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setHumidityEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setHumidityEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setHumidityCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setHumidityValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void irradiance(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addIrradiance(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(9).getBytes())
                .setIrradianceEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setIrradianceEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setIrradianceEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setIrradianceEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setIrradianceCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setIrradianceValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addIrradiance(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(11).getBytes())
                .setIrradianceEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setIrradianceEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setIrradianceEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setIrradianceEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setIrradianceCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setIrradianceValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void pc(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addPollenConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(9).getBytes())
                .setPollenConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setPollenConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setPollenConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setPollenConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setPollenConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setPollenConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addPollenConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(11).getBytes())
                .setPollenConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setPollenConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setPollenConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setPollenConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setPollenConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setPollenConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void rainfall(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addRainfall(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(9).getBytes())
                .setRainfallEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setRainfallEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setRainfallEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setRainfallEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setRainfallCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setRainfallValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addRainfall(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(11).getBytes())
                .setRainfallEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setRainfallEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setRainfallEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setRainfallEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setRainfallCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setRainfallValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void pressure(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addPressure(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(9).getBytes())
                .setPressureEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setPressureEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setPressureEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setPressureEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setPressureCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setPressureValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addPressure(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(11).getBytes())
                .setPressureEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setPressureEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setPressureEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setPressureEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setPressureCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setPressureValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void temperature(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addTemperature(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(9).getBytes())
                .setTemperatureEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setTemperatureEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setTemperatureEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setTemperatureEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setTemperatureCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setTemperatureValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addTemperature(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(11).getBytes())
                .setTemperatureEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setTemperatureEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setTemperatureEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setTemperatureEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setTemperatureCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setTemperatureValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void twd(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addTrueWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(9).getBytes())
                .setTrueWindDirectionEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setTrueWindDirectionEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setTrueWindDirectionEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setTrueWindDirectionEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setTrueWindDirectionCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setTrueWindDirectionValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addTrueWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(11).getBytes())
                .setTrueWindDirectionEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setTrueWindDirectionEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setTrueWindDirectionEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setTrueWindDirectionEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setTrueWindDirectionCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setTrueWindDirectionValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void tws(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addTrueWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(9).getBytes())
                .setTrueWindSpeedEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setTrueWindSpeedEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setTrueWindSpeedEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setTrueWindSpeedEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setTrueWindSpeedCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setTrueWindSpeedValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addTrueWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(11).getBytes())
                .setTrueWindSpeedEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setTrueWindSpeedEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setTrueWindSpeedEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setTrueWindSpeedEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setTrueWindSpeedCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setTrueWindSpeedValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void uvi(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addUVIndex(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new UVIndex(9).getBytes())
                .setUVIndexEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setUVIndexEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setUVIndexEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setUVIndexEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setUVIndexCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setUVIndexValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addUVIndex(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new UVIndex(11).getBytes())
                .setUVIndexEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setUVIndexEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setUVIndexEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setUVIndexEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setUVIndexCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setUVIndexValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void wc(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addWindChill(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(9).getBytes())
                .setWindChillEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setWindChillEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setWindChillEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setWindChillEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setWindChillCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setWindChillValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addWindChill(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(11).getBytes())
                .setWindChillEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setWindChillEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setWindChillEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setWindChillEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setWindChillCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setWindChillValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void bpt(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addBarometricPressureTrend(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(9).getBytes())
                .setBarometricPressureTrendEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setBarometricPressureTrendEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setBarometricPressureTrendEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setBarometricPressureTrendEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setBarometricPressureTrendCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setBarometricPressureTrendValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addBarometricPressureTrend(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(11).getBytes())
                .setBarometricPressureTrendEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setBarometricPressureTrendEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setBarometricPressureTrendEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setBarometricPressureTrendEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setBarometricPressureTrendCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setBarometricPressureTrendValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void md(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addMagneticDeclination(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(9).getBytes())
                .setMagneticDeclinationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setMagneticDeclinationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMagneticDeclinationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMagneticDeclinationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMagneticDeclinationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setMagneticDeclinationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addMagneticDeclination(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(11).getBytes())
                .setMagneticDeclinationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setMagneticDeclinationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMagneticDeclinationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMagneticDeclinationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMagneticDeclinationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setMagneticDeclinationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void mfd2d(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addMagneticFluxDensity2D(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(100, 101).getBytes())
                .setMagneticFluxDensity2DEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setMagneticFluxDensity2DEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMagneticFluxDensity2DEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMagneticFluxDensity2DEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMagneticFluxDensity2DCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setMagneticFluxDensity2DValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addMagneticFluxDensity2D(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(200, 201).getBytes())
                .setMagneticFluxDensity2DEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setMagneticFluxDensity2DEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMagneticFluxDensity2DEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMagneticFluxDensity2DEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMagneticFluxDensity2DCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setMagneticFluxDensity2DValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void mfd3d(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addMagneticFluxDensity3D(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(100, 101, 102).getBytes())
                .setMagneticFluxDensity3DEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setMagneticFluxDensity3DEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMagneticFluxDensity3DEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMagneticFluxDensity3DEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMagneticFluxDensity3DCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setMagneticFluxDensity3DValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}));

        builder.addMagneticFluxDensity3D(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(200, 201, 202).getBytes())
                .setMagneticFluxDensity3DEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setMagneticFluxDensity3DEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMagneticFluxDensity3DEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMagneticFluxDensity3DEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMagneticFluxDensity3DCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setMagneticFluxDensity3DValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
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
        if (mEnvironmentalSensingProfileMockCallback != null) {
            mEnvironmentalSensingProfileMockCallback.quit();
        }
        super.onDestroy();
    }

    protected void updateLayout() {
        if (!BLEUtilsAndroid.isBluetoothEnabled(this)) {
            BLEUtilsAndroid.bluetoothEnable(this);
        } else if (mEnvironmentalSensingProfileMockCallback.isStarted()) {
            mConnectDisconnectButton.setText(R.string.stop);
        } else {
            mConnectDisconnectButton.setText(R.string.start);
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onClick(View v) {
        if (R.id.connectDisconnectButton == v.getId()) {
            if (mEnvironmentalSensingProfileMockCallback.isStarted()) {
                mEnvironmentalSensingProfileMockCallback.quit();
            } else {
                mEnvironmentalSensingProfileMockCallback.start();
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

            if ("onDeviceConnected".equals(log.first)) {
                mEnvironmentalSensingProfileMockCallback.stopAdvertising();
            }
        });
    }
}
