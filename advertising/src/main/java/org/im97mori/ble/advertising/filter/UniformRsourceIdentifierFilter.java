package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.UniformRsourceIdentifier;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link UniformRsourceIdentifierFilter}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class UniformRsourceIdentifierFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link UniformRsourceIdentifier} in Advertising data
     */
    private final List<? extends UniformRsourceIdentifier> mExpect;

    /**
     * @param expect expected List of {@link UniformRsourceIdentifier} in Advertising data
     */
    public UniformRsourceIdentifierFilter(@NonNull List<? extends UniformRsourceIdentifier> expect) {
        mExpect = expect;
    }

    /**
     * @see #UniformRsourceIdentifierFilter(List)
     */
    public UniformRsourceIdentifierFilter(@NonNull UniformRsourceIdentifier... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends UniformRsourceIdentifier> actual = advertisingDataParseResult.getUniformRsourceIdentifierList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    UniformRsourceIdentifier expectElement = mExpect.get(i);
                    UniformRsourceIdentifier actualElement = actual.get(i);
                    if (expectElement.getLength() != actualElement.getLength()
                            || expectElement.getDataType() != actualElement.getDataType()) {
                        URI expectURI = expectElement.getUri();
                        URI actualURI = actualElement.getUri();
                        if (expectURI == null && actualURI != null
                                || expectURI != null && actualURI == null
                                || expectURI != null && !expectURI.equals(actualURI)) {
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
