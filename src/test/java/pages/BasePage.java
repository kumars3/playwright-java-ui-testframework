package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

import java.nio.file.Paths;

public class BasePage {

    private final Page page;
    private Locator WelcomeMessage;


    public BasePage(Page page)
    {
        this.page = page;
        WelcomeMessage = page.getByText("Welcome back");

    }
    public void navigateToHomePage(String url)
    {
        page.navigate(url);
    }

    public String getWelcomeMessage()
    {
        return WelcomeMessage.textContent();
    }

    //Generic actions
    public void clickElement(Locator element)
    {
        element.click();
    }
    public void clickFirstElement (Locator element)
    {
        element.first().click();
    }

    public void fillInputBox(Locator inputBox, String value)
    {
        inputBox.fill(value);
    }
    public String getElementText(Locator element)
    {
        return element.textContent();
    }
    public void selectDropdownOption(Locator dropdown, String option)
    {
        dropdown.selectOption(option);
    }

    public boolean isElementVisible(Locator element)
    {
        return element.isVisible();
    }

     public boolean isElementEnabled(Locator element)
    {
        return element.isEnabled();
    }

     public boolean isElementChecked(Locator element)
    {
        return element.isChecked();
    }

     public void clickButtonByName(String buttonName)
    {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonName)).click();
    }

    public void clickLinkByName(String linkName)
    {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkName)).click();
    }

    public void clickElementByText(String text)
    {
        page.getByText(text).click();
    }

    public String getTextByLocator(Locator element)
    {
        return element.textContent();
    }

     public String getTextByRole(AriaRole role, String name)
    {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(name)).textContent();
    }

    //capture screenshot
    public void captureScreenshot(String filePath)
    {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath)));
    }
  //Scroll to view
    public void scrollToElement(Locator element)
    {
        element.scrollIntoViewIfNeeded();
    }

     public void hoverOverElement(Locator element)
    {
        element.hover();
    }

     public void doubleClickElement(Locator element)
    {
        element.dblclick();
    }

     public void rightClickElement(Locator element)
    {
        element.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    public void dragAndDrop(Locator source, Locator target)
    {
        source.dragTo(target);
    }
    public void waitForElement(Locator element, int timeout)
    {
        element.waitFor(new Locator.WaitForOptions().setTimeout(timeout));
    }

    public String getPageTitle()
    {
        return page.title();
    }

     public String getCurrentUrl()
    {
        return page.url();
    }

    public void refreshPage()
    {
        page.reload();
    }

     public void navigateBack()
    {
        page.goBack();
    }

     public void navigateForward()
    {
        page.goForward();
    }

    public void acceptAlert()
    {
        page.onDialog(dialog -> dialog.accept());
    }

     public void dismissAlert()
    {
        page.onDialog(dialog -> dialog.dismiss());
    }

     public String getAlertText()
    {
        final String[] alertText = new String[1];
        page.onDialog(dialog -> alertText[0] = dialog.message());
        return alertText[0];
    }

    public String getInnerText(Locator element)
    {
        return element.innerText();
    }

     public String getValue(Locator element)
    {
        return element.inputValue();
    }

     public boolean isElementPresent(Locator element)
    {
        return element.count() > 0;
    }

}
