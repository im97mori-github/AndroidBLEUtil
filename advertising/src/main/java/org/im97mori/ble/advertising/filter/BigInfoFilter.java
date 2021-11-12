package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.BigInfo;

import java.util.Arrays;

/**
 * filter for {@link BigInfo}
 */
@SuppressWarnings({"WeakerAccess"})
public class BigInfoFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link BigInfo} in Advertising data
     */
    private final BigInfo mExpect;

    /**
     * @param expect expected {@link BigInfo} in Advertising data
     */
    public BigInfoFilter(@Nullable BigInfo expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        BigInfo actual = advertisingDataParseResult.getBigInfo();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getBigOffset() == actual.getBigOffset()
                    && mExpect.getBigOffsetUnits() == actual.getBigOffsetUnits()
                    && mExpect.getIsoInterval() == actual.getIsoInterval()
                    && mExpect.getNumBis() == actual.getNumBis()
                    && mExpect.getNse() == actual.getNse()
                    && mExpect.getBn() == actual.getBn()
                    && mExpect.getSubInterval() == actual.getSubInterval()
                    && mExpect.getPto() == actual.getPto()
                    && mExpect.getBisSpacing() == actual.getBisSpacing()
                    && mExpect.getIrc() == actual.getIrc()
                    && mExpect.getMaxPdu() == actual.getMaxPdu()
                    && mExpect.getRfu() == actual.getRfu()
                    && mExpect.getSeedAccessAddress() == actual.getSeedAccessAddress()
                    && mExpect.getSduInterval() == actual.getSduInterval()
                    && mExpect.getMaxSdu() == actual.getMaxSdu()
                    && mExpect.getBaseCrcInit() == actual.getBaseCrcInit()
                    && mExpect.getChm() == actual.getChm()
                    && mExpect.getPhy() == actual.getPhy()
                    && mExpect.getBisPayloadCount() == actual.getBisPayloadCount()
                    && mExpect.getFraming() == actual.getFraming()
                    && Arrays.equals(mExpect.getGiv(), actual.getGiv())
                    && Arrays.equals(mExpect.getGskd(), actual.getGskd())) {
                result = true;
            }
        }
        return result;
    }
}
