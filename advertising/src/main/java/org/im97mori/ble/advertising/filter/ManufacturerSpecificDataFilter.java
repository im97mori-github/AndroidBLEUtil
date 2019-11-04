package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ManufacturerSpecificData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * filter for {@link ManufacturerSpecificData}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ManufacturerSpecificDataFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link ManufacturerSpecificData} in Advertising data
     */
    private final List<ManufacturerSpecificData> mExpect;

    /**
     * bitmask
     *
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[]) 3rd parameter
     */
    private final List<byte[]> mBitmaskList;

    /**
     * @param expect      expected List of {@link ManufacturerSpecificData} in Advertising data
     * @param bitmaskList bitmask
     */
    public ManufacturerSpecificDataFilter(@NonNull List<ManufacturerSpecificData> expect, @Nullable List<byte[]> bitmaskList) {
        mExpect = expect;
        mBitmaskList = bitmaskList;
    }

    /**
     * @see #ManufacturerSpecificDataFilter(List, List)
     */
    public ManufacturerSpecificDataFilter(@NonNull ManufacturerSpecificData expect, @Nullable byte[] bitmask) {
        this(Collections.singletonList(expect), bitmask == null ? null : Collections.singletonList(bitmask));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<ManufacturerSpecificData> actual = advertisingDataParseResult.getManufacturerSpecificDataList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                if (mBitmaskList == null) {
                    result = true;
                    for (int i = 0; i < mExpect.size(); i++) {
                        ManufacturerSpecificData expectElement = mExpect.get(i);
                        ManufacturerSpecificData actualElement = actual.get(i);
                        if (expectElement.getLength() == actualElement.getLength()
                                && expectElement.getDataType() == actualElement.getDataType()
                                && expectElement.getCompanyIdentifier() == actualElement.getCompanyIdentifier()) {
                            if (!Arrays.equals(expectElement.getManufacturerSpecificData(), actualElement.getManufacturerSpecificData())) {
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
                        ManufacturerSpecificData expectElement = mExpect.get(i);
                        ManufacturerSpecificData actualElement = actual.get(i);
                        if (expectElement.getLength() == actualElement.getLength()
                                && expectElement.getDataType() == actualElement.getDataType()
                                && expectElement.getCompanyIdentifier() == actualElement.getCompanyIdentifier()) {
                            byte[] expectData = expectElement.getManufacturerSpecificData();
                            byte[] actualData = actualElement.getManufacturerSpecificData();
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
