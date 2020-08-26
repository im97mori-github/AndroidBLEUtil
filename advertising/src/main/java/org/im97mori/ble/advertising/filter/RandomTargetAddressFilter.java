package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.RandomTargetAddress;

import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link RandomTargetAddress}
 */
@SuppressWarnings({"WeakerAccess"})
public class RandomTargetAddressFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link RandomTargetAddress} in Advertising data
     */
    private final RandomTargetAddress mExpect;

    /**
     * bitmask
     *
     * @see android.bluetooth.le.ScanFilter.Builder#setManufacturerData(int, byte[], byte[]) 3rd parameter
     */
    private final List<byte[]> mBitmaskList;

    /**
     * @param expect      expected {@link RandomTargetAddress} in Advertising data
     * @param bitmaskList bitmask
     */
    public RandomTargetAddressFilter(@Nullable RandomTargetAddress expect, @Nullable List<byte[]> bitmaskList) {
        mExpect = expect;
        mBitmaskList = bitmaskList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        RandomTargetAddress actual = advertisingDataParseResult.getRandomTargetAddress();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()) {

                List<byte[]> expectAddressList = mExpect.getAddressList();
                List<byte[]> actualAddressList = actual.getAddressList();
                if (expectAddressList.size() == actualAddressList.size()) {
                    if (mBitmaskList == null) {
                        result = true;
                        for (int i = 0; i < expectAddressList.size(); i++) {
                            byte[] expectData = expectAddressList.get(i);
                            byte[] actualData = actualAddressList.get(i);
                            if (!Arrays.equals(expectData, actualData)) {
                                result = false;
                                break;
                            }
                        }
                    } else if (expectAddressList.size() == mBitmaskList.size()) {
                        result = true;
                        for (int i = 0; i < expectAddressList.size(); i++) {

                            byte[] expectData = expectAddressList.get(i);
                            byte[] actualData = actualAddressList.get(i);
                            byte[] bitmaskData = mBitmaskList.get(i);

                            if (bitmaskData.length == 6) {
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
                        }
                    }
                }
            }
        }
        return result;
    }
}
