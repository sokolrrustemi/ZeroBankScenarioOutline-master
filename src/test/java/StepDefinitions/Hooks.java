package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    @Before
    public void before(){
        System.out.println("The scenario started.");
    }
    @After
    public void after(Scenario scenario){
        ExcelUtility.writeToExcel("src/test/java/apachePOI/resource/_ScenarioResults.xlsx",scenario, GWD.getThreadBrowserName());

        if (scenario.isFailed()){
            TakesScreenshot screenshot=((TakesScreenshot) GWD.getDriver());
            byte[] stateInMemory=screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(stateInMemory, "image/png", "screenshot name");
        }

        System.out.println("The scenario finished.");
        GWD.quitDriver();
    }
}
