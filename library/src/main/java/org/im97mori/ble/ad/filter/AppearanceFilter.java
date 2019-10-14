package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.Appearance;

/**
 * filter for {@link Appearance}
 */
@SuppressWarnings("WeakerAccess")
public class AppearanceFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link Appearance} in Advertising data
     */
    private final Appearance mExpect;

    /**
     * @param expect expected {@link Appearance} in Advertising data
     */
    public AppearanceFilter(@Nullable Appearance expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        Appearance actual = advertisingDataParseResult.getAppearance();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getAppearanceKey() == actual.getAppearanceKey()) {
                result = true;
            }
        }
        return result;
    }
}
