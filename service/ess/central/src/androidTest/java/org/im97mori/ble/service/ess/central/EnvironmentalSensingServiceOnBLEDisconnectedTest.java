package org.im97mori.ble.service.ess.central;

import static org.im97mori.ble.constants.CharacteristicUUID.AMMONIA_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DEW_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ELEVATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.METHANE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.OZONE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;

public class EnvironmentalSensingServiceOnBLEDisconnectedTest extends AbstractCentralTest {


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onBLEDisconnected_000001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        BluetoothGattDescriptor bluetoothGattDescriptor;

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AMMONIA_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(METHANE_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OZONE_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getAmmoniaConcentrationCount());
        assertEquals(1, environmentalSensingService.getAmmoniaConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getApparentWindDirectionCount());
        assertEquals(1, environmentalSensingService.getApparentWindDirectionCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getApparentWindSpeedCount());
        assertEquals(1, environmentalSensingService.getApparentWindSpeedCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCount());
        assertEquals(1, environmentalSensingService.getBarometricPressureTrendCount().intValue());
        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getCarbonMonoxideConcentrationCount());
        assertEquals(1, environmentalSensingService.getCarbonMonoxideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getDewPointCount());
        assertEquals(1, environmentalSensingService.getDewPointCount().intValue());
        assertNotNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getElevationCount());
        assertEquals(1, environmentalSensingService.getElevationCount().intValue());
        assertNotNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getGustFactorCount());
        assertEquals(1, environmentalSensingService.getGustFactorCount().intValue());
        assertNotNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getHeatIndexCount());
        assertEquals(1, environmentalSensingService.getHeatIndexCount().intValue());
        assertNotNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getHumidityCount());
        assertEquals(1, environmentalSensingService.getHumidityCount().intValue());
        assertNotNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getIrradianceCount());
        assertEquals(1, environmentalSensingService.getIrradianceCount().intValue());
        assertNotNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMagneticDeclinationCount());
        assertEquals(1, environmentalSensingService.getMagneticDeclinationCount().intValue());
        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCount());
        assertEquals(1, environmentalSensingService.getMagneticFluxDensity2DCount().intValue());
        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCount());
        assertEquals(1, environmentalSensingService.getMagneticFluxDensity3DCount().intValue());
        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMethaneConcentrationCount());
        assertEquals(1, environmentalSensingService.getMethaneConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getNitrogenDioxideConcentrationCount());
        assertEquals(1, environmentalSensingService.getNitrogenDioxideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCount());
        assertEquals(1, environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getOzoneConcentrationCount());
        assertEquals(1, environmentalSensingService.getOzoneConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getParticulateMatterPm10ConcentrationCount());
        assertEquals(1, environmentalSensingService.getParticulateMatterPm10ConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getParticulateMatterPm1ConcentrationCount());
        assertEquals(1, environmentalSensingService.getParticulateMatterPm1ConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCount());
        assertEquals(1, environmentalSensingService.getParticulateMatterPm25ConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getPollenConcentrationCount());
        assertEquals(1, environmentalSensingService.getPollenConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getPressureCount());
        assertEquals(1, environmentalSensingService.getPressureCount().intValue());
        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getRainfallCount());
        assertEquals(1, environmentalSensingService.getRainfallCount().intValue());
        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getSulfurDioxideConcentrationCount());
        assertEquals(1, environmentalSensingService.getSulfurDioxideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getSulfurHexafluorideConcentrationCount());
        assertEquals(1, environmentalSensingService.getSulfurHexafluorideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getTemperatureCount());
        assertEquals(1, environmentalSensingService.getTemperatureCount().intValue());
        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getTrueWindDirectionCount());
        assertEquals(1, environmentalSensingService.getTrueWindDirectionCount().intValue());
        assertNotNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getTrueWindSpeedCount());
        assertEquals(1, environmentalSensingService.getTrueWindSpeedCount().intValue());
        assertNotNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getUVIndexCount());
        assertEquals(1, environmentalSensingService.getUVIndexCount().intValue());
        assertNotNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getWindChillCount());
        assertEquals(1, environmentalSensingService.getWindChillCount().intValue());
        assertNotNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        environmentalSensingService.onBLEDisconnected(2, BLETestUtilsAndroid.MOCK_DEVICE_0, BluetoothGatt.GATT_SUCCESS, null);

        assertNotNull(environmentalSensingService.getAmmoniaConcentrationCount());
        assertEquals(0, environmentalSensingService.getAmmoniaConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getApparentWindDirectionCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getApparentWindSpeedCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCount().intValue());
        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getCarbonMonoxideConcentrationCount());
        assertEquals(0, environmentalSensingService.getCarbonMonoxideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getDewPointCount());
        assertEquals(0, environmentalSensingService.getDewPointCount().intValue());
        assertNotNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getElevationCount());
        assertEquals(0, environmentalSensingService.getElevationCount().intValue());
        assertNotNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getGustFactorCount());
        assertEquals(0, environmentalSensingService.getGustFactorCount().intValue());
        assertNotNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getHeatIndexCount());
        assertEquals(0, environmentalSensingService.getHeatIndexCount().intValue());
        assertNotNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getHumidityCount());
        assertEquals(0, environmentalSensingService.getHumidityCount().intValue());
        assertNotNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getIrradianceCount());
        assertEquals(0, environmentalSensingService.getIrradianceCount().intValue());
        assertNotNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMagneticDeclinationCount());
        assertEquals(0, environmentalSensingService.getMagneticDeclinationCount().intValue());
        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity2DCount().intValue());
        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity3DCount().intValue());
        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getMethaneConcentrationCount());
        assertEquals(0, environmentalSensingService.getMethaneConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getNitrogenDioxideConcentrationCount());
        assertEquals(0, environmentalSensingService.getNitrogenDioxideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCount());
        assertEquals(0, environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getOzoneConcentrationCount());
        assertEquals(0, environmentalSensingService.getOzoneConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getParticulateMatterPm10ConcentrationCount());
        assertEquals(0, environmentalSensingService.getParticulateMatterPm10ConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getParticulateMatterPm1ConcentrationCount());
        assertEquals(0, environmentalSensingService.getParticulateMatterPm1ConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCount());
        assertEquals(0, environmentalSensingService.getParticulateMatterPm25ConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getPollenConcentrationCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getPressureCount());
        assertEquals(0, environmentalSensingService.getPressureCount().intValue());
        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getRainfallCount());
        assertEquals(0, environmentalSensingService.getRainfallCount().intValue());
        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getSulfurDioxideConcentrationCount());
        assertEquals(0, environmentalSensingService.getSulfurDioxideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getSulfurHexafluorideConcentrationCount());
        assertEquals(0, environmentalSensingService.getSulfurHexafluorideConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getTemperatureCount());
        assertEquals(0, environmentalSensingService.getTemperatureCount().intValue());
        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getTrueWindDirectionCount());
        assertEquals(0, environmentalSensingService.getTrueWindDirectionCount().intValue());
        assertNotNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getTrueWindSpeedCount());
        assertEquals(0, environmentalSensingService.getTrueWindSpeedCount().intValue());
        assertNotNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getUVIndexCount());
        assertEquals(0, environmentalSensingService.getUVIndexCount().intValue());
        assertNotNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getWindChillCount());
        assertEquals(0, environmentalSensingService.getWindChillCount().intValue());
        assertNotNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }
}
