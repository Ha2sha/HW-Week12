package TestSuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username field & assign values to it
        sendTextToElement(By.id("txtUsername"),"Admin");

        //find password field & assign values to it
        sendTextToElement(By.id("txtPassword"),"admin123");

        //find Login Button & click on it
        clickOnElement(By.name("Submit"));

        //Requirement
        String expectedMsg="Welcome Paul";

        //find welcome txt element & get text
        String actualMasg=getTextFromElement(By.id("welcome"));

        //validating expected & actual texts
        Assert.assertEquals("Login Unsuccessful",expectedMsg,actualMasg);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
