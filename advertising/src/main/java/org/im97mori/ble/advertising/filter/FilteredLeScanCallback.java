package org.im97mori.ble.advertising.filter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.BLEAdvertisingLogUtils;

import java.util.Arrays;
import java.util.List;

/**
 * {@link android.bluetooth.BluetoothAdapter.LeScanCallback} with filter function
 */
@SuppressWarnings({"WeakerAccess"})
public class FilteredLeScanCallback implements BluetoothAdapter.LeScanCallback {

    /**
     * Builder for {@link FilteredLeScanCallback}
     */
    public static class Builder extends AbstractFilteredCallbackBuilder<FilteredLeScanCallback> {

        /**
         * {@link FilteredLeScanCallbackInterface} instance
         */
        protected final FilteredLeScanCallbackInterface mFilteredLeScanCallbackInterface;

        /**
         * {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link FilteredLeScanCallbackInterface#onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
         */
        protected final BluetoothAdapter.LeScanCallback mLeScanCallback;

        /**
         * @param filteredLeScanCallbackInterface {@link FilteredLeScanCallbackInterface} instance
         * @param leScanCallback                  {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link FilteredLeScanCallbackInterface#onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
         */
        public Builder(@NonNull FilteredLeScanCallbackInterface filteredLeScanCallbackInterface, @Nullable BluetoothAdapter.LeScanCallback leScanCallback) {
            mFilteredLeScanCallbackInterface = filteredLeScanCallbackInterface;
            mLeScanCallback = leScanCallback;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FilteredLeScanCallback build() {
            return new FilteredLeScanCallback(mFilterList, mAdvertisingDataParser, mFilteredLeScanCallbackInterface, mLeScanCallback);
        }

    }

    /**
     * {@link AndFilter} from {@link #FilteredLeScanCallback(List, AdvertisingDataParser, FilteredLeScanCallbackInterface, BluetoothAdapter.LeScanCallback)} 1st parameter
     */
    private final AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> mAndFilter;

    /**
     * {@link AdvertisingDataParser} instance
     */
    private final AdvertisingDataParser mAdvertisingDataParser;

    /**
     * {@link FilteredLeScanCallbackInterface} instance
     */
    private final FilteredLeScanCallbackInterface mFilteredLeScanCallbackInterface;

    /**
     * {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link FilteredLeScanCallbackInterface#onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
     */
    private final BluetoothAdapter.LeScanCallback mLeScanCallback;

    /**
     * @param filterList                      used for {@link AndFilter}
     * @param parser                          {@link AdvertisingDataParser} instance
     * @param filteredLeScanCallbackInterface {@link FilteredLeScanCallbackInterface} instance
     * @param leScanCallback                  {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link FilteredLeScanCallbackInterface#onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
     */
    protected FilteredLeScanCallback(@NonNull List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> filterList, @Nullable AdvertisingDataParser parser, @NonNull FilteredLeScanCallbackInterface filteredLeScanCallbackInterface, @Nullable BluetoothAdapter.LeScanCallback leScanCallback) {
        mAndFilter = new AndFilter<>(filterList);
        if (parser == null) {
            mAdvertisingDataParser = new AdvertisingDataParser.Builder(true).build();
        } else {
            mAdvertisingDataParser = parser;
        }
        mFilteredLeScanCallbackInterface = filteredLeScanCallbackInterface;
        mLeScanCallback = leScanCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
        AdvertisingDataParser.AdvertisingDataParseResult result = mAdvertisingDataParser.parse(scanRecord);
        if (mAndFilter.isMatched(result)) {
            mFilteredLeScanCallbackInterface.onFilteredLeScan(device, rssi, scanRecord, result);
            if (mLeScanCallback != null) {
                mLeScanCallback.onLeScan(device, rssi, scanRecord);
            }
        } else {
            BLEAdvertisingLogUtils.stackLog("not matched", device, Arrays.toString(scanRecord));
        }
    }

}
