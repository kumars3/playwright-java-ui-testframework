package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


public class OrderConfirmationPage extends BasePage {
    private final Page page;
    private Locator headerSuccessMessage;
    private Locator orderCreatedMessage;
     public OrderConfirmationPage(Page page)
     {
         super(page);
         this.page = page;
         headerSuccessMessage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Your Order Has Been Processed!"));
         orderCreatedMessage = page.locator("//p[contains(text(),'Your order #')]");
     }

     public String getHeaderSuccessMessage()
     {
         //String actualText = headerSuccessMessage.innerText().split("\n")[0];
         String actualText = getInnerText(headerSuccessMessage).split("\n")[0];
         return actualText;
     }

     public String getOrderSuccessMessage()
     {
         //String actualText = orderCreatedMessage.innerText().split("\n")[0];
         String actualText = getInnerText(orderCreatedMessage).split("\n")[0];
         return actualText;
     }
}
