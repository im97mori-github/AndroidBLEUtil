package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
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
 * Descriptor data class
 */
@SuppressWarnings({"WeakerAccess"})
public class DescriptorData implements Parcelable, ByteArrayInterface {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<DescriptorData> CREATOR = new Creator<DescriptorData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DescriptorData createFromParcel(@NonNull Parcel in) {
            return new DescriptorData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DescriptorData[] newArray(int size) {
            return new DescriptorData[size];
        }

    };

    /**
     * {@link UUID} instance
     */
    @SerializedName("uuid")
    public UUID uuid;

    /**
     * combination of
     * {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
     * {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
     */
    @SerializedName("permission")
    public int permission;

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
     * temporary(preparedWrite) data with {@link BluetoothGattServerCallback#onDescriptorWriteRequest(BluetoothDevice, int, BluetoothGattDescriptor, boolean, boolean, int, byte[])}
     */
    public final HashMap<Integer, byte[]> temporaryData = new HashMap<>();

    /**
     * Constructor
     */
    public DescriptorData() {
    }

    /**
     * @param uuid         {@link UUID} instance
     * @param permission   combination of
     *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
     *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
     * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
     * @param delay        response delay(millis)
     * @param data         data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
     */
    public DescriptorData(@NonNull UUID uuid, int permission, int responseCode, long delay, @Nullable byte[] data) {
        this.uuid = uuid;
        this.permission = permission;
        this.responseCode = responseCode;
        this.delay = delay;
        this.data = data;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public DescriptorData(@NonNull Parcel in) {
        uuid = (UUID) in.readSerializable();
        permission = in.readInt();
        responseCode = in.readInt();
        delay = in.readLong();
        data = in.createByteArray();
        currentData = in.createByteArray();
        Bundle bundle = in.readBundle(getClass().getClassLoader());
        //noinspection ConstantConditions
        for (String key : bundle.keySet()) {
            temporaryData.put(Integer.parseInt(key), bundle.getByteArray(key));
        }
    }

    /**
     * check {@link #temporaryData} data
     *
     * @return {@code true}:ready for {@link #executeReliableWrite()}, {@code false}:not ready
     */
    public boolean isTemporaryDataValid() {
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
        dest.writeInt(permission);
        dest.writeInt(responseCode);
        dest.writeLong(delay);
        dest.writeByteArray(data);
        dest.writeByteArray(currentData);
        Bundle bundle = new Bundle();
        for (Map.Entry<Integer, byte[]> entry : temporaryData.entrySet()) {
            bundle.putByteArray(entry.getKey().toString(), entry.getValue());
        }
        dest.writeBundle(bundle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode = Objects.hashCode(uuid)
                ^ Integer.valueOf(permission).hashCode()
                ^ Integer.valueOf(responseCode).hashCode()
                ^ Long.valueOf(delay).hashCode()
                ^ Arrays.hashCode(data)
                ^ Arrays.hashCode(currentData);
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
        if (obj instanceof DescriptorData) {
            DescriptorData target = (DescriptorData) obj;
            result = Objects.equals(uuid, target.uuid)
                    && permission == target.permission
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData);
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
