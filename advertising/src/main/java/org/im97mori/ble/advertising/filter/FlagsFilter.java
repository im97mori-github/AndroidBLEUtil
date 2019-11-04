package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.Flags;

import java.util.List;

/**
 * filter for {@link Flags}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FlagsFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link Flags} in Advertising data
     */
    private final Flags mExpect;

    /**
     * @param expect expected {@link Flags} in Advertising data
     */
    public FlagsFilter(@Nullable Flags expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        Flags actual = advertisingDataParseResult.getFlags();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()) {
                List<Integer> expectFlagsList = mExpect.getFlagsList();
                List<Integer> actualFlagsList = actual.getFlagsList();
                if (expectFlagsList.size() == actualFlagsList.size()) {
                    result = true;
                    for (int i = 0; i < expectFlagsList.size(); i++) {
                        if (!expectFlagsList.get(i).equals(actualFlagsList.get(i))) {
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
