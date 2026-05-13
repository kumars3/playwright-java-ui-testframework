package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage  {
private final Page page;
//Locators
private final Locator loginLink;
private final Locator specialMenuLink;
private final Locator cartLink;
private Locator GbpCurrencyOption;

        public HomePage(Page page)
        {
            super(page);
            this.loginLink = page.getByText("Login or register");
            this.specialMenuLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Specials"));
            this.cartLink = page.getByText("Cart").first();
            GbpCurrencyOption  = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("£ Pound Sterling"));
            this.page = page;

        }

        //Actions
        public void navigateToLoginPage()
        {clickElement(loginLink);}
        public void navigateToSaleProducts()
       {
        //specialMenuLink.click();
        clickElement(specialMenuLink);
       }
       public void viewMyBasket()
       {
           //cartLink.click();
           clickElement(cartLink);
       }

    public void SelectGbpOption()
    {
        //GbpCurrencyOption.click();
        clickElement(GbpCurrencyOption);
    }
}
