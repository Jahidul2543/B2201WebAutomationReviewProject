package pageobjectstests;

import browserdriver.BrowserDriver;
import excelreader.MyDataReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ContactUs;
import pageobjects.HomePage;

import java.io.FileNotFoundException;

public class ContactUsPageTest extends BrowserDriver {
    HomePage homePage = null;
    ContactUs contactUs = null;

    @BeforeMethod
    public void initializeElement(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        contactUs =  PageFactory.initElements(driver, ContactUs.class);
    }

    /**
     * 1. Create a method who can get data from MyDataProvider class using getExcelSheetData()
     * ""
     * */
   @DataProvider
    public Object[][]  dataProvider() throws Exception {
        MyDataReader myDataReader = new MyDataReader();
        String filePath = "/Users/jahidul/IdeaProjects/B2201WebAutomationReviewProject/automationpractice/testData/testdataContactUs.xlsx";
        myDataReader.setExcelFile(filePath);
        Object[][]  data = myDataReader.getExcelSheetData("Sheet1");
        return data;
    }

    @Test(dataProvider = "dataProvider")
    public void sendTextTest(String email,String textToSend, String expectedText){
        homePage.goToContactUsPage();
        String actualMessage = contactUs.contactUsFormSubmission(textToSend, email, 1);
        Assert.assertEquals(actualMessage, expectedText );
    }
}
