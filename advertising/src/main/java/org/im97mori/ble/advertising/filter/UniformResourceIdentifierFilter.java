package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.UniformResourceIdentifier;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link UniformResourceIdentifierFilter}
 */
@SuppressWarnings({"WeakerAccess"})
public class UniformResourceIdentifierFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link UniformResourceIdentifier} in Advertising data
     */
    private final List<? extends UniformResourceIdentifier> mExpect;

    /**
     * @param expect expected List of {@link UniformResourceIdentifier} in Advertising data
     */
    public UniformResourceIdentifierFilter(@NonNull List<? extends UniformResourceIdentifier> expect) {
        mExpect = expect;
    }

    /**
     * @see #UniformResourceIdentifierFilter(List)
     */
    public UniformResourceIdentifierFilter(@NonNull UniformResourceIdentifier... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends UniformResourceIdentifier> actual = advertisingDataParseResult.getUniformResourceIdentifierList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    UniformResourceIdentifier expectElement = mExpect.get(i);
                    UniformResourceIdentifier actualElement = actual.get(i);
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
