package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //find Register element & click on it
        clickOnElement(By.className("ico-register"));
        //This is from requirement
        String expectedText = "Register";

        //find register page text element & get text
        String actualText = getTextFromElement(By.tagName("h1"));

        //validating expected & actual texts
        Assert.assertEquals("Page Not Found", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find Register element & click on it
        clickOnElement(By.className("ico-register"));

        //find gender element & click on it
        clickOnElement(By.cssSelector("span.female"));

        //find firstname text box & assign values
        sendTextToElement(By.id("FirstName"),"Kesha");

        //find lastName text box & assign values
        sendTextToElement(By.id("LastName"),"Patel");

        //find DOB day element & assign values
        sendTextToElement(By.name("DateOfBirthDay"),"22");

        //find DOB month element & assign values
        sendTextToElement(By.name("DateOfBirthMonth"),"March");

        //find DOB Year element & assign values
        sendTextToElement(By.name("DateOfBirthYear"),"1985");

        //find email field & assign value to it
        sendTextToElement(By.xpath("//input[@type='email']"),"kesha@gmail.com");

        //find password field & assign value to it
        sendTextToElement(By.xpath("//input[@id='Password']"),"Kesha22");

        //find confirm password field & assign value to it
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"Kesha22");

        //find Register button & click on it
        clickOnElement(By.xpath("//button[@name='register-button']"));

        String expectedResult="Your registration completed";

        //find register result element & get text
        String actualResult=getTextFromElement(By.cssSelector(".result"));

        //validating expected & actual result
        Assert.assertEquals("Registration not successful",expectedResult,actualResult);
    }

    @After
    public void tearDown() {

        // closeBrowser();
    }


}
