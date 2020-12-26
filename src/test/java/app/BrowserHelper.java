package app;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserHelper extends HelperBase{

    private final String googleHomeUrl = "https://www.google.com/";

    public BrowserHelper(WebDriver wd) {
        super(wd);
    }

    public String whatSiteIsOpened() {
        String sUrl = wd.getCurrentUrl();
        URL url = null;
        try {
            url = new URL(sUrl);
            return url.getHost();
        } catch (MalformedURLException e) {
            return "";
        }

    }

    public void goTo(String urlYNetNews) {
        wd.navigate().to(urlYNetNews);
    }

    public void resolution(int width, int height) {
        wd.manage().window().setSize(new Dimension(width,height));
    }
}