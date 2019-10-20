package com.example.integration.test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.Matchers.equalTo;

public class LottoControllerTest {

    private WireMockServer wireMockServer;

    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
        setupStub();
    }

    public void setupStub() {
        // TODO: mock standalone Wiremock with proper data
        wireMockServer.stubFor(WireMock.get(urlEqualTo("/data/answers"))
                .willReturn(aResponse().withHeader("Content-Type", MediaType.APPLICATION_JSON)
                        .withStatus(200)
                        .withBodyFile("json/numbers.json")));
    }

    @AfterEach
    public void teardown() {
        wireMockServer.stop();
    }

    @Test
    public void testStatusCodePositive() {
        System.out.println("wireMockServer.baseUrl() = " + wireMockServer.baseUrl());
        RestAssured
                .when()
                .get("http://localhost:8090/data/answers").prettyPeek()
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    void getNumbers() {
        RestAssured
                .when()
                .get("/integration-test/data/lotto").peek()
                .then()
                .body("lotto.lottoId", equalTo(5));
    }
}