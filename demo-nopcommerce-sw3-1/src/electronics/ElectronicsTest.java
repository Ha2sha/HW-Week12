package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() {
        //1.1 Mouse Hover on “Electronics”Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Text not matched", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        /*2.2 Mouse Hover on “Cell phones” and click
        2.1 Mouse Hover on “Electronics”Tab
        2.3 Verify the text “Cell phones”*/
        textVerified(); //called the method

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(3000);
        String expectedText =  "Nokia Lumia 1020";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Text Nokia Lumia 1020 does not match.",expectedText, actualText);

        //2.7 Verify the price “$349.00”
        String expectedPrice="$349.00";
        String actualPrice=getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("Price not Matched",expectedPrice,actualPrice);

        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(3000);
        String expectedMsgBar="The product has been added to your shopping cart";
        String actualMsgBar=getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        Assert.assertEquals("Message not verified",expectedMsgBar,actualMsgBar);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        String expectedMsg1="Shopping cart";
        String actualMsg1=getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals("Message do not Match",expectedMsg1,actualMsg1);

        //2.13 Verify the quantity is 2
        String expectedQty="(2)";
        String actualQty=getTextFromElement(By.xpath("//span[contains(text(),'(2)')]"));
        Assert.assertEquals("Incorrect Qty",expectedQty,actualQty);

        //2.14 Verify the Total $698.00
        Thread.sleep(10000);
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("Total display is not correct", expectedTotal,actualTotal);

        //2.15 click on checkbox “I agree with the terms of service”
        mouseHoverToElementAndClick(By.id("termsofservice"));

        //2.16 Click on checkout
        mouseHoverToElementAndClick(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(3000);
        String expectedMsg2="Welcome, Please Sign In!";
        String actualMsg2=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Chekout error",expectedMsg2,actualMsg2);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        String expectedText2="Register";
        String actualText2=getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register Link is Broken",expectedText2,actualText2);

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Hira");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='Email']"),"hira@gmail.com");  //always give new email before running program
        sendTextToElement(By.xpath("//input[@id='Password']"),"H12545");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"H12545");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        String expectedText3="Your registration completed";
        String actualText3=getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Your registration is not completed",expectedText3,actualText3);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping cart”
        String expectedText4="Shopping cart";
        String actualText4=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text is not diplayed",expectedText4,actualText4);

        //2.25 click on checkbox “I agree with the terms of service”
        mouseHoverToElementAndClick(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        mouseHoverToElementAndClick(By.id("checkout"));
        //2.27 Fill the Mandatory fields
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Surat");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"10,Shiv Krupa");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "395002");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "09875823258");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.name("save"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));

        //2.31 Select Radio Button “Credit Card” & Continue
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"),"visa");

        //2.33 Fill all the details
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Hira Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"4485821584127596");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"3");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2027");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"631");

        //2.34 Click on “CONTINUE”CHECKOUT”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(3000);
        String expectedPaymentMethod = "Payment Method: Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Payment method is not correct", expectedPaymentMethod,actualPaymentMethod);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(3000);
        String expectedMethod1 = "Shipping Method: 2nd Day Air";
        String actualMethod1 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Shipping Method is not correct", expectedMethod1,actualMethod1);

        //2.37 Verify Total is “$698.00”
        Thread.sleep(3000);
        String expectedTotal1 = "$698.00";
        String actualTotal1 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Total is not correct", expectedTotal1,actualTotal1);

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        String expectedText1="Thank you";
        String actualText1=getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Payment Error",expectedText1,actualText1);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedText5 = "Your order has been successfully processed!";
        String actualText5 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Thank You does not display", expectedText5,actualText5);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(3000);
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store not displayed", expectedWelcome,actualWelcome);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl="https://demo.nopcommerce.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals("Incorrect URL",expectedUrl,actualUrl);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
