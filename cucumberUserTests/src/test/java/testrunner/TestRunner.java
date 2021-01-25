/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 *
 * @author 黑妹
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@Main or @Test"},
        glue = "stepDefinitions",
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber"})

public class TestRunner {
    @BeforeClass
    public void setup(){
    }
    
}
