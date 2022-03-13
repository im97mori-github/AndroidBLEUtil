package org.im97mori.ble.characteristic.u2ae5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ChromaticityInCctAndDuvValuesAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityInCctAndDuvValuesAndroid result = new ChromaticityInCctAndDuvValuesAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt16(data, 0), result.getCorrelatedColorTemperature());
        assertEquals(BLEUtils.createUInt16(data, 2), result.getChromaticityDistanceFromPlanckian());
    }

    @Test
    public void test_constructor_00101() {
        int correlatedColorTemperature = 1;
        int chromaticityDistanceFromPlanckian = 2;

        ChromaticityInCctAndDuvValuesAndroid result = new ChromaticityInCctAndDuvValuesAndroid(correlatedColorTemperature, chromaticityDistanceFromPlanckian);
        assertEquals(correlatedColorTemperature, result.getCorrelatedColorTemperature());
        assertEquals(chromaticityDistanceFromPlanckian, result.getChromaticityDistanceFromPlanckian());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityInCctAndDuvValuesAndroid result1 = new ChromaticityInCctAndDuvValuesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityInCctAndDuvValuesAndroid result2 = ChromaticityInCctAndDuvValuesAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCorrelatedColorTemperature(), result1.getCorrelatedColorTemperature());
        assertEquals(result2.getCorrelatedColorTemperature(), result1.getCorrelatedColorTemperature());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityInCctAndDuvValuesAndroid result1 = new ChromaticityInCctAndDuvValuesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ChromaticityInCctAndDuvValuesAndroid result1 = new ChromaticityInCctAndDuvValuesAndroid(bluetoothGattCharacteristic);
        ChromaticityInCctAndDuvValuesAndroid result2 = ChromaticityInCctAndDuvValuesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
