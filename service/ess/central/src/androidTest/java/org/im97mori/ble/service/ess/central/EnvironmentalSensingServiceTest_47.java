package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class EnvironmentalSensingServiceTest_47 extends AbstractCentralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCount_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressureCount());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCount_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        Integer count = environmentalSensingService.getPressureCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCount_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCount_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCount_00005() {
        final AtomicBoolean isStarted = new AtomicBoolean(true);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return isStarted.get();
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        Integer count = environmentalSensingService.getPressureCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());

        isStarted.set(false);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCount_00006() {
        final AtomicBoolean isStarted = new AtomicBoolean(true);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return isStarted.get();
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);
        isStarted.set(false);

        Integer count = environmentalSensingService.getPressureCount();
        assertNull(count);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.isPressureNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.isPressureNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isPressureNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isPressureNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isPressureNotificatable(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isPressureNotificatable(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isPressureNotificatable(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isPressureNotificatable_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isPressureNotificatable(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingMeasurement_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(0);
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(1);
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicEnvironmentalSensingTriggerSettingCount_00009() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(1);
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicEnvironmentalSensingConfiguration_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicCharacteristicUserDescription_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasPressureCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicValidRange(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasPressureCharacteristicValidRange(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasPressureCharacteristicValidRange_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasPressureCharacteristicValidRange(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressure_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressure());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressure_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getPressure());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressure_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressure());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressure_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressure());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressure_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressure(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressure_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressure(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressure_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressure(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.startPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.startPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startPressureNotification(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startPressureNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startPressureNotification_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startPressureNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.stopPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.stopPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopPressureNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopPressureNotification(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopPressureNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopPressureNotification_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopPressureNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingMeasurement_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting());
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting(0, 0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting(0, 1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting(0, 1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00009() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting(1, 0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingTriggerSetting_00010() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingTriggerSetting(1, 1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00009() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingTriggerSetting_00010() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureEnvironmentalSensingConfiguration_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureEnvironmentalSensingConfiguration_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressureCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getPressureCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureCharacteristicUserDescription_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setPressureCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setPressureCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setPressureCharacteristicUserDescription(1, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setPressureCharacteristicUserDescription_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setPressureCharacteristicUserDescription(1, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getPressureValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getPressureValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureValidRange(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getPressureValidRange(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getPressureValidRange_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getPressureValidRange(1));
    }

}
