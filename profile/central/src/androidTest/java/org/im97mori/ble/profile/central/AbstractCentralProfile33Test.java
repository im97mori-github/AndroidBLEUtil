package org.im97mori.ble.profile.central;

import android.os.Build;

import androidx.test.filters.SdkSuppress;
import androidx.test.rule.GrantPermissionRule;

import org.junit.Rule;

@SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
public class AbstractCentralProfile33Test extends BaseAbstractCentralProfileTest {

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule
            .grant(android.Manifest.permission.BLUETOOTH_CONNECT);

}
