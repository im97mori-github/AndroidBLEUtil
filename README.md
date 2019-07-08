# BLE Advertising Data Parser for Android

## Prerequire
minSdkVersion 19

## How to use
for Manufacturer Specific Data (data type 0xff)

### Kitkat(API 19)
    class TestLeScanCallback implements BluetoothAdapter.LeScanCallback {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
            AdvertisingDataParser parser = builder.build();

            AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(scanRecord);

            StringBuilder sb = new StringBuilder();
            sb.append("data count:");
            sb.append(result.getResultList().size());
            sb.append("\n\n");

            ManufacturerSpecificData manufacturerSpecificData = result.getManufacturerSpecificData();
            if (manufacturerSpecificData != null) {
                sb.append("Manufacturer Specific Data");
                sb.append("\nCompany Identifier Code\n");
                sb.append(manufacturerSpecificData.getCompanyIdentifier());
                sb.append("\nCompany Name\n");
                sb.append(manufacturerSpecificData.getCompanyName());
                sb.append("\nManufacturer Specific Data size\n");
                sb.append(manufacturerSpecificData.getmManufacturerSpecificData().length);
                sb.append("\nManufacturer Specific Data list\n");
                sb.append(Arrays.toString(manufacturerSpecificData.getmManufacturerSpecificData()));
                sb.append("\n\n");
            }
            System.out.println(sb.toString());
        }
    }

### Lolipop(API 21)
    class TestScanCallback extends ScanCallback {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            ScanRecord scanRecord = result.getScanRecord();
            if (scanRecord != null) {
                AdvertisingDataParser.Builder builder = new AdvertisingDataParser.Builder(true);
                AdvertisingDataParser parser = builder.build();

                AdvertisingDataParser.AdvertisingDataParseResult result = parser.parse(scanRecord.getBytes();

                StringBuilder sb = new StringBuilder();
                sb.append("data count:");
                sb.append(result.getResultList().size());
                sb.append("\n\n");

                ManufacturerSpecificData manufacturerSpecificData = result.getManufacturerSpecificData();
                if (manufacturerSpecificData != null) {
                    sb.append("Manufacturer Specific Data");
                    sb.append("\nCompany Identifier Code\n");
                    sb.append(manufacturerSpecificData.getCompanyIdentifier());
                    sb.append("\nCompany Name\n");
                    sb.append(manufacturerSpecificData.getCompanyName());
                    sb.append("\nManufacturer Specific Data size\n");
                    sb.append(manufacturerSpecificData.getmManufacturerSpecificData().length);
                    sb.append("\nManufacturer Specific Data list\n");
                    sb.append(Arrays.toString(manufacturerSpecificData.getmManufacturerSpecificData()));
                    sb.append("\n\n");
                }
                System.out.println(sb.toString());
            }
        }