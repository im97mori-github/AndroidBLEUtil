package org.im97mori.ble.service.uds.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;

import java.util.List;

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
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Cumulative Value response)
     */
    @SerializedName("register_new_user_response_value")
    public int registerNewUserResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Mask Location and Speed Characteristic Content response)
     */
    @SerializedName("consent_response_value")
    public int consentResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Navigation Control response)
     */
    @SerializedName("delete_user_data_response_value")
    public int deleteUserDataResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Number of Routes response)
     */
    @SerializedName("list_all_users_response_value")
    public int listAllUsersResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Number of Routes response)
     */
    @SerializedName("delete_users_response_value")
    public int deleteUsersResponseValue;

    /**
     * Constructor
     */
    public UserControlPointCharacteristicData() {
    }

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
     * @param delay                        response delay(millis)
     * @param registerNewUserResponseValue characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Register New User response)
     * @param consentResponseValue         characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Consent Response response)
     * @param deleteUserDataResponseValue  characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete User Data response)
     * @param listAllUsersResponseValue    characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(List All Users response)
     * @param deleteUsersResponseValue     characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete Users response)
     */
    public UserControlPointCharacteristicData(int property
            , int permission
            , @NonNull List<DescriptorData> descriptorDataList
            , long delay
            , int registerNewUserResponseValue
            , int consentResponseValue
            , int deleteUserDataResponseValue
            , int listAllUsersResponseValue
            , int deleteUsersResponseValue) {
        super(USER_CONTROL_POINT_CHARACTERISTIC, property, permission, descriptorDataList, BluetoothGatt.GATT_SUCCESS, delay, new byte[0], 0);
        this.registerNewUserResponseValue = registerNewUserResponseValue;
        this.consentResponseValue = consentResponseValue;
        this.deleteUserDataResponseValue = deleteUserDataResponseValue;
        this.listAllUsersResponseValue = listAllUsersResponseValue;
        this.deleteUsersResponseValue = deleteUsersResponseValue;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public UserControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        registerNewUserResponseValue = in.readInt();
        consentResponseValue = in.readInt();
        deleteUserDataResponseValue = in.readInt();
        listAllUsersResponseValue = in.readInt();
        deleteUsersResponseValue = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(registerNewUserResponseValue);
        dest.writeInt(consentResponseValue);
        dest.writeInt(deleteUserDataResponseValue);
        dest.writeInt(listAllUsersResponseValue);
        dest.writeInt(deleteUsersResponseValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(registerNewUserResponseValue).hashCode()
                ^ Integer.valueOf(consentResponseValue).hashCode()
                ^ Integer.valueOf(deleteUserDataResponseValue).hashCode()
                ^ Integer.valueOf(listAllUsersResponseValue).hashCode()
                ^ Integer.valueOf(deleteUsersResponseValue).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof UserControlPointCharacteristicData) {
            UserControlPointCharacteristicData target = (UserControlPointCharacteristicData) obj;
            result = super.equals(target)
                    && registerNewUserResponseValue == target.registerNewUserResponseValue
                    && consentResponseValue == target.consentResponseValue
                    && deleteUserDataResponseValue == target.deleteUserDataResponseValue
                    && listAllUsersResponseValue == target.listAllUsersResponseValue
                    && deleteUsersResponseValue == target.deleteUsersResponseValue;
        }
        return result;
    }

}
