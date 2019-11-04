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
@SuppressWarnings({"unused", "WeakerAccess"})
public class FilteredLeScanCallback implements BluetoothAdapter.LeScanCallback {

    /**
     * Builder for {@link FilteredLeScanCallback}
     */
    public static class Builder extends AbstractFilteredCallbackBuilder<FilteredLeScanCallback> {

        /**
         * {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link #onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
         */
        protected BluetoothAdapter.LeScanCallback mLeScanCallback;

        /**
         * @param leScanCallback {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link #onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
         * @return myself
         */
        public Builder setScanCallback(BluetoothAdapter.LeScanCallback leScanCallback) {
            mLeScanCallback = leScanCallback;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FilteredLeScanCallback build() {
            return new FilteredLeScanCallback(mFilterList, mAdvertisingDataParser, mLeScanCallback);
        }

    }

    /**
     * {@link AndFilter} from {@link #FilteredLeScanCallback(List, AdvertisingDataParser, BluetoothAdapter.LeScanCallback)} 1st parameter
     */
    private final AndFilter<AdvertisingDataParser.AdvertisingDataParseResult> mAndFilter;

    /**
     * {@link AdvertisingDataParser} instance
     */
    private final AdvertisingDataParser mAdvertisingDataParser;

    /**
     * {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link #onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
     */
    private final BluetoothAdapter.LeScanCallback mLeScanCallback;

    /**
     * @param filterList     used for {@link AndFilter}
     * @param parser         {@link AdvertisingDataParser} instance
     * @param leScanCallback {@link android.bluetooth.BluetoothAdapter.LeScanCallback} instance, used at the same time {@link #onFilteredLeScan(BluetoothDevice, int, byte[], AdvertisingDataParser.AdvertisingDataParseResult)}
     */
    protected FilteredLeScanCallback(@NonNull List<AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>> filterList, @Nullable AdvertisingDataParser parser, @Nullable BluetoothAdapter.LeScanCallback leScanCallback) {
        mAndFilter = new AndFilter<>(filterList);
        if (parser == null) {
            mAdvertisingDataParser = new AdvertisingDataParser.Builder(true).build();
        } else {
            mAdvertisingDataParser = parser;
        }
        mLeScanCallback = leScanCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
        AdvertisingDataParser.AdvertisingDataParseResult result = mAdvertisingDataParser.parse(scanRecord);
        if (mAndFilter.isMatched(result)) {
            onFilteredLeScan(device, rssi, scanRecord, result);
            if (mLeScanCallback != null) {
                mLeScanCallback.onLeScan(device, rssi, scanRecord);
            }
        } else {
            BLEAdvertisingLogUtils.stackLog("not matched", device, Arrays.toString(scanRecord));
        }
    }

    /**
     * Filtered {@link #onLeScan(BluetoothDevice, int, byte[])}
     *
     * @param device     {@link #onLeScan(BluetoothDevice, int, byte[])} 1st parameter
     * @param rssi       {@link #onLeScan(BluetoothDevice, int, byte[])} 2nd parameter
     * @param scanRecord {@link #onLeScan(BluetoothDevice, int, byte[])} 3rd parameter
     * @param result     {@link org.im97mori.ble.advertising.AdvertisingDataParser.AdvertisingDataParseResult} instance, created from scanRecord byte array
     */
    @SuppressWarnings("EmptyMethod")
    public void onFilteredLeScan(@NonNull BluetoothDevice device, int rssi, @NonNull byte[] scanRecord, @NonNull AdvertisingDataParser.AdvertisingDataParseResult result) {
    }

}
