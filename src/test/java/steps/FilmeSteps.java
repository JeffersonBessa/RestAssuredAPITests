package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.Endpoints;
import utils.RestUtils;
import java.util.HashMap;
import java.util.Map;

public class FilmeSteps {

    @Dado("que tenha um payload valido da API de Filme")
    public void queTenhaUmPayloadValidoDaAPIDeFilme() {
        FilmesMap.initAll();
    }

    @Quando("envio uma requisicao do tipo POST de Filme")
    public void envioUmaRequisicaoDoTipoPOSTDeFilme() {
        RestUtils.postRequest(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, Endpoints.FILMES);
    }

    @Entao("armazeno o id que recebo do response de Filme")
    public void armazenoOIdQueReceboDoResponseDeFilme() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");
    }

    @Quando("realizo uma requisicao do tipo GET de Filme atraves do nome")
    public void realizoUmaRequisicaoDoTipoGETDeFilmeAtravesDoNome() {
        Map<String, Object> param = new HashMap<>();
        String nome = FilmesMap.getFilme().get("nome").toString();
        param.put("nome", nome);
        RestUtils.getRequest(FilmesMap.getHeader(), param, Endpoints.FILMES);
    }

    @Dado("altero o indice {int} da lista de categorias do filme com os valores")
    public void alteroOIndiceDaListaDeCategoriasDoFilmeComOsValores(int indice, Map<String, String> map) {
        FilmesMap.getListCategoria().get(indice).putAll(map);
    }

    @Quando("realizo uma requisicao do tipo PUT de Filme")
    public void realizoUmaRequisicaoDoTipoPUTDeFilme() {
        RestUtils.putRequest(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, Endpoints.FILMES+"/" + FilmesMap.id);
    }

    @Quando("realizo uma requisicao do tipo Delete de Filme")
    public void realizoUmaRequisicaoDoTipoDeleteDeFilme() {
        RestUtils.deleteRequest(FilmesMap.getHeader(),Endpoints.FILMES+"/" + FilmesMap.id);
    }
}
