package org.im97mori.ble.profile.central;

import android.bluetooth.le.ScanResult;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseAbstractCentralProfile extends AbstractCentralProfile {

    public final AtomicBoolean result = new AtomicBoolean(false);

    /**
     * @param context         {@link Context} instance
     * @param profileCallback {@link ProfileCallback} instance
     */
    public BaseAbstractCentralProfile(@NonNull Context context, @NonNull ProfileCallback profileCallback) {
        super(context, profileCallback);
    }

    @Nullable
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return null;
    }

    @NonNull
    @Override
    protected FilteredScanCallback createFilteredScanCallback() {
        return new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {

            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {

            }

            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).build();
    }

    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new FilteredLeScanCallback.Builder((device, rssi, scanRecord, result) -> {

        }, null).build();
    }

}
