package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteListOf32BitServiceUUIDs;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * filter for {@link CompleteListOf32BitServiceUUIDs}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CompleteListOf32BitServiceUUIDsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link CompleteListOf32BitServiceUUIDsFilter} in Advertising data
     */
    private final List<? extends CompleteListOf32BitServiceUUIDs> mExpect;

    /**
     * @param expect expected List of {@link CompleteListOf32BitServiceUUIDsFilter} in Advertising data
     */
    public CompleteListOf32BitServiceUUIDsFilter(@NonNull List<? extends CompleteListOf32BitServiceUUIDs> expect) {
        mExpect = expect;
    }

    /**
     * @see #CompleteListOf32BitServiceUUIDsFilter(List)
     */
    public CompleteListOf32BitServiceUUIDsFilter(@NonNull CompleteListOf32BitServiceUUIDs... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends CompleteListOf32BitServiceUUIDs> actual = advertisingDataParseResult.getCompleteListOf32BitServiceUUIDsList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    CompleteListOf32BitServiceUUIDs expectElement = mExpect.get(i);
                    CompleteListOf32BitServiceUUIDs actualElement = actual.get(i);
                    if (expectElement.getLength() == actualElement.getLength()
                            && expectElement.getDataType() == actualElement.getDataType()) {
                        List<UUID> expectUUIDList = expectElement.getUuidList();
                        List<UUID> actualUUIDList = actualElement.getUuidList();
                        if (expectUUIDList.size() == actualUUIDList.size()) {
                            for (int j = 0; j < expectUUIDList.size(); j++) {
                                if (!expectUUIDList.get(j).equals(actualUUIDList.get(j))) {
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
        return result;
    }
}
