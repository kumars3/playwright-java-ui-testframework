package stepdefinitions;

//import com.aventstack.extentreports.model.Test;
import context.TestContext;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import utils.ConfigReader;

public class CustomerE2ECheckoutJourneySteps {
    private final TestContext context;
    private final PageObjectManager pages;

    public CustomerE2ECheckoutJourneySteps(TestContext context) {
        this.context = context;
        this.pages = new PageObjectManager(context.page);
    }
    @Given("I am on home page")
    public void iAmOnHomePage() {
        String BaseUrl = ConfigReader.getFromPropertiesVariables("app.url");
        context.page.navigate(BaseUrl);
    }

    @When("I navigate to account login page")
    public void iNavigateToAccountLoginPage() {
        pages.getHomePage().navigateToLoginPage();
    }

    @And("I continue to register a new customer")
    public void iContinueToRegisterANewCustomer() {
        System.out.println("Navigating to account login page");
    }

    @And("I create a customer <CustomerType> account with details <FirstName>,<LastName>,<TelephoneNo>,<AddressLine{int}>,<City>,<Region>,<ZipCode>,<Country>,<SubscribeNewsLetterFlag>")
    public void iCreateACustomerCustomerTypeAccountWithDetailsFirstNameLastNameTelephoneNoAddressLineCityRegionZipCodeCountrySubscribeNewsLetterFlag(int arg0) {
          System.out.println("Navigating to account login page");
    }

    @Then("the new customer account is created successfully")
    public void theNewCustomerAccountIsCreatedSuccessfully() {
        System.out.println("Navigating to account login page");
    }

    @When("I navigate to home page")
    public void iNavigateToHomePage() {
        System.out.println("Navigating to account login page");
    }

    @When("I add {string} product into the basket")
    public void iAddProductBrandProductIntoTheBasket(String productBrand) {
        System.out.println(productBrand);
    }

    @When("I search a product {string} from product category menu")
    public void iSearchAProductProductCategoryFromProductCategoryMenu(String productCategory) {
        System.out.println(productCategory);
    }

    @And("I sort product list based on <SortingIndex>")
    public void iSortProductListBasedOnSortingIndex() {
        System.out.println("Navigating to account login page");
    }

    @And("I add a product into basket from the search list")
    public void iAddAProductIntoBasketFromTheSearchList() {
        System.out.println("Navigating to account login page");
    }

    @And("I checkout from my basket")
    public void iCheckoutFromMyBasket() {
        pages.getHomePage().viewMyBasket();
        pages.getMyBasketPage().checkoutMyBasket();
    }

    @And("I confirm my order")
    public void iConfirmMyOrder() {
        String headerText = pages.getCheckOutConfirmationPage().getHeaderText().trim();
        assert (headerText.equalsIgnoreCase("Checkout Confirmation"));
        pages.getCheckOutConfirmationPage().clickConfirmOrderButton();

    }

    @Then("My order is created successfully")
    public void myOrderIsCreatedSuccessfully() {
        String headerSuccessMessage = pages.getOrderConfirmationPage().getHeaderSuccessMessage().trim();
        String orderSuccessMessage = pages.getOrderConfirmationPage().getOrderSuccessMessage().trim();
        assert (headerSuccessMessage.equalsIgnoreCase("Your Order Has Been Processed!"));
        assert (orderSuccessMessage.contains("Your order #"));
    }

    @When("I navigate to my order history page")
    public void iNavigateToMyOrderHistoryPage() {
        System.out.println("Navigating to account login page");
    }

    @Then("My order is listed in order history page")
    public void myOrderIsListedInOrderHistoryPage() {
        System.out.println("Navigating to account login page");
    }

    @When("I navigate to my order details page")
    public void iNavigateToMyOrderDetailsPage() {
        System.out.println("Navigating to account login page");
    }

    @Then("The order is displayed in my order detail page")
    public void theOrderIsDisplayedInMyOrderDetailPage() {
        System.out.println("Navigating to account login page");
    }

    @And("I log into my account")
    public void iLogIntoMyAccountHavingEmailId() {
       pages.getAccountLoginPage().Login(ConfigReader.getFromEnvVariables("APP_USERNAME"), "" + ConfigReader.getFromEnvVariables("APP_PASSWORD"));
    }

    @And("I add sale product into basket")
    public void iAddSaleProductIntoBasket() {
        pages.getHomePage().navigateToSaleProducts();
        pages.getProductListPage().AddProductIntoBasketFromProductList();
    }

    @Then("login is successful and I am navigated to my account page")
    public void loginIsSuccessfulAndIAmNavigatedToMyAccountPage() {
        String welcomeMessage = pages.getMyAccountPage().getWelcomeMessage();
        assert (welcomeMessage.contains("Welcome back"));
    }

    @Then("basket is emptied successfully")
    public void basketIsEmptiedSuccessfully() {
        String actualText = pages.getMyBasketPage().getEmptyBasketMessage().trim();
        assert (actualText.equals("Your shopping cart is empty!"));
        assert (pages.getMyBasketPage().isTotalAmountDisplayed() == false);
    }

    @And("I empty my basket")
    public void iEmptyMyBasket() {
        pages.getHomePage().viewMyBasket();
        pages.getMyBasketPage().emptyBasket();
    }

    @And("I select GBP currency option")
    public void iSelectGBPCurrencyOption() {
        pages.getHomePage().SelectGbpOption();
    }
}