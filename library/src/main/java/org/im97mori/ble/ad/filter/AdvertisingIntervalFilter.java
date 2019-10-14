package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.AdvertisingInterval;

/**
 * filter for {@link AdvertisingInterval}
 */
@SuppressWarnings("WeakerAccess")
public class AdvertisingIntervalFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link AdvertisingInterval} in Advertising data
     */
    private final AdvertisingInterval mExpect;

    /**
     * @param expect expected {@link AdvertisingInterval} in Advertising data
     */
    public AdvertisingIntervalFilter(@Nullable AdvertisingInterval expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        AdvertisingInterval actual = advertisingDataParseResult.getAdvertisingInterval();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getAdvertisingInterval() == actual.getAdvertisingInterval()) {
                result = true;
            }
        }
        return result;
    }
}
