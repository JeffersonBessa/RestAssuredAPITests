package steps;

import io.cucumber.java.pt.*;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.Endpoints;
import utils.RestUtils;
import java.util.Map;

public class LoginSteps {

    public static final String SYSTEM_URL = "http://localhost:8080/";

    @Dado("que tenha um payload valido da API de Login")
    public void queTenhaUmPayloadValidoDaAPIDeLogin() {
        LoginMap.initLogin();
        RestUtils.setBaseURI(SYSTEM_URL);
    }

    @Dado("que tenha um payload da API de Login com as seguintes informacoes")
    public void queTenhaUmPayloadDaAPIDeLoginComAsSeguintesInformacoes(Map<String, Object> map) {
        LoginMap.initLogin();
        RestUtils.setBaseURI(SYSTEM_URL);
        LoginMap.getLogin().putAll(map);
    }

    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
        RestUtils.postRequest(LoginMap.getLogin(), ContentType.JSON, Endpoints.LOGIN);
    }

    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
        LoginMap.token = RestUtils.getJsonValue("token");
    }

    @Dado("que tenha realizado o login com dados validos")
    public void queTenhaRealizadoOLoginComDadosValidos() {
        queTenhaUmPayloadValidoDaAPIDeLogin();
        envioUmaRequisicaoDoTipoPOSTDeLogin();
        armazenoOTokenQueReceboDoResponseDeLogin();
    }
}
