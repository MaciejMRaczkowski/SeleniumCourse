package bdd.zadania;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/Cucumber/Features/zadanie2.feature",
        plugin = {
                "pretty",
                "html:out/zadanie2report.html"
        }
)

public class Zadanie2Test {
}
