package StepDefinitions;

import Pages.LoginPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class LoginSteps {
    LoginPage lp=new LoginPage();

    @Given("Navigate to website")
    public void navigateToWebsite() {
        GWD.getDriver().get("http://zero.webappsecurity.com/login.html");
    }

    @And("Enter username that as {string} and password that as {string}")
    public void enterUsernameThatAsAndPasswordThatAs(String username, String password) {
        lp.mySendKeys(lp.username, "username");
        lp.mySendKeys(lp.password, "password");
    }

    @When("Click login button")
    public void clickLoginButton() {
        lp.myClick(lp.signInButton);
        GWD.getDriver().navigate().back();
    }

    @Then("Verify that user logged in")
    public void verifyThatUserLoggedIn() {
        Assert.assertTrue(lp.userIcon.isEnabled());
    }

    @And("Enter username and password from ZeroBankData")
    public void enterUsernameAndPasswordFromZeroBankData() throws IOException {

        String path="src/test/java/apachePOI/resource/_ZeroBankData.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet= workbook.getSheet("Sheet1");
        String username= String.valueOf(sheet.getRow(4).getCell(5));
        String password= String.valueOf(sheet.getRow(4).getCell(6));

        lp.mySendKeys(lp.username, username);
        lp.mySendKeys(lp.password, password);


    }
}
