package org.im97mori.ble.profile.peripheral;

import android.Manifest;
import android.os.Build;

import androidx.test.filters.SdkSuppress;
import androidx.test.rule.GrantPermissionRule;

import org.junit.Rule;

@SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
public class AbstractProfileMockCallback33Test extends BaseAbstractProfileMockCallbackTest {

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule
            .grant(Manifest.permission.BLUETOOTH_ADVERTISE, Manifest.permission.BLUETOOTH_CONNECT);

}
