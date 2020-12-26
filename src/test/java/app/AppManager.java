package app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppManager {

    protected WebDriver wd;
    private BrowserHelper browserHelper;
    private GoogleHelper googleHelper;
    private YNetNewsHelper yNetNewsHelper;

    public void init(){
        initWebDriver();
        browserHelper = new BrowserHelper(wd);
        googleHelper = new GoogleHelper(wd);
        yNetNewsHelper = new YNetNewsHelper(wd);
    }

    private void initWebDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        // This will make Selenium WebDriver to wait until the initial HTML document has been
        // completely loaded and parsed, and discards loading of stylesheets, images and subframes.
        // When set to eager, Selenium WebDriver waits until DOMContentLoaded event fire is returned.
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        // ThreadGuard checks that a driver is called only from the same thread that created it.
        // Threading issues especially when running tests in Parallel may have mysterious and hard
        // to diagnose errors. Using this wrapper prevents this category of errors and will raise
        // an exception when it happens.
        wd = ThreadGuard.protect(new ChromeDriver(chromeOptions));

        // Once set, the implicit wait is set for the life of the session.
        // Do not mix implicit and explicit waits. Doing so can cause unpredictable wait times.
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void stop(){
        if(wd != null) {
            // it closes the opened chrome
            //wd.quit();
        }
    }

    public BrowserHelper browser(){
        return browserHelper;
    }

    public GoogleHelper google(){
        return googleHelper;
    }

    public YNetNewsHelper ynetnews() { return yNetNewsHelper; }
}
