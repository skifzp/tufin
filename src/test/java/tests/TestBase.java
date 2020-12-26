package tests;

import app.AppManager;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class TestBase {
    public static AppManager app;

    @BeforeTest
    public void startUp(ITestContext context){
        app = new AppManager();
        app.init();
        context.setAttribute("app",app);
    }

    @AfterTest
    public void tearDown() {
        app.stop();
    }

}