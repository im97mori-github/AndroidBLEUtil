package org.im97mori.ble.profile.pxp.central;

import android.bluetooth.le.ScanCallback;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

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

import static org.im97mori.ble.constants.ServiceUUID.LINK_LOSS_SERVICE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;

/**
 * Proximity Profile specific scan callback
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ProximityProfileScanCallback extends FilteredScanCallback {

    /**
     * @param filteredScanCallbackInterface {@link FilteredScanCallbackInterface} instance
     * @param scanCallback                  {@link ScanCallback} instance
     */
    public ProximityProfileScanCallback(@NonNull FilteredScanCallbackInterface filteredScanCallbackInterface, @Nullable ScanCallback scanCallback) {
        super(Collections.singletonList(
                new OrFilter<>(
                        new CompleteListOf16BitServiceUUIDsFilter(new CompleteListOf16BitServiceUUIDs(LINK_LOSS_SERVICE))
                        , new CompleteListOf32BitServiceUUIDsFilter(new CompleteListOf32BitServiceUUIDs(LINK_LOSS_SERVICE))
                        , new CompleteListOf128BitServiceUUIDsFilter(new CompleteListOf128BitServiceUUIDs(LINK_LOSS_SERVICE))
                        , new IncompleteListOf16BitServiceUUIDsFilter(new IncompleteListOf16BitServiceUUIDs(LINK_LOSS_SERVICE))
                        , new IncompleteListOf32BitServiceUUIDsFilter(new IncompleteListOf32BitServiceUUIDs(LINK_LOSS_SERVICE))
                        , new IncompleteListOf128BitServiceUUIDsFilter(new IncompleteListOf128BitServiceUUIDs(LINK_LOSS_SERVICE))))
                , new AdvertisingDataParser.Builder(false)
                        .include(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .include(COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE)
                        .build()
                , filteredScanCallbackInterface
                , scanCallback);
    }

}
