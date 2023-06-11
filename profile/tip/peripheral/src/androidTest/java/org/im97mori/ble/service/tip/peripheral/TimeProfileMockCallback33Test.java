package org.im97mori.ble.service.tip.peripheral;

import android.Manifest;
import android.os.Build;

import androidx.test.filters.SdkSuppress;
import androidx.test.rule.GrantPermissionRule;

import org.junit.Rule;

@SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
public class TimeProfileMockCallback33Test extends BaseTimeProfileMockCallbackTest {

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.BLUETOOTH_ADVERTISE);

}
