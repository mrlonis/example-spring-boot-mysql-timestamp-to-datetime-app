package com.mrlonis.time;

import static com.mrlonis.time.util.TestData.getTestEntityCalendar;
import static com.mrlonis.time.util.TestData.getTestEntityDate;
import static com.mrlonis.time.util.TestData.getTestEntityOffsetDateTime;
import static com.mrlonis.time.util.TestData.getTestEntityTimestamp;
import static com.mrlonis.time.util.TestData.getTestEntityZonedDateTime;
import static com.mrlonis.time.util.TestUtils.assertInitialRepositoryConditions;
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
        assertInitialRepositoryConditions(testEntityCalendarRepository);

        TestEntityCalendar newEntity = getTestEntityCalendar();
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
        assertInitialRepositoryConditions(testEntityDateRepository);

        TestEntityDate newEntity = getTestEntityDate();
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
        assertInitialRepositoryConditions(testEntityOffsetDateTimeRepository);

        TestEntityOffsetDateTime newEntity = getTestEntityOffsetDateTime();
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
        assertInitialRepositoryConditions(testEntityTimestampRepository);

        TestEntityTimestamp newEntity = getTestEntityTimestamp();
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
        assertInitialRepositoryConditions(testEntityZonedDateTimeRepository);

        TestEntityZonedDateTime newEntity = getTestEntityZonedDateTime();
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntityZonedDateTimeRepository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }
}
