package org.im97mori.ble.advertising.filter;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.EncryptedData;

import java.util.Arrays;
import java.util.List;

/**
 * filter for {@link EncryptedDataFilter}
 */
@SuppressWarnings({"WeakerAccess"})
public class EncryptedDataFilter implements AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> {

    /**
     * expected List of {@link EncryptedData} in Advertising data
     */
    private final List<? extends EncryptedData> mExpect;

    /**
     * @param expect expected List of {@link EncryptedData} in Advertising data
     */
    public EncryptedDataFilter(@NonNull List<? extends EncryptedData> expect) {
        mExpect = expect;
    }

    /**
     * @see #EncryptedDataFilter(List)
     */
    public EncryptedDataFilter(@NonNull EncryptedData... expects) {
        this(Arrays.asList(expects));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMatched(@NonNull AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
        boolean result = false;
        List<? extends EncryptedData> actual = advertisingDataParseResult.getEncryptedDataList();
        if (mExpect.isEmpty()) {
            if (actual.isEmpty()) {
                result = true;
            }
        } else {
            if (mExpect.size() == actual.size()) {
                result = true;
                for (int i = 0; i < mExpect.size(); i++) {
                    EncryptedData expectElement = mExpect.get(i);
                    EncryptedData actualElement = actual.get(i);
                    if (expectElement.getLength() != actualElement.getLength()
                            || expectElement.getDataType() != actualElement.getDataType()) {
                        if (expectElement.getLength() != actualElement.getLength()
                                || expectElement.getDataType() != actualElement.getDataType()
                                || !Arrays.equals(expectElement.getRandomizer(), actualElement.getRandomizer())
                                || !Arrays.equals(expectElement.getPayload(), actualElement.getPayload())
                                || !Arrays.equals(expectElement.getMic(), actualElement.getMic())) {
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
