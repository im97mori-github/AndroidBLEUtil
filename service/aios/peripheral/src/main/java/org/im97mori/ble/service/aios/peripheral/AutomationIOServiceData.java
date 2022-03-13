package org.im97mori.ble.service.aios.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Automation IO Service data class
 */
public class AutomationIOServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<AutomationIOServiceData> CREATOR = new Creator<AutomationIOServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AutomationIOServiceData createFromParcel(@NonNull Parcel in) {
            return new AutomationIOServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AutomationIOServiceData[] newArray(int size) {
            return new AutomationIOServiceData[size];
        }

    };

    /**
     * Digital characteristic data list
     */
    @SerializedName("digital_list")
    public List<DigitalCharacteristicData> digitalList;

    /**
     * Constructor
     */
    public AutomationIOServiceData() {
    }

    /**
     * @param characteristicList {@link CharacteristicData} list
     * @param digitalList        Digital characteristic data list
     */
    public AutomationIOServiceData(@NonNull List<CharacteristicData> characteristicList
            , @NonNull List<DigitalCharacteristicData> digitalList) {
        super(AUTOMATION_IO_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , characteristicList);
        this.digitalList = digitalList;

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public AutomationIOServiceData(@NonNull Parcel in) {
        super(in);
        digitalList = in.createTypedArrayList(DigitalCharacteristicData.CREATOR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        ArrayList<CharacteristicData> workList = new ArrayList<>(super.getCharacteristicDataList());
        workList.addAll(digitalList);
        return workList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(digitalList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(digitalList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            AutomationIOServiceData target = (AutomationIOServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(digitalList, target.digitalList);
        }
        return result;
    }
}
