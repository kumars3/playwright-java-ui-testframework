package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class MyBasketPage extends BasePage {
private Page page;
private final Locator removeButtons;
private final Locator emptyBasketMessage;
private final Locator checkoutButton;
private final Locator continueShoppingButton;
private final Locator totalAmount;
    public MyBasketPage(Page page)
    {
        super(page);
        this.page = page;
        removeButtons = page.locator("//*[@id='cart']//tbody/tr/td[7]/a");
        emptyBasketMessage =  page.locator("//div[@class='contentpanel']");
        checkoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Checkout"));
        continueShoppingButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue Shopping"));
        totalAmount = page.locator("//*[@id='totals_table']/tbody/tr[3]/td[2]/span");

    }

    public void emptyBasket()
    {
        int count = removeButtons.count();
        for(int i=0;i< count;i++)
        {
            //int ival = i;
            removeButtons.first().click();
        }
    }

    public String getEmptyBasketMessage()
    {
       // String actualText = emptyBasketMessage.innerText().split("\n")[0];
        String actualText = getInnerText(emptyBasketMessage).split("\n")[0];
        return actualText;
        }

    public boolean isTotalAmountDisplayed()
    {
        if (totalAmount.count() !=0)
        return true;
        else
            return false;
    }
    public void checkoutMyBasket()
    {
        clickFirstElement(checkoutButton);
    }

}