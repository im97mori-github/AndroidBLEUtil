package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import java.util.UUID;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
import static org.im97mori.ble.ad.AdvertisingDataConstants.BASE_UUID;

/**
 * <p>
 * Service Data - 16-bit UUID
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ServiceData16BitUUID extends AbstractAdvertisingData {

    /**
     * UUID
     */
    private final UUID mUuid;

    /**
     * byte array of Additional service data
     */
    private final byte[] mAdditionalServiceData;

    /**
     * Constructor for Service Data - 16-bit UUID
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    ServiceData16BitUUID(byte[] data, int offset, int length) {
        super(length);

        // combine with BASE UUID
        long target = data[offset + 2] & 0xff;
        target |= (data[offset + 3] & 0xff) << 8;
        target = target << 32;
        mUuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());

        // Additional service data
        mAdditionalServiceData = new byte[length - 3];
        if (mAdditionalServiceData.length > 0) {
            System.arraycopy(data, offset + 4, mAdditionalServiceData, 0, length - 3);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
    }

    /**
     * @return {@link UUID}
     */
    public UUID getUuid() {
        return mUuid;
    }

    /**
     * @return byte array of Additional service data
     */
    public byte[] getAdditionalServiceData() {
        return mAdditionalServiceData;
    }

}
