package bg.mobile.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    final String BASE_URL = "https://www.mobile.bg/";
    WebDriver driver;
    WebDriverWait wait;
    Logger log;

    public BasePage(WebDriver driver,Logger log) {
        this.driver = driver;
        this.log = log;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitAndClickOnWebElement(WebElement elm) {
        //Waiting for the element to be ready for click interaction
        wait.until(ExpectedConditions.visibilityOf(elm));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
        //User click interaction with the element
        elm.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public void waitAndTypeTextInField(WebElement textField, String inputText){
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.clear();
        textField.sendKeys(inputText);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public void navigateTo(String pageURLSuffix){
        String currentURL = BASE_URL + pageURLSuffix;
        driver.get(currentURL);
        log.info("CONFIRM # The user has navigated to : " + currentURL);
        waitPageTobeFullLoaded();
    }

    public void navigateToBaseURL(){
        String currentURL = BASE_URL;
        driver.get(currentURL);
        log.info("CONFIRM # The user has navigated to : " + currentURL);
        waitPageTobeFullLoaded();
    }

    public void waitPageTobeFullLoaded(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }
}
