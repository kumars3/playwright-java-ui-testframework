package hooks;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser.NewContextOptions;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.PageObjectManager;
import pages.BasePage;
import utils.ConfigReader;
import utils.FileUtils;

import java.awt.*;
import java.nio.file.Paths;
import java.util.Arrays;

import static utils.ConfigReader.getFromPropertiesVariables;

public class Hooks{

    private final TestContext testContext;
    private static final String SCREENSHOT_DIR = "target/artificats/screenshots/";
    private static final String TRACE_DIR = "target/artificats/traces/";
    private static final String VIDEO_DIR = "target/artificats/videos/";

    boolean headless = Boolean.parseBoolean(getFromPropertiesVariables("headless"));
    boolean traceEnabled = Boolean.parseBoolean(getFromPropertiesVariables("trace.enabled"));
    boolean videoEnabled = Boolean.parseBoolean(getFromPropertiesVariables("video.enabled"));
    boolean screenshotEnabled = Boolean.parseBoolean(getFromPropertiesVariables("screenshot.enabled"));

public Hooks(TestContext testContext) {
    this.testContext = testContext;
}
    @Before
    public void Setup(Scenario scenario)
    {
        System.out.println(
                "Thread ID: " +
                        Thread.currentThread().getId()
        );

        FileUtils.ensureDirectory(SCREENSHOT_DIR);
        FileUtils.ensureDirectory(TRACE_DIR);
        FileUtils.ensureDirectory(VIDEO_DIR);

        testContext.scenarioName = FileUtils.santitizeFileName(scenario.getName());

        String browserTag = scenario.getSourceTagNames().stream().findFirst().orElse("").replace("@", "");
        BrowserType browserType = null;
        testContext.playwright = Playwright.create();

        // Get your actual screen size to maximise browser window on launch
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        switch (browserTag.toLowerCase()) {
            case "chrome","edge","chromium":
                browserType = testContext.playwright.chromium();
                break;
            case "firefox":
                browserType = testContext.playwright.firefox();
                break;
            case "webkit":
                browserType = testContext.playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserTag);
        }
        // 1. Launch with the '--start-maximized' argument and in headed mode
        testContext.browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless).setArgs(Arrays.asList("--start-maximised")));
//video recording starts here
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        if(videoEnabled) {
            contextOptions.setRecordVideoDir(Paths.get(VIDEO_DIR, scenario.getName().replaceAll(" ", "_")));
            contextOptions.setRecordVideoSize(width, height);
            contextOptions.setViewportSize(width, height);
        }
        testContext.browserContext = testContext.browser.newContext(contextOptions.setViewportSize(width,height));
        //tracing starts
        if(traceEnabled) {
            testContext.browserContext.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }
        testContext.page = testContext.browserContext.newPage();
        testContext.pageObjectManager = new PageObjectManager(testContext.page);

        if(screenshotEnabled)
        {
         //captureScreenshot(SCREENSHOT_DIR + testContext.scenarioName + "_" + System.nanoTime()+ ".png");
         testContext.page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(SCREENSHOT_DIR, testContext.scenarioName + "_" + System.nanoTime() + ".png")).setFullPage(true));
        }

    }
    @After
    public void TearDown(Scenario scenario)
    {
        if(traceEnabled) {
            testContext.browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(TRACE_DIR, scenario.getName().replaceAll(" ", "_") + ".zip")));
        }
        testContext.browser.close();
        testContext.browserContext.close();
        testContext.page.close();
        testContext.playwright.close();
    }
}
