package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ServiceData128BitUUID;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * filter for {@link ServiceData128BitUUID}
 */
@SuppressWarnings({"WeakerAccess"})
public class ServiceData128BitUUIDFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link ServiceData128BitUUID} in Advertising data
     */
    private final List<? extends ServiceData128BitUUID> mExpect;

    /**
     * bitmask
     *
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[]) 3rd parameter
     */
    private final List<byte[]> mBitmaskList;

    /**
     * @param expect      expected List of {@link ServiceData128BitUUID} in Advertising data
     * @param bitmaskList bitmask
     */
    public ServiceData128BitUUIDFilter(@NonNull List<? extends ServiceData128BitUUID> expect, @Nullable List<byte[]> bitmaskList) {
        mExpect = expect;
        mBitmaskList = bitmaskList;
    }

    /**
     * @see #ServiceData128BitUUIDFilter(List, List)
     */
    public ServiceData128BitUUIDFilter(@NonNull ServiceData128BitUUID expect, @Nullable byte[] bitmask) {
        this(Collections.singletonList(expect), bitmask == null ? null : Collections.singletonList(bitmask));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends ServiceData128BitUUID> actual = advertisingDataParseResult.getServiceData128BitUUIDList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                if (mBitmaskList == null) {
                    result = true;
                    for (int i = 0; i < mExpect.size(); i++) {
                        ServiceData128BitUUID expectElement = mExpect.get(i);
                        ServiceData128BitUUID actualElement = actual.get(i);
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
                        ServiceData128BitUUID expectElement = mExpect.get(i);
                        ServiceData128BitUUID actualElement = actual.get(i);
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
