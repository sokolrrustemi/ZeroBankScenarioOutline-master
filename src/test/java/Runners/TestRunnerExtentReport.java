package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;


@CucumberOptions
        (
                tags="@SmokeTest",
                features = "src/test/java/FeatureFiles",
                glue = "StepDefinitions",
                plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                dryRun = false


        )
public class TestRunnerExtentReport extends AbstractTestNGCucumberTests {

        @AfterClass
        public static void writeExtentReport() {
                ExtentService.getInstance().setSystemInfo("Windows Username", System.getProperty("user.name")); // Alternate --> System.getProperty("user.name")
                ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
                ExtentService.getInstance().setSystemInfo("Username", "Senol");
                ExtentService.getInstance().setSystemInfo("Application Name", "Zero Bank");
                ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
                ExtentService.getInstance().setSystemInfo("Department", "QA");
                ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
                ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
                ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
                ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
        }
}
