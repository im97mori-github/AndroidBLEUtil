package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.ChannelMapUpdateIndication;

import java.util.List;

/**
 * filter for {@link ChannelMapUpdateIndication}
 */
@SuppressWarnings({"WeakerAccess"})
public class ChannelMapUpdateIndicationFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link ChannelMapUpdateIndication} in Advertising data
     */
    private final ChannelMapUpdateIndication mExpect;

    /**
     * @param expect expected {@link ChannelMapUpdateIndication} in Advertising data
     */
    public ChannelMapUpdateIndicationFilter(@Nullable ChannelMapUpdateIndication expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        ChannelMapUpdateIndication actual = advertisingDataParseResult.getChannelMapUpdateIndication();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getInstant() == actual.getInstant()) {
                List<Integer> expectChmList = mExpect.getChmList();
                List<Integer> actualChmList = actual.getChmList();
                if (expectChmList.size() == actualChmList.size()) {
                    result = true;
                    for (int i = 0; i < expectChmList.size(); i++) {
                        if (!expectChmList.get(i).equals(actualChmList.get(i))) {
                            result = false;
                            break;
                        }
                    }
                }
                if (result) {
                    List<Integer> expectUnusedPhyChannelList = mExpect.getUnusedPhyChannelList();
                    List<Integer> actualUnusedPhyChannelList = actual.getUnusedPhyChannelList();
                    if (expectUnusedPhyChannelList.size() == actualUnusedPhyChannelList.size()) {
                        for (int i = 0; i < expectUnusedPhyChannelList.size(); i++) {
                            if (!expectUnusedPhyChannelList.get(i).equals(actualUnusedPhyChannelList.get(i))) {
                                result = false;
                                break;
                            }
                        }
                    } else {
                        result = false;
                    }
                }
                if (result) {
                    List<Integer> expectUnusedPhyChannelRfCenterFrequencyList = mExpect.getUnusedPhyChannelRfCenterFrequencyList();
                    List<Integer> actualUnusedPhyChannelRfCenterFrequencyList = actual.getUnusedPhyChannelRfCenterFrequencyList();
                    if (expectUnusedPhyChannelRfCenterFrequencyList.size() == actualUnusedPhyChannelRfCenterFrequencyList.size()) {
                        for (int i = 0; i < expectUnusedPhyChannelRfCenterFrequencyList.size(); i++) {
                            if (!expectUnusedPhyChannelRfCenterFrequencyList.get(i).equals(actualUnusedPhyChannelRfCenterFrequencyList.get(i))) {
                                result = false;
                                break;
                            }
                        }
                    } else {
                        result = false;
                    }
                }
            }
        }
        return result;
    }
}
