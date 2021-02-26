package org.im97mori.ble.service.aios.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedProperties;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable", "ConstantConditions"})
public class AutomationIOServiceTest_003 extends AbstractAutomationIOServiceTest {

    @Test
    public void test_getDigitalCount_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        assertNull(automationIOService.getDigitalCount());
    }

    @Test
    public void test_getDigitalCount_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    public void test_getDigitalCount_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    public void test_getDigitalCount_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalReadable());
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable());
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalReadable());
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable());
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalReadable(1));
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable(1));
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable(1));
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalReadable(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritable());
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable());
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritable());
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable());
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalNotificatable());
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalNotificatable());
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalNotificatable());
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalNotificatable());
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalReadable(1));
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalNotificatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalNotificatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalNotificatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalIndicatable());
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalIndicatable());
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalIndicatable());
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalIndicatable());
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalIndicatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalIndicatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalIndicatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalIndicatable(1));
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00005() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, false).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00006() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00007() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00105() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, false).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00106() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00107() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00005() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00006() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00007() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00105() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00106() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00107() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00005() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00105() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    public void test_getAnalogCount_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        assertNull(automationIOService.getAnalogCount());
    }

    @Test
    public void test_getAnalogCount_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        Integer count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    public void test_getAnalogCount_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    public void test_getAnalogCount_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogReadable());
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable());
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogReadable());
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable());
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogReadable(1));
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable(1));
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable(1));
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogReadable(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritable());
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable());
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritable());
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable());
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogNotificatable());
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogNotificatable());
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogNotificatable());
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogNotificatable());
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogReadable(1));
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogNotificatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogNotificatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogNotificatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogIndicatable());
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogIndicatable());
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogIndicatable());
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogIndicatable());
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogIndicatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogIndicatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogIndicatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogIndicatable(1));
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00005() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, false).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00006() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00007() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00105() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, false).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00106() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00107() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00005() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00006() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00007() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00105() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00106() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00107() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00005() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00102() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00104() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00105() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    public void test_isAggregateCharacteristicSupporeted_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAggregateSupporeted());
    }

    @Test
    public void test_isAggregateCharacteristicSupporeted_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.isAggregateSupporeted());
    }

    @Test
    public void test_isAggregateCharacteristicReadable_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAggregateReadable());
    }

    @Test
    public void test_isAggregateCharacteristicReadable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.isAggregateReadable());
    }

    @Test
    public void test_isAggregateCharacteristicReadable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.isAggregateReadable());
    }

    @Test
    public void test_isAggregateCharacteristicNotificatable_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAggregateNotificatable());
    }

    @Test
    public void test_isAggregateCharacteristicNotificatable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.isAggregateNotificatable());
    }

    @Test
    public void test_isAggregateCharacteristicNotificatable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.isAggregateNotificatable());
    }

    @Test
    public void test_isAggregateCharacteristicNotificatable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.isAggregateNotificatable());
    }

    @Test
    public void test_isAggregateCharacteristicIndicatable_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_isAggregateCharacteristicIndicatable_00002() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_isAggregateCharacteristicIndicatable_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_isAggregateCharacteristicIndicatable_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_getDigital_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigital(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigital());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigital_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigital();
        assertNull(taskId);
    }

    @Test
    public void test_getDigital_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigital();
        assertNull(taskId);
    }

    @Test
    public void test_getDigital_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigital();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigital_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigital(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigital_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigital(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigital_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigital(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigital_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigital(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigital_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigital(int index, @NonNull Digital digital) {
                originalIndex.set(index);
                return super.setDigital(index, digital);
            }

        };

        assertNull(automationIOService.setDigital(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setDigital_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigital(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigital_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigital(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigital_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigital(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigital_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigital(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigital_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigital(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigital_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigital(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigital_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigital(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalWithNoResponse_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalWithNoResponse(int index, @NonNull Digital digital) {
                originalIndex.set(index);
                return super.setDigitalWithNoResponse(index, digital);
            }

        };

        assertNull(automationIOService.setDigitalWithNoResponse(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setDigitalWithNoResponse_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalWithNoResponse_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalWithNoResponse_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalWithNoResponse_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalWithNoResponse_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalWithNoResponse_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalWithNoResponse_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalClientCharacteristicConfiguration(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalClientCharacteristicConfiguration());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00006() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00105() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startDigitalNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startDigitalNotification(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.startDigitalNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_startDigitalNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startDigitalNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopDigitalNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopDigitalNotification(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.stopDigitalNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_stopDigitalNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopDigitalNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startDigitalIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startDigitalIndication(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.startDigitalIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_startDigitalIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startDigitalIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_startDigitalIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopDigitalIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopDigitalIndication(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.stopDigitalIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_stopDigitalIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopDigitalIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopDigitalIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalCharacteristicPresentationFormat(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalCharacteristicPresentationFormat());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalCharacteristicUserDescription(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalCharacteristicUserDescription());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalCharacteristicUserDescriptionn_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                originalIndex.set(index);
                return super.setDigitalCharacteristicUserDescription(index, characteristicUserDescription);
            }

        };

        assertNull(automationIOService.setDigitalCharacteristicUserDescription(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalCharacteristicExtendedProperties(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalCharacteristicExtendedProperties());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalValueTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalValueTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                originalIndex.set(index);
                return super.setAnalogValueTriggerSetting(index, valueTriggerSetting);
            }

        };

        assertNull(automationIOService.setDigitalValueTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalTimeTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalTimeTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
                originalIndex.set(index);
                return super.setDigitalTimeTriggerSetting(index, timeTriggerSetting);
            }

        };

        assertNull(automationIOService.setDigitalTimeTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalNumberOfDigitals(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalNumberOfDigitals());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalNumberOfDigitals();
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalNumberOfDigitals(1);
        assertNull(taskId);
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalog_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalog(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalog());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalog_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalog();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalog_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalog();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalog_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalog();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalog_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalog(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalog_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalog(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalog_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalog(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalog_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalog(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalog_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalog(int index, @NonNull Analog analog) {
                originalIndex.set(index);
                return super.setAnalog(index, analog);
            }

        };

        assertNull(automationIOService.setAnalog(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setAnalog_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalog(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalog_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalog(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalog_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalog(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalog_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalog_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalog_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalog_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogWithNoResponse_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogWithNoResponse(int index, @NonNull Analog analog) {
                originalIndex.set(index);
                return super.setAnalogWithNoResponse(index, analog);
            }

        };

        assertNull(automationIOService.setAnalogWithNoResponse(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setAnalogWithNoResponse_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogWithNoResponse_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogWithNoResponse_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogWithNoResponse_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogWithNoResponse_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogWithNoResponse_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogWithNoResponse_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogClientCharacteristicConfiguration(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogClientCharacteristicConfiguration());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00006() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00105() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startAnalogNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startAnalogNotification(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.startAnalogNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_startAnalogNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startAnalogNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopAnalogNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopAnalogNotification(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.stopAnalogNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_stopAnalogNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopAnalogNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startAnalogIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startAnalogIndication(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.startAnalogIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_startAnalogIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startAnalogIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_startAnalogIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopAnalogIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopAnalogIndication(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.stopAnalogIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_stopAnalogIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopAnalogIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    public void test_stopAnalogIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogCharacteristicPresentationFormat(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogCharacteristicPresentationFormat());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogCharacteristicUserDescription(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogCharacteristicUserDescription());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogCharacteristicUserDescriptionn_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                originalIndex.set(index);
                return super.setAnalogCharacteristicUserDescription(index, characteristicUserDescription);
            }

        };

        assertNull(automationIOService.setAnalogCharacteristicUserDescription(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattDescriptor.setValue(new CharacteristicExtendedProperties(false, true).getBytes());
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogCharacteristicExtendedProperties(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogCharacteristicExtendedProperties());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogValueTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogValueTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                originalIndex.set(index);
                return super.setAnalogValueTriggerSetting(index, valueTriggerSetting);
            }

        };

        assertNull(automationIOService.setAnalogValueTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogTimeTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogTimeTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
                originalIndex.set(index);
                return super.setAnalogTimeTriggerSetting(index, timeTriggerSetting);
            }

        };

        assertNull(automationIOService.setAnalogTimeTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogValidRange_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogValidRange(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogValidRange());
        assertEquals(0, originalIndex.get());
    }

    @Test
    public void test_getAnalogValidRange_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValidRange();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValidRange_00003() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValidRange();
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValidRange_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };

        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValidRange();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAnalogValidRange_00101() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValidRange(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValidRange_00102() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValidRange(1);
        assertNull(taskId);
    }

    @Test
    public void test_getAnalogValidRange_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValidRange(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAggregate_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAggregate();
        assertNull(taskId);
    }

    @Test
    public void test_getAggregate_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAggregate();
        assertNull(taskId);
    }

    @Test
    public void test_getAggregate_00003() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregate();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00006() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00007() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startAggregateNotification_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateNotification_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateNotification_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopAggregateNotification_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateNotification_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateNotification_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_startAggregateIndication_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateIndication_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateIndication_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_startAggregateIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    public void test_stopAggregateIndication_00001() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateIndication_00003() {
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(new MockBLEConnection(), new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateIndication_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        bluetoothGattService.addCharacteristic(BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    public void test_stopAggregateIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }
        };
        AutomationIOService automationIOService = new AutomationIOService(mockBLEConnection, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        Parcel parcel = createBluetoothCharacteristicParcel(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.<BluetoothGattDescriptor>emptyList());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BluetoothGattCharacteristic.CREATOR.createFromParcel(parcel);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        parcel.recycle();
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

}
