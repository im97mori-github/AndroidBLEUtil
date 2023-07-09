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
import org.im97mori.ble.characteristic.u2bcf.AmmoniaConcentration;
import org.im97mori.ble.characteristic.u2bd0.CarbonMonoxideConcentration;
import org.im97mori.ble.characteristic.u2bd1.MethaneConcentration;
import org.im97mori.ble.characteristic.u2bd2.NitrogenDioxideConcentration;
import org.im97mori.ble.characteristic.u2bd3.NonMethaneVolatileOrganicCompoundsConcentration;
import org.im97mori.ble.characteristic.u2bd4.OzoneConcentration;
import org.im97mori.ble.characteristic.u2bd5.ParticulateMatterPm1Concentration;
import org.im97mori.ble.characteristic.u2bd6.ParticulateMatterPm25Concentration;
import org.im97mori.ble.characteristic.u2bd7.ParticulateMatterPm10Concentration;
import org.im97mori.ble.characteristic.u2bd8.SulfurDioxideConcentration;
import org.im97mori.ble.characteristic.u2bd9.SulfurHexafluorideConcentration;
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

        addAmmoniaConcentration(builder);
        addApparentWindDirection(builder);
        addApparentWindSpeed(builder);
        addBarometricPressureTrend(builder);
        addCarbonMonoxideConcentration(builder);
        addDewPoint(builder);
        addElevation(builder);
        addGustFactor(builder);
        addHeatIndex(builder);
        addHumidity(builder);
        addIrradiance(builder);
        addMagneticDeclination(builder);
        addMagneticFluxDensity2D(builder);
        addMagneticFluxDensity3D(builder);
        addMethaneConcentration(builder);
        addNitrogenDioxideConcentration(builder);
        addNitrogenDioxideConcentration(builder);
        addNonMethaneVolatileOrganicCompoundsConcentration(builder);
        addOzoneConcentration(builder);
        addParticulateMatterPm10Concentration(builder);
        addParticulateMatterPm1Concentration(builder);
        addParticulateMatterPm25Concentration(builder);
        addPollenConcentration(builder);
        addPressure(builder);
        addRainfall(builder);
        addSulfurDioxideConcentration(builder);
        addSulfurHexafluorideConcentration(builder);
        addTemperature(builder);
        addTrueWindDirection(builder);
        addTrueWindSpeed(builder);
        addUVIndex(builder);
        addWindChill(builder);

        mEnvironmentalSensingProfileMockCallback = builder
                .build();
    }

    private void addAmmoniaConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addAmmoniaConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new AmmoniaConcentration(new byte[]{50, 51}).getBytes())
                .setAmmoniaConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setAmmoniaConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setAmmoniaConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setAmmoniaConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setAmmoniaConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setAmmoniaConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addAmmoniaConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new AmmoniaConcentration(new byte[]{100, 101}).getBytes())
                .setAmmoniaConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setAmmoniaConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setAmmoniaConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setAmmoniaConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setAmmoniaConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setAmmoniaConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addApparentWindDirection(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addApparentWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(new byte[]{50, 51}).getBytes())
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

                .addApparentWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindDirection(new byte[]{100, 101}).getBytes())
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

    private void addApparentWindSpeed(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addApparentWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindSpeed(new byte[]{50, 51}).getBytes())
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
                .setApparentWindSpeedValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addApparentWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ApparentWindSpeed(new byte[]{100, 101}).getBytes())
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

    private void addBarometricPressureTrend(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addBarometricPressureTrend(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(new byte[]{50}).getBytes())
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
                .setBarometricPressureTrendValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addBarometricPressureTrend(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new BarometricPressureTrend(new byte[]{100}).getBytes())
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

    private void addCarbonMonoxideConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addCarbonMonoxideConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new CarbonMonoxideConcentration(new byte[]{50, 51}).getBytes())
                .setCarbonMonoxideConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setCarbonMonoxideConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setCarbonMonoxideConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setCarbonMonoxideConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setCarbonMonoxideConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setCarbonMonoxideConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addCarbonMonoxideConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new CarbonMonoxideConcentration(new byte[]{100, 101}).getBytes())
                .setCarbonMonoxideConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setCarbonMonoxideConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setCarbonMonoxideConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setCarbonMonoxideConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setCarbonMonoxideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setCarbonMonoxideConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addDewPoint(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addDewPoint(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(new byte[]{50}).getBytes())
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
                .setDewPointValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addDewPoint(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new DewPoint(new byte[]{100}).getBytes())
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

    private void addElevation(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addElevation(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(new byte[]{50, 51, 52}).getBytes())
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
                .setElevationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addElevation(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Elevation(new byte[]{100, 101, 102}).getBytes())
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

    private void addGustFactor(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addGustFactor(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(new byte[]{50}).getBytes())
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
                .setGustFactorValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addGustFactor(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new GustFactor(new byte[]{100}).getBytes())
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

    private void addHeatIndex(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addHeatIndex(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(new byte[]{50}).getBytes())
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
                .setHeatIndexValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addHeatIndex(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new HeatIndex(new byte[]{100}).getBytes())
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

    private void addHumidity(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addHumidity(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(new byte[]{50, 51}).getBytes())
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
                .setHumidityValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addHumidity(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Humidity(new byte[]{100, 101}).getBytes())
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

    private void addIrradiance(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addIrradiance(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(new byte[]{50, 51}).getBytes())
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
                .setIrradianceValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addIrradiance(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Irradiance(new byte[]{100, 101}).getBytes())
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

    private void addMagneticDeclination(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addMagneticDeclination(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(new byte[]{50, 51}).getBytes())
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
                .setMagneticDeclinationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addMagneticDeclination(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticDeclination(new byte[]{100, 101}).getBytes())
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

    private void addMagneticFluxDensity2D(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addMagneticFluxDensity2D(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(new byte[]{50, 51, 52, 53}).getBytes())
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
                .setMagneticFluxDensity2DValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addMagneticFluxDensity2D(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity2D(new byte[]{100, 101, 102, 103}).getBytes())
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

    private void addMagneticFluxDensity3D(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addMagneticFluxDensity3D(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(new byte[]{50, 51, 52, 53, 54, 55}).getBytes())
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
                .setMagneticFluxDensity3DValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addMagneticFluxDensity3D(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MagneticFluxDensity3D(new byte[]{100, 101, 102, 103, 104, 105}).getBytes())
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

    private void addMethaneConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addMethaneConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MethaneConcentration(new byte[]{50, 51}).getBytes())
                .setMethaneConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setMethaneConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMethaneConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMethaneConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMethaneConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setMethaneConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addMethaneConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new MethaneConcentration(new byte[]{100, 101}).getBytes())
                .setMethaneConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setMethaneConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setMethaneConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setMethaneConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setMethaneConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setMethaneConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addNitrogenDioxideConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addNitrogenDioxideConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new NitrogenDioxideConcentration(new byte[]{50, 51}).getBytes())
                .setNitrogenDioxideConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setNitrogenDioxideConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setNitrogenDioxideConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setNitrogenDioxideConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setNitrogenDioxideConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setNitrogenDioxideConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addNitrogenDioxideConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new NitrogenDioxideConcentration(new byte[]{100, 101}).getBytes())
                .setNitrogenDioxideConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setNitrogenDioxideConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setNitrogenDioxideConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setNitrogenDioxideConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setNitrogenDioxideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setNitrogenDioxideConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addNonMethaneVolatileOrganicCompoundsConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addNonMethaneVolatileOrganicCompoundsConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new NonMethaneVolatileOrganicCompoundsConcentration(new byte[]{50, 51}).getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addNonMethaneVolatileOrganicCompoundsConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new NonMethaneVolatileOrganicCompoundsConcentration(new byte[]{100, 101}).getBytes())
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setNonMethaneVolatileOrganicCompoundsConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setNonMethaneVolatileOrganicCompoundsConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addOzoneConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addOzoneConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new OzoneConcentration(new byte[]{50, 51}).getBytes())
                .setOzoneConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setOzoneConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setOzoneConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setOzoneConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setOzoneConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setOzoneConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addOzoneConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new OzoneConcentration(new byte[]{100, 101}).getBytes())
                .setOzoneConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setOzoneConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setOzoneConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setOzoneConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setOzoneConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setOzoneConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addParticulateMatterPm10Concentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addParticulateMatterPm10Concentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ParticulateMatterPm10Concentration(new byte[]{50, 51}).getBytes())
                .setParticulateMatterPm10ConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setParticulateMatterPm10ConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setParticulateMatterPm10ConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setParticulateMatterPm10ConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setParticulateMatterPm10ConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setParticulateMatterPm10ConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addParticulateMatterPm10Concentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ParticulateMatterPm10Concentration(new byte[]{100, 101}).getBytes())
                .setParticulateMatterPm10ConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setParticulateMatterPm10ConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setParticulateMatterPm10ConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setParticulateMatterPm10ConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setParticulateMatterPm10ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setParticulateMatterPm10ConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addParticulateMatterPm1Concentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addParticulateMatterPm1Concentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ParticulateMatterPm1Concentration(new byte[]{50, 51}).getBytes())
                .setParticulateMatterPm1ConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setParticulateMatterPm1ConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setParticulateMatterPm1ConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setParticulateMatterPm1ConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setParticulateMatterPm1ConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setParticulateMatterPm1ConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addParticulateMatterPm1Concentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ParticulateMatterPm1Concentration(new byte[]{100, 101}).getBytes())
                .setParticulateMatterPm1ConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setParticulateMatterPm1ConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setParticulateMatterPm1ConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setParticulateMatterPm1ConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setParticulateMatterPm1ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setParticulateMatterPm1ConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addParticulateMatterPm25Concentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addParticulateMatterPm25Concentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ParticulateMatterPm25Concentration(new byte[]{50, 51}).getBytes())
                .setParticulateMatterPm25ConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setParticulateMatterPm25ConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setParticulateMatterPm25ConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setParticulateMatterPm25ConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setParticulateMatterPm25ConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setParticulateMatterPm25ConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addParticulateMatterPm25Concentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new ParticulateMatterPm25Concentration(new byte[]{100, 101}).getBytes())
                .setParticulateMatterPm25ConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setParticulateMatterPm25ConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setParticulateMatterPm25ConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setParticulateMatterPm25ConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setParticulateMatterPm25ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setParticulateMatterPm25ConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addPollenConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addPollenConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(new byte[]{50, 51, 52}).getBytes())
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
                .setPollenConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addPollenConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new PollenConcentration(new byte[]{100, 101, 102}).getBytes())
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

    private void addPressure(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addPressure(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(new byte[]{50, 51, 52, 53}).getBytes())
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
                .setPressureValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addPressure(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Pressure(new byte[]{100, 101, 102, 103}).getBytes())
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

    private void addRainfall(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addRainfall(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(new byte[]{50, 51}).getBytes())
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
                .setRainfallValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addRainfall(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Rainfall(new byte[]{100, 101}).getBytes())
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

    private void addSulfurDioxideConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addSulfurDioxideConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new SulfurDioxideConcentration(new byte[]{50, 51}).getBytes())
                .setSulfurDioxideConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setSulfurDioxideConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setSulfurDioxideConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setSulfurDioxideConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setSulfurDioxideConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setSulfurDioxideConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addSulfurDioxideConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new SulfurDioxideConcentration(new byte[]{100, 101}).getBytes())
                .setSulfurDioxideConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setSulfurDioxideConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setSulfurDioxideConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setSulfurDioxideConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setSulfurDioxideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setSulfurDioxideConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addSulfurHexafluorideConcentration(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addSulfurHexafluorideConcentration(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new SulfurHexafluorideConcentration(new byte[]{50, 51}).getBytes())
                .setSulfurHexafluorideConcentrationEsMeasurement(0, new EnvironmentalSensingMeasurement(new byte[]{0, 1}
                        , 2
                        , 3
                        , 4
                        , 5
                        , 6))
                .setSulfurHexafluorideConcentrationEsTriggerSetting(0
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setSulfurHexafluorideConcentrationEsTriggerSetting(0
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setSulfurHexafluorideConcentrationEsConfiguration(0
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setSulfurHexafluorideConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription("0".getBytes()))
                .setSulfurHexafluorideConcentrationValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addSulfurHexafluorideConcentration(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new SulfurHexafluorideConcentration(new byte[]{100, 101}).getBytes())
                .setSulfurHexafluorideConcentrationEsMeasurement(1, new EnvironmentalSensingMeasurement(new byte[]{12, 13}
                        , 14
                        , 15
                        , 16
                        , 17
                        , 18))
                .setSulfurHexafluorideConcentrationEsTriggerSetting(1
                        , 0
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_INACTIVE))
                .setSulfurHexafluorideConcentrationEsTriggerSetting(1
                        , 1
                        , new EnvironmentalSensingTriggerSetting(EnvironmentalSensingTriggerSetting.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS))
                .setSulfurHexafluorideConcentrationEsConfiguration(1
                        , new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND))
                .setSulfurHexafluorideConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription("00".getBytes()))
                .setSulfurHexafluorideConcentrationValidRange(1, new ValidRange(new byte[]{19, 20}, new byte[]{21, 22}));
    }

    private void addTemperature(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addTemperature(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(new byte[]{50, 51}).getBytes())
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
                .setTemperatureValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addTemperature(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new Temperature(new byte[]{100, 101}).getBytes())
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

    private void addTrueWindDirection(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addTrueWindDirection(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(new byte[]{50, 51}).getBytes())
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
                .setTrueWindDirectionValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addTrueWindDirection(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindDirection(new byte[]{100, 101}).getBytes())
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

    private void addTrueWindSpeed(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addTrueWindSpeed(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(new byte[]{50, 51}).getBytes())
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
                .setTrueWindSpeedValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addTrueWindSpeed(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new TrueWindSpeed(new byte[]{100, 101}).getBytes())
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

    private void addUVIndex(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addUVIndex(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new UVIndex(new byte[]{50}).getBytes())
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
                .setUVIndexValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addUVIndex(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new UVIndex(new byte[]{100}).getBytes())
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

    private void addWindChill(EnvironmentalSensingProfileMockCallback.Builder<EspCallbackSample> builder) {
        builder.addWindChill(0, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(new byte[]{50}).getBytes())
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
                .setWindChillValidRange(0, new ValidRange(new byte[]{0, 1}, new byte[]{9, 10}))

                .addWindChill(1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGatt.GATT_SUCCESS, 0, new WindChill(new byte[]{100}).getBytes())
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
    public void onCallback(final Pair<String, String> log) {
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
