package cucumberTests;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue="stepImplementations")
public class LoginTestRunner {

}
