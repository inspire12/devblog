package com.cnu.devblog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import static org.assertj.core.api.Assertions.assertThat;
import org.testcontainers.junit.jupiter.Testcontainers;
@SpringBootTest
@Testcontainers
public class RepositoryTest {
    @Container
    private static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>("mysql:8.0.24")
        .withInitScript("schema.sql");

//    @DynamicPropertySource
//    public static void properties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
//        registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
//        registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
//    }


    @Test
    void test() {
        assertThat(MY_SQL_CONTAINER.isRunning()).isTrue();
    }
}
