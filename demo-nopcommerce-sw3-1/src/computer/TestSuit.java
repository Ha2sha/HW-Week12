package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuit extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void VerifyPriceLowToHigh(){
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));//mouse hover to Computer Tab
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));//click on desktop
        selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"),"10");//Select Sort By price "Price: Low to High"

        String expectedResult= "Price: Low to High";

        String actualResult=getTextFromElement(By.xpath("//option[contains(text(),'Price: Low to High')]"));//GET TEXT FROM ELEMENT

        //validating expected & actual results
        Assert.assertEquals("Product not displayed by Price:Low to High",expectedResult,actualResult);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 mouse hover to Computer Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //2.2 click on desktop
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.id("products-orderby"),"5");

        //2.4 Click on "Add To Cart"
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"));

        //2.5 Verify the Text "Build your own computer"
        String expectedText="Build your own computer";
        String actualText=getTextFromElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Not found",expectedText,actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='product_attribute_1']"),"1");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"5");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_4_9']"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//input[@id='product_attribute_5_10']"));
        mouseHoverToElementAndClick(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        Thread.sleep(3000);
        String expectedPrice="$1,475.00";
        String actualPrice=getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Price do not Match",expectedPrice,actualPrice);

        //Click on "ADD TO CARD" Button.
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMsg="The product has been added to your shopping cart";
        String actualMsg=getTextFromElement(By.xpath("//div[@class='bar-notification success']"));
        Assert.assertEquals("Not added to the cart",expectedMsg,actualMsg);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        String expectedMsg1="Shopping cart";
        String actualMsg1=getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals("Message do not Match",expectedMsg1,actualMsg1);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"),"2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        String expectedTotal="$2,950.00";
        String actualTotal=getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Total not matched",expectedTotal,actualTotal);

        //2.18 click on checkbox “I agree with the terms of service”
        mouseHoverToElementAndClick(By.id("termsofservice"));
        //2.19 Click on “CHECKOUT”
        mouseHoverToElementAndClick(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(3000);
        String expectedMsg2="Welcome, Please Sign In!";
        String actualMsg2=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Chekout error",expectedMsg2,actualMsg2);

        //2.21 Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Kimaya");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Devani");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"kimaya@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Surat");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "10,Shiv Krupa");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "395002");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "09875823258");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.name("save"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));

        //2.26 Select Radio Button “Credit Card” & click on continue
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");
        //2.28 Fill all the details
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Miss Kimaya");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "7");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "802");
        //2.29 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        Thread.sleep(3000);
        String expectedPaymentMethod = "Payment Method: Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Payment method is not correct", expectedPaymentMethod,actualPaymentMethod);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Shipping Method: Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
        Assert.assertEquals("Shipping Method is not correct", expectedShippingMethod,actualShippingMethod);

        //2.33 Verify Total is “$2,950.00”
        String expectedFinalTotal = "$2,950.00";
        String actualFinalTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("Final Total is not correct", expectedFinalTotal,actualFinalTotal);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.35 Verify the Text “Thank You”
        String expectedText1="Thank you";
        String actualText1=getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Payment Error",expectedText1,actualText1);

        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText2 = "Your order has been successfully processed!";
        String actualText2 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Thank You does not display", expectedText2,actualText2);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.38 Verify the text “Welcome to our store”
        Thread.sleep(3000);
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store not displayed", expectedWelcome,actualWelcome);


    }


    @After
    public void tearDown() {
       closeBrowser();
    }
}
