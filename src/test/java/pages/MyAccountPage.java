package pages;

import com.microsoft.playwright.Page;

public class MyAccountPage extends BasePage{
private final Page page;
    public MyAccountPage(Page page)
    {
        super(page );
        this.page = page;

    }
    @Override
    public String getWelcomeMessage() {
        return super.getWelcomeMessage();
    }
}
