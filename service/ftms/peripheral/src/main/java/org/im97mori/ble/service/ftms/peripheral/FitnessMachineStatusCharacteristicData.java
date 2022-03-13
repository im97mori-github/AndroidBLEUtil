package org.im97mori.ble.service.ftms.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_STATUS_CHARACTERISTIC;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;

import java.util.List;

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
     * Constructor
     */
    public FitnessMachineStatusCharacteristicData() {
    }

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
        return super.hashCode()
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
            result = super.equals(target)
                    && spinDownStatusValue == target.spinDownStatusValue;
        }
        return result;
    }

}
