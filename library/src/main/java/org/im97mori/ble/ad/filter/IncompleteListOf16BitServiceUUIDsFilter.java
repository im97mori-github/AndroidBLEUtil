package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.IncompleteListOf16BitServiceUUIDs;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * filter for {@link IncompleteListOf16BitServiceUUIDs}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IncompleteListOf16BitServiceUUIDsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link IncompleteListOf16BitServiceUUIDsFilter} in Advertising data
     */
    private final List<IncompleteListOf16BitServiceUUIDs> mExpect;

    /**
     * @param expect expected List of {@link IncompleteListOf16BitServiceUUIDsFilter} in Advertising data
     */
    public IncompleteListOf16BitServiceUUIDsFilter(@NonNull List<IncompleteListOf16BitServiceUUIDs> expect) {
        mExpect = expect;
    }

    /**
     * @see #IncompleteListOf16BitServiceUUIDsFilter(List)
     */
    public IncompleteListOf16BitServiceUUIDsFilter(@NonNull IncompleteListOf16BitServiceUUIDs... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<IncompleteListOf16BitServiceUUIDs> actual = advertisingDataParseResult.getIncompleteListOf16BitServiceUUIDsList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    IncompleteListOf16BitServiceUUIDs expectElement = mExpect.get(i);
                    IncompleteListOf16BitServiceUUIDs actualElement = actual.get(i);
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
