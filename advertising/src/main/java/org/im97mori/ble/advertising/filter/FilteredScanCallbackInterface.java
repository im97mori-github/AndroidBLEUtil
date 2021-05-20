package org.im97mori.ble.advertising.filter;

import android.bluetooth.le.ScanResult;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;

import java.util.List;

/**
 * Callback interface for {@link FilteredScanCallback}
 */
@SuppressWarnings("unused")
public interface FilteredScanCallbackInterface {

    /**
     * Filtered {@link FilteredScanCallback#onScanResult(int, ScanResult)}
     *
     * @param callbackType {@link FilteredScanCallback#onScanResult(int, ScanResult)} 1st parameter
     * @param result       {@link FilteredScanCallback#onScanResult(int, ScanResult)} 2nd parameter
     * @param parseResult  {@link org.im97mori.ble.advertising.AdvertisingDataParser.AdvertisingDataParseResult} instance, created from result
     */
    void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult);

    /**
     * Filtered {@link FilteredScanCallback#onBatchScanResults(List)}
     *
     * @param results      {@link FilteredScanCallback#onBatchScanResults(List)} 1st paramerter
     * @param parseResults List of {@link org.im97mori.ble.advertising.AdvertisingDataParser.AdvertisingDataParseResult} instance, created from results
     */
    void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults);

    /**
     * @see android.bluetooth.le.ScanCallback#onScanFailed(int)
     */
    void onScanFailed(int errorCode);

}
