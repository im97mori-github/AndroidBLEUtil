package org.im97mori.ble.profile.tip.central;

import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.profile.tip.central.db.TimeProfileBondedDatabaseHelper;
import org.im97mori.ble.service.cts.central.CurrentTimeService;
import org.im97mori.ble.service.ndcs.central.NextDstChangeService;
import org.im97mori.ble.service.rtus.central.ReferenceTimeUpdateService;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.im97mori.ble.constants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TimeProfileTest extends AbstractCentralTest {

    @Override
    public void setup() {
        super.setup();
        BLEConnectionHolder.addInstance(MOCK_BLE_CONNECTION, true);
    }

    @Override
    public void tearDown() {
        super.tearDown();
        BLEConnection bleConnection = BLEConnectionHolder.getInstance(BLETestUtilsAndroid.MOCK_DEVICE_0);
        if (bleConnection instanceof MockBLEConnection) {
            ((MockBLEConnection) bleConnection).quitTaskHandler();
        }
        BLEConnectionHolder.clearInstance();
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_createFilteredScanCallback_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertTrue(timeProfile.createFilteredScanCallback() instanceof TimeProfileScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_createFilteredLeScanCallback_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertTrue(timeProfile.createFilteredLeScanCallback() instanceof TimeProfileLeScanCallback);
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.findDevices( null));
    }

    @Test
    @RequiresDevice
    public void test_findDevices_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Bundle bundle = new Bundle();
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Nullable
            @Override
            public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback, long timeout, @Nullable Bundle argument) {
                assertEquals(bundle, argument);
                atomicBoolean.set(true);
                return super.scanDevice(filteredScanCallback, timeout, argument);
            }
        };
        timeProfile.start();
        assertNotNull(timeProfile.findDevices( bundle));
        assertTrue(atomicBoolean.get());
        timeProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_hasNextDstChangeService_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.hasNextDstChangeService());
    }

    @Test
    @RequiresDevice
    public void test_hasNextDstChangeService_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.hasNextDstChangeService());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasNextDstChangeService_00003() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = timeProfile.hasNextDstChangeService();
        timeProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasNextDstChangeService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(NEXT_DST_CHANGE_SERVICE, 0);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        timeProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = timeProfile.hasNextDstChangeService();
        timeProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_hasReferenceTimeUpdateService_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.hasReferenceTimeUpdateService());
    }

    @Test
    @RequiresDevice
    public void test_hasReferenceTimeUpdateService_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.hasReferenceTimeUpdateService());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_hasReferenceTimeUpdateService_00003() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        Boolean result = timeProfile.hasReferenceTimeUpdateService();
        timeProfile.disconnect();
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    @RequiresDevice
    public void test_hasReferenceTimeUpdateService_00004() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(REFERENCE_TIME_UPDATE_SERVICE, 0);

        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        timeProfile.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        Boolean result = timeProfile.hasReferenceTimeUpdateService();
        timeProfile.disconnect();
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    @RequiresDevice
    public void test_isCurrentTimeCharacteristicWritable_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_isCurrentTimeCharacteristicWritable_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.isCurrentTimeCharacteristicWritable());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicSupported_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicSupported_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.isLocalTimeInformationCharacteristicSupported());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicWritable_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicWritable_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.isLocalTimeInformationCharacteristicWritable());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_isReferenceTimeInformationCharacteristicSupported_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isReferenceTimeInformationCharacteristicSupported_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.isReferenceTimeInformationCharacteristicSupported());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTime_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.getCurrentTime());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTime_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer getCurrentTime() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.getCurrentTime());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.setCurrentTime(new CurrentTime(new byte[10])));
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer setCurrentTime(@NonNull CurrentTime currentTime) {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.setCurrentTime(new CurrentTime(new byte[10])));
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTimeClientCharacteristicConfiguration_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTimeClientCharacteristicConfiguration_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer getCurrentTimeClientCharacteristicConfiguration() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.getCurrentTimeClientCharacteristicConfiguration());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_startCurrentTimeNotification_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.startCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCurrentTimeNotification_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer startCurrentTimeNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.startCurrentTimeNotification());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_stopCurrentTimeNotification_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.stopCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCurrentTimeNotification_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer stopCurrentTimeNotification() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.stopCurrentTimeNotification());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.getLocalTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer getLocalTimeInformation() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.getLocalTimeInformation());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer setLocalTimeInformation(@NonNull LocalTimeInformation localTimeInformation) {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.setLocalTimeInformation(new LocalTimeInformation(new byte[2])));
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.getReferenceTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mCurrentTimeService == null) {
                    mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer getReferenceTimeInformation() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.getReferenceTimeInformation());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTimeWithDst_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.getTimeWithDst());
    }

    @Test
    @RequiresDevice
    public void test_getTimeWithDst_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mNextDstChangeService == null) {
                    mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer getTimeWithDst() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.getTimeWithDst());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_setTimeUpdateControlPoint_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.setTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE)));
    }

    @Test
    @RequiresDevice
    public void test_setTimeUpdateControlPoint_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer setTimeUpdateControlPoint(@NonNull TimeUpdateControlPoint timeUpdateControlPoint) {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.setTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE)));
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getTimeUpdateState_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertNull(timeProfile.getTimeUpdateState());
    }

    @Test
    @RequiresDevice
    public void test_getTimeUpdateState_00002() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                if (mReferenceTimeUpdateService == null) {
                    mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null) {
                        @Override
                        public synchronized Integer getTimeUpdateState() {
                            return 1;
                        }
                    };
                }
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.getTimeUpdateState());
        timeProfile.disconnect();
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseHelper_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        assertTrue(timeProfile.getDatabaseHelper() instanceof TimeProfileBondedDatabaseHelper);
    }

    @Test
    @RequiresDevice
    public void test_createServices_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID) {
            @Override
            public synchronized void createServices() {
                super.createServices();
                atomicBoolean.set(true);
            }
        };
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        assertNotNull(timeProfile.mCurrentTimeService);
        assertNotNull(timeProfile.mNextDstChangeService);
        assertNotNull(timeProfile.mReferenceTimeUpdateService);
        assertTrue(atomicBoolean.get());
        timeProfile.quit();
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        TimeProfile timeProfile = new TimeProfile(ApplicationProvider.getApplicationContext(), new BaseTimeProfileCallback(), BASE_UUID);
        timeProfile.connect(BLETestUtilsAndroid.MOCK_DEVICE_0);
        timeProfile.quit();
        assertNull(timeProfile.mCurrentTimeService);
        assertNull(timeProfile.mNextDstChangeService);
        assertNull(timeProfile.mReferenceTimeUpdateService);
    }

}
