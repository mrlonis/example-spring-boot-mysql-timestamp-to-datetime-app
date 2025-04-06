package com.mrlonis.time;

import static com.mrlonis.time.TestConstants.TEST_NAME;
import static com.mrlonis.time.TestConstants.TEST_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.mrlonis.time.entity.TestEntityCalendar;
import com.mrlonis.time.entity.TestEntityDate;
import com.mrlonis.time.entity.TestEntityOffsetDateTime;
import com.mrlonis.time.entity.TestEntityTimestamp;
import com.mrlonis.time.entity.TestEntityZonedDateTime;
import com.mrlonis.time.repository.TestEntityCalendarRepository;
import com.mrlonis.time.repository.TestEntityDateRepository;
import com.mrlonis.time.repository.TestEntityOffsetDateTimeRepository;
import com.mrlonis.time.repository.TestEntityTimestampRepository;
import com.mrlonis.time.repository.TestEntityZonedDateTimeRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

/**
 * The goal of these tests are to combine all the repository tests into one place, and then perform the tests against a
 * database BEFORE it is migrated to datetime. This is to show that the code show in this repository works against the
 * database before it is migrated to datetime. This further shows how this migration is a low-risk operation, by proving
 * the application code can remain completely unchanged and still work against the database regardless of what the
 * underlying datetime data type is being using in the database table.
 */
@Import(TestcontainersConfiguration.class)
@SpringBootTest
@ActiveProfiles("test-timestamp")
class ApplicationTimestampTests {
    @Autowired
    private TestEntityCalendarRepository testEntityCalendarRepository;

    @Autowired
    private TestEntityDateRepository testEntityDateRepository;

    @Autowired
    private TestEntityOffsetDateTimeRepository testEntityOffsetDateTimeRepository;

    @Autowired
    private TestEntityTimestampRepository testEntityTimestampRepository;

    @Autowired
    private TestEntityZonedDateTimeRepository testEntityZonedDateTimeRepository;

    @Test
    void testEntityCalendar() {
        List<TestEntityCalendar> all = testEntityCalendarRepository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        TestEntityCalendar newEntity = TestEntityCalendar.builder()
                .name(TEST_NAME)
                .createdUser(TEST_USER)
                .updatedUser(TEST_USER)
                .build();
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntityCalendarRepository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }

    @Test
    void testEntityDate() {
        List<TestEntityDate> all = testEntityDateRepository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        TestEntityDate newEntity = new TestEntityDate()
                .setName(TEST_NAME)
                .setCreatedUser(TEST_USER)
                .setUpdatedUser(TEST_USER);
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntityDateRepository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }

    @Test
    void testEntityOffsetDateTime() {
        List<TestEntityOffsetDateTime> all = testEntityOffsetDateTimeRepository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        TestEntityOffsetDateTime newEntity = new TestEntityOffsetDateTime()
                .setName(TEST_NAME)
                .setCreatedUser(TEST_USER)
                .setUpdatedUser(TEST_USER);
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntityOffsetDateTimeRepository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }

    @Test
    void testEntityTimestamp() {
        List<TestEntityTimestamp> all = testEntityTimestampRepository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        TestEntityTimestamp newEntity = new TestEntityTimestamp()
                .setName(TEST_NAME)
                .setCreatedUser(TEST_USER)
                .setUpdatedUser(TEST_USER);
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntityTimestampRepository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }

    @Test
    void testEntityZonedDateTime() {
        List<TestEntityZonedDateTime> all = testEntityZonedDateTimeRepository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        TestEntityZonedDateTime newEntity = new TestEntityZonedDateTime()
                .setName(TEST_NAME)
                .setCreatedUser(TEST_USER)
                .setUpdatedUser(TEST_USER);
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntityZonedDateTimeRepository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }
}
