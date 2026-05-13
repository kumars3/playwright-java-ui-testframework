package managers;

import com.microsoft.playwright.*;
import pages.*;

public class PageObjectManager {
    private final Page page;

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private AccountLoginPage accountLoginPage;
    private ProductListPage productListPage;
    private MyBasketPage myBasketPage;
    private CheckOutConfirmationPage checkOutConfirmationPage;
    private OrderConfirmationPage orderConfirmationPage;
    private BasePage  basePage;


    public PageObjectManager(Page page) {
        this.page = page;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(page);
        }
        return homePage;
    }
    public MyAccountPage getMyAccountPage() {
        if (myAccountPage == null) {
            myAccountPage = new MyAccountPage(page);
        }
        return myAccountPage;
    }

    public AccountLoginPage getAccountLoginPage() {
        if (accountLoginPage == null) {
            accountLoginPage = new AccountLoginPage(page);
        }
        return accountLoginPage;
    }

    public  ProductListPage getProductListPage() {
        if (productListPage == null) {
            productListPage = new ProductListPage(page);
        }
        return productListPage;
    }

    public MyBasketPage getMyBasketPage() {
        if (myBasketPage == null) {
            myBasketPage = new MyBasketPage(page);
        }
        return myBasketPage;
    }

    public CheckOutConfirmationPage getCheckOutConfirmationPage() {
        if (checkOutConfirmationPage == null) {
            checkOutConfirmationPage = new CheckOutConfirmationPage(page);
        }
        return checkOutConfirmationPage;
    }

    public OrderConfirmationPage getOrderConfirmationPage() {
        if (orderConfirmationPage == null) {
            orderConfirmationPage = new OrderConfirmationPage(page);
        }
        return orderConfirmationPage;
    }

    public BasePage getBasePage() {
            if (basePage == null) {
                basePage = new BasePage(page);
            }
            return basePage;
        }
}
