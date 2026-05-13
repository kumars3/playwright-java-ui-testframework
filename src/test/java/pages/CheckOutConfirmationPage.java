package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class CheckOutConfirmationPage extends BasePage {
    private final Page page;
    private Locator header;
    private Locator confirmOrderButton;
    public CheckOutConfirmationPage(Page page)
    {
        super(page);
        this.page=page;
        header = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Checkout Confirmation"));
        confirmOrderButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm Order"));
    }

    public String getHeaderText()
    {
        //String actualText = header.innerText().split("\n")[0];
        String actualText = getInnerText(header).split("\n")[0];
        return actualText;
    }

    public void clickConfirmOrderButton()
    {
//        confirmOrderButton.click();
        clickElement(confirmOrderButton);
    }
}
