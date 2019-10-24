package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.ShortenedLocalName;

/**
 * filter for {@link ShortenedLocalName}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ShortenedLocalNameFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link ShortenedLocalName} in Advertising data
     */
    private final ShortenedLocalName mExpect;

    /**
     * @param expect expected {@link ShortenedLocalName} in Advertising data
     */
    public ShortenedLocalNameFilter(@Nullable ShortenedLocalName expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        ShortenedLocalName actual = advertisingDataParseResult.getShortenedLocalName();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getShortenedLocalName().equals(actual.getShortenedLocalName())) {
                result = true;
            }
        }
        return result;
    }

}
