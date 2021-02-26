package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a2c.MagneticDeclinationAndroid;
import org.im97mori.ble.characteristic.u2a6c.ElevationAndroid;
import org.im97mori.ble.characteristic.u2a6d.PressureAndroid;
import org.im97mori.ble.characteristic.u2a6e.TemperatureAndroid;
import org.im97mori.ble.characteristic.u2a6f.HumidityAndroid;
import org.im97mori.ble.characteristic.u2a70.TrueWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a71.TrueWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a72.ApparentWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a73.ApparentWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a74.GustFactorAndroid;
import org.im97mori.ble.characteristic.u2a75.PollenConcentrationAndroid;
import org.im97mori.ble.characteristic.u2a76.UVIndexAndroid;
import org.im97mori.ble.characteristic.u2a77.IrradianceAndroid;
import org.im97mori.ble.characteristic.u2a78.RainfallAndroid;
import org.im97mori.ble.characteristic.u2a79.WindChillAndroid;
import org.im97mori.ble.characteristic.u2a7a.HeatIndexAndroid;
import org.im97mori.ble.characteristic.u2a7b.DewPointAndroid;
import org.im97mori.ble.characteristic.u2aa0.MagneticFluxDensity2DAndroid;
import org.im97mori.ble.characteristic.u2aa1.MagneticFluxDensity3DAndroid;
import org.im97mori.ble.characteristic.u2aa3.BarometricPressureTrendAndroid;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DEW_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ELEVATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TDS_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.EXTERNAL_REPORT_REFERENCE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable"})
public class EnvironmentalSensingServiceTest_1 {

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.isDescriptorValueChangedCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00107() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCount());
        assertEquals(1, environmentalSensingService.getApparentWindDirectionCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00207() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00208() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00209() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00210() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00305() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00306() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00307() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00308() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00309() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00310() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00402() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00403() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00404() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00405() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00406() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00407() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00408() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00409() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00410() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00502() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00503() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00504() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00505() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00506() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00507() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00508() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00509() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00510() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00602() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00603() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00604() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00605() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00606() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00607() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00608() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00609() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00610() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00702() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00703() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00704() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00705() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00706() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00707() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00708() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00709() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00710() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00802() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00803() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00804() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00805() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00806() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00807() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00808() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00809() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00810() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00901() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00902() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00903() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00904() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00905() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00906() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00907() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00908() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00909() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00910() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01009() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01010() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01107() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01108() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01109() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01110() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01207() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01208() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01209() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01210() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01305() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01306() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01307() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01308() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01309() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01310() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01402() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01403() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01404() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01405() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01406() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01407() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01408() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01409() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01410() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01502() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01503() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01504() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01505() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01506() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01507() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01508() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01509() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01510() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01602() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01603() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01604() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01605() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01606() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01607() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01608() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01609() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01610() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01702() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01703() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01704() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01705() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01706() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01707() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01708() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01709() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01710() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01802() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01803() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01804() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01805() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01806() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01807() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01808() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01809() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01810() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01901() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01902() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01903() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01904() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01905() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01906() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01907() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01908() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01909() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01910() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02009() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02010() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TDS_CONTROL_POINT_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02107() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02108() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02109() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(EXTERNAL_REPORT_REFERENCE_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onDiscoverServiceSuccess_02110() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());
    }

    @Test
    public void test_onBLEDisconnected_000001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
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

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattDescriptor = new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
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

        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
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

        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCount());
        assertEquals(1, environmentalSensingService.getApparentWindDirectionCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getApparentWindSpeedCount());
        assertEquals(1, environmentalSensingService.getApparentWindSpeedCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

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

        assertNotNull(environmentalSensingService.getPollenConcentrationCount());
        assertEquals(1, environmentalSensingService.getPollenConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getRainfallCount());
        assertEquals(1, environmentalSensingService.getRainfallCount().intValue());
        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getPressureCount());
        assertEquals(1, environmentalSensingService.getPressureCount().intValue());
        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getTemperatureCount());
        assertEquals(1, environmentalSensingService.getTemperatureCount().intValue());
        assertNotNull(environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getPressureCount());
        assertEquals(1, environmentalSensingService.getPressureCount().intValue());
        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

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

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCount());
        assertEquals(1, environmentalSensingService.getBarometricPressureTrendCount().intValue());
        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(1, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

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

        environmentalSensingService.onBLEDisconnected(2, MockBLEConnection.MOCK_DEVICE, BluetoothGatt.GATT_SUCCESS, null);

        assertNotNull(environmentalSensingService.getApparentWindDirectionCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getApparentWindSpeedCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCount().intValue());
        assertNotNull(environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

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

        assertNotNull(environmentalSensingService.getPollenConcentrationCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCount().intValue());
        assertNotNull(environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getRainfallCount());
        assertEquals(0, environmentalSensingService.getRainfallCount().intValue());
        assertNotNull(environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

        assertNotNull(environmentalSensingService.getPressureCount());
        assertEquals(0, environmentalSensingService.getPressureCount().intValue());
        assertNotNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

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

        assertNotNull(environmentalSensingService.getBarometricPressureTrendCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCount().intValue());
        assertNotNull(environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount());
        assertEquals(0, environmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount().intValue());

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
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = APPARENT_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(APPARENT_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onApparentWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ApparentWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DewPointAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DewPointAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DewPointAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DEW_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DewPointAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DewPointAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(DEW_POINT_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onDewPointReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DewPointAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ElevationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ElevationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ElevationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ELEVATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ElevationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ElevationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00306() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(ELEVATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onElevationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull ElevationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull GustFactorAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull GustFactorAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull GustFactorAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull GustFactorAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull GustFactorAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00406() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(GUST_FACTOR_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull GustFactorAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HeatIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HeatIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HeatIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HeatIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HeatIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00506() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HEAT_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HeatIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HumidityAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HumidityAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HumidityAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HumidityAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HumidityAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00606() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(HUMIDITY_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull HumidityAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull IrradianceAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull IrradianceAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull IrradianceAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull IrradianceAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull IrradianceAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00706() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(IRRADIANCE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull IrradianceAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PollenConcentrationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PollenConcentrationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PollenConcentrationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = POLLEN_CONCENTRATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PollenConcentrationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PollenConcentrationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00806() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(POLLEN_CONCENTRATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPollenConcentrationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PollenConcentrationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull RainfallAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull RainfallAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(RAINFALL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull RainfallAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RAINFALL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull RainfallAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull RainfallAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00906() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(RAINFALL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onRainfallReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull RainfallAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PressureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PressureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PressureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PRESSURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PressureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PressureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(PRESSURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onPressureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull PressureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TemperatureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TemperatureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TemperatureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TEMPERATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TemperatureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TemperatureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TEMPERATURE_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTemperatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TemperatureAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_DIRECTION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_DIRECTION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindDirectionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindDirectionAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRUE_WIND_SPEED_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01306() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(TRUE_WIND_SPEED_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onTrueWindSpeedReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull TrueWindSpeedAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull UVIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull UVIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull UVIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UV_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull UVIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull UVIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01406() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(UV_INDEX_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onUVIndexReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull UVIndexAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull WindChillAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull WindChillAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(WIND_CHILL_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull WindChillAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WIND_CHILL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull WindChillAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull WindChillAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01506() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(WIND_CHILL_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onWindChillReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull WindChillAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BarometricPressureTrendAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BarometricPressureTrendAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BarometricPressureTrendAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BarometricPressureTrendAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BarometricPressureTrendAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01606() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onBarometricPressureTrendReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull BarometricPressureTrendAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticDeclinationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticDeclinationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticDeclinationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_DECLINATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticDeclinationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticDeclinationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01706() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_DECLINATION_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticDeclinationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticDeclinationAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity2DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity2DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity2DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity2DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity2DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01806() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity2DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity2DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 7, 8, 9, 10};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity3DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 7, 8, 9, 10};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity3DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 7, 8, 9, 10};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity3DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, apparentWindDirectionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 7, 8, 9, 10};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity3DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 7, 8, 9, 10};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity3DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

    @Test
    public void test_onCharacteristicReadSuccess_01906() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 7, 8, 9, 10};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        Parcel parcel = Parcel.obtain();
        parcel.writeParcelable(new ParcelUuid(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC), 0);
        parcel.writeInt(originalCharacteristicInstanceId);
        parcel.writeInt(BluetoothGattCharacteristic.PROPERTY_READ);
        parcel.writeInt(BluetoothGattCharacteristic.PERMISSION_READ);
        parcel.writeInt(16);
        parcel.writeInt(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        parcel.writeTypedList(new ArrayList<BluetoothGattDescriptor>());
        parcel.setDataPosition(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onMagneticFluxDensity3DReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull MagneticFluxDensity3DAndroid apparentWindDirectionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
        mockBLEConnection.onConnectFailed(1, 0, new Bundle());
    }

}
