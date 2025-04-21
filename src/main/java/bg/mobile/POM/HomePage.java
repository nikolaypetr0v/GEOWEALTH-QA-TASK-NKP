package bg.mobile.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy (xpath = "//a[contains(@href,'//www.mobile.bg')]")
    private WebElement navigationHomePageTab;
    @FindBy (xpath = "//a[contains(@href,'//www.mobile.bg/search/avtomobili-dzhipove')]")
    private WebElement navigationSearchTab;
    @FindBy (xpath = "//strong[text() = \"Вход\"]")
    private WebElement headerLogInButton;
    @FindBy (xpath = "//div[@id = \"cookiescript_accept\"]")
    private WebElement acceptAllCookiesBtn;

    public HomePage (WebDriver driver, Logger log)  {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    public void clickOnAcceptAllCookiesBtn () {
        waitAndClickOnWebElement(acceptAllCookiesBtn);
    }

    public void openHomePage () {
        navigateToBaseURL();
    }

    public void clickOnNavHomeTab(){
        waitAndClickOnWebElement(navigationHomePageTab);
    }

    public void clickOnNavSearchTab(){
        waitAndClickOnWebElement(navigationSearchTab);
    }

    public boolean isLogInBtnShown(){
        boolean isBtnShown = false;
        log.info(" ACTION @ The user is verifying if the log-in button is presented");
        try {
            wait.until(ExpectedConditions.visibilityOf(headerLogInButton));
            log.info("CONFIRM # The log-in button is presented to the user");
            isBtnShown = true;
        } catch ( TimeoutException e) {
            log.error("ERROR ! The log-in button is not presented to the user");
            isBtnShown = false;
        }
        return isBtnShown;
    }
}
