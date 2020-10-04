package org.im97mori.ble.service.uds.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;

import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;

/**
 * User Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class UserControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<UserControlPointCharacteristicData> CREATOR = new Creator<UserControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new UserControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserControlPointCharacteristicData[] newArray(int size) {
            return new UserControlPointCharacteristicData[size];
        }

    };

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Cumulative Value response)
     */
    @SerializedName("register_new_user_responce_value")
    public int registerNewUserResponceValue;

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Mask Location and Speed Characteristic Content response)
     */
    @SerializedName("consent_responce_value")
    public int consentResponceValue;

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Navigation Control response)
     */
    @SerializedName("delete_user_data_responce_value")
    public int deleteUserDataResponceValue;

    /**
     * part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Number of Routes response)
     */
    @SerializedName("list_all_users_responce_value")
    public int listAllUsersResponceValue;

    /**
     * part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Number of Routes response)
     */
    @SerializedName("delete_users_responce_value")
    public int deleteUsersResponceValue;

    /**
     * @param property                     combination of
     *                                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
     *                                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE_NO_RESPONSE}
     *                                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE}
     *                                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
     *                                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_INDICATE}
     * @param permission                   combination of
     *                                     {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_READ}
     *                                     {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_WRITE}
     * @param descriptorDataList           {@link DescriptorData} list
     * @param delay                        responce delay(millis)
     * @param notificationCount            notification / indication count
     * @param registerNewUserResponceValue characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Register New User response)
     * @param consentResponceValue         characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Consent Response response)
     * @param deleteUserDataResponceValue  characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete User Data response)
     * @param listAllUsersResponceValue    characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(List All Users response)
     * @param deleteUsersResponceValue     characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete Users response)
     */
    public UserControlPointCharacteristicData(int property
            , int permission
            , @NonNull List<DescriptorData> descriptorDataList
            , long delay
            , int notificationCount
            , int registerNewUserResponceValue
            , int consentResponceValue
            , int deleteUserDataResponceValue
            , int listAllUsersResponceValue
            , int deleteUsersResponceValue) {
        super(USER_CONTROL_POINT_CHARACTERISTIC, property, permission, descriptorDataList, BluetoothGatt.GATT_SUCCESS, delay, new byte[0], notificationCount);
        this.registerNewUserResponceValue = registerNewUserResponceValue;
        this.consentResponceValue = consentResponceValue;
        this.deleteUserDataResponceValue = deleteUserDataResponceValue;
        this.listAllUsersResponceValue = listAllUsersResponceValue;
        this.deleteUsersResponceValue = deleteUsersResponceValue;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public UserControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        registerNewUserResponceValue = in.readInt();
        consentResponceValue = in.readInt();
        deleteUserDataResponceValue = in.readInt();
        listAllUsersResponceValue = in.readInt();
        deleteUsersResponceValue = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(registerNewUserResponceValue);
        dest.writeInt(consentResponceValue);
        dest.writeInt(deleteUserDataResponceValue);
        dest.writeInt(listAllUsersResponceValue);
        dest.writeInt(deleteUsersResponceValue);
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
                ^ Integer.valueOf(registerNewUserResponceValue).hashCode()
                ^ Integer.valueOf(consentResponceValue).hashCode()
                ^ Integer.valueOf(deleteUserDataResponceValue).hashCode()
                ^ Integer.valueOf(listAllUsersResponceValue).hashCode()
                ^ Integer.valueOf(deleteUsersResponceValue).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof UserControlPointCharacteristicData) {
            UserControlPointCharacteristicData target = (UserControlPointCharacteristicData) obj;
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
                    && registerNewUserResponceValue == target.registerNewUserResponceValue
                    && consentResponceValue == target.consentResponceValue
                    && deleteUserDataResponceValue == target.deleteUserDataResponceValue
                    && listAllUsersResponceValue == target.listAllUsersResponceValue
                    && deleteUsersResponceValue == target.deleteUsersResponceValue;
        }
        return result;
    }

}
