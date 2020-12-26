package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Test_WeatherViaYNetNews extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.ynetnews().goToHome();
    }

    @Test
    public void testWeatherInCity() throws InterruptedException {
        app.ynetnews().goToWeather();
        sleep(2000);
        String city = "Elat";
        app.ynetnews().weatherIn(city);
    }
}
