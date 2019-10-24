package org.im97mori.ble.ad.filter;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.ad.AdvertisingDataParser;

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
         * {@link ScanCallback} instance, used at the same time {@link #onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link #onFilteredBatchScanResults(List, List)}
         */
        protected ScanCallback mScanCallback;

        /**
         * @param scanCallback {@link ScanCallback} instance, used at the same time {@link #onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link #onFilteredBatchScanResults(List, List)}
         * @return myself
         */
        public Builder setScanCallback(ScanCallback scanCallback) {
            mScanCallback = scanCallback;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FilteredScanCallback build() {
            return new FilteredScanCallback(mFilterList, mAdvertisingDataParser, mScanCallback);
        }

    }

    /**
     * {@link AndFilter} from {@link #FilteredScanCallback(List, AdvertisingDataParser, ScanCallback)} 1st parameter
     */
    private final AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> mAndFilter;

    /**
     * {@link AdvertisingDataParser} instance
     */
    private final AdvertisingDataParser mAdvertisingDataParser;

    /**
     * {@link ScanCallback} instance, used at the same time {@link #onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link #onFilteredBatchScanResults(List, List)}
     */
    private final ScanCallback mScanCallback;

    /**
     * @param filterList   used for {@link AndFilter}
     * @param parser       {@link AdvertisingDataParser} instance
     * @param scanCallback {@link ScanCallback} instance, used at the same time {@link #onFilteredScanResult(int, ScanResult, AdvertisingDataParser.AdvertisingDataParseResult)} or {@link #onFilteredBatchScanResults(List, List)}
     */
    protected FilteredScanCallback(@NonNull List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> filterList, @Nullable AdvertisingDataParser parser, @Nullable ScanCallback scanCallback) {
        mAndFilter = new AndFilter<>(filterList);
        if (parser == null) {
            mAdvertisingDataParser = new AdvertisingDataParser.Builder(true).build();
        } else {
            mAdvertisingDataParser = parser;
        }
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
                onFilteredScanResult(callbackType, result, parseResult);
                if (mScanCallback != null) {
                    mScanCallback.onScanResult(callbackType, result);
                }
            } else {
                BLELogUtils.stackLog("not matched", result.getDevice(), scanRecord);
            }
        }
    }

    /**
     * Filtered {@link #onScanResult(int, ScanResult)}
     *
     * @param callbackType {@link #onScanResult(int, ScanResult)} 1st parameter
     * @param result       {@link #onScanResult(int, ScanResult)} 2nd parameter
     * @param parseResult  {@link  org.im97mori.ble.ad.AdvertisingDataParser.AdvertisingDataParseResult} instance, created from result
     */
    @SuppressWarnings("EmptyMethod")
    public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
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
                    BLELogUtils.stackLog("not matched", scanResult.getDevice(), scanRecord);
                }
            }
        }
        if (!filteredResults.isEmpty()) {
            onFilteredBatchScanResults(filteredResults, parseResults);
            if (mScanCallback != null) {
                mScanCallback.onBatchScanResults(results);
            }
        }
    }

    /**
     * Filtered {@link #onBatchScanResults(List)}
     *
     * @param results      {@link #onBatchScanResults(List)} 1st paramerter
     * @param parseResults List of {@link org.im97mori.ble.ad.AdvertisingDataParser.AdvertisingDataParseResult} instance, created from results
     */
    @SuppressWarnings("EmptyMethod")
    public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
    }

}
