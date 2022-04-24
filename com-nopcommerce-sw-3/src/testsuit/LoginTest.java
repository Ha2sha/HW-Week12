package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find login link & click on the login link
        clickOnElement(By.linkText("Log in"));

        //This is from the requirement doc
        String expectedMessage="Welcome, Please Sign In!";

        //find the welcome text element & get the text from element
        String actualMessage=getTextFromElement(By.tagName("h1"));

        //Validated actual & expected messages
        Assert.assertEquals("Login Page not found",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find login link & click on the login link
        clickOnElement(By.linkText("Log in"));

        //find email field & assign value to it
        sendTextToElement(By.id("Email"),"kesha@gmail.com");

        //find password field & assign value to it
        sendTextToElement(By.name("Password"),"Kesha22");

        //find login Button element & click on it
        clickOnElement(By.cssSelector("button[class='button-1 login-button']"));

        String expectedLogoutText="Log out";

        //find logout text element & get text
        String actualLogoutText= getTextFromElement(By.linkText("Log out"));

        //validating expected & actual texts
        Assert.assertEquals("Not Found", expectedLogoutText,actualLogoutText);

    }

    @Test
    public void userShouldNotLoginSuccessfullyWithInValidCredentials(){
        //find login link & click on the login link
        clickOnElement(By.linkText("Log in"));

        //find emailField and pass incorrect email address
        sendTextToElement(By.id("Email"),"hello@gmail.com");

        //find passwordField and pass incorrect password
        sendTextToElement(By.id("Password"),"hello123");

        //find Login Button and click it
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //this is form the requirement
        String expectedErrorMsg="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        //find error message element & get text
        String actualErrorMsg=getTextFromElement(By.cssSelector(".message-error.validation-summary-errors"));

        //Validated actual & expected error messages
        Assert.assertEquals("Error not displayed",expectedErrorMsg, actualErrorMsg);

    }

    @After
    public void tearDown() {
        //closeBrowser();
    }

}
