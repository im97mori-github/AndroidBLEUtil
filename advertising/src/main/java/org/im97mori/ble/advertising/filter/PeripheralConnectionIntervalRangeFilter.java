package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.PeripheralConnectionIntervalRange;

import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link PeripheralConnectionIntervalRange}
 */
@SuppressWarnings({"WeakerAccess"})
public class PeripheralConnectionIntervalRangeFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link PeripheralConnectionIntervalRange} in Advertising data
     */
    private final List<? extends PeripheralConnectionIntervalRange> mExpect;

    /**
     * @param expect expected List of {@link PeripheralConnectionIntervalRange} in Advertising data
     */
    public PeripheralConnectionIntervalRangeFilter(@NonNull List<? extends PeripheralConnectionIntervalRange> expect) {
        mExpect = expect;
    }

    /**
     * @see #PeripheralConnectionIntervalRangeFilter(List)
     */
    public PeripheralConnectionIntervalRangeFilter(@NonNull PeripheralConnectionIntervalRange... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends PeripheralConnectionIntervalRange> actual = advertisingDataParseResult.getPeripheralConnectionIntervalRangeList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    PeripheralConnectionIntervalRange expectElement = mExpect.get(i);
                    PeripheralConnectionIntervalRange actualElement = actual.get(i);
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
