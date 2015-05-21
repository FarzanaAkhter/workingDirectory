import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty","html:target/cucumber-htmlreport"},
tags={"@Add Item"})
public class RunnerTest {

}
