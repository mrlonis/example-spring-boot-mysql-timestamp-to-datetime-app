package com.mrlonis.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.mrlonis.time.entity.TestEntity1;
import com.mrlonis.time.entity.TestEntity2;
import com.mrlonis.time.repository.TestEntity1Repository;
import com.mrlonis.time.repository.TestEntity2Repository;
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
    private static final String TEST_NAME = "Test Name";
    private static final String TEST_USER = "fakeuser";

    @Autowired
    private TestEntity1Repository testEntity1Repository;

    @Autowired
    private TestEntity2Repository testEntity2Repository;

    @Test
    void testEntity1() {
        var all = testEntity1Repository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        var newEntity =
                new TestEntity1().setName(TEST_NAME).setCreatedUser(TEST_USER).setUpdatedUser(TEST_USER);
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntity1Repository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }

    @Test
    void testEntity2() {
        var all = testEntity2Repository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        var newEntity =
                new TestEntity2().setName(TEST_NAME).setCreatedUser(TEST_USER).setUpdatedUser(TEST_USER);
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = testEntity2Repository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }
}
