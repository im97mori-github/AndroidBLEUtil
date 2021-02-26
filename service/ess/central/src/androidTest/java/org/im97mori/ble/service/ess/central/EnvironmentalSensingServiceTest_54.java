package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class EnvironmentalSensingServiceTest_54 {

    @Test
    public void test_getMagneticDeclinationCount_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCount());
    }

    @Test
    public void test_getMagneticDeclinationCount_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        Integer count = environmentalSensingService.getMagneticDeclinationCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCount_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCount_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCount_00005() {
        final AtomicBoolean isStarted = new AtomicBoolean(true);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return isStarted.get();
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        Integer count = environmentalSensingService.getMagneticDeclinationCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());

        isStarted.set(false);
    }

    @Test
    public void test_getMagneticDeclinationCount_00006() {
        final AtomicBoolean isStarted = new AtomicBoolean(true);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return isStarted.get();
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);
        isStarted.set(false);

        Integer count = environmentalSensingService.getMagneticDeclinationCount();
        assertNull(count);
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.isMagneticDeclinationNotificatable());
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.isMagneticDeclinationNotificatable());
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isMagneticDeclinationNotificatable());
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isMagneticDeclinationNotificatable());
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isMagneticDeclinationNotificatable(0));
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isMagneticDeclinationNotificatable(1));
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isMagneticDeclinationNotificatable(1));
    }

    @Test
    public void test_isMagneticDeclinationNotificatable_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isMagneticDeclinationNotificatable(1));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(0));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(1));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement_00008() {
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
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(1));
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(1);
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount_00009() {
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
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(1);
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(1));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration_00008() {
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
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(1));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription(0));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicCharacteristicUserDescription_00008() {
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
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange());
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange(0));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange(1));
    }

    @Test
    public void test_hasMagneticDeclinationCharacteristicValidRange_00008() {
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
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasMagneticDeclinationCharacteristicValidRange(1));
    }

    @Test
    public void test_getMagneticDeclination_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclination());
    }

    @Test
    public void test_getMagneticDeclination_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getMagneticDeclination());
    }

    @Test
    public void test_getMagneticDeclination_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclination());
    }

    @Test
    public void test_getMagneticDeclination_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclination());
    }

    @Test
    public void test_getMagneticDeclination_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclination(0));
    }

    @Test
    public void test_getMagneticDeclination_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclination(1));
    }

    @Test
    public void test_getMagneticDeclination_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclination(1));
    }

    @Test
    public void test_startMagneticDeclinationNotification_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.startMagneticDeclinationNotification());
    }

    @Test
    public void test_startMagneticDeclinationNotification_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.startMagneticDeclinationNotification());
    }

    @Test
    public void test_startMagneticDeclinationNotification_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startMagneticDeclinationNotification());
    }

    @Test
    public void test_startMagneticDeclinationNotification_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startMagneticDeclinationNotification());
    }

    @Test
    public void test_startMagneticDeclinationNotification_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startMagneticDeclinationNotification());
    }

    @Test
    public void test_startMagneticDeclinationNotification_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startMagneticDeclinationNotification(0));
    }

    @Test
    public void test_startMagneticDeclinationNotification_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startMagneticDeclinationNotification(1));
    }

    @Test
    public void test_startMagneticDeclinationNotification_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startMagneticDeclinationNotification(1));
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.stopMagneticDeclinationNotification());
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.stopMagneticDeclinationNotification());
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopMagneticDeclinationNotification());
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopMagneticDeclinationNotification());
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopMagneticDeclinationNotification());
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopMagneticDeclinationNotification(0));
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopMagneticDeclinationNotification(1));
    }

    @Test
    public void test_stopMagneticDeclinationNotification_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createSetNotificationTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopMagneticDeclinationNotification(1));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement(0));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement(1));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingMeasurement_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement(1));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting());
    }


    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 0));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00009() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 0));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingTriggerSetting_00010() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 1));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }


    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00009() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingTriggerSetting_00010() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration());
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration(0));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration(1));
    }

    @Test
    public void test_getMagneticDeclinationEnvironmentalSensingConfiguration_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration(1));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_setMagneticDeclinationEnvironmentalSensingConfiguration_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription());
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription(0));
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription(1));
    }

    @Test
    public void test_getMagneticDeclinationCharacteristicUserDescription_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationCharacteristicUserDescription(1));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(1, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_setMagneticDeclinationCharacteristicUserDescription_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(1, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getMagneticDeclinationValidRange());
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getMagneticDeclinationValidRange());
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationValidRange());
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationValidRange());
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationValidRange());
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationValidRange(0));
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getMagneticDeclinationValidRange(1));
    }

    @Test
    public void test_getMagneticDeclinationValidRange_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(mockBLEConnection, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_DECLINATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getMagneticDeclinationValidRange(1));
    }

}
