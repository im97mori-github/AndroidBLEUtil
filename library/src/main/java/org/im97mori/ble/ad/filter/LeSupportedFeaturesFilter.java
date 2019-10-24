package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.LeSupportedFeatures;

import java.util.List;

/**
 * filter for {@link LeSupportedFeatures}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LeSupportedFeaturesFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link LeSupportedFeaturesFilter} in Advertising data
     */
    private final LeSupportedFeatures mExpect;

    /**
     * @param expect expected {@link LeSupportedFeaturesFilter} in Advertising data
     */
    public LeSupportedFeaturesFilter(@Nullable LeSupportedFeatures expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        LeSupportedFeatures actual = advertisingDataParseResult.getLeSupportedFeatures();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()) {
                List<Integer> expectLeSupportedFeaturesList = mExpect.getLeSupportedFeaturesList();
                List<Integer> actualLeSupportedFeaturesList = actual.getLeSupportedFeaturesList();
                if (expectLeSupportedFeaturesList.size() == actualLeSupportedFeaturesList.size()) {
                    result = true;
                    for (int i = 0; i < expectLeSupportedFeaturesList.size(); i++) {
                        if (!expectLeSupportedFeaturesList.get(i).equals(actualLeSupportedFeaturesList.get(i))) {
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
