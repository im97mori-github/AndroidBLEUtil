package org.im97mori.ble.profile.aiop.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.profile.aiop.central.db.AutomationIOProfileBondedDatabaseHelper;
import org.im97mori.ble.service.aios.central.AutomationIOService;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AutomationIOProfileTest {

    @Test
    public void test_findAutomationIOProfileDevices_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.findAutomationIOProfileDevices(null));
    }

    @Test
    public void test_findAutomationIOProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        automationIOProfile.start();
        assertNotNull(automationIOProfile.findAutomationIOProfileDevices(bundle));
        assertTrue(atomicBoolean.get());
        automationIOProfile.quit();
    }

    @Test
    public void test_getDigitalCount_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalCount());
    }

    @Test
    public void test_getDigitalCount_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalCount());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicReadable());
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicReadable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicReadable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicReadable(1));
    }

    @Test
    public void test_isDigitalCharacteristicReadable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicReadable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicReadable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicWritable());
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicWritable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicWritable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicWritableWithNoResponse());
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicWritableWithNoResponse(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicWritableWithNoResponse());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicWritableWithNoResponse(1));
    }

    @Test
    public void test_isDigitalCharacteristicWritableWithNoResponse_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicWritableWithNoResponse(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicWritableWithNoResponse(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicNotificatable());
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicNotificatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicNotificatable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicNotificatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicNotificatable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicNotificatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicNotificatable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicIndicatable());
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicIndicatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicIndicatable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicIndicatable(1));
    }

    @Test
    public void test_isDigitalCharacteristicIndicatable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicIndicatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicIndicatable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicPresentationFormatDescriptor());
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicPresentationFormatDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicPresentationFormatDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicPresentationFormatDescriptor(1));
    }

    @Test
    public void test_hasDigitalCharacteristicPresentationFormatDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicPresentationFormatDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicPresentationFormatDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicCharacteristicUserDescriptionDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable());
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable(1));
    }

    @Test
    public void test_isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isDigitalCharacteristicCharacteristicUserDescriptionDescriptorWritable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor());
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor(1));
    }

    @Test
    public void test_hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicCharacteristicExtendedPropertiesDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicValueTriggerSettingDescriptor());
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicValueTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicValueTriggerSettingDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicValueTriggerSettingDescriptor(1));
    }

    @Test
    public void test_hasDigitalCharacteristicValueTriggerSettingDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicValueTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicValueTriggerSettingDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicTimeTriggerSettingDescriptor());
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicTimeTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicTimeTriggerSettingDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasDigitalCharacteristicTimeTriggerSettingDescriptor(1));
    }

    @Test
    public void test_hasDigitalCharacteristicTimeTriggerSettingDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasDigitalCharacteristicTimeTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasDigitalCharacteristicTimeTriggerSettingDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogCount_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogCount());
    }

    @Test
    public void test_getAnalogCount_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogCount());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicReadable());
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicReadable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicReadable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicReadable(1));
    }

    @Test
    public void test_isAnalogCharacteristicReadable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicReadable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicReadable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicWritable());
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicWritable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicWritable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicWritableWithNoResponse());
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicWritableWithNoResponse(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicWritableWithNoResponse());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicWritableWithNoResponse(1));
    }

    @Test
    public void test_isAnalogCharacteristicWritableWithNoResponse_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicWritableWithNoResponse(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicWritableWithNoResponse(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicNotificatable());
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicNotificatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicNotificatable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicNotificatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicNotificatable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicNotificatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicNotificatable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicIndicatable());
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicIndicatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicIndicatable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicIndicatable(1));
    }

    @Test
    public void test_isAnalogCharacteristicIndicatable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicIndicatable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicIndicatable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicPresentationFormatDescriptor());
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicPresentationFormatDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicPresentationFormatDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicPresentationFormatDescriptor(1));
    }

    @Test
    public void test_hasAnalogCharacteristicPresentationFormatDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicPresentationFormatDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicPresentationFormatDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicCharacteristicUserDescriptionDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable());
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable(1));
    }

    @Test
    public void test_isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAnalogCharacteristicCharacteristicUserDescriptionDescriptorWritable(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor());
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor(1));
    }

    @Test
    public void test_hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicCharacteristicExtendedPropertiesDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicValueTriggerSettingDescriptor());
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicValueTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicValueTriggerSettingDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicValueTriggerSettingDescriptor(1));
    }

    @Test
    public void test_hasAnalogCharacteristicValueTriggerSettingDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicValueTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicValueTriggerSettingDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicTimeTriggerSettingDescriptor());
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicTimeTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicTimeTriggerSettingDescriptor());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.hasAnalogCharacteristicTimeTriggerSettingDescriptor(1));
    }

    @Test
    public void test_hasAnalogCharacteristicTimeTriggerSettingDescriptor_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean hasAnalogCharacteristicTimeTriggerSettingDescriptor(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.hasAnalogCharacteristicTimeTriggerSettingDescriptor(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAggregateCharacteristicSupporeted_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAggregateCharacteristicSupporeted());
    }

    @Test
    public void test_isAggregateCharacteristicSupporeted_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAggregateCharacteristicSupporeted() {
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAggregateCharacteristicSupporeted());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAggregateCharacteristicReadable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAggregateCharacteristicReadable());
    }

    @Test
    public void test_isAggregateCharacteristicReadable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAggregateCharacteristicReadable() {
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAggregateCharacteristicReadable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAggregateCharacteristicNotificatable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAggregateCharacteristicNotificatable());
    }

    @Test
    public void test_isAggregateCharacteristicNotificatable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAggregateCharacteristicNotificatable() {
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAggregateCharacteristicNotificatable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_isAggregateCharacteristicIndicatable_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.isAggregateCharacteristicIndicatable());
    }

    @Test
    public void test_isAggregateCharacteristicIndicatable_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public boolean isAggregateCharacteristicIndicatable() {
                            atomicBoolean.set(true);
                            return true;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.isAggregateCharacteristicIndicatable());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigital_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigital());
    }

    @Test
    public void test_getDigital_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigital(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigital());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigital_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigital(1));
    }

    @Test
    public void test_getDigital_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigital(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigital(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigital_00001() {
        final Digital originalDigital = new Digital(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigital(originalDigital));
    }

    @Test
    public void test_setDigital_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final Digital originalDigital = new Digital(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigital(int index, @NonNull Digital digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalDigital.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigital(originalDigital));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigital_00101() {
        final Digital originalDigital = new Digital(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigital(1, originalDigital));
    }

    @Test
    public void test_setDigital_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final Digital originalDigital = new Digital(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigital(int index, @NonNull Digital digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalDigital.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigital(originalIndex, originalDigital));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalWithNoResponse_00001() {
        final Digital originalDigital = new Digital(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalWithNoResponse(originalDigital));
    }

    @Test
    public void test_setDigitalWithNoResponse_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final Digital originalDigital = new Digital(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalWithNoResponse(int index, @NonNull Digital digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalDigital.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalWithNoResponse(originalDigital));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalWithNoResponse_00101() {
        final Digital originalDigital = new Digital(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalWithNoResponse(1, originalDigital));
    }

    @Test
    public void test_setDigitalWithNoResponse_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final Digital originalDigital = new Digital(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalWithNoResponse(int index, @NonNull Digital digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalDigital.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalWithNoResponse(originalIndex, originalDigital));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalClientCharacteristicConfiguration());
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalClientCharacteristicConfiguration(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalClientCharacteristicConfiguration());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalClientCharacteristicConfiguration(1));
    }

    @Test
    public void test_getDigitalClientCharacteristicConfiguration_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalClientCharacteristicConfiguration(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalClientCharacteristicConfiguration(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startDigitalNotification_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startDigitalNotification());
    }

    @Test
    public void test_startDigitalNotification_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startDigitalNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startDigitalNotification());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startDigitalNotification_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startDigitalNotification(1));
    }

    @Test
    public void test_startDigitalNotification_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startDigitalNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startDigitalNotification(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopDigitalNotification_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopDigitalNotification());
    }

    @Test
    public void test_stopDigitalNotification_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopDigitalNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopDigitalNotification());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopDigitalNotification_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopDigitalNotification(1));
    }

    @Test
    public void test_stopDigitalNotification_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopDigitalNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopDigitalNotification(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startDigitalIndication_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startDigitalIndication());
    }

    @Test
    public void test_startDigitalIndication_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startDigitalIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startDigitalIndication());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startDigitalIndication_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startDigitalIndication(1));
    }

    @Test
    public void test_startDigitalIndication_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startDigitalIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startDigitalIndication(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopDigitalIndication_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopDigitalIndication());
    }

    @Test
    public void test_stopDigitalIndication_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopDigitalIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopDigitalIndication());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopDigitalIndication_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopDigitalIndication(1));
    }

    @Test
    public void test_stopDigitalIndication_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopDigitalIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopDigitalIndication(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalCharacteristicPresentationFormat());
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalCharacteristicPresentationFormat(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalCharacteristicPresentationFormat());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_getDigitalCharacteristicPresentationFormat_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalCharacteristicPresentationFormat(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalCharacteristicPresentationFormat(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalCharacteristicUserDescription());
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalCharacteristicUserDescription(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalCharacteristicUserDescription());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalCharacteristicUserDescription(1));
    }

    @Test
    public void test_getDigitalCharacteristicUserDescription_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalCharacteristicUserDescription(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalCharacteristicUserDescription(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00001() {
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalCharacteristicUserDescription(originalCharacteristicUserDescription));
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalCharacteristicUserDescription.getBytes(), characteristicUserDescription.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalCharacteristicUserDescription(originalCharacteristicUserDescription));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00101() {
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalCharacteristicUserDescription(1, originalCharacteristicUserDescription));
    }

    @Test
    public void test_setDigitalCharacteristicUserDescription_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalCharacteristicUserDescription.getBytes(), characteristicUserDescription.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalCharacteristicUserDescription(originalIndex, originalCharacteristicUserDescription));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalCharacteristicExtendedProperties());
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalCharacteristicExtendedProperties(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalCharacteristicExtendedProperties());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_getDigitalCharacteristicExtendedProperties_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalCharacteristicExtendedProperties(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalCharacteristicExtendedProperties(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalValueTriggerSetting());
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalValueTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalValueTriggerSetting());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalValueTriggerSetting(1));
    }

    @Test
    public void test_getDigitalValueTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalValueTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalValueTriggerSetting(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00001() {
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalValueTriggerSetting(originalValueTriggerSetting));
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalValueTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalValueTriggerSetting(originalValueTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00101() {
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalValueTriggerSetting(1, originalValueTriggerSetting));
    }

    @Test
    public void test_setDigitalValueTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalValueTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalValueTriggerSetting(originalIndex, originalValueTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalTimeTriggerSetting());
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalTimeTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalTimeTriggerSetting());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalTimeTriggerSetting(1));
    }

    @Test
    public void test_getDigitalTimeTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalTimeTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalTimeTriggerSetting(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00001() {
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalTimeTriggerSetting(originalTimeTriggerSetting));
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalTimeTriggerSetting(int index, @NonNull TimeTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalTimeTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalTimeTriggerSetting(originalTimeTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00101() {
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setDigitalTimeTriggerSetting(1, originalTimeTriggerSetting));
    }

    @Test
    public void test_setDigitalTimeTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setDigitalTimeTriggerSetting(int index, @NonNull TimeTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalTimeTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setDigitalTimeTriggerSetting(originalIndex, originalTimeTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalNumberOfDigitals());
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalNumberOfDigitals(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalNumberOfDigitals());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getDigitalNumberOfDigitals(1));
    }

    @Test
    public void test_getDigitalNumberOfDigitals_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getDigitalNumberOfDigitals(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getDigitalNumberOfDigitals(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalog_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalog());
    }

    @Test
    public void test_getAnalog_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalog(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalog());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalog_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalog(1));
    }

    @Test
    public void test_getAnalog_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalog(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalog(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalog_00001() {
        final Analog originalAnalog = new Analog(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalog(originalAnalog));
    }

    @Test
    public void test_setAnalog_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final Analog originalAnalog = new Analog(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalog(int index, @NonNull Analog digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalAnalog.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalog(originalAnalog));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalog_00101() {
        final Analog originalAnalog = new Analog(new byte[]{1, 2});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalog(1, originalAnalog));
    }

    @Test
    public void test_setAnalog_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final Analog originalAnalog = new Analog(new byte[]{1, 2});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalog(int index, @NonNull Analog digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalAnalog.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalog(originalIndex, originalAnalog));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogWithNoResponse_00001() {
        final Analog originalAnalog = new Analog(new byte[]{1, 2});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogWithNoResponse(originalAnalog));
    }

    @Test
    public void test_setAnalogWithNoResponse_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final Analog originalAnalog = new Analog(new byte[]{1, 2});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogWithNoResponse(int index, @NonNull Analog digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalAnalog.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogWithNoResponse(originalAnalog));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogWithNoResponse_00101() {
        final Analog originalAnalog = new Analog(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogWithNoResponse(1, originalAnalog));
    }

    @Test
    public void test_setAnalogWithNoResponse_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final Analog originalAnalog = new Analog(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogWithNoResponse(int index, @NonNull Analog digital) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalAnalog.getBytes(), digital.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogWithNoResponse(originalIndex, originalAnalog));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogClientCharacteristicConfiguration());
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogClientCharacteristicConfiguration(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogClientCharacteristicConfiguration());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogClientCharacteristicConfiguration(1));
    }

    @Test
    public void test_getAnalogClientCharacteristicConfiguration_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogClientCharacteristicConfiguration(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogClientCharacteristicConfiguration(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startAnalogNotification_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startAnalogNotification());
    }

    @Test
    public void test_startAnalogNotification_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startAnalogNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startAnalogNotification());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startAnalogNotification_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startAnalogNotification(1));
    }

    @Test
    public void test_startAnalogNotification_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startAnalogNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startAnalogNotification(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopAnalogNotification_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopAnalogNotification());
    }

    @Test
    public void test_stopAnalogNotification_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopAnalogNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopAnalogNotification());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopAnalogNotification_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopAnalogNotification(1));
    }

    @Test
    public void test_stopAnalogNotification_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopAnalogNotification(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopAnalogNotification(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startAnalogIndication_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startAnalogIndication());
    }

    @Test
    public void test_startAnalogIndication_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startAnalogIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startAnalogIndication());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startAnalogIndication_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startAnalogIndication(1));
    }

    @Test
    public void test_startAnalogIndication_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startAnalogIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startAnalogIndication(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopAnalogIndication_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopAnalogIndication());
    }

    @Test
    public void test_stopAnalogIndication_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopAnalogIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopAnalogIndication());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopAnalogIndication_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopAnalogIndication(1));
    }

    @Test
    public void test_stopAnalogIndication_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopAnalogIndication(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopAnalogIndication(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogCharacteristicPresentationFormat());
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogCharacteristicPresentationFormat(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogCharacteristicPresentationFormat());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    public void test_getAnalogCharacteristicPresentationFormat_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogCharacteristicPresentationFormat(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogCharacteristicPresentationFormat(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogCharacteristicUserDescription());
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogCharacteristicUserDescription(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogCharacteristicUserDescription());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogCharacteristicUserDescription(1));
    }

    @Test
    public void test_getAnalogCharacteristicUserDescription_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogCharacteristicUserDescription(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogCharacteristicUserDescription(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00001() {
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogCharacteristicUserDescription(originalCharacteristicUserDescription));
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalCharacteristicUserDescription.getBytes(), characteristicUserDescription.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogCharacteristicUserDescription(originalCharacteristicUserDescription));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00101() {
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogCharacteristicUserDescription(1, originalCharacteristicUserDescription));
    }

    @Test
    public void test_setAnalogCharacteristicUserDescription_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final CharacteristicUserDescription originalCharacteristicUserDescription = new CharacteristicUserDescription(new byte[]{1});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalCharacteristicUserDescription.getBytes(), characteristicUserDescription.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogCharacteristicUserDescription(originalIndex, originalCharacteristicUserDescription));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogCharacteristicExtendedProperties());
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogCharacteristicExtendedProperties(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogCharacteristicExtendedProperties());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    public void test_getAnalogCharacteristicExtendedProperties_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogCharacteristicExtendedProperties(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogCharacteristicExtendedProperties(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogValueTriggerSetting());
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogValueTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogValueTriggerSetting());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogValueTriggerSetting(1));
    }

    @Test
    public void test_getAnalogValueTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogValueTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogValueTriggerSetting(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00001() {
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogValueTriggerSetting(originalValueTriggerSetting));
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalValueTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogValueTriggerSetting(originalValueTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00101() {
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogValueTriggerSetting(1, originalValueTriggerSetting));
    }

    @Test
    public void test_setAnalogValueTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final ValueTriggerSetting originalValueTriggerSetting = new ValueTriggerSetting(new byte[]{ValueTriggerSetting.NONE_0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalValueTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogValueTriggerSetting(originalIndex, originalValueTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogTimeTriggerSetting());
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogTimeTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogTimeTriggerSetting());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogTimeTriggerSetting(1));
    }

    @Test
    public void test_getAnalogTimeTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogTimeTriggerSetting(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogTimeTriggerSetting(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00001() {
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogTimeTriggerSetting(originalTimeTriggerSetting));
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogTimeTriggerSetting(int index, @NonNull TimeTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalTimeTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }


                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogTimeTriggerSetting(originalTimeTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00101() {
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.setAnalogTimeTriggerSetting(1, originalTimeTriggerSetting));
    }

    @Test
    public void test_setAnalogTimeTriggerSetting_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        final TimeTriggerSetting originalTimeTriggerSetting = new TimeTriggerSetting(new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0});
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer setAnalogTimeTriggerSetting(int index, @NonNull TimeTriggerSetting valueTriggerSetting) {
                            assertEquals(originalIndex, index);
                            assertArrayEquals(originalTimeTriggerSetting.getBytes(), valueTriggerSetting.getBytes());
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.setAnalogTimeTriggerSetting(originalIndex, originalTimeTriggerSetting));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogValidRange_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogValidRange());
    }

    @Test
    public void test_getAnalogValidRange_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 0;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogValidRange(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogValidRange());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAnalogValidRange_00101() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAnalogValidRange(1));
    }

    @Test
    public void test_getAnalogValidRange_00102() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalIndex = 1;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAnalogValidRange(int index) {
                            assertEquals(originalIndex, index);
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAnalogValidRange(originalIndex));
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAggregate_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAggregate());
    }

    @Test
    public void test_getAggregate_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAggregate() {
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAggregate());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.getAggregateClientCharacteristicConfiguration());
    }

    @Test
    public void test_getAggregateClientCharacteristicConfiguration_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer getAggregateClientCharacteristicConfiguration() {
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.getAggregateClientCharacteristicConfiguration());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startAggregateNotification_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startAggregateNotification());
    }

    @Test
    public void test_startAggregateNotification_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startAggregateNotification() {
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startAggregateNotification());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopAggregateNotification_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopAggregateNotification());
    }

    @Test
    public void test_stopAggregateNotification_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopAggregateNotification() {
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopAggregateNotification());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_startAggregateIndication_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.startAggregateIndication());
    }

    @Test
    public void test_startAggregateIndication_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer startAggregateIndication() {
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.startAggregateIndication());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_stopAggregateIndication_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertNull(automationIOProfile.stopAggregateIndication());
    }

    @Test
    public void test_stopAggregateIndication_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()) {
            @Override
            public synchronized void createServices() {
                if (mAutomationIOService == null) {
                    mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null) {

                        @Override
                        public synchronized Integer stopAggregateIndication() {
                            atomicBoolean.set(true);
                            return 1;
                        }

                    };
                }
            }
        };
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.stopAggregateIndication());
        assertTrue(atomicBoolean.get());
        automationIOProfile.disconnect();
    }

    @Test
    public void test_getDatabaseHelper_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        assertTrue(automationIOProfile.getDatabaseHelper() instanceof AutomationIOProfileBondedDatabaseHelper);
    }

    @Test
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback()){
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        automationIOProfile.connect(MOCK_DEVICE);
        assertNotNull(automationIOProfile.mAutomationIOService);
        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_quit_00001() {
        AutomationIOProfile automationIOProfile = new AutomationIOProfile(ApplicationProvider.getApplicationContext(), new BaseAutomationIOProfileCallback());
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        automationIOProfile.connect(MOCK_DEVICE);
        automationIOProfile.quit();
        assertNull(automationIOProfile.mAutomationIOService);
    }

}
