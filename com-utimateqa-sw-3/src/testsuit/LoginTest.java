package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find sign-in link & click on it
        clickOnElement(By.linkText("Sign In"));

        //This is from requirement
        String expectedText="Welcome Back!";

        //find actual text element & get text
        String actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));

        //Validating expected & actual texts
        Assert.assertEquals("Sign In Link not working",expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find sign-in link & click on it
        clickOnElement(By.linkText("Sign In"));

        //find email field & send values
        sendTextToElement(By.id("user[email]"),"abc@gmail.com");

        //find password field & send values
        sendTextToElement(By.id("user[password]"),"abc123");

        //find signIn button & click on it
        clickOnElement(By.xpath("//input[@type='submit']"));

        //This is from requirement
        String expectedMsg="Invalid email or password.";

        //find actual msg element & get text
        String actualMsg=getTextFromElement(By.xpath("//li[@role='alert']"));

        //Validating Actual & Expected texts
        Assert.assertEquals("Enter Valid Credentials",expectedMsg,actualMsg);
    }

    @After
    public void teraDown() {
    closeBrowser();
    }

}
