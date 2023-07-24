package org.im97mori.ble.service.ess.central;

import static org.im97mori.ble.constants.CharacteristicUUID.AMMONIA_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DEW_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ELEVATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.METHANE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.OZONE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.im97mori.ble.service.ess.EnvironmentSensingServiceConstants.ESS_UPPER_CASE_NAME_MAP;
import static org.im97mori.ble.service.ess.EnvironmentSensingServiceConstants.ESS_UUID_SET;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2a2c.MagneticDeclinationAndroid;
import org.im97mori.ble.characteristic.u2a6c.ElevationAndroid;
import org.im97mori.ble.characteristic.u2a6d.PressureAndroid;
import org.im97mori.ble.characteristic.u2a6e.TemperatureAndroid;
import org.im97mori.ble.characteristic.u2a6f.HumidityAndroid;
import org.im97mori.ble.characteristic.u2a70.TrueWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a71.TrueWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a72.ApparentWindSpeedAndroid;
import org.im97mori.ble.characteristic.u2a73.ApparentWindDirectionAndroid;
import org.im97mori.ble.characteristic.u2a74.GustFactorAndroid;
import org.im97mori.ble.characteristic.u2a75.PollenConcentrationAndroid;
import org.im97mori.ble.characteristic.u2a76.UVIndexAndroid;
import org.im97mori.ble.characteristic.u2a77.IrradianceAndroid;
import org.im97mori.ble.characteristic.u2a78.RainfallAndroid;
import org.im97mori.ble.characteristic.u2a79.WindChillAndroid;
import org.im97mori.ble.characteristic.u2a7a.HeatIndexAndroid;
import org.im97mori.ble.characteristic.u2a7b.DewPointAndroid;
import org.im97mori.ble.characteristic.u2a7d.DescriptorValueChangedAndroid;
import org.im97mori.ble.characteristic.u2aa0.MagneticFluxDensity2DAndroid;
import org.im97mori.ble.characteristic.u2aa1.MagneticFluxDensity3DAndroid;
import org.im97mori.ble.characteristic.u2aa3.BarometricPressureTrendAndroid;
import org.im97mori.ble.characteristic.u2bcf.AmmoniaConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd0.CarbonMonoxideConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd1.MethaneConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd2.NitrogenDioxideConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd3.NonMethaneVolatileOrganicCompoundsConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd4.OzoneConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd5.ParticulateMatterPm1ConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd6.ParticulateMatterPm25ConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd7.ParticulateMatterPm10ConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd8.SulfurDioxideConcentrationAndroid;
import org.im97mori.ble.characteristic.u2bd9.SulfurHexafluorideConcentrationAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfigurationAndroid;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurementAndroid;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSettingAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Environmental Sensing Service (Service UUID: 0x181A) for Central
 */
public class EnvironmentalSensingService extends AbstractCentralService {

    /**
     * {@link EnvironmentalSensingServiceCallback} instance
     */
    private final EnvironmentalSensingServiceCallback mEnvironmentalSensingServiceCallback;

    /**
     * Descriptor Value Changed characteristic flag
     * {@code true}:Descriptor Value Changed characteristic is exist, {@code false}:Descriptor Value Changed characteristic is not exist or service not ready
     */
    private boolean mIsDescriptorValueChangedCharacteristicSupported;

    /**
     * ESS Characteristic reflection data
     */
    private static class EssData {

        /**
         * available {@link BluetoothGattCharacteristic} instance list
         */
        final List<BluetoothGattCharacteristic> mBluetoothGattCharacteristicList = new LinkedList<>();

        /**
         * available {@link BluetoothGattDescriptor} instance map
         */
        final Map<Integer, List<BluetoothGattDescriptor>> mEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

        /**
         * ESS Characteristic data class
         */
        Class<? extends Parcelable> mClazz;

        /**
         * ESS Characteristic upper camel case name
         *
         * @see org.im97mori.ble.service.ess.EnvironmentSensingServiceConstants#ESS_UPPER_CASE_NAME_MAP
         */
        String mUpperCamelCaseName;

        /**
         * ESS Characteristic data class's {@link ByteArrayCreator}
         */
        ByteArrayCreator<?> mCreator;
    }

    private final Map<UUID, EssData> mEssDataMap = new HashMap<>();

    /**
     * @param bleConnection                       {@link BLEConnection} instance
     * @param environmentalSensingServiceCallback {@link EnvironmentalSensingServiceCallback} instance
     * @param bleCallback                         {@link BLECallback} instance (optional)
     */
    public EnvironmentalSensingService(@NonNull BLEConnection bleConnection, @NonNull EnvironmentalSensingServiceCallback environmentalSensingServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mEnvironmentalSensingServiceCallback = environmentalSensingServiceCallback;
        for (UUID uuid : ESS_UUID_SET) {
            String upperCase = ESS_UPPER_CASE_NAME_MAP.get(uuid);
            EssData essData = new EssData();
            essData.mUpperCamelCaseName = upperCase;
            try {
                //noinspection unchecked
                essData.mClazz = (Class<? extends Parcelable>) Class.forName(String.format("org.im97mori.ble.characteristic.u%1$04x.%2$sAndroid", BLEUtils.convert128to16(uuid), upperCase));
                essData.mCreator = (ByteArrayCreator<?>) essData.mClazz.getDeclaredField("CREATOR").get(null);
            } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            mEssDataMap.put(uuid, essData);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsDescriptorValueChangedCharacteristicSupported = false;
            for (EssData essData : mEssDataMap.values()) {
                essData.mBluetoothGattCharacteristicList.clear();
                essData.mEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            }
        }
        super.onBLEDisconnected(taskId, bluetoothDevice, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (ENVIRONMENTAL_SENSING_SERVICE.equals(bluetoothGattService.getUuid())) {
                    BluetoothGattCharacteristic descriptorValueChangedBluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC);
                    if (descriptorValueChangedBluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_INDICATE == descriptorValueChangedBluetoothGattCharacteristic.getProperties()
                            && descriptorValueChangedBluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsDescriptorValueChangedCharacteristicSupported = true;
                    }
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        EssData essData = mEssDataMap.get(bluetoothGattCharacteristic.getUuid());
                        if (essData != null) {
                            if ((BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                                essData.mBluetoothGattCharacteristicList.add(bluetoothGattCharacteristic);
                                int index = essData.mBluetoothGattCharacteristicList.indexOf(bluetoothGattCharacteristic);
                                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                                if (descriptorList == null) {
                                    descriptorList = new ArrayList<>();
                                    essData.mEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                                }
                                for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                    if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                        descriptorList.add(bluetoothGattDescriptor);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * get characteristic index
     *
     * @param bluetoothGattCharacteristicList characteristic list
     * @param characteristicInstanceId        task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @return characteristic index
     */
    @Nullable
    private Integer getCharacteristicIndex(@NonNull List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList, @Nullable Integer characteristicInstanceId) {
        Integer index = null;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        for (int i = 0; i < bluetoothGattCharacteristicList.size(); i++) {
            bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(i);
            if (characteristicInstanceId != null && characteristicInstanceId == bluetoothGattCharacteristic.getInstanceId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                try {
                    Class<EnvironmentalSensingServiceCallback> clazz = EnvironmentalSensingServiceCallback.class;
                    Method method = clazz.getDeclaredMethod(String.format("on%1$sReadSuccess", essData.mUpperCamelCaseName)
                            , Integer.class
                            , BluetoothDevice.class
                            , UUID.class
                            , Integer.class
                            , UUID.class
                            , Integer.class
                            , Integer.class
                            , essData.mClazz
                            , Bundle.class);
                    //noinspection JavaReflectionInvocation
                    method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId), essData.mCreator.createFromByteArray(values), argument);
                } catch (NoSuchMethodException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                try {
                    Class<EnvironmentalSensingServiceCallback> clazz = EnvironmentalSensingServiceCallback.class;
                    Method method = clazz.getDeclaredMethod(String.format("on%1$sReadFailed", essData.mUpperCamelCaseName)
                            , Integer.class
                            , BluetoothDevice.class
                            , UUID.class
                            , Integer.class
                            , UUID.class
                            , Integer.class
                            , Integer.class
                            , int.class
                            , Bundle.class);
                    method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId), status, argument);
                } catch (NoSuchMethodException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                try {
                    Class<EnvironmentalSensingServiceCallback> clazz = EnvironmentalSensingServiceCallback.class;
                    Method method = clazz.getDeclaredMethod(String.format("on%1$sReadTimeout", essData.mUpperCamelCaseName)
                            , Integer.class
                            , BluetoothDevice.class
                            , UUID.class
                            , Integer.class
                            , UUID.class
                            , Integer.class
                            , Integer.class
                            , long.class
                            , Bundle.class);
                    method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId), timeout, argument);
                } catch (NoSuchMethodException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * get descriptor index
     *
     * @param bluetoothGattDescriptorList descriptor list
     * @param descriptorInstanceId        task target descriptor instance id
     */
    @Nullable
    private Integer getDescriptorIndex(@Nullable List<BluetoothGattDescriptor> bluetoothGattDescriptorList, @Nullable Integer descriptorInstanceId) {
        Integer index = null;
        if (bluetoothGattDescriptorList != null) {
            BluetoothGattDescriptor bluetoothGattDescriptor;
            for (int i = 0; i < bluetoothGattDescriptorList.size(); i++) {
                bluetoothGattDescriptor = bluetoothGattDescriptorList.get(i);
                if (descriptorInstanceId != null && descriptorInstanceId == BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            if (DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDescriptorValueChangedClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                }
            }
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                Integer characteristicIndex = getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingMeasurementReadSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , EnvironmentalSensingMeasurementAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingTriggerSettingReadSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , EnvironmentalSensingTriggerSettingAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingConfigurationReadSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , EnvironmentalSensingConfigurationAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sCharacteristicUserDescriptionReadSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , CharacteristicUserDescriptionAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sValidRangeReadSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , ValidRangeAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | IllegalAccessException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            if (DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDescriptorValueChangedClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            }

            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                Integer characteristicIndex = getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingMeasurementReadFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingTriggerSettingReadFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingConfigurationReadFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sCharacteristicUserDescriptionReadFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sValidRangeReadFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            if (DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDescriptorValueChangedClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            }
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                Integer characteristicIndex = getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingMeasurementReadTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingTriggerSettingReadTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingConfigurationReadTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sCharacteristicUserDescriptionReadTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sValidRangeReadTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            if (DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                        mEnvironmentalSensingServiceCallback.onDescriptorValueChangedIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                    } else {
                        mEnvironmentalSensingServiceCallback.onDescriptorValueChangedIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                    }
                }
            }
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                Integer characteristicIndex = getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingTriggerSettingWriteSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , EnvironmentalSensingTriggerSettingAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingConfigurationWriteSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , EnvironmentalSensingConfigurationAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sCharacteristicUserDescriptionWriteSuccess", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , CharacteristicUserDescriptionAndroid.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            if (DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                        mEnvironmentalSensingServiceCallback.onDescriptorValueChangedIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                    } else {
                        mEnvironmentalSensingServiceCallback.onDescriptorValueChangedIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                    }
                }
            }
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                Integer characteristicIndex = getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingTriggerSettingWriteFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingConfigurationWriteFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sCharacteristicUserDescriptionWriteFailed", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , int.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            if (DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                    if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                        mEnvironmentalSensingServiceCallback.onDescriptorValueChangedIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                    } else {
                        mEnvironmentalSensingServiceCallback.onDescriptorValueChangedIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                    }
                }
            }
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                Integer characteristicIndex = getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingTriggerSettingWriteTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sEnvironmentalSensingConfigurationWriteTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    try {
                        Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sCharacteristicUserDescriptionWriteTimeout", essData.mUpperCamelCaseName)
                                , Integer.class
                                , BluetoothDevice.class
                                , UUID.class
                                , Integer.class
                                , UUID.class
                                , Integer.class
                                , Integer.class
                                , Integer.class
                                , long.class
                                , Bundle.class);
                        method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                    } catch (NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            if (DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onDescriptorValueChangedIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DescriptorValueChangedAndroid.CREATOR.createFromByteArray(values));
            }
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                try {
                    Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sNotified", essData.mUpperCamelCaseName)
                            , BluetoothDevice.class
                            , UUID.class
                            , Integer.class
                            , UUID.class
                            , Integer.class
                            , Integer.class
                            , essData.mClazz);
                    //noinspection JavaReflectionInvocation
                    method.invoke(mEnvironmentalSensingServiceCallback, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId), essData.mCreator.createFromByteArray(values));
                } catch (NoSuchMethodException | InvocationTargetException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                String suffix;
                if (notificationStatus) {
                    suffix = "Start";
                } else {
                    suffix = "Stop";
                }
                try {
                    Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sNotify%2$sSuccess", essData.mUpperCamelCaseName, suffix)
                            , Integer.class
                            , BluetoothDevice.class
                            , UUID.class
                            , Integer.class
                            , UUID.class
                            , Integer.class
                            , Integer.class
                            , Bundle.class);
                    method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId), argument);
                } catch (NoSuchMethodException | InvocationTargetException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        super.onSetNotificationSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, notificationStatus, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && ENVIRONMENTAL_SENSING_SERVICE.equals(serviceUUID)) {
            EssData essData = mEssDataMap.get(characteristicUUID);
            if (essData != null) {
                String suffix;
                if (notificationStatus) {
                    suffix = "Start";
                } else {
                    suffix = "Stop";
                }
                try {
                    Method method = EnvironmentalSensingServiceCallback.class.getDeclaredMethod(String.format("on%1$sNotify%2$sFailed", essData.mUpperCamelCaseName, suffix)
                            , Integer.class
                            , BluetoothDevice.class
                            , UUID.class
                            , Integer.class
                            , UUID.class
                            , Integer.class
                            , Integer.class
                            , int.class
                            , Bundle.class);
                    method.invoke(mEnvironmentalSensingServiceCallback, taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(essData.mBluetoothGattCharacteristicList, characteristicInstanceId), status, argument);
                } catch (NoSuchMethodException | InvocationTargetException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        super.onSetNotificationFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, notificationStatus, status, argument);
    }

    /**
     * check Descriptor Value Changed characteristic
     * <p>
     * {@code true}:Descriptor Value Changed characteristic is exist, {@code false}:Descriptor Value Changed characteristic is not exist or service not ready
     */
    public boolean isDescriptorValueChangedCharacteristicSupported() {
        return mIsDescriptorValueChangedCharacteristicSupported;
    }

    /**
     * get Descriptor
     *
     * @param characteristicList {@link EssData#mBluetoothGattCharacteristicList}
     * @param descriptorUUID     descriptor's {@link UUID}
     * @param index              characteristic index
     * @return target characteristic's {@link BluetoothGattDescriptor} instance or {@code null} when target characteristic do not have specific descriptor
     */
    @Nullable
    private synchronized BluetoothGattDescriptor getDescriptor(@NonNull List<BluetoothGattCharacteristic> characteristicList, @NonNull UUID descriptorUUID, int index) {
        BluetoothGattDescriptor bluetoothGattDescriptor = null;
        if (isStarted() && index >= 0 && index < characteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristicList.get(index);
            bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(descriptorUUID);
        }
        return bluetoothGattDescriptor;
    }

    /**
     * get Environmental Sensing Characteristic's ES Measurement
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer getEnvironmentalSensingEnvironmentalSensingMeasurement(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList) {
        return getEnvironmentalSensingDescriptor(index, characteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
    }

    /**
     * get Environmental Sensing Characteristic's ES Trigger Setting
     *
     * @param characteristicIndex characteristic index
     * @param descriptorIndex     descriptor index
     * @param descriptorMap       target descriptor map
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer getEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull Map<Integer, List<BluetoothGattDescriptor>> descriptorMap) {
        Integer taskId = null;
        if (isStarted()) {
            List<BluetoothGattDescriptor> descriptorList = descriptorMap.get(characteristicIndex);
            if (descriptorList != null && descriptorIndex >= 0 && descriptorIndex < descriptorList.size()) {
                BluetoothGattDescriptor bluetoothGattDescriptor = descriptorList.get(descriptorIndex);
                BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattDescriptor.getCharacteristic();
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                taskId = mBLEConnection.createReadDescriptorTask(ENVIRONMENTAL_SENSING_SERVICE
                        , bluetoothGattService.getInstanceId()
                        , bluetoothGattCharacteristic.getUuid()
                        , bluetoothGattCharacteristic.getInstanceId()
                        , bluetoothGattDescriptor.getUuid()
                        , BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor)
                        , ReadDescriptorTask.TIMEOUT_MILLIS
                        , null
                        , this);
            }
        }
        return taskId;
    }

    /**
     * get Environmental Sensing Characteristic's Valid Range
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer getEnvironmentalSensingValidRange(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList) {
        return getEnvironmentalSensingDescriptor(index, characteristicList, VALID_RANGE_DESCRIPTOR);
    }

    /**
     * get Environmental Sensing Characteristic
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    @Nullable
    private synchronized Integer getEnvironmentalSensingCharacteristic(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < characteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristicList.get(index);
            if (bluetoothGattCharacteristic != null) {
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                if (bluetoothGattService != null) {
                    taskId = mBLEConnection.createReadCharacteristicTask(ENVIRONMENTAL_SENSING_SERVICE
                            , bluetoothGattService.getInstanceId()
                            , bluetoothGattCharacteristic.getUuid()
                            , bluetoothGattCharacteristic.getInstanceId()
                            , ReadCharacteristicTask.TIMEOUT_MILLIS
                            , null
                            , this);
                }
            }
        }
        return taskId;
    }

    /**
     * get Environmental Sensing Characteristic's Characteristic User Description
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer getEnvironmentalSensingCharacteristicUserDescription(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList) {
        return getEnvironmentalSensingDescriptor(index, characteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
    }

    /**
     * get Environmental Sensing Characteristic's ES Configuration
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer getEnvironmentalSensingEnvironmentalSensingConfiguration(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList) {
        return getEnvironmentalSensingDescriptor(index, characteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR);
    }

    /**
     * get Environmental Sensing Characteristic's descriptor
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @param descriptorUUID     target descriptor's {@link UUID} instance
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer getEnvironmentalSensingDescriptor(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList, @NonNull UUID descriptorUUID) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < characteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristicList.get(index);
            if (bluetoothGattCharacteristic != null) {
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                if (bluetoothGattService != null) {
                    BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(descriptorUUID);
                    if (bluetoothGattDescriptor != null) {
                        taskId = mBLEConnection.createReadDescriptorTask(ENVIRONMENTAL_SENSING_SERVICE
                                , bluetoothGattService.getInstanceId()
                                , bluetoothGattCharacteristic.getUuid()
                                , bluetoothGattCharacteristic.getInstanceId()
                                , bluetoothGattDescriptor.getUuid()
                                , BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor)
                                , ReadDescriptorTask.TIMEOUT_MILLIS
                                , null
                                , this);
                    }
                }
            }
        }
        return taskId;
    }

    /**
     * set Environmental Sensing Characteristic's descriptor
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @param descriptorUUID     target descriptor's {@link UUID} instance
     * @param byteArrayInterface {@link ByteArrayInterface} instance
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer setEnvironmentalSensingDescriptor(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < characteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristicList.get(index);
            if (bluetoothGattCharacteristic != null) {
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                if (bluetoothGattService != null) {
                    BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(descriptorUUID);
                    if (bluetoothGattDescriptor != null) {
                        taskId = mBLEConnection.createWriteDescriptorTask(ENVIRONMENTAL_SENSING_SERVICE
                                , bluetoothGattService.getInstanceId()
                                , bluetoothGattCharacteristic.getUuid()
                                , bluetoothGattCharacteristic.getInstanceId()
                                , bluetoothGattDescriptor.getUuid()
                                , BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor)
                                , byteArrayInterface
                                , WriteDescriptorTask.TIMEOUT_MILLIS
                                , null
                                , this);
                    }
                }
            }
        }
        return taskId;
    }

    /**
     * start Environmental Sensing Characteristic notification
     *
     * @param index              characteristic index
     * @param characteristicList target characteristic list
     * @param notificationStatus {@code true}:start notification, {@code false}:stop notification
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer setEnvironmentalSensingCharacteristicNotification(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList, boolean notificationStatus) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < characteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristicList.get(index);
            if (bluetoothGattCharacteristic != null) {
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                if (bluetoothGattService != null) {
                    taskId = mBLEConnection.createSetNotifyTask(ENVIRONMENTAL_SENSING_SERVICE
                            , bluetoothGattService.getInstanceId()
                            , bluetoothGattCharacteristic.getUuid()
                            , bluetoothGattCharacteristic.getInstanceId()
                            , notificationStatus
                            , null
                            , this);
                }
            }
        }
        return taskId;
    }

    /**
     * set Environmental Sensing Characteristic's ES Trigger Setting
     *
     * @param characteristicIndex                characteristic index
     * @param descriptorIndex                    descriptor index
     * @param descriptorMap                      target descriptor map
     * @param environmentalSensingTriggerSetting {@link EnvironmentalSensingTriggerSetting} instance
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer setEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull Map<Integer, List<BluetoothGattDescriptor>> descriptorMap, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (isStarted()) {
            List<BluetoothGattDescriptor> descriptorList = descriptorMap.get(characteristicIndex);
            if (descriptorList != null && descriptorIndex >= 0 && descriptorIndex < descriptorList.size()) {
                BluetoothGattDescriptor bluetoothGattDescriptor = descriptorList.get(descriptorIndex);
                BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattDescriptor.getCharacteristic();
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                taskId = mBLEConnection.createWriteDescriptorTask(ENVIRONMENTAL_SENSING_SERVICE
                        , bluetoothGattService.getInstanceId()
                        , bluetoothGattCharacteristic.getUuid()
                        , bluetoothGattCharacteristic.getInstanceId()
                        , bluetoothGattDescriptor.getUuid()
                        , BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor)
                        , environmentalSensingTriggerSetting
                        , ReadDescriptorTask.TIMEOUT_MILLIS
                        , null
                        , this);
            }
        }
        return taskId;
    }

    /**
     * set Environmental Sensing Characteristic's ES Configuration
     *
     * @param index                             characteristic index
     * @param characteristicList                target characteristic list
     * @param environmentalSensingConfiguration {@link EnvironmentalSensingConfiguration} instance
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer setEnvironmentalSensingEnvironmentalSensingConfiguration(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setEnvironmentalSensingDescriptor(index, characteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, environmentalSensingConfiguration);
    }

    /**
     * set Environmental Sensing Characteristic's Characteristic User Description
     *
     * @param index                         characteristic index
     * @param characteristicList            target characteristic list
     * @param characteristicUserDescription {@link CharacteristicUserDescription} instance
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     */
    private synchronized Integer setEnvironmentalSensingCharacteristicUserDescription(int index, @NonNull List<BluetoothGattCharacteristic> characteristicList, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setEnvironmentalSensingDescriptor(index, characteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, characteristicUserDescription);
    }

    /**
     * get Descriptor Value Changed's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDescriptorValueChangedClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(ENVIRONMENTAL_SENSING_SERVICE, null, DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Descriptor Value Changed indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startDescriptorValueChangedIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(ENVIRONMENTAL_SENSING_SERVICE, null, DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Descriptor Value Changed indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDescriptorValueChangedIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopDescriptorValueChangedIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(ENVIRONMENTAL_SENSING_SERVICE, null, DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentration(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentration() {
        return getAmmoniaConcentration(0);
    }

    /**
     * get Ammonia Concentration
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, AmmoniaConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Ammonia Concentration characteristic's ES Trigger Setting count
     *
     * @param index Ammonia Concentration characteristic index
     * @return Ammonia Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getAmmoniaConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCharacteristicUserDescription() {
        return getAmmoniaConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Ammonia Concentration's Characteristic User Description
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Ammonia Concentration characteristic count
     *
     * @return available Ammonia Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getAmmoniaConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingConfiguration() {
        return getAmmoniaConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Ammonia Concentration's ES Configuration
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingMeasurement() {
        return getAmmoniaConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Ammonia Concentration's ES Measurement
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingTriggerSetting() {
        return getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Ammonia Concentration's Trigger Setting
     *
     * @param characteristicIndex Ammonia Concentration characteristic index
     * @param descriptorIndex     Ammonia Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationValidRange() {
        return getAmmoniaConcentrationValidRange(0);
    }

    /**
     * get Ammonia Concentration's Valid Range
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canAmmoniaConcentrationNotify(int)
     */
    public synchronized boolean canAmmoniaConcentrationNotify() {
        return canAmmoniaConcentrationNotify(0);
    }

    /**
     * get Ammonia Concentration characteristic's notify status
     *
     * @param index Ammonia Concentration characteristic index
     * @return {@code true}:target  Ammonia Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canAmmoniaConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Ammonia Concentration characteristic's ES Measurement
     *
     * @param index Ammonia Concentration characteristic index
     * @return {@code true}:target Ammonia Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Ammonia Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Ammonia Concentration characteristic's ES Configuration
     *
     * @param index Ammonia Concentration characteristic index
     * @return {@code true}:target Ammonia Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Ammonia Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription() {
        return hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Ammonia Concentration characteristic's Characteristic User Description
     *
     * @param index Ammonia Concentration characteristic index
     * @return {@code true}:target Ammonia Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Ammonia Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicValidRange() {
        return hasAmmoniaConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Ammonia Concentration characteristic's Valid Range
     *
     * @param index Ammonia Concentration characteristic index
     * @return {@code true}:target Ammonia Concentration Characteristic has Valid Range Descriptor, {@code false}:target Ammonia Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasAmmoniaConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startAmmoniaConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startAmmoniaConcentrationNotification() {
        return startAmmoniaConcentrationNotification(0);
    }

    /**
     * start Ammonia Concentration notification
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startAmmoniaConcentrationNotification(int index) {
        Integer taskId = null;
        if (canAmmoniaConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopAmmoniaConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopAmmoniaConcentrationNotification() {
        return stopAmmoniaConcentrationNotification(0);
    }

    /**
     * stop Ammonia Concentration notification
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopAmmoniaConcentrationNotification(int index) {
        Integer taskId = null;
        if (canAmmoniaConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Ammonia Concentration's Trigger Setting
     *
     * @param characteristicIndex Ammonia Concentration characteristic index
     * @param descriptorIndex     Ammonia Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setAmmoniaConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setAmmoniaConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Ammonia Concentration's ES Configuration
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setAmmoniaConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setAmmoniaConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Ammonia Concentration's Characteristic User Description
     *
     * @param index Ammonia Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onAmmoniaConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirection(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirection() {
        return getApparentWindDirection(0);
    }

    /**
     * get Apparent Wind Direction
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ApparentWindDirectionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindDirection(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Apparent Wind Direction characteristic's ES Trigger Setting count
     *
     * @param index Apparent Wind Direction characteristic index
     * @return Apparent Wind Direction characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getApparentWindDirectionCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCharacteristicUserDescription() {
        return getApparentWindDirectionCharacteristicUserDescription(0);
    }

    /**
     * get Apparent Wind Direction's Characteristic User Description
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Apparent Wind Direction characteristic count
     *
     * @return available Apparent Wind Direction characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getApparentWindDirectionEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingConfiguration() {
        return getApparentWindDirectionEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Apparent Wind Direction's ES Configuration
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingMeasurement() {
        return getApparentWindDirectionEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Apparent Wind Direction's ES Measurement
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingTriggerSetting() {
        return getApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Apparent Wind Direction's Trigger Setting
     *
     * @param characteristicIndex Apparent Wind Direction characteristic index
     * @param descriptorIndex     Apparent Wind Direction characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionValidRange(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionValidRange() {
        return getApparentWindDirectionValidRange(0);
    }

    /**
     * get Apparent Wind Direction's Valid Range
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canApparentWindDirectionNotify(int)
     */
    public synchronized boolean canApparentWindDirectionNotify() {
        return canApparentWindDirectionNotify(0);
    }

    /**
     * get Apparent Wind Direction characteristic's notify status
     *
     * @param index Apparent Wind Direction characteristic index
     * @return {@code true}:target  Apparent Wind Direction characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canApparentWindDirectionNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement() {
        return hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Apparent Wind Direction characteristic's ES Measurement
     *
     * @param index Apparent Wind Direction characteristic index
     * @return {@code true}:target Apparent Wind Direction Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Apparent Wind Direction Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration() {
        return hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Apparent Wind Direction characteristic's ES Configuration
     *
     * @param index Apparent Wind Direction characteristic index
     * @return {@code true}:target Apparent Wind Direction Characteristic has ES Configuration Descriptor, {@code false}:target Apparent Wind Direction Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicCharacteristicUserDescription() {
        return hasApparentWindDirectionCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Apparent Wind Direction characteristic's Characteristic User Description
     *
     * @param index Apparent Wind Direction characteristic index
     * @return {@code true}:target Apparent Wind Direction Characteristic has Characteristic User Description Descriptor, {@code false}:target Apparent Wind Direction Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicValidRange(int)
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicValidRange() {
        return hasApparentWindDirectionCharacteristicValidRange(0);
    }

    /**
     * check Apparent Wind Direction characteristic's Valid Range
     *
     * @param index Apparent Wind Direction characteristic index
     * @return {@code true}:target Apparent Wind Direction Characteristic has Valid Range Descriptor, {@code false}:target Apparent Wind Direction Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasApparentWindDirectionCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startApparentWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer startApparentWindDirectionNotification() {
        return startApparentWindDirectionNotification(0);
    }

    /**
     * start Apparent Wind Direction notification
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startApparentWindDirectionNotification(int index) {
        Integer taskId = null;
        if (canApparentWindDirectionNotify(index)) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopApparentWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer stopApparentWindDirectionNotification() {
        return stopApparentWindDirectionNotification(0);
    }

    /**
     * stop Apparent Wind Direction notification
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopApparentWindDirectionNotification(int index) {
        Integer taskId = null;
        if (canApparentWindDirectionNotify(index)) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setApparentWindDirectionEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Apparent Wind Direction's Trigger Setting
     *
     * @param characteristicIndex Apparent Wind Direction characteristic index
     * @param descriptorIndex     Apparent Wind Direction characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindDirectionEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setApparentWindDirectionEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Apparent Wind Direction's ES Configuration
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindDirectionCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setApparentWindDirectionCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Apparent Wind Direction's Characteristic User Description
     *
     * @param index Apparent Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindDirectionCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeed(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeed() {
        return getApparentWindSpeed(0);
    }

    /**
     * get Apparent Wind Speed
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ApparentWindSpeedAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeed(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Apparent Wind Speed characteristic's ES Trigger Setting count
     *
     * @param index Apparent Wind Speed characteristic index
     * @return Apparent Wind Speed characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getApparentWindSpeedCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCharacteristicUserDescription() {
        return getApparentWindSpeedCharacteristicUserDescription(0);
    }

    /**
     * get Apparent Wind Speed's Characteristic User Description
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Apparent Wind Speed characteristic count
     *
     * @return available Apparent Wind Speed characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getApparentWindSpeedEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingConfiguration() {
        return getApparentWindSpeedEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Apparent Wind Speed's ES Configuration
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingMeasurement() {
        return getApparentWindSpeedEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Apparent Wind Speed's ES Measurement
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingTriggerSetting() {
        return getApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Apparent Wind Speed's Trigger Setting
     *
     * @param characteristicIndex Apparent Wind Speed characteristic index
     * @param descriptorIndex     Apparent Wind Speed characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedValidRange(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedValidRange() {
        return getApparentWindSpeedValidRange(0);
    }

    /**
     * get Apparent Wind Speed's Valid Range
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canApparentWindSpeedNotify(int)
     */
    public synchronized boolean canApparentWindSpeedNotify() {
        return canApparentWindSpeedNotify(0);
    }

    /**
     * get Apparent Wind Speed characteristic's notify status
     *
     * @param index Apparent Wind Speed characteristic index
     * @return {@code true}:target  Apparent Wind Speed characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canApparentWindSpeedNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement() {
        return hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Apparent Wind Speed characteristic's ES Measurement
     *
     * @param index Apparent Wind Speed characteristic index
     * @return {@code true}:target Apparent Wind Speed Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Apparent Wind Speed Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration() {
        return hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Apparent Wind Speed characteristic's ES Configuration
     *
     * @param index Apparent Wind Speed characteristic index
     * @return {@code true}:target Apparent Wind Speed Characteristic has ES Configuration Descriptor, {@code false}:target Apparent Wind Speed Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicCharacteristicUserDescription() {
        return hasApparentWindSpeedCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Apparent Wind Speed characteristic's Characteristic User Description
     *
     * @param index Apparent Wind Speed characteristic index
     * @return {@code true}:target Apparent Wind Speed Characteristic has Characteristic User Description Descriptor, {@code false}:target Apparent Wind Speed Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicValidRange(int)
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicValidRange() {
        return hasApparentWindSpeedCharacteristicValidRange(0);
    }

    /**
     * check Apparent Wind Speed characteristic's Valid Range
     *
     * @param index Apparent Wind Speed characteristic index
     * @return {@code true}:target Apparent Wind Speed Characteristic has Valid Range Descriptor, {@code false}:target Apparent Wind Speed Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasApparentWindSpeedCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startApparentWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer startApparentWindSpeedNotification() {
        return startApparentWindSpeedNotification(0);
    }

    /**
     * start Apparent Wind Speed notification
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startApparentWindSpeedNotification(int index) {
        Integer taskId = null;
        if (canApparentWindSpeedNotify(index)) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopApparentWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer stopApparentWindSpeedNotification() {
        return stopApparentWindSpeedNotification(0);
    }

    /**
     * stop Apparent Wind Speed notification
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopApparentWindSpeedNotification(int index) {
        Integer taskId = null;
        if (canApparentWindSpeedNotify(index)) {
            EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setApparentWindSpeedEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Apparent Wind Speed's Trigger Setting
     *
     * @param characteristicIndex Apparent Wind Speed characteristic index
     * @param descriptorIndex     Apparent Wind Speed characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindSpeedEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setApparentWindSpeedEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Apparent Wind Speed's ES Configuration
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindSpeedCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setApparentWindSpeedCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Apparent Wind Speed's Characteristic User Description
     *
     * @param index Apparent Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onApparentWindSpeedCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrend(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrend() {
        return getBarometricPressureTrend(0);
    }

    /**
     * get Barometric Pressure Trend
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, BarometricPressureTrendAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrend(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Barometric Pressure Trend characteristic's ES Trigger Setting count
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return Barometric Pressure Trend characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getBarometricPressureTrendCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCharacteristicUserDescription() {
        return getBarometricPressureTrendCharacteristicUserDescription(0);
    }

    /**
     * get Barometric Pressure Trend's Characteristic User Description
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Barometric Pressure Trend characteristic count
     *
     * @return available Barometric Pressure Trend characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getBarometricPressureTrendEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingConfiguration() {
        return getBarometricPressureTrendEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Barometric Pressure Trend's ES Configuration
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingMeasurement() {
        return getBarometricPressureTrendEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Barometric Pressure Trend's ES Measurement
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingTriggerSetting() {
        return getBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Barometric Pressure Trend's Trigger Setting
     *
     * @param characteristicIndex Barometric Pressure Trend characteristic index
     * @param descriptorIndex     Barometric Pressure Trend characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendValidRange(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendValidRange() {
        return getBarometricPressureTrendValidRange(0);
    }

    /**
     * get Barometric Pressure Trend's Valid Range
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canBarometricPressureTrendNotify(int)
     */
    public synchronized boolean canBarometricPressureTrendNotify() {
        return canBarometricPressureTrendNotify(0);
    }

    /**
     * get Barometric Pressure Trend characteristic's notify status
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return {@code true}:target  Barometric Pressure Trend characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canBarometricPressureTrendNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement() {
        return hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Barometric Pressure Trend characteristic's ES Measurement
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return {@code true}:target Barometric Pressure Trend Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Barometric Pressure Trend Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration() {
        return hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Barometric Pressure Trend characteristic's ES Configuration
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return {@code true}:target Barometric Pressure Trend Characteristic has ES Configuration Descriptor, {@code false}:target Barometric Pressure Trend Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicCharacteristicUserDescription() {
        return hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Barometric Pressure Trend characteristic's Characteristic User Description
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return {@code true}:target Barometric Pressure Trend Characteristic has Characteristic User Description Descriptor, {@code false}:target Barometric Pressure Trend Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicValidRange(int)
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicValidRange() {
        return hasBarometricPressureTrendCharacteristicValidRange(0);
    }

    /**
     * check Barometric Pressure Trend characteristic's Valid Range
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return {@code true}:target Barometric Pressure Trend Characteristic has Valid Range Descriptor, {@code false}:target Barometric Pressure Trend Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasBarometricPressureTrendCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startBarometricPressureTrendNotification(int)
     */
    @Nullable
    public synchronized Integer startBarometricPressureTrendNotification() {
        return startBarometricPressureTrendNotification(0);
    }

    /**
     * start Barometric Pressure Trend notification
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startBarometricPressureTrendNotification(int index) {
        Integer taskId = null;
        if (canBarometricPressureTrendNotify(index)) {
            EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopBarometricPressureTrendNotification(int)
     */
    @Nullable
    public synchronized Integer stopBarometricPressureTrendNotification() {
        return stopBarometricPressureTrendNotification(0);
    }

    /**
     * stop Barometric Pressure Trend notification
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopBarometricPressureTrendNotification(int index) {
        Integer taskId = null;
        if (canBarometricPressureTrendNotify(index)) {
            EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setBarometricPressureTrendEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Barometric Pressure Trend's Trigger Setting
     *
     * @param characteristicIndex Barometric Pressure Trend characteristic index
     * @param descriptorIndex     Barometric Pressure Trend characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setBarometricPressureTrendEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setBarometricPressureTrendEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Barometric Pressure Trend's ES Configuration
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setBarometricPressureTrendCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setBarometricPressureTrendCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Barometric Pressure Trend's Characteristic User Description
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onBarometricPressureTrendCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentration() {
        return getCarbonMonoxideConcentration(0);
    }

    /**
     * get Carbon Monoxide Concentration
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CarbonMonoxideConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Carbon Monoxide Concentration characteristic's ES Trigger Setting count
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return Carbon Monoxide Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getCarbonMonoxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicUserDescription() {
        return getCarbonMonoxideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Carbon Monoxide Concentration's Characteristic User Description
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Carbon Monoxide Concentration characteristic count
     *
     * @return available Carbon Monoxide Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration() {
        return getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Carbon Monoxide Concentration's ES Configuration
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement() {
        return getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Carbon Monoxide Concentration's ES Measurement
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting() {
        return getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Carbon Monoxide Concentration's Trigger Setting
     *
     * @param characteristicIndex Carbon Monoxide Concentration characteristic index
     * @param descriptorIndex     Carbon Monoxide Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationValidRange() {
        return getCarbonMonoxideConcentrationValidRange(0);
    }

    /**
     * get Carbon Monoxide Concentration's Valid Range
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canCarbonMonoxideConcentrationNotify(int)
     */
    public synchronized boolean canCarbonMonoxideConcentrationNotify() {
        return canCarbonMonoxideConcentrationNotify(0);
    }

    /**
     * get Carbon Monoxide Concentration characteristic's notify status
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return {@code true}:target  Carbon Monoxide Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canCarbonMonoxideConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Carbon Monoxide Concentration characteristic's ES Measurement
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return {@code true}:target Carbon Monoxide Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Carbon Monoxide Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Carbon Monoxide Concentration characteristic's ES Configuration
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return {@code true}:target Carbon Monoxide Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Carbon Monoxide Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Carbon Monoxide Concentration characteristic's Characteristic User Description
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return {@code true}:target Carbon Monoxide Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Carbon Monoxide Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicValidRange() {
        return hasCarbonMonoxideConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Carbon Monoxide Concentration characteristic's Valid Range
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return {@code true}:target Carbon Monoxide Concentration Characteristic has Valid Range Descriptor, {@code false}:target Carbon Monoxide Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasCarbonMonoxideConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startCarbonMonoxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startCarbonMonoxideConcentrationNotification() {
        return startCarbonMonoxideConcentrationNotification(0);
    }

    /**
     * start Carbon Monoxide Concentration notification
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startCarbonMonoxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canCarbonMonoxideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopCarbonMonoxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopCarbonMonoxideConcentrationNotification() {
        return stopCarbonMonoxideConcentrationNotification(0);
    }

    /**
     * stop Carbon Monoxide Concentration notification
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopCarbonMonoxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canCarbonMonoxideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Carbon Monoxide Concentration's Trigger Setting
     *
     * @param characteristicIndex Carbon Monoxide Concentration characteristic index
     * @param descriptorIndex     Carbon Monoxide Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Carbon Monoxide Concentration's ES Configuration
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setCarbonMonoxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setCarbonMonoxideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Carbon Monoxide Concentration's Characteristic User Description
     *
     * @param index Carbon Monoxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onCarbonMonoxideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getDewPoint(int)
     */
    @Nullable
    public synchronized Integer getDewPoint() {
        return getDewPoint(0);
    }

    /**
     * get Dew Point
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, DewPointAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDewPoint(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Dew Point characteristic's ES Trigger Setting count
     *
     * @param index Dew Point characteristic index
     * @return Dew Point characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getDewPointCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getDewPointCharacteristicUserDescription() {
        return getDewPointCharacteristicUserDescription(0);
    }

    /**
     * get Dew Point's Characteristic User Description
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDewPointCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Dew Point characteristic count
     *
     * @return available Dew Point characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getDewPointCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getDewPointEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingConfiguration() {
        return getDewPointEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Dew Point's ES Configuration
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getDewPointEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingMeasurement() {
        return getDewPointEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Dew Point's ES Measurement
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getDewPointEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingTriggerSetting() {
        return getDewPointEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Dew Point's Trigger Setting
     *
     * @param characteristicIndex Dew Point characteristic index
     * @param descriptorIndex     Dew Point characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getDewPointValidRange(int)
     */
    @Nullable
    public synchronized Integer getDewPointValidRange() {
        return getDewPointValidRange(0);
    }

    /**
     * get Dew Point's Valid Range
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDewPointValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canDewPointNotify(int)
     */
    public synchronized boolean canDewPointNotify() {
        return canDewPointNotify(0);
    }

    /**
     * get Dew Point characteristic's notify status
     *
     * @param index Dew Point characteristic index
     * @return {@code true}:target  Dew Point characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canDewPointNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasDewPointCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasDewPointCharacteristicEnvironmentalSensingMeasurement() {
        return hasDewPointCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Dew Point characteristic's ES Measurement
     *
     * @param index Dew Point characteristic index
     * @return {@code true}:target Dew Point Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Dew Point Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasDewPointCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasDewPointCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasDewPointCharacteristicEnvironmentalSensingConfiguration() {
        return hasDewPointCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Dew Point characteristic's ES Configuration
     *
     * @param index Dew Point characteristic index
     * @return {@code true}:target Dew Point Characteristic has ES Configuration Descriptor, {@code false}:target Dew Point Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasDewPointCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasDewPointCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasDewPointCharacteristicCharacteristicUserDescription() {
        return hasDewPointCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Dew Point characteristic's Characteristic User Description
     *
     * @param index Dew Point characteristic index
     * @return {@code true}:target Dew Point Characteristic has Characteristic User Description Descriptor, {@code false}:target Dew Point Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasDewPointCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasDewPointCharacteristicValidRange(int)
     */
    public synchronized boolean hasDewPointCharacteristicValidRange() {
        return hasDewPointCharacteristicValidRange(0);
    }

    /**
     * check Dew Point characteristic's Valid Range
     *
     * @param index Dew Point characteristic index
     * @return {@code true}:target Dew Point Characteristic has Valid Range Descriptor, {@code false}:target Dew Point Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasDewPointCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startDewPointNotification(int)
     */
    @Nullable
    public synchronized Integer startDewPointNotification() {
        return startDewPointNotification(0);
    }

    /**
     * start Dew Point notification
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startDewPointNotification(int index) {
        Integer taskId = null;
        if (canDewPointNotify(index)) {
            EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopDewPointNotification(int)
     */
    @Nullable
    public synchronized Integer stopDewPointNotification() {
        return stopDewPointNotification(0);
    }

    /**
     * stop Dew Point notification
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopDewPointNotification(int index) {
        Integer taskId = null;
        if (canDewPointNotify(index)) {
            EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setDewPointEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setDewPointEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Dew Point's Trigger Setting
     *
     * @param characteristicIndex Dew Point characteristic index
     * @param descriptorIndex     Dew Point characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setDewPointEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setDewPointEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Dew Point's ES Configuration
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setDewPointCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setDewPointCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setDewPointCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Dew Point's Characteristic User Description
     *
     * @param index Dew Point characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onDewPointCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDewPointCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(DEW_POINT_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getElevation(int)
     */
    @Nullable
    public synchronized Integer getElevation() {
        return getElevation(0);
    }

    /**
     * get Elevation
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ElevationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getElevation(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getElevationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Elevation characteristic's ES Trigger Setting count
     *
     * @param index Elevation characteristic index
     * @return Elevation characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getElevationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getElevationCharacteristicUserDescription() {
        return getElevationCharacteristicUserDescription(0);
    }

    /**
     * get Elevation's Characteristic User Description
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getElevationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Elevation characteristic count
     *
     * @return available Elevation characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getElevationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getElevationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingConfiguration() {
        return getElevationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Elevation's ES Configuration
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getElevationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingMeasurement() {
        return getElevationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Elevation's ES Measurement
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getElevationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingTriggerSetting() {
        return getElevationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Elevation's Trigger Setting
     *
     * @param characteristicIndex Elevation characteristic index
     * @param descriptorIndex     Elevation characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getElevationValidRange(int)
     */
    @Nullable
    public synchronized Integer getElevationValidRange() {
        return getElevationValidRange(0);
    }

    /**
     * get Elevation's Valid Range
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getElevationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canElevationNotify(int)
     */
    public synchronized boolean canElevationNotify() {
        return canElevationNotify(0);
    }

    /**
     * get Elevation characteristic's notify status
     *
     * @param index Elevation characteristic index
     * @return {@code true}:target  Elevation characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canElevationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasElevationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasElevationCharacteristicEnvironmentalSensingMeasurement() {
        return hasElevationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Elevation characteristic's ES Measurement
     *
     * @param index Elevation characteristic index
     * @return {@code true}:target Elevation Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Elevation Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasElevationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasElevationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasElevationCharacteristicEnvironmentalSensingConfiguration() {
        return hasElevationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Elevation characteristic's ES Configuration
     *
     * @param index Elevation characteristic index
     * @return {@code true}:target Elevation Characteristic has ES Configuration Descriptor, {@code false}:target Elevation Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasElevationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasElevationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasElevationCharacteristicCharacteristicUserDescription() {
        return hasElevationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Elevation characteristic's Characteristic User Description
     *
     * @param index Elevation characteristic index
     * @return {@code true}:target Elevation Characteristic has Characteristic User Description Descriptor, {@code false}:target Elevation Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasElevationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasElevationCharacteristicValidRange(int)
     */
    public synchronized boolean hasElevationCharacteristicValidRange() {
        return hasElevationCharacteristicValidRange(0);
    }

    /**
     * check Elevation characteristic's Valid Range
     *
     * @param index Elevation characteristic index
     * @return {@code true}:target Elevation Characteristic has Valid Range Descriptor, {@code false}:target Elevation Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasElevationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startElevationNotification(int)
     */
    @Nullable
    public synchronized Integer startElevationNotification() {
        return startElevationNotification(0);
    }

    /**
     * start Elevation notification
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startElevationNotification(int index) {
        Integer taskId = null;
        if (canElevationNotify(index)) {
            EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopElevationNotification(int)
     */
    @Nullable
    public synchronized Integer stopElevationNotification() {
        return stopElevationNotification(0);
    }

    /**
     * stop Elevation notification
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopElevationNotification(int index) {
        Integer taskId = null;
        if (canElevationNotify(index)) {
            EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setElevationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setElevationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Elevation's Trigger Setting
     *
     * @param characteristicIndex Elevation characteristic index
     * @param descriptorIndex     Elevation characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setElevationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setElevationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Elevation's ES Configuration
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setElevationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setElevationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setElevationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Elevation's Characteristic User Description
     *
     * @param index Elevation characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onElevationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setElevationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(ELEVATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getGustFactor(int)
     */
    @Nullable
    public synchronized Integer getGustFactor() {
        return getGustFactor(0);
    }

    /**
     * get Gust Factor
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, GustFactorAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getGustFactor(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Gust Factor characteristic's ES Trigger Setting count
     *
     * @param index Gust Factor characteristic index
     * @return Gust Factor characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getGustFactorCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getGustFactorCharacteristicUserDescription() {
        return getGustFactorCharacteristicUserDescription(0);
    }

    /**
     * get Gust Factor's Characteristic User Description
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getGustFactorCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Gust Factor characteristic count
     *
     * @return available Gust Factor characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getGustFactorCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getGustFactorEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingConfiguration() {
        return getGustFactorEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Gust Factor's ES Configuration
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingMeasurement() {
        return getGustFactorEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Gust Factor's ES Measurement
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingTriggerSetting() {
        return getGustFactorEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Gust Factor's Trigger Setting
     *
     * @param characteristicIndex Gust Factor characteristic index
     * @param descriptorIndex     Gust Factor characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorValidRange(int)
     */
    @Nullable
    public synchronized Integer getGustFactorValidRange() {
        return getGustFactorValidRange(0);
    }

    /**
     * get Gust Factor's Valid Range
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getGustFactorValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canGustFactorNotify(int)
     */
    public synchronized boolean canGustFactorNotify() {
        return canGustFactorNotify(0);
    }

    /**
     * get Gust Factor characteristic's notify status
     *
     * @param index Gust Factor characteristic index
     * @return {@code true}:target  Gust Factor characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canGustFactorNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasGustFactorCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasGustFactorCharacteristicEnvironmentalSensingMeasurement() {
        return hasGustFactorCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Gust Factor characteristic's ES Measurement
     *
     * @param index Gust Factor characteristic index
     * @return {@code true}:target Gust Factor Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Gust Factor Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasGustFactorCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasGustFactorCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasGustFactorCharacteristicEnvironmentalSensingConfiguration() {
        return hasGustFactorCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Gust Factor characteristic's ES Configuration
     *
     * @param index Gust Factor characteristic index
     * @return {@code true}:target Gust Factor Characteristic has ES Configuration Descriptor, {@code false}:target Gust Factor Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasGustFactorCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasGustFactorCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasGustFactorCharacteristicCharacteristicUserDescription() {
        return hasGustFactorCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Gust Factor characteristic's Characteristic User Description
     *
     * @param index Gust Factor characteristic index
     * @return {@code true}:target Gust Factor Characteristic has Characteristic User Description Descriptor, {@code false}:target Gust Factor Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasGustFactorCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasGustFactorCharacteristicValidRange(int)
     */
    public synchronized boolean hasGustFactorCharacteristicValidRange() {
        return hasGustFactorCharacteristicValidRange(0);
    }

    /**
     * check Gust Factor characteristic's Valid Range
     *
     * @param index Gust Factor characteristic index
     * @return {@code true}:target Gust Factor Characteristic has Valid Range Descriptor, {@code false}:target Gust Factor Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasGustFactorCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startGustFactorNotification(int)
     */
    @Nullable
    public synchronized Integer startGustFactorNotification() {
        return startGustFactorNotification(0);
    }

    /**
     * start Gust Factor notification
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startGustFactorNotification(int index) {
        Integer taskId = null;
        if (canGustFactorNotify(index)) {
            EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopGustFactorNotification(int)
     */
    @Nullable
    public synchronized Integer stopGustFactorNotification() {
        return stopGustFactorNotification(0);
    }

    /**
     * stop Gust Factor notification
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopGustFactorNotification(int index) {
        Integer taskId = null;
        if (canGustFactorNotify(index)) {
            EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setGustFactorEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setGustFactorEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Gust Factor's Trigger Setting
     *
     * @param characteristicIndex Gust Factor characteristic index
     * @param descriptorIndex     Gust Factor characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setGustFactorEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setGustFactorEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Gust Factor's ES Configuration
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setGustFactorCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setGustFactorCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setGustFactorCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Gust Factor's Characteristic User Description
     *
     * @param index Gust Factor characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onGustFactorCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setGustFactorCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(GUST_FACTOR_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndex(int)
     */
    @Nullable
    public synchronized Integer getHeatIndex() {
        return getHeatIndex(0);
    }

    /**
     * get Heat Index
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, HeatIndexAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeatIndex(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Heat Index characteristic's ES Trigger Setting count
     *
     * @param index Heat Index characteristic index
     * @return Heat Index characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getHeatIndexCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexCharacteristicUserDescription() {
        return getHeatIndexCharacteristicUserDescription(0);
    }

    /**
     * get Heat Index's Characteristic User Description
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeatIndexCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Heat Index characteristic count
     *
     * @return available Heat Index characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getHeatIndexCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getHeatIndexEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingConfiguration() {
        return getHeatIndexEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Heat Index's ES Configuration
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingMeasurement() {
        return getHeatIndexEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Heat Index's ES Measurement
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingTriggerSetting() {
        return getHeatIndexEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Heat Index's Trigger Setting
     *
     * @param characteristicIndex Heat Index characteristic index
     * @param descriptorIndex     Heat Index characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexValidRange(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexValidRange() {
        return getHeatIndexValidRange(0);
    }

    /**
     * get Heat Index's Valid Range
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeatIndexValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canHeatIndexNotify(int)
     */
    public synchronized boolean canHeatIndexNotify() {
        return canHeatIndexNotify(0);
    }

    /**
     * get Heat Index characteristic's notify status
     *
     * @param index Heat Index characteristic index
     * @return {@code true}:target  Heat Index characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canHeatIndexNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasHeatIndexCharacteristicEnvironmentalSensingMeasurement() {
        return hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Heat Index characteristic's ES Measurement
     *
     * @param index Heat Index characteristic index
     * @return {@code true}:target Heat Index Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Heat Index Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasHeatIndexCharacteristicEnvironmentalSensingConfiguration() {
        return hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Heat Index characteristic's ES Configuration
     *
     * @param index Heat Index characteristic index
     * @return {@code true}:target Heat Index Characteristic has ES Configuration Descriptor, {@code false}:target Heat Index Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasHeatIndexCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasHeatIndexCharacteristicCharacteristicUserDescription() {
        return hasHeatIndexCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Heat Index characteristic's Characteristic User Description
     *
     * @param index Heat Index characteristic index
     * @return {@code true}:target Heat Index Characteristic has Characteristic User Description Descriptor, {@code false}:target Heat Index Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasHeatIndexCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasHeatIndexCharacteristicValidRange(int)
     */
    public synchronized boolean hasHeatIndexCharacteristicValidRange() {
        return hasHeatIndexCharacteristicValidRange(0);
    }

    /**
     * check Heat Index characteristic's Valid Range
     *
     * @param index Heat Index characteristic index
     * @return {@code true}:target Heat Index Characteristic has Valid Range Descriptor, {@code false}:target Heat Index Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasHeatIndexCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startHeatIndexNotification(int)
     */
    @Nullable
    public synchronized Integer startHeatIndexNotification() {
        return startHeatIndexNotification(0);
    }

    /**
     * start Heat Index notification
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startHeatIndexNotification(int index) {
        Integer taskId = null;
        if (canHeatIndexNotify(index)) {
            EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopHeatIndexNotification(int)
     */
    @Nullable
    public synchronized Integer stopHeatIndexNotification() {
        return stopHeatIndexNotification(0);
    }

    /**
     * stop Heat Index notification
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopHeatIndexNotification(int index) {
        Integer taskId = null;
        if (canHeatIndexNotify(index)) {
            EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setHeatIndexEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setHeatIndexEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Heat Index's Trigger Setting
     *
     * @param characteristicIndex Heat Index characteristic index
     * @param descriptorIndex     Heat Index characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setHeatIndexEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setHeatIndexEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Heat Index's ES Configuration
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setHeatIndexCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setHeatIndexCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setHeatIndexCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Heat Index's Characteristic User Description
     *
     * @param index Heat Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHeatIndexCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHeatIndexCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HEAT_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getHumidity(int)
     */
    @Nullable
    public synchronized Integer getHumidity() {
        return getHumidity(0);
    }

    /**
     * get Humidity
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, HumidityAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHumidity(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Humidity characteristic's ES Trigger Setting count
     *
     * @param index Humidity characteristic index
     * @return Humidity characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getHumidityCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getHumidityCharacteristicUserDescription() {
        return getHumidityCharacteristicUserDescription(0);
    }

    /**
     * get Humidity's Characteristic User Description
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHumidityCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Humidity characteristic count
     *
     * @return available Humidity characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getHumidityCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getHumidityEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingConfiguration() {
        return getHumidityEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Humidity's ES Configuration
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getHumidityEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingMeasurement() {
        return getHumidityEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Humidity's ES Measurement
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getHumidityEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingTriggerSetting() {
        return getHumidityEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Humidity's Trigger Setting
     *
     * @param characteristicIndex Humidity characteristic index
     * @param descriptorIndex     Humidity characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getHumidityValidRange(int)
     */
    @Nullable
    public synchronized Integer getHumidityValidRange() {
        return getHumidityValidRange(0);
    }

    /**
     * get Humidity's Valid Range
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHumidityValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canHumidityNotify(int)
     */
    public synchronized boolean canHumidityNotify() {
        return canHumidityNotify(0);
    }

    /**
     * get Humidity characteristic's notify status
     *
     * @param index Humidity characteristic index
     * @return {@code true}:target  Humidity characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canHumidityNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasHumidityCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasHumidityCharacteristicEnvironmentalSensingMeasurement() {
        return hasHumidityCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Humidity characteristic's ES Measurement
     *
     * @param index Humidity characteristic index
     * @return {@code true}:target Humidity Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Humidity Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasHumidityCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasHumidityCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasHumidityCharacteristicEnvironmentalSensingConfiguration() {
        return hasHumidityCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Humidity characteristic's ES Configuration
     *
     * @param index Humidity characteristic index
     * @return {@code true}:target Humidity Characteristic has ES Configuration Descriptor, {@code false}:target Humidity Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasHumidityCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasHumidityCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasHumidityCharacteristicCharacteristicUserDescription() {
        return hasHumidityCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Humidity characteristic's Characteristic User Description
     *
     * @param index Humidity characteristic index
     * @return {@code true}:target Humidity Characteristic has Characteristic User Description Descriptor, {@code false}:target Humidity Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasHumidityCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasHumidityCharacteristicValidRange(int)
     */
    public synchronized boolean hasHumidityCharacteristicValidRange() {
        return hasHumidityCharacteristicValidRange(0);
    }

    /**
     * check Humidity characteristic's Valid Range
     *
     * @param index Humidity characteristic index
     * @return {@code true}:target Humidity Characteristic has Valid Range Descriptor, {@code false}:target Humidity Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasHumidityCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startHumidityNotification(int)
     */
    @Nullable
    public synchronized Integer startHumidityNotification() {
        return startHumidityNotification(0);
    }

    /**
     * start Humidity notification
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startHumidityNotification(int index) {
        Integer taskId = null;
        if (canHumidityNotify(index)) {
            EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopHumidityNotification(int)
     */
    @Nullable
    public synchronized Integer stopHumidityNotification() {
        return stopHumidityNotification(0);
    }

    /**
     * stop Humidity notification
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopHumidityNotification(int index) {
        Integer taskId = null;
        if (canHumidityNotify(index)) {
            EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setHumidityEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setHumidityEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Humidity's Trigger Setting
     *
     * @param characteristicIndex Humidity characteristic index
     * @param descriptorIndex     Humidity characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setHumidityEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setHumidityEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Humidity's ES Configuration
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setHumidityCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setHumidityCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setHumidityCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Humidity's Characteristic User Description
     *
     * @param index Humidity characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onHumidityCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHumidityCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(HUMIDITY_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getIrradiance(int)
     */
    @Nullable
    public synchronized Integer getIrradiance() {
        return getIrradiance(0);
    }

    /**
     * get Irradiance
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, IrradianceAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIrradiance(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Irradiance characteristic's ES Trigger Setting count
     *
     * @param index Irradiance characteristic index
     * @return Irradiance characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getIrradianceCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getIrradianceCharacteristicUserDescription() {
        return getIrradianceCharacteristicUserDescription(0);
    }

    /**
     * get Irradiance's Characteristic User Description
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIrradianceCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Irradiance characteristic count
     *
     * @return available Irradiance characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getIrradianceCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getIrradianceEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingConfiguration() {
        return getIrradianceEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Irradiance's ES Configuration
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingMeasurement() {
        return getIrradianceEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Irradiance's ES Measurement
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingTriggerSetting() {
        return getIrradianceEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Irradiance's Trigger Setting
     *
     * @param characteristicIndex Irradiance characteristic index
     * @param descriptorIndex     Irradiance characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceValidRange(int)
     */
    @Nullable
    public synchronized Integer getIrradianceValidRange() {
        return getIrradianceValidRange(0);
    }

    /**
     * get Irradiance's Valid Range
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIrradianceValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canIrradianceNotify(int)
     */
    public synchronized boolean canIrradianceNotify() {
        return canIrradianceNotify(0);
    }

    /**
     * get Irradiance characteristic's notify status
     *
     * @param index Irradiance characteristic index
     * @return {@code true}:target  Irradiance characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canIrradianceNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasIrradianceCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasIrradianceCharacteristicEnvironmentalSensingMeasurement() {
        return hasIrradianceCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Irradiance characteristic's ES Measurement
     *
     * @param index Irradiance characteristic index
     * @return {@code true}:target Irradiance Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Irradiance Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasIrradianceCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasIrradianceCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasIrradianceCharacteristicEnvironmentalSensingConfiguration() {
        return hasIrradianceCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Irradiance characteristic's ES Configuration
     *
     * @param index Irradiance characteristic index
     * @return {@code true}:target Irradiance Characteristic has ES Configuration Descriptor, {@code false}:target Irradiance Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasIrradianceCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasIrradianceCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasIrradianceCharacteristicCharacteristicUserDescription() {
        return hasIrradianceCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Irradiance characteristic's Characteristic User Description
     *
     * @param index Irradiance characteristic index
     * @return {@code true}:target Irradiance Characteristic has Characteristic User Description Descriptor, {@code false}:target Irradiance Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasIrradianceCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasIrradianceCharacteristicValidRange(int)
     */
    public synchronized boolean hasIrradianceCharacteristicValidRange() {
        return hasIrradianceCharacteristicValidRange(0);
    }

    /**
     * check Irradiance characteristic's Valid Range
     *
     * @param index Irradiance characteristic index
     * @return {@code true}:target Irradiance Characteristic has Valid Range Descriptor, {@code false}:target Irradiance Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasIrradianceCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startIrradianceNotification(int)
     */
    @Nullable
    public synchronized Integer startIrradianceNotification() {
        return startIrradianceNotification(0);
    }

    /**
     * start Irradiance notification
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startIrradianceNotification(int index) {
        Integer taskId = null;
        if (canIrradianceNotify(index)) {
            EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopIrradianceNotification(int)
     */
    @Nullable
    public synchronized Integer stopIrradianceNotification() {
        return stopIrradianceNotification(0);
    }

    /**
     * stop Irradiance notification
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopIrradianceNotification(int index) {
        Integer taskId = null;
        if (canIrradianceNotify(index)) {
            EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setIrradianceEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setIrradianceEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Irradiance's Trigger Setting
     *
     * @param characteristicIndex Irradiance characteristic index
     * @param descriptorIndex     Irradiance characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setIrradianceEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setIrradianceEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Irradiance's ES Configuration
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setIrradianceCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setIrradianceCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setIrradianceCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Irradiance's Characteristic User Description
     *
     * @param index Irradiance characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onIrradianceCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setIrradianceCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(IRRADIANCE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclination(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclination() {
        return getMagneticDeclination(0);
    }

    /**
     * get Magnetic Declination
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, MagneticDeclinationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticDeclination(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Magnetic Declination characteristic's ES Trigger Setting count
     *
     * @param index Magnetic Declination characteristic index
     * @return Magnetic Declination characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getMagneticDeclinationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCharacteristicUserDescription() {
        return getMagneticDeclinationCharacteristicUserDescription(0);
    }

    /**
     * get Magnetic Declination's Characteristic User Description
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Magnetic Declination characteristic count
     *
     * @return available Magnetic Declination characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getMagneticDeclinationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingConfiguration() {
        return getMagneticDeclinationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Magnetic Declination's ES Configuration
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingMeasurement() {
        return getMagneticDeclinationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Magnetic Declination's ES Measurement
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingTriggerSetting() {
        return getMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Magnetic Declination's Trigger Setting
     *
     * @param characteristicIndex Magnetic Declination characteristic index
     * @param descriptorIndex     Magnetic Declination characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationValidRange() {
        return getMagneticDeclinationValidRange(0);
    }

    /**
     * get Magnetic Declination's Valid Range
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canMagneticDeclinationNotify(int)
     */
    public synchronized boolean canMagneticDeclinationNotify() {
        return canMagneticDeclinationNotify(0);
    }

    /**
     * get Magnetic Declination characteristic's notify status
     *
     * @param index Magnetic Declination characteristic index
     * @return {@code true}:target  Magnetic Declination characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canMagneticDeclinationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement() {
        return hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Magnetic Declination characteristic's ES Measurement
     *
     * @param index Magnetic Declination characteristic index
     * @return {@code true}:target Magnetic Declination Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Magnetic Declination Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration() {
        return hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Magnetic Declination characteristic's ES Configuration
     *
     * @param index Magnetic Declination characteristic index
     * @return {@code true}:target Magnetic Declination Characteristic has ES Configuration Descriptor, {@code false}:target Magnetic Declination Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicCharacteristicUserDescription() {
        return hasMagneticDeclinationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Magnetic Declination characteristic's Characteristic User Description
     *
     * @param index Magnetic Declination characteristic index
     * @return {@code true}:target Magnetic Declination Characteristic has Characteristic User Description Descriptor, {@code false}:target Magnetic Declination Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicValidRange(int)
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicValidRange() {
        return hasMagneticDeclinationCharacteristicValidRange(0);
    }

    /**
     * check Magnetic Declination characteristic's Valid Range
     *
     * @param index Magnetic Declination characteristic index
     * @return {@code true}:target Magnetic Declination Characteristic has Valid Range Descriptor, {@code false}:target Magnetic Declination Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasMagneticDeclinationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startMagneticDeclinationNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticDeclinationNotification() {
        return startMagneticDeclinationNotification(0);
    }

    /**
     * start Magnetic Declination notification
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startMagneticDeclinationNotification(int index) {
        Integer taskId = null;
        if (canMagneticDeclinationNotify(index)) {
            EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopMagneticDeclinationNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticDeclinationNotification() {
        return stopMagneticDeclinationNotification(0);
    }

    /**
     * stop Magnetic Declination notification
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopMagneticDeclinationNotification(int index) {
        Integer taskId = null;
        if (canMagneticDeclinationNotify(index)) {
            EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setMagneticDeclinationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Magnetic Declination's Trigger Setting
     *
     * @param characteristicIndex Magnetic Declination characteristic index
     * @param descriptorIndex     Magnetic Declination characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setMagneticDeclinationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMagneticDeclinationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Magnetic Declination's ES Configuration
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setMagneticDeclinationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMagneticDeclinationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Magnetic Declination's Characteristic User Description
     *
     * @param index Magnetic Declination characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticDeclinationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2D(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2D() {
        return getMagneticFluxDensity2D(0);
    }

    /**
     * get Magnetic Flux Density - 2D
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, MagneticFluxDensity2DAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2D(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Magnetic Flux Density - 2D characteristic's ES Trigger Setting count
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return Magnetic Flux Density - 2D characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getMagneticFluxDensity2DCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCharacteristicUserDescription() {
        return getMagneticFluxDensity2DCharacteristicUserDescription(0);
    }

    /**
     * get Magnetic Flux Density - 2D's Characteristic User Description
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Magnetic Flux Density - 2D characteristic count
     *
     * @return available Magnetic Flux Density - 2D characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getMagneticFluxDensity2DEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingConfiguration() {
        return getMagneticFluxDensity2DEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Magnetic Flux Density - 2D's ES Configuration
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingMeasurement() {
        return getMagneticFluxDensity2DEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Magnetic Flux Density - 2D's ES Measurement
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting() {
        return getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Magnetic Flux Density - 2D's Trigger Setting
     *
     * @param characteristicIndex Magnetic Flux Density - 2D characteristic index
     * @param descriptorIndex     Magnetic Flux Density - 2D characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DValidRange() {
        return getMagneticFluxDensity2DValidRange(0);
    }

    /**
     * get Magnetic Flux Density - 2D's Valid Range
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canMagneticFluxDensity2DNotify(int)
     */
    public synchronized boolean canMagneticFluxDensity2DNotify() {
        return canMagneticFluxDensity2DNotify(0);
    }

    /**
     * get Magnetic Flux Density - 2D characteristic's notify status
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return {@code true}:target  Magnetic Flux Density - 2D characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canMagneticFluxDensity2DNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement() {
        return hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Magnetic Flux Density - 2D characteristic's ES Measurement
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 2D Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Magnetic Flux Density - 2D Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration() {
        return hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Magnetic Flux Density - 2D characteristic's ES Configuration
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 2D Characteristic has ES Configuration Descriptor, {@code false}:target Magnetic Flux Density - 2D Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription() {
        return hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Magnetic Flux Density - 2D characteristic's Characteristic User Description
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 2D Characteristic has Characteristic User Description Descriptor, {@code false}:target Magnetic Flux Density - 2D Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicValidRange(int)
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicValidRange() {
        return hasMagneticFluxDensity2DCharacteristicValidRange(0);
    }

    /**
     * check Magnetic Flux Density - 2D characteristic's Valid Range
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 2D Characteristic has Valid Range Descriptor, {@code false}:target Magnetic Flux Density - 2D Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity2DCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startMagneticFluxDensity2DNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity2DNotification() {
        return startMagneticFluxDensity2DNotification(0);
    }

    /**
     * start Magnetic Flux Density - 2D notification
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity2DNotification(int index) {
        Integer taskId = null;
        if (canMagneticFluxDensity2DNotify(index)) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopMagneticFluxDensity2DNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity2DNotification() {
        return stopMagneticFluxDensity2DNotification(0);
    }

    /**
     * stop Magnetic Flux Density - 2D notification
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity2DNotification(int index) {
        Integer taskId = null;
        if (canMagneticFluxDensity2DNotify(index)) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Magnetic Flux Density - 2D's Trigger Setting
     *
     * @param characteristicIndex Magnetic Flux Density - 2D characteristic index
     * @param descriptorIndex     Magnetic Flux Density - 2D characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity2DEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMagneticFluxDensity2DEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Magnetic Flux Density - 2D's ES Configuration
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity2DCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMagneticFluxDensity2DCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Magnetic Flux Density - 2D's Characteristic User Description
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity2DCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3D(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3D() {
        return getMagneticFluxDensity3D(0);
    }

    /**
     * get Magnetic Flux Density - 3D
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, MagneticFluxDensity3DAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3D(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Magnetic Flux Density - 3D characteristic's ES Trigger Setting count
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return Magnetic Flux Density - 3D characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getMagneticFluxDensity3DCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCharacteristicUserDescription() {
        return getMagneticFluxDensity3DCharacteristicUserDescription(0);
    }

    /**
     * get Magnetic Flux Density - 3D's Characteristic User Description
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Magnetic Flux Density - 3D characteristic count
     *
     * @return available Magnetic Flux Density - 3D characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getMagneticFluxDensity3DEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingConfiguration() {
        return getMagneticFluxDensity3DEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Magnetic Flux Density - 3D's ES Configuration
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingMeasurement() {
        return getMagneticFluxDensity3DEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Magnetic Flux Density - 3D's ES Measurement
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting() {
        return getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Magnetic Flux Density - 3D's Trigger Setting
     *
     * @param characteristicIndex Magnetic Flux Density - 3D characteristic index
     * @param descriptorIndex     Magnetic Flux Density - 3D characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DValidRange() {
        return getMagneticFluxDensity3DValidRange(0);
    }

    /**
     * get Magnetic Flux Density - 3D's Valid Range
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canMagneticFluxDensity3DNotify(int)
     */
    public synchronized boolean canMagneticFluxDensity3DNotify() {
        return canMagneticFluxDensity3DNotify(0);
    }

    /**
     * get Magnetic Flux Density - 3D characteristic's notify status
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return {@code true}:target  Magnetic Flux Density - 3D characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canMagneticFluxDensity3DNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement() {
        return hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Magnetic Flux Density - 3D characteristic's ES Measurement
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 3D Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Magnetic Flux Density - 3D Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration() {
        return hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Magnetic Flux Density - 3D characteristic's ES Configuration
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 3D Characteristic has ES Configuration Descriptor, {@code false}:target Magnetic Flux Density - 3D Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription() {
        return hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Magnetic Flux Density - 3D characteristic's Characteristic User Description
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 3D Characteristic has Characteristic User Description Descriptor, {@code false}:target Magnetic Flux Density - 3D Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicValidRange(int)
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicValidRange() {
        return hasMagneticFluxDensity3DCharacteristicValidRange(0);
    }

    /**
     * check Magnetic Flux Density - 3D characteristic's Valid Range
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return {@code true}:target Magnetic Flux Density - 3D Characteristic has Valid Range Descriptor, {@code false}:target Magnetic Flux Density - 3D Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasMagneticFluxDensity3DCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startMagneticFluxDensity3DNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity3DNotification() {
        return startMagneticFluxDensity3DNotification(0);
    }

    /**
     * start Magnetic Flux Density - 3D notification
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity3DNotification(int index) {
        Integer taskId = null;
        if (canMagneticFluxDensity3DNotify(index)) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopMagneticFluxDensity3DNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity3DNotification() {
        return stopMagneticFluxDensity3DNotification(0);
    }

    /**
     * stop Magnetic Flux Density - 3D notification
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity3DNotification(int index) {
        Integer taskId = null;
        if (canMagneticFluxDensity3DNotify(index)) {
            EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Magnetic Flux Density - 3D's Trigger Setting
     *
     * @param characteristicIndex Magnetic Flux Density - 3D characteristic index
     * @param descriptorIndex     Magnetic Flux Density - 3D characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity3DEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMagneticFluxDensity3DEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Magnetic Flux Density - 3D's ES Configuration
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity3DCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMagneticFluxDensity3DCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Magnetic Flux Density - 3D's Characteristic User Description
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMagneticFluxDensity3DCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentration(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentration() {
        return getMethaneConcentration(0);
    }

    /**
     * get Methane Concentration
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, MethaneConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMethaneConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Methane Concentration characteristic's ES Trigger Setting count
     *
     * @param index Methane Concentration characteristic index
     * @return Methane Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getMethaneConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCharacteristicUserDescription() {
        return getMethaneConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Methane Concentration's Characteristic User Description
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Methane Concentration characteristic count
     *
     * @return available Methane Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getMethaneConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingConfiguration() {
        return getMethaneConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Methane Concentration's ES Configuration
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingMeasurement() {
        return getMethaneConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Methane Concentration's ES Measurement
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingTriggerSetting() {
        return getMethaneConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Methane Concentration's Trigger Setting
     *
     * @param characteristicIndex Methane Concentration characteristic index
     * @param descriptorIndex     Methane Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationValidRange() {
        return getMethaneConcentrationValidRange(0);
    }

    /**
     * get Methane Concentration's Valid Range
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canMethaneConcentrationNotify(int)
     */
    public synchronized boolean canMethaneConcentrationNotify() {
        return canMethaneConcentrationNotify(0);
    }

    /**
     * get Methane Concentration characteristic's notify status
     *
     * @param index Methane Concentration characteristic index
     * @return {@code true}:target  Methane Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canMethaneConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Methane Concentration characteristic's ES Measurement
     *
     * @param index Methane Concentration characteristic index
     * @return {@code true}:target Methane Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Methane Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Methane Concentration characteristic's ES Configuration
     *
     * @param index Methane Concentration characteristic index
     * @return {@code true}:target Methane Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Methane Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicCharacteristicUserDescription() {
        return hasMethaneConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Methane Concentration characteristic's Characteristic User Description
     *
     * @param index Methane Concentration characteristic index
     * @return {@code true}:target Methane Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Methane Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicValidRange() {
        return hasMethaneConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Methane Concentration characteristic's Valid Range
     *
     * @param index Methane Concentration characteristic index
     * @return {@code true}:target Methane Concentration Characteristic has Valid Range Descriptor, {@code false}:target Methane Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasMethaneConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startMethaneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startMethaneConcentrationNotification() {
        return startMethaneConcentrationNotification(0);
    }

    /**
     * start Methane Concentration notification
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startMethaneConcentrationNotification(int index) {
        Integer taskId = null;
        if (canMethaneConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopMethaneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopMethaneConcentrationNotification() {
        return stopMethaneConcentrationNotification(0);
    }

    /**
     * stop Methane Concentration notification
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopMethaneConcentrationNotification(int index) {
        Integer taskId = null;
        if (canMethaneConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setMethaneConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMethaneConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Methane Concentration's Trigger Setting
     *
     * @param characteristicIndex Methane Concentration characteristic index
     * @param descriptorIndex     Methane Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setMethaneConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMethaneConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Methane Concentration's ES Configuration
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setMethaneConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMethaneConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Methane Concentration's Characteristic User Description
     *
     * @param index Methane Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onMethaneConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(METHANE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentration() {
        return getNitrogenDioxideConcentration(0);
    }

    /**
     * get Nitrogen Dioxide Concentration
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, NitrogenDioxideConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Nitrogen Dioxide Concentration characteristic's ES Trigger Setting count
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return Nitrogen Dioxide Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getNitrogenDioxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicUserDescription() {
        return getNitrogenDioxideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Nitrogen Dioxide Concentration's Characteristic User Description
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Nitrogen Dioxide Concentration characteristic count
     *
     * @return available Nitrogen Dioxide Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration() {
        return getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Nitrogen Dioxide Concentration's ES Configuration
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement() {
        return getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Nitrogen Dioxide Concentration's ES Measurement
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting() {
        return getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Nitrogen Dioxide Concentration's Trigger Setting
     *
     * @param characteristicIndex Nitrogen Dioxide Concentration characteristic index
     * @param descriptorIndex     Nitrogen Dioxide Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationValidRange() {
        return getNitrogenDioxideConcentrationValidRange(0);
    }

    /**
     * get Nitrogen Dioxide Concentration's Valid Range
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canNitrogenDioxideConcentrationNotify(int)
     */
    public synchronized boolean canNitrogenDioxideConcentrationNotify() {
        return canNitrogenDioxideConcentrationNotify(0);
    }

    /**
     * get Nitrogen Dioxide Concentration characteristic's notify status
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return {@code true}:target  Nitrogen Dioxide Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canNitrogenDioxideConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Nitrogen Dioxide Concentration characteristic's ES Measurement
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return {@code true}:target Nitrogen Dioxide Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Nitrogen Dioxide Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Nitrogen Dioxide Concentration characteristic's ES Configuration
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return {@code true}:target Nitrogen Dioxide Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Nitrogen Dioxide Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Nitrogen Dioxide Concentration characteristic's Characteristic User Description
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return {@code true}:target Nitrogen Dioxide Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Nitrogen Dioxide Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicValidRange() {
        return hasNitrogenDioxideConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Nitrogen Dioxide Concentration characteristic's Valid Range
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return {@code true}:target Nitrogen Dioxide Concentration Characteristic has Valid Range Descriptor, {@code false}:target Nitrogen Dioxide Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasNitrogenDioxideConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startNitrogenDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startNitrogenDioxideConcentrationNotification() {
        return startNitrogenDioxideConcentrationNotification(0);
    }

    /**
     * start Nitrogen Dioxide Concentration notification
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startNitrogenDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canNitrogenDioxideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopNitrogenDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopNitrogenDioxideConcentrationNotification() {
        return stopNitrogenDioxideConcentrationNotification(0);
    }

    /**
     * stop Nitrogen Dioxide Concentration notification
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopNitrogenDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canNitrogenDioxideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Nitrogen Dioxide Concentration's Trigger Setting
     *
     * @param characteristicIndex Nitrogen Dioxide Concentration characteristic index
     * @param descriptorIndex     Nitrogen Dioxide Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Nitrogen Dioxide Concentration's ES Configuration
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setNitrogenDioxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setNitrogenDioxideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Nitrogen Dioxide Concentration's Characteristic User Description
     *
     * @param index Nitrogen Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNitrogenDioxideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentration(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentration() {
        return getNonMethaneVolatileOrganicCompoundsConcentration(0);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, NonMethaneVolatileOrganicCompoundsConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Non-Methane Volatile Organic Compounds Concentration characteristic's ES Trigger Setting count
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return Non-Methane Volatile Organic Compounds Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration's Characteristic User Description
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Non-Methane Volatile Organic Compounds Concentration characteristic count
     *
     * @return available Non-Methane Volatile Organic Compounds Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration's ES Configuration
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration's ES Measurement
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration's Trigger Setting
     *
     * @param characteristicIndex Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @param descriptorIndex     Non-Methane Volatile Organic Compounds Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationValidRange() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(0);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration's Valid Range
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canNonMethaneVolatileOrganicCompoundsConcentrationNotify(int)
     */
    public synchronized boolean canNonMethaneVolatileOrganicCompoundsConcentrationNotify() {
        return canNonMethaneVolatileOrganicCompoundsConcentrationNotify(0);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration characteristic's notify status
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return {@code true}:target  Non-Methane Volatile Organic Compounds Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canNonMethaneVolatileOrganicCompoundsConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Non-Methane Volatile Organic Compounds Concentration characteristic's ES Measurement
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return {@code true}:target Non-Methane Volatile Organic Compounds Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Non-Methane Volatile Organic Compounds Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Non-Methane Volatile Organic Compounds Concentration characteristic's ES Configuration
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return {@code true}:target Non-Methane Volatile Organic Compounds Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Non-Methane Volatile Organic Compounds Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Non-Methane Volatile Organic Compounds Concentration characteristic's Characteristic User Description
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return {@code true}:target Non-Methane Volatile Organic Compounds Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Non-Methane Volatile Organic Compounds Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Non-Methane Volatile Organic Compounds Concentration characteristic's Valid Range
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return {@code true}:target Non-Methane Volatile Organic Compounds Concentration Characteristic has Valid Range Descriptor, {@code false}:target Non-Methane Volatile Organic Compounds Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startNonMethaneVolatileOrganicCompoundsConcentrationNotification() {
        return startNonMethaneVolatileOrganicCompoundsConcentrationNotification(0);
    }

    /**
     * start Non-Methane Volatile Organic Compounds Concentration notification
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
        Integer taskId = null;
        if (canNonMethaneVolatileOrganicCompoundsConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopNonMethaneVolatileOrganicCompoundsConcentrationNotification() {
        return stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(0);
    }

    /**
     * stop Non-Methane Volatile Organic Compounds Concentration notification
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
        Integer taskId = null;
        if (canNonMethaneVolatileOrganicCompoundsConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Non-Methane Volatile Organic Compounds Concentration's Trigger Setting
     *
     * @param characteristicIndex Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @param descriptorIndex     Non-Methane Volatile Organic Compounds Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Non-Methane Volatile Organic Compounds Concentration's ES Configuration
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Non-Methane Volatile Organic Compounds Concentration's Characteristic User Description
     *
     * @param index Non-Methane Volatile Organic Compounds Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentration(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentration() {
        return getOzoneConcentration(0);
    }

    /**
     * get Ozone Concentration
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, OzoneConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getOzoneConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Ozone Concentration characteristic's ES Trigger Setting count
     *
     * @param index Ozone Concentration characteristic index
     * @return Ozone Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getOzoneConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCharacteristicUserDescription() {
        return getOzoneConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Ozone Concentration's Characteristic User Description
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Ozone Concentration characteristic count
     *
     * @return available Ozone Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getOzoneConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingConfiguration() {
        return getOzoneConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Ozone Concentration's ES Configuration
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingMeasurement() {
        return getOzoneConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Ozone Concentration's ES Measurement
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingTriggerSetting() {
        return getOzoneConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Ozone Concentration's Trigger Setting
     *
     * @param characteristicIndex Ozone Concentration characteristic index
     * @param descriptorIndex     Ozone Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationValidRange() {
        return getOzoneConcentrationValidRange(0);
    }

    /**
     * get Ozone Concentration's Valid Range
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canOzoneConcentrationNotify(int)
     */
    public synchronized boolean canOzoneConcentrationNotify() {
        return canOzoneConcentrationNotify(0);
    }

    /**
     * get Ozone Concentration characteristic's notify status
     *
     * @param index Ozone Concentration characteristic index
     * @return {@code true}:target  Ozone Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canOzoneConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Ozone Concentration characteristic's ES Measurement
     *
     * @param index Ozone Concentration characteristic index
     * @return {@code true}:target Ozone Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Ozone Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Ozone Concentration characteristic's ES Configuration
     *
     * @param index Ozone Concentration characteristic index
     * @return {@code true}:target Ozone Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Ozone Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicCharacteristicUserDescription() {
        return hasOzoneConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Ozone Concentration characteristic's Characteristic User Description
     *
     * @param index Ozone Concentration characteristic index
     * @return {@code true}:target Ozone Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Ozone Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicValidRange() {
        return hasOzoneConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Ozone Concentration characteristic's Valid Range
     *
     * @param index Ozone Concentration characteristic index
     * @return {@code true}:target Ozone Concentration Characteristic has Valid Range Descriptor, {@code false}:target Ozone Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasOzoneConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startOzoneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startOzoneConcentrationNotification() {
        return startOzoneConcentrationNotification(0);
    }

    /**
     * start Ozone Concentration notification
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startOzoneConcentrationNotification(int index) {
        Integer taskId = null;
        if (canOzoneConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopOzoneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopOzoneConcentrationNotification() {
        return stopOzoneConcentrationNotification(0);
    }

    /**
     * stop Ozone Concentration notification
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopOzoneConcentrationNotification(int index) {
        Integer taskId = null;
        if (canOzoneConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setOzoneConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setOzoneConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Ozone Concentration's Trigger Setting
     *
     * @param characteristicIndex Ozone Concentration characteristic index
     * @param descriptorIndex     Ozone Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setOzoneConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setOzoneConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Ozone Concentration's ES Configuration
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setOzoneConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setOzoneConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Ozone Concentration's Characteristic User Description
     *
     * @param index Ozone Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onOzoneConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(OZONE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10Concentration() {
        return getParticulateMatterPm10Concentration(0);
    }

    /**
     * get Particulate Matter - PM10 Concentration
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ParticulateMatterPm10ConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10Concentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Particulate Matter - PM10 Concentration characteristic's ES Trigger Setting count
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return Particulate Matter - PM10 Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicUserDescription() {
        return getParticulateMatterPm10ConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Particulate Matter - PM10 Concentration's Characteristic User Description
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Particulate Matter - PM10 Concentration characteristic count
     *
     * @return available Particulate Matter - PM10 Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration() {
        return getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Particulate Matter - PM10 Concentration's ES Configuration
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement() {
        return getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Particulate Matter - PM10 Concentration's ES Measurement
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting() {
        return getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Particulate Matter - PM10 Concentration's Trigger Setting
     *
     * @param characteristicIndex Particulate Matter - PM10 Concentration characteristic index
     * @param descriptorIndex     Particulate Matter - PM10 Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationValidRange() {
        return getParticulateMatterPm10ConcentrationValidRange(0);
    }

    /**
     * get Particulate Matter - PM10 Concentration's Valid Range
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canParticulateMatterPm10ConcentrationNotify(int)
     */
    public synchronized boolean canParticulateMatterPm10ConcentrationNotify() {
        return canParticulateMatterPm10ConcentrationNotify(0);
    }

    /**
     * get Particulate Matter - PM10 Concentration characteristic's notify status
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return {@code true}:target  Particulate Matter - PM10 Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canParticulateMatterPm10ConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Particulate Matter - PM10 Concentration characteristic's ES Measurement
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM10 Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Particulate Matter - PM10 Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Particulate Matter - PM10 Concentration characteristic's ES Configuration
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM10 Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Particulate Matter - PM10 Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription() {
        return hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Particulate Matter - PM10 Concentration characteristic's Characteristic User Description
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM10 Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Particulate Matter - PM10 Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicValidRange() {
        return hasParticulateMatterPm10ConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Particulate Matter - PM10 Concentration characteristic's Valid Range
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM10 Concentration Characteristic has Valid Range Descriptor, {@code false}:target Particulate Matter - PM10 Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasParticulateMatterPm10ConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startParticulateMatterPm10ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm10ConcentrationNotification() {
        return startParticulateMatterPm10ConcentrationNotification(0);
    }

    /**
     * start Particulate Matter - PM10 Concentration notification
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm10ConcentrationNotification(int index) {
        Integer taskId = null;
        if (canParticulateMatterPm10ConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopParticulateMatterPm10ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm10ConcentrationNotification() {
        return stopParticulateMatterPm10ConcentrationNotification(0);
    }

    /**
     * stop Particulate Matter - PM10 Concentration notification
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm10ConcentrationNotification(int index) {
        Integer taskId = null;
        if (canParticulateMatterPm10ConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Particulate Matter - PM10 Concentration's Trigger Setting
     *
     * @param characteristicIndex Particulate Matter - PM10 Concentration characteristic index
     * @param descriptorIndex     Particulate Matter - PM10 Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Particulate Matter - PM10 Concentration's ES Configuration
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm10ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setParticulateMatterPm10ConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Particulate Matter - PM10 Concentration's Characteristic User Description
     *
     * @param index Particulate Matter - PM10 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm10ConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1Concentration() {
        return getParticulateMatterPm1Concentration(0);
    }

    /**
     * get Particulate Matter - PM1 Concentration
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ParticulateMatterPm1ConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1Concentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Particulate Matter - PM1 Concentration characteristic's ES Trigger Setting count
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return Particulate Matter - PM1 Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicUserDescription() {
        return getParticulateMatterPm1ConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Particulate Matter - PM1 Concentration's Characteristic User Description
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Particulate Matter - PM1 Concentration characteristic count
     *
     * @return available Particulate Matter - PM1 Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration() {
        return getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Particulate Matter - PM1 Concentration's ES Configuration
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement() {
        return getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Particulate Matter - PM1 Concentration's ES Measurement
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting() {
        return getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Particulate Matter - PM1 Concentration's Trigger Setting
     *
     * @param characteristicIndex Particulate Matter - PM1 Concentration characteristic index
     * @param descriptorIndex     Particulate Matter - PM1 Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationValidRange() {
        return getParticulateMatterPm1ConcentrationValidRange(0);
    }

    /**
     * get Particulate Matter - PM1 Concentration's Valid Range
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canParticulateMatterPm1ConcentrationNotify(int)
     */
    public synchronized boolean canParticulateMatterPm1ConcentrationNotify() {
        return canParticulateMatterPm1ConcentrationNotify(0);
    }

    /**
     * get Particulate Matter - PM1 Concentration characteristic's notify status
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return {@code true}:target  Particulate Matter - PM1 Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canParticulateMatterPm1ConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Particulate Matter - PM1 Concentration characteristic's ES Measurement
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM1 Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Particulate Matter - PM1 Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Particulate Matter - PM1 Concentration characteristic's ES Configuration
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM1 Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Particulate Matter - PM1 Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription() {
        return hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Particulate Matter - PM1 Concentration characteristic's Characteristic User Description
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM1 Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Particulate Matter - PM1 Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicValidRange() {
        return hasParticulateMatterPm1ConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Particulate Matter - PM1 Concentration characteristic's Valid Range
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM1 Concentration Characteristic has Valid Range Descriptor, {@code false}:target Particulate Matter - PM1 Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasParticulateMatterPm1ConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startParticulateMatterPm1ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm1ConcentrationNotification() {
        return startParticulateMatterPm1ConcentrationNotification(0);
    }

    /**
     * start Particulate Matter - PM1 Concentration notification
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm1ConcentrationNotification(int index) {
        Integer taskId = null;
        if (canParticulateMatterPm1ConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopParticulateMatterPm1ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm1ConcentrationNotification() {
        return stopParticulateMatterPm1ConcentrationNotification(0);
    }

    /**
     * stop Particulate Matter - PM1 Concentration notification
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm1ConcentrationNotification(int index) {
        Integer taskId = null;
        if (canParticulateMatterPm1ConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Particulate Matter - PM1 Concentration's Trigger Setting
     *
     * @param characteristicIndex Particulate Matter - PM1 Concentration characteristic index
     * @param descriptorIndex     Particulate Matter - PM1 Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Particulate Matter - PM1 Concentration's ES Configuration
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm1ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setParticulateMatterPm1ConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Particulate Matter - PM1 Concentration's Characteristic User Description
     *
     * @param index Particulate Matter - PM1 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm1ConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25Concentration() {
        return getParticulateMatterPm25Concentration(0);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ParticulateMatterPm25ConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25Concentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Particulate Matter - PM2.5 Concentration characteristic's ES Trigger Setting count
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return Particulate Matter - PM2.5 Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicUserDescription() {
        return getParticulateMatterPm25ConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration's Characteristic User Description
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Particulate Matter - PM2.5 Concentration characteristic count
     *
     * @return available Particulate Matter - PM2.5 Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration() {
        return getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration's ES Configuration
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement() {
        return getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration's ES Measurement
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting() {
        return getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration's Trigger Setting
     *
     * @param characteristicIndex Particulate Matter - PM2.5 Concentration characteristic index
     * @param descriptorIndex     Particulate Matter - PM2.5 Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationValidRange() {
        return getParticulateMatterPm25ConcentrationValidRange(0);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration's Valid Range
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canParticulateMatterPm25ConcentrationNotify(int)
     */
    public synchronized boolean canParticulateMatterPm25ConcentrationNotify() {
        return canParticulateMatterPm25ConcentrationNotify(0);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration characteristic's notify status
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return {@code true}:target  Particulate Matter - PM2.5 Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canParticulateMatterPm25ConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Particulate Matter - PM2.5 Concentration characteristic's ES Measurement
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM2.5 Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Particulate Matter - PM2.5 Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Particulate Matter - PM2.5 Concentration characteristic's ES Configuration
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM2.5 Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Particulate Matter - PM2.5 Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription() {
        return hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Particulate Matter - PM2.5 Concentration characteristic's Characteristic User Description
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM2.5 Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Particulate Matter - PM2.5 Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicValidRange() {
        return hasParticulateMatterPm25ConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Particulate Matter - PM2.5 Concentration characteristic's Valid Range
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return {@code true}:target Particulate Matter - PM2.5 Concentration Characteristic has Valid Range Descriptor, {@code false}:target Particulate Matter - PM2.5 Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasParticulateMatterPm25ConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startParticulateMatterPm25ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm25ConcentrationNotification() {
        return startParticulateMatterPm25ConcentrationNotification(0);
    }

    /**
     * start Particulate Matter - PM2.5 Concentration notification
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm25ConcentrationNotification(int index) {
        Integer taskId = null;
        if (canParticulateMatterPm25ConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopParticulateMatterPm25ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm25ConcentrationNotification() {
        return stopParticulateMatterPm25ConcentrationNotification(0);
    }

    /**
     * stop Particulate Matter - PM2.5 Concentration notification
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm25ConcentrationNotification(int index) {
        Integer taskId = null;
        if (canParticulateMatterPm25ConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Particulate Matter - PM2.5 Concentration's Trigger Setting
     *
     * @param characteristicIndex Particulate Matter - PM2.5 Concentration characteristic index
     * @param descriptorIndex     Particulate Matter - PM2.5 Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Particulate Matter - PM2.5 Concentration's ES Configuration
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm25ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setParticulateMatterPm25ConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Particulate Matter - PM2.5 Concentration's Characteristic User Description
     *
     * @param index Particulate Matter - PM2.5 Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onParticulateMatterPm25ConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentration(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentration() {
        return getPollenConcentration(0);
    }

    /**
     * get Pollen Concentration
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, PollenConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPollenConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Pollen Concentration characteristic's ES Trigger Setting count
     *
     * @param index Pollen Concentration characteristic index
     * @return Pollen Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getPollenConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCharacteristicUserDescription() {
        return getPollenConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Pollen Concentration's Characteristic User Description
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Pollen Concentration characteristic count
     *
     * @return available Pollen Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getPollenConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingConfiguration() {
        return getPollenConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Pollen Concentration's ES Configuration
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingMeasurement() {
        return getPollenConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Pollen Concentration's ES Measurement
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingTriggerSetting() {
        return getPollenConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Pollen Concentration's Trigger Setting
     *
     * @param characteristicIndex Pollen Concentration characteristic index
     * @param descriptorIndex     Pollen Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationValidRange() {
        return getPollenConcentrationValidRange(0);
    }

    /**
     * get Pollen Concentration's Valid Range
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canPollenConcentrationNotify(int)
     */
    public synchronized boolean canPollenConcentrationNotify() {
        return canPollenConcentrationNotify(0);
    }

    /**
     * get Pollen Concentration characteristic's notify status
     *
     * @param index Pollen Concentration characteristic index
     * @return {@code true}:target  Pollen Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canPollenConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Pollen Concentration characteristic's ES Measurement
     *
     * @param index Pollen Concentration characteristic index
     * @return {@code true}:target Pollen Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Pollen Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Pollen Concentration characteristic's ES Configuration
     *
     * @param index Pollen Concentration characteristic index
     * @return {@code true}:target Pollen Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Pollen Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasPollenConcentrationCharacteristicCharacteristicUserDescription() {
        return hasPollenConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Pollen Concentration characteristic's Characteristic User Description
     *
     * @param index Pollen Concentration characteristic index
     * @return {@code true}:target Pollen Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Pollen Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasPollenConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasPollenConcentrationCharacteristicValidRange() {
        return hasPollenConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Pollen Concentration characteristic's Valid Range
     *
     * @param index Pollen Concentration characteristic index
     * @return {@code true}:target Pollen Concentration Characteristic has Valid Range Descriptor, {@code false}:target Pollen Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasPollenConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startPollenConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startPollenConcentrationNotification() {
        return startPollenConcentrationNotification(0);
    }

    /**
     * start Pollen Concentration notification
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startPollenConcentrationNotification(int index) {
        Integer taskId = null;
        if (canPollenConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopPollenConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopPollenConcentrationNotification() {
        return stopPollenConcentrationNotification(0);
    }

    /**
     * stop Pollen Concentration notification
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopPollenConcentrationNotification(int index) {
        Integer taskId = null;
        if (canPollenConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setPollenConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setPollenConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Pollen Concentration's Trigger Setting
     *
     * @param characteristicIndex Pollen Concentration characteristic index
     * @param descriptorIndex     Pollen Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setPollenConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setPollenConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Pollen Concentration's ES Configuration
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setPollenConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setPollenConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Pollen Concentration's Characteristic User Description
     *
     * @param index Pollen Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPollenConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getPressure(int)
     */
    @Nullable
    public synchronized Integer getPressure() {
        return getPressure(0);
    }

    /**
     * get Pressure
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, PressureAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPressure(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getPressureCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Pressure characteristic's ES Trigger Setting count
     *
     * @param index Pressure characteristic index
     * @return Pressure characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getPressureCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getPressureCharacteristicUserDescription() {
        return getPressureCharacteristicUserDescription(0);
    }

    /**
     * get Pressure's Characteristic User Description
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPressureCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Pressure characteristic count
     *
     * @return available Pressure characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getPressureCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getPressureEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingConfiguration() {
        return getPressureEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Pressure's ES Configuration
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getPressureEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingMeasurement() {
        return getPressureEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Pressure's ES Measurement
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getPressureEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingTriggerSetting() {
        return getPressureEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Pressure's Trigger Setting
     *
     * @param characteristicIndex Pressure characteristic index
     * @param descriptorIndex     Pressure characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getPressureValidRange(int)
     */
    @Nullable
    public synchronized Integer getPressureValidRange() {
        return getPressureValidRange(0);
    }

    /**
     * get Pressure's Valid Range
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPressureValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canPressureNotify(int)
     */
    public synchronized boolean canPressureNotify() {
        return canPressureNotify(0);
    }

    /**
     * get Pressure characteristic's notify status
     *
     * @param index Pressure characteristic index
     * @return {@code true}:target  Pressure characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canPressureNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasPressureCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasPressureCharacteristicEnvironmentalSensingMeasurement() {
        return hasPressureCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Pressure characteristic's ES Measurement
     *
     * @param index Pressure characteristic index
     * @return {@code true}:target Pressure Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Pressure Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasPressureCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasPressureCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasPressureCharacteristicEnvironmentalSensingConfiguration() {
        return hasPressureCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Pressure characteristic's ES Configuration
     *
     * @param index Pressure characteristic index
     * @return {@code true}:target Pressure Characteristic has ES Configuration Descriptor, {@code false}:target Pressure Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasPressureCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasPressureCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasPressureCharacteristicCharacteristicUserDescription() {
        return hasPressureCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Pressure characteristic's Characteristic User Description
     *
     * @param index Pressure characteristic index
     * @return {@code true}:target Pressure Characteristic has Characteristic User Description Descriptor, {@code false}:target Pressure Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasPressureCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasPressureCharacteristicValidRange(int)
     */
    public synchronized boolean hasPressureCharacteristicValidRange() {
        return hasPressureCharacteristicValidRange(0);
    }

    /**
     * check Pressure characteristic's Valid Range
     *
     * @param index Pressure characteristic index
     * @return {@code true}:target Pressure Characteristic has Valid Range Descriptor, {@code false}:target Pressure Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasPressureCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startPressureNotification(int)
     */
    @Nullable
    public synchronized Integer startPressureNotification() {
        return startPressureNotification(0);
    }

    /**
     * start Pressure notification
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startPressureNotification(int index) {
        Integer taskId = null;
        if (canPressureNotify(index)) {
            EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopPressureNotification(int)
     */
    @Nullable
    public synchronized Integer stopPressureNotification() {
        return stopPressureNotification(0);
    }

    /**
     * stop Pressure notification
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopPressureNotification(int index) {
        Integer taskId = null;
        if (canPressureNotify(index)) {
            EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setPressureEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setPressureEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Pressure's Trigger Setting
     *
     * @param characteristicIndex Pressure characteristic index
     * @param descriptorIndex     Pressure characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setPressureEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setPressureEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Pressure's ES Configuration
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setPressureCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setPressureCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setPressureCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Pressure's Characteristic User Description
     *
     * @param index Pressure characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onPressureCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setPressureCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(PRESSURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getRainfall(int)
     */
    @Nullable
    public synchronized Integer getRainfall() {
        return getRainfall(0);
    }

    /**
     * get Rainfall
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, RainfallAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRainfall(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Rainfall characteristic's ES Trigger Setting count
     *
     * @param index Rainfall characteristic index
     * @return Rainfall characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getRainfallCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getRainfallCharacteristicUserDescription() {
        return getRainfallCharacteristicUserDescription(0);
    }

    /**
     * get Rainfall's Characteristic User Description
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRainfallCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Rainfall characteristic count
     *
     * @return available Rainfall characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getRainfallCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getRainfallEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingConfiguration() {
        return getRainfallEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Rainfall's ES Configuration
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getRainfallEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingMeasurement() {
        return getRainfallEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Rainfall's ES Measurement
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getRainfallEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingTriggerSetting() {
        return getRainfallEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Rainfall's Trigger Setting
     *
     * @param characteristicIndex Rainfall characteristic index
     * @param descriptorIndex     Rainfall characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getRainfallValidRange(int)
     */
    @Nullable
    public synchronized Integer getRainfallValidRange() {
        return getRainfallValidRange(0);
    }

    /**
     * get Rainfall's Valid Range
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRainfallValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canRainfallNotify(int)
     */
    public synchronized boolean canRainfallNotify() {
        return canRainfallNotify(0);
    }

    /**
     * get Rainfall characteristic's notify status
     *
     * @param index Rainfall characteristic index
     * @return {@code true}:target  Rainfall characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canRainfallNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasRainfallCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasRainfallCharacteristicEnvironmentalSensingMeasurement() {
        return hasRainfallCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Rainfall characteristic's ES Measurement
     *
     * @param index Rainfall characteristic index
     * @return {@code true}:target Rainfall Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Rainfall Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasRainfallCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasRainfallCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasRainfallCharacteristicEnvironmentalSensingConfiguration() {
        return hasRainfallCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Rainfall characteristic's ES Configuration
     *
     * @param index Rainfall characteristic index
     * @return {@code true}:target Rainfall Characteristic has ES Configuration Descriptor, {@code false}:target Rainfall Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasRainfallCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasRainfallCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasRainfallCharacteristicCharacteristicUserDescription() {
        return hasRainfallCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Rainfall characteristic's Characteristic User Description
     *
     * @param index Rainfall characteristic index
     * @return {@code true}:target Rainfall Characteristic has Characteristic User Description Descriptor, {@code false}:target Rainfall Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasRainfallCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasRainfallCharacteristicValidRange(int)
     */
    public synchronized boolean hasRainfallCharacteristicValidRange() {
        return hasRainfallCharacteristicValidRange(0);
    }

    /**
     * check Rainfall characteristic's Valid Range
     *
     * @param index Rainfall characteristic index
     * @return {@code true}:target Rainfall Characteristic has Valid Range Descriptor, {@code false}:target Rainfall Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasRainfallCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startRainfallNotification(int)
     */
    @Nullable
    public synchronized Integer startRainfallNotification() {
        return startRainfallNotification(0);
    }

    /**
     * start Rainfall notification
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startRainfallNotification(int index) {
        Integer taskId = null;
        if (canRainfallNotify(index)) {
            EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopRainfallNotification(int)
     */
    @Nullable
    public synchronized Integer stopRainfallNotification() {
        return stopRainfallNotification(0);
    }

    /**
     * stop Rainfall notification
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopRainfallNotification(int index) {
        Integer taskId = null;
        if (canRainfallNotify(index)) {
            EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setRainfallEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setRainfallEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Rainfall's Trigger Setting
     *
     * @param characteristicIndex Rainfall characteristic index
     * @param descriptorIndex     Rainfall characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setRainfallEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setRainfallEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Rainfall's ES Configuration
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setRainfallCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setRainfallCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setRainfallCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Rainfall's Characteristic User Description
     *
     * @param index Rainfall characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onRainfallCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setRainfallCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(RAINFALL_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentration() {
        return getSulfurDioxideConcentration(0);
    }

    /**
     * get Sulfur Dioxide Concentration
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, SulfurDioxideConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Sulfur Dioxide Concentration characteristic's ES Trigger Setting count
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return Sulfur Dioxide Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getSulfurDioxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicUserDescription() {
        return getSulfurDioxideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Sulfur Dioxide Concentration's Characteristic User Description
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Sulfur Dioxide Concentration characteristic count
     *
     * @return available Sulfur Dioxide Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingConfiguration() {
        return getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Sulfur Dioxide Concentration's ES Configuration
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingMeasurement() {
        return getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Sulfur Dioxide Concentration's ES Measurement
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting() {
        return getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Sulfur Dioxide Concentration's Trigger Setting
     *
     * @param characteristicIndex Sulfur Dioxide Concentration characteristic index
     * @param descriptorIndex     Sulfur Dioxide Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationValidRange() {
        return getSulfurDioxideConcentrationValidRange(0);
    }

    /**
     * get Sulfur Dioxide Concentration's Valid Range
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canSulfurDioxideConcentrationNotify(int)
     */
    public synchronized boolean canSulfurDioxideConcentrationNotify() {
        return canSulfurDioxideConcentrationNotify(0);
    }

    /**
     * get Sulfur Dioxide Concentration characteristic's notify status
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return {@code true}:target  Sulfur Dioxide Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canSulfurDioxideConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Sulfur Dioxide Concentration characteristic's ES Measurement
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return {@code true}:target Sulfur Dioxide Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Sulfur Dioxide Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Sulfur Dioxide Concentration characteristic's ES Configuration
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return {@code true}:target Sulfur Dioxide Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Sulfur Dioxide Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Sulfur Dioxide Concentration characteristic's Characteristic User Description
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return {@code true}:target Sulfur Dioxide Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Sulfur Dioxide Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicValidRange() {
        return hasSulfurDioxideConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Sulfur Dioxide Concentration characteristic's Valid Range
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return {@code true}:target Sulfur Dioxide Concentration Characteristic has Valid Range Descriptor, {@code false}:target Sulfur Dioxide Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasSulfurDioxideConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startSulfurDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startSulfurDioxideConcentrationNotification() {
        return startSulfurDioxideConcentrationNotification(0);
    }

    /**
     * start Sulfur Dioxide Concentration notification
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startSulfurDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canSulfurDioxideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopSulfurDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopSulfurDioxideConcentrationNotification() {
        return stopSulfurDioxideConcentrationNotification(0);
    }

    /**
     * stop Sulfur Dioxide Concentration notification
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopSulfurDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canSulfurDioxideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Sulfur Dioxide Concentration's Trigger Setting
     *
     * @param characteristicIndex Sulfur Dioxide Concentration characteristic index
     * @param descriptorIndex     Sulfur Dioxide Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Sulfur Dioxide Concentration's ES Configuration
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setSulfurDioxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setSulfurDioxideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Sulfur Dioxide Concentration's Characteristic User Description
     *
     * @param index Sulfur Dioxide Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurDioxideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentration(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentration() {
        return getSulfurHexafluorideConcentration(0);
    }

    /**
     * get Sulfur Hexafluoride Concentration
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, SulfurHexafluorideConcentrationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Sulfur Hexafluoride Concentration characteristic's ES Trigger Setting count
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return Sulfur Hexafluoride Concentration characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicUserDescription() {
        return getSulfurHexafluorideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * get Sulfur Hexafluoride Concentration's Characteristic User Description
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Sulfur Hexafluoride Concentration characteristic count
     *
     * @return available Sulfur Hexafluoride Concentration characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration() {
        return getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Sulfur Hexafluoride Concentration's ES Configuration
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement() {
        return getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Sulfur Hexafluoride Concentration's ES Measurement
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting() {
        return getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Sulfur Hexafluoride Concentration's Trigger Setting
     *
     * @param characteristicIndex Sulfur Hexafluoride Concentration characteristic index
     * @param descriptorIndex     Sulfur Hexafluoride Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationValidRange() {
        return getSulfurHexafluorideConcentrationValidRange(0);
    }

    /**
     * get Sulfur Hexafluoride Concentration's Valid Range
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canSulfurHexafluorideConcentrationNotify(int)
     */
    public synchronized boolean canSulfurHexafluorideConcentrationNotify() {
        return canSulfurHexafluorideConcentrationNotify(0);
    }

    /**
     * get Sulfur Hexafluoride Concentration characteristic's notify status
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return {@code true}:target  Sulfur Hexafluoride Concentration characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canSulfurHexafluorideConcentrationNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Sulfur Hexafluoride Concentration characteristic's ES Measurement
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return {@code true}:target Sulfur Hexafluoride Concentration Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Sulfur Hexafluoride Concentration Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Sulfur Hexafluoride Concentration characteristic's ES Configuration
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return {@code true}:target Sulfur Hexafluoride Concentration Characteristic has ES Configuration Descriptor, {@code false}:target Sulfur Hexafluoride Concentration Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Sulfur Hexafluoride Concentration characteristic's Characteristic User Description
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return {@code true}:target Sulfur Hexafluoride Concentration Characteristic has Characteristic User Description Descriptor, {@code false}:target Sulfur Hexafluoride Concentration Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicValidRange(int)
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicValidRange() {
        return hasSulfurHexafluorideConcentrationCharacteristicValidRange(0);
    }

    /**
     * check Sulfur Hexafluoride Concentration characteristic's Valid Range
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return {@code true}:target Sulfur Hexafluoride Concentration Characteristic has Valid Range Descriptor, {@code false}:target Sulfur Hexafluoride Concentration Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasSulfurHexafluorideConcentrationCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startSulfurHexafluorideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startSulfurHexafluorideConcentrationNotification() {
        return startSulfurHexafluorideConcentrationNotification(0);
    }

    /**
     * start Sulfur Hexafluoride Concentration notification
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startSulfurHexafluorideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canSulfurHexafluorideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopSulfurHexafluorideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopSulfurHexafluorideConcentrationNotification() {
        return stopSulfurHexafluorideConcentrationNotification(0);
    }

    /**
     * stop Sulfur Hexafluoride Concentration notification
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopSulfurHexafluorideConcentrationNotification(int index) {
        Integer taskId = null;
        if (canSulfurHexafluorideConcentrationNotify(index)) {
            EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Sulfur Hexafluoride Concentration's Trigger Setting
     *
     * @param characteristicIndex Sulfur Hexafluoride Concentration characteristic index
     * @param descriptorIndex     Sulfur Hexafluoride Concentration characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Sulfur Hexafluoride Concentration's ES Configuration
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setSulfurHexafluorideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setSulfurHexafluorideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Sulfur Hexafluoride Concentration's Characteristic User Description
     *
     * @param index Sulfur Hexafluoride Concentration characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onSulfurHexafluorideConcentrationCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getTemperature(int)
     */
    @Nullable
    public synchronized Integer getTemperature() {
        return getTemperature(0);
    }

    /**
     * get Temperature
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, TemperatureAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTemperature(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Temperature characteristic's ES Trigger Setting count
     *
     * @param index Temperature characteristic index
     * @return Temperature characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getTemperatureCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTemperatureCharacteristicUserDescription() {
        return getTemperatureCharacteristicUserDescription(0);
    }

    /**
     * get Temperature's Characteristic User Description
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTemperatureCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Temperature characteristic count
     *
     * @return available Temperature characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getTemperatureCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getTemperatureEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingConfiguration() {
        return getTemperatureEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Temperature's ES Configuration
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingMeasurement() {
        return getTemperatureEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Temperature's ES Measurement
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingTriggerSetting() {
        return getTemperatureEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Temperature's Trigger Setting
     *
     * @param characteristicIndex Temperature characteristic index
     * @param descriptorIndex     Temperature characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureValidRange(int)
     */
    @Nullable
    public synchronized Integer getTemperatureValidRange() {
        return getTemperatureValidRange(0);
    }

    /**
     * get Temperature's Valid Range
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTemperatureValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canTemperatureNotify(int)
     */
    public synchronized boolean canTemperatureNotify() {
        return canTemperatureNotify(0);
    }

    /**
     * get Temperature characteristic's notify status
     *
     * @param index Temperature characteristic index
     * @return {@code true}:target  Temperature characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canTemperatureNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasTemperatureCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasTemperatureCharacteristicEnvironmentalSensingMeasurement() {
        return hasTemperatureCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Temperature characteristic's ES Measurement
     *
     * @param index Temperature characteristic index
     * @return {@code true}:target Temperature Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Temperature Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasTemperatureCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTemperatureCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasTemperatureCharacteristicEnvironmentalSensingConfiguration() {
        return hasTemperatureCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Temperature characteristic's ES Configuration
     *
     * @param index Temperature characteristic index
     * @return {@code true}:target Temperature Characteristic has ES Configuration Descriptor, {@code false}:target Temperature Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasTemperatureCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTemperatureCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasTemperatureCharacteristicCharacteristicUserDescription() {
        return hasTemperatureCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Temperature characteristic's Characteristic User Description
     *
     * @param index Temperature characteristic index
     * @return {@code true}:target Temperature Characteristic has Characteristic User Description Descriptor, {@code false}:target Temperature Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasTemperatureCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTemperatureCharacteristicValidRange(int)
     */
    public synchronized boolean hasTemperatureCharacteristicValidRange() {
        return hasTemperatureCharacteristicValidRange(0);
    }

    /**
     * check Temperature characteristic's Valid Range
     *
     * @param index Temperature characteristic index
     * @return {@code true}:target Temperature Characteristic has Valid Range Descriptor, {@code false}:target Temperature Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasTemperatureCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startTemperatureNotification(int)
     */
    @Nullable
    public synchronized Integer startTemperatureNotification() {
        return startTemperatureNotification(0);
    }

    /**
     * start Temperature notification
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startTemperatureNotification(int index) {
        Integer taskId = null;
        if (canTemperatureNotify(index)) {
            EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopTemperatureNotification(int)
     */
    @Nullable
    public synchronized Integer stopTemperatureNotification() {
        return stopTemperatureNotification(0);
    }

    /**
     * stop Temperature notification
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopTemperatureNotification(int index) {
        Integer taskId = null;
        if (canTemperatureNotify(index)) {
            EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setTemperatureEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setTemperatureEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Temperature's Trigger Setting
     *
     * @param characteristicIndex Temperature characteristic index
     * @param descriptorIndex     Temperature characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setTemperatureEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setTemperatureEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Temperature's ES Configuration
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setTemperatureCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTemperatureCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setTemperatureCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Temperature's Characteristic User Description
     *
     * @param index Temperature characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTemperatureCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTemperatureCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TEMPERATURE_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirection(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirection() {
        return getTrueWindDirection(0);
    }

    /**
     * get True Wind Direction
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, TrueWindDirectionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindDirection(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available True Wind Direction characteristic's ES Trigger Setting count
     *
     * @param index True Wind Direction characteristic index
     * @return True Wind Direction characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getTrueWindDirectionCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCharacteristicUserDescription() {
        return getTrueWindDirectionCharacteristicUserDescription(0);
    }

    /**
     * get True Wind Direction's Characteristic User Description
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available True Wind Direction characteristic count
     *
     * @return available True Wind Direction characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getTrueWindDirectionEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingConfiguration() {
        return getTrueWindDirectionEnvironmentalSensingConfiguration(0);
    }

    /**
     * get True Wind Direction's ES Configuration
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingMeasurement() {
        return getTrueWindDirectionEnvironmentalSensingMeasurement(0);
    }

    /**
     * get True Wind Direction's ES Measurement
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingTriggerSetting() {
        return getTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get True Wind Direction's Trigger Setting
     *
     * @param characteristicIndex True Wind Direction characteristic index
     * @param descriptorIndex     True Wind Direction characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionValidRange(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionValidRange() {
        return getTrueWindDirectionValidRange(0);
    }

    /**
     * get True Wind Direction's Valid Range
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canTrueWindDirectionNotify(int)
     */
    public synchronized boolean canTrueWindDirectionNotify() {
        return canTrueWindDirectionNotify(0);
    }

    /**
     * get True Wind Direction characteristic's notify status
     *
     * @param index True Wind Direction characteristic index
     * @return {@code true}:target  True Wind Direction characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canTrueWindDirectionNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement() {
        return hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check True Wind Direction characteristic's ES Measurement
     *
     * @param index True Wind Direction characteristic index
     * @return {@code true}:target True Wind Direction Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target True Wind Direction Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration() {
        return hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check True Wind Direction characteristic's ES Configuration
     *
     * @param index True Wind Direction characteristic index
     * @return {@code true}:target True Wind Direction Characteristic has ES Configuration Descriptor, {@code false}:target True Wind Direction Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicCharacteristicUserDescription() {
        return hasTrueWindDirectionCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check True Wind Direction characteristic's Characteristic User Description
     *
     * @param index True Wind Direction characteristic index
     * @return {@code true}:target True Wind Direction Characteristic has Characteristic User Description Descriptor, {@code false}:target True Wind Direction Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicValidRange(int)
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicValidRange() {
        return hasTrueWindDirectionCharacteristicValidRange(0);
    }

    /**
     * check True Wind Direction characteristic's Valid Range
     *
     * @param index True Wind Direction characteristic index
     * @return {@code true}:target True Wind Direction Characteristic has Valid Range Descriptor, {@code false}:target True Wind Direction Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasTrueWindDirectionCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startTrueWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer startTrueWindDirectionNotification() {
        return startTrueWindDirectionNotification(0);
    }

    /**
     * start True Wind Direction notification
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startTrueWindDirectionNotification(int index) {
        Integer taskId = null;
        if (canTrueWindDirectionNotify(index)) {
            EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopTrueWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer stopTrueWindDirectionNotification() {
        return stopTrueWindDirectionNotification(0);
    }

    /**
     * stop True Wind Direction notification
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopTrueWindDirectionNotification(int index) {
        Integer taskId = null;
        if (canTrueWindDirectionNotify(index)) {
            EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setTrueWindDirectionEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get True Wind Direction's Trigger Setting
     *
     * @param characteristicIndex True Wind Direction characteristic index
     * @param descriptorIndex     True Wind Direction characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindDirectionEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setTrueWindDirectionEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set True Wind Direction's ES Configuration
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindDirectionCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setTrueWindDirectionCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set True Wind Direction's Characteristic User Description
     *
     * @param index True Wind Direction characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindDirectionCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeed(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeed() {
        return getTrueWindSpeed(0);
    }

    /**
     * get True Wind Speed
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, TrueWindSpeedAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeed(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available True Wind Speed characteristic's ES Trigger Setting count
     *
     * @param index True Wind Speed characteristic index
     * @return True Wind Speed characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getTrueWindSpeedCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCharacteristicUserDescription() {
        return getTrueWindSpeedCharacteristicUserDescription(0);
    }

    /**
     * get True Wind Speed's Characteristic User Description
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available True Wind Speed characteristic count
     *
     * @return available True Wind Speed characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getTrueWindSpeedEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingConfiguration() {
        return getTrueWindSpeedEnvironmentalSensingConfiguration(0);
    }

    /**
     * get True Wind Speed's ES Configuration
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingMeasurement() {
        return getTrueWindSpeedEnvironmentalSensingMeasurement(0);
    }

    /**
     * get True Wind Speed's ES Measurement
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingTriggerSetting() {
        return getTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get True Wind Speed's Trigger Setting
     *
     * @param characteristicIndex True Wind Speed characteristic index
     * @param descriptorIndex     True Wind Speed characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedValidRange(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedValidRange() {
        return getTrueWindSpeedValidRange(0);
    }

    /**
     * get True Wind Speed's Valid Range
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canTrueWindSpeedNotify(int)
     */
    public synchronized boolean canTrueWindSpeedNotify() {
        return canTrueWindSpeedNotify(0);
    }

    /**
     * get True Wind Speed characteristic's notify status
     *
     * @param index True Wind Speed characteristic index
     * @return {@code true}:target  True Wind Speed characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canTrueWindSpeedNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement() {
        return hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check True Wind Speed characteristic's ES Measurement
     *
     * @param index True Wind Speed characteristic index
     * @return {@code true}:target True Wind Speed Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target True Wind Speed Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration() {
        return hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check True Wind Speed characteristic's ES Configuration
     *
     * @param index True Wind Speed characteristic index
     * @return {@code true}:target True Wind Speed Characteristic has ES Configuration Descriptor, {@code false}:target True Wind Speed Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicCharacteristicUserDescription() {
        return hasTrueWindSpeedCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check True Wind Speed characteristic's Characteristic User Description
     *
     * @param index True Wind Speed characteristic index
     * @return {@code true}:target True Wind Speed Characteristic has Characteristic User Description Descriptor, {@code false}:target True Wind Speed Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicValidRange(int)
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicValidRange() {
        return hasTrueWindSpeedCharacteristicValidRange(0);
    }

    /**
     * check True Wind Speed characteristic's Valid Range
     *
     * @param index True Wind Speed characteristic index
     * @return {@code true}:target True Wind Speed Characteristic has Valid Range Descriptor, {@code false}:target True Wind Speed Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasTrueWindSpeedCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startTrueWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer startTrueWindSpeedNotification() {
        return startTrueWindSpeedNotification(0);
    }

    /**
     * start True Wind Speed notification
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startTrueWindSpeedNotification(int index) {
        Integer taskId = null;
        if (canTrueWindSpeedNotify(index)) {
            EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopTrueWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer stopTrueWindSpeedNotification() {
        return stopTrueWindSpeedNotification(0);
    }

    /**
     * stop True Wind Speed notification
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopTrueWindSpeedNotification(int index) {
        Integer taskId = null;
        if (canTrueWindSpeedNotify(index)) {
            EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setTrueWindSpeedEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get True Wind Speed's Trigger Setting
     *
     * @param characteristicIndex True Wind Speed characteristic index
     * @param descriptorIndex     True Wind Speed characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindSpeedEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setTrueWindSpeedEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set True Wind Speed's ES Configuration
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindSpeedCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setTrueWindSpeedCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set True Wind Speed's Characteristic User Description
     *
     * @param index True Wind Speed characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onTrueWindSpeedCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getUVIndex(int)
     */
    @Nullable
    public synchronized Integer getUVIndex() {
        return getUVIndex(0);
    }

    /**
     * get UV Index
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, UVIndexAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUVIndex(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available UV Index characteristic's ES Trigger Setting count
     *
     * @param index UV Index characteristic index
     * @return UV Index characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getUVIndexCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getUVIndexCharacteristicUserDescription() {
        return getUVIndexCharacteristicUserDescription(0);
    }

    /**
     * get UV Index's Characteristic User Description
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUVIndexCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available UV Index characteristic count
     *
     * @return available UV Index characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getUVIndexCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getUVIndexEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingConfiguration() {
        return getUVIndexEnvironmentalSensingConfiguration(0);
    }

    /**
     * get UV Index's ES Configuration
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingMeasurement() {
        return getUVIndexEnvironmentalSensingMeasurement(0);
    }

    /**
     * get UV Index's ES Measurement
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingTriggerSetting() {
        return getUVIndexEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get UV Index's Trigger Setting
     *
     * @param characteristicIndex UV Index characteristic index
     * @param descriptorIndex     UV Index characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexValidRange(int)
     */
    @Nullable
    public synchronized Integer getUVIndexValidRange() {
        return getUVIndexValidRange(0);
    }

    /**
     * get UV Index's Valid Range
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUVIndexValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canUVIndexNotify(int)
     */
    public synchronized boolean canUVIndexNotify() {
        return canUVIndexNotify(0);
    }

    /**
     * get UV Index characteristic's notify status
     *
     * @param index UV Index characteristic index
     * @return {@code true}:target  UV Index characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canUVIndexNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasUVIndexCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasUVIndexCharacteristicEnvironmentalSensingMeasurement() {
        return hasUVIndexCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check UV Index characteristic's ES Measurement
     *
     * @param index UV Index characteristic index
     * @return {@code true}:target UV Index Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target UV Index Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasUVIndexCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasUVIndexCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasUVIndexCharacteristicEnvironmentalSensingConfiguration() {
        return hasUVIndexCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check UV Index characteristic's ES Configuration
     *
     * @param index UV Index characteristic index
     * @return {@code true}:target UV Index Characteristic has ES Configuration Descriptor, {@code false}:target UV Index Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasUVIndexCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasUVIndexCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasUVIndexCharacteristicCharacteristicUserDescription() {
        return hasUVIndexCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check UV Index characteristic's Characteristic User Description
     *
     * @param index UV Index characteristic index
     * @return {@code true}:target UV Index Characteristic has Characteristic User Description Descriptor, {@code false}:target UV Index Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasUVIndexCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasUVIndexCharacteristicValidRange(int)
     */
    public synchronized boolean hasUVIndexCharacteristicValidRange() {
        return hasUVIndexCharacteristicValidRange(0);
    }

    /**
     * check UV Index characteristic's Valid Range
     *
     * @param index UV Index characteristic index
     * @return {@code true}:target UV Index Characteristic has Valid Range Descriptor, {@code false}:target UV Index Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasUVIndexCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startUVIndexNotification(int)
     */
    @Nullable
    public synchronized Integer startUVIndexNotification() {
        return startUVIndexNotification(0);
    }

    /**
     * start UV Index notification
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startUVIndexNotification(int index) {
        Integer taskId = null;
        if (canUVIndexNotify(index)) {
            EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopUVIndexNotification(int)
     */
    @Nullable
    public synchronized Integer stopUVIndexNotification() {
        return stopUVIndexNotification(0);
    }

    /**
     * stop UV Index notification
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopUVIndexNotification(int index) {
        Integer taskId = null;
        if (canUVIndexNotify(index)) {
            EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setUVIndexEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setUVIndexEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get UV Index's Trigger Setting
     *
     * @param characteristicIndex UV Index characteristic index
     * @param descriptorIndex     UV Index characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setUVIndexEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setUVIndexEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set UV Index's ES Configuration
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setUVIndexCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setUVIndexCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setUVIndexCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set UV Index's Characteristic User Description
     *
     * @param index UV Index characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onUVIndexCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setUVIndexCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(UV_INDEX_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getWindChill(int)
     */
    @Nullable
    public synchronized Integer getWindChill() {
        return getWindChill(0);
    }

    /**
     * get Wind Chill
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, WindChillAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWindChill(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristic(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * get available Wind Chill characteristic's ES Trigger Setting count
     *
     * @param index Wind Chill characteristic index
     * @return Wind Chill characteristic's ES Trigger Setting count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
            if (essData != null) {
                List<BluetoothGattDescriptor> descriptorList = essData.mEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                if (descriptorList == null) {
                    count = 0;
                } else {
                    count = descriptorList.size();
                }
            }
        }
        return count;
    }

    /**
     * @see #getWindChillCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getWindChillCharacteristicUserDescription() {
        return getWindChillCharacteristicUserDescription(0);
    }

    /**
     * get Wind Chill's Characteristic User Description
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWindChillCharacteristicUserDescription(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * get available Wind Chill characteristic count
     *
     * @return available Wind Chill characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getWindChillCount() {
        Integer count = null;
        if (isStarted()) {
            EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
            if (essData != null) {
                count = essData.mBluetoothGattCharacteristicList.size();
            }
        }
        return count;
    }

    /**
     * @see #getWindChillEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingConfiguration() {
        return getWindChillEnvironmentalSensingConfiguration(0);
    }

    /**
     * get Wind Chill's ES Configuration
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingConfigurationAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getWindChillEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingMeasurement() {
        return getWindChillEnvironmentalSensingMeasurement(0);
    }

    /**
     * get Wind Chill's ES Measurement
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingMeasurementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, EnvironmentalSensingMeasurementAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingMeasurementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingMeasurementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingEnvironmentalSensingMeasurement(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #getWindChillEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingTriggerSetting() {
        return getWindChillEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * get Wind Chill's Trigger Setting
     *
     * @param characteristicIndex Wind Chill characteristic index
     * @param descriptorIndex     Wind Chill characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingTriggerSettingReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingTriggerSettingReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingTriggerSettingReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap);
        }
        return taskId;
    }

    /**
     * @see #getWindChillValidRange(int)
     */
    @Nullable
    public synchronized Integer getWindChillValidRange() {
        return getWindChillValidRange(0);
    }

    /**
     * get Wind Chill's Valid Range
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, ValidRangeAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWindChillValidRange(int index) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = getEnvironmentalSensingValidRange(index, essData.mBluetoothGattCharacteristicList);
        }
        return taskId;
    }

    /**
     * @see #canWindChillNotify(int)
     */
    public synchronized boolean canWindChillNotify() {
        return canWindChillNotify(0);
    }

    /**
     * get Wind Chill characteristic's notify status
     *
     * @param index Wind Chill characteristic index
     * @return {@code true}:target  Wind Chill characteristic can notify, {@code false}:can not notify
     */
    public synchronized boolean canWindChillNotify(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            if (isStarted() && index >= 0 && index < essData.mBluetoothGattCharacteristicList.size()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = essData.mBluetoothGattCharacteristicList.get(index);
                result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
            }
        }
        return result;
    }

    /**
     * @see #hasWindChillCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized boolean hasWindChillCharacteristicEnvironmentalSensingMeasurement() {
        return hasWindChillCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * check Wind Chill characteristic's ES Measurement
     *
     * @param index Wind Chill characteristic index
     * @return {@code true}:target Wind Chill Characteristic has Characteristic ES Measurement Descriptor, {@code false}:target Wind Chill Characteristic does not have Characteristic ES Measurement Descriptor
     */
    public synchronized boolean hasWindChillCharacteristicEnvironmentalSensingMeasurement(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasWindChillCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized boolean hasWindChillCharacteristicEnvironmentalSensingConfiguration() {
        return hasWindChillCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * check Wind Chill characteristic's ES Configuration
     *
     * @param index Wind Chill characteristic index
     * @return {@code true}:target Wind Chill Characteristic has ES Configuration Descriptor, {@code false}:target Wind Chill Characteristic does not have ES Configuration Descriptor
     */
    public synchronized boolean hasWindChillCharacteristicEnvironmentalSensingConfiguration(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasWindChillCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized boolean hasWindChillCharacteristicCharacteristicUserDescription() {
        return hasWindChillCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * check Wind Chill characteristic's Characteristic User Description
     *
     * @param index Wind Chill characteristic index
     * @return {@code true}:target Wind Chill Characteristic has Characteristic User Description Descriptor, {@code false}:target Wind Chill Characteristic does not have Characteristic User Description Descriptor
     */
    public synchronized boolean hasWindChillCharacteristicCharacteristicUserDescription(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #hasWindChillCharacteristicValidRange(int)
     */
    public synchronized boolean hasWindChillCharacteristicValidRange() {
        return hasWindChillCharacteristicValidRange(0);
    }

    /**
     * check Wind Chill characteristic's Valid Range
     *
     * @param index Wind Chill characteristic index
     * @return {@code true}:target Wind Chill Characteristic has Valid Range Descriptor, {@code false}:target Wind Chill Characteristic does not have Valid Range Descriptor
     */
    public synchronized boolean hasWindChillCharacteristicValidRange(int index) {
        boolean result = false;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            result = getDescriptor(essData.mBluetoothGattCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
        }
        return result;
    }

    /**
     * @see #startWindChillNotification(int)
     */
    @Nullable
    public synchronized Integer startWindChillNotification() {
        return startWindChillNotification(0);
    }

    /**
     * start Wind Chill notification
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startWindChillNotification(int index) {
        Integer taskId = null;
        if (canWindChillNotify(index)) {
            EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, true);
            }
        }
        return taskId;
    }

    /**
     * @see #stopWindChillNotification(int)
     */
    @Nullable
    public synchronized Integer stopWindChillNotification() {
        return stopWindChillNotification(0);
    }

    /**
     * stop Wind Chill notification
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopWindChillNotification(int index) {
        Integer taskId = null;
        if (canWindChillNotify(index)) {
            EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
            if (essData != null) {
                taskId = setEnvironmentalSensingCharacteristicNotification(index, essData.mBluetoothGattCharacteristicList, false);
            }
        }
        return taskId;
    }

    /**
     * @see #setWindChillEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setWindChillEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * get Wind Chill's Trigger Setting
     *
     * @param characteristicIndex Wind Chill characteristic index
     * @param descriptorIndex     Wind Chill characteristic's ES Trigger Setting descriptor index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingTriggerSettingWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, EnvironmentalSensingTriggerSettingAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingTriggerSettingWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillEnvironmentalSensingTriggerSettingWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, essData.mEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #setWindChillEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setWindChillEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * set Wind Chill's ES Configuration
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingEnvironmentalSensingConfiguration(index, essData.mBluetoothGattCharacteristicList, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #setWindChillCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setWindChillCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setWindChillCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * set Wind Chill's Characteristic User Description
     *
     * @param index Wind Chill characteristic index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, CharacteristicUserDescriptionAndroid, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, int, Bundle)
     * @see EnvironmentalSensingServiceCallback#onWindChillCharacteristicUserDescriptionWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setWindChillCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        EssData essData = mEssDataMap.get(WIND_CHILL_CHARACTERISTIC);
        if (essData != null) {
            taskId = setEnvironmentalSensingCharacteristicUserDescription(index, essData.mBluetoothGattCharacteristicList, characteristicUserDescription);
        }
        return taskId;
    }
}