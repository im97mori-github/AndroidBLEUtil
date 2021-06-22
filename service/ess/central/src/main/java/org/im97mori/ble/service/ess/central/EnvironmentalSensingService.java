package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEUtilsAndroid;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
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
import static org.im97mori.ble.constants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;
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
     * Apparent Wind Direction Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mApparentWindDirectionCharacteristicList = new LinkedList<>();

    /**
     * Apparent Wind Direction Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Apparent Wind Speed Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mApparentWindSpeedCharacteristicList = new LinkedList<>();

    /**
     * Apparent Wind Speed Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Dew Point Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mDewPointCharacteristicList = new LinkedList<>();

    /**
     * Dew Point Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mDewPointEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Elevation Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mElevationCharacteristicList = new LinkedList<>();

    /**
     * Elevation Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mElevationEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Gust Factor Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mGustFactorCharacteristicList = new LinkedList<>();

    /**
     * Gust Factor Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Heat Index Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mHeatIndexCharacteristicList = new LinkedList<>();

    /**
     * Heat Index Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Humidity Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mHumidityCharacteristicList = new LinkedList<>();

    /**
     * Humidity Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mHumidityEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Irradiance Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mIrradianceCharacteristicList = new LinkedList<>();

    /**
     * Irradiance Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Pollen Concentration Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mPollenConcentrationCharacteristicList = new LinkedList<>();

    /**
     * Pollen Concentration Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Rainfall Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mRainfallCharacteristicList = new LinkedList<>();

    /**
     * Rainfall Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mRainfallEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Pressure Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mPressureCharacteristicList = new LinkedList<>();

    /**
     * Pressure Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mPressureEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Temperature Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mTemperatureCharacteristicList = new LinkedList<>();

    /**
     * Temperature Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * True Wind Direction Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mTrueWindDirectionCharacteristicList = new LinkedList<>();

    /**
     * True Wind Direction Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * True Wind Speed Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mTrueWindSpeedCharacteristicList = new LinkedList<>();

    /**
     * True Wind Speed Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * UV Index Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mUVIndexCharacteristicList = new LinkedList<>();

    /**
     * UV Index Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Wind Chill Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mWindChillCharacteristicList = new LinkedList<>();

    /**
     * Wind Chill Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mWindChillEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Barometric Pressure Trend Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mBarometricPressureTrendCharacteristicList = new LinkedList<>();

    /**
     * Barometric Pressure Trend Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Magnetic Declination Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mMagneticDeclinationCharacteristicList = new LinkedList<>();

    /**
     * Magnetic Declination Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Magnetic Flux Density - 2D Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mMagneticFluxDensity2DCharacteristicList = new LinkedList<>();

    /**
     * Magnetic Flux Density - 2D Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * Magnetic Flux Density - 3D Characteristic list
     */
    private final List<BluetoothGattCharacteristic> mMagneticFluxDensity3DCharacteristicList = new LinkedList<>();

    /**
     * Magnetic Flux Density - 3D Environmental Sensing Trigger Setting Descriptor map
     */
    private final Map<Integer, List<BluetoothGattDescriptor>> mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap = new HashMap<>();

    /**
     * @param bleConnection                       {@link BLEConnection} instance
     * @param environmentalSensingServiceCallback {@link EnvironmentalSensingServiceCallback} instance
     * @param bleCallback                         {@link BLECallback} instance (optional)
     */
    public EnvironmentalSensingService(@NonNull BLEConnection bleConnection, @NonNull EnvironmentalSensingServiceCallback environmentalSensingServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mEnvironmentalSensingServiceCallback = environmentalSensingServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsDescriptorValueChangedCharacteristicSupported = false;
            mApparentWindDirectionCharacteristicList.clear();
            mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mApparentWindSpeedCharacteristicList.clear();
            mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mDewPointCharacteristicList.clear();
            mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mElevationCharacteristicList.clear();
            mElevationEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mGustFactorCharacteristicList.clear();
            mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mHeatIndexCharacteristicList.clear();
            mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mHumidityCharacteristicList.clear();
            mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mIrradianceCharacteristicList.clear();
            mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mPollenConcentrationCharacteristicList.clear();
            mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mRainfallCharacteristicList.clear();
            mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mPressureCharacteristicList.clear();
            mPressureEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mTemperatureCharacteristicList.clear();
            mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mTrueWindDirectionCharacteristicList.clear();
            mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mTrueWindSpeedCharacteristicList.clear();
            mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mUVIndexCharacteristicList.clear();
            mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mWindChillCharacteristicList.clear();
            mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mBarometricPressureTrendCharacteristicList.clear();
            mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mMagneticDeclinationCharacteristicList.clear();
            mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mMagneticFluxDensity2DCharacteristicList.clear();
            mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.clear();
            mMagneticFluxDensity3DCharacteristicList.clear();
            mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.clear();
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
                    BluetoothGattCharacteristic descriptorValueChangedbluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC);
                    if (descriptorValueChangedbluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_INDICATE == descriptorValueChangedbluetoothGattCharacteristic.getProperties()
                            && descriptorValueChangedbluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsDescriptorValueChangedCharacteristicSupported = true;
                    }
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                        if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mApparentWindDirectionCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mApparentWindDirectionCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mApparentWindSpeedCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mApparentWindSpeedCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mDewPointCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mDewPointCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mElevationCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mElevationCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mElevationEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mGustFactorCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mGustFactorCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mHeatIndexCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mHeatIndexCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mHumidityCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mHumidityCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mIrradianceCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mIrradianceCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mPollenConcentrationCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mPollenConcentrationCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mRainfallCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mRainfallCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mPressureCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mPressureCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mPressureEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mTemperatureCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mTemperatureCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mTrueWindDirectionCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mTrueWindDirectionCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mTrueWindSpeedCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mTrueWindSpeedCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mUVIndexCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mUVIndexCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mWindChillCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mWindChillCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mBarometricPressureTrendCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mBarometricPressureTrendCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mMagneticDeclinationCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mMagneticDeclinationCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mMagneticFluxDensity2DCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mMagneticFluxDensity2DCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
                            }
                            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(bluetoothGattDescriptor.getUuid())) {
                                    descriptorList.add(bluetoothGattDescriptor);
                                }
                            }
                        } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)
                                && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mMagneticFluxDensity3DCharacteristicList.add(bluetoothGattCharacteristic);
                            int index = mMagneticFluxDensity3DCharacteristicList.indexOf(bluetoothGattCharacteristic);
                            List<BluetoothGattDescriptor> descriptorList = mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
                            if (descriptorList == null) {
                                descriptorList = new ArrayList<>();
                                mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.put(index, descriptorList);
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
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * get characteristic index
     *
     * @param bluetoothGattCharacteristicList characteristic list
     * @param characteristicInstanceId        task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
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
            if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindDirectionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), ApparentWindDirectionAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindSpeedReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), ApparentWindSpeedAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onDewPointReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), DewPointAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onElevationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), ElevationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onGustFactorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), GustFactorAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHeatIndexReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), HeatIndexAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHumidityReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), HumidityAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onIrradianceReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), IrradianceAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPollenConcentrationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), PollenConcentrationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onRainfallReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), RainfallAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPressureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), PressureAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTemperatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), TemperatureAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindDirectionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), TrueWindDirectionAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindSpeedReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), TrueWindSpeedAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onUVIndexReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), UVIndexAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onWindChillReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), WindChillAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onBarometricPressureTrendReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), BarometricPressureTrendAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticDeclinationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), MagneticDeclinationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), MagneticFluxDensity2DAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), MagneticFluxDensity3DAndroid.CREATOR.createFromByteArray(values), argument);
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
            if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindDirectionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), status, argument);
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindSpeedReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), status, argument);
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onDewPointReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), status, argument);
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onElevationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), status, argument);
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onGustFactorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), status, argument);
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHeatIndexReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), status, argument);
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHumidityReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), status, argument);
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onIrradianceReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), status, argument);
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPollenConcentrationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), status, argument);
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onRainfallReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), status, argument);
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPressureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), status, argument);
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTemperatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), status, argument);
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindDirectionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), status, argument);
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindSpeedReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), status, argument);
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onUVIndexReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), status, argument);
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onWindChillReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), status, argument);
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onBarometricPressureTrendReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), status, argument);
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticDeclinationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), status, argument);
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), status, argument);
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), status, argument);
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
            if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindDirectionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindSpeedReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onDewPointReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onElevationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onGustFactorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHeatIndexReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHumidityReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onIrradianceReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPollenConcentrationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onRainfallReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPressureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTemperatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindDirectionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindSpeedReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onUVIndexReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onWindChillReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onBarometricPressureTrendReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticDeclinationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), timeout, argument);
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * get descriptor index
     *
     * @param bluetoothGattDescriptorList descriptor list
     * @param descriptorInstanceId        task target descriptor incetanceId
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
            } else if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingMeasurementAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, getDescriptorIndex(mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId), EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DCharacteristicUserDescriptionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), descriptorInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
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
            } else if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DCharacteristicUserDescriptionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
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
            } else if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingMeasurementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DCharacteristicUserDescriptionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
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
            } else if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DCharacteristicUserDescriptionWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, CharacteristicUserDescriptionAndroid.CREATOR.createFromByteArray(values), argument);
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
            } else if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, status, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DCharacteristicUserDescriptionWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, status, argument);
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
            } else if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onDewPointCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onElevationCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onGustFactorCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onHumidityCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onIrradianceCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onRainfallCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onPressureCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTemperatureCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onUVIndexCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onWindChillCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                Integer characteristicIndex = getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId);
                if (ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                    Integer descriptorIndex = null;
                    if (characteristicIndex != null) {
                        descriptorIndex = getDescriptorIndex(mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(characteristicIndex), descriptorInstanceId);
                    }
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingTriggerSettingWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, descriptorIndex, timeout, argument);
                } else if (ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DEnvironmentalSensingConfigurationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
                } else if (CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR.equals(descriptorUUID)) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DCharacteristicUserDescriptionWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, characteristicIndex, descriptorInstanceId, timeout, argument);
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
            } else if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindDirectionNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), ApparentWindDirectionAndroid.CREATOR.createFromByteArray(values));
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onApparentWindSpeedNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), ApparentWindSpeedAndroid.CREATOR.createFromByteArray(values));
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onDewPointNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), DewPointAndroid.CREATOR.createFromByteArray(values));
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onElevationNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), ElevationAndroid.CREATOR.createFromByteArray(values));
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onGustFactorNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), GustFactorAndroid.CREATOR.createFromByteArray(values));
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHeatIndexNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), HeatIndexAndroid.CREATOR.createFromByteArray(values));
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onHumidityNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), HumidityAndroid.CREATOR.createFromByteArray(values));
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onIrradianceNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), IrradianceAndroid.CREATOR.createFromByteArray(values));
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPollenConcentrationNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), PollenConcentrationAndroid.CREATOR.createFromByteArray(values));
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onRainfallNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), RainfallAndroid.CREATOR.createFromByteArray(values));
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onPressureNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), PressureAndroid.CREATOR.createFromByteArray(values));
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTemperatureNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), TemperatureAndroid.CREATOR.createFromByteArray(values));
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindDirectionNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), TrueWindDirectionAndroid.CREATOR.createFromByteArray(values));
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onTrueWindSpeedNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), TrueWindSpeedAndroid.CREATOR.createFromByteArray(values));
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onUVIndexNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), UVIndexAndroid.CREATOR.createFromByteArray(values));
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onWindChillNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), WindChillAndroid.CREATOR.createFromByteArray(values));
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onBarometricPressureTrendNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), BarometricPressureTrendAndroid.CREATOR.createFromByteArray(values));
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticDeclinationNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), MagneticDeclinationAndroid.CREATOR.createFromByteArray(values));
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), MagneticFluxDensity2DAndroid.CREATOR.createFromByteArray(values));
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), MagneticFluxDensity3DAndroid.CREATOR.createFromByteArray(values));
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
            if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onDewPointNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onDewPointNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onElevationNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onElevationNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onGustFactorNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onGustFactorNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onHeatIndexNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onHumidityNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onHumidityNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onIrradianceNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onIrradianceNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onRainfallNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onRainfallNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onPressureNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onPressureNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onTemperatureNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onTemperatureNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onUVIndexNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onUVIndexNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onWindChillNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onWindChillNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), argument);
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
            if (APPARENT_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onApparentWindDirectionNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindDirectionCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (APPARENT_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onApparentWindSpeedNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mApparentWindSpeedCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (DEW_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onDewPointNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onDewPointNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mDewPointCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (ELEVATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onElevationNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onElevationNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mElevationCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (GUST_FACTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onGustFactorNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onGustFactorNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mGustFactorCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (HEAT_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onHeatIndexNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onHeatIndexNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHeatIndexCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (HUMIDITY_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onHumidityNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onHumidityNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mHumidityCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (IRRADIANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onIrradianceNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onIrradianceNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mIrradianceCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (POLLEN_CONCENTRATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onPollenConcentrationNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPollenConcentrationCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (RAINFALL_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onRainfallNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onRainfallNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mRainfallCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onPressureNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onPressureNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mPressureCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onTemperatureNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onTemperatureNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTemperatureCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (TRUE_WIND_DIRECTION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onTrueWindDirectionNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindDirectionCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (TRUE_WIND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onTrueWindSpeedNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mTrueWindSpeedCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (UV_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onUVIndexNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onUVIndexNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mUVIndexCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (WIND_CHILL_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onWindChillNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onWindChillNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mWindChillCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onBarometricPressureTrendNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mBarometricPressureTrendCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (MAGNETIC_DECLINATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onMagneticDeclinationNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticDeclinationCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity2DNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity2DCharacteristicList, characteristicInstanceId), status, argument);
                }
            } else if (MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC.equals(characteristicUUID)) {
                if (notificationStatus) {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), status, argument);
                } else {
                    mEnvironmentalSensingServiceCallback.onMagneticFluxDensity3DNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getCharacteristicIndex(mMagneticFluxDensity3DCharacteristicList, characteristicInstanceId), status, argument);
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
     * @param characteristicList one of {@link #mApparentWindDirectionCharacteristicList}
     *                           {@link #mApparentWindSpeedCharacteristicList}
     *                           {@link #mDewPointCharacteristicList}
     *                           {@link #mElevationCharacteristicList}
     *                           {@link #mGustFactorCharacteristicList}
     *                           {@link #mHeatIndexCharacteristicList}
     *                           {@link #mHumidityCharacteristicList}
     *                           {@link #mIrradianceCharacteristicList}
     *                           {@link #mPollenConcentrationCharacteristicList}
     *                           {@link #mRainfallCharacteristicList}
     *                           {@link #mPressureCharacteristicList}
     *                           {@link #mTemperatureCharacteristicList}
     *                           {@link #mTrueWindDirectionCharacteristicList}
     *                           {@link #mTrueWindSpeedCharacteristicList}
     *                           {@link #mUVIndexCharacteristicList}
     *                           {@link #mWindChillCharacteristicList}
     *                           {@link #mBarometricPressureTrendCharacteristicList}
     *                           {@link #mMagneticDeclinationCharacteristicList}
     *                           {@link #mMagneticFluxDensity2DCharacteristicList}
     *                           {@link #mMagneticFluxDensity3DCharacteristicList}
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
     * get available Apparent Wind Direction characteristic count
     *
     * @return available Apparent Wind Direction characteristic count. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCount() {
        Integer count = null;
        if (isStarted()) {
            count = mApparentWindDirectionCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isApparentWindDirectionNotificatable(int)
     */
    public synchronized boolean isApparentWindDirectionNotificatable() {
        return isApparentWindDirectionNotificatable(0);
    }

    /**
     * get Apparent Wind Direction characteristic's notificatable status
     *
     * @param index Apparent Wind Direction characteristic index
     * @return {@code true}:target  Apparent Wind Direction characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isApparentWindDirectionNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mApparentWindDirectionCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mApparentWindDirectionCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mApparentWindDirectionCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mApparentWindDirectionCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mApparentWindDirectionCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mApparentWindDirectionCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mApparentWindSpeedCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isApparentWindSpeedNotificatable(int)
     */
    public synchronized boolean isApparentWindSpeedNotificatable() {
        return isApparentWindSpeedNotificatable(0);
    }

    /**
     * get Apparent Wind Speed characteristic's notificatable status
     *
     * @param index Apparent Wind Speed characteristic index
     * @return {@code true}:target  Apparent Wind Speed characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isApparentWindSpeedNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mApparentWindSpeedCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mApparentWindSpeedCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mApparentWindSpeedCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mApparentWindSpeedCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mApparentWindSpeedCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mApparentWindSpeedCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mDewPointCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isDewPointNotificatable(int)
     */
    public synchronized boolean isDewPointNotificatable() {
        return isDewPointNotificatable(0);
    }

    /**
     * get Dew Point characteristic's notificatable status
     *
     * @param index Dew Point characteristic index
     * @return {@code true}:target  Dew Point characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isDewPointNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mDewPointCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mDewPointCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mDewPointCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mDewPointEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mDewPointCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mDewPointCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mDewPointCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mElevationCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isElevationNotificatable(int)
     */
    public synchronized boolean isElevationNotificatable() {
        return isElevationNotificatable(0);
    }

    /**
     * get Elevation characteristic's notificatable status
     *
     * @param index Elevation characteristic index
     * @return {@code true}:target  Elevation characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isElevationNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mElevationCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mElevationCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mElevationCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mElevationEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mElevationCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mElevationCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mElevationCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mGustFactorCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isGustFactorNotificatable(int)
     */
    public synchronized boolean isGustFactorNotificatable() {
        return isGustFactorNotificatable(0);
    }

    /**
     * get Gust Factor characteristic's notificatable status
     *
     * @param index Gust Factor characteristic index
     * @return {@code true}:target  Gust Factor characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isGustFactorNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mGustFactorCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mGustFactorCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mGustFactorCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mGustFactorCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mGustFactorCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mGustFactorCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mHeatIndexCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isHeatIndexNotificatable(int)
     */
    public synchronized boolean isHeatIndexNotificatable() {
        return isHeatIndexNotificatable(0);
    }

    /**
     * get Heat Index characteristic's notificatable status
     *
     * @param index Heat Index characteristic index
     * @return {@code true}:target  Heat Index characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isHeatIndexNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mHeatIndexCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mHeatIndexCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mHeatIndexCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mHeatIndexCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mHeatIndexCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mHeatIndexCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mHumidityCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isHumidityNotificatable(int)
     */
    public synchronized boolean isHumidityNotificatable() {
        return isHumidityNotificatable(0);
    }

    /**
     * get Humidity characteristic's notificatable status
     *
     * @param index Humidity characteristic index
     * @return {@code true}:target  Humidity characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isHumidityNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mHumidityCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mHumidityCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mHumidityCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mHumidityEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mHumidityCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mHumidityCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mHumidityCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mIrradianceCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isIrradianceNotificatable(int)
     */
    public synchronized boolean isIrradianceNotificatable() {
        return isIrradianceNotificatable(0);
    }

    /**
     * get Irradiance characteristic's notificatable status
     *
     * @param index Irradiance characteristic index
     * @return {@code true}:target  Irradiance characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isIrradianceNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mIrradianceCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mIrradianceCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mIrradianceCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mIrradianceCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mIrradianceCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mIrradianceCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mPollenConcentrationCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isPollenConcentrationNotificatable(int)
     */
    public synchronized boolean isPollenConcentrationNotificatable() {
        return isPollenConcentrationNotificatable(0);
    }

    /**
     * get Pollen Concentration characteristic's notificatable status
     *
     * @param index Pollen Concentration characteristic index
     * @return {@code true}:target  Pollen Concentration characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isPollenConcentrationNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mPollenConcentrationCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mPollenConcentrationCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mPollenConcentrationCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mPollenConcentrationCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mPollenConcentrationCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mPollenConcentrationCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mRainfallCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isRainfallNotificatable(int)
     */
    public synchronized boolean isRainfallNotificatable() {
        return isRainfallNotificatable(0);
    }

    /**
     * get Rainfall characteristic's notificatable status
     *
     * @param index Rainfall characteristic index
     * @return {@code true}:target  Rainfall characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isRainfallNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mRainfallCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mRainfallCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mRainfallCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mRainfallEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mRainfallCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mRainfallCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mRainfallCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mPressureCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isPressureNotificatable(int)
     */
    public synchronized boolean isPressureNotificatable() {
        return isPressureNotificatable(0);
    }

    /**
     * get Pressure characteristic's notificatable status
     *
     * @param index Pressure characteristic index
     * @return {@code true}:target  Pressure characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isPressureNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mPressureCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mPressureCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mPressureCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mPressureEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mPressureCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mPressureCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mPressureCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mTemperatureCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isTemperatureNotificatable(int)
     */
    public synchronized boolean isTemperatureNotificatable() {
        return isTemperatureNotificatable(0);
    }

    /**
     * get Temperature characteristic's notificatable status
     *
     * @param index Temperature characteristic index
     * @return {@code true}:target  Temperature characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isTemperatureNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mTemperatureCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mTemperatureCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mTemperatureCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mTemperatureCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mTemperatureCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mTemperatureCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mTrueWindDirectionCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isTrueWindDirectionNotificatable(int)
     */
    public synchronized boolean isTrueWindDirectionNotificatable() {
        return isTrueWindDirectionNotificatable(0);
    }

    /**
     * get True Wind Direction characteristic's notificatable status
     *
     * @param index True Wind Direction characteristic index
     * @return {@code true}:target  True Wind Direction characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isTrueWindDirectionNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mTrueWindDirectionCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mTrueWindDirectionCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mTrueWindDirectionCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mTrueWindDirectionCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mTrueWindDirectionCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mTrueWindDirectionCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mTrueWindSpeedCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isTrueWindSpeedNotificatable(int)
     */
    public synchronized boolean isTrueWindSpeedNotificatable() {
        return isTrueWindSpeedNotificatable(0);
    }

    /**
     * get True Wind Speed characteristic's notificatable status
     *
     * @param index True Wind Speed characteristic index
     * @return {@code true}:target  True Wind Speed characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isTrueWindSpeedNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mTrueWindSpeedCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mTrueWindSpeedCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mTrueWindSpeedCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mTrueWindSpeedCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mTrueWindSpeedCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mTrueWindSpeedCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mUVIndexCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isUVIndexNotificatable(int)
     */
    public synchronized boolean isUVIndexNotificatable() {
        return isUVIndexNotificatable(0);
    }

    /**
     * get UV Index characteristic's notificatable status
     *
     * @param index UV Index characteristic index
     * @return {@code true}:target  UV Index characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isUVIndexNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mUVIndexCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mUVIndexCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mUVIndexCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mUVIndexCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mUVIndexCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mUVIndexCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mWindChillCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isWindChillNotificatable(int)
     */
    public synchronized boolean isWindChillNotificatable() {
        return isWindChillNotificatable(0);
    }

    /**
     * get Wind Chill characteristic's notificatable status
     *
     * @param index Wind Chill characteristic index
     * @return {@code true}:target  Wind Chill characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isWindChillNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mWindChillCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mWindChillCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mWindChillCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mWindChillEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mWindChillCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mWindChillCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mWindChillCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mBarometricPressureTrendCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isBarometricPressureTrendNotificatable(int)
     */
    public synchronized boolean isBarometricPressureTrendNotificatable() {
        return isBarometricPressureTrendNotificatable(0);
    }

    /**
     * get Barometric Pressure Trend characteristic's notificatable status
     *
     * @param index Barometric Pressure Trend characteristic index
     * @return {@code true}:target  Barometric Pressure Trend characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isBarometricPressureTrendNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mBarometricPressureTrendCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mBarometricPressureTrendCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mBarometricPressureTrendCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mBarometricPressureTrendCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mBarometricPressureTrendCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mBarometricPressureTrendCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mMagneticDeclinationCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isMagneticDeclinationNotificatable(int)
     */
    public synchronized boolean isMagneticDeclinationNotificatable() {
        return isMagneticDeclinationNotificatable(0);
    }

    /**
     * get Magnetic Declination characteristic's notificatable status
     *
     * @param index Magnetic Declination characteristic index
     * @return {@code true}:target  Magnetic Declination characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isMagneticDeclinationNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mMagneticDeclinationCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mMagneticDeclinationCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mMagneticDeclinationCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mMagneticDeclinationCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mMagneticDeclinationCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mMagneticDeclinationCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mMagneticFluxDensity2DCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isMagneticFluxDensity2DNotificatable(int)
     */
    public synchronized boolean isMagneticFluxDensity2DNotificatable() {
        return isMagneticFluxDensity2DNotificatable(0);
    }

    /**
     * get Magnetic Flux Density - 2D characteristic's notificatable status
     *
     * @param index Magnetic Flux Density - 2D characteristic index
     * @return {@code true}:target  Magnetic Flux Density - 2D characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isMagneticFluxDensity2DNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mMagneticFluxDensity2DCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mMagneticFluxDensity2DCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mMagneticFluxDensity2DCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mMagneticFluxDensity2DCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mMagneticFluxDensity2DCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mMagneticFluxDensity2DCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
            count = mMagneticFluxDensity3DCharacteristicList.size();
        }
        return count;
    }

    /**
     * @see #isMagneticFluxDensity3DNotificatable(int)
     */
    public synchronized boolean isMagneticFluxDensity3DNotificatable() {
        return isMagneticFluxDensity3DNotificatable(0);
    }

    /**
     * get Magnetic Flux Density - 3D characteristic's notificatable status
     *
     * @param index Magnetic Flux Density - 3D characteristic index
     * @return {@code true}:target  Magnetic Flux Density - 3D characteristic is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isMagneticFluxDensity3DNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mMagneticFluxDensity3DCharacteristicList.size()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = mMagneticFluxDensity3DCharacteristicList.get(index);
            result = (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
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
        return getDescriptor(mMagneticFluxDensity3DCharacteristicList, ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, index) != null;
    }

    /**
     * @see #getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
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
            List<BluetoothGattDescriptor> descriptorList = mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap.get(index);
            if (descriptorList == null) {
                count = 0;
            } else {
                count = descriptorList.size();
            }
        }
        return count;
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
        return getDescriptor(mMagneticFluxDensity3DCharacteristicList, ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mMagneticFluxDensity3DCharacteristicList, CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, index) != null;
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
        return getDescriptor(mMagneticFluxDensity3DCharacteristicList, VALID_RANGE_DESCRIPTOR, index) != null;
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
                    taskId = mBLEConnection.createSetNotificationTask(ENVIRONMENTAL_SENSING_SERVICE
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
        return getEnvironmentalSensingCharacteristic(index, mApparentWindDirectionCharacteristicList);
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
        if (isApparentWindDirectionNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mApparentWindDirectionCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startApparentWindDirectionNotification(int)
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
        if (isApparentWindDirectionNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mApparentWindDirectionCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mApparentWindDirectionCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mApparentWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mApparentWindDirectionCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mApparentWindDirectionCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mApparentWindDirectionCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mApparentWindDirectionCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mApparentWindDirectionCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mApparentWindSpeedCharacteristicList);
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
        if (isApparentWindSpeedNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mApparentWindSpeedCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startApparentWindSpeedNotification(int)
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
        if (isApparentWindSpeedNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mApparentWindSpeedCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mApparentWindSpeedCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mApparentWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mApparentWindSpeedCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mApparentWindSpeedCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mApparentWindSpeedCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mApparentWindSpeedCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mApparentWindSpeedCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mDewPointCharacteristicList);
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
        if (isDewPointNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mDewPointCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startDewPointNotification(int)
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
        if (isDewPointNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mDewPointCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mDewPointCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mDewPointEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mDewPointEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mDewPointCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mDewPointCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mDewPointCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mDewPointCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mDewPointCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mElevationCharacteristicList);
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
        if (isElevationNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mElevationCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startElevationNotification(int)
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
        if (isElevationNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mElevationCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mElevationCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mElevationEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mElevationEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mElevationCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mElevationCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mElevationCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mElevationCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mElevationCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mGustFactorCharacteristicList);
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
        if (isGustFactorNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mGustFactorCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startGustFactorNotification(int)
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
        if (isGustFactorNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mGustFactorCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mGustFactorCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mGustFactorEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mGustFactorCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mGustFactorCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mGustFactorCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mGustFactorCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mGustFactorCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mHeatIndexCharacteristicList);
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
        if (isHeatIndexNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mHeatIndexCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startHeatIndexNotification(int)
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
        if (isHeatIndexNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mHeatIndexCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mHeatIndexCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mHeatIndexEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mHeatIndexCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mHeatIndexCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mHeatIndexCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mHeatIndexCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mHeatIndexCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mHumidityCharacteristicList);
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
        if (isHumidityNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mHumidityCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startHumidityNotification(int)
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
        if (isHumidityNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mHumidityCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mHumidityCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mHumidityEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mHumidityEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mHumidityCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mHumidityCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mHumidityCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mHumidityCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mHumidityCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mIrradianceCharacteristicList);
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
        if (isIrradianceNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mIrradianceCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startIrradianceNotification(int)
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
        if (isIrradianceNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mIrradianceCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mIrradianceCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mIrradianceEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mIrradianceCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mIrradianceCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mIrradianceCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mIrradianceCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mIrradianceCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mPollenConcentrationCharacteristicList);
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
        if (isPollenConcentrationNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mPollenConcentrationCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startPollenConcentrationNotification(int)
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
        if (isPollenConcentrationNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mPollenConcentrationCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mPollenConcentrationCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mPollenConcentrationEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mPollenConcentrationCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mPollenConcentrationCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mPollenConcentrationCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mPollenConcentrationCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mPollenConcentrationCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mRainfallCharacteristicList);
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
        if (isRainfallNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mRainfallCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startRainfallNotification(int)
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
        if (isRainfallNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mRainfallCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mRainfallCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mRainfallEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mRainfallEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mRainfallCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mRainfallCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mRainfallCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mRainfallCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mRainfallCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mPressureCharacteristicList);
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
        if (isPressureNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mPressureCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startPressureNotification(int)
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
        if (isPressureNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mPressureCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mPressureCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mPressureEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mPressureEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mPressureCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mPressureCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mPressureCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mPressureCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mPressureCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mTemperatureCharacteristicList);
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
        if (isTemperatureNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mTemperatureCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startTemperatureNotification(int)
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
        if (isTemperatureNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mTemperatureCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mTemperatureCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mTemperatureEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mTemperatureCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mTemperatureCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mTemperatureCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mTemperatureCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mTemperatureCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mTrueWindDirectionCharacteristicList);
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
        if (isTrueWindDirectionNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mTrueWindDirectionCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startTrueWindDirectionNotification(int)
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
        if (isTrueWindDirectionNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mTrueWindDirectionCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mTrueWindDirectionCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mTrueWindDirectionEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mTrueWindDirectionCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mTrueWindDirectionCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mTrueWindDirectionCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mTrueWindDirectionCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mTrueWindDirectionCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mTrueWindSpeedCharacteristicList);
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
        if (isTrueWindSpeedNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mTrueWindSpeedCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startTrueWindSpeedNotification(int)
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
        if (isTrueWindSpeedNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mTrueWindSpeedCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mTrueWindSpeedCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mTrueWindSpeedEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mTrueWindSpeedCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mTrueWindSpeedCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mTrueWindSpeedCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mTrueWindSpeedCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mTrueWindSpeedCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mUVIndexCharacteristicList);
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
        if (isUVIndexNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mUVIndexCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startUVIndexNotification(int)
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
        if (isUVIndexNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mUVIndexCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mUVIndexCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mUVIndexEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mUVIndexCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mUVIndexCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mUVIndexCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mUVIndexCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mUVIndexCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mWindChillCharacteristicList);
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
        if (isWindChillNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mWindChillCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startWindChillNotification(int)
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
        if (isWindChillNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mWindChillCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mWindChillCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mWindChillEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mWindChillEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mWindChillCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mWindChillCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mWindChillCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mWindChillCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mWindChillCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mBarometricPressureTrendCharacteristicList);
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
        if (isBarometricPressureTrendNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mBarometricPressureTrendCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startBarometricPressureTrendNotification(int)
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
        if (isBarometricPressureTrendNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mBarometricPressureTrendCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mBarometricPressureTrendCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mBarometricPressureTrendEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mBarometricPressureTrendCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mBarometricPressureTrendCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mBarometricPressureTrendCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mBarometricPressureTrendCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mBarometricPressureTrendCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mMagneticDeclinationCharacteristicList);
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
        if (isMagneticDeclinationNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mMagneticDeclinationCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startMagneticDeclinationNotification(int)
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
        if (isMagneticDeclinationNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mMagneticDeclinationCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mMagneticDeclinationCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mMagneticDeclinationEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mMagneticDeclinationCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mMagneticDeclinationCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mMagneticDeclinationCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mMagneticDeclinationCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mMagneticDeclinationCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mMagneticFluxDensity2DCharacteristicList);
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
        if (isMagneticFluxDensity2DNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mMagneticFluxDensity2DCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startMagneticFluxDensity2DNotification(int)
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
        if (isMagneticFluxDensity2DNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mMagneticFluxDensity2DCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mMagneticFluxDensity2DCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mMagneticFluxDensity2DEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mMagneticFluxDensity2DCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mMagneticFluxDensity2DCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mMagneticFluxDensity2DCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mMagneticFluxDensity2DCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mMagneticFluxDensity2DCharacteristicList);
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
        return getEnvironmentalSensingCharacteristic(index, mMagneticFluxDensity3DCharacteristicList);
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
        if (isMagneticFluxDensity3DNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mMagneticFluxDensity3DCharacteristicList, true);
        }
        return taskId;
    }

    /**
     * @see #startMagneticFluxDensity3DNotification(int)
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
        if (isMagneticFluxDensity3DNotificatable(index)) {
            taskId = setEnvironmentalSensingCharacteristicNotification(index, mMagneticFluxDensity3DCharacteristicList, false);
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
        return getEnvironmentalSensingEnvironmentalSensingMeasurement(index, mMagneticFluxDensity3DCharacteristicList);
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
        return getEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap);
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
        return setEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, mMagneticFluxDensity3DEnvironmentalSensingTriggerSettingDescriptorMap, environmentalSensingTriggerSetting);
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
        return getEnvironmentalSensingEnvironmentalSensingConfiguration(index, mMagneticFluxDensity3DCharacteristicList);
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
        return setEnvironmentalSensingEnvironmentalSensingConfiguration(index, mMagneticFluxDensity3DCharacteristicList, environmentalSensingConfiguration);
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
        return getEnvironmentalSensingCharacteristicUserDescription(index, mMagneticFluxDensity3DCharacteristicList);
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
        return setEnvironmentalSensingCharacteristicUserDescription(index, mMagneticFluxDensity3DCharacteristicList, characteristicUserDescription);
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
        return getEnvironmentalSensingValidRange(index, mMagneticFluxDensity3DCharacteristicList);
    }

}
