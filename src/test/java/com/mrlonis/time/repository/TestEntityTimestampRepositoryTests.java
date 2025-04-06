package com.mrlonis.time.repository;

import static com.mrlonis.time.util.TestData.getTestEntityTimestamp;
import static com.mrlonis.time.util.TestUtils.assertInitialRepositoryConditions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.mrlonis.time.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class TestEntityTimestampRepositoryTests {
    @Autowired
    private TestEntityTimestampRepository repository;

    @Test
    void testEntity() {
        assertInitialRepositoryConditions(repository);

        var newEntity = getTestEntityTimestamp();
        assertNull(newEntity.getId());
        assertNull(newEntity.getCreatedDatetime());
        assertNull(newEntity.getUpdatedDatetime());

        newEntity = repository.saveAndFlush(newEntity);
        assertNotNull(newEntity.getId());
        assertNotNull(newEntity.getCreatedDatetime());
        assertNotNull(newEntity.getUpdatedDatetime());
    }
}
