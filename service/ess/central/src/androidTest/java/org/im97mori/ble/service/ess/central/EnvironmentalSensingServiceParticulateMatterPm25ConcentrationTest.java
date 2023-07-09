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

import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC;
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

public class EnvironmentalSensingServiceParticulateMatterPm25ConcentrationTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCount_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCount());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCount_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCount_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCount();
        assertNotNull(count);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCount_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCount_00005() {
        final AtomicBoolean isStarted = new AtomicBoolean(true);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return isStarted.get();
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());

        isStarted.set(false);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCount_00006() {
        final AtomicBoolean isStarted = new AtomicBoolean(true);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return isStarted.get();
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);
        isStarted.set(false);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCount();
        assertNull(count);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertFalse(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_isParticulateMatterPm25ConcentrationNotificatable_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        assertTrue(environmentalSensingService.isParticulateMatterPm25ConcentrationNotificatable(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
        assertNotNull(count);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1);
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount_00009() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(1);
        assertNotNull(count);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, 0, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00005() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00006() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00007() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_hasParticulateMatterPm25ConcentrationCharacteristicValidRange_00008() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(environmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25Concentration_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25Concentration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25Concentration_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getParticulateMatterPm25Concentration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25Concentration_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25Concentration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25Concentration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25Concentration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25Concentration_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25Concentration(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25Concentration_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25Concentration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25Concentration_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25Concentration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_startParticulateMatterPm25ConcentrationNotification_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.startParticulateMatterPm25ConcentrationNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_stopParticulateMatterPm25ConcentrationNotification_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateSetNotificationTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.stopParticulateMatterPm25ConcentrationNotification(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting());
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00009() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(1, 0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00010() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(1, 1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00009() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(1, 0, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting_00010() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(1, 1, new EnvironmentalSensingTriggerSetting(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(1, new EnvironmentalSensingConfiguration(0)));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationCharacteristicUserDescription_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(0, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_setParticulateMatterPm25ConcentrationCharacteristicUserDescription_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(1, new CharacteristicUserDescription(new byte[1])));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00001() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00002() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00003() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00004() {
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00005() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00006() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange(0));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00007() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange(1));
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_getParticulateMatterPm25ConcentrationValidRange_00008() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, new MockEnvironmentalSensingServiceCallback(), null) {
            @Override
            public synchronized boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(VALID_RANGE_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertNotNull(environmentalSensingService.getParticulateMatterPm25ConcentrationValidRange(1));
    }

}
