package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username field & assign values
        sendTextToElement(By.id("user-name"),"standard_user");

        //find password field & assign values
        sendTextToElement(By.name("password"),"secret_sauce");

        //find Login Button & click on it
        clickOnElement(By.id("login-button"));

        //This is from requirement
        String expectedText = "PRODUCTS";

        //find actualTextElement &get Text
        String actualText = getTextFromElement(By.tagName("span"));

        //Validating expected & actual texts
        Assert.assertEquals("Unsuccessful Login", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //find username field & assign values
        sendTextToElement(By.id("user-name"),"standard_user");

        //find password field & assign values
        sendTextToElement(By.name("password"),"secret_sauce");

        //find Login Button & click on it
        clickOnElement(By.id("login-button"));

        //This is from requirement
        int expectedItems = 6;

        //find 6 items on homepage
        int actualItems = sizeOfListWebElement(By.className("inventory_item"));

        //validating expected & actual items
        Assert.assertEquals("6 items Not displayed", expectedItems, actualItems);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
