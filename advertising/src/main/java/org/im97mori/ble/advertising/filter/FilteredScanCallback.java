package org.im97mori.ble.advertising.filter;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.BLEAdvertisingLogUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link ScanCallback} with filter function
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class FilteredScanCallback extends ScanCallback {

    /**
     * Builder for {@link FilteredScanCallback}
     */
    public static class Builder extends AbstractFilteredCallbackBuilder<FilteredScanCallback> {

        /**
         * {@link FilteredScanCallbackInterface} instance
         */
        protected final FilteredScanCallbackInterface mFilteredScanCallbackInterface;

        /**
         * {@link ScanCallback} instance, used at the same time {@link FilteredScanCallbackInterface#onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link FilteredScanCallbackInterface#onFilteredBatchScanResults(List, List)}
         */
        protected final ScanCallback mScanCallback;

        /**
         * @param filteredScanCallbackInterface {@link FilteredScanCallbackInterface} instance
         * @param scanCallback                  {@link ScanCallback} instance, used at the same time {@link FilteredScanCallbackInterface#onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link FilteredScanCallbackInterface#onFilteredBatchScanResults(List, List)}
         */
        public Builder(@NonNull FilteredScanCallbackInterface filteredScanCallbackInterface, @Nullable ScanCallback scanCallback) {
            mFilteredScanCallbackInterface = filteredScanCallbackInterface;
            mScanCallback = scanCallback;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FilteredScanCallback build() {
            return new FilteredScanCallback(mFilterList, mAdvertisingDataParser, mFilteredScanCallbackInterface, mScanCallback);
        }

    }

    /**
     * {@link AndFilter} from {@link #FilteredScanCallback(List, AdvertisingDataParser, FilteredScanCallbackInterface, ScanCallback)} 1st parameter
     */
    private final AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> mAndFilter;

    /**
     * {@link AdvertisingDataParser} instance
     */
    private final AdvertisingDataParser mAdvertisingDataParser;

    /**
     * {@link FilteredScanCallbackInterface} instance
     */
    private final FilteredScanCallbackInterface mFilteredScanCallbackInterface;

    /**
     * {@link ScanCallback} instance, used at the same time {@link FilteredScanCallbackInterface#onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link FilteredScanCallbackInterface#onFilteredBatchScanResults(List, List)}
     */
    private final ScanCallback mScanCallback;

    /**
     * @param filterList                    used for {@link AndFilter}
     * @param parser                        {@link AdvertisingDataParser} instance
     * @param filteredScanCallbackInterface {@link FilteredScanCallbackInterface} instance
     * @param scanCallback                  {@link ScanCallback} instance, used at the same time {@link FilteredScanCallbackInterface#onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link FilteredScanCallbackInterface#onFilteredBatchScanResults(List, List)}
     */
    protected FilteredScanCallback(@NonNull List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> filterList, @Nullable AdvertisingDataParser parser, @NonNull FilteredScanCallbackInterface filteredScanCallbackInterface, @Nullable ScanCallback scanCallback) {
        mAndFilter = new AndFilter<>(filterList);
        if (parser == null) {
            mAdvertisingDataParser = new AdvertisingDataParser.Builder(true).build();
        } else {
            mAdvertisingDataParser = parser;
        }
        mFilteredScanCallbackInterface = filteredScanCallbackInterface;
        mScanCallback = scanCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void onScanResult(int callbackType, ScanResult result) {
        ScanRecord scanRecord = result.getScanRecord();
        if (scanRecord != null) {
            AdvertisingDataParser.AdvertisingDataParseResult parseResult = mAdvertisingDataParser.parse(scanRecord.getBytes());
            if (mAndFilter.isMatched(parseResult)) {
                mFilteredScanCallbackInterface.onFilteredScanResult(callbackType, result, parseResult);
                if (mScanCallback != null) {
                    mScanCallback.onScanResult(callbackType, result);
                }
            } else {
                BLEAdvertisingLogUtils.stackLog("not matched", result.getDevice(), scanRecord);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void onBatchScanResults(@NonNull List<ScanResult> results) {
        List<ScanResult> filteredResults = new LinkedList<>();
        List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults = new LinkedList<>();
        for (ScanResult scanResult : results) {
            ScanRecord scanRecord = scanResult.getScanRecord();
            if (scanRecord != null) {
                AdvertisingDataParser.AdvertisingDataParseResult parseResult = mAdvertisingDataParser.parse(scanRecord.getBytes());
                if (mAndFilter.isMatched(parseResult)) {
                    filteredResults.add(scanResult);
                    parseResults.add(parseResult);
                } else {
                    BLEAdvertisingLogUtils.stackLog("not matched", scanResult.getDevice(), scanRecord);
                }
            }
        }
        if (!filteredResults.isEmpty()) {
            mFilteredScanCallbackInterface.onFilteredBatchScanResults(filteredResults, parseResults);
            if (mScanCallback != null) {
                mScanCallback.onBatchScanResults(results);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onScanFailed(int errorCode) {
        mFilteredScanCallbackInterface.onScanFailed(errorCode);
        if (mScanCallback != null) {
            mScanCallback.onScanFailed(errorCode);
        }
    }

}
