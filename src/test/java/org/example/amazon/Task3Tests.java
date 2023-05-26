package org.example.amazon;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3Tests implements IAbstractTest {

    @Test
    public void creatingAccountWithoutProperData() {

        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

        CreateAccountPage createAccountPage = homePage.clickOnNewCustomerLink();
        createAccountPage = createAccountPage.clickContinue();

        Assert.assertTrue(createAccountPage.checkIfNameInputHasErrors());
    }

    @Test
    public void addingToTheCartTest() {

        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

        homePage.typeSearchCriteria("guitar");

        int numberOfCartItems = homePage.getSearchResults()
                .clickOnFirstFoundItem()
                .addProductToTheCart()
                .numberOfCartItems();

        Assert.assertEquals(numberOfCartItems, 1);
    }

    @Test
    public void proceedToCheckoutWithoutSigningIn() {

        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

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

        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

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

        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

        homePage.scrollDownTheHomePage();
        HelpPage helpPage = homePage.clickHelpButton();
        LoginAndPasswordIssuePage loginAndPasswordIssuePage = helpPage.clickOnLoginAndPasswordIssueCard();
        loginAndPasswordIssuePage.clickOnSelectMenuAndChooseIdontHaveAccountOpt();

        Assert.assertTrue(loginAndPasswordIssuePage.isContactNumberProvided());
    }

}
