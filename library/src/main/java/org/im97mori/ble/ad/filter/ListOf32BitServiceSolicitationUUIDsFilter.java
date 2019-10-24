package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.ListOf32BitServiceSolicitationUUIDs;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * filter for {@link ListOf32BitServiceSolicitationUUIDs}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ListOf32BitServiceSolicitationUUIDsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link ListOf32BitServiceSolicitationUUIDs} in Advertising data
     */
    private final List<ListOf32BitServiceSolicitationUUIDs> mExpect;

    /**
     * @param expect expected List of {@link ListOf32BitServiceSolicitationUUIDs} in Advertising data
     */
    public ListOf32BitServiceSolicitationUUIDsFilter(@NonNull List<ListOf32BitServiceSolicitationUUIDs> expect) {
        mExpect = expect;
    }

    /**
     * @see #ListOf32BitServiceSolicitationUUIDsFilter(List)
     */
    public ListOf32BitServiceSolicitationUUIDsFilter(@NonNull ListOf32BitServiceSolicitationUUIDs... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<ListOf32BitServiceSolicitationUUIDs> actual = advertisingDataParseResult.getListOf32BitServiceSolicitationUUIDsList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    ListOf32BitServiceSolicitationUUIDs expectElement = mExpect.get(i);
                    ListOf32BitServiceSolicitationUUIDs actualElement = actual.get(i);
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
