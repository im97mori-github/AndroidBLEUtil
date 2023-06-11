package org.im97mori.ble;

import android.os.Build;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.junit.Test;

@SdkSuppress(minSdkVersion = Build.VERSION_CODES.JELLY_BEAN_MR2, maxSdkVersion = Build.VERSION_CODES.S_V2)
public class BLEUtilsAndroid18To32Test extends BaseBLEUtilsAndroidTest {

    @Test
    @RequiresDevice
    public void test_isBluetoothEnabled_00001() {
        super.test_isBluetoothEnabled_00001();
    }

    @Test
    @RequiresDevice
    public void test_isBluetoothEnabled_00002() {
        super.test_isBluetoothEnabled_00002();
    }

    @Test
    @RequiresDevice
    public void test_bluetoothEnable_00001() {
        super.test_bluetoothEnable_00001();
    }

    @Test
    @RequiresDevice
    public void test_bluetoothDisable_00001() {
        super.test_bluetoothDisable_00001();
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.N, maxSdkVersion = Build.VERSION_CODES.S_V2)
    public void test_getDescriptorInstanceId_00001() {
        super.test_getDescriptorInstanceId_00001();
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.N, maxSdkVersion = Build.VERSION_CODES.S_V2)
    public void test_getDescriptorInstanceId_00002() {
        super.test_getDescriptorInstanceId_00002();
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT, maxSdkVersion = Build.VERSION_CODES.M)
    public void test_getDescriptorInstanceId_00101() {
        super.test_getDescriptorInstanceId_00101();
    }

    @Override
    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT, maxSdkVersion = Build.VERSION_CODES.M)
    public void test_getDescriptorInstanceId_00102() throws IllegalAccessException, NoSuchFieldException {
        super.test_getDescriptorInstanceId_00102();
    }

    @Override
    @Test
    @SdkSuppress(maxSdkVersion = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void test_getDescriptorInstanceId_00201() {
        super.test_getDescriptorInstanceId_00201();
    }
}
