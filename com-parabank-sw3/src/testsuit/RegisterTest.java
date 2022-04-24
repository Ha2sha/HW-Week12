package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){

        //finding Register Link & clicking on it
        clickOnElement(By.linkText("Register"));

        //this is from requirement
        String expectedText="Signing up is easy!";

        //finding textMessage element & get text
        String actualText=getTextFromElement(By.xpath("//h1[@class='title']"));

        //validating actual & expected text
        Assert.assertEquals("Register link not working", expectedText, actualText);

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){

        //finding Register Link & clicking on it
        clickOnElement(By.linkText("Register"));

        //finding firstname element & sending values
        sendTextToElement(By.id("customer.firstName"),"Sweety");

        //finding lastName element & sending values
        sendTextToElement(By.id("customer.lastName"),"Patel");

        //finding Address element & sending values
        sendTextToElement(By.id("customer.address.street"),"101 E. Huntington Drive");

        //finding city element & sending values
        sendTextToElement(By.id("customer.address.city"),"California");

        //finding state element & sending values
        sendTextToElement(By.id("customer.address.state"),"USA");

        //finding Zipcode element & sending values
        sendTextToElement(By.id("customer.address.zipCode"),"91016");

        //finding Phone number element & sending values
        sendTextToElement(By.id("customer.phoneNumber"),"91256897450");

        //finding SSN element & sending values
        sendTextToElement(By.id("customer.ssn"),"08785850");

        //finding UserName element & sending values
        sendTextToElement(By.id("customer.username"),"Sweety12");

        //finding password element & sending values
        sendTextToElement(By.id("customer.password"),"sweety@2");

        //finding password element & sending values
        sendTextToElement(By.id("repeatedPassword"),"sweety@2");

        //finding password element & Click on it
        clickOnElement(By.xpath("//input[@value='Register']"));

        //This is from the requirement
        String expectedMsg="Your account was created successfully. You are now logged in.";

        //get test from element
        String actualMsg=getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));

        //validating expected & actual message
        Assert.assertEquals("Registered Successfully.",expectedMsg,actualMsg);

    }

    @After
    public void teraDown(){

        closeBrowser();
    }
}
