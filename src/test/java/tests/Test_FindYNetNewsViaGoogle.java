package tests;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test_FindYNetNewsViaGoogle extends TestBase{

    private final String urlYNetNews = "www.ynetnews.com";

    @Test
    public void testGoToYNNHomeUrl(){
        app.google().goToGoogleHome();
        app.google().search(urlYNetNews);
        app.google().enterSite(urlYNetNews);
        assertThat(app.browser().whatSiteIsOpened(), equalTo(urlYNetNews));
    }
}
