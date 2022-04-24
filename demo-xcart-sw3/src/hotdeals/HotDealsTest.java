package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {
    String baseUrl="https://mobile.x-cart.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically(){
        //1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));
        //1.2 Mouse hover on the “Sale”  link and click
        mouseHoverToElementAndClick(By.linkText("Sale"));
        //1.3 Verify the text “Sale”
        String expectedText="Sale";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);

        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        //1.5 Verify that the product arrange alphabetically
        String expectedOrder="Name A - Z";
        String actualOrder=getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]"));
        Assert.assertEquals("product is not arranged by Name A-Z",expectedOrder,actualOrder);
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh(){
        //2.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));
        //2.2 Mouse hover on the “Sale”  link and click
        mouseHoverToElementAndClick(By.linkText("Sale"));
        //2.3 Verify the text “Sale”
        String expectedText="Sale";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
        //2.4 Mouse hover on “Sort By” and select “Price Low-High”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.linkText("Price Low - High"));
        //2.5 Verify that the product’s price arrange Low to High
        String expectedOrder="Price Low - High";
        String actualOrder=getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')]"));
        Assert.assertEquals("product is not arranged by Price Low to High",expectedOrder,actualOrder);
    }

    @Test
    public void verifySaleProductsArrangeByRates(){
        //3.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));
        //3.2 Mouse hover on the “Sale”  link and click
        mouseHoverToElementAndClick(By.linkText("Sale"));
        //3.3 Verify the text “Sale”
        String expectedText="Sale";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
        //3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.linkText("Rates"));
        //3.5 Verify that the product’s arrange Rates
        String expectedOrder="Rates";
        String actualOrder=getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));
        Assert.assertEquals("product is not arranged by Rates",expectedOrder,actualOrder);

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA(){
        //4.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));
        //4.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverToElementAndClick(By.linkText("Bestsellers"));
        //4.3 Verify the text “Bestsellers”
        String expectedText="Bestsellers";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
        //4.4 Mouse hover on “Sort By” and select “Name Z-A”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.linkText("Name Z - A"));

        //4.5 Verify that the product arrange by Z to A
        String expectedOrder="Name Z - A";
        String actualOrder=getTextFromElement(By.xpath("//span[contains(text(),'Name Z - A')]"));
        Assert.assertEquals("product is not arranged by Name Z to A",expectedOrder,actualOrder);
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow(){
        //5.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));
        //5.2 Mouse hover on the “Bestsellers” link and click
        mouseHoverToElementAndClick(By.linkText("Bestsellers"));
        //5.3 Verify the text “Bestsellers”
        String expectedText="Bestsellers";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
        //5.4 Mouse hover on “Sort By” and select “Price High-Low”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.linkText("Price High - Low"));

        //5.5 Verify that the product’s price arrange High to Low
        String expectedOrder="Price High - Low";
        String actualOrder=getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')]"));
        Assert.assertEquals("product is not arranged by Price High - Low",expectedOrder,actualOrder);
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates(){
        //6.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.cssSelector("ul[class='nav navbar-nav top-main-menu'] span[class='primary-title']"));
        //6.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverToElementAndClick(By.linkText("Bestsellers"));
        //6.3 Verify the text “Bestsellers”
        String expectedText="Bestsellers";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Broken Link",expectedText,actualText);
        //6.4 Mouse hover on “Sort By” and select “Rates”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToElementAndClick(By.linkText("Rates"));
        //6.5 Verify that the product’s arrange Rates
        String expectedOrder="Rates";
        String actualOrder=getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));
        Assert.assertEquals("product is not arranged by Rates",expectedOrder,actualOrder);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
