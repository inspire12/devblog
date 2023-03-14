package com.cnu.devblog.fixture;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class TestcontainersFixturesTest {
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8");
    @BeforeAll
    static void startDb() {
        mysql.start();
    }

    @Test
    void test(){
        // Do the testing here.
    }
    @AfterAll
    static void stopDb() {
        mysql.stop();
    }
}