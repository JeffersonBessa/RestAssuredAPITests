package steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import utils.RestUtils;
import java.util.ArrayList;

public class GenericSteps {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUtils.getResponse().getStatusCode());
    }

    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value) {
        Assert.assertEquals(value, RestUtils.getJsonValue(key));
    }

    @E("valido que recebo uma lista vazia no response")
    public void validoQueReceboUmaListaVaziaNoResponse() {
        Assert.assertEquals(new ArrayList<>(), RestUtils.getResponse().jsonPath().get());
    }
}
