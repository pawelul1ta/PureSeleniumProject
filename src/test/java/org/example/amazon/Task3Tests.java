package org.example.amazon;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.amazon.base.*;
import org.example.amazon.web.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3Tests implements IAbstractTest {

    @Test
    public void creatingAccountWithoutProperData() {

        AmazonHomePageBase homePage = initPage(getDriver(), AmazonHomePageBase.class);
        homePage.open();

        CreateAccountPageBase createAccountPage = homePage.clickOnNewCustomerLink();
        createAccountPage = createAccountPage.clickContinue();

        Assert.assertTrue(createAccountPage.checkIfNameInputHasErrors());
    }

    @Test
    public void addingToTheCartTest() {

        AmazonHomePageBase homePage = initPage(getDriver(), AmazonHomePageBase.class);
        homePage.open();

        homePage.typeSearchCriteria("guitar");

        int numberOfCartItems = homePage.getSearchResults().clickOnFirstFoundItem().addProductToTheCart().numberOfCartItems();

        Assert.assertEquals(numberOfCartItems, 1);
    }

    @Test
    public void proceedToCheckoutWithoutSigningIn() {

        AmazonHomePageBase homePage = initPage(getDriver(), AmazonHomePageBase.class);
        homePage.open();

        homePage.typeSearchCriteria("guitar");
        SearchResultsPageBase resultsPage = homePage.getSearchResults();
        ProductPageBase productPage = resultsPage.clickOnFirstFoundItem();
        AddingToCartSummaryBase addingToCartSummary = productPage.addProductToTheCart();
        ShoppingCartPageBase shoppingCart = addingToCartSummary.goToTheCart();
        SignInPageBase signInPage = shoppingCart.proceedToCheckout();

        Assert.assertTrue(signInPage.isSignInFormPresent());
    }

    @Test
    public void removingFromTheCartTest() {

        AmazonHomePageBase homePage = initPage(getDriver(), AmazonHomePageBase.class);
        homePage.open();

        homePage.typeSearchCriteria("dog");
        SearchResultsPageBase resultsPage = homePage.getSearchResults();
        ProductPageBase productPage = resultsPage.clickOnFirstFoundItem();
        AddingToCartSummaryBase addingToCartSummary = productPage.addProductToTheCart();
        ShoppingCartPageBase shoppingCart = addingToCartSummary.goToTheCart();
        shoppingCart.deleteItemFromCart();

        Assert.assertEquals(shoppingCart.numberOfCartItems(), 0);
    }

    @Test
    public void contactInformationTest() {

        AmazonHomePageBase homePage = initPage(getDriver(), AmazonHomePageBase.class);
        homePage.open();

        HelpPageBase helpPage = homePage.clickHelpButton();
        LoginAndPasswordIssuePageBase loginAndPasswordIssuePage = helpPage.clickOnLoginAndPasswordIssueCard();
        loginAndPasswordIssuePage.clickOnSelectMenuAndChooseIdontHaveAccountOpt();

        Assert.assertTrue(loginAndPasswordIssuePage.isContactNumberProvided());
    }

}
