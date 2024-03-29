package org.im97mori.ble;

import androidx.test.filters.RequiresDevice;
import androidx.test.rule.GrantPermissionRule;

import org.junit.Rule;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

//@SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
public class BLEUtilsAndroid33Test extends BaseBLEUtilsAndroidTest {

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule
            .grant(android.Manifest.permission.BLUETOOTH_CONNECT);

    @Test
    @RequiresDevice
    @SuppressWarnings("deprecation")
    public void test_isBluetoothEnabled_00001() {
        super.test_isBluetoothEnabled_00001();
    }

    @Test
    @RequiresDevice
    @SuppressWarnings("deprecation")
    public void test_isBluetoothEnabled_00002() {
        super.test_isBluetoothEnabled_00002();
    }

    @Test
    public void test_getDescriptorInstanceId_00001() {
        super.test_getDescriptorInstanceId_00001();
    }

    @Test
    public void test_getDescriptorInstanceId_00002() {
        super.test_getDescriptorInstanceId_00002();
    }
}
