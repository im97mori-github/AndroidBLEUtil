package org.im97mori.ble.profile.scpp.peripheral;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.Suppress;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("ConstantConditions")
@Suppress
abstract class BaseScanParametersProfileMockCallbackTest {

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
