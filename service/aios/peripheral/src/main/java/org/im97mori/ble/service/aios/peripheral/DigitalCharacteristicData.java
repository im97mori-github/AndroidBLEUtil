package org.im97mori.ble.service.aios.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.NUMBER_OF_DIGITALS_DESCRIPTOR;

import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitals;

import java.util.ArrayList;

public class DigitalCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<DigitalCharacteristicData> CREATOR = new Creator<DigitalCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DigitalCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new DigitalCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DigitalCharacteristicData[] newArray(int size) {
            return new DigitalCharacteristicData[size];
        }

    };

    public DigitalCharacteristicData(int property, int permission, int responseCode, long delay, @NonNull byte[] value) {
        super(DIGITAL_CHARACTERISTIC
                , property
                , permission
                , new ArrayList<>()
                , responseCode
                , delay
                , value
                , -1);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public DigitalCharacteristicData(@NonNull Parcel in) {
        super(in);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean executeReliableWrite() {
        boolean result = super.executeReliableWrite();
        if (result) {
            for (DescriptorData descriptorData : descriptorDataList) {
                if (NUMBER_OF_DIGITALS_DESCRIPTOR.equals(descriptorData.uuid)) {
                    currentData = AutomationIOServiceMockCallback.sanitizeDigitalData(currentData, new NumberOfDigitals(descriptorData.getBytes()).getNoOfDigitals());
                    break;
                }
            }
        }
        return result;
    }

}
