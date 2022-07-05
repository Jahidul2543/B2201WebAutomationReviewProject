package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    // Create webelement object using locator
    @FindBy(how = How.LINK_TEXT, using = "Contact us")
    WebElement contactUs;

    public void goToContactUsPage(){
        contactUs.click();
    }



}
