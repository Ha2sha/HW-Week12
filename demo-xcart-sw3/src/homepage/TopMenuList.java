package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuList extends Utility {
    String baseUrl="https://mobile.x-cart.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        //1.1 Click on the “Shipping” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Shipping')]"));
        //1.2 Verify the text “Shipping”
        String expectedText="Shipping";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        //2.1 Click on the “New!” link
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'New!')]"));
        //2.2 Verify the text “New arrivals”
        String expectedText="New arrivals";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
    }
    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully(){
        //3.1 Click on the “Coming soon” link
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Coming soon')]"));
        //3.2 Verify the text “Coming soon”
        String expectedText="Coming soon";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        //4.1 Click on the “Contact us” link
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Contact us')]"));
        //4.2 Verify the text “Contact us”
        String expectedText="Contact us";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
    }


    @After
    public void tearDown(){
        closeBrowser();
    }
}
