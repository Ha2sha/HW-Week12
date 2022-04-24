package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class Utility extends BaseTest {

    //This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
        //driver.findElement(by).click();
    }

    // This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will send text to Element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method will calculate size of List <WebElement>
    public int sizeOfListWebElement(By by){
        List<WebElement> inventory = driver.findElements(by);
        int actualItems = inventory.size();
        return actualItems;
    }
    //This method will clear the text box
    public void clearTheTextBox(By by){
        driver.findElement(by).clear();
    }

    //************************************Alert Methods***********************************//
    //This method will Switch to Alert Method
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method is for accepting Alerts
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //This method is for dismiss Alerts
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // This method is for get text from Alerts
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    // This method is for send text to Alerts
    public void sendTextAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //************************************Select Methods***********************************//
    //This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //This method will select the option by value
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //This method will select the option by index value
    public void selectByIndexFromDropDown(By by, int indexNo) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNo);
    }

    //This method will select all options & choose 1 from all
    public void selectByAllOptions(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        //System.out.println("No. of Options:" + allOptions.size());
        for (WebElement element:allOptions) {
            System.out.println(element.getText());
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
            }
        }
    }

    //************************************Switch Window Methods***********************************//
    //This method is for switching to iFrame
    public void switchIframe(By by,WebElement frameID, String text){
        driver.switchTo().frame(frameID);
        sendTextToElement(by,text);
        driver.switchTo().defaultContent();
    }

    public void getParentWindowHandle(String parentWindow){
        parentWindow=driver.getWindowHandle();
    }
    public void getBackToParentWindow(String parentWindow){
        driver.switchTo().window(parentWindow);
    }
    public void getChildWindowHandles(String parentWindow){
        parentWindow=driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for (String handle : handles) {
            if (!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                clickOnElement(By.xpath("//a[contains(text(),'Sign In')]"));
                driver.close();
                break;
            }
        }
    }

    //************************************Action Class Methods***********************************//

    //This method will be used to hover mouse on element
        public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

     //This method will be used to hover mouse on element & click
        public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

}