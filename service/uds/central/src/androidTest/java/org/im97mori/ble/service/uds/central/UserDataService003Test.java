package org.im97mori.ble.service.uds.central;

import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a7f.AerobicThreshold;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThreshold;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessment;
import org.im97mori.ble.characteristic.u2a87.EmailAddress;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a8f.HipCircumference;
import org.im97mori.ble.characteristic.u2a90.LastName;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholds;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a97.WaistCircumference;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import androidx.test.filters.RequiresDevice;

public class UserDataService003Test extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_getFirstName_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFirstName());
    }

    @Test
    @RequiresDevice
    public void test_getFirstName_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFirstName());
    }

    @Test
    @RequiresDevice
    public void test_getFirstName_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFirstName());
    }

    @Test
    @RequiresDevice
    public void test_getFirstName_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFirstName();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setFirstName_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        FirstName firstName = new FirstName("a");

        assertNull(userDataService.setFirstName(firstName));
    }

    @Test
    @RequiresDevice
    public void test_setFirstName_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FirstName firstName = new FirstName("a");

        assertNull(userDataService.setFirstName(firstName));
    }

    @Test
    @RequiresDevice
    public void test_setFirstName_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FirstName firstName = new FirstName("a");

        assertNull(userDataService.setFirstName(firstName));
    }

    @Test
    @RequiresDevice
    public void test_setFirstName_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFirstNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FirstName firstName = new FirstName("a");

        Integer taskId = userDataService.setFirstName(firstName);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getLastName_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getLastName());
    }

    @Test
    @RequiresDevice
    public void test_getLastName_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLastName());
    }

    @Test
    @RequiresDevice
    public void test_getLastName_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLastName());
    }

    @Test
    @RequiresDevice
    public void test_getLastName_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getLastName();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setLastName_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        LastName lastName = new LastName("a");

        assertNull(userDataService.setLastName(lastName));
    }

    @Test
    @RequiresDevice
    public void test_setLastName_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LastName lastName = new LastName("a");

        assertNull(userDataService.setLastName(lastName));
    }

    @Test
    @RequiresDevice
    public void test_setLastName_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LastName lastName = new LastName("a");

        assertNull(userDataService.setLastName(lastName));
    }

    @Test
    @RequiresDevice
    public void test_setLastName_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LastName lastName = new LastName("a");

        Integer taskId = userDataService.setLastName(lastName);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getEmailAddress_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getEmailAddress());
    }

    @Test
    @RequiresDevice
    public void test_getEmailAddress_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getEmailAddress());
    }

    @Test
    @RequiresDevice
    public void test_getEmailAddress_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getEmailAddress());
    }

    @Test
    @RequiresDevice
    public void test_getEmailAddress_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isEmailAddressCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getEmailAddress();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setEmailAddress_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        EmailAddress emailAddress = new EmailAddress("a");

        assertNull(userDataService.setEmailAddress(emailAddress));
    }

    @Test
    @RequiresDevice
    public void test_setEmailAddress_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        EmailAddress emailAddress = new EmailAddress("a");

        assertNull(userDataService.setEmailAddress(emailAddress));
    }

    @Test
    @RequiresDevice
    public void test_setEmailAddress_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isEmailAddressCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        EmailAddress emailAddress = new EmailAddress("a");

        assertNull(userDataService.setEmailAddress(emailAddress));
    }

    @Test
    @RequiresDevice
    public void test_setEmailAddress_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isEmailAddressCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        EmailAddress emailAddress = new EmailAddress("a");

        Integer taskId = userDataService.setEmailAddress(emailAddress);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAge_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAge());
    }

    @Test
    @RequiresDevice
    public void test_getAge_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAge());
    }

    @Test
    @RequiresDevice
    public void test_getAge_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLastNameCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAge());
    }

    @Test
    @RequiresDevice
    public void test_getAge_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAgeCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAge();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAge_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        Age age = new Age(1);

        assertNull(userDataService.setAge(age));
    }

    @Test
    @RequiresDevice
    public void test_setAge_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Age age = new Age(1);

        assertNull(userDataService.setAge(age));
    }

    @Test
    @RequiresDevice
    public void test_setAge_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAgeCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Age age = new Age(1);

        assertNull(userDataService.setAge(age));
    }

    @Test
    @RequiresDevice
    public void test_setAge_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAgeCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Age age = new Age(1);

        Integer taskId = userDataService.setAge(age);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDateOfBirth_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDateOfBirth());
    }

    @Test
    @RequiresDevice
    public void test_getDateOfBirth_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfBirth());
    }

    @Test
    @RequiresDevice
    public void test_getDateOfBirth_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfBirth());
    }

    @Test
    @RequiresDevice
    public void test_getDateOfBirth_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDateOfBirth();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDateOfBirth_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        assertNull(userDataService.setDateOfBirth(dateOfBirth));
    }

    @Test
    @RequiresDevice
    public void test_setDateOfBirth_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        assertNull(userDataService.setDateOfBirth(dateOfBirth));
    }

    @Test
    @RequiresDevice
    public void test_setDateOfBirth_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        assertNull(userDataService.setDateOfBirth(dateOfBirth));
    }

    @Test
    @RequiresDevice
    public void test_setDateOfBirth_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfBirthCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfBirth dateOfBirth = new DateOfBirth(1, 2, 3);

        Integer taskId = userDataService.setDateOfBirth(dateOfBirth);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getGender_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getGender());
    }

    @Test
    @RequiresDevice
    public void test_getGender_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getGender());
    }

    @Test
    @RequiresDevice
    public void test_getGender_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getGender());
    }

    @Test
    @RequiresDevice
    public void test_getGender_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getGender();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setGender_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        Gender gender = new Gender(Gender.GENDER_MALE);

        assertNull(userDataService.setGender(gender));
    }

    @Test
    @RequiresDevice
    public void test_setGender_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Gender gender = new Gender(Gender.GENDER_MALE);

        assertNull(userDataService.setGender(gender));
    }

    @Test
    @RequiresDevice
    public void test_setGender_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Gender gender = new Gender(Gender.GENDER_MALE);

        assertNull(userDataService.setGender(gender));
    }

    @Test
    @RequiresDevice
    public void test_setGender_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isGenderCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Gender gender = new Gender(Gender.GENDER_MALE);

        Integer taskId = userDataService.setGender(gender);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getWeight_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getWeight());
    }

    @Test
    @RequiresDevice
    public void test_getWeight_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWeight());
    }

    @Test
    @RequiresDevice
    public void test_getWeight_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWeight());
    }

    @Test
    @RequiresDevice
    public void test_getWeight_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getWeight();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setWeight_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        Weight weight = new Weight(0);

        assertNull(userDataService.setWeight(weight));
    }

    @Test
    @RequiresDevice
    public void test_setWeight_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Weight weight = new Weight(0);

        assertNull(userDataService.setWeight(weight));
    }

    @Test
    @RequiresDevice
    public void test_setWeight_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Weight weight = new Weight(0);

        assertNull(userDataService.setWeight(weight));
    }

    @Test
    @RequiresDevice
    public void test_setWeight_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Weight weight = new Weight(0);

        Integer taskId = userDataService.setWeight(weight);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getHeight_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getHeight());
    }

    @Test
    @RequiresDevice
    public void test_getHeight_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeight());
    }

    @Test
    @RequiresDevice
    public void test_getHeight_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeight());
    }

    @Test
    @RequiresDevice
    public void test_getHeight_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getHeight();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setHeight_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        Height height = new Height(0);

        assertNull(userDataService.setHeight(height));
    }

    @Test
    @RequiresDevice
    public void test_setHeight_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Height height = new Height(0);

        assertNull(userDataService.setHeight(height));
    }

    @Test
    @RequiresDevice
    public void test_setHeight_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Height height = new Height(0);

        assertNull(userDataService.setHeight(height));
    }

    @Test
    @RequiresDevice
    public void test_setHeight_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeightCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Height height = new Height(0);

        Integer taskId = userDataService.setHeight(height);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getVO2Max_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getVO2Max());
    }

    @Test
    @RequiresDevice
    public void test_getVO2Max_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getVO2Max());
    }

    @Test
    @RequiresDevice
    public void test_getVO2Max_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getVO2Max());
    }

    @Test
    @RequiresDevice
    public void test_getVO2Max_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getVO2Max();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setVO2Max_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        VO2Max vo2Max = new VO2Max(0);

        assertNull(userDataService.setVO2Max(vo2Max));
    }

    @Test
    @RequiresDevice
    public void test_setVO2Max_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        VO2Max vo2Max = new VO2Max(0);

        assertNull(userDataService.setVO2Max(vo2Max));
    }

    @Test
    @RequiresDevice
    public void test_setVO2Max_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        VO2Max vo2Max = new VO2Max(0);

        assertNull(userDataService.setVO2Max(vo2Max));
    }

    @Test
    @RequiresDevice
    public void test_setVO2Max_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isVO2MaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        VO2Max vo2Max = new VO2Max(0);

        Integer taskId = userDataService.setVO2Max(vo2Max);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getHeartRateMax_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getHeartRateMax());
    }

    @Test
    @RequiresDevice
    public void test_getHeartRateMax_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeartRateMax());
    }

    @Test
    @RequiresDevice
    public void test_getHeartRateMax_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHeartRateMax());
    }

    @Test
    @RequiresDevice
    public void test_getHeartRateMax_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getHeartRateMax();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setHeartRateMax_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        HeartRateMax heartRateMax = new HeartRateMax(0);

        assertNull(userDataService.setHeartRateMax(heartRateMax));
    }

    @Test
    @RequiresDevice
    public void test_setHeartRateMax_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HeartRateMax heartRateMax = new HeartRateMax(0);

        assertNull(userDataService.setHeartRateMax(heartRateMax));
    }

    @Test
    @RequiresDevice
    public void test_setHeartRateMax_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HeartRateMax heartRateMax = new HeartRateMax(0);

        assertNull(userDataService.setHeartRateMax(heartRateMax));
    }

    @Test
    @RequiresDevice
    public void test_setHeartRateMax_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHeartRateMaxCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HeartRateMax heartRateMax = new HeartRateMax(0);

        Integer taskId = userDataService.setHeartRateMax(heartRateMax);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getRestingHeartRate_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getRestingHeartRate());
    }

    @Test
    @RequiresDevice
    public void test_getRestingHeartRate_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getRestingHeartRate());
    }

    @Test
    @RequiresDevice
    public void test_getRestingHeartRate_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getRestingHeartRate());
    }

    @Test
    @RequiresDevice
    public void test_getRestingHeartRate_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getRestingHeartRate();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setRestingHeartRate_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        assertNull(userDataService.setRestingHeartRate(restingHeartRate));
    }

    @Test
    @RequiresDevice
    public void test_setRestingHeartRate_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        assertNull(userDataService.setRestingHeartRate(restingHeartRate));
    }

    @Test
    @RequiresDevice
    public void test_setRestingHeartRate_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        assertNull(userDataService.setRestingHeartRate(restingHeartRate));
    }

    @Test
    @RequiresDevice
    public void test_setRestingHeartRate_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isRestingHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        RestingHeartRate restingHeartRate = new RestingHeartRate(0);

        Integer taskId = userDataService.setRestingHeartRate(restingHeartRate);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getMaximumRecommendedHeartRate_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getMaximumRecommendedHeartRate());
    }

    @Test
    @RequiresDevice
    public void test_getMaximumRecommendedHeartRate_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getMaximumRecommendedHeartRate());
    }

    @Test
    @RequiresDevice
    public void test_getMaximumRecommendedHeartRate_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getMaximumRecommendedHeartRate());
    }

    @Test
    @RequiresDevice
    public void test_getMaximumRecommendedHeartRate_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getMaximumRecommendedHeartRate();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setMaximumRecommendedHeartRate_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        assertNull(userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate));
    }

    @Test
    @RequiresDevice
    public void test_setMaximumRecommendedHeartRate_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        assertNull(userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate));
    }

    @Test
    @RequiresDevice
    public void test_setMaximumRecommendedHeartRate_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        assertNull(userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate));
    }

    @Test
    @RequiresDevice
    public void test_setMaximumRecommendedHeartRate_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isMaximumRecommendedHeartRateCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        MaximumRecommendedHeartRate maximumRecommendedHeartRate = new MaximumRecommendedHeartRate(0);

        Integer taskId = userDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAerobicThreshold());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicThreshold());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicThreshold());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAerobicThreshold();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        assertNull(userDataService.setAerobicThreshold(aerobicThreshold));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        assertNull(userDataService.setAerobicThreshold(aerobicThreshold));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        assertNull(userDataService.setAerobicThreshold(aerobicThreshold));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicThreshold aerobicThreshold = new AerobicThreshold(0);

        Integer taskId = userDataService.setAerobicThreshold(aerobicThreshold);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAnaerobicThreshold());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicThreshold());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicThreshold());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAnaerobicThreshold();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicThreshold_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        assertNull(userDataService.setAnaerobicThreshold(anaerobicThreshold));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicThreshold_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        assertNull(userDataService.setAnaerobicThreshold(anaerobicThreshold));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicThreshold_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        assertNull(userDataService.setAnaerobicThreshold(anaerobicThreshold));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicThreshold_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicThresholdCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicThreshold anaerobicThreshold = new AnaerobicThreshold(0);

        Integer taskId = userDataService.setAnaerobicThreshold(anaerobicThreshold);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getSportTypeForAerobicAndAnaerobicThresholds());
    }

    @Test
    @RequiresDevice
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getSportTypeForAerobicAndAnaerobicThresholds());
    }

    @Test
    @RequiresDevice
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getSportTypeForAerobicAndAnaerobicThresholds());
    }

    @Test
    @RequiresDevice
    public void test_getSportTypeForAerobicAndAnaerobicThresholds_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getSportTypeForAerobicAndAnaerobicThresholds();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        assertNull(userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds));
    }

    @Test
    @RequiresDevice
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        assertNull(userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds));
    }

    @Test
    @RequiresDevice
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        assertNull(userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds));
    }

    @Test
    @RequiresDevice
    public void test_setSportTypeForAerobicAndAnaerobicThresholds_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds = new SportTypeForAerobicAndAnaerobicThresholds(0);

        Integer taskId = userDataService.setSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDateOfThresholdAssessment_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDateOfThresholdAssessment());
    }

    @Test
    @RequiresDevice
    public void test_getDateOfThresholdAssessment_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfThresholdAssessment());
    }

    @Test
    @RequiresDevice
    public void test_getDateOfThresholdAssessment_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDateOfThresholdAssessment());
    }

    @Test
    @RequiresDevice
    public void test_getDateOfThresholdAssessment_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDateOfThresholdAssessment();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDateOfThresholdAssessment_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        assertNull(userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment));
    }

    @Test
    @RequiresDevice
    public void test_setDateOfThresholdAssessment_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        assertNull(userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment));
    }

    @Test
    @RequiresDevice
    public void test_setDateOfThresholdAssessment_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        assertNull(userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment));
    }

    @Test
    @RequiresDevice
    public void test_setDateOfThresholdAssessment_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDateOfThresholdAssessmentCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DateOfThresholdAssessment dateOfThresholdAssessment = new DateOfThresholdAssessment(0, 1, 2);

        Integer taskId = userDataService.setDateOfThresholdAssessment(dateOfThresholdAssessment);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getWaistCircumference_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getWaistCircumference());
    }

    @Test
    @RequiresDevice
    public void test_getWaistCircumference_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWaistCircumference());
    }

    @Test
    @RequiresDevice
    public void test_getWaistCircumference_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getWaistCircumference());
    }

    @Test
    @RequiresDevice
    public void test_getWaistCircumference_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getWaistCircumference();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setWaistCircumference_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        WaistCircumference waistCircumference = new WaistCircumference(0);

        assertNull(userDataService.setWaistCircumference(waistCircumference));
    }

    @Test
    @RequiresDevice
    public void test_setWaistCircumference_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        WaistCircumference waistCircumference = new WaistCircumference(0);

        assertNull(userDataService.setWaistCircumference(waistCircumference));
    }

    @Test
    @RequiresDevice
    public void test_setWaistCircumference_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        WaistCircumference waistCircumference = new WaistCircumference(0);

        assertNull(userDataService.setWaistCircumference(waistCircumference));
    }

    @Test
    @RequiresDevice
    public void test_setWaistCircumference_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isWaistCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        WaistCircumference waistCircumference = new WaistCircumference(0);

        Integer taskId = userDataService.setWaistCircumference(waistCircumference);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getHipCircumference_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getHipCircumference());
    }

    @Test
    @RequiresDevice
    public void test_getHipCircumference_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHipCircumference());
    }

    @Test
    @RequiresDevice
    public void test_getHipCircumference_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getHipCircumference());
    }

    @Test
    @RequiresDevice
    public void test_getHipCircumference_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getHipCircumference();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setHipCircumference_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        HipCircumference hipCircumference = new HipCircumference(0);

        assertNull(userDataService.setHipCircumference(hipCircumference));
    }

    @Test
    @RequiresDevice
    public void test_setHipCircumference_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HipCircumference hipCircumference = new HipCircumference(0);

        assertNull(userDataService.setHipCircumference(hipCircumference));
    }

    @Test
    @RequiresDevice
    public void test_setHipCircumference_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HipCircumference hipCircumference = new HipCircumference(0);

        assertNull(userDataService.setHipCircumference(hipCircumference));
    }

    @Test
    @RequiresDevice
    public void test_setHipCircumference_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isHipCircumferenceCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        HipCircumference hipCircumference = new HipCircumference(0);

        Integer taskId = userDataService.setHipCircumference(hipCircumference);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFatBurnHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFatBurnHeartRateLowerLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        assertNull(userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        assertNull(userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        assertNull(userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit = new FatBurnHeartRateLowerLimit(0);

        Integer taskId = userDataService.setFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFatBurnHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFatBurnHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getFatBurnHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFatBurnHeartRateUpperLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        assertNull(userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        assertNull(userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        assertNull(userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setFatBurnHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFatBurnHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit = new FatBurnHeartRateUpperLimit(0);

        Integer taskId = userDataService.setFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAerobicHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAerobicHeartRateLowerLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit = new AerobicHeartRateLowerLimit(0);

        Integer taskId = userDataService.setAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAerobicHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAerobicHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAerobicHeartRateUpperLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit = new AerobicHeartRateUpperLimit(0);

        Integer taskId = userDataService.setAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAnaerobicHeartRateLowerLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateLowerLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateLowerLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateLowerLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateLowerLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit = new AnaerobicHeartRateLowerLimit(0);

        Integer taskId = userDataService.setAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getAnaerobicHeartRateUpperLimit());
    }

    @Test
    @RequiresDevice
    public void test_getAnaerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getAnaerobicHeartRateUpperLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateUpperLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateUpperLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateUpperLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        assertNull(userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit));
    }

    @Test
    @RequiresDevice
    public void test_setAnaerobicHeartRateUpperLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit = new AnaerobicHeartRateUpperLimit(0);

        Integer taskId = userDataService.setAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getFiveZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getFiveZoneHeartRateLimits());
    }

    @Test
    @RequiresDevice
    public void test_getFiveZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFiveZoneHeartRateLimits());
    }

    @Test
    @RequiresDevice
    public void test_getFiveZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getFiveZoneHeartRateLimits());
    }

    @Test
    @RequiresDevice
    public void test_getFiveZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getFiveZoneHeartRateLimits();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setFiveZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        assertNull(userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits));
    }

    @Test
    @RequiresDevice
    public void test_setFiveZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        assertNull(userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits));
    }

    @Test
    @RequiresDevice
    public void test_setFiveZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        assertNull(userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits));
    }

    @Test
    @RequiresDevice
    public void test_setFiveZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isFiveZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        FiveZoneHeartRateLimits fiveZoneHeartRateLimits = new FiveZoneHeartRateLimits(0, 1, 2, 3);

        Integer taskId = userDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getThreeZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getThreeZoneHeartRateLimits());
    }

    @Test
    @RequiresDevice
    public void test_getThreeZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getThreeZoneHeartRateLimits());
    }

    @Test
    @RequiresDevice
    public void test_getThreeZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getThreeZoneHeartRateLimits());
    }

    @Test
    @RequiresDevice
    public void test_getThreeZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getThreeZoneHeartRateLimits();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setThreeZoneHeartRateLimits_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        assertNull(userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits));
    }

    @Test
    @RequiresDevice
    public void test_setThreeZoneHeartRateLimits_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        assertNull(userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits));
    }

    @Test
    @RequiresDevice
    public void test_setThreeZoneHeartRateLimits_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        assertNull(userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits));
    }

    @Test
    @RequiresDevice
    public void test_setThreeZoneHeartRateLimits_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isThreeZoneHeartRateLimitsCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        ThreeZoneHeartRateLimits threeZoneHeartRateLimits = new ThreeZoneHeartRateLimits(0, 1);

        Integer taskId = userDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getTwoZoneHeartRateLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getTwoZoneHeartRateLimit());
    }

    @Test
    @RequiresDevice
    public void test_getTwoZoneHeartRateLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getTwoZoneHeartRateLimit());
    }

    @Test
    @RequiresDevice
    public void test_getTwoZoneHeartRateLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getTwoZoneHeartRateLimit());
    }

    @Test
    @RequiresDevice
    public void test_getTwoZoneHeartRateLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getTwoZoneHeartRateLimit();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setTwoZoneHeartRateLimit_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        assertNull(userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit));
    }

    @Test
    @RequiresDevice
    public void test_setTwoZoneHeartRateLimit_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        assertNull(userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit));
    }

    @Test
    @RequiresDevice
    public void test_setTwoZoneHeartRateLimit_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        assertNull(userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit));
    }

    @Test
    @RequiresDevice
    public void test_setTwoZoneHeartRateLimit_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isTwoZoneHeartRateLimitCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TwoZoneHeartRateLimit twoZoneHeartRateLimit = new TwoZoneHeartRateLimit(0);

        Integer taskId = userDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getLanguage_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getLanguage());
    }

    @Test
    @RequiresDevice
    public void test_getLanguage_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLanguage());
    }

    @Test
    @RequiresDevice
    public void test_getLanguage_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getLanguage());
    }

    @Test
    @RequiresDevice
    public void test_getLanguage_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getLanguage();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setLanguage_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        Language language = new Language("a");

        assertNull(userDataService.setLanguage(language));
    }

    @Test
    @RequiresDevice
    public void test_setLanguage_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Language language = new Language("a");

        assertNull(userDataService.setLanguage(language));
    }

    @Test
    @RequiresDevice
    public void test_setLanguage_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Language language = new Language("a");

        assertNull(userDataService.setLanguage(language));
    }

    @Test
    @RequiresDevice
    public void test_setLanguage_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isLanguageCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        Language language = new Language("a");

        Integer taskId = userDataService.setLanguage(language);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrement_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDatabaseChangeIncrement());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrement_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDatabaseChangeIncrement());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrement_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDatabaseChangeIncrement();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDatabaseChangeIncrement_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        DatabaseChangeIncrement databaseChangeIncrement = new DatabaseChangeIncrement(0);

        assertNull(userDataService.setDatabaseChangeIncrement(databaseChangeIncrement));
    }

    @Test
    @RequiresDevice
    public void test_setDatabaseChangeIncrement_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DatabaseChangeIncrement databaseChangeIncrement = new DatabaseChangeIncrement(0);

        assertNull(userDataService.setDatabaseChangeIncrement(databaseChangeIncrement));
    }

    @Test
    @RequiresDevice
    public void test_setDatabaseChangeIncrement_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        DatabaseChangeIncrement databaseChangeIncrement = new DatabaseChangeIncrement(0);

        Integer taskId = userDataService.setDatabaseChangeIncrement(databaseChangeIncrement);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getDatabaseChangeIncrementClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDatabaseChangeIncrementNotification_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.startDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startDatabaseChangeIncrementNotification_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startDatabaseChangeIncrementNotification_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startDatabaseChangeIncrementNotification_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.startDatabaseChangeIncrementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDatabaseChangeIncrementNotification_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.stopDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopDatabaseChangeIncrementNotification_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopDatabaseChangeIncrementNotification_000003() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopDatabaseChangeIncrementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopDatabaseChangeIncrementNotification_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.stopDatabaseChangeIncrementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getUserIndex_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getUserIndex());
    }

    @Test
    @RequiresDevice
    public void test_getUserIndex_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getUserIndex());
    }

    @Test
    @RequiresDevice
    public void test_getUserIndex_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getUserIndex();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getRegisteredUserClientCharacteristicConfiguration_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getRegisteredUserClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRegisteredUserClientCharacteristicConfiguration_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getRegisteredUserClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRegisteredUserClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getRegisteredUserClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startRegisteredUserIndication_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.startRegisteredUserIndication());
    }

    @Test
    @RequiresDevice
    public void test_startRegisteredUserIndication_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startRegisteredUserIndication());
    }

    @Test
    @RequiresDevice
    public void test_startRegisteredUserIndication_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.startRegisteredUserIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopRegisteredUserIndication_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.stopRegisteredUserIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopRegisteredUserIndication_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopRegisteredUserIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopRegisteredUserIndication_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.stopRegisteredUserIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setUserControlPoint_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);
        UserControlPoint userControlPoint = new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER, 0, 1, 2, 3, 4);

        assertNull(userDataService.setUserControlPoint(userControlPoint));
    }

    @Test
    @RequiresDevice
    public void test_setUserControlPoint_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        UserControlPoint userControlPoint = new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER, 0, 1, 2, 3, 4);

        assertNull(userDataService.setUserControlPoint(userControlPoint));
    }

    @Test
    @RequiresDevice
    public void test_setUserControlPoint_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        UserControlPoint userControlPoint = new UserControlPoint(UserControlPoint.OP_CODE_REGISTER_NEW_USER, 0, 1, 2, 3, 4);

        Integer taskId = userDataService.setUserControlPoint(userControlPoint);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getUserControlPointClientCharacteristicConfiguration_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.getUserControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getUserControlPointClientCharacteristicConfiguration_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.getUserControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getUserControlPointClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.getUserControlPointClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startUserControlPointIndication_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.startUserControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startUserControlPointIndication_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.startUserControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startUserControlPointIndication_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.startUserControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopUserControlPointIndication_000001() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null);

        assertNull(userDataService.stopUserControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopUserControlPointIndication_000002() {
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(userDataService.stopUserControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopUserControlPointIndication_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        UserDataService userDataService = new UserDataService(MOCK_BLE_CONNECTION, new MockUserDataServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = userDataService.stopUserControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
