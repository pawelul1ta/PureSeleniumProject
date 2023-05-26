package org.example.amazon;

import base_test.AbstractTest;
import org.example.util.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3Tests extends AbstractTest {

    @Test
    public void creatingAccountWithoutProperData() {

        AmazonHomePage homePage = openTheHomePage();

        CreateAccountPage createAccountPage = homePage.clickOnNewCustomerLink();
        createAccountPage = createAccountPage.clickContinue();

        Assert.assertTrue(createAccountPage.checkIfNameInputHasErrors());
    }

    @Test
    public void addingToTheCartTest() {

        AmazonHomePage homePage = openTheHomePage();

        homePage.typeSearchCriteria("guitar");

        int numberOfCartItems = homePage.getSearchResults()
                .clickOnFirstFoundItem()
                .addProductToTheCart()
                .numberOfCartItems();

        Assert.assertEquals(numberOfCartItems, 1);
    }

    @Test
    public void proceedToCheckoutWithoutSigningIn() {

        AmazonHomePage homePage = openTheHomePage();
        homePage.typeSearchCriteria("guitar");
        SearchResultsPage resultsPage = homePage.getSearchResults();
        ProductPage productPage = resultsPage.clickOnFirstFoundItem();
        AddingToCartSummary addingToCartSummary = productPage.addProductToTheCart();
        ShoppingCartPage shoppingCart = addingToCartSummary.goToTheCart();
        SignInPage signInPage = shoppingCart.proceedToCheckout();

        Assert.assertTrue(signInPage.isSignInFormPresent());
    }

    @Test
    public void removingFromTheCartTest() {

        AmazonHomePage homePage = openTheHomePage();
        homePage.typeSearchCriteria("guitar");
        SearchResultsPage resultsPage = homePage.getSearchResults();
        ProductPage productPage = resultsPage.clickOnFirstFoundItem();
        AddingToCartSummary addingToCartSummary = productPage.addProductToTheCart();
        ShoppingCartPage shoppingCart = addingToCartSummary.goToTheCart();
        shoppingCart.deleteItemFromCart();

        Assert.assertEquals(shoppingCart.numberOfCartItems(), 0);
    }

    @Test
    public void contactInformationTest() {
        AmazonHomePage homePage = openTheHomePage();
        homePage.scrollDownThePage();
        HelpPage helpPage = homePage.clickHelpButton();
        LoginAndPasswordIssuePage loginAndPasswordIssuePage = helpPage.clickOnLoginAndPasswordIssueCard();
        loginAndPasswordIssuePage.clickOnSelectMenuAndChooseIdontHaveAccountOpt();

        Assert.assertTrue(loginAndPasswordIssuePage.isContactNumberProvided());
    }

    private AmazonHomePage openTheHomePage() {
        String url = PropertiesUtil.get("baseUrl");
        WebDriver driver = driverThreadLocal.get();
        driver.get(url);
        return new AmazonHomePage(driver);
    }
}
