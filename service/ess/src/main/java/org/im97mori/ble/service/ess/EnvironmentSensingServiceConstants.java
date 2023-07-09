package org.im97mori.ble.service.ess;

import static org.im97mori.ble.constants.CharacteristicUUID.AMMONIA_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC;
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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * ESS Characteristic Constant class
 */
public class EnvironmentSensingServiceConstants {

    /**
     * ESS Characteristic set
     */
    public static final Set<UUID> ESS_UUID_SET;

    static {
        Set<UUID> set = new HashSet<>();
        set.add(MAGNETIC_DECLINATION_CHARACTERISTIC);
        set.add(ELEVATION_CHARACTERISTIC);
        set.add(PRESSURE_CHARACTERISTIC);
        set.add(TEMPERATURE_CHARACTERISTIC);
        set.add(HUMIDITY_CHARACTERISTIC);
        set.add(TRUE_WIND_SPEED_CHARACTERISTIC);
        set.add(TRUE_WIND_DIRECTION_CHARACTERISTIC);
        set.add(APPARENT_WIND_SPEED_CHARACTERISTIC);
        set.add(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
        set.add(GUST_FACTOR_CHARACTERISTIC);
        set.add(POLLEN_CONCENTRATION_CHARACTERISTIC);
        set.add(UV_INDEX_CHARACTERISTIC);
        set.add(IRRADIANCE_CHARACTERISTIC);
        set.add(RAINFALL_CHARACTERISTIC);
        set.add(WIND_CHILL_CHARACTERISTIC);
        set.add(HEAT_INDEX_CHARACTERISTIC);
        set.add(DEW_POINT_CHARACTERISTIC);
        set.add(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
        set.add(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
        set.add(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
        set.add(AMMONIA_CONCENTRATION_CHARACTERISTIC);
        set.add(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC);
        set.add(METHANE_CONCENTRATION_CHARACTERISTIC);
        set.add(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        set.add(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC);
        set.add(OZONE_CONCENTRATION_CHARACTERISTIC);
        set.add(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC);
        set.add(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC);
        set.add(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC);
        set.add(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC);
        set.add(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC);
        ESS_UUID_SET = Collections.synchronizedSet(Collections.unmodifiableSet(set));
    }

    /**
     * ESS Characteristic upper camel case name map
     */
    public static final Map<UUID, String> ESS_UPPER_CASE_NAME_MAP;

    static {
        Map<UUID, String> map = new HashMap<>();
        map.put(MAGNETIC_DECLINATION_CHARACTERISTIC, "MagneticDeclination");
        map.put(ELEVATION_CHARACTERISTIC, "Elevation");
        map.put(PRESSURE_CHARACTERISTIC, "Pressure");
        map.put(TEMPERATURE_CHARACTERISTIC, "Temperature");
        map.put(HUMIDITY_CHARACTERISTIC, "Humidity");
        map.put(TRUE_WIND_SPEED_CHARACTERISTIC, "TrueWindSpeed");
        map.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, "TrueWindDirection");
        map.put(APPARENT_WIND_SPEED_CHARACTERISTIC, "ApparentWindSpeed");
        map.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, "ApparentWindDirection");
        map.put(GUST_FACTOR_CHARACTERISTIC, "GustFactor");
        map.put(POLLEN_CONCENTRATION_CHARACTERISTIC, "PollenConcentration");
        map.put(UV_INDEX_CHARACTERISTIC, "UVIndex");
        map.put(IRRADIANCE_CHARACTERISTIC, "Irradiance");
        map.put(RAINFALL_CHARACTERISTIC, "Rainfall");
        map.put(WIND_CHILL_CHARACTERISTIC, "WindChill");
        map.put(HEAT_INDEX_CHARACTERISTIC, "HeatIndex");
        map.put(DEW_POINT_CHARACTERISTIC, "DewPoint");
        map.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, "MagneticFluxDensity2D");
        map.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, "MagneticFluxDensity3D");
        map.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, "BarometricPressureTrend");
        map.put(AMMONIA_CONCENTRATION_CHARACTERISTIC, "AmmoniaConcentration");
        map.put(CARBON_MONOXIDE_CONCENTRATION_CHARACTERISTIC, "CarbonMonoxideConcentration");
        map.put(METHANE_CONCENTRATION_CHARACTERISTIC, "MethaneConcentration");
        map.put(NITROGEN_DIOXIDE_CONCENTRATION_CHARACTERISTIC, "NitrogenDioxideConcentration");
        map.put(NON_METHANE_VOLATILE_ORGANIC_COMPOUNDS_CONCENTRATION_CHARACTERISTIC, "NonMethaneVolatileOrganicCompoundsConcentration");
        map.put(OZONE_CONCENTRATION_CHARACTERISTIC, "OzoneConcentration");
        map.put(PARTICULATE_MATTER_PM1_CONCENTRATION_CHARACTERISTIC, "ParticulateMatterPm1Concentration");
        map.put(PARTICULATE_MATTER_PM2_5_CONCENTRATION_CHARACTERISTIC, "ParticulateMatterPm25Concentration");
        map.put(PARTICULATE_MATTER_PM10_CONCENTRATION_CHARACTERISTIC, "ParticulateMatterPm10Concentration");
        map.put(SULFUR_DIOXIDE_CONCENTRATION_CHARACTERISTIC, "SulfurDioxideConcentration");
        map.put(SULFUR_HEXAFLUORIDE_CONCENTRATION_CHARACTERISTIC, "SulfurHexafluorideConcentration");
        ESS_UPPER_CASE_NAME_MAP = Collections.synchronizedMap(Collections.unmodifiableMap(map));
    }
}
