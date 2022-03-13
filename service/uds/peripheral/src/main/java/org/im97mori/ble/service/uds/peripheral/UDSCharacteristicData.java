package org.im97mori.ble.service.uds.peripheral;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.core.UserIndexUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * UDS Characteristic data class
 */
public class UDSCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<UDSCharacteristicData> CREATOR = new Creator<UDSCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UDSCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new UDSCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UDSCharacteristicData[] newArray(int size) {
            return new UDSCharacteristicData[size];
        }

    };

    /**
     * key:user index, value:user data
     */
    private final Map<Integer, CharacteristicData> userDataMap = new HashMap<>();

    /**
     * Constructor
     */
    public UDSCharacteristicData() {
    }

    /**
     * @see CharacteristicData#CharacteristicData(UUID, int, int, List, int, long, byte[], int)
     */
    public UDSCharacteristicData(@NonNull UUID uuid, int property, int permission, @NonNull List<DescriptorData> descriptorDataList, int responseCode, long delay, @Nullable byte[] data, int notificationCount) {
        super(uuid, property, permission, descriptorDataList, responseCode, delay, data, notificationCount);
    }

    /**
     * @param in Parcel
     * @see CharacteristicData#CharacteristicData(Parcel)
     */
    public UDSCharacteristicData(@NonNull Parcel in) {
        super(in);
    }

    /**
     * get user data
     *
     * @param userIndex user index
     * @return user data {@link CharacteristicData} instance or {@code null}({@link UserIndexUtils#USER_ID_UNKNOWN_USER})
     */
    @Nullable
    public CharacteristicData getUserData(int userIndex) {
        CharacteristicData characteristicData = null;
        if (!UserIndexUtils.isUserIdUnknownUser(userIndex)) {
            characteristicData = userDataMap.get(userIndex);
            if (characteristicData == null) {
                Parcel parcel = Parcel.obtain();
                this.writeToParcel(parcel, 0);
                parcel.setDataPosition(0);
                characteristicData = CharacteristicData.CREATOR.createFromParcel(parcel);
                userDataMap.put(userIndex, characteristicData);
                parcel.recycle();
            }
        }
        return characteristicData;
    }

    /**
     * remove user data
     *
     * @param userIndex user index or {@link UserIndexUtils#USER_ID_UNKNOWN_USER} for remove all user data
     */
    public void removeUserData(int userIndex) {
        if (UserIndexUtils.isUserIdUnknownUser(userIndex)) {
            userDataMap.clear();
        } else {
            userDataMap.remove(userIndex);
        }
    }

    /**
     * set user data
     *
     * @param userIndex          user index
     * @param characteristicData user data {@link CharacteristicData} instance
     */
    public void setUserData(int userIndex, @NonNull CharacteristicData characteristicData) {
        if (!UserIndexUtils.isUserIdUnknownUser(userIndex)) {
            userDataMap.put(userIndex, characteristicData);
        }
    }

}
