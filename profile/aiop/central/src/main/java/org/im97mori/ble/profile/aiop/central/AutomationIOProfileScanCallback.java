package org.im97mori.ble.profile.aiop.central;

import android.bluetooth.le.ScanCallback;

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
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.advertising.filter.IncompleteListOf128BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.IncompleteListOf16BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.IncompleteListOf32BitServiceUUIDsFilter;
import org.im97mori.ble.advertising.filter.OrFilter;

import java.util.Collections;

import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;

/**
 * Automation IO Profile specific scan callback
 */
public class AutomationIOProfileScanCallback extends FilteredScanCallback {

    /**
     * @param filteredScanCallbackInterface {@link FilteredScanCallbackInterface} instance
     * @param scanCallback                  {@link ScanCallback} instance
     */
    public AutomationIOProfileScanCallback(@NonNull FilteredScanCallbackInterface filteredScanCallbackInterface, @Nullable ScanCallback scanCallback) {
        super(Collections.singletonList(
                new OrFilter<>(
                        new CompleteListOf16BitServiceUUIDsFilter(new CompleteListOf16BitServiceUUIDs(AUTOMATION_IO_SERVICE))
                        , new CompleteListOf32BitServiceUUIDsFilter(new CompleteListOf32BitServiceUUIDs(AUTOMATION_IO_SERVICE))
                        , new CompleteListOf128BitServiceUUIDsFilter(new CompleteListOf128BitServiceUUIDs(AUTOMATION_IO_SERVICE))
                        , new IncompleteListOf16BitServiceUUIDsFilter(new IncompleteListOf16BitServiceUUIDs(AUTOMATION_IO_SERVICE))
                        , new IncompleteListOf32BitServiceUUIDsFilter(new IncompleteListOf32BitServiceUUIDs(AUTOMATION_IO_SERVICE))
                        , new IncompleteListOf128BitServiceUUIDsFilter(new IncompleteListOf128BitServiceUUIDs(AUTOMATION_IO_SERVICE))))
                , new AdvertisingDataParser.Builder(false)
                        .include(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS)
                        .include(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS)
                        .include(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS)
                        .include(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS)
                        .include(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS)
                        .include(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS)
                        .build()
                , filteredScanCallbackInterface
                , scanCallback);
    }

}
