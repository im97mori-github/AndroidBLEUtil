package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Characteristic data class
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CharacteristicData implements Parcelable, ByteArrayInterface {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<CharacteristicData> CREATOR = new Creator<CharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CharacteristicData createFromParcel(@NonNull Parcel in) {
            return new CharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CharacteristicData[] newArray(int size) {
            return new CharacteristicData[size];
        }

    };

    /**
     * {@link UUID} instance
     */
    @SerializedName("uuid")
    public UUID uuid;

    /**
     * combination of
     * {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
     * {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE_NO_RESPONSE}
     * {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE}
     * {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
     * {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_INDICATE}
     */
    @SerializedName("property")
    public int property;

    /**
     * combination of
     * {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_READ}
     * {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_WRITE}
     */
    @SerializedName("permission")
    public int permission;

    /**
     * {@link DescriptorData} list
     */
    @SerializedName("descriptor_data_list")
    public List<DescriptorData> descriptorDataList = new ArrayList<>();

    /**
     * response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
     */
    @SerializedName("response_code")
    public int responseCode;

    /**
     * responce delay(millis)
     */
    @SerializedName("delay")
    public long delay;

    /**
     * data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     */
    @SerializedName("data")
    public byte[] data;

    /**
     * overwritten data with {@link android.bluetooth.BluetoothGattServerCallback#onCharacteristicWriteRequest(BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[])}
     */
    public byte[] currentData;

    /**
     * temporary(preparedWrite) data with {@link android.bluetooth.BluetoothGattServerCallback#onCharacteristicWriteRequest(BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[])}
     */
    public byte[] temporaryData;

    /**
     * notification / indication count
     * {@code -1} is infinit
     */
    @SerializedName("notification_count")
    public int notificationCount = -1;

    /**
     * Constructor
     */
    public CharacteristicData() {
    }

    /**
     * @param uuid               {@link UUID} instance
     * @param property           combination of
     *                           {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
     *                           {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE_NO_RESPONSE}
     *                           {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE}
     *                           {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
     *                           {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_INDICATE}
     * @param permission         combination of
     *                           {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_READ}
     *                           {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_WRITE}
     * @param descriptorDataList {@link DescriptorData} list
     * @param responseCode       response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
     * @param delay              responce delay(millis)
     * @param data               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     * @param notificationCount  notification / indication count
     */
    public CharacteristicData(@NonNull UUID uuid, int property, int permission, @NonNull List<DescriptorData> descriptorDataList, int responseCode, long delay, @Nullable byte[] data, int notificationCount) {
        this.uuid = uuid;
        this.property = property;
        this.permission = permission;
        this.descriptorDataList = descriptorDataList;
        this.responseCode = responseCode;
        this.delay = delay;
        this.data = data;
        this.notificationCount = notificationCount;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public CharacteristicData(@NonNull Parcel in) {
        uuid = (UUID) in.readSerializable();
        property = in.readInt();
        permission = in.readInt();
        descriptorDataList = in.createTypedArrayList(DescriptorData.CREATOR);
        responseCode = in.readInt();
        delay = in.readLong();
        data = in.createByteArray();
        currentData = in.createByteArray();
        temporaryData = in.createByteArray();
        notificationCount = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] result;
        if (currentData != null) {
            result = currentData;
        } else {
            result = data;
        }
        return result;
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
        dest.writeSerializable(uuid);
        dest.writeInt(property);
        dest.writeInt(permission);
        DescriptorData[] descriptorDataList = new DescriptorData[this.descriptorDataList.size()];
        dest.writeTypedArray(this.descriptorDataList.toArray(descriptorDataList), flags);
        dest.writeInt(responseCode);
        dest.writeLong(delay);
        dest.writeByteArray(data);
        dest.writeByteArray(currentData);
        dest.writeByteArray(temporaryData);
        dest.writeInt(notificationCount);
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
                ^ Arrays.hashCode(currentData)
                ^ Arrays.hashCode(temporaryData)
                ^ Integer.valueOf(notificationCount).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof CharacteristicData) {
            CharacteristicData target = (CharacteristicData) obj;
            result = uuid.equals(target.uuid)
                    && property == target.property
                    && permission == target.permission
                    && Arrays.equals(descriptorDataList.toArray(), target.descriptorDataList.toArray())
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData)
                    && Arrays.equals(temporaryData, target.temporaryData)
                    && notificationCount == target.notificationCount;
        }
        return result;
    }

}
