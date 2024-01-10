package StepDefinitions;

import Pages.OnlineBanking;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddNewPayee {

    OnlineBanking obp=new OnlineBanking();
    @When("Click on the element in OnlineBanking")
    public void clickOnTheElementInOnlineBanking(DataTable links) {
        List<String> linkList=links.asList(String.class);
        for (int i = 0; i < linkList.size(); i++) {
            String link= linkList.get(i);
            WebElement webElement= obp.getWebelement(link);
            obp.myClick(webElement);

        }
    }

    @And("User sending name,address,account,and details in OnlineBanking")
    public void userSendingNameAddressAccountAndDetailsInOnlineBanking(DataTable dataTable) {
        List<List<String>> items=dataTable.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            List<String>item=items.get(i);
            WebElement element=obp.getWebelement(item.get(0));
            String text=item.get(1);
            obp.mySendKeys(element, text);

        }





    }

    @When("Click to add button")
    public void clickToAddButton() {
        obp.myClick(obp.AddButton);
    }
}
