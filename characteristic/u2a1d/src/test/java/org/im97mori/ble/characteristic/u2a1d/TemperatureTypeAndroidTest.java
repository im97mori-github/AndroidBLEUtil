package org.im97mori.ble.characteristic.u2a1d;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.TemperatureTypeUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TemperatureTypeAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT, result1.getTemperatureTextDescription());
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor010() {
        int temperatureTextDescription = 1;

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(temperatureTextDescription);
        assertEquals(temperatureTextDescription, result1.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureTypeAndroid result2 = TemperatureTypeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureTypeAndroid result1 = new TemperatureTypeAndroid(data);
        TemperatureTypeAndroid result2 = TemperatureTypeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
