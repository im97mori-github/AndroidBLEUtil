package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.UUID;

/**
 * Descriptor data class
 */
@SuppressWarnings({"WeakerAccess", "unused"})
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
     * @param delay        responce delay(millis)
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
        temporaryData = in.createByteArray();
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
        dest.writeByteArray(temporaryData);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return uuid.hashCode()
                ^ Integer.valueOf(permission).hashCode()
                ^ Integer.valueOf(responseCode).hashCode()
                ^ Long.valueOf(delay).hashCode()
                ^ Arrays.hashCode(data)
                ^ Arrays.hashCode(currentData)
                ^ Arrays.hashCode(temporaryData);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof DescriptorData) {
            DescriptorData target = (DescriptorData) obj;
            result = uuid.equals(target.uuid)
                    && permission == target.permission
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData)
                    && Arrays.equals(temporaryData, target.temporaryData);
        }
        return result;
    }

}
