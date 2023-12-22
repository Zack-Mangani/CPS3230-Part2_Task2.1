package test.cps3230.ebay;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features",  glue = "test.cps3230.ebay")
public class TestRunner {


}
