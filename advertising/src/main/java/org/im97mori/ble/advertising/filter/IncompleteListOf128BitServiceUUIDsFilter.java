package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.IncompleteListOf128BitServiceUUIDs;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * filter for {@link IncompleteListOf128BitServiceUUIDs}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IncompleteListOf128BitServiceUUIDsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link IncompleteListOf128BitServiceUUIDs} in Advertising data
     */
    private final List<? extends IncompleteListOf128BitServiceUUIDs> mExpect;

    /**
     * @param expect expected List of {@link IncompleteListOf128BitServiceUUIDsFilter} in Advertising data
     */
    public IncompleteListOf128BitServiceUUIDsFilter(@NonNull List<? extends IncompleteListOf128BitServiceUUIDs> expect) {
        mExpect = expect;
    }

    /**
     * @see #IncompleteListOf128BitServiceUUIDsFilter(List)
     */
    public IncompleteListOf128BitServiceUUIDsFilter(@NonNull IncompleteListOf128BitServiceUUIDs... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends IncompleteListOf128BitServiceUUIDs> actual = advertisingDataParseResult.getIncompleteListOf128BitServiceUUIDsList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    IncompleteListOf128BitServiceUUIDs expectElement = mExpect.get(i);
                    IncompleteListOf128BitServiceUUIDs actualElement = actual.get(i);
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
