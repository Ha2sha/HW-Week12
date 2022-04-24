package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        //find the Computer tab element & click on it
        clickOnElement(By.linkText("Computers"));

        //This is from requirement
        String expectedTabText = "Computers";

        //find & get text from Computer tab element text
        String actualTabText = getTextFromElement(By.tagName("h1"));

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //find the Electronics tab element & click on it
        clickOnElement(By.linkText("Electronics"));

        //This is from requirement
        String expectedTabText = "Electronics";

        //find & get text from Electronics tab element text
        String actualTabText = getTextFromElement(By.tagName("h1"));;

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //find Apparel tab element & click on it
        clickOnElement(By.linkText("Apparel"));
        //This is from requirement
        String expectedTabText = "Apparel";

        //find & get text from Apparel tab element text
        String actualTabText = getTextFromElement(By.linkText("Apparel"));

        //validating actual & expected texts
        Assert.assertEquals("Page Not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //find Digital Downloads tab element & click on it
        clickOnElement(By.linkText("Digital downloads"));
        //This is from requirement
        String expectedTabText = "Digital downloads";

        //find & get text from Digital downloads  tab element text
        String actualTabText = getTextFromElement(By.linkText("Digital downloads"));

        //validating actual & expected texts
        Assert.assertEquals("Page Not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //find the Books tab element & click on it
        clickOnElement(By.linkText("Books"));
        //This is from requirement
        String expectedTabText = "Books";

        //find & get text from Books tab element text
        String actualTabText = getTextFromElement(By.tagName("h1"));

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //find the Jewelry tab element & click on it
        clickOnElement(By.linkText("Jewelry"));
        //This is from requirement
        String expectedTabText = "Jewelry";

        //find Jewelry tab element text & get text
        String actualTabText = getTextFromElement(By.tagName("h1"));

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //find Giftcards tab element & click on it
        clickOnElement(By.linkText("Gift Cards"));
        //This is from requirement
        String expectedTabText="Gift Cards";

        //find Giftcards text element & get text from it
        String actualTabText=getTextFromElement(By.linkText("Gift Cards"));

        //validation expected & actual results
        Assert.assertEquals("Page not Found",expectedTabText,actualTabText);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
