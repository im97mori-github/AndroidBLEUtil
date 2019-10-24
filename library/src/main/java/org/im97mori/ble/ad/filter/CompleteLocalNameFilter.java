package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.CompleteLocalName;

/**
 * filter for {@link CompleteLocalName}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CompleteLocalNameFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link CompleteLocalName} in Advertising data
     */
    private final CompleteLocalName mExpect;

    /**
     * @param expect expected {@link CompleteLocalName} in Advertising data
     */
    public CompleteLocalNameFilter(@Nullable CompleteLocalName expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        CompleteLocalName actual = advertisingDataParseResult.getCompleteLocalName();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getCompleteLocalName().equals(actual.getCompleteLocalName())) {
                result = true;
            }
        }
        return result;
    }
}
