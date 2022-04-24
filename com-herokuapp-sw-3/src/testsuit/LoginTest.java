package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username field & assign values
        sendTextToElement(By.id("username"),"tomsmith");

        //find password field & assign values
        sendTextToElement(By.name("password"),"SuperSecretPassword!");

        //find Login Button & click on it
        clickOnElement(By.xpath("//button[@type='submit']"));

        //This is from requirement
        String expectedText = "Secure Area";

        //find actualTextElement & get Text
        String actualText = getTextFromElement(By.tagName("h2"));

        //Validating expected & actual texts
        Assert.assertEquals("Unsuccessful Login", expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //find username field & assign values
        sendTextToElement(By.id("username"),"tomsmith1");

        //find password field & assign values
        sendTextToElement(By.name("password"),"SuperSecretPassword!");

        //find Login Button & click on it
        clickOnElement(By.xpath("//button[@type='submit']"));

        //this is the requirement
        String expectedResult = "Your username is invalid!";

        //for test to pass
        //String expectedResult = "Your username is invalid!\n"+"×";

        //find actualTextElement & get Text
        String actualResult = getTextFromElement(By.xpath("//div[@id='flash']"));

        //Validating expected & actual texts
        Assert.assertEquals("Invalid Username", expectedResult, actualResult);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //find username field & assign values
        sendTextToElement(By.id("username"),"tomsmith");

        //find password field & assign values
        sendTextToElement(By.name("password"),"SuperSecretPassword");

        //find Login Button & click on it
        clickOnElement(By.xpath("//button[@type='submit']"));

        //this is the requirement
        String expectedResult = "Your password is invalid!";

        //for test to pass
        //String expectedResult = "Your password is invalid!\n"+"×";

        //find actualTextElement & get Text
        String actualResult = getTextFromElement(By.xpath("//div[@id='flash']"));

        //Validating expected & actual texts
        Assert.assertEquals("Invalid Password", expectedResult, actualResult);
    }

    @After
    public void teraDown() {
        closeBrowser();
    }

}
