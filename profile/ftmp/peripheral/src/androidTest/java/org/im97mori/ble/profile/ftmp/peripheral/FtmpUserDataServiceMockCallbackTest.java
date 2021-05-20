package org.im97mori.ble.profile.ftmp.peripheral;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;

import org.im97mori.ble.MockData;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class FtmpUserDataServiceMockCallbackTest {

    private static class TestFtmpUserDataServiceMockCallback extends FtmpUserDataServiceMockCallback {

        public TestFtmpUserDataServiceMockCallback(@NonNull MockData mockData, boolean isFallback, boolean isUserDataRetentionFeatureSupported) {
            super(mockData, isFallback, isUserDataRetentionFeatureSupported);
        }

        public void setCurrentUserMap(@NonNull BluetoothDevice device, @NonNull Integer userIndex) {
            mCurrentUserMap.put(device, userIndex);
        }
    }

    @Test
    public void test_onDeviceDisconnected_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        FtmpUserDataServiceMockCallback ftmpUserDataServiceMockCallback = new FtmpUserDataServiceMockCallback(new MockData(), false, false) {
            @Override
            protected void deleteUsers(int userIndex) {
                isCalled.set(true);
            }
        };
        ftmpUserDataServiceMockCallback.onDeviceDisconnected(null, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDeviceDisconnected_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        FtmpUserDataServiceMockCallback ftmpUserDataServiceMockCallback = new FtmpUserDataServiceMockCallback(new MockData(), false, true) {
            @Override
            protected void deleteUsers(int userIndex) {
                isCalled.set(true);
            }
        };
        ftmpUserDataServiceMockCallback.onDeviceDisconnected(null, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDeviceDisconnected_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        FtmpUserDataServiceMockCallback ftmpUserDataServiceMockCallback = new FtmpUserDataServiceMockCallback(new MockData(), false, true) {
            @Override
            protected void deleteUsers(int userIndex) {
                isCalled.set(true);
            }
        };
        ftmpUserDataServiceMockCallback.onDeviceDisconnected(null, BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDeviceDisconnected_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        TestFtmpUserDataServiceMockCallback ftmpUserDataServiceMockCallback = new TestFtmpUserDataServiceMockCallback(new MockData(), false, true) {
            @Override
            protected void deleteUsers(int userIndex) {
                isCalled.set(true);
            }
        };
        ftmpUserDataServiceMockCallback.setCurrentUserMap(BLETestUtilsAndroid.MOCK_DEVICE_1, 1);
        ftmpUserDataServiceMockCallback.onDeviceDisconnected(null, BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDeviceDisconnected_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final int originalUserIndex = 1;
        TestFtmpUserDataServiceMockCallback ftmpUserDataServiceMockCallback = new TestFtmpUserDataServiceMockCallback(new MockData(), false, true) {
            @Override
            protected void deleteUsers(int userIndex) {
                assertEquals(originalUserIndex, userIndex);
                isCalled.set(true);
            }
        };
        ftmpUserDataServiceMockCallback.setCurrentUserMap(BLETestUtilsAndroid.MOCK_DEVICE_0, originalUserIndex);
        ftmpUserDataServiceMockCallback.onDeviceDisconnected(null, BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertTrue(isCalled.get());
    }

}
