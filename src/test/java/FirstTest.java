import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class FirstTest {
    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/test/resources/features/first-test.feature", plugin = {"pretty","html:out.html"})

    public class zadanie1Test {
    }
}
