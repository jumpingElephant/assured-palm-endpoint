package com.example.integration.test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("/lotto")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class LottoController {

    @GET
    public String getNumbers() {
        return "{\n" +
                "  \"lotto\": {\n" +
                "    \"lottoId\": 5,\n" +
                "    \"winning-numbers\": [2, 45, 34, 23, 7, 5, 3],\n" +
                "    \"winners\": [\n" +
                "      {\n" +
                "        \"winnerId\": 23,\n" +
                "        \"numbers\": [2, 45, 34, 23, 3, 5]\n" +
                "      },\n" +
                "      {\n" +
                "        \"winnerId\": 54,\n" +
                "        \"numbers\": [52, 3, 12, 11, 18, 22]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";
    }
}
