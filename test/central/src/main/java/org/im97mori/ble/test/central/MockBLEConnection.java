package org.im97mori.ble.test.central;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.test.BLETestUtilsAndroid;

import java.util.UUID;

/** @noinspection unused*/
public class MockBLEConnection extends BLEConnection {

    protected Boolean mIsConnected;

    protected Integer mCreateDiscoverServiceTaskId;

    protected Integer mQuitTaskId;

    protected Integer mCreateReadCharacteristicTaskId;

    protected Integer mCreateWriteCharacteristicTaskId;

    protected Integer mCreateReadDescriptorTaskId;

    protected Integer mCreateWriteDescriptorTaskId;

    protected Integer mCreateSetNotifyTaskId;

    protected boolean mIsCreateDiscoverServiceTaskPassed;

    public MockBLEConnection() {
        super(ApplicationProvider.getApplicationContext(), BLETestUtilsAndroid.MOCK_DEVICE_0, null);
        this.start();
    }

    public void setConnected(@Nullable Boolean isConnected) {
        mIsConnected = isConnected;
    }

    public void setCreateDiscoverServiceTaskId(@Nullable Integer createDiscoverServiceTaskId) {
        mCreateDiscoverServiceTaskId = createDiscoverServiceTaskId;
    }

    public void setQuitTaskId(@Nullable Integer quitTaskId) {
        mQuitTaskId = quitTaskId;
    }

    public void setCreateReadCharacteristicTaskId(@Nullable Integer createReadCharacteristicTaskId) {
        mCreateReadCharacteristicTaskId = createReadCharacteristicTaskId;
    }

    public void setCreateWriteCharacteristicTaskId(@Nullable Integer createWriteCharacteristicTaskId) {
        mCreateWriteCharacteristicTaskId = createWriteCharacteristicTaskId;
    }

    public void setCreateReadDescriptorTaskId(@Nullable Integer createReadDescriptorTaskId) {
        mCreateReadDescriptorTaskId = createReadDescriptorTaskId;
    }

    public void setCreateWriteDescriptorTaskId(@Nullable Integer createWriteDescriptorTaskId) {
        mCreateWriteDescriptorTaskId = createWriteDescriptorTaskId;
    }

    public void setCreateSetNotifyTaskId(@Nullable Integer createSetNotifyTaskId) {
        mCreateSetNotifyTaskId = createSetNotifyTaskId;
    }

    @Override
    public synchronized Integer connect(boolean needMtuSetting, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        return 1;
    }

    @Nullable
    @Override
    public Integer createDiscoverServiceTask(long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer result;
        if (mCreateDiscoverServiceTaskId == null) {
            result = super.createDiscoverServiceTask(timeout, argument, bleCallback);
        } else {
            result = mCreateDiscoverServiceTaskId;
        }
        mIsCreateDiscoverServiceTaskPassed = true;
        return result;
    }

    public boolean isCreateDiscoverServiceTaskPassed() {
        return mIsCreateDiscoverServiceTaskPassed;
    }

    @Nullable
    @Override
    public Integer quit() {
        Integer result;
        if (mQuitTaskId == null) {
            result = super.quit();
        } else {
            result = mQuitTaskId;
        }
        return result;
    }

    @Override
    public boolean isConnected() {
        boolean result;
        if (mIsConnected == null) {
            result = super.isConnected();
        } else {
            result = mIsConnected;
        }
        return result;
    }

    @Nullable
    @Override
    public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer result;
        if (mCreateReadCharacteristicTaskId == null) {
            result = super.createReadCharacteristicTask(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument, bleCallback);
        } else {
            result = mCreateReadCharacteristicTaskId;
        }
        return result;
    }

    @Nullable
    @Override
    public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer result;
        if (mCreateWriteCharacteristicTaskId == null) {
            result = super.createWriteCharacteristicTask(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, byteArrayInterface, writeType, timeout, argument, bleCallback);
        } else {
            result = mCreateWriteCharacteristicTaskId;
        }
        return result;
    }

    @Nullable
    @Override
    public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer result;
        if (mCreateWriteDescriptorTaskId == null) {
            result = super.createWriteDescriptorTask(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, byteArrayInterface, timeout, argument, bleCallback);
        } else {
            result = mCreateWriteDescriptorTaskId;
        }
        return result;
    }

    @Nullable
    @Override
    public synchronized Integer createSetNotifyTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer result;
        if (mCreateSetNotifyTaskId == null) {
            result = super.createSetNotifyTask(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, notificationStatus, argument, bleCallback);
        } else {
            result = mCreateSetNotifyTaskId;
        }
        return result;
    }

    @Nullable
    @Override
    public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer result;
        if (mCreateReadDescriptorTaskId == null) {
            result = super.createReadDescriptorTask(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument, bleCallback);
        } else {
            result = mCreateReadDescriptorTaskId;
        }
        return result;
    }

    @SuppressLint("MissingPermission")
    public synchronized void quitTaskHandler() {
        if (mBluetoothGatt != null) {
            mBluetoothGatt.close();
            mBluetoothGatt = null;
        }
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;
        }
    }

}
