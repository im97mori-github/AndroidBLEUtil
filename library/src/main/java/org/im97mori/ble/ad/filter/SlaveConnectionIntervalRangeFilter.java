package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.SlaveConnectionIntervalRange;

import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link SlaveConnectionIntervalRange}
 */
@SuppressWarnings("WeakerAccess")
public class SlaveConnectionIntervalRangeFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link SlaveConnectionIntervalRange} in Advertising data
     */
    private final List<SlaveConnectionIntervalRange> mExpect;

    /**
     * @param expect expected List of {@link SlaveConnectionIntervalRange} in Advertising data
     */
    public SlaveConnectionIntervalRangeFilter(@NonNull List<SlaveConnectionIntervalRange> expect) {
        mExpect = expect;
    }

    /**
     * @see #SlaveConnectionIntervalRangeFilter(List)
     */
    public SlaveConnectionIntervalRangeFilter(@NonNull SlaveConnectionIntervalRange... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<SlaveConnectionIntervalRange> actual = advertisingDataParseResult.getSlaveConnectionIntervalRangeList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    SlaveConnectionIntervalRange expectElement = mExpect.get(i);
                    SlaveConnectionIntervalRange actualElement = actual.get(i);
                    if (expectElement.getLength() != actualElement.getLength()
                            || expectElement.getDataType() != actualElement.getDataType()
                            || expectElement.getMinimumValue() != actualElement.getMinimumValue()
                            || expectElement.getMaximumValue() != actualElement.getMaximumValue()) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
