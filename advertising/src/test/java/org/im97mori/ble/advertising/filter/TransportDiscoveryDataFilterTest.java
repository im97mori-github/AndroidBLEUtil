package org.im97mori.ble.advertising.filter;

import static org.im97mori.ble.constants.DataType.TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.im97mori.ble.TransportDiscoveryServiceUtils;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.TransportDiscoveryDataAndroid;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TransportDiscoveryDataFilterTest extends TestBase {

    @Test
    public void test_001() {
        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(null);
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_002() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = new byte[0];

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_003() {
        byte[] actualData = new byte[5];
        actualData[0] = 4;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(null);
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_004() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = Arrays.copyOf(expectData, expectData.length);

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_101() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = new byte[5];
        actualData[0] = 4;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING;
        actualData[3] = 0;
        actualData[4] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_102() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = new byte[5];
        actualData[0] = 4;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 1;
        actualData[4] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_103() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = new byte[6];
        actualData[0] = 5;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 1;
        actualData[5] = 2;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_201() {
        byte[] expectData = new byte[5];
        expectData[0] = 4;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;

        byte[] actualData = new byte[8];
        actualData[0] = 7;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 0;
        actualData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[6] = 0;
        actualData[7] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_202() {
        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;
        expectData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[6] = 0;
        expectData[7] = 0;

        byte[] actualData = new byte[5];
        actualData[0] = 4;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_203() {
        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;
        expectData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[6] = 0;
        expectData[7] = 0;

        byte[] actualData = new byte[8];
        actualData[0] = 7;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 0;
        actualData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[6] = 0;
        actualData[7] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertTrue(filter.isMatched(result));
    }

    @Test
    public void test_204() {
        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;
        expectData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[6] = 0;
        expectData[7] = 0;

        byte[] actualData = new byte[8];
        actualData[0] = 7;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 0;
        actualData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_WIFI_ALLICANCE_NEIGHBOR_AWARENESS_NETWORKING;
        actualData[6] = 0;
        actualData[7] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_205() {
        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;
        expectData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[6] = 0;
        expectData[7] = 0;

        byte[] actualData = new byte[8];
        actualData[0] = 7;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 0;
        actualData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[6] = 1;
        actualData[7] = 0;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

    @Test
    public void test_206() {
        byte[] expectData = new byte[8];
        expectData[0] = 7;
        expectData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        expectData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[3] = 0;
        expectData[4] = 0;
        expectData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        expectData[6] = 0;
        expectData[7] = 0;

        byte[] actualData = new byte[9];
        actualData[0] = 8;
        actualData[1] = TRANSPORT_DISCOVERY_DATA_DATA_TYPE;
        actualData[2] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[3] = 0;
        actualData[4] = 0;
        actualData[5] = TransportDiscoveryServiceUtils.ORGANIZATION_ID_BLUETOOTH_SIG;
        actualData[6] = 0;
        actualData[7] = 1;
        actualData[8] = 2;

        AdvertisingDataParser parser = new AdvertisingDataParser.Builder(true).build();
        AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(actualData);
        AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult> filter = new TransportDiscoveryDataFilter(TransportDiscoveryDataAndroid.CREATOR.createFromByteArray(expectData));
        assertFalse(filter.isMatched(result));
    }

}
