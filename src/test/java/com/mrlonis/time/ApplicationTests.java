package com.mrlonis.time;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mrlonis.time.util.TestcontainersConfigurations;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * This is a basic context load test to ensure that the application can start up and that the Spring context is able to
 * load
 */
class ApplicationTests {
    @Nested
    @Import(TestcontainersConfigurations.TestcontainersConfigurationMySQL5_7.class)
    @SpringBootTest
    class ApplicationMySQL5_7Tests {
        @Test
        void contextLoads() {
            assertTrue(true);
        }
    }

    @Nested
    @Import(TestcontainersConfigurations.TestcontainersConfigurationMySQL8_0.class)
    @SpringBootTest
    class ApplicationMySQL8_0Tests {
        @Test
        void contextLoads() {
            assertTrue(true);
        }
    }

    @Nested
    @Import(TestcontainersConfigurations.TestcontainersConfigurationMySQL8.class)
    @SpringBootTest
    class ApplicationMySQL8Tests {
        @Test
        void contextLoads() {
            assertTrue(true);
        }
    }

    @Nested
    @Import(TestcontainersConfigurations.TestcontainersConfigurationMySQL9.class)
    @SpringBootTest
    class ApplicationMySQL9Tests {
        @Test
        void contextLoads() {
            assertTrue(true);
        }
    }

    @Nested
    @Import(TestcontainersConfigurations.TestcontainersConfigurationMySQL_LTS.class)
    @SpringBootTest
    class ApplicationMySQLLTSTests {
        @Test
        void contextLoads() {
            assertTrue(true);
        }
    }

    @Nested
    @Import(TestcontainersConfigurations.TestcontainersConfigurationMySQL_Latest.class)
    @SpringBootTest
    class ApplicationMySQLLatestTests {
        @Test
        void contextLoads() {
            assertTrue(true);
        }
    }
}
