package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl="https://mobile.x-cart.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForVinylIdolzGhostbusters() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));

        //1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverToElementAndClick(By.linkText("Bestsellers"));

        //1.3 Verify the text “Bestsellers”
        String expectedText="Bestsellers";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);

        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.linkText("Name A - Z"));

        //1.5 Click on “Add to cart” button of the product “VinylIdolzGhostbusters”
        Thread.sleep(5000);
        mouseHoverToElementAndClick(By.xpath("//a[@class='fn url next-previous-assigned'][normalize-space()='Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//button[@type='submit']//span[contains(text(),'Add to cart')]"));

        //1.6 Verify the message “Product has been added to your cart” display in green bar
          String expectedCartMsg="Product has been added to your cart";
          Thread.sleep(3000);
          String actualCartMsg=getTextFromElement(By.xpath("//li[@class='info']"));
          Assert.assertEquals("Product has not been added to the cart",expectedCartMsg,actualCartMsg);

        //1.7 Click on X sign to close the message
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@id='status-messages']/a"));

        //1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //1.9 Verify the text “Your shopping cart - 1 item”
        String expectedCartMsg2="Your shopping cart - 1 item";
        String actualCartMsg2=getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]"));
        Assert.assertEquals("Text 'Your shopping cart - 1 item' is not displayed",expectedCartMsg2,actualCartMsg2);

        //1.10 Verify the Subtotal $19.99
        Thread.sleep(3000);
        String expectedSubTotal="$19.99";
        String actualSubTotal=getTextFromElement(By.xpath("//ul[@class='sums']/li/span"));
        Assert.assertEquals("Subtotal is not correct",expectedSubTotal,actualSubTotal);
        //1.11 Verify the total $25.84
        String expectedTotal="$25.84";
        String actualTotal=getTextFromElement(By.xpath("//li[@class='total']/span/span[1]"));
        Assert.assertEquals("Total is not correct",expectedTotal,actualTotal);

        //1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));

        //1.13 Verify the text “Log in to your account”
        Thread.sleep(3000);
        String expectedLoginText="Log in to your account";
        String actualLoginText=getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        Assert.assertEquals("Text 'Log in to your account' is not displayed",expectedLoginText,actualLoginText);

        //1.14 Enter Email address
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='email']"), "harry21@gmail.com");//pls use harry2 when you check

        //1.15 Click on “Continue” Button
        Thread.sleep(3000);
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));

        //1.16 Verify the text “Secure Checkout”
        String expectedCheckOutText="Secure Checkout";
        String actualCheckOutText=getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals("Text 'Secure Checkout' is not displayed",expectedCheckOutText,actualCheckOutText);

        //1.17 Fill all the mandatory fields
        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Harry");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Portar");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "12 Sunrise Apartment");

//        clearTheTextBox(By.xpath("//input[@id='shippingaddress-city']"));//clear the text box
//        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"),"Surat");
//        clearTheTextBox(By.xpath("//select[@id='shippingaddress-country-code']"));//clear the text box
//        selectByValueFromDropDown(By.xpath("//select[@id='shippingaddress-country-code']"),"India");
//        clearTheTextBox(By.xpath("//input[@id='shippingaddress-zipcode']"));//clear the text box
//        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"),"358992");

        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "sg");

        //1.18 Check the check box “Create an account for later use”

        clickOnElement(By.xpath("//input[@id='create_profile']"));

        //1.19 Enter the password
        sendTextToElement(By.xpath("//input[@id='password']"), "Harry12");

        //1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.xpath("//span[contains(text(),'Local shipping')]"));
        //1.21 Select Payment Method “COD”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//span[contains(text(),'COD')]"));
        //1.22 Verify the total $26.86
        String expectedTotal1 = "$26.86";
        String actualTotal1 = getTextFromElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/span[2]/span[1]/span[1]"));
        Assert.assertEquals("Total '$26.86' is not displayed", expectedTotal1, actualTotal1);

        //1.23 Click on “Place Order” Button
        Thread.sleep(5000);
        //mouseHoverToElement(By.xpath("//span[normalize-space()='Place order: $26.86']"));
        clickOnElement(By.xpath("//span[contains(text(),'Place order: $26.86')]"));


        //1.24 Verify the text “Thank you for your order”
        Thread.sleep(3000);
        String expectedText1 = "Thank you for your order";
        String actualText1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text 'Thank you for your order' is not displayed", expectedText1, actualText1);

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));
        //2.2 Mouse hover on the “Bestseller”  link and click
        mouseHoverToElementAndClick(By.linkText("Bestsellers"));
        //2.3 Verify the text “Bestsellers”
        String expectedText="Bestsellers";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
        //2.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.linkText("Name A - Z"));
        //2.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        Thread.sleep(5000);
        mouseHoverToElementAndClick(By.xpath("//a[@class='fn url next-previous-assigned'][normalize-space()='Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//button[@type='submit']//span[contains(text(),'Add to cart')]"));

        //2.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedCartMsg="Product has been added to your cart";
        Thread.sleep(3000);
        String actualCartMsg=getTextFromElement(By.xpath("//li[@class='info']"));
        Assert.assertEquals("Product has not been added to the cart",expectedCartMsg,actualCartMsg);

        //2.7 Click on X sign to close the message
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@id='status-messages']/a"));

        //2.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //2.9 Verify the text “Your shopping cart - 1 item”
        String expectedCartMsg2="Your shopping cart - 1 item";
        String actualCartMsg2=getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]"));
        Assert.assertEquals("Text 'Your shopping cart - 1 item' is not displayed",expectedCartMsg2,actualCartMsg2);

        //2.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //2.11 Verify the text “Are you sure you want to clear your cart?” on alert
        switchToAlert();
        String expectedAlertMessage = "Are you sure you want to clear your cart?";
        String actualAlertMessage = getTextAlert(); // capture alert message
        Assert.assertEquals("Alert message is not the same", expectedAlertMessage,actualAlertMessage);

        //2.12 Click “Ok” on alert
        acceptAlert();

        //2.13 Verify the message “Item(s) deleted from your cart”
        String expectedCartMsg1="Item(s) deleted from your cart";
        Thread.sleep(3000);
        String actualCartMsg1=getTextFromElement(By.xpath("//li[@class='info']"));
        Assert.assertEquals("Product has not been added to the cart",expectedCartMsg1,actualCartMsg1);

        //2.15 Verify the text “Your cart is empty”
        String expectedText3 = "Your cart is empty";
        String actualText3 = getTextFromElement(By.xpath("//h1[contains(text(),'Your cart is empty')]"));
        Assert.assertEquals("Text 'Your cart is empty' is not displayed", expectedText3, actualText3);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
