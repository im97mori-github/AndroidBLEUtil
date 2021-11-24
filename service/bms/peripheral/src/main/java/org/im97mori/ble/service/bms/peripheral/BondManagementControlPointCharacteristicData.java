package org.im97mori.ble.service.bms.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;

import java.util.Collections;

/**
 * Bond Management Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class BondManagementControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<BondManagementControlPointCharacteristicData> CREATOR = new Creator<BondManagementControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new BondManagementControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BondManagementControlPointCharacteristicData[] newArray(int size) {
            return new BondManagementControlPointCharacteristicData[size];
        }

    };

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (BR/EDR and LE) response)
     */
    @SerializedName("delete_bond_of_requesting_device_br_edr_le_response_value")
    public int deleteBondOfRequestingDeviceBrEdrLeResponseCode;

    /**
     * Delete bond of requesting device (BR/EDR and LE)'s Authorization Code
     */
    @SerializedName("delete_bond_of_requesting_device_br_edr_le_authorization_code")
    public String deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (BR/EDR transport only) response)
     */
    @SerializedName("delete_bond_of_requesting_device_br_edr_response_value")
    public int deleteBondOfRequestingDeviceBrEdrResponseCode;

    /**
     * Delete bond of requesting device (BR/EDR transport only)'s Authorization Code
     */
    @SerializedName("delete_bond_of_requesting_device_br_edr_authorization_code")
    public String deleteBondOfRequestingDeviceBrEdrAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (LE transport only) response)
     */
    @SerializedName("delete_bond_of_requesting_device_le_response_value")
    public int deleteBondOfRequestingDeviceLeResponseCode;

    /**
     * Delete bond of requesting device (LE transport only)'s Authorization Code
     */
    @SerializedName("delete_bond_of_requesting_device_le_authorization_code")
    public String deleteBondOfRequestingDeviceLeAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (BR/EDR and LE) response)
     */
    @SerializedName("delete_all_bonds_on_server_br_edr_le_response_code")
    public int deleteAllBondsOnServerBrEdrLeResponseCode;

    /**
     * Delete all bonds on server (BR/EDR and LE)'s Authorization Code
     */
    @SerializedName("delete_all_bonds_on_server_br_edr_le_authorization_code")
    public String deleteAllBondsOnServerBrEdrLeAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (BR/EDR transport only) response)
     */
    @SerializedName("delete_all_bonds_on_server_br_edr_response_value")
    public int deleteAllBondsOnServerBrEdrResponseCode;

    /**
     * Delete all bonds on server (BR/EDR transport only)'s Authorization Code
     */
    @SerializedName("delete_all_bonds_on_server_br_edr_authorization_code")
    public String deleteAllBondsOnServerBrEdrAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (LE transport only) response)
     */
    @SerializedName("delete_all_bonds_on_server_le_response_value")
    public int deleteAllBondsOnServerLeResponseCode;

    /**
     * Delete all bonds on server (LE transport only)'s Authorization Code
     */
    @SerializedName("delete_all_bonds_on_server_le_authorization_code")
    public String deleteAllBondsOnServerLeAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (BR/EDR and LE) response)
     */
    @SerializedName("delete_all_but_the_active_bond_on_server_br_edr_le_response_value")
    public int deleteAllButTheActiveBondOnServerBrEdrLeResponseCode;

    /**
     * Delete all but the active bond on server (BR/EDR and LE)'s Authorization Code
     */
    @SerializedName("delete_all_but_the_active_bond_on_server_br_edr_le_authorization_code")
    public String deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (BR/EDR transport only) response)
     */
    @SerializedName("delete_all_but_the_active_bond_on_server_br_edr_response_value")
    public int deleteAllButTheActiveBondOnServerBrEdrResponseCode;

    /**
     * Delete all but the active bond on server (BR/EDR transport only)'s Authorization Code
     */
    @SerializedName("delete_all_but_the_active_bond_on_server_br_edr_authorization_code")
    public String deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (LE transport only) response)
     */
    @SerializedName("delete_all_but_the_active_bond_on_server_le_response_value")
    public int deleteAllButTheActiveBondOnServerLeResponseCode;

    /**
     * Delete all but the active bond on server (LE transport only)'s Authorization Code
     */
    @SerializedName("delete_all_but_the_active_bond_on_server_le_authorization_code")
    public String deleteAllButTheActiveBondOnServerLeAuthorizationCode;

    /**
     * @param delay                                                     response delay(millis)
     * @param deleteBondOfRequestingDeviceBrEdrLeResponseCode           response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (BR/EDR and LE) response)
     * @param deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode      Delete bond of requesting device (BR/EDR and LE)'s Authorization Code
     * @param deleteBondOfRequestingDeviceBrEdrResponseCode             response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (BR/EDR transport only) response)
     * @param deleteBondOfRequestingDeviceBrEdrAuthorizationCode        Delete bond of requesting device (BR/EDR transport only)'s Authorization Code
     * @param deleteBondOfRequestingDeviceLeResponseCode                response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete bond of requesting device (LE transport only) response)
     * @param deleteBondOfRequestingDeviceLeAuthorizationCode           Delete bond of requesting device (LE transport only)'s Authorization Code
     * @param deleteAllBondsOnServerBrEdrLeResponseCode                 response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (BR/EDR and LE) response)
     * @param deleteAllBondsOnServerBrEdrLeAuthorizationCode            Delete all bonds on server (BR/EDR and LE)'s Authorization Code
     * @param deleteAllBondsOnServerBrEdrResponseCode                   response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (BR/EDR transport only) response)
     * @param deleteAllBondsOnServerBrEdrAuthorizationCode              Delete all bonds on server (BR/EDR transport only)'s Authorization Code
     * @param deleteAllBondsOnServerLeResponseCode                      response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all bonds on server (LE transport only) response)
     * @param deleteAllBondsOnServerLeAuthorizationCode                 Delete all bonds on server (LE transport only)'s Authorization Code
     * @param deleteAllButTheActiveBondOnServerBrEdrLeResponseCode      response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (BR/EDR and LE) response)
     * @param deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode Delete all but the active bond on server (BR/EDR and LE)'s Authorization Code
     * @param deleteAllButTheActiveBondOnServerBrEdrResponseCode        response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (BR/EDR transport only) response)
     * @param deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode   Delete all but the active bond on server (BR/EDR transport only)'s Authorization Code
     * @param deleteAllButTheActiveBondOnServerLeResponseCode           response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete all but the active bond on server (LE transport only) response)
     * @param deleteAllButTheActiveBondOnServerLeAuthorizationCode      Delete all but the active bond on server (LE transport only)'s Authorization Code
     */
    public BondManagementControlPointCharacteristicData(long delay
            , int deleteBondOfRequestingDeviceBrEdrLeResponseCode
            , @Nullable String deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
            , int deleteBondOfRequestingDeviceBrEdrResponseCode
            , @Nullable String deleteBondOfRequestingDeviceBrEdrAuthorizationCode
            , int deleteBondOfRequestingDeviceLeResponseCode
            , @Nullable String deleteBondOfRequestingDeviceLeAuthorizationCode
            , int deleteAllBondsOnServerBrEdrLeResponseCode
            , @Nullable String deleteAllBondsOnServerBrEdrLeAuthorizationCode
            , int deleteAllBondsOnServerBrEdrResponseCode
            , @Nullable String deleteAllBondsOnServerBrEdrAuthorizationCode
            , int deleteAllBondsOnServerLeResponseCode
            , @Nullable String deleteAllBondsOnServerLeAuthorizationCode
            , int deleteAllButTheActiveBondOnServerBrEdrLeResponseCode
            , @Nullable String deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
            , int deleteAllButTheActiveBondOnServerBrEdrResponseCode
            , @Nullable String deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
            , int deleteAllButTheActiveBondOnServerLeResponseCode
            , @Nullable String deleteAllButTheActiveBondOnServerLeAuthorizationCode) {
        super(BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_WRITE
                , BluetoothGattCharacteristic.PERMISSION_WRITE
                , Collections.emptyList()
                , BluetoothGatt.GATT_SUCCESS
                , delay
                , null
                , 0);
        this.deleteBondOfRequestingDeviceBrEdrLeResponseCode = deleteBondOfRequestingDeviceBrEdrLeResponseCode;
        this.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode;
        this.deleteBondOfRequestingDeviceBrEdrResponseCode = deleteBondOfRequestingDeviceBrEdrResponseCode;
        this.deleteBondOfRequestingDeviceBrEdrAuthorizationCode = deleteBondOfRequestingDeviceBrEdrAuthorizationCode;
        this.deleteBondOfRequestingDeviceLeResponseCode = deleteBondOfRequestingDeviceLeResponseCode;
        this.deleteBondOfRequestingDeviceLeAuthorizationCode = deleteBondOfRequestingDeviceLeAuthorizationCode;
        this.deleteAllBondsOnServerBrEdrLeResponseCode = deleteAllBondsOnServerBrEdrLeResponseCode;
        this.deleteAllBondsOnServerBrEdrLeAuthorizationCode = deleteAllBondsOnServerBrEdrLeAuthorizationCode;
        this.deleteAllBondsOnServerBrEdrResponseCode = deleteAllBondsOnServerBrEdrResponseCode;
        this.deleteAllBondsOnServerBrEdrAuthorizationCode = deleteAllBondsOnServerBrEdrAuthorizationCode;
        this.deleteAllBondsOnServerLeResponseCode = deleteAllBondsOnServerLeResponseCode;
        this.deleteAllBondsOnServerLeAuthorizationCode = deleteAllBondsOnServerLeAuthorizationCode;
        this.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode = deleteAllButTheActiveBondOnServerBrEdrLeResponseCode;
        this.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode;
        this.deleteAllButTheActiveBondOnServerBrEdrResponseCode = deleteAllButTheActiveBondOnServerBrEdrResponseCode;
        this.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode;
        this.deleteAllButTheActiveBondOnServerLeResponseCode = deleteAllButTheActiveBondOnServerLeResponseCode;
        this.deleteAllButTheActiveBondOnServerLeAuthorizationCode = deleteAllButTheActiveBondOnServerLeAuthorizationCode;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public BondManagementControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        deleteBondOfRequestingDeviceBrEdrLeResponseCode = in.readInt();
        deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = in.readString();
        deleteBondOfRequestingDeviceBrEdrResponseCode = in.readInt();
        deleteBondOfRequestingDeviceBrEdrAuthorizationCode = in.readString();
        deleteBondOfRequestingDeviceLeResponseCode = in.readInt();
        deleteBondOfRequestingDeviceLeAuthorizationCode = in.readString();
        deleteAllBondsOnServerBrEdrLeResponseCode = in.readInt();
        deleteAllBondsOnServerBrEdrLeAuthorizationCode = in.readString();
        deleteAllBondsOnServerBrEdrResponseCode = in.readInt();
        deleteAllBondsOnServerBrEdrAuthorizationCode = in.readString();
        deleteAllBondsOnServerLeResponseCode = in.readInt();
        deleteAllBondsOnServerLeAuthorizationCode = in.readString();
        deleteAllButTheActiveBondOnServerBrEdrLeResponseCode = in.readInt();
        deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = in.readString();
        deleteAllButTheActiveBondOnServerBrEdrResponseCode = in.readInt();
        deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = in.readString();
        deleteAllButTheActiveBondOnServerLeResponseCode = in.readInt();
        deleteAllButTheActiveBondOnServerLeAuthorizationCode = in.readString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(deleteBondOfRequestingDeviceBrEdrLeResponseCode);
        dest.writeString(deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode);
        dest.writeInt(deleteBondOfRequestingDeviceBrEdrResponseCode);
        dest.writeString(deleteBondOfRequestingDeviceBrEdrAuthorizationCode);
        dest.writeInt(deleteBondOfRequestingDeviceLeResponseCode);
        dest.writeString(deleteBondOfRequestingDeviceLeAuthorizationCode);
        dest.writeInt(deleteAllBondsOnServerBrEdrLeResponseCode);
        dest.writeString(deleteAllBondsOnServerBrEdrLeAuthorizationCode);
        dest.writeInt(deleteAllBondsOnServerBrEdrResponseCode);
        dest.writeString(deleteAllBondsOnServerBrEdrAuthorizationCode);
        dest.writeInt(deleteAllBondsOnServerLeResponseCode);
        dest.writeString(deleteAllBondsOnServerLeAuthorizationCode);
        dest.writeInt(deleteAllButTheActiveBondOnServerBrEdrLeResponseCode);
        dest.writeString(deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode);
        dest.writeInt(deleteAllButTheActiveBondOnServerBrEdrResponseCode);
        dest.writeString(deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode);
        dest.writeInt(deleteAllButTheActiveBondOnServerLeResponseCode);
        dest.writeString(deleteAllButTheActiveBondOnServerLeAuthorizationCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(deleteBondOfRequestingDeviceBrEdrLeResponseCode).hashCode()
                ^ deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteBondOfRequestingDeviceBrEdrResponseCode).hashCode()
                ^ deleteBondOfRequestingDeviceBrEdrAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteBondOfRequestingDeviceLeResponseCode).hashCode()
                ^ deleteBondOfRequestingDeviceLeAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteAllBondsOnServerBrEdrLeResponseCode).hashCode()
                ^ deleteAllBondsOnServerBrEdrLeAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteAllBondsOnServerBrEdrResponseCode).hashCode()
                ^ deleteAllBondsOnServerBrEdrAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteAllBondsOnServerLeResponseCode).hashCode()
                ^ deleteAllBondsOnServerLeAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteAllButTheActiveBondOnServerBrEdrLeResponseCode).hashCode()
                ^ deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteAllButTheActiveBondOnServerBrEdrResponseCode).hashCode()
                ^ deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode.hashCode()
                ^ Integer.valueOf(deleteAllButTheActiveBondOnServerLeResponseCode).hashCode()
                ^ deleteAllButTheActiveBondOnServerLeAuthorizationCode.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof BondManagementControlPointCharacteristicData) {
            BondManagementControlPointCharacteristicData target = (BondManagementControlPointCharacteristicData) obj;
            result = super.equals(target)
                    && deleteBondOfRequestingDeviceBrEdrLeResponseCode == target.deleteBondOfRequestingDeviceBrEdrLeResponseCode
                    && deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode.equals(target.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode)
                    && deleteBondOfRequestingDeviceBrEdrResponseCode == target.deleteBondOfRequestingDeviceBrEdrResponseCode
                    && deleteBondOfRequestingDeviceBrEdrAuthorizationCode.equals(target.deleteBondOfRequestingDeviceBrEdrAuthorizationCode)
                    && deleteBondOfRequestingDeviceLeResponseCode == target.deleteBondOfRequestingDeviceLeResponseCode
                    && deleteBondOfRequestingDeviceLeAuthorizationCode.equals(target.deleteBondOfRequestingDeviceLeAuthorizationCode)
                    && deleteAllBondsOnServerBrEdrLeResponseCode == target.deleteAllBondsOnServerBrEdrLeResponseCode
                    && deleteAllBondsOnServerBrEdrLeAuthorizationCode.equals(target.deleteAllBondsOnServerBrEdrLeAuthorizationCode)
                    && deleteAllBondsOnServerBrEdrResponseCode == target.deleteAllBondsOnServerBrEdrResponseCode
                    && deleteAllBondsOnServerBrEdrAuthorizationCode.equals(target.deleteAllBondsOnServerBrEdrAuthorizationCode)
                    && deleteAllBondsOnServerLeResponseCode == target.deleteAllBondsOnServerLeResponseCode
                    && deleteAllBondsOnServerLeAuthorizationCode.equals(target.deleteAllBondsOnServerLeAuthorizationCode)
                    && deleteAllButTheActiveBondOnServerBrEdrLeResponseCode == target.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                    && deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode.equals(target.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode)
                    && deleteAllButTheActiveBondOnServerBrEdrResponseCode == target.deleteAllButTheActiveBondOnServerBrEdrResponseCode
                    && deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode.equals(target.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode)
                    && deleteAllButTheActiveBondOnServerLeResponseCode == target.deleteAllButTheActiveBondOnServerLeResponseCode
                    && deleteAllButTheActiveBondOnServerLeAuthorizationCode.equals(target.deleteAllButTheActiveBondOnServerLeAuthorizationCode);
        }
        return result;
    }

}
