package org.im97mori.ble;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Service data class
 */
@SuppressWarnings({"WeakerAccess"})
public class ServiceData implements Parcelable {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<ServiceData> CREATOR = new Creator<ServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData createFromParcel(@NonNull Parcel in) {
            return new ServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData[] newArray(int size) {
            return new ServiceData[size];
        }

    };

    /**
     * {@link UUID} instance
     */
    @SerializedName("uuid")
    public UUID uuid;

    /**
     * {@link BluetoothGattService#SERVICE_TYPE_PRIMARY} or {@link BluetoothGattService#SERVICE_TYPE_SECONDARY}
     */
    @SerializedName("type")
    public int type;

    /**
     * {@link CharacteristicData} list
     */
    @SerializedName("characteristic_data_list")
    public List<CharacteristicData> characteristicDataList;

    /**
     * Constructor
     */
    public ServiceData() {
    }

    /**
     * @param uuid                   {@link UUID} instance
     * @param type                   {@link BluetoothGattService#SERVICE_TYPE_PRIMARY} or {@link BluetoothGattService#SERVICE_TYPE_SECONDARY}
     * @param characteristicDataList {@link CharacteristicData} list
     */
    public ServiceData(@NonNull UUID uuid, int type, @NonNull List<CharacteristicData> characteristicDataList) {
        this.uuid = uuid;
        this.type = type;
        this.characteristicDataList = characteristicDataList;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public ServiceData(@NonNull Parcel in) {
        uuid = UUID.fromString(in.readString());
        type = in.readInt();
        characteristicDataList = in.createTypedArrayList(CharacteristicData.CREATOR);
    }

    /**
     * @return {@link #characteristicDataList}
     */
    public List<CharacteristicData> getCharacteristicDataList() {
        return characteristicDataList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(uuid.toString());
        dest.writeInt(type);
        CharacteristicData[] characteristicDataArray = new CharacteristicData[characteristicDataList.size()];
        dest.writeTypedArray(characteristicDataList.toArray(characteristicDataArray), flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(uuid)
                ^ Integer.valueOf(type).hashCode()
                ^ Objects.hashCode(characteristicDataList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            ServiceData target = (ServiceData) obj;
            result = Objects.equals(uuid, target.uuid)
                    && type == target.type
                    && Objects.equals(characteristicDataList, target.characteristicDataList);
        }
        return result;
    }

}
