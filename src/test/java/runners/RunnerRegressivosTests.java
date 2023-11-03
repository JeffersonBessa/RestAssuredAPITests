package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.RestUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    tags = "@regressivo",
    glue = "steps",
    plugin = {"json:target/reports/cucumber-Reports.json", "pretty"},
    snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerRegressivosTests {

    @BeforeClass
    public static void beforeClass(){
        RestUtils.setBaseURI("http://localhost:8181");
    }
}
