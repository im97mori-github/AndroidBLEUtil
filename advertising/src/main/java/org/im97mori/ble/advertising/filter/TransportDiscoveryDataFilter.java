package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.TransportDiscoveryData;

import java.util.Arrays;

/**
 * filter for {@link TransportDiscoveryData}
 */
public class TransportDiscoveryDataFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link TransportDiscoveryData} in Advertising data
     */
    private final TransportDiscoveryData mExpect;

    /**
     * @param expect expected {@link TransportDiscoveryData} in Advertising data
     */
    public TransportDiscoveryDataFilter(@Nullable TransportDiscoveryData expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        TransportDiscoveryData actual = advertisingDataParseResult.getTransportDiscoveryData();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getTransportBlockList().size() == actual.getTransportBlockList().size()) {
                result = true;
                for (int i = 0; i < mExpect.getTransportBlockList().size(); i++) {
                    if (mExpect.getTransportBlockList().get(i).getOrganizationId() != actual.getTransportBlockList().get(i).getOrganizationId()
                            || mExpect.getTransportBlockList().get(i).getTdsFlags() != actual.getTransportBlockList().get(i).getTdsFlags()
                            || mExpect.getTransportBlockList().get(i).getTransportDataLength() != actual.getTransportBlockList().get(i).getTransportDataLength()
                            || !Arrays.equals(mExpect.getTransportBlockList().get(i).getTransportData(), actual.getTransportBlockList().get(i).getTransportData())) {
                        result = false;
                        break;
                    }
                }

            }
        }
        return result;
    }

}
