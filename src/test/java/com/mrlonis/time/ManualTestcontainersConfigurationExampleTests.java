package com.mrlonis.time;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.mrlonis.time.repository.TestEntity1Repository;
import com.mrlonis.time.repository.TestEntity2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * This test class is used to test the application with a MySQL database using Testcontainers. It is very similar in
 * setup to the {@link ApplicationTests JodaToJavaTimeApplicationTests} class. The difference is that this test is a
 * more "manual" approach to the Testcontainers setup, while the other one uses a
 * {@link ServiceConnection @ServiceConnection} annotation to automatically configure the database connection removing
 * the need for {@link DynamicPropertySource @DynamicPropertySource} used in this class.
 *
 * <p>This class will likely never be expanded and will eventually diverge from the other test class. It is here to show
 * how to set up a test with Testcontainers manually. The other test class is the preferred way to set up a test with
 * Testcontainers with Spring Boot 3.1+.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class ManualTestcontainersConfigurationExampleTests {
    static final MySQLContainer<?> MY_SQL_CONTAINER;

    static {
        MY_SQL_CONTAINER = new MySQLContainer<>("mysql:8.0");
        MY_SQL_CONTAINER.start();
    }

    @DynamicPropertySource
    static void configureTestProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
    }

    @Autowired
    private TestEntity1Repository testEntity1Repository;

    @Autowired
    private TestEntity2Repository testEntity2Repository;

    @Test
    void contextLoads() {
        var result1 = testEntity1Repository.findAll();
        assertFalse(result1.isEmpty());

        var result2 = testEntity2Repository.findAll();
        assertFalse(result2.isEmpty());
    }
}
