package br.com.erudio.integrationtests.swagger;

import static io.restassured.RestAssured.given;

import br.com.erudio.configs.TestConfigs;
import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void shouldDisplaySwaggerUiPage() {
        var content =
        given()
                .basePath("/swagger-ui/index.html")
                .port(port)
                .when()
                    .get()
                .then()
                    .statusCode(200)
                .extract()
                    .body()
                        .asString();
        assertTrue(content.contains("Swagger UI"));
    }

}
