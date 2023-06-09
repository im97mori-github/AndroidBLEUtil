package org.im97mori.ble.profile.scpp.peripheral;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.GrantPermissionRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import android.Manifest;

@SuppressWarnings("ConstantConditions")
public class ScanParametersProfileMockCallbackTest {

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.BLUETOOTH_ADVERTISE);

    @Test
    public void test_getServiceUUID_00001() {
        assertNull(new ScanParametersProfileMockCallback(ApplicationProvider.getApplicationContext(), null).getServiceUUID());
    }

    @Test
    public void test_startAdvertising_00001() {
        final AtomicBoolean result = new AtomicBoolean(true);
        ScanParametersProfileMockCallback timeProfileMockCallback = new ScanParametersProfileMockCallback(ApplicationProvider.getApplicationContext(), null) {
            @Override
            public boolean startAdvertising(boolean includeUUID) {
                result.set(includeUUID);
                return super.startAdvertising(includeUUID);
            }
        };
        timeProfileMockCallback.startAdvertising();
        assertFalse(result.get());
    }

}
