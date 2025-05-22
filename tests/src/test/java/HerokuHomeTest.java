import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class HerokuHomeTest {
    private RemoteWebDriver driver;
    private HerokuHomePage home;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        // Initialize RemoteWebDriver (e.g. Selenium Grid)
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
        home = new HerokuHomePage(driver);
        wait = new WebDriverWait(driver, 10);
    }

     @Test
    public void testHomePageHeading_WithExplicitWait() {
        // 1. Navigate to the Internet demo site
        driver.get("http://the-internet.herokuapp.com/");

        // 2. Use explicit wait to pause until the <h1> is visible
        By headingLocator = By.tagName("h1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));

        // 3. Now that it's visible, retrieve its text
        String actualHeading = driver.findElement(headingLocator).getText();

        // 4. Assert it matches the expected value
        String expectedHeading = "Welcome to the-internet";
        assertEquals(
            "The <h1> text should match after waiting for it to appear",
            expectedHeading,
            actualHeading
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}