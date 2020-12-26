package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class YNetNewsHelper extends HelperBase{

    private final String ynetnewsHomeUrl = "https://www.ynetnews.com/category/3083";
    private final String ynetnewsWeather = "https://www.ynetnews.com/weather";

    public YNetNewsHelper(WebDriver wd) {
        super(wd);
    }

    public void goToHome() {
        String curUrl = wd.getCurrentUrl();
        if (ynetnewsHomeUrl.equals(curUrl)) {
            return;
        }
        wd.navigate().to(ynetnewsHomeUrl);
    }

    public void goToWeather() {
        String curUrl = wd.getCurrentUrl();
        if (ynetnewsWeather.equals(curUrl)) {
            return;
        }
        wd.navigate().to(ynetnewsWeather);
    }

    public void weatherIn(String city) {
        //new Select(wd.findElement(By.id("weathercityselect"))).selectByVisibleText(city);
        click(By.cssSelector("div.arrow-down"));
        click(By.cssSelector("div[aria-valuenow='"+ city +"']"));
    }

    public boolean isPresentSendToFriends() {
        return isElementPresent(By.cssSelector("button[title='send to friend']"));
    }

    public void sendToFriend() {
        click(By.cssSelector("button[title='send to friend']"));
    }
}
