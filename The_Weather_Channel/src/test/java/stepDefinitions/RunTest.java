package stepDefinitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                glue = "stepDefinitions",
                tags = "@Cenario1, @Cenario2, @Cenario3, @Cenario4, @Cenario5"),
		format = {"json:target/cucumber.json"}
public class RunTest {

}
