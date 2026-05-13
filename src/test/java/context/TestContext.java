package context;
import com.microsoft.playwright.*;
import managers.PageObjectManager;

import java.nio.file.Path;


public class TestContext {
    public Playwright playwright;
    public Browser browser;
    public BrowserContext browserContext;
    public Page page;
    public PageObjectManager pageObjectManager;

    public Path screenshotPath;
    public Path tracepath;
    public Path videoPath;
    public String scenarioName;
    public String browserName;


}
