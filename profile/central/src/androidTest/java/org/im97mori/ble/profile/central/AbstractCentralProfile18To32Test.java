package org.im97mori.ble.profile.central;

import static org.junit.Assert.assertNull;

import android.bluetooth.le.ScanResult;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.List;

@SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT, maxSdkVersion = Build.VERSION_CODES.S_V2)
public class AbstractCentralProfile18To32Test extends BaseAbstractCentralProfileTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_scanDevice_00001() {
        BaseAbstractCentralProfile baseAbstractCentralProfile = new BaseAbstractCentralProfile(ApplicationProvider.getApplicationContext(), new BaseProfileCallback());
        assertNull(baseAbstractCentralProfile.scanDevice(new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {

            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {

            }

            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).build(), ScanTask.TIMEOUT_MILLIS, null));
    }

}
