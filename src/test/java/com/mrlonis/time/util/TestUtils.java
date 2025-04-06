package com.mrlonis.time.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.mrlonis.time.entity.base.BaseEntity;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.repository.JpaRepository;

@UtilityClass
public class TestUtils {
    public static <T extends BaseEntity, R extends JpaRepository<T, Long>> void assertInitialRepositoryConditions(
            R repository) {
        List<T> all = repository.findAll();
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());
    }
}
