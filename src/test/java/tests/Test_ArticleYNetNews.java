package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test_ArticleYNetNews extends TestBase{

    private final String urlYNetNews = "www.ynetnews.com";

    @BeforeMethod
    public void ensurePreconditions() {
        app.browser().resolution(1920,1080);
        app.browser().goTo("https://www.ynetnews.com/health_science/article/rJG3N00epv");
    }

    @Test
    public void testArticleSendToFriend() throws InterruptedException {
        assertThat(app.ynetnews().isPresentSendToFriends(), equalTo(true));
        app.ynetnews().sendToFriend();
    }
}
