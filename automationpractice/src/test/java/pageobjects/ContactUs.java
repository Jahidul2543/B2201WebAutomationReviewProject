package pageobjects;

import helper.ApplicationHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

public class ContactUs {
    @FindBy(how = How.ID, using = "message")
    WebElement messageBox;

    @FindBy(how = How.ID, using = "submitMessage")
    WebElement submitButton;
    //div[@id='center_column']/div/p
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/p/text()")
    WebElement message;

    @FindBy(how = How.ID, using = "email")
    WebElement emailBox;

    @FindBy(how = How.ID, using = "id_contact")
    WebElement dropdown;


    public String contactUsFormSubmission(String textToSend, String email, int indexNumber){
        messageBox.sendKeys(textToSend);
        emailBox.sendKeys(email);
        ApplicationHelper.selectByIndex(dropdown,indexNumber );
        submitButton.click();
        String actualMessage  = message.getText();
        // Using reporting Package from utilities module
        TestLogger.log("Actual Message: " + actualMessage);

        return actualMessage;

    }



}
