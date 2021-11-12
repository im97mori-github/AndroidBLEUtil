package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.AdvertisingIntervalLong;

/**
 * filter for {@link AdvertisingIntervalLong}
 */
@SuppressWarnings({"WeakerAccess"})
public class AdvertisingIntervalLongFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link AdvertisingIntervalLong} in Advertising data
     */
    private final AdvertisingIntervalLong mExpect;

    /**
     * @param expect expected {@link AdvertisingIntervalLong} in Advertising data
     */
    public AdvertisingIntervalLongFilter(@Nullable AdvertisingIntervalLong expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        AdvertisingIntervalLong actual = advertisingDataParseResult.getAdvertisingIntervalLong();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getAdvertisingIntervalLong() == actual.getAdvertisingIntervalLong()) {
                result = true;
            }
        }
        return result;
    }
}
