# Simple Advertising data parser and BLE Connection for Android

see [https://github.com/im97mori-github/AndroidBLEUtil/wiki](https://github.com/im97mori-github/AndroidBLEUtil/wiki)

## Prerequire
### Central feature
minSdkVersion 18
### Peripheral feature
minSdkVersion 21

## Download
project/build.gradle

    repositories {
        maven { url "https://github.com/im97mori-github/maven/raw/master" }
        google()
        mavenCentral()
    }

project/module/build.gradle

    def version = '0.6.0'
    dependencies {
        // Core package(Constants + Utility)
        implementation 'org.im97mori:ble-core-android:${version}'
        
        // Advertising classes
        // org.im97mori:ble-advertising with Parcelable interface
        implementation 'org.im97mori:ble-advertising-android:${version}'
        
        // Characteristic package
        
        // All available characteristic package
        // org.im97mori:ble-characteristic with Parcelable interface
        implementation 'org.im97mori:ble-characteristic-android:${version}'
        
        // Characteristic utility classes
        implementation 'org.im97mori:ble-characteristic-core-android:${version}'
        
        // Individual characteristic class
        // XXXX is characteristic 16bit UUID(hexadecimal)
        // org.im97mori:ble-characteristic-uXXXX with Parcelable interface
        implementation 'org.im97mori:ble-characteristic-uXXXX-android:${version}'
        
        // ex) Device Name characteristic(UUID 0x2a00)
        implementation 'org.im97mori:ble-characteristic-u2a00-android:${version}'
        
        // Descriptor package
        
        // All available descriptor package
        // org.im97mori:ble-descriptor with Parcelable interface
        implementation 'org.im97mori:ble-descriptor-android:${version}'
        
        // Individual descriptor class
        // XXXX is descriptor 16bit UUID(hexadecimal)
        // org.im97mori:ble-descriptor-uXXXX with Parcelable interface
        implementation 'org.im97mori:ble-descriptor-uXXXX-android:${version}'
        
        // ex) Client Characteristic Configuration descriptor(UUID 0x2902)
        implementation 'org.im97mori:ble-descriptor-u2902-android:${version}'
        
        // Central feature
        implementation 'org.im97mori:ble-central:0.7.9'
        
        // Peripheral feature
        implementation 'org.im97mori:ble-peripheral:0.3.9'
        
        // Service package
        
        // All available service package
        implementation 'org.im97mori:ble-service-android:${version}'
        
        // Individual service package
        // Central + Peripheral
        // XXX is shortened service name
        implementation 'ble-service-XXX-android:${version}'
        implementation 'ble-service-central-XXX-android:${version}' // central only
        implementation 'ble-service-peripheral-XXX-android:${version}' // peripheral only

        // Peripheral package
        
        // All available profile package
        implementation 'org.im97mori:ble-profile-android:${version}'
        
        // Individual profile package
        // Central + Peripheral
        // XXX is shortened profile name
        implementation 'ble-profile-XXX-android:${version}'
        implementation 'ble-profile-central-XXX-android:${version}' // central only
        implementation 'ble-profile-peripheral-XXX-android:${version}' // peripheral only
    }

