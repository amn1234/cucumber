package testRunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/Features/login.feature",  // Run only login.feature    
//features = "src/test/resources/Features",  // Path to feature files
    glue = "stepDefinitions"                  // Package where step definitions are
)
public class TestRunner {

}
