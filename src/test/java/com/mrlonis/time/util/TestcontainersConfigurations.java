package com.mrlonis.time.util;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.images.PullPolicy;
import org.testcontainers.utility.DockerImageName;

public class TestcontainersConfigurations {
    @TestConfiguration(proxyBeanMethods = false)
    public static class TestcontainersConfigurationMySQL5_7 {
        @Bean
        @ServiceConnection
        MySQLContainer<?> mysqlContainer() {
            return new MySQLContainer<>(DockerImageName.parse("mysql:5.7"))
                    .withImagePullPolicy(PullPolicy.alwaysPull());
        }
    }

    @TestConfiguration(proxyBeanMethods = false)
    public static class TestcontainersConfigurationMySQL8_0 {
        @Bean
        @ServiceConnection
        MySQLContainer<?> mysqlContainer() {
            return new MySQLContainer<>(DockerImageName.parse("mysql:8.0"))
                    .withImagePullPolicy(PullPolicy.alwaysPull());
        }
    }

    @TestConfiguration(proxyBeanMethods = false)
    public static class TestcontainersConfigurationMySQL8 {
        @Bean
        @ServiceConnection
        MySQLContainer<?> mysqlContainer() {
            return new MySQLContainer<>(DockerImageName.parse("mysql:8")).withImagePullPolicy(PullPolicy.alwaysPull());
        }
    }

    @TestConfiguration(proxyBeanMethods = false)
    public static class TestcontainersConfigurationMySQL9 {
        @Bean
        @ServiceConnection
        MySQLContainer<?> mysqlContainer() {
            return new MySQLContainer<>(DockerImageName.parse("mysql:9")).withImagePullPolicy(PullPolicy.alwaysPull());
        }
    }

    @TestConfiguration(proxyBeanMethods = false)
    public static class TestcontainersConfigurationMySQL_LTS {
        @Bean
        @ServiceConnection
        MySQLContainer<?> mysqlContainer() {
            return new MySQLContainer<>(DockerImageName.parse("mysql:lts"))
                    .withImagePullPolicy(PullPolicy.alwaysPull());
        }
    }

    @TestConfiguration(proxyBeanMethods = false)
    public static class TestcontainersConfigurationMySQL_Latest {
        @Bean
        @ServiceConnection
        MySQLContainer<?> mysqlContainer() {
            return new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
                    .withImagePullPolicy(PullPolicy.alwaysPull());
        }
    }
}
