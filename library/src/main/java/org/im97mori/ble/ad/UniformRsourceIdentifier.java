package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import java.net.URI;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
import static org.im97mori.ble.ad.AdvertisingDataConstants.URI_SCHEME_NAME_STRING_MAPPING;

/**
 * <p>
 * URI
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class UniformRsourceIdentifier extends AbstractAdvertisingData {

    /**
     * URI text
     */
    private final String mUriString;

    /**
     * URI
     */
    private final URI mUri;

    /**
     * Constructor for URI
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    UniformRsourceIdentifier(byte[] data, int offset, int length) {
        super(length);

        mUriString = new String(data, offset + 2, length - 1);
        int scheme = mUriString.charAt(0) & 0xff;
        mUri = URI.create(URI_SCHEME_NAME_STRING_MAPPING.get(scheme) + mUriString.substring(1));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
    }

    /**
     * @return URI text
     */
    public String getUriString() {
        return mUriString;
    }

    /**
     * @return {@link URI}
     */
    public URI getUri() {
        return mUri;
    }

}
