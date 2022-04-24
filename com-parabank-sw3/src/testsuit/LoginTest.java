package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username element & send values
        sendTextToElement(By.name("username"),"Sweety12");

        //find password element & send values
        sendTextToElement(By.name("password"),"sweety@2");

        //find login button & click on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //requirement
        String expectedText = "Accounts Overview";

        //find actualText element & get text
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));

        //validating expected & actual texts
        Assert.assertEquals("SignIn Successfully", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {

        //find username element & send values
        sendTextToElement(By.name("username"),"absfererw");

        //find password element & send values
        sendTextToElement(By.name("password"),"a1sdajJ23");

        //find login button & click on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //requirement
        String expectedText = "The username and password could not be verified.";

        //find actualText element & get text
        String actualText = getTextFromElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));

        //validating expected & actual texts
        Assert.assertEquals("Invalid Username & Password", expectedText, actualText);
    }

    @Test
    public void userShouldLogOutSuccessfully(){
        //find username element & send values
        sendTextToElement(By.name("username"),"Sweety12");

        //find password element & send values
        sendTextToElement(By.name("password"),"sweety@2");

        //find login button & click on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //find Logout element & click on it
        clickOnElement(By.linkText("Log Out"));

        //this is from requirement
        String expectedText="Customer Login";

        //find Customerlogin element & get text
        String actualText=getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));

        //validating expected & actual text
        Assert.assertEquals("Logout Successfully",expectedText,actualText);

    }

    @After
    public void teraDown() {
        closeBrowser();
    }
}
