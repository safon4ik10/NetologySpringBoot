package ru.netology.netologyspringboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.junit.Assert.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NetologySpringBootApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> devContainer = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    private static final GenericContainer<?> prodContainer = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devContainer.start();
        prodContainer.start();
    }

    @Test
    void contextLoads() {
        final String localHost = "http://localhost:";
        ResponseEntity<String> devEntity = restTemplate.getForEntity(localHost + devContainer.getMappedPort(8080) + "/profile", String.class);
        ResponseEntity<String> prodEntity = restTemplate.getForEntity(localHost + prodContainer.getMappedPort(8081) + "/profile", String.class);

        assertEquals("Current profile is dev", devEntity.getBody());
        assertEquals("Current profile is production", prodEntity.getBody());
    }

}
