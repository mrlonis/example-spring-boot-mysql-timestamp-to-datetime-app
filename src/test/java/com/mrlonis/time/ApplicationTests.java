package com.mrlonis.time;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.mrlonis.time.repository.TestEntity1Repository;
import com.mrlonis.time.repository.TestEntity2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Testcontainers
class ApplicationTests {
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
        registry.add("spring.flyway.enabled", () -> "true");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "validate");
        registry.add(
                "spring.jpa.hibernate.naming.physical-strategy",
                () -> "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        registry.add(
                "spring.jpa.hibernate.naming.implicit-strategy",
                () -> "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
    }

    @Autowired
    private TestEntity1Repository repository1;

    @Autowired
    private TestEntity2Repository repository2;

    @Test
    void contextLoads() {
        var result1 = repository1.findAll();
        assertFalse(result1.isEmpty());

        var result2 = repository2.findAll();
        assertFalse(result2.isEmpty());
    }
}
