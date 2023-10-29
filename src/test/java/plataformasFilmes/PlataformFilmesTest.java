package plataformasFilmes;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlataformFilmesTest {

    public static final String SYSTEM_URL = "http://localhost:8080/";
    public static final String AUTH_ENDPOINT = "auth";

    @BeforeAll
    public static void validarLoginMap(){
        RestUtils.setBaseURI(SYSTEM_URL);
        LoginMap.initLogin();

        Response response = RestUtils.postRequest(LoginMap.getLogin(), ContentType.JSON, AUTH_ENDPOINT);
        assertEquals(200, response.statusCode());
        LoginMap.token = RestUtils.getJsonValue("token");
    }

    @Test
    public void validarConsultaCategorias(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+ LoginMap.token);

        Response response = RestUtils.getRequest(header, "categorias");
        assertEquals(200,response.statusCode());
        assertEquals("Terror", RestUtils.getJsonValue("tipo[2]").toString());
        List<String> listTipo = response.body().jsonPath().get("tipo");
        assertTrue(listTipo.contains("Terror"));
    }

    @Test
    public void validarLogin(){
        String json = "{" + "\"email\": \"aluno@email.com\"," + "\"senha\": \"123456\"" + "}";
        Response response = RestUtils.postRequest(json, ContentType.JSON,AUTH_ENDPOINT);
        assertEquals(200, response.statusCode());
        String token = RestUtils.getJsonValue("token");
        System.out.println(token);
    }
}
