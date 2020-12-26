package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHelper extends HelperBase{

    private final String googleHomeUrl = "https://www.google.com/";

    public GoogleHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGoogleHome() {
        String curUrl = wd.getCurrentUrl();
        if (googleHomeUrl.equals(curUrl)) {
            return;
        }
        wd.navigate().to(googleHomeUrl);
    }

    public void search(String searchStr) {
        type(By.name("q"), searchStr);
        click(By.name("btnK"));
    }

    public void enterSite(String url){
            click(By.cssSelector("div.yuRUbf>a[href*='" + url + "']"));
    }
}
