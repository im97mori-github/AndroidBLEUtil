package org.im97mori.ble.service.cts.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.CURRENT_TIME_SERVICE;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Current Time Service data class
 */
public class CurrentTimeServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<CurrentTimeServiceData> CREATOR = new Creator<CurrentTimeServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTimeServiceData createFromParcel(@NonNull Parcel in) {
            return new CurrentTimeServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTimeServiceData[] newArray(int size) {
            return new CurrentTimeServiceData[size];
        }

    };

    /**
     * Current Time Measurement data
     */
    @SerializedName("current_time_measurement")
    public CharacteristicData currentTime;

    /**
     * Local Time Information data
     */
    @SerializedName("local_time_information")
    public CharacteristicData localTimeInformation;

    /**
     * Reference Time Information data
     */
    @SerializedName("reference_time_information")
    public ReferenceTimeInformationCharacteristicData referenceTimeInformation;

    /**
     * Constructor
     */
    public CurrentTimeServiceData() {
    }

    /**
     * @param currentTime              Current Time Measurement data
     * @param localTimeInformation     Local Time Information data
     * @param referenceTimeInformation Reference Time Information data
     */
    public CurrentTimeServiceData(@NonNull CharacteristicData currentTime
            , @Nullable CharacteristicData localTimeInformation
            , @Nullable ReferenceTimeInformationCharacteristicData referenceTimeInformation) {
        super(CURRENT_TIME_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.currentTime = currentTime;
        this.localTimeInformation = localTimeInformation;
        this.referenceTimeInformation = referenceTimeInformation;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public CurrentTimeServiceData(@NonNull Parcel in) {
        super(in);
        currentTime = in.readParcelable(this.getClass().getClassLoader());
        localTimeInformation = in.readParcelable(this.getClass().getClassLoader());
        referenceTimeInformation = in.readParcelable(this.getClass().getClassLoader());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(currentTime);
        if (localTimeInformation != null) {
            characteristicDataList.add(localTimeInformation);
        }
        if (referenceTimeInformation != null) {
            characteristicDataList.add(referenceTimeInformation);
        }
        return characteristicDataList;
    }


    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(currentTime, flags);
        dest.writeParcelable(localTimeInformation, flags);
        dest.writeParcelable(referenceTimeInformation, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(currentTime)
                ^ Objects.hashCode(localTimeInformation)
                ^ Objects.hashCode(referenceTimeInformation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            CurrentTimeServiceData target = (CurrentTimeServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(currentTime, target.currentTime)
                    && Objects.equals(localTimeInformation, target.localTimeInformation)
                    && Objects.equals(referenceTimeInformation, target.referenceTimeInformation);
        }
        return result;
    }
}
