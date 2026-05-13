package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

public class ProductListPage {
private final Page page;
private final Locator availableProductCartButtons;

public ProductListPage(Page page){
        this.page = page;
        page.waitForLoadState(LoadState.NETWORKIDLE);
       availableProductCartButtons = page.locator("//a[@title='Add to Cart']");
     }
    public void AddProductIntoBasketFromProductList()
    {
        availableProductCartButtons.first().waitFor();
        int count = availableProductCartButtons.count();
        for(int i=0;i<Math.min(2,count);i++)
        {
            availableProductCartButtons.nth(i).click();
        }
    }
}
