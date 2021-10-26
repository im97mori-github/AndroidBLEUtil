package org.im97mori.ble.profile.cscp.central;

import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.COMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
import static org.im97mori.ble.constants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;

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

/**
 * Cycling Speed and Cadence Profile specific scan callback
 */
public class CyclingSpeedAndCadenceProfileLeScanCallback extends FilteredLeScanCallback {

    /**
     * @param filteredLeScanCallbackInterface {@link FilteredLeScanCallbackInterface} instance
     * @param leScanCallback                  {@link BluetoothAdapter.LeScanCallback} instance
     */
    public CyclingSpeedAndCadenceProfileLeScanCallback(@NonNull FilteredLeScanCallbackInterface filteredLeScanCallbackInterface, @Nullable BluetoothAdapter.LeScanCallback leScanCallback) {
        super(Collections.singletonList(
                new OrFilter<>(
                        new CompleteListOf16BitServiceUUIDsFilter(new CompleteListOf16BitServiceUUIDs(CYCLING_SPEED_AND_CADENCE_SERVICE))
                        , new CompleteListOf32BitServiceUUIDsFilter(new CompleteListOf32BitServiceUUIDs(CYCLING_SPEED_AND_CADENCE_SERVICE))
                        , new CompleteListOf128BitServiceUUIDsFilter(new CompleteListOf128BitServiceUUIDs(CYCLING_SPEED_AND_CADENCE_SERVICE))
                        , new IncompleteListOf16BitServiceUUIDsFilter(new IncompleteListOf16BitServiceUUIDs(CYCLING_SPEED_AND_CADENCE_SERVICE))
                        , new IncompleteListOf32BitServiceUUIDsFilter(new IncompleteListOf32BitServiceUUIDs(CYCLING_SPEED_AND_CADENCE_SERVICE))
                        , new IncompleteListOf128BitServiceUUIDsFilter(new IncompleteListOf128BitServiceUUIDs(CYCLING_SPEED_AND_CADENCE_SERVICE))))
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
