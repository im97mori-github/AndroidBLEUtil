package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Characteristic data class
 */
@SuppressWarnings("ALL")
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
    public List<DescriptorData> descriptorDataList;

    /**
     * response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
     */
    @SerializedName("response_code")
    public int responseCode;

    /**
     * response delay(millis)
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
    public final HashMap<Integer, byte[]> temporaryData = new HashMap<>();

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
     * @param delay              response delay(millis)
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
        Bundle bundle = in.readBundle(getClass().getClassLoader());
        //noinspection ConstantConditions
        for (String key : bundle.keySet()) {
            temporaryData.put(Integer.parseInt(key), bundle.getByteArray(key));
        }
        notificationCount = in.readInt();
    }

    /**
     * @return {@link #descriptorDataList}
     */
    public List<DescriptorData> getDescriptorDataList() {
        return descriptorDataList;
    }

    /**
     * check {@link #temporaryData} data
     *
     * @return {@code true}:ready for {@link #executeReliableWrite()}, {@code false}:not ready
     */
    public synchronized boolean isTemporaryDataValid() {
        boolean result = true;
        List<Integer> keyList = new ArrayList<>(temporaryData.keySet());
        Collections.sort(keyList);
        if (!keyList.isEmpty()) {
            if (keyList.get(0) != 0) {
                result = false;
            } else {
                int position = 0;
                for (Integer key : keyList) {
                    if (key != position) {
                        result = false;
                        break;
                    }
                    byte[] targetData = temporaryData.get(key);
                    if (targetData == null) {
                        result = false;
                        break;
                    }
                    position += targetData.length;
                }
            }
        }
        return result;
    }

    /**
     * execute reliable write
     */
    public synchronized boolean executeReliableWrite() {
        boolean result = isTemporaryDataValid();
        if (result) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            List<Integer> keyList = new ArrayList<>(temporaryData.keySet());
            Collections.sort(keyList);
            for (Integer key : keyList) {
                byte[] targetData = temporaryData.get(key);
                try {
                    baos.write(targetData);
                } catch (IOException e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
            currentData = baos.toByteArray();
        }
        temporaryData.clear();
        return result;
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
        Bundle bundle = new Bundle();
        for (Map.Entry<Integer, byte[]> entry : temporaryData.entrySet()) {
            bundle.putByteArray(entry.getKey().toString(), entry.getValue());
        }
        dest.writeBundle(bundle);
        dest.writeInt(notificationCount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode = Objects.hashCode(uuid)
                ^ Integer.valueOf(property).hashCode()
                ^ Integer.valueOf(permission).hashCode()
                ^ Objects.hashCode(descriptorDataList)
                ^ Integer.valueOf(responseCode).hashCode()
                ^ Long.valueOf(delay).hashCode()
                ^ Arrays.hashCode(data)
                ^ Arrays.hashCode(currentData)
                ^ Integer.valueOf(notificationCount).hashCode();
        for (Map.Entry<Integer, byte[]> entry : temporaryData.entrySet()) {
            hashCode ^= entry.getKey().hashCode();
            hashCode ^= Arrays.hashCode(entry.getValue());
        }
        return hashCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof CharacteristicData) {
            CharacteristicData target = (CharacteristicData) obj;
            result = Objects.equals(uuid, target.uuid)
                    && property == target.property
                    && permission == target.permission
                    && Objects.equals(descriptorDataList, target.descriptorDataList)
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData)
                    && notificationCount == target.notificationCount;
            if (result) {
                if (temporaryData.size() == target.temporaryData.size()) {
                    for (Integer key : temporaryData.keySet()) {
                        if (!Arrays.equals(temporaryData.get(key), target.temporaryData.get(key))) {
                            result = false;
                            break;
                        }
                    }
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

}
