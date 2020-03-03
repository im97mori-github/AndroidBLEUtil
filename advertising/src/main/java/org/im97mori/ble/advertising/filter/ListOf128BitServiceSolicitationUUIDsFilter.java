package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ListOf128BitServiceSolicitationUUIDs;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * filter for {@link ListOf128BitServiceSolicitationUUIDs}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ListOf128BitServiceSolicitationUUIDsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link ListOf128BitServiceSolicitationUUIDs} in Advertising data
     */
    private final List<? extends ListOf128BitServiceSolicitationUUIDs> mExpect;

    /**
     * @param expect expected List of {@link ListOf128BitServiceSolicitationUUIDs} in Advertising data
     */
    public ListOf128BitServiceSolicitationUUIDsFilter(@NonNull List<? extends ListOf128BitServiceSolicitationUUIDs> expect) {
        mExpect = expect;
    }

    /**
     * @see #ListOf128BitServiceSolicitationUUIDsFilter(List)
     */
    public ListOf128BitServiceSolicitationUUIDsFilter(@NonNull ListOf128BitServiceSolicitationUUIDs... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends ListOf128BitServiceSolicitationUUIDs> actual = advertisingDataParseResult.getListOf128BitServiceSolicitationUUIDsList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    ListOf128BitServiceSolicitationUUIDs expectElement = mExpect.get(i);
                    ListOf128BitServiceSolicitationUUIDs actualElement = actual.get(i);
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
