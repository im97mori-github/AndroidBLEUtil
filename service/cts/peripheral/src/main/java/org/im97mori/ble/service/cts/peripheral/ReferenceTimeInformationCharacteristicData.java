package org.im97mori.ble.service.cts.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.SystemClock;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;

import java.util.Collections;

import static org.im97mori.ble.constants.CharacteristicUUID.REFERENCE_TIME_INFORMATION_CHARACTERISTIC;

/**
 * Reference Time Information Characteristic data class
 */
public class ReferenceTimeInformationCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<ReferenceTimeInformationCharacteristicData> CREATOR = new Creator<ReferenceTimeInformationCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReferenceTimeInformationCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new ReferenceTimeInformationCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReferenceTimeInformationCharacteristicData[] newArray(int size) {
            return new ReferenceTimeInformationCharacteristicData[size];
        }

    };

    /**
     * @see SystemClock#elapsedRealtime()
     */
    @Expose(serialize = false, deserialize = false)
    public long lastUpdate;

    /**
     * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
     * @param delay        response delay(millis)
     * @param data         data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     */
    public ReferenceTimeInformationCharacteristicData(int responseCode, long delay, byte[] data) {
        super(REFERENCE_TIME_INFORMATION_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_READ
                , BluetoothGattCharacteristic.PERMISSION_READ
                , Collections.emptyList()
                , responseCode
                , delay
                , data
                , 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public ReferenceTimeInformationCharacteristicData(@NonNull Parcel in) {
        super(in);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        ReferenceTimeInformation base = new ReferenceTimeInformation(super.getBytes());

        long delta = SystemClock.elapsedRealtime() - lastUpdate;
        long days = delta / DateUtils.DAY_IN_MILLIS;
        long hours;
        if (days > ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_DAYS) {
            days = ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_DAYS;
            hours = ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_HOURS;
        } else {
            hours = delta / DateUtils.HOUR_IN_MILLIS;
            if (hours > ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_HOURS) {
                hours = ReferenceTimeInformation.DAYS_SINCE_UPDATE_255_OR_MORE_HOURS;
            }
        }
        return new ReferenceTimeInformation(base.getTimeSource(), base.getAccuracy(), (int) days, (int) hours).getBytes();
    }


}
