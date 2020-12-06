package org.im97mori.ble.profile.tip.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.service.cts.central.CurrentTimeService;
import org.im97mori.ble.service.ndcs.central.NextDstChangeService;
import org.im97mori.ble.service.rtus.central.ReferenceTimeUpdateService;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.im97mori.ble.BLEConstants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TimeProfileTest {

    @Test
    public void test_findWeightScaleProfileDevices_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.findTimeProfileDevices(BASE_UUID, null));
    }

    @Test
    public void test_findWeightScaleProfileDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        timeProfile.start();
        assertNotNull(timeProfile.findTimeProfileDevices(BASE_UUID, bundle));
        assertTrue(atomicBoolean.get());
        timeProfile.quit();
    }

    @Test
    public void test_hasNextDstChangeService_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.hasNextDstChangeService());
    }

    @Test
    public void test_hasNextDstChangeService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        timeProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(timeProfile.hasNextDstChangeService());
        timeProfile.disconnect();
    }

    @Test
    public void test_hasReferenceTimeUpdateService_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.hasReferenceTimeUpdateService());
    }

    @Test
    public void test_hasReferenceTimeUpdateService_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {
            @Override
            public synchronized boolean isConnected() {
                return true;
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        timeProfile.onDiscoverServiceSuccess(1, MOCK_DEVICE, Collections.singletonList(new BluetoothGattService(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY)), null);
        assertNotNull(timeProfile.hasReferenceTimeUpdateService());
        timeProfile.disconnect();
    }

    @Test
    public void test_isCurrentTimeCharacteristicWritable_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.isCurrentTimeCharacteristicWritable());
    }

    @Test
    public void test_isCurrentTimeCharacteristicWritable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.isCurrentTimeCharacteristicWritable());
        timeProfile.disconnect();
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicSupporeted_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.isLocalTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.isLocalTimeInformationCharacteristicSupporeted());
        timeProfile.disconnect();
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicWritable_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    public void test_isLocalTimeInformationCharacteristicWritable_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.isLocalTimeInformationCharacteristicWritable());
        timeProfile.disconnect();
    }

    @Test
    public void test_isReferenceTimeInformationCharacteristicSupporeted_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.isReferenceTimeInformationCharacteristicSupporeted());
    }

    @Test
    public void test_isReferenceTimeInformationCharacteristicSupporeted_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.isReferenceTimeInformationCharacteristicSupporeted());
        timeProfile.disconnect();
    }

    @Test
    public void test_getCurrentTime_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.getCurrentTime());
    }

    @Test
    public void test_getCurrentTime_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.getCurrentTime());
        timeProfile.disconnect();
    }

    @Test
    public void test_setCurrentTime_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.setCurrentTime(new CurrentTime(new byte[10])));
    }

    @Test
    public void test_setCurrentTime_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isCurrentTimeCharacteristicWritable() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.setCurrentTime(new CurrentTime(new byte[10])));
        timeProfile.disconnect();
    }

    @Test
    public void test_getCurrentTimeClientCharacteristicConfiguration_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCurrentTimeClientCharacteristicConfiguration_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.getCurrentTimeClientCharacteristicConfiguration());
        timeProfile.disconnect();
    }

    @Test
    public void test_startCurrentTimeNotification_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.startCurrentTimeNotification());
    }

    @Test
    public void test_startCurrentTimeNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.startCurrentTimeNotification());
        timeProfile.disconnect();
    }

    @Test
    public void test_stopCurrentTimeNotification_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.stopCurrentTimeNotification());
    }

    @Test
    public void test_stopCurrentTimeNotification_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.stopCurrentTimeNotification());
        timeProfile.disconnect();
    }

    @Test
    public void test_getLocalTimeInformation_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.getLocalTimeInformation());
    }

    @Test
    public void test_getLocalTimeInformation_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isLocalTimeInformationCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.getLocalTimeInformation());
        timeProfile.disconnect();
    }

    @Test
    public void test_setLocalTimeInformation_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
    }

    @Test
    public void test_setLocalTimeInformation_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isLocalTimeInformationCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
        timeProfile.disconnect();
    }

    @Test
    public void test_getReferenceTimeInformation_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.getReferenceTimeInformation());
    }

    @Test
    public void test_getReferenceTimeInformation_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isReferenceTimeInformationCharacteristicSupporeted() {
                            return true;
                        }

                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.getReferenceTimeInformation());
        timeProfile.disconnect();
    }

    @Test
    public void test_getTimeWithDst_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.getTimeWithDst());
    }

    @Test
    public void test_getTimeWithDst_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.getTimeWithDst());
        timeProfile.disconnect();
    }

    @Test
    public void test_setTimeUpdateControlPoint_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.setTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE)));
    }

    @Test
    public void test_setTimeUpdateControlPoint_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.setTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE)));
        timeProfile.disconnect();
    }

    @Test
    public void test_getTimeUpdateState_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback());
        assertNull(timeProfile.getTimeUpdateState());
    }

    @Test
    public void test_getTimeUpdateState_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);
        final BluetoothDevice MOCK_DEVICE = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        BLEConnection bleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null) {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        BLEConnectionHolder.clearInstance();
        BLEConnectionHolder.addInstance(bleConnection, true);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback()) {

            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
                }
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public boolean isStarted() {
                            return true;
                        }
                    };
                }
            }
        };
        timeProfile.connect(MOCK_DEVICE);
        assertNotNull(timeProfile.getTimeUpdateState());
        timeProfile.disconnect();
    }

}
