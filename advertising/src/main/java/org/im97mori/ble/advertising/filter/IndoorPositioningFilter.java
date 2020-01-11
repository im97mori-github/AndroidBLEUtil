package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.IndoorPositioning;

/**
 * filter for {@link IndoorPositioning}
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class IndoorPositioningFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected {@link IndoorPositioning} in Advertising data
     */
    private final IndoorPositioning mExpect;

    /**
     * @param expect expected {@link IndoorPositioning} in Advertising data
     */
    public IndoorPositioningFilter(@Nullable IndoorPositioning expect) {
        mExpect = expect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        IndoorPositioning actual = advertisingDataParseResult.getIndoorPositioning();
        if (mExpect == null) {
            if (actual == null) {
                result = true;
            }
        } else {
            if (actual != null
                    && mExpect.getLength() == actual.getLength()
                    && mExpect.getDataType() == actual.getDataType()
                    && mExpect.getIndoorPositioningConfiguration() == actual.getIndoorPositioningConfiguration()
                    && mExpect.getGlobalCoorinatesLatitude() == actual.getGlobalCoorinatesLatitude()
                    && mExpect.getGlobalCoorinatesLongitude() == actual.getGlobalCoorinatesLongitude()
                    && mExpect.getLocalCoordinatesNorth() == actual.getLocalCoordinatesNorth()
                    && mExpect.getLocalCoordinatesEast() == actual.getLocalCoordinatesEast()
                    && mExpect.getTxPower() == actual.getTxPower()
                    && mExpect.getFloorNumber() == actual.getFloorNumber()
                    && mExpect.getAltitude() == actual.getAltitude()
                    && mExpect.getUncertainty() == actual.getUncertainty()) {
                result = true;
            }
        }
        return result;
    }

}
