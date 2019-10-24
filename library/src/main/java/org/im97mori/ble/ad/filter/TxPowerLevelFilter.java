package org.im97mori.ble.ad.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.im97mori.ble.ad.TxPowerLevel;

import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link TxPowerLevel}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TxPowerLevelFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link TxPowerLevel} in Advertising data
     */
    private final List<TxPowerLevel> mExpect;

    /**
     * @param expect expected List of {@link TxPowerLevel} in Advertising data
     */
    public TxPowerLevelFilter(@NonNull List<TxPowerLevel> expect) {
        mExpect = expect;
    }

    /**
     * @see #TxPowerLevelFilter(List)
     */
    public TxPowerLevelFilter(@NonNull TxPowerLevel... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<TxPowerLevel> actual = advertisingDataParseResult.getTxPowerLevelList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    TxPowerLevel expectElement = mExpect.get(i);
                    TxPowerLevel actualElement = actual.get(i);
                    if (expectElement.getLength() != actualElement.getLength()
                            || expectElement.getDataType() != actualElement.getDataType()
                            || expectElement.getTxPowerLevel() != actualElement.getTxPowerLevel()) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

}
