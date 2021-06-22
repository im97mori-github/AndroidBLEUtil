package org.im97mori.ble.service.ftms.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;

import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_STATUS_CHARACTERISTIC;

/**
 * Fitness Machine Status Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class FitnessMachineStatusCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<FitnessMachineStatusCharacteristicData> CREATOR = new Creator<FitnessMachineStatusCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineStatusCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineStatusCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineStatusCharacteristicData[] newArray(int size) {
            return new FitnessMachineStatusCharacteristicData[size];
        }

    };

    /**
     * Spin Down Status Value
     */
    @SerializedName("spin_down_status_value")
    public int spinDownStatusValue;

    /**
     * @param descriptorDataList  {@link DescriptorData} list
     * @param spinDownStatusValue Spin Down Status Value
     */
    public FitnessMachineStatusCharacteristicData(@NonNull List<DescriptorData> descriptorDataList
            , int spinDownStatusValue) {
        super(FITNESS_MACHINE_STATUS_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                , 0
                , descriptorDataList
                , BluetoothGatt.GATT_SUCCESS
                , 0
                , null
                , 0);
        this.spinDownStatusValue = spinDownStatusValue;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public FitnessMachineStatusCharacteristicData(@NonNull Parcel in) {
        super(in);
        spinDownStatusValue = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(spinDownStatusValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return uuid.hashCode()
                ^ Integer.valueOf(property).hashCode()
                ^ Integer.valueOf(permission).hashCode()
                ^ Arrays.hashCode(descriptorDataList.toArray())
                ^ Integer.valueOf(responseCode).hashCode()
                ^ Long.valueOf(delay).hashCode()
                ^ Arrays.hashCode(data)
                ^ Integer.valueOf(notificationCount).hashCode()
                ^ Arrays.hashCode(currentData)
                ^ Arrays.hashCode(temporaryData)
                ^ Integer.valueOf(spinDownStatusValue).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof FitnessMachineStatusCharacteristicData) {
            FitnessMachineStatusCharacteristicData target = (FitnessMachineStatusCharacteristicData) obj;
            result = uuid.equals(target.uuid)
                    && property == target.property
                    && permission == target.permission
                    && Arrays.equals(descriptorDataList.toArray(), target.descriptorDataList.toArray())
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData)
                    && Arrays.equals(temporaryData, target.temporaryData)
                    && notificationCount == target.notificationCount
                    && spinDownStatusValue == target.spinDownStatusValue;
        }
        return result;
    }

}
