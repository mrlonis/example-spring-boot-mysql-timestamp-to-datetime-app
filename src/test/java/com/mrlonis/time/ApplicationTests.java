package com.mrlonis.time;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mrlonis.time.util.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * This is a basic context load test to ensure that the application can start up and that the Spring context is able to
 * load
 */
@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ApplicationTests {
    @Test
    void contextLoads() {
        assertTrue(true);
    }
}
