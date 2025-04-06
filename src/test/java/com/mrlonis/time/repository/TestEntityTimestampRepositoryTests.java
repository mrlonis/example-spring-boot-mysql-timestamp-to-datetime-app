package com.mrlonis.time.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.mrlonis.time.TestcontainersConfiguration;
import com.mrlonis.time.entity.TestEntityTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class TestEntityTimestampRepositoryTests {
    private static final String TEST_NAME = "Test Name";
    private static final String TEST_USER = "fakeuser";

    @Autowired
    private TestEntityTimestampRepository testEntityTimestampRepository;

    @Test
    void testEntity1() {
        var all = testEntityTimestampRepository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());

        var newEntity = new TestEntityTimestamp()
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
}
