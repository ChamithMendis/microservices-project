package com.chamith.microservices.order;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class OrderServiceMicroserviceApplicationTests {
    static WireMockServer wireMockServer;

    @BeforeAll
    static void startWireMock() {
        wireMockServer = new WireMockServer(0);
        wireMockServer.start();

        configureFor("localhost", 0);
    }

    @AfterAll
    static void stopWireMock() {
        wireMockServer.stop();
    }

	@Test
	void contextLoads() {
	}

}
