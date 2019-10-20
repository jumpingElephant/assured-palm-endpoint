package com.example.integration.test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

class LottoControllerTest {

    @Test
    void getNumbers() {
        get("/integration-test/data/lotto")
                .then()
                .body("lotto.lottoId", equalTo(5));
    }
}