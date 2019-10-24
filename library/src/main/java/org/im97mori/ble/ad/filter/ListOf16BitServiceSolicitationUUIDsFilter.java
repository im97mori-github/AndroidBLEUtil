package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.ListOf16BitServiceSolicitationUUIDs;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * filter for {@link ListOf16BitServiceSolicitationUUIDs}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ListOf16BitServiceSolicitationUUIDsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link ListOf16BitServiceSolicitationUUIDs} in Advertising data
     */
    private final List<ListOf16BitServiceSolicitationUUIDs> mExpect;

    /**
     * @param expect expected List of {@link ListOf16BitServiceSolicitationUUIDs} in Advertising data
     */
    public ListOf16BitServiceSolicitationUUIDsFilter(@NonNull List<ListOf16BitServiceSolicitationUUIDs> expect) {
        mExpect = expect;
    }

    /**
     * @see #ListOf16BitServiceSolicitationUUIDsFilter(List)
     */
    public ListOf16BitServiceSolicitationUUIDsFilter(@NonNull ListOf16BitServiceSolicitationUUIDs... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<ListOf16BitServiceSolicitationUUIDs> actual = advertisingDataParseResult.getListOf16BitServiceSolicitationUUIDsList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    ListOf16BitServiceSolicitationUUIDs expectElement = mExpect.get(i);
                    ListOf16BitServiceSolicitationUUIDs actualElement = actual.get(i);
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
