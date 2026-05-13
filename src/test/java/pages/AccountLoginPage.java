package pages;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
//import com.microsoft.playwright.Page;

public class AccountLoginPage extends BasePage {
    private Page page;
    private final Locator LoginNameInputBox;
    private final Locator PasswordInputBox;
    private final Locator LoginButton;

    public AccountLoginPage(Page page) {
        super(page);
        this.page = page;
        //Locators
        LoginNameInputBox = page.locator("#loginFrm_loginname");
        PasswordInputBox = page.locator("#loginFrm_password");
        LoginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    }
        //Actions
        public void Login(String emailId,String password)
        {
            String userName = emailId.split("@")[0].trim();
            //LoginNameInputBox.fill(userName);
            fillInputBox(LoginNameInputBox,userName);
            fillInputBox(PasswordInputBox,password);
            //LoginButton.click();
            clickElement(LoginButton);
        }
    }