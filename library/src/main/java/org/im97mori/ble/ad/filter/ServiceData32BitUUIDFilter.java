package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.ServiceData32BitUUID;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * filter for {@link ServiceData32BitUUID}
 */
@SuppressWarnings("WeakerAccess")
public class ServiceData32BitUUIDFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link ServiceData32BitUUID} in Advertising data
     */
    private final List<ServiceData32BitUUID> mExpect;

    /**
     * bitmask
     *
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[]) 3rd parameter
     */
    private final List<byte[]> mBitmaskList;

    /**
     * @param expect      expected List of {@link ServiceData32BitUUID} in Advertising data
     * @param bitmaskList bitmask
     */
    public ServiceData32BitUUIDFilter(@NonNull List<ServiceData32BitUUID> expect, @Nullable List<byte[]> bitmaskList) {
        mExpect = expect;
        mBitmaskList = bitmaskList;
    }

    /**
     * @see #ServiceData32BitUUIDFilter(List, List)
     */
    public ServiceData32BitUUIDFilter(@NonNull ServiceData32BitUUID expect, @Nullable byte[] bitmask) {
        this(Collections.singletonList(expect), bitmask == null ? null : Collections.singletonList(bitmask));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<ServiceData32BitUUID> actual = advertisingDataParseResult.getServiceData32BitUUIDList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                if (mBitmaskList == null) {
                    result = true;
                    for (int i = 0; i < mExpect.size(); i++) {
                        ServiceData32BitUUID expectElement = mExpect.get(i);
                        ServiceData32BitUUID actualElement = actual.get(i);
                        if (expectElement.getLength() == actualElement.getLength()
                                && expectElement.getDataType() == actualElement.getDataType()
                                && expectElement.getUuid().equals(actualElement.getUuid())) {
                            if (!Arrays.equals(expectElement.getAdditionalServiceData(), actualElement.getAdditionalServiceData())) {
                                result = false;
                                break;
                            }
                        } else {
                            result = false;
                            break;
                        }
                    }
                } else if (mExpect.size() == mBitmaskList.size()) {
                    result = true;
                    for (int i = 0; i < mExpect.size(); i++) {
                        ServiceData32BitUUID expectElement = mExpect.get(i);
                        ServiceData32BitUUID actualElement = actual.get(i);
                        if (expectElement.getLength() == actualElement.getLength()
                                && expectElement.getDataType() == actualElement.getDataType()
                                && expectElement.getUuid().equals(actualElement.getUuid())) {
                            byte[] expectData = expectElement.getAdditionalServiceData();
                            byte[] actualData = actualElement.getAdditionalServiceData();
                            byte[] bitmaskData = mBitmaskList.get(i);
                            if (expectData.length == actualData.length && bitmaskData != null && expectData.length == bitmaskData.length) {
                                for (int j = 0; j < expectData.length; j++) {
                                    if ((expectData[j] & bitmaskData[j]) != (actualData[j] & bitmaskData[j])) {
                                        result = false;
                                        break;
                                    }
                                }
                                if (!result) {
                                    break;
                                }
                            } else {
                                result = false;
                                break;
                            }
                        } else {
                            result = false;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
