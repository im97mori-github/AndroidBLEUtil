package org.im97mori.ble.profile.scpp.central;

import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;

import android.bluetooth.BluetoothAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.advertising.CompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.advertising.IncompleteListOf128BitServiceUUIDs;
import org.im97mori.ble.advertising.IncompleteListOf16BitServiceUUIDs;
import org.im97mori.ble.advertising.IncompleteListOf32BitServiceUUIDs;
import org.im97mori.ble.advertising.filter.CompleteListOf128BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.CompleteListOf16BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.CompleteListOf32BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredLeScanCallbackInterface;
import org.im97mori.ble.advertising.filter.IncompleteListOf128BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.IncompleteListOf16BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.IncompleteListOf32BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.OrFilter;

import java.util.Collections;
import java.util.UUID;

/**
 * Scan Parameters Profile specific scan callback
 */
public class ScanParametersProfileLeScanCallback extends FilteredLeScanCallback {

    /**
     * @param serviceUUID                     advertising UUID
     * @param filteredLeScanCallbackInterface {@link FilteredLeScanCallbackInterface} instance
     * @param leScanCallback                  {@link BluetoothAdapter.LeScanCallback} instance
     */
    public ScanParametersProfileLeScanCallback(@NonNull UUID serviceUUID, @NonNull FilteredLeScanCallbackInterface filteredLeScanCallbackInterface, @Nullable BluetoothAdapter.LeScanCallback leScanCallback) {
        super(Collections.singletonList(
                new OrFilter<>(
                        new CompleteListOf16BitServiceUUIDsFilter(new CompleteListOf16BitServiceUUIDs(serviceUUID))
                        , new CompleteListOf32BitServiceUUIDsFilter(new CompleteListOf32BitServiceUUIDs(serviceUUID))
                        , new CompleteListOf128BitServiceUUIDsFilter(new CompleteListOf128BitServiceUUIDs(serviceUUID))
                        , new IncompleteListOf16BitServiceUUIDsFilter(new IncompleteListOf16BitServiceUUIDs(serviceUUID))
                        , new IncompleteListOf32BitServiceUUIDsFilter(new IncompleteListOf32BitServiceUUIDs(serviceUUID))
                        , new IncompleteListOf128BitServiceUUIDsFilter(new IncompleteListOf128BitServiceUUIDs(serviceUUID))))
                , new AdvertisingDataParser.Builder(false)
                        .include(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .build()
                , filteredLeScanCallbackInterface
                , leScanCallback);
    }

}
