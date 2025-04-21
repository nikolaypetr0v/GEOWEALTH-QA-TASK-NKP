package gui.regression.search;

import bg.mobile.POM.HomePage;
import bg.mobile.POM.SearchPage;
import gui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHappyTest extends BaseTest {
    //const and vars that will be used in the test case
    private static final int WAIT = 2000;
    private static final String SEARCH_PAGE_TITLE_TXT_LOCATOR = "Търсене в Автомобили и Джипове";
    private static final String CAR_BRAND_NAME_LOCATOR = "VW";

    @Test
    public void verifyUserCanSearchForACar(){
        HomePage homePage = new HomePage(super.driver, log);
        homePage.openHomePage();
        log.info("STEP 1: Not logged in user has opened the www.mobile.bg Home page.");
        sleepy(WAIT);

        homePage.clickOnAcceptAllCookiesBtn();
        log.info("STEP 2: Not logged in user has accepted all \"cookies\" in www.mobile.bg cookies consent dialog.");
        boolean isLogInBtnVisible = homePage.isLogInBtnShown();
        Assert.assertTrue(isLogInBtnVisible);
        sleepy(WAIT);

        homePage.clickOnNavSearchTab();
        log.info("STEP 3: The user has navigated to mobile.bg Search page");

        SearchPage searchPage = new SearchPage(super.driver, log);
        boolean isSearchPageOpened = searchPage.isSearchPageOpenedPerRequirements(SEARCH_PAGE_TITLE_TXT_LOCATOR);
        Assert.assertTrue(isSearchPageOpened);
        log.info("STEP 4: The user has verified that the Search page is opened as per requirements ");
        sleepy(WAIT);

        searchPage.typeInCarBrandInDropdown(CAR_BRAND_NAME_LOCATOR);
        log.info("STEP 5: The user has provided a car brand name.");
        sleepy(WAIT);

        searchPage.clickOnCarBrandVWOption();
        log.info("STEP 6: The user has clicked on a car brand VW option in the dropdown list.");
        sleepy(WAIT);

        searchPage.clickOnCarModelDropdown();
        log.info("STEP 7: The user has clicked on a car model dropdown field.");
        sleepy(WAIT);

        searchPage.locateCarModelGolfOption();
        log.info("STEP 8: The user has localised car model Golf option.");
        sleepy(WAIT);

        searchPage.clickOnCarModelGolfOption();
        log.info("STEP 9: The user has clicked on a car model Golf option in the dropdown list.");
        sleepy(WAIT);

        searchPage.clickOnCarModelOKButton();
        log.info("STEP 10: The user has clicked on the car model OK button in the dropdown list.");
        sleepy(WAIT);

        searchPage.clickOnFourWheelDriveCheckbox();
        log.info("STEP 11: The user has clicked on a four-wheel-drive checkbox(section Others).");
        sleepy(WAIT);

        searchPage.locateVehicleSearchBtn();
        log.info("STEP 12: The user has localised the vehicle Search button.");
        sleepy(WAIT);

        searchPage.clickOnSearchButton();
        log.info("STEP 13: The user has clicked on the vehicle Search button.");
        sleepy(WAIT);

        searchPage.showTotalNumberOfVWGolfAds();
        sleepy(WAIT);
    }
}
