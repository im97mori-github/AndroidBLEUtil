package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_PUBLIC_TARGET_ADDRESS;

/**
 * <p>
 * Public Target Address
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class PublicTargetAddress extends AbstractAdvertisingData {

    /**
     * Public Target Address list
     */
    private final List<byte[]> mAddressList;

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    PublicTargetAddress(byte[] data, int offset, int length) {
        super(length);

        List<byte[]> addressList = new ArrayList<>();
        byte[] address;
        for (int i = offset + 2; i < offset + length - 1; i += 6) {
            address = new byte[6];
            System.arraycopy(data, i, address, 0, 6);
            addressList.add(address);
        }
        mAddressList = Collections.synchronizedList(Collections.unmodifiableList(addressList));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_PUBLIC_TARGET_ADDRESS;
    }

    /**
     * @return Public Target Address list
     */
    public List<byte[]> getAddressList() {
        return mAddressList;
    }

}
