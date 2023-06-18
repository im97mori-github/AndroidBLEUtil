package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.EncryptedData;
import org.im97mori.ble.advertising.PeriodicAdvertisingResponseTimingInformation;

import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link PeriodicAdvertisingResponseTimingInformationFilter}
 */
@SuppressWarnings({"WeakerAccess"})
public class PeriodicAdvertisingResponseTimingInformationFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link EncryptedData} in Advertising data
     */
    private final List<? extends PeriodicAdvertisingResponseTimingInformation> mExpect;

    /**
     * @param expect expected List of {@link PeriodicAdvertisingResponseTimingInformation} in Advertising data
     */
    public PeriodicAdvertisingResponseTimingInformationFilter(@NonNull List<? extends PeriodicAdvertisingResponseTimingInformation> expect) {
        mExpect = expect;
    }

    /**
     * @see #PeriodicAdvertisingResponseTimingInformationFilter(List)
     */
    public PeriodicAdvertisingResponseTimingInformationFilter(@NonNull PeriodicAdvertisingResponseTimingInformation... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends PeriodicAdvertisingResponseTimingInformation> actual = advertisingDataParseResult.getPeriodicAdvertisingResponseTimingInformationList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    PeriodicAdvertisingResponseTimingInformation expectElement = mExpect.get(i);
                    PeriodicAdvertisingResponseTimingInformation actualElement = actual.get(i);
                    if (expectElement.getLength() != actualElement.getLength()
                            || expectElement.getDataType() != actualElement.getDataType()) {
                        if (expectElement.getLength() != actualElement.getLength()
                                || expectElement.getDataType() != actualElement.getDataType()
                                || !Arrays.equals(expectElement.getRspAa(), actualElement.getRspAa())
                                || expectElement.getNumSubevents() != actualElement.getNumSubevents()
                                || expectElement.getSubeventInterval() != actualElement.getSubeventInterval()
                                || expectElement.getResponseSlotDelay() != actualElement.getResponseSlotDelay()
                                || expectElement.getResponseSlotSpacing() != actualElement.getResponseSlotSpacing()) {
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
