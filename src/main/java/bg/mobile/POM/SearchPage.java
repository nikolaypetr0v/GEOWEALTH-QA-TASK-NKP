package bg.mobile.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    //const
    public static final String SEARCH_PAGE_URL = "https://www.mobile.bg/search/avtomobili-dzhipove";

    @FindBy (xpath = "//div[@class = \"pageTitle MT15 MB15\"]")
    private WebElement searchPageTitle;
    @FindBy (xpath = "//input[@name = \"marka\"]")
    private WebElement carBrandInputField;
    @FindBy (xpath = "(//div[@id = \"akSearchMarki\" and @class = \"akSearchMarki\"]/div[@class = \"scroll\"]/div[@class = \"a\" and @onclick = \"selectOptionMenu('','','VW');\"]/span[contains(text(), \"VW\")])[2]")
    private WebElement carBrandVWDropdownOption;
    @FindBy (name = "model_show")
    private WebElement carModelDropdown;
    @FindBy (xpath = "//div[@id = \"akSearchModeli\"]")
    private WebElement carModelDropdownList;
    @FindBy (xpath = "//input[@data-value = \"Golf\"]")
    private WebElement carModelGolfCheckboxOption;
    @FindBy (xpath = "//span[contains(text(), \"4x4\")]")
    private WebElement fourWheelDriveCheckbox;
    @FindBy (xpath = "//a[@class = \"SEARCH_btn MT6\"]")
    private WebElement vehicleSearchButton;
    @FindBy (xpath = "//div[contains(text(), \"1 - 20 от общо\")]")
    private WebElement totalNumberOfAdsFound;
    @FindBy (xpath = "//div[@id = \"akSearchModeli\"]/a[@class = \"addButton\"]")
    private WebElement carModelOKButton;

    public SearchPage (WebDriver driver, Logger log)  {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    public void openSearchPage () {
        navigateTo(SEARCH_PAGE_URL);
    }

    public void locateCarModelGolfOption () {
        //Scrolling down the page until the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", carModelGolfCheckboxOption);
    }

    public void locateVehicleSearchBtn () {
        //Scrolling up the page until the element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", vehicleSearchButton);
    }

    public void showTotalNumberOfVWGolfAds () {
        log.info("The result of the VW Golf search is: " + totalNumberOfAdsFound.getText());
    }

    public void typeInCarBrandInDropdown (String carBrandName) {
        waitAndTypeTextInField(carBrandInputField, carBrandName);
    }

    public void clickOnCarBrandVWOption () {
        waitAndClickOnWebElement(carBrandVWDropdownOption);
    }

    public void clickOnCarModelDropdown () {
        waitAndClickOnWebElement(carModelDropdown);
    }

    public void clickOnCarModelGolfOption () {
        waitAndClickOnWebElement(carModelGolfCheckboxOption);
    }

    public void clickOnCarModelOKButton () {
        waitAndClickOnWebElement(carModelOKButton);
    }

    public void clickOnFourWheelDriveCheckbox () {
        waitAndClickOnWebElement(fourWheelDriveCheckbox);
    }

    public void clickOnSearchButton () {
        waitAndClickOnWebElement(vehicleSearchButton);
    }

    public String getSearchPageTitle () {
        wait.until(ExpectedConditions.visibilityOf(searchPageTitle));
        return searchPageTitle.getText();
    }

    public boolean isSearchPageOpenedPerRequirements(String expectedSearchPageTitleTxt){
        boolean isSearchPagePerRequirements = false;

        try{
            String actualSearchPageTitleTxt = getSearchPageTitle();
            isSearchPagePerRequirements = expectedSearchPageTitleTxt.equals(actualSearchPageTitleTxt);
            if (isSearchPagePerRequirements) {
                System.out.println("There is a match! Actual Search page header matches the criteria ");
            }
        } catch (NoSuchElementException e){
            log.error("ERROR ! The Search page is not opened per requirements.");
        }
        return isSearchPagePerRequirements;
    }
}
