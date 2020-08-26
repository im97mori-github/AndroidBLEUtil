package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.CompleteListOf16BitServiceUUIDs;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * filter for {@link CompleteListOf16BitServiceUUIDs}
 */
@SuppressWarnings({"WeakerAccess"})
public class CompleteListOf16BitServiceUUIDsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link CompleteListOf16BitServiceUUIDs} in Advertising data
     */
    private final List<? extends CompleteListOf16BitServiceUUIDs> mExpect;

    /**
     * @param expect expected List of {@link CompleteListOf16BitServiceUUIDs} in Advertising data
     */
    public CompleteListOf16BitServiceUUIDsFilter(@NonNull List<? extends CompleteListOf16BitServiceUUIDs> expect) {
        mExpect = expect;
    }

    /**
     * @see #CompleteListOf16BitServiceUUIDsFilter(List)
     */
    public CompleteListOf16BitServiceUUIDsFilter(@NonNull CompleteListOf16BitServiceUUIDs... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends CompleteListOf16BitServiceUUIDs> actual = advertisingDataParseResult.getCompleteListOf16BitServiceUUIDsList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    CompleteListOf16BitServiceUUIDs expectElement = mExpect.get(i);
                    CompleteListOf16BitServiceUUIDs actualElement = actual.get(i);
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
