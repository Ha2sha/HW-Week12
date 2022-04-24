package TestSuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
    openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

        //find forgot password link element & click on it
        clickOnElement(By.linkText("Forgot your password?"));

        //This is from the requirement
        String expectedText="Forgot Your Password?";

        //find forgotPassword text & get text
        String actualText=getTextFromElement(By.tagName("h1"));

        //validating expected & actual texts
        Assert.assertEquals("Link is Broken",expectedText,actualText);

    }
    @After
    public void tearDown(){
      closeBrowser();
    }
}
